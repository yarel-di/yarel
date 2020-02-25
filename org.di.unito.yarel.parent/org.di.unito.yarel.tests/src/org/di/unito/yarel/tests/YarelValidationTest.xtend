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
}