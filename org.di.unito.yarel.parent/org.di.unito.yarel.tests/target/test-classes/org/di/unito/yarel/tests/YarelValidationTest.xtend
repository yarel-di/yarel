/*Added by Paolo Parker*/
package org.di.unito.yarel.tests

import static extension org.eclipse.xtext.EcoreUtil2.*

import static extension org.junit.Assert.*
import org.junit.runner.RunWith
import javax.inject.Inject
import org.junit.Test
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Body
import org.di.unito.yarel.yarel.SerComp
import org.di.unito.yarel.yarel.ParComp
import org.di.unito.yarel.yarel.BodyInc
import org.di.unito.yarel.yarel.BodyDec
import org.di.unito.yarel.yarel.BodyFun
import org.di.unito.yarel.yarel.BodyPerm
import org.di.unito.yarel.yarel.Type
import org.di.unito.yarel.yarel.Signature
import java.util.ArrayList
import org.di.unito.yarel.yarel.Permutation
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.di.unito.yarel.yarel.BodyFor
import org.di.unito.yarel.yarel.BodyIt
import org.di.unito.yarel.yarel.BodyInv
import org.di.unito.yarel.yarel.BodyIf
import org.di.unito.yarel.yarel.BodyId
import org.di.unito.yarel.yarel.YarelPackage
import org.di.unito.yarel.validation.YarelValidator
import org.eclipse.emf.ecore.EObject

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(YarelInjectorProvider))

class YarelValidationTest 
{
	@Inject extension ParseHelper<Model>
 	@Inject extension ValidationTestHelper //utilities for testing validation
	
	@Test
	def void testWrongArity()
	{
		var model = '''module m 
					   {
					   		dcl f: int, int
							def f := inc
					   }'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(),YarelValidator::ERROR_ARITY,"Different arities")
	}
	
	@Test
	def void testWrongIfArities()
	{
		var model = '''module m 
					   {
					   		dcl positive: int
					   		dcl zero: int
					   		dcl negative: int, int
					   		dcl f: int, int
					   		
					   		def positive := inc
					   		def zero := dec
					   		def negative := inc|dec
					   		
							def f := if[positive,zero,negative]
					   }'''.parse
		model.assertError(YarelPackage::eINSTANCE.getBodyIf(),YarelValidator::ERROR_IF_FUNCTIONS_ARITY,"Arity of positive, zero and negative functions must be equal")
	}
	
	@Test
	def void testWrongSerCompArities()
	{
		var model = '''module m 
					   {
					   		dcl left: int
					   		dcl right: int, int
					   		dcl f: int
					   		
							def f := left;right
					   }'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	//Testing if one or more indices of the permutation definition is out of bounds
	@Test
	def void testWrongPermutationIndex0()
	{
		var model = '''module m 
					   {
					   		dcl f: int, int, int, int
					   		
							def f := /3 2 4 5/
					   }'''.parse
		var arity = ((model.elements.get(0) as Declaration).signature as Signature).types.size()
		model.assertError(YarelPackage::eINSTANCE.getBodyPerm(),YarelValidator::ERROR_PERMUTATION_BOUND,"Index of permutation out of bound, it must be between 1 and "+arity)
	}
	
	//Testing if two or more indices have the same value in the permutation definition
	@Test
	def void testWrongPermutationIndex1()
	{
		var model = '''module m 
					   {
					   		dcl f: int, int, int, int
					   		
							def f := /3 2 4 4/
					   }'''.parse
		model.assertError(YarelPackage::eINSTANCE.getBodyPerm(),YarelValidator::ERROR_PERMUTATION_INDICES,"Indices must be all different")
	}
	//----------------------------------------NEW STUFF----------------------------------------------------
	//Testing if one or more indices of the permutation definition is out of bounds
	@Test
	def void testWrongPermutationIndex2()
	{
		var model = '''module m 
		{ 
			dcl f: int, int, int, int 
			def f := /3 1 4/
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(),YarelValidator::ERROR_ARITY,"Different arities")
	}
	
	//Testing if one or more indices of the permutation definition is out of bounds
	@Test
	def void testWrongPermutationIndex3()
	{
		var model = '''module m 
		{ 
			dcl f: int, int, int, int 
			def f := /1 3/
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(),YarelValidator::ERROR_ARITY,"Different arities")
	}
	
	//For loop
	
	@Test
	def void testWrongDefinitionArity0()
	{
		var model = '''module m 
		{ 
			dcl f: int
		    def f := for[f];f 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(),YarelValidator::ERROR_ARITY,"Different arities")
	}
	
	@Test
	def void testWrongDefinitionArity1()
	{
		var model = '''module m 
		{ 
			dcl f: int
		    def f := f;for[f] 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity2()
	{
		var model = '''module m 
		{ 
			dcl f: 2 int
		    def f := f;for[f] 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity3()
	{
		var model = '''module m 
		{ 
			dcl f: int, int
		    def f := f;for[f] 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity4()
	{
		var model = '''module m 
		{ 
			dcl f: int
		    def f := /1/;for[inc] 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity5()
	{
		var model = '''module m 
		{ 
			dcl f: int
		    def f := for[inc];/1/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity6()
	{
		var model = '''module m 
		{ 
			dcl f: int
		    def f := /1 2 3/;for[inc] 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity7()
	{
		var model = '''module m 
		{ 
			dcl f: int
		    def f := for[inc];/1 2 3/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity8()
	{
		var model = '''module m 
		{ 
			dcl f: int, int
		    def f := /1 2/;/1 2 3/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity9()
	{
		var model = '''module m 
		{ 
			dcl f: 2 int
			def f := /1 2/;/1 2 3/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity10()
	{
		var model = '''module m 
		{ 
			dcl f: int, int
		    def f := /1 2 3/;/1 2/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity11()
	{
		var model = '''module m 
		{ 
			dcl f: int, int
		    def f := /1 2 3/;/1 2/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity12()
	{
		var model = '''module m 
		{ 
			dcl f: 2 int
		    def f := /1 2 3/;/1 2/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	//Iteration
	
	@Test
	def void testWrongDefinitionArity13()
	{
		var model = '''module m 
		{ 
			dcl f: int
		    def f := it[f];f 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(),YarelValidator::ERROR_ARITY,"Different arities")
	}
	
	@Test
	def void testWrongDefinitionArity14()
	{
		var model = '''module m 
		{ 
			dcl f: int
		    def f := f;it[f] 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity15()
	{
		var model = '''module m 
		{ 
			dcl f: 2 int
		    def f := f;it[f] 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity16()
	{
		var model = '''module m 
		{ 
			dcl f: int, int
		    def f := f;it[f] 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity17()
	{
		var model = '''module m 
		{ 
			dcl f: int
		    def f := /1/;it[inc] 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity18()
	{
		var model = '''module m 
		{ 
			dcl f: int
		    def f := it[inc];/1/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity19()
	{
		var model = '''module m 
		{ 
			dcl f: int
		    def f := /1 2 3/;it[inc] 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity20()
	{
		var model = '''module m 
		{ 
			dcl f: int
		    def f := it[inc];/1 2 3/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity21()
	{
		var model = '''module m 
		{ 
			dcl f: int, int
		    def f := /1 2/;/1 2 3/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity22()
	{
		var model = '''module m 
		{ 
			dcl f: 2 int
			def f := /1 2/;/1 2 3/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity23()
	{
		var model = '''module m 
		{ 
			dcl f: int, int
		    def f := /1 2 3/;/1 2/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity24()
	{
		var model = '''module m 
		{ 
			dcl f: int, int
		    def f := /1 2 3/;/1 2/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	@Test
	def void testWrongDefinitionArity25()
	{
		var model = '''module m 
		{ 
			dcl f: 2 int
		    def f := /1 2 3/;/1 2/ 
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getSerComp(),YarelValidator::ERROR_SERIAL_COMPOSITION,"Arity of left and right branch must be equal")
	}
	
	//TESTS FOR IMPORTS
	//Added by: Matteo Palazzo
	
	//Test if there is an error if you try to import a module that does not exist
	@Test def void testImportedModuleExistCheck(){
		val mod1 = '''
			module mod1{
				dcl f : int
				def f := id
			}
		'''.parse
		mod1.assertNoErrors
		val mod2 = 
		'''
		import mod4.*
		import mod1.*
		module mod2{
			dcl g : int
			def g := f
		}
		'''.parse(mod1.eResource.resourceSet) => [
					assertError(
						YarelPackage::eINSTANCE.import, 
						YarelValidator::ERROR_IMPORT, 
						"'mod4' cannot be resolved as a module"
					)
					1.assertEquals(validate.size)//assert that is there is only one error
					                             //and that the second import work
		]
	}
	
	//Test if there is an error if you try to import a function that is not declared
	@Test def void testImportedFunctionExistCheck(){
		val mod1 = '''
			module mod1{
				dcl f : int
				def f := id
			}
		'''.parse
		mod1.assertNoErrors
		val mod2 = 
		'''
		import mod1.f
		import mod1.h
		module mod2{
			dcl g : int
			def g := f
		}
		'''.parse(mod1.eResource.resourceSet) => [
					assertError(
						YarelPackage::eINSTANCE.import, 
						YarelValidator::ERROR_IMPORT, 
						"'mod1' does not declare function: 'h'"
					)
					1.assertEquals(validate.size)//assert that is there is only one error
					                             //and that the second import work
		]
	}
	
	//Test if there is an error if there are duplicate modules
	@Test def void testDuplicateModule(){
		val mod1 = '''
			module mod1{}
		'''.parse
		mod1.assertNoErrors
		'''
			module mod1{}
		'''.parse(mod1.eResource.resourceSet) => [
				assertError(
					YarelPackage::eINSTANCE.model,
					YarelValidator::ERROR_DUPLICATE_MODULE,
					"The module 'mod1' is already defined"
				)
				1.assertEquals(validate.size)
		]
	}
	
	//Test if there is an error you redeclare a function declared in another module
	/*@Test def void testRedeclaredFunctionWildcardCase(){
		val mod1 = '''
			module mod1{
				dcl f : int 
				def f := id
				dcl g : int
				def g := id
			}
			
		'''.parse
		mod1.assertNoErrors
		'''
			module mod2{
				import mod1.*
				dcl f : int
				def f := id
				dcl g : int
				def g := id
			}
		'''.parse(mod1.eResource.resourceSet) => [
				assertError(
					YarelPackage::eINSTANCE.declaration,
					YarelValidator::ERROR_IMPORT,
					"The function 'f' is already declared in the imported module 'mod1'"
				)
				assertError(
					YarelPackage::eINSTANCE.declaration,
					YarelValidator::ERROR_IMPORT,
					"The function 'g' is already declared in the imported module 'mod1'"
				)
				2.assertEquals(validate.size)
		]
	}*/
	
	//Test if there no if error you redeclare a function declared in another module
	//but you don't import that function
	@Test def void testRedeclaredFunctionNoWildcardCase(){
		val mod1 = '''
			module mod1{
				dcl f : int 
				def f := id
				dcl g : int 
				def g := id
			}
		'''.parse
		mod1.assertNoErrors
		'''
		import mod1.f
		module mod2{
			dcl g : int
			def g := id
		}
		'''.parse(mod1.eResource.resourceSet).assertNoErrors
	}
	
	//Test if the error that you have if you try to redefine
	//a function declared in 2 or more different modules is referred to the
	//first imported module that import that function
	/*@Test def void testRedeclaredFunctionMultipleModules(){
		val mod1 = '''
			module mod1{
				dcl f : int 
				def f := id
			}
		'''.parse
		mod1.assertNoErrors
		val mod2 = '''
			module mod2{
				dcl f : int 
				def f := id
			}
		'''.parse(mod1.eResource.resourceSet)
		mod2.assertNoErrors
		'''
			module mod3{
				import mod1.*
				import mod2.*
				dcl f : int
				def f := id
			}
		'''.parse(mod1.eResource.resourceSet)
		   .assertError(
				YarelPackage::eINSTANCE.declaration,
				YarelValidator::ERROR_IMPORT,
				"The function 'f' is already declared in the imported module 'mod1'"
		    )
	}*/
	
	//Test if there is an error if you give to a function multiple definition
	@Test def void testMultipleDefinition(){
		val mod1 = '''
			module mod1{
				dcl f : int
				def f := id
				def f := neg
			}
		'''.parse => [
				assertError(
					YarelPackage::eINSTANCE.declaration,
					YarelValidator::ERROR_INVALID_DEFINITION_COUNT,
					"The declared function 'f' has multiple definitions" 
				)
		]
	}
	
	@Test def void testImportedFunctionOverride(){
		val mod1 = 
		'''
		module mod1{
			dcl f : int
			def f := id
		}
		'''.parse
		mod1.assertNoErrors
		'''
		import mod1.*
		module mod2{
			dcl f : int
			def f := neg
		}
		'''.parse(mod1.eResource.resourceSet).assertNoErrors
	}
	
	//Test if there is an error if a declared function has not definition
	@Test def void testNoDefiniton(){
		val mod1 = '''
		module mod1{
			dcl f : int
		}
		'''.parse => [
				assertError(
					YarelPackage::eINSTANCE.declaration,
					YarelValidator::ERROR_INVALID_DEFINITION_COUNT,
					"The declared function 'f' has no definition" 
				)
		]
	}
	
	//Test if there is an error if you try to define an imported function
	@Test def void testImportedFunctionDefinition(){
		val mod1 = '''
			module mod1{
				dcl f : int
				def f := id
			}
		'''.parse
		mod1.assertNoErrors
		'''
		import mod1.*
		module mod2{
			def f := id
		}
		'''.parse(mod1.eResource.resourceSet) => [								
				assertError(
					YarelPackage::eINSTANCE.definition,
					"org.eclipse.xtext.diagnostics.Diagnostic.Linking",
					"Couldn't resolve reference to Declaration 'f'"
				)				
		]
	}
	
	//Test if the error does not appear if no import is used and no declaration is given
	//instead the cross reference error should appear
	@Test def void testImportedFunctionDefinitionWithNoImport(){
		val mod1 = '''
			module mod1{
				dcl f : int
				def f := id
			}
		'''.parse
		mod1.assertNoErrors
		'''
			module mod2{
				def f := id
			}
		'''.parse(mod1.eResource.resourceSet) => [
				//assert that the onyl error is due to the unresolved cross reference
				assertError(
					YarelPackage::eINSTANCE.definition,
					"org.eclipse.xtext.diagnostics.Diagnostic.Linking",
					"Couldn't resolve reference to Declaration 'f'"
				)
				1.assertEquals(validate.size)
		]
	}
}