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
import org.di.unito.yarel.scoping.YarelIndex
import org.di.unito.yarel.utils.YarelUtils
import org.di.unito.yarel.yarel.BodyIf
import org.di.unito.yarel.yarel.BodyPerm
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.Import
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.SerComp
import org.di.unito.yarel.yarel.YarelPackage
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType

import static extension org.eclipse.xtext.EcoreUtil2.*
import org.di.unito.yarel.yarel.PermutationIndexed

/**
 * This class contains the rules that are necessary to every Reval program in order to work.  
 */
class YarelValidator extends AbstractYarelValidator {
	@Inject extension YarelIndex
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
	
	
	/**
	 * Check if arities of the three functions passed to the IF operator are equal
	 */
	@Check
	def checkSelection(BodyIf selection) {
		val posArity =YarelUtils.getArity( selection.pos)
		val negArity =  YarelUtils.getArity(selection.neg)
		val zeroArity = YarelUtils.getArity(selection.zero)
		if((posArity != zeroArity) || (zeroArity != negArity) || (posArity != negArity)) //TODO: Da separare per evidenziare l'errore sulla funzione giusta
				error("Arity of positive, zero and negative functions must be equal", YarelPackage::eINSTANCE.bodyIf_Pos, ERROR_IF_FUNCTIONS_ARITY)
	}
	
	/**
	 * Check if the number of parameters of each branch of the serial composition are equal
	 */
	@Check
	def checkSerialComposition(SerComp serial) {
		val leftArity = YarelUtils.getArity(serial.left)
		val rightArity = YarelUtils.getArity(serial.right)
		
		if(leftArity != rightArity)
			error("Arity of left and right branch must be equal", YarelPackage::eINSTANCE.serComp_Left, ERROR_SERIAL_COMPOSITION)
	}
	
	/**
	 * Check if the declared arity of the function declaration is equal to the arity of the function definition
	 */
	@Check
	def checkArity(Definition definition) {
		val arityDec = YarelUtils.getArity(definition.declarationName);
		val arityDef = YarelUtils.getArity(definition.body);
		if(arityDec  != arityDef)
			error('''Different arities: declarion=«arityDec»; definition=«arityDef»''', YarelPackage::eINSTANCE.definition_Body, ERROR_ARITY)
	}
	
	/**
	 * Check if each index used inside a permutation is less or equal to the arity of the function
	 */
	@Check
	def checkPermutationBound(BodyPerm permutationBody) {
		val permutation = permutationBody.permutation
		val arity = YarelUtils.getArity(permutationBody)
		
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
	
	//----VALIDATION FOR IMPORTS----//
	/**
	 * Check if the imported module exist
	 * And if the imported function of the imported module exist
	 * Added by: Matteo Palazzo
	 */
	 @Check(CheckType::NORMAL)
	 def checkImport(Import impt){
	 	val importedModule = impt.visibleModules.findFirst[mod |mod.name.equals(impt.importedModule)]//should be only one
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
	 			if(!importedModule.declarations.map[name].contains(importedFunction)){//check if the imported module contain the function
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
	  	if(currentModule.visibleModules.exists[mod | mod != currentModule && mod.name == currentModule.name]){
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
	  	while(count < 2 && i < currentModule.definitions.size){//count the number of definition
	  		if(currentModule.definitions.get(i).declarationName == decl) count++
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
	  
	  @Check(CheckType::FAST)
	  def checkBodyPermIndexArity(PermutationIndexed indexedPermutations){
	  	if(indexedPermutations.permutationArity < 2){
	  		error('''Indexed permutations invalid: «indexedPermutations.permutationArity». The minimum is 2.''',
	  			YarelPackage::eINSTANCE.permutation_Indexes,
	  			ERROR_ARITY
	  		)
	  	}
	  }
}
