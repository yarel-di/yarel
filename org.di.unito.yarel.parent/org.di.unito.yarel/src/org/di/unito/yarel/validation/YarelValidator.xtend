/**
  * Yarel
 * Copyright (C) 2018  Claudio Grandi, Dariush Moshiri, Luca Roversi
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.di.unito.yarel.validation

import com.google.inject.Inject
import java.util.Arrays
import java.util.List
import java.util.Set
import java.util.Map
import java.util.HashMap
import java.util.HashSet
import java.util.TreeMap
import java.util.function.Supplier
import java.util.function.Function
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import org.di.unito.yarel.scoping.YarelIndex
import org.di.unito.yarel.utils.ComposedArity
import org.di.unito.yarel.utils.Utils
import org.di.unito.yarel.utils.YarelUtils
import org.di.unito.yarel.yarel.YarelPackage
import org.di.unito.yarel.yarel.Import
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.ParamName
import org.di.unito.yarel.yarel.AritiesAssignment
import org.di.unito.yarel.yarel.FunctionInvocation
import org.di.unito.yarel.yarel.SerComp
import org.di.unito.yarel.yarel.ParameterLEWP
import org.di.unito.yarel.yarel.ParametersAssignment
import org.di.unito.yarel.yarel.ParametricArity
import org.di.unito.yarel.yarel.BodyIf
import org.di.unito.yarel.yarel.BodyPerm
import org.di.unito.yarel.yarel.BodyParamFor
import org.di.unito.yarel.yarel.BodyParamIt
import org.di.unito.yarel.yarel.BodyParamPerm
import org.di.unito.yarel.yarel.BodyParamId
import org.di.unito.yarel.yarel.Body
import org.di.unito.yarel.yarel.BodyParamInc
import org.di.unito.yarel.yarel.BodyParamNeg
import org.di.unito.yarel.yarel.BodyParamDec
import org.di.unito.yarel.yarel.SwapIndexed
import org.di.unito.yarel.yarel.ParamConstrPositive
import org.di.unito.yarel.yarel.ParamConstrNatural
import org.di.unito.yarel.yarel.ParamConstrDistinct
import org.di.unito.yarel.yarel.ParamConstrBound

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

/**
 * This class contains the rules that are necessary to every Reval program in order to work.  
 */
class YarelValidator extends AbstractYarelValidator {
//	@Inject extension YarelIndex
	@Inject extension YarelUtils

	//Error ids
	public static val BASE_ERROR_NAME = 'org.di.unito.yarel_'
	public static val WARNING_BAD_MODULE_NAME = BASE_ERROR_NAME + 'WARNING_BAD_MODULE_NAME'
	public static val ERROR_RECURSION = BASE_ERROR_NAME + 'ERROR_RECURSION'
	public static val ERROR_FORBIDDEN_KEYWORD = BASE_ERROR_NAME + 'ERROR_FORBIDDEN_KEYWORD'
	public static val ERROR_SERIAL_COMPOSITION = BASE_ERROR_NAME + 'ERROR_SERIAL_COMPOSITION'
	public static val ERROR_IF_FUNCTIONS_ARITY = BASE_ERROR_NAME + 'ERROR_IF_FUNCTIONS_ARITY'
	public static val ERROR_PERMUTATION_BOUND = BASE_ERROR_NAME + 'ERROR_PERMUTATION_BOUND'
	public static val ERROR_PERMUTATION_INDICES = BASE_ERROR_NAME + 'ERROR_PERMUTATION_INDICES'
	public static val ERROR_ITERATION_FUNCTIONS_ARITY = BASE_ERROR_NAME + 'ERROR_ITERATION_FUNCTIONS_ARITY'
	public static val ERROR_ARITY = BASE_ERROR_NAME + 'ERROR_ARITY'
	public static val ERROR_IMPORT = BASE_ERROR_NAME + 'ERROR_IMPORT'
	public static val ERROR_PARAM_UNDEFINED = BASE_ERROR_NAME + 'ERROR_PARAM_UNDEFINED'
	public static val ERROR_DUPLICATE_MODULE = BASE_ERROR_NAME + 'ERROR_DUPLICATE_MODULE'
	public static val ERROR_FUNCTION_NOT_FOUND = BASE_ERROR_NAME + 'ERROR_FUNCTION_NOT_FOUND'
	public static val ERROR_INVALID_DEFINITION_COUNT = BASE_ERROR_NAME + 'ERROR_INVALID_DEFINITION_COUNT'
	public static val ERROR_SERIAL_COMPOSITION_ARITY = BASE_ERROR_NAME + 'ERROR_SERIAL_COMPOSITION_ARITY'
	public static val ERROR_NON_POSITIVE_ARITY_SCALAR = BASE_ERROR_NAME + 'ERROR_NON_POSITIVE_ARITY_SCALAR'
	public static val ERROR_PARAMETRIC_OPERATOR_ARITY = BASE_ERROR_NAME + 'ERROR_PARAMETRIC_OPERATOR_ARITY'
	public static val ERROR_PARAMS_ON_NON_PARAM_FUNCTION = BASE_ERROR_NAME + 'ERROR_PARAMS_ON_NON_PARAM_FUNCTION'
	public static val ERROR_UNDEFINED_PARAM_IN_CONSTRAINT = BASE_ERROR_NAME + 'ERROR_UNDEFINED_PARAM_IN_CONSTRAINT'
	public static val ERROR_PARAM_BOTH_IN_ARITY_INVOCATION = BASE_ERROR_NAME + 'ERROR_PARAM_BOTH_IN_ARITY_INVOCATION';
	public static val ERROR_DUPLICATE_PARAMETER_DEFINITION = BASE_ERROR_NAME + 'ERROR_DUPLICATE_PARAMETER_DEFINITION'
	public static val ERROR_UNDEFINED_PARAM_IN_ARITY_ASSIGN = BASE_ERROR_NAME + 'ERROR_UNDEFINED_PARAM_IN_ARITY_ASSIGN'
	public static val ERROR_UNDEFINED_PARAM_IN_PARAM_ASSIGN = BASE_ERROR_NAME + 'ERROR_UNDEFINED_PARAM_IN_PARAM_ASSIGN'
	public static val ERROR_FUNCTION_PARAM_OUTSIDE_DEFINITION = BASE_ERROR_NAME + 'ERROR_FUNCTION_PARAM_OUTSIDE_DEFINITION'
	public static val ERROR_PARAMETERS_AMOUNT_ON_FUNCTION_CALL = BASE_ERROR_NAME + 'ERROR_PARAMETERS_AMOUNT_ON_FUNCTION_CALL'
	public static val ERROR_FUNCTION_PARAMS_AND_PROVIDED_UNMATCH = BASE_ERROR_NAME + 'ERROR_FUNCTION_PARAMS_AND_PROVIDED_UNMATCH'
	public static val ERROR_FUNCTION_ARITIES_AND_PROVIDED_UNMATCH = BASE_ERROR_NAME + 'ERROR_FUNCTION_ARITIES_AND_PROVIDED_UNMATCH'
	public static val ERROR_DUPLICATE_PARAMETER_IN_CONSTRAINT = BASE_ERROR_NAME + 'ERROR_DUPLICATE_PARAMETER_IN_CONSTRAINT'
	
	protected static val Set<String> FORBIDDEN_KEYWORD = {
		val Set<String> s = new HashSet();
		s.addAll("int", "A", "return", "inverse", "class","public","private","protected","final","[","]","(",")","{","}",
		",",".","\"", "RPP","inc","dec","id","for","if","while",";","/","\\", "this", "new", "null", "synchronized", "static",
		"__startIndex__","__endIndex__","__theWholeBody__","__x__","__steps__","__function__","__semaphore__","__threadPoolExecutor__","__neverStarted__",
		"__subtasks__","__repCounterIndex__","__repetitionCounter__","__originalRepCounter__","__startIndexOffset__", "__iterationsAmount__"
		);
		s;
	}
	
	static def boolean isForbidden(String word){
		return FORBIDDEN_KEYWORD.contains(word);
	}
	
	/**
	 * Check if arities of the three functions passed to the IF operator are equal
	 */
	@Check
	def checkSelection(BodyIf selection) {
		val posArity =  YarelUtils.getArity(selection.pos)
		val negArity =  YarelUtils.getArity(selection.neg)
		val zeroArity = YarelUtils.getArity(selection.zero)
		val boolean posEqualsZero = posArity.equals(zeroArity)
		val boolean negEqualsZero = negArity.equals(zeroArity)
		val boolean posEqualsNeg  = posArity.equals(negArity)
		if(! (posEqualsZero && negEqualsZero && posEqualsNeg)){ // the last is redundant ..
			if(posEqualsZero){
				error("Arity of negative function ["+negArity.toString()+"] is not equal to the others: [" + posArity.toString() + "]"
					, YarelPackage::eINSTANCE.bodyIf_Neg, ERROR_IF_FUNCTIONS_ARITY
				)
			} else if(negEqualsZero){
				error("Arity of positive function ["+posArity.toString()+"] is not equal to the others: [" + negArity.toString() + "]"
					, YarelPackage::eINSTANCE.bodyIf_Pos, ERROR_IF_FUNCTIONS_ARITY
				)
			} else if(posEqualsNeg){
				error("Arity of zero-case function ["+zeroArity.toString()+"] is not equal to the others: [" + posArity.toString() + "]"
					, YarelPackage::eINSTANCE.bodyIf_Zero, ERROR_IF_FUNCTIONS_ARITY
				)
			} else {
				error("All functions arities must be equal, but they are all different:<ul>"
						+"<li>pos : [" + posArity.toString() + "]</li>"
						+"<li>zero: [" + zeroArity.toString() + "]</li>"
						+"<li>neg : [" + negArity.toString() + "]</li></ul>"
					, YarelPackage::eINSTANCE.bodyIf_Function, ERROR_IF_FUNCTIONS_ARITY
				)
			}
		}
	}
	
	/**
	 * Check if the number of parameters of each branch of the serial composition are equal
	 */
	@Check
	def checkSerialComposition(Definition deff){
		val deffArity = YarelUtils.getArity(deff.declarationName)
		val allSequentialBlocks = YarelUtils.getAllSequentialBodyBlocks(deff.body)
		
		allSequentialBlocks.forEach[ b, index|
			val bodyArity = YarelUtils.getArity(b)
			if(!deffArity.equals(bodyArity)){
				error("Arity of "+index+"-th serial-composition's block must be equal to the declaration (the \"dcl\" of the function):<br><ul><li>The declared one:[ "
					+ deffArity.toString() + " ]</li> <li> the block's one: [ "+
					bodyArity.toString()+" ] </li></ul>."
					, YarelPackage::eINSTANCE.definition_Body, index,
					ERROR_SERIAL_COMPOSITION_ARITY
				)
			}
		]
	}
	
	@Check
//	def checkSerialComposition(SerComp deff){
//	}
	def checkSerialComposition(SerComp serial) {
		val leftArity = YarelUtils.getArity(serial.left)
		val rightArity = YarelUtils.getArity(serial.right)
//		val allSequentialBlocks = YarelUtils.getAllSequentialBodyBlocks(serial)
		
		if(!leftArity.equals(rightArity))
			error("Arity of left and right branch in serial composition must be equal: LEFT:["
				+ leftArity.toString() + "] , right:["+rightArity.toString()+"]"
				, YarelPackage::eINSTANCE.serComp_Right, ERROR_SERIAL_COMPOSITION_ARITY
			)
	}
	
	/**
	 * Check if the declared arity of the function declaration is equal to the arity of the function definition
	 */
	@Check
	def checkArity(Definition definition) {
		val arityDec = YarelUtils.getArity(definition.declarationName);
		val arityDef = YarelUtils.getArity(definition.body);
		if(!arityDec.equals(arityDef))
			error('''Different arities:\n\tdeclarion=[«arityDec»];\n\tdefinition=[«arityDef»]''', YarelPackage::eINSTANCE.definition_Body, ERROR_ARITY)
	}
	
	/**
	 * Check if each index used inside a permutation is less or equal to the arity of the function
	 */
	@Check
	def checkPermutationBound(BodyPerm permutationBody) {
		val permutation = permutationBody.permutation
		val arity = YarelUtils.getArity(permutationBody)
		val intArityPart = arity.scalar
		val indexes = 1..intArityPart
		val outOfBoundIndexes = permutation.indexes.filter[!indexes.contains(it.value)]
		
		if(outOfBoundIndexes.size > 0)
				error("Index of permutation out of bound, it must be between 1 and " + intArityPart, YarelPackage::eINSTANCE.bodyPerm_Permutation, ERROR_PERMUTATION_BOUND)
	}	
	
	/**
	 * Check if the indices in a permutation are all different
	 */
	@Check
	def checkPermutationIndicesEquality(BodyPerm permutationBody) {
		val permutation = permutationBody.permutation
		val indicesSet = new HashSet<Integer>()
		
		permutation.indexes.forEach[
			if(indicesSet.contains(it.value))
				error("Indices must be all different", YarelPackage::eINSTANCE.bodyPerm_Permutation, ERROR_PERMUTATION_INDICES)
			indicesSet.add(it.value)
		]
	}
	
	//----VALIDATION FOR IMPORTS----//
	/**
	 * Check if the imported module exist
	 * And if the imported function of the imported module exist
	 * Added by: Matteo Palazzo
	 */
	@Check(CheckType::NORMAL)
	def checkImport(Import impt){
		val importedModule = YarelIndex.getVisibleModules(impt).findFirst[mod |mod.name.equals(impt.importedModule)]//should be only one
		if(importedModule === null){//check if the module exist
			error(
				''''«impt.importedModule»' cannot be resolved as a module''', 
				YarelPackage::eINSTANCE.import_ImportedNamespace, 
				ERROR_IMPORT
			)
		}
		else{//Check that the imported function is declared in the imported module
			val importedFunction = impt.importedFunction
			if(importedFunction != '*'){//the wildcard is not used
				if(!YarelIndex.declarations(importedModule).map[name].contains(importedFunction)){//check if the imported module contain the function
					error(
						"'" + importedModule.name + "'" + " does not declare function: " + "'" + importedFunction + "'", 
						YarelPackage::eINSTANCE.import_ImportedNamespace, 
						ERROR_IMPORT)
				}
			}
		}
	}
	 
	/**
	 * Check if there aren't module duplicate
	 * Added by: Matteo Palazzo
	 */
	 @Check(CheckType::NORMAL)
	def checkModuleDuplicate(Model currentModule){
		if(YarelIndex.getVisibleModules(currentModule).exists[mod | mod != currentModule && mod.name == currentModule.name]){
			error(
				'''The module '«currentModule.name»' is already defined''',
				YarelPackage::eINSTANCE.model_Name,
				ERROR_DUPLICATE_MODULE
			)
		}
	}
	
	/**
	 * Check that every declared function has just one definition
	 * also check that every declared function has a definition inside the same module
	 * Added by Matteo Palazzo
	 */
	@Check
	def checkOneDefinition(Declaration decl){
		val currentModule = decl.getContainerOfType(typeof(Model))
		var count = 0
		var i = 0
		val defs = YarelIndex.definitions( currentModule)
		while(count < 2 && i < defs.size){//count the number of definition
			if(defs.get(i).declarationName == decl) count++
			i++
		}
		if(count >= 2){//check if the declaration has no definition
			error('''The declared function '«decl.name»' has multiple definitions''',
				YarelPackage::eINSTANCE.declaration_Name,
				ERROR_INVALID_DEFINITION_COUNT
			)
		}
		else if(count == 0){//check if the declaration has multiple definition
			error('''The declared function '«decl.name»' has no definition''',
				YarelPackage::eINSTANCE.declaration_Name,
				ERROR_INVALID_DEFINITION_COUNT
			)
		}
		//else noError
	}
	
	
	/*Added by Marco Ottina*/
	def <E> pinpointDuplicate(EList<E> list, EReference literal, Map<String,Integer> elementToIndexMap, 
		Function<E,String> elementToStringMapper, String listName, String code){
		elementToIndexMap.clear;
		for (var i= 0; i < list.size ; i++){
			var name = elementToStringMapper.apply(list.get(i));
			if(elementToIndexMap.containsKey(name)){
				error(
					'''Duplicate element "«name»" in «listName» list at index «(i+1)» (it was the «(elementToIndexMap.get(name) +1)»-th element).'''
						,literal, i, code
					);
			}else{
				elementToIndexMap.put(name,i);
			}
		}
		elementToIndexMap.clear;
	}
	
	@Check
	def checkForbiddenVariableName(ParamName varName){
		if(isForbidden(varName.parName)){
			error("Forbidden keyword: "+varName.parName,
				YarelPackage::eINSTANCE.paramName_ParName,
				ERROR_FORBIDDEN_KEYWORD
			)
		}
	}
	
	// ---- PARAMETERS (arity or invocation) CHECKS ---- //
	
	@Check
	def checkDefinitionParametersUniqueness(Declaration decl){
			var Map<String,Integer> paramsMap ;
		if(decl.aritySignature.parametricArities !== null && (!decl.aritySignature.parametricArities.empty)){
			paramsMap = new TreeMap<String,Integer>(Utils.STRING_COMPARATOR);
			pinpointDuplicate(
				decl.aritySignature.parametricArities,
				YarelPackage::eINSTANCE.declaration_AritySignature,
				paramsMap,
				[ ParamName parType | parType.parName],
				"function's parameters",
				ERROR_DUPLICATE_PARAMETER_DEFINITION
				);
		}
		if(decl.invocParamsSignat !== null && decl.invocParamsSignat.invocParam !== null && (!decl.invocParamsSignat.invocParam.empty)){
			pinpointDuplicate(
				decl.invocParamsSignat.invocParam,
				YarelPackage::eINSTANCE.declaration_InvocParamsSignat,
				paramsMap,
				[ ParamName parType | parType.parName],
				"function's parameters",
				ERROR_DUPLICATE_PARAMETER_DEFINITION
				);
		}
	}
	
		@Check
	def checkParametersArityInvocationNotShared(Declaration decl){
		//i.e., a void intersection
		val invocSign = decl.invocParamsSignat;
		val aritySign = decl.aritySignature;
		if(invocSign === null || invocSign.invocParam === null || invocSign.invocParam.empty
			|| aritySign === null || aritySign.parametricArities === null
			|| aritySign.parametricArities.empty){
			return ; // no problem
		}
		val Map<String,Integer> smallerParamsSet = new HashMap();
		var List<String> largerParamsNameList ;
		if(invocSign.invocParam.size < aritySign.parametricArities.size){
			invocSign.invocParam.forEach[ par, index| smallerParamsSet.put(par.parName,index)]
			largerParamsNameList = aritySign.parametricArities.map[it.parName]
		}else{
			aritySign.parametricArities.forEach[ par, index| smallerParamsSet.put(par.parName,index)]
			largerParamsNameList = invocSign.invocParam.map[it.parName]
		}
		for(String parName : largerParamsNameList){
			if(smallerParamsSet.containsKey(parName)){
				error(
					"Duplicate parameter name \""+ parName+"\" in both arity definition and invocation parameters list.",
					YarelPackage::eINSTANCE.declaration_InvocParamsSignat,
					smallerParamsSet.get(parName),
					ERROR_PARAM_BOTH_IN_ARITY_INVOCATION
				)
			}
		}
	}
	
	@Check
	def checkSingleArityOnNativeOperators(Body body){
		var String operatorName = 
			switch body {
				BodyParamPerm: "Parametrized Permutation"
				BodyParamId  : "Parametrized Identity"
				BodyParamInc : "Parametrized Increment"
				BodyParamDec : "Parametrized Decrement"
				BodyParamNeg : "Parametrized Negation"
				BodyParamIt  : "Parametrized Abs-Iteration"
				BodyParamFor : "Parametrized For-Iteration"
				default:
					null
			};
		if(operatorName !== null){
			val arity = switch body {
				BodyParamPerm: body.arity
				BodyParamId  : body.arity
				BodyParamInc : body.arity
				BodyParamDec : body.arity
				BodyParamNeg : body.arity
				default:
					null
				}
			if( arity === null || arity.arities === null || arity.arities.size != 1){
				error("The operator " + operatorName + " must have exactly one arity parameter:"
					+ Arrays.toString(arity.arities.map[YarelUtils.getArity(it.arity)].toArray),
					YarelPackage::eINSTANCE.atomicParRep_Arity,
					ERROR_PARAMETRIC_OPERATOR_ARITY 
				)
			}
			
			val paramsAssign = switch body {
				BodyParamPerm: null
				BodyParamId  : null
				BodyParamInc : body.getParamsAssign()
				BodyParamDec : body.paramsAssign
				BodyParamNeg : body.paramsAssign
				BodyParamIt : body.paramsAssign
				BodyParamFor : body.paramsAssign
				default:
					null
				}
			if( //paramsAssign === null || paramsAssign.parameters === null ||
				paramsAssign !== null && paramsAssign.parameters !== null &&
				paramsAssign.parameters.size != 1
			){
				error("The operator " + operatorName + " must have exactly one parameter:"
					+ Arrays.toString(paramsAssign.parameters.map[YarelUtils.getArity(it.arity)].toArray),
					YarelPackage::eINSTANCE.atomicParRep_ParamsAssign,
					ERROR_PARAMETRIC_OPERATOR_ARITY 
				)
			}
		}
	}
	
	/*
	 * Parameters can be invoked freely upon functions' parameters assignment,
	 * but upon arity assignment only arity's parameters (of the caller function)
	 * can be used, to allow clean and clear arity checks.
	 */
	def checkParameterExisting_V1(ParameterLEWP parName){
		var boolean errorManaged = false;
		/* check if this parameter is used in function's invocation [parameters' passage]
		 * or just in arity definition [native parametric operators or function's arity definition]
		*/
		val paramAssignContext = parName.getContainerOfType(typeof(ParametersAssignment));
		val arityAssignContext = parName.getContainerOfType(typeof(AritiesAssignment));
		
		if(arityAssignContext !== null){
			val Definition defContext = arityAssignContext.getContainerOfType(typeof(Definition));
			if(defContext !== null){
				val Declaration decl = YarelUtils.getDeclaration(defContext)
				if(decl !== null){
					if(!decl.aritySignature.parametricArities.map[it.parName].contains(parName.paramName)){
						errorManaged = true;
						error(
							"The parameter \""+parName.paramName+"\" is not an arity parameter (check the \"dcl\", after the colon) or is undefined.",
							YarelPackage::eINSTANCE.parameterLEWP_ParamName,
							ERROR_UNDEFINED_PARAM_IN_ARITY_ASSIGN
						)
					}
				}
			}
		}else if (paramAssignContext !==null) {
			val Definition defContext = paramAssignContext.getContainerOfType(typeof(Definition));
			if(defContext !== null){
				val Declaration decl = YarelUtils.getDeclaration(defContext)
				if(decl !== null){
					if(!(
						decl.aritySignature.parametricArities.map[it.parName].contains(parName.paramName)
						|| decl.invocParamsSignat.invocParam.map[it.parName].contains(parName.paramName)
						)){
					errorManaged = true;
						error(
						"The parameter \""+parName.paramName+"\" is undefined. Write another one or check the function declaration (the \"dcl\" part).",
						YarelPackage::eINSTANCE.parameterLEWP_ParamName,
						ERROR_PARAM_UNDEFINED
						)
					}
				}
			}
		}else if(!errorManaged){
			//unkown error
			error("The parameter \""+parName.paramName+"\" is used in a unrecognized context.",
				YarelPackage::eINSTANCE.parameterLEWP_ParamName)
		}
	}
	
	private def void checkParExist(EObject parCallingContext, EList<ParametricArity> setOfParamsAssignement,
		EReference refError, String errorCode
	){
		val sovrafunctionCallerDefinition = parCallingContext.getContainerOfType(typeof(Definition))
		
 		if(sovrafunctionCallerDefinition === null){
 			return;
 		}
 		val funCallerDecl = sovrafunctionCallerDefinition.declarationName
		val allowedParamsName = new HashSet<String>();
		if(funCallerDecl.aritySignature.parametricArities !== null ){
			funCallerDecl.aritySignature.parametricArities.forEach[allowedParamsName.add(it.parName)]
		}
		if(funCallerDecl.invocParamsSignat !== null && funCallerDecl.invocParamsSignat.invocParam !== null){
			funCallerDecl.invocParamsSignat.invocParam .forEach[allowedParamsName.add(it.parName)]
		}
//		if(allowedParamsName.empty){
//			error("Inside the function "+funCallerDecl.name+", the parameter \""+parName.paramName+"\" is used in a unrecognized context.",
//				YarelPackage::eINSTANCE.parameterLEWP_ParamName)
//		}
		
		setOfParamsAssignement.forEach[ pa, indexPa|
			val arityParamAssign = YarelUtils.getArity(pa)
			if(arityParamAssign.isParametric){
				arityParamAssign.parametersCoefficients.forEach([paName, coeff|
					if(!allowedParamsName.contains(paName)){
						error(
							"Inside the function "+funCallerDecl.name+", the parameter \""+paName+"\" is not an arity parameter, invocation parameter or is undefined.",
							refError, indexPa, errorCode
	 					)
 					}
				])
			}
		]
	}
	
	@Check(CheckType::NORMAL)
	def checkParametersExisting(AritiesAssignment arityAssign){
		checkParExist(arityAssign, arityAssign.arities,
			YarelPackage::eINSTANCE.aritiesAssignment_Arities,
			ERROR_UNDEFINED_PARAM_IN_ARITY_ASSIGN
		)
	}
	@Check(CheckType::NORMAL)
	def checkParametersExisting(ParametersAssignment parAssign){
		checkParExist(parAssign, parAssign.parameters,
			YarelPackage::eINSTANCE.parametersAssignment_Parameters,
			ERROR_UNDEFINED_PARAM_IN_PARAM_ASSIGN
		)
	}

	@Check
	def checkEnoughParametersToFunctionCall(FunctionInvocation function ){
		val Declaration funcDecl = function.funName
		var int expectedParamsAmount = 0;
		var int providedParamsAmount = 0;
		
//		val ComposedArity caFuncDeclArity = YarelUtils.getArity(funcDecl)
		if(funcDecl === null){
			// neither the model or the function's Declarations exists
			error(
				"Function " + function.toString()+ " declaration not found.",
				YarelPackage::eINSTANCE.functionInvocation_FunName,
				ERROR_FUNCTION_NOT_FOUND
			)
		}
		// check the arity assignment
		expectedParamsAmount = (funcDecl.aritySignature === null || funcDecl.aritySignature.parametricArities === null) ? 0:
				funcDecl.aritySignature.parametricArities.size;
		providedParamsAmount = (function.aritiesAssign === null || function.aritiesAssign.arities === null) ? 0 :
				function.aritiesAssign.arities.size;
		if(expectedParamsAmount != providedParamsAmount ){
			error("Amounts of function's arity(ies) parameters required and arities providedaren't matching: required="+
				expectedParamsAmount + ", provided=" + providedParamsAmount,
				YarelPackage::eINSTANCE.functionInvocation_AritiesAssign,
				ERROR_FUNCTION_ARITIES_AND_PROVIDED_UNMATCH
			)
		}
		// check the parameters assignment
		expectedParamsAmount = (funcDecl.invocParamsSignat === null || funcDecl.invocParamsSignat.invocParam === null) ? 0:
				funcDecl.invocParamsSignat.invocParam.size;
		providedParamsAmount = (function.paramsAssign === null || function.paramsAssign.parameters === null) ? 0 :
				function.paramsAssign.parameters.size;
		if(expectedParamsAmount != providedParamsAmount ){
			error("Amounts of function's parameters required and parameters' values provided aren't matching: required="+
				expectedParamsAmount + ", provided=" + providedParamsAmount,
				YarelPackage::eINSTANCE.functionInvocation_ParamsAssign,
				ERROR_FUNCTION_PARAMS_AND_PROVIDED_UNMATCH
			);
		}
	}

	@Check
	def infoIfNegativeParameters(ParametricArity pa){
		val composedArity = YarelUtils.getArity(pa.arity);
		composedArity.parametersCoefficients.forEach[parName, parCoeff, index|
			if(parCoeff < 0){
				info("Parameter \""+parName+"\"'s coefficient should not be negative: "+parCoeff,
					YarelPackage::eINSTANCE.parametricArity_Arity,index,
					BASE_ERROR_NAME + "WARNING_ARITY"
				)
			}
		]
	}
	
	
	@Check
	def checkSwapIndexedParametersAmount(SwapIndexed sw){ // will be removed because the SwapIndexed could be non-native
		if(sw.paramsAssign.parameters.size !== 2){
			error("Swap requires exactly 2 parameters inside the curved brackets (other than the arity in curly brackets).",
				YarelPackage::eINSTANCE.swapIndexed_ParamsAssign,
				BASE_ERROR_NAME + "PARAMS_AMOUNT_ON_SWAP_INDEXED"
			)
		}
	}
	
	// TODO check if this error is required or an useless obstacle
	@Check
	def checkPositivityArityAtomParametricArity(AritiesAssignment arityAssign){
		arityAssign.arities.forEach[pa|
			val ComposedArity arity = YarelUtils.getArity(pa)
			if((!arity.isParametric)&&(arity.scalar < 1)){
				warning("Non-positive integer part in a non-parametric arity: that integer must be greater than zero: "+arity.scalar,
					YarelPackage::eINSTANCE.parametricArity_Arity,
					ERROR_NON_POSITIVE_ARITY_SCALAR
				)
			}
		]
	}
	
	
	protected def checkConstraintParamExisting(Declaration decl, ParamName parameter, int indexParam, boolean mustBeOnlyArityParam){
		val allowedParamsName = new HashSet<String>();
		if(decl.aritySignature.parametricArities !== null ){
			decl.aritySignature.parametricArities.forEach[allowedParamsName.add(it.parName)]
		}
		if(!mustBeOnlyArityParam){
			if(decl.invocParamsSignat !== null && decl.invocParamsSignat.invocParam !== null){
				decl.invocParamsSignat.invocParam .forEach[allowedParamsName.add(it.parName)]
			}
		}
		if(!allowedParamsName.contains(parameter.parName)){
			error(
				"The parameter \""+parameter.parName+"\" is not an arity parameter"+
				(mustBeOnlyArityParam ? ", invocation parameter":"")
				+" or is undefined.",
				YarelPackage::eINSTANCE.declaration_ParametersConstraint,
				indexParam, ERROR_UNDEFINED_PARAM_IN_CONSTRAINT
			)
		}
	}
	
	@Check
	def checkConstraintParamExisting(Declaration declaration){
		if( declaration.parametersConstraint !== null){
			declaration.parametersConstraint.constraints.forEach[constraint, index|
				 switch constraint {
					ParamConstrPositive: {
						checkConstraintParamExisting(declaration, constraint.paramName, index, false)
					}
					ParamConstrNatural: {
						checkConstraintParamExisting(declaration, constraint.paramName, index, false)
					}
					ParamConstrDistinct: {
						constraint.paramsNames.forEach[param|
							checkConstraintParamExisting(declaration, param, index, false)
						]
					}
					ParamConstrBound:{
						checkConstraintParamExisting(declaration, constraint.paramName, index, false)
						checkConstraintParamExisting(declaration, constraint.arityParamName, index, true)
					}
				};
			]
		}
	}
	
	@Check
	def checkUniquienessOnDistinctConstraint(ParamConstrDistinct constraint){
		val Map<String,Integer> elementToIndexMap = new TreeMap<String,Integer>(Utils.STRING_COMPARATOR);
		pinpointDuplicate(
			constraint.paramsNames,
			YarelPackage::eINSTANCE.paramConstrDistinct_ParamsNames,
			elementToIndexMap,
			[p | p.parName],
			"distinct parameter name",
			ERROR_DUPLICATE_PARAMETER_IN_CONSTRAINT
		)
	}
	
	@Check
	def checkDistinctOnBoundConstraint(ParamConstrBound constraint){
		if(constraint.paramName.parName == constraint.arityParamName.parName){
			error("Duplicated parameter on bound constraint: " + constraint.paramName.parName,
				YarelPackage::eINSTANCE.paramConstrBound_ArityParamName,
			ERROR_DUPLICATE_PARAMETER_IN_CONSTRAINT
			)
		}
	}

	static interface AritySupplier extends Supplier<ComposedArity>{}
}