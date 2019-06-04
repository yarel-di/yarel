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

import java.util.List
import java.util.HashSet
import java.util.HashMap
import java.util.ArrayList
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.Body
import org.di.unito.yarel.yarel.BodyDec
import org.di.unito.yarel.yarel.BodyFun
import org.di.unito.yarel.yarel.BodyId
import org.di.unito.yarel.yarel.BodyIf
import org.di.unito.yarel.yarel.BodyInc
import org.di.unito.yarel.yarel.BodyInv
import org.di.unito.yarel.yarel.BodyIt
import org.di.unito.yarel.yarel.BodyNeg
import org.di.unito.yarel.yarel.BodyTof
import org.di.unito.yarel.yarel.BodyNot
import org.di.unito.yarel.yarel.BodyPerm
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.ParComp
import org.di.unito.yarel.yarel.SerComp
import org.di.unito.yarel.yarel.TypeInt
import org.di.unito.yarel.yarel.TypeBool
import org.di.unito.yarel.yarel.YarelPackage
import org.eclipse.xtext.validation.Check

/**
 * This class contains the rules that are necessary to every Reval program in order to work.  
 */
class YarelValidator extends AbstractYarelValidator {

	//Error ids
	public static val BASE_ERROR_NAME = 'org.di.unito.reval_'
	public static val ERROR_DECLARATION_NAME = BASE_ERROR_NAME + 'ERROR_DECLARATION_NAME'
	public static val ERROR_SIGNATURES_TYPE = BASE_ERROR_NAME + 'ERROR_SIGNATURES_TYPE'
	public static val ERROR_SIGNATURES_ARITY = BASE_ERROR_NAME + 'ERROR_SIGNATURES_ARITY'
	public static val ERROR_ARITY = BASE_ERROR_NAME + 'ERROR_ARITY'
	public static val ERROR_OPERATIONS_TYPE = BASE_ERROR_NAME + 'ERROR_OPERATIONS_TYPE'
	public static val ERROR_ORDER = BASE_ERROR_NAME + 'ERROR_ORDER'
	public static val ERROR_SERIAL_COMPOSITION = BASE_ERROR_NAME + 'ERROR_SERIAL_COMPOSITION'
	public static val ERROR_IF_FUNCTIONS_ARITY = BASE_ERROR_NAME + 'ERROR_IF_FUNCTIONS_ARITY'
	public static val ERROR_PERMUTATION_BOUND = BASE_ERROR_NAME + 'ERROR_PERMUTATION_BOUND'
	public static val ERROR_PERMUTATION_INDECES = BASE_ERROR_NAME + 'ERROR_PERMUTATION_INDECES'
	/* These errors have never been used in the program
	public static val WARNING_BAD_MODULE_NAME = BASE_ERROR_NAME + 'WARNING_BAD_MODULE_NAME'
	public static val ERROR_RECURSION = BASE_ERROR_NAME + 'ERROR_RECURSION'
	public static val ERROR_ITERATION_FUNCTIONS_ARITY = BASE_ERROR_NAME + 'ERROR_ITERATION_FUNCTIONS_ARITY'
	*/
	
	public static val ERROR_TRY = BASE_ERROR_NAME + 'ERROR_TRY' //Da cancellare
	
	public var currentInput = new ArrayList<Object>
	public var currentIndex = 0
	public var currentOutput = new ArrayList<Object>
	/**
	 * Declarations ArrayList contains:
	 * [0] -> ArrayList of input types
	 * [1] -> ArrayList of output types
	 * [2] -> Body of the declaration
	 */
	public val declarations = new HashMap<String, ArrayList<Object>>
	
	/**
	 * Empty declarations hashmap
	 * Added by Riccardo Viola.
	 */
	@Check
	def checkModel(Model model){
		declarations.clear()
	}
	
	/**
	 * Convert object list to ArrayList
	 * Added by Riccardo Viola.
	 */
	private def convertToArrayList (ArrayList<Object> arr, List<Object> list, int dim){
		if(dim < list.size){
			val el = list.get(dim) as String
			arr.add(el.trim())
			convertToArrayList(arr, list, dim+1)
		}
	}
	
	/**
	 * Return a string with the compressed input. For example "2 int" become "int, int"
	 * Added by Riccardo Viola.
	 */
	private def String conversion (String res, int value, String type){
		if(value > 1){
			conversion(res + ", " + type, value-1, type)
		}else{
			return res
		}
	}
	
	/**
	 * Check if declaration is already declared and fill the declarations HashMap with its name, input and output types
	 * Added by Riccardo Viola.
	 */
	@Check // Ho controllato ed effettivamente non danno alcun errore se vengono fatte 2 dcl con stesso nome
	def getDeclarationInfo (Declaration declaration){
		currentInput.clear()
		currentIndex = 0
		currentOutput.clear()
		
		if(declarations.containsKey(declaration.getName())){
			error("Declarations must have different names", YarelPackage::eINSTANCE.declaration_Name, ERROR_DECLARATION_NAME)
		}
		else{
			val arrayIn = declaration.signaturesL.types.map[
												if(it instanceof TypeInt){ 
													if(it.value == 0) "int" else conversion("int", it.value, "int")
												}else{
														if(it.value == 0) "bool" else conversion("bool", it.value, "bool")
												}].reduce[p1, p2 | p1.toString() +","+ p2.toString()].split(",");						
			val arrayOut = declaration.signaturesR.types.map[ 
												if(it instanceof TypeInt){ 
													if(it.value == 0) "int" else conversion("int", it.value, "int")
													}else{
														if(it.value == 0) "bool" else conversion("bool", it.value, "bool")
												}].reduce[p1, p2 | p1.toString() +","+ p2.toString()].split(",");
			convertToArrayList(currentInput, arrayIn, 0)
			convertToArrayList(currentOutput, arrayOut, 0)
			
			val ArrayList<Object> listTypes = new ArrayList<Object>
			listTypes.add(currentInput.clone())
			listTypes.add(currentOutput.clone())
			declarations.put(declaration.getName(), listTypes)
		}
	}
	
	/**
	 * Return input arity
	 * Added by Riccardo Viola.
	 */
	private def int getArityL(Declaration declaration) {
		return declaration.signaturesL.types.map[ if(it.value == 0)  1 else it.value ].reduce[p1, p2 | p1 + p2]
	}
	
	/**
	 * Return output arity
	 * Added by Riccardo Viola.
	 */
	private def int getArityR(Declaration declaration) {
		return declaration.signaturesR.types.map[ if(it.value == 0)  1 else it.value ].reduce[p1, p2 | p1 + p2]
	}
	
	/**
	 * Return input arity
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
	private def dispatch int getArity(Declaration declaration) {
		return getArityL(declaration)
	}
	
	/**
	 * Return body arity
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
	private def dispatch int getArity(Body body) {
		switch body {
			SerComp : body.left.arity
			ParComp : body.right.arity + body.left.arity 
			BodyInv : body.body.arity
			BodyFun : body.funName.arity
			BodyIt  : 1 + body.body.arity
			BodyIf  : 1 + body.pos.arity
			BodyPerm: body.permutation.indexes.size
			BodyInc : 1
			BodyDec : 1
			BodyNeg : 1
			BodyTof : 3
			BodyNot : 1
			BodyId  : 1
			default:
				throw new RuntimeException("Body not found " + body)
		}
	}
	
	/**
	 * Check if arities of signaturesL and signaturesR are equal
	 */
	@Check
	def checkArityLR(Declaration declaration) {
		val signaturesLArity = getArityL(declaration)
		val signaturesRArity = getArityR(declaration)
		
		if(signaturesLArity != signaturesRArity)
			error("Arity of signaturesL and signaturesR must be equal", YarelPackage::eINSTANCE.declaration_SignaturesR, ERROR_SIGNATURES_ARITY)
	}
	
	/**
	 * Check if types of signaturesL and signaturesR are compatible
	 * Added by Riccardo Viola.
	 */
	@Check
	def checkTypesLR(Declaration declaration){
		val signaturesLTypes = #[declaration.signaturesL.types.map[ if(it instanceof TypeInt) { if(it.value == 0)  1 else it.value }].reduce[p1, p2 | p1 + p2], 
								 declaration.signaturesL.types.map[ if(it instanceof TypeBool) { if(it.value == 0)  1 else it.value }].reduce[p1, p2 | p1 + p2] ]
		val signaturesRTypes = #[declaration.signaturesR.types.map[ if(it instanceof TypeInt) { if(it.value == 0)  1 else it.value }].reduce[p1, p2 | p1 + p2], 
								 declaration.signaturesR.types.map[ if(it instanceof TypeBool) { if(it.value == 0)  1 else it.value }].reduce[p1, p2 | p1 + p2]	]
		
		if(signaturesLTypes != signaturesRTypes)
			error("Types of signaturesL and signaturesR must be equal", YarelPackage::eINSTANCE.declaration_SignaturesR, ERROR_SIGNATURES_TYPE)
	}
	
	/**
	 * Check if the declared arity of the function declaration is equal to the arity of the function definition
	 */
	@Check
	def checkArity(Definition definition) {
		if(definition.declarationName.arity != definition.body.arity)
			error("Different arities", YarelPackage::eINSTANCE.definition_Body, ERROR_ARITY)
	}
	
	/**
	 * Add definition body to declarations
	 * Added by Riccardo Viola.
	 */
	@Check
	def getBodyDefinition(Definition definition){
		(declarations.get(definition.getDeclarationName().getName())).add(definition.getBody())
	}
	
	/**
	 * Change types order
	 * Added by Riccardo Viola.
	 */
	private def modifyInputTypesOrder(ArrayList<Object> orderedList, ArrayList<Integer> indexes, int dim){
		if(dim < indexes.size()){
			orderedList.add(currentInput.get(indexes.get(dim)-1))
			modifyInputTypesOrder(orderedList, indexes, dim + 1)
		}
	}
	
	/**
	 * Return an ArrayList which contains the permutation indexes
	 * Added by Riccardo Viola.
	 */
	private def ArrayList<Integer> getPermutationIndexes(BodyPerm permutationBody){
		val indexes = new ArrayList<Integer>() 
		permutationBody.permutation.indexes.forEach[
			indexes.add(it.value)
		]
		return indexes
	}
	
	/**
	 * Check if operations types are properly linked with input
	 * Added by Riccardo Viola.
	 */
	private def boolean checkType(Body body, boolean fwd){
		switch body {
			SerComp : {
				if(body.getRight() !== null){
					if(checkType(body.getLeft(), fwd)){
						currentIndex = 0
						if(checkType(body.getRight(), fwd)){
							return true
						}else{
							return false
						}
					}else{
						return false
					}
				}
				else{
					if(checkType(body.getLeft(), fwd)){
						return true
					}
					else{
						return false
					}
				}
			}
			ParComp : {
				if(fwd){
					if(body.getRight() !== null){
						if(checkType(body.getLeft(), fwd) && checkType(body.getRight(), fwd)){
							return true
						}else{
							return false
						}
					}
					else{
						if(checkType(body.getLeft(), fwd)){
							return true
						}
						else{
							return false
						}
					}
				}else{
					if(body.getRight() !== null){
						if(checkType(body.getRight(), fwd) && checkType(body.getLeft(), fwd)){
							return true
						}else{
							return false
						}
					}
					else{
						if(checkType(body.getLeft(), fwd)){
							return true
						}
						else{
							return false
						}
					}
				}
			}
			BodyPerm : {
				val ArrayList<Integer> indexes = getPermutationIndexes(body)
				val orderedList = new ArrayList<Object>
				if(fwd){
					modifyInputTypesOrder(orderedList, indexes, 0)
				}else{
					val ArrayList<Integer> indexesRev = new ArrayList<Integer>
					var int dim = indexes.size() 
					var int ind = 1
					while(dim > 0){
						indexesRev.add(indexes.indexOf(ind) + 1)
						dim--
						ind++
					}
					modifyInputTypesOrder(orderedList, indexesRev, 0)
				}
				currentInput = orderedList
				currentIndex = 0
				return true
			}
			BodyInv : {
				if(checkType(body.getBody(), !fwd)){
					return true
				}else{
					return false
				}
			}
			BodyFun :{ //Posso farli entrambi con il body o uno input e l'altro output??
				if(fwd){
					val ArrayList<Object> fun = declarations.get(body.getFunName().getName())
					if(checkType(fun.get(2) as Body, fwd)){
						return true
					}else{
						return false	
					}
				}else{
					val ArrayList<Object> outputFun = declarations.get(body.getFunName().getName()).get(1) as ArrayList<Object>
					var int dim = 0
					while(dim < outputFun.size()){
						if(outputFun.get(dim) == currentInput.get(currentIndex)){
							dim++
							currentIndex++
						}else{
							return false
						}
					}
					return true
				}
			}
			BodyIt  : {
				val Body bodyIt = body.getBody()
				if(checkType(bodyIt, fwd)){
					if(currentInput.get(currentIndex) == "int"){
						currentIndex++
						return true
					}else{
						return false
					}
				}else{
					return false
				}
			}
			BodyIf  : {
				val Body bodyPos = body.getPos()
				val Body bodyZero = body.getZero()
				val Body bodyNeg = body.getNeg()
				var int memo = currentIndex
				if(checkType(bodyPos, fwd)){
					currentIndex = memo
					if(checkType(bodyZero, fwd)){
						currentIndex = memo
						if(checkType(bodyNeg, fwd)){
							if(currentInput.get(currentIndex) == "int"){
								currentIndex++
								return true
							}
						}
					}
				} 
				return false
			}
			BodyInc : {
				if(currentInput.get(currentIndex) == "int"){
					currentIndex++
					return true
				}else{
					return false
				}	
			}
			BodyDec : {
				if(currentInput.get(currentIndex) == "int"){
					currentIndex++
					return true
				}else{
					return false
				}	
			}
			BodyNeg : {
				if(currentInput.get(currentIndex) == "int"){
					currentIndex++
					return true
				}else{
					return false
				}	
			}
			BodyTof : {
				if(currentInput.get(currentIndex) == "bool" && currentInput.get(currentIndex + 1) == "bool" && currentInput.get(currentIndex + 2) == "bool"){
					currentIndex += 3
					return true
				}else{
					return false
				}
			}
			BodyNot : {
				if(currentInput.get(currentIndex) == "bool"){
					currentIndex ++
					return true
				}else{
					return false
				}
			}
			BodyId  : {
				currentIndex++
				return true
			}
			default:
				throw new RuntimeException("Body not found " + body)
		}
	}
	
	/**
	 * Compare input and output lists
	 * Added by Riccardo Viola.
	 */
	private def boolean compareLists(ArrayList<Object> ar1, ArrayList<Object> ar2, int dim){
		if(dim < ar1.size()){
			if(ar1.get(dim) == ar2.get(dim)){
				compareLists(ar1, ar2, dim + 1)
			}else{
				return false
			}
		}else{
			return true
		}
	}
	
	/**
	 * Check if input and output type orders are equal and if operations have correct type inputs
	 * Added by Riccardo Viola.
	 */	
	@Check
	def checkOperations(Definition definition){
		val body = definition.body as Body	
		
		if(!checkType(body, true))
			error("Operations and input types are bad linked", YarelPackage::eINSTANCE.definition_Body, ERROR_OPERATIONS_TYPE)
					
		if(!compareLists(currentInput, currentOutput, 0))
			error("Different order between input and output types after operations", YarelPackage::eINSTANCE.definition_Body, ERROR_ORDER)
	}
	
	/**
	 * Check if the number of parameters of each branch of the serial composition are equal
	 */
	@Check
	def checkSerialComposition(SerComp serial) {
		val leftArity = serial.left.arity
		val rightArity = serial.right.arity
		
		if(leftArity != rightArity)
			error("Arity of left and right branch must be equal", YarelPackage::eINSTANCE.serComp_Left, ERROR_SERIAL_COMPOSITION)
	}
	
	/**
	 * Check if arities of the three functions passed to the IF operator are equal
	 */
	@Check
	def checkSelection(BodyIf selection) {
		val posArity = selection.pos.arity
		val negArity = selection.neg.arity
		val zeroArity = selection.zero.arity
		
		if(posArity != zeroArity)
			error("Arity of positive and zero functions must be equal", YarelPackage::eINSTANCE.bodyIf_Pos, ERROR_IF_FUNCTIONS_ARITY)
		else if (zeroArity != negArity)
			error("Arity of zero and negative functions must be equal", YarelPackage::eINSTANCE.bodyIf_Zero, ERROR_IF_FUNCTIONS_ARITY)
		else if	(negArity != posArity)
			error("Arity of positive and negative functions must be equal", YarelPackage::eINSTANCE.bodyIf_Neg, ERROR_IF_FUNCTIONS_ARITY)
	}
	
	/**
	 * Check if each index used inside permutation is less or equal to the arity of the function
	 */
	@Check
	def checkPermutationBound(BodyPerm permutationBody) {
		val permutation = permutationBody.permutation
		val arity = permutationBody.arity
		
		val outOfBoundIndexes = permutation.indexes.filter[!(1..arity).contains(it.value)]
		
		if(outOfBoundIndexes.size > 0)
			error("Index of permutation out of bound, it must be between 1 and " + arity, YarelPackage::eINSTANCE.bodyPerm_Permutation, ERROR_PERMUTATION_BOUND)
	}	
	
	/**
	 * Check if the indices in a permutation are all different
	 */
	@Check
	def checkPermutationIndicesEquality(BodyPerm permutationBody) {
		val permutation = permutationBody.permutation
		val indicesSet = new HashSet<Integer>
		
		permutation.indexes.forEach[
			if(indicesSet.contains(it.value))
				error("Indices must be all different", YarelPackage::eINSTANCE.bodyPerm_Permutation, ERROR_PERMUTATION_INDECES)
			indicesSet.add(it.value)
		]
	}
	
}
