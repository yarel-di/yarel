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
import org.di.unito.yarel.yarel.Import
import org.di.unito.yarel.scoping.YarelIndex
import com.google.inject.Inject
import org.di.unito.yarel.utils.YarelUtils
import org.di.unito.yarel.yarel.Model
import org.eclipse.xtext.validation.CheckType
import static extension org.eclipse.xtext.EcoreUtil2.*
import java.util.HashMap
import java.util.Map
import java.util.List
import java.util.ArrayList

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
	  * Check if the module does not declare a function with the same name
	  * of a function declared in another module
	  * Added by: Matteo Palazzo
	  */
	  @Check
	  def checkImportedFunctionRedeclaration(Declaration decl){
	  	val imports = mapImportedFunToMod(decl.getContainerOfType(typeof(Model)))
	  	val importingMod = imports.get(decl.name)
	  	if(importingMod !== null){
	  		//The function is not imported by a module
	  		error(
	  			"The function '" + decl.name + "' is already declared in the imported module '" +
	  				importingMod + "'",
	  			YarelPackage::eINSTANCE.declaration_Name,
	  			ERROR_IMPORT
	  		)
	  	}
	  	/*
	  	OLD VERSION:
	  	val importedModules = currentModule.visibleModules.filter[mod |
	  		currentModule.imports.map[importedModule].contains(mod.name)	  		
	  	]//take only the imported modules
		val mod = importedModules.findFirst[
			declarations.map[name].contains(decl.name)
		]//the module that already declare the function
	  	if(mod !== null){
	  		//The function is declared in another module
	  		error(
	  			"The function '" + decl.name + "' is already declared in the imported module '" +
	  				mod.name + "'",
	  			YarelPackage::eINSTANCE.declaration_Name,
	  			ERROR_IMPORT
	  		) 	
	  	}*/
	  }
	  
	  /**
	   * Map each imported function to the first module that import its
	   * Added by Matteo Palazzo
	   */
	  private def mapImportedFunToMod(Model module){
	  	val Map<String, String> funToModMap = new HashMap()
	  	val visibleModules = module.visibleModules
	  	for(impt : module.imports){
	  		val importedModule = impt.importedModule
	  		val function = impt.importedFunction
	  		if(function == '*'){//resolve the wildcard
  				visibleModules.findFirst[mod | mod.name == importedModule]
  							  .declarations
  							  .map[name]
  							  .forEach(fun | funToModMap.putIfAbsent(fun, importedModule))
	  		}
	  		else{//add the function to the map
	  			funToModMap.putIfAbsent(function, importedModule)
	  		}
	  	}
	  	return funToModMap
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
	  
	  /**
	   * Check that a module does not give a definition of an imported function
	   * Added by Matteo Palazzo
	   */
	  @Check def checkDefineOnlyOwnFunction(Definition definition){
	  	if(definition.declarationName.name !== null){//The cross reference of the object is solved
		  	val mod = definition.getContainerOfType(typeof(Model))
		  	if(!mod.declarations.contains(definition.declarationName)){
		  		error(
		  			"Trying to define the imported function '" + definition.declarationName.name + "'",
		  			YarelPackage::eINSTANCE.definition_DeclarationName,
		  			ERROR_IMPORT
		  		)
		  	}
	  	}
	  }
}
