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

import java.util.HashSet
import org.di.unito.yarel.yarel.Body
import org.di.unito.yarel.yarel.BodyDec
import org.di.unito.yarel.yarel.BodyFun
import org.di.unito.yarel.yarel.BodyId
import org.di.unito.yarel.yarel.BodyIf
import org.di.unito.yarel.yarel.BodyInc
import org.di.unito.yarel.yarel.BodyInv
import org.di.unito.yarel.yarel.BodyIt
import org.di.unito.yarel.yarel.BodyNeg
import org.di.unito.yarel.yarel.BodyPerm
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.ParComp
import org.di.unito.yarel.yarel.SerComp
import org.di.unito.yarel.yarel.YarelPackage
import org.eclipse.xtext.validation.Check
import org.di.unito.yarel.yarel.BodyFor

/**
 * This class contains the rules that are necessary to every Reval program in order to work.  
 */
class YarelValidator extends AbstractYarelValidator {


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
	
	
	private def dispatch int getArity(Declaration declaration) {
		return declaration.signature.types.map[ if(it.value == 0)  1 else it.value ].reduce[p1, p2 | p1 + p2]
	}
		
	private def dispatch int getArity(Body body) {
		switch body {
			SerComp: body.left.arity
			ParComp: body.right.arity + body.left.arity
			BodyInv : body.body.arity
			BodyFun : body.funName.arity
			BodyIt : 1 + body.body.arity
			BodyFor: 1 + body.body.arity
			BodyIf: 1 + body.pos.arity
			BodyPerm: body.permutation.indexes.size
			BodyInc : 1
			BodyDec : 1
			BodyNeg : 1
			BodyId: 1
			default:
				throw new RuntimeException("Body not found " + body)
		}
	}
	
	/**
	 * Check if arities of the three functions passed to the IF operator are equal
	 */
	@Check
	def checkSelection(BodyIf selection) {
		val posArity = selection.pos.arity
		val negArity =  selection.neg.arity
		val zeroArity = selection.zero.arity
		if((posArity != zeroArity) || (zeroArity != negArity) || (posArity != negArity)) //TODO: Da separare per evidenziare l'errore sulla funzione giusta
				error("Arity of positive, zero and negative functions must be equal", YarelPackage::eINSTANCE.bodyIf_Pos, ERROR_IF_FUNCTIONS_ARITY)
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
	 * Check if the declared arity of the function declaration is equal to the arity of the function definition
	 */
	@Check
	def checkArity(Definition definition) {
		if(definition.declarationName.arity != definition.body.arity)
			error("Different arities", YarelPackage::eINSTANCE.definition_Body, ERROR_ARITY)
	}
	
	/**
	 * Check if each index used inside a permutation is less or equal to the arity of the function
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
		val indicesSet = new HashSet<Integer>()
		
		permutation.indexes.forEach[
			if(indicesSet.contains(it.value))
				error("Indices must be all different", YarelPackage::eINSTANCE.bodyPerm_Permutation, ERROR_PERMUTATION_INDICES)
			indicesSet.add(it.value)
		]
	}
}
