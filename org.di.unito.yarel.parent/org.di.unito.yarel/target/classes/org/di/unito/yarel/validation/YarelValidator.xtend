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
import java.util.HashSet
import java.util.Map
import java.util.TreeMap
import java.util.function.Function
import org.di.unito.yarel.scoping.YarelIndex
import org.di.unito.yarel.utils.Utils
import org.di.unito.yarel.utils.YarelUtils
import org.di.unito.yarel.yarel.BodyIf
import org.di.unito.yarel.yarel.BodyPerm
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.Import
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.ParameterLEWP
import org.di.unito.yarel.yarel.SerComp
import org.di.unito.yarel.yarel.TypeParam
import org.di.unito.yarel.yarel.YarelPackage
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import org.di.unito.yarel.yarel.FunctionInvocation
import org.di.unito.yarel.utils.ComposedArity
import org.di.unito.yarel.yarel.ParametricArity
import org.di.unito.yarel.yarel.impl.ParamLEWPImpl

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
	public static val ERROR_SERIAL_COMPOSITION = BASE_ERROR_NAME + 'ERROR_SERIAL_COMPOSITION'
	public static val ERROR_IF_FUNCTIONS_ARITY = BASE_ERROR_NAME + 'ERROR_IF_FUNCTIONS_ARITY'
	public static val ERROR_PERMUTATION_BOUND = BASE_ERROR_NAME + 'ERROR_PERMUTATION_BOUND'
	public static val ERROR_PERMUTATION_INDICES = BASE_ERROR_NAME + 'ERROR_PERMUTATION_INDICES'
	public static val ERROR_ITERATION_FUNCTIONS_ARITY = BASE_ERROR_NAME + 'ERROR_ITERATION_FUNCTIONS_ARITY'
	public static val ERROR_ARITY = BASE_ERROR_NAME + 'ERROR_ARITY'
	public static val ERROR_IMPORT = BASE_ERROR_NAME + 'ERROR_IMPORT'
	public static val ERROR_DUPLICATE_MODULE = BASE_ERROR_NAME + 'ERROR_DUPLICATE_MODULE'
	public static val ERROR_INVALID_DEFINITION_COUNT = BASE_ERROR_NAME + 'ERROR_INVALID_DEFINITION_COUNT'
	public static val ERROR_FUNCTION_PARAM_OUTSIDE_DEFINITION = BASE_ERROR_NAME + 'ERROR_FUNCTION_PARAM_OUTSIDE_DEFINITION'
	public static val ERROR_DUPLICATE_PARAMETER_DEFINITION = BASE_ERROR_NAME + 'ERROR_DUPLICATE_PARAMETER_DEFINITION'
	public static val ERROR_WRONG_PARAMETERS_AMOUNT_ON_FUNCTION_CALL = BASE_ERROR_NAME + 'ERROR_WRONG_PARAMETERS_AMOUNT_ON_FUNCTION_CALL'
	

	
	
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
				error("Arity of positive function ["+posArity.toString()+"] is not equal to the others: [" + negEqualsZero.toString() + "]"
					, YarelPackage::eINSTANCE.bodyIf_Pos, ERROR_IF_FUNCTIONS_ARITY
				)
			} else if(posEqualsNeg){
				error("Arity of zero-case function ["+zeroArity.toString()+"] is not equal to the others: [" + posArity.toString() + "]"
					, YarelPackage::eINSTANCE.bodyIf_Zero, ERROR_IF_FUNCTIONS_ARITY
				)
			} else {
				error("All functions arities must be equal, but are all different:"
						+"\n\tpos : [" + posArity.toString() + "]"
						+"\n\tzero: [" + zeroArity.toString() + "]"
						+"\n\tneg : [" + negArity.toString() + "]"
					, YarelPackage::eINSTANCE.bodyIf_Function, ERROR_IF_FUNCTIONS_ARITY
				)
			}
		}
	}
	
	/**
	 * Check if the number of parameters of each branch of the serial composition are equal
	 */
	@Check
	def checkSerialComposition(SerComp serial) {
		val leftArity = YarelUtils.getArity(serial.left)
		val rightArity = YarelUtils.getArity(serial.right)
		
		if(!leftArity.equals(rightArity))
			error("Arity of left and right branch in serial composition must be equal: LEFT:["
				+ leftArity.toString() + "] , right:["+rightArity.toString()+"]"
				, YarelPackage::eINSTANCE.serComp_Left, ERROR_SERIAL_COMPOSITION
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
		Function<E,String> elementToStringMapper, String listName){
		elementToIndexMap.clear;
		for (var i= 0; i < list.size ; i++){
			var name = elementToStringMapper.apply(list.get(i));
			if(elementToIndexMap.containsKey(name)){
				error(
					'''Duplicate element "«name»" in «listName» list at index «(i+1)» (it was the «(elementToIndexMap.get(name) +1)»-th element).'''
						,literal, i
					);
			}else{
				elementToIndexMap.put(name,i);
			}
		}
		elementToIndexMap.clear;
	}
	
	@Check
	def checkDefinitionParametersUniqueness(Declaration decl){
		if(decl.signature.params !== null && (!decl.signature.params.empty)){
			val paramsMap = new TreeMap<String,Integer>(Utils.STRING_COMPARATOR);
			pinpointDuplicate(decl.signature.params, YarelPackage::eINSTANCE.declaration_Signature, paramsMap,
				[ TypeParam parType | parType.parName], "function's parameters"
			)
		}
	}
	
	@Check
	def checkParameterExisting(ParameterLEWP parName){
		var boolean outsideDefinition = false;
		val Definition defContext = parName.getContainerOfType(typeof(Definition));
		if(defContext !== null){
			val Declaration decl = YarelUtils.getDeclaration(defContext)
			if(decl !== null){
				if(! decl.signature.params.map[ parType | parType.parName].contains(parName.paramName)){
					error(
						"Undefined parameter: " + parName.paramName,
						YarelPackage::eINSTANCE.parameterLEWP_ParamName,
						ERROR_DUPLICATE_PARAMETER_DEFINITION
					)
				}
			}else{
				outsideDefinition = true;
			}
		}else if(parName.getContainerOfType(typeof(Declaration)) === null){
			outsideDefinition = true;
		}
		if(outsideDefinition){
			warning("Parameter invocation or allocation outside a Definition (a code block) or a function's Declaration.",
				parName,
				YarelPackage::eINSTANCE.parameterLEWP_ParamName,
				ERROR_FUNCTION_PARAM_OUTSIDE_DEFINITION
			)
		}
	}

	@Check
	def checkEnoughParametersToFunction(FunctionInvocation function ){
		val ComposedArity caFuncDef = YarelUtils.getArityOfFunctionName(function, function.funName.name);
		if(caFuncDef ===null){
			return; // neither the model or the function's Declarations exists
		}
		if (
			(function.parameters===null && caFuncDef.parametersAmount != 0) ||
			(function.parameters !== null && (function.parameters.size != caFuncDef.parametersAmount))
			){
			if (function.parameters === null){
				error("Wrong function's parameter provided (between curly brackets): "
					+ caFuncDef.parametersAmount + " expected, "+
					(function.parameters===null ? 0 : function.parameters.size) + " provided.",
					YarelPackage::eINSTANCE.functionInvocation_Parameters,
					ERROR_WRONG_PARAMETERS_AMOUNT_ON_FUNCTION_CALL
				)
			}
		}
	}

	@Check
	def warnIfNegativeParameters(ParametricArity pa){
		val composedArity = YarelUtils.getArity(pa.arity);
		composedArity.parametersCoefficients.forEach[parName, parCoeff, index|
			if(parCoeff < 0){
				warning("Parameter \""+parName+"\"'s coefficient should not be negative: "+parCoeff,
					YarelPackage::eINSTANCE.parametricArity_Arity,index,
					BASE_ERROR_NAME + "WARNING_ARITY"
				)
			}
		]
	}
	
//	@Check
//	def checkParametersExisting(ParametricArity parmArity){
////		if(para)
//	}
//	def checkParametersExisting(Definition defin){
//		val currentModule = defin.getContainerOfType(typeof(Model));
//		if(currentModule.declarations.size>0){//count the number of definition
//			if(currentModule.declarations
//				.map[Declaration decl|decl.name]
//				.contains(defin.declarationName.name)
//			){
//				
//			//.get(i).declarationName == decl) 
////		permutationArity =
////		defin.
//			}
//		}
//	}


//	@Check(CheckType::FAST)
//	def checkBodyPermIndexArity(PermutationIndexed indexedPermutations){
//		if(indexedPermutations.permutationArity < 2){
//			error('''Indexed permutations invalid: «indexedPermutations.permutationArity». The minimum is 2.''',
//				YarelPackage::eINSTANCE.permutation_Indexes,
//				ERROR_ARITY
//			)
//		}
//	}
}