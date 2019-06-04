package org.di.unito.yarel.tests

import javax.inject.Inject
import org.di.unito.yarel.validation.YarelValidator
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.YarelPackage
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(YarelInjectorProvider))

class YarelValidationTest{
	
	@Inject extension ParseHelper<Model>
 	@Inject extension ValidationTestHelper //utilities for testing validation
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testMultipleDeclarations1(){
		var model = '''module m {
			dcl f: 2 int -> 2 int
		    dcl f: 2 bool -> 2 bool
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDeclaration(), YarelValidator::ERROR_DECLARATION_NAME, "Declarations must have different names")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testMultipleDeclarations2(){
		var model = '''module m {
			dcl f: 2 int -> 2 int
			dcl f: 2 int -> 2 int
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDeclaration(), YarelValidator::ERROR_DECLARATION_NAME, "Declarations must have different names")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testTypesLAndR1(){
		var model = '''module m {
			dcl f: 2 int, bool -> int, 2 bool
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDeclaration(), YarelValidator::ERROR_SIGNATURES_TYPE, "Types of signaturesL and signaturesR must be equal")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testTypesLAndR2(){
		var model = '''module m {
			dcl f: int, bool -> bool, bool
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDeclaration(), YarelValidator::ERROR_SIGNATURES_TYPE, "Types of signaturesL and signaturesR must be equal")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testTypesLAndR3(){
		var model = '''module m {
			dcl f: 2 int, 3 bool -> bool, bool, int, int, int
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDeclaration(), YarelValidator::ERROR_SIGNATURES_TYPE, "Types of signaturesL and signaturesR must be equal")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testOperationsLinking1(){
		var model = '''module m {
			dcl f : bool -> bool
			def f := dec
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_OPERATIONS_TYPE, "Operations and input types are bad linked")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testOperationsLinking2(){
		var model = '''module m {
			dcl f : bool -> bool
			def f := inc
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_OPERATIONS_TYPE, "Operations and input types are bad linked")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testOperationsLinking3(){
		var model = '''module m {
			dcl f : bool -> bool
			def f := neg
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_OPERATIONS_TYPE, "Operations and input types are bad linked")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testOperationsLinking4(){
		var model = '''module m {
			dcl f : int -> int
			def f := not
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_OPERATIONS_TYPE, "Operations and input types are bad linked")
	}
	
	/**
	 * Added by Riccardo Viola
	 */
	@Test
	def void testOperationsLinking5(){
		var model = '''module m {
			dcl f : 2 bool, int -> 2 bool, int 
			def f := tof
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_OPERATIONS_TYPE, "Operations and input types are bad linked")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testOperationsLinking6(){
		var model = '''module m {
			dcl f : bool, int -> bool, int
			def f := (inc | not)
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_OPERATIONS_TYPE, "Operations and input types are bad linked")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testOperationsLinking7(){
		var model = '''module m {
			dcl f : 2 bool, int, bool -> 2 bool, int, bool 
			def f := (tof | inc)
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_OPERATIONS_TYPE, "Operations and input types are bad linked")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testOperationsLinking8(){
		var model = '''module m {
			dcl f : 2 int, 3 bool -> int, 3 bool, int
			def f := (id | id | id | id | id);
					 (tof | id | inc);
					 /2 1 3 4 5/;
					 (dec | id | id | id | id);
					 /1 3 4 5 2/
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_OPERATIONS_TYPE, "Operations and input types are bad linked")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testOperationsLinking9(){
		var model = '''module m {
			dcl f : 2 int, 3 bool -> int, 3 bool, int
			def f := (id | id | id | id | id);
					 (inc | id | tof);
					 /2 1 3 4 5/;
					 (tof | id | id);
					 /1 3 4 5 2/
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_OPERATIONS_TYPE, "Operations and input types are bad linked")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testOperationsLinking10(){
		var model = '''module m {
			dcl f : 2 int, 3 bool -> int, 3 bool, int
			def f := (id | id | id | id | id);
					 (inc | id | tof);
					 /2 1 3 4 5/;
					 (dec | tof | id);
					 /1 3 4 5 2/
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_OPERATIONS_TYPE, "Operations and input types are bad linked")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testPermutationOrder1(){
		var model = '''module m {
			dcl f : bool, int -> bool, int
			def f := /2 1/
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_ORDER, "Different order between input and output types after operations")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testPermutationOrder2(){
		var model = '''module m {
			dcl f : int, bool -> int, bool
			def f := /2 1/
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_ORDER, "Different order between input and output types after operations")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testPermutationOrder3(){
		var model = '''module m {
			dcl f : int, bool -> bool, int
			def f := /2 1/;
					 /2 1/
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_ORDER, "Different order between input and output types after operations")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testPermutationOrder4(){
		var model = '''module m {
			dcl f : int, bool -> int, bool
			def f := /2 1/;
					 /2 1/;
					 /2 1/
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_ORDER, "Different order between input and output types after operations")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testPermutationOrder5(){
		var model = '''module m {
			dcl f : 2 int, 3 bool -> int, 3 bool, int
			def f := (id | id | id | id | id);
					 (inc | id | tof);
					 /2 1 3 4 5/;
					 (dec | id | id | id | id);
					 /1 3 4 2 5/
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_ORDER, "Different order between input and output types after operations")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testPermutationOrder6(){
		var model = '''module m {
			dcl f : 2 int, 3 bool -> int, 3 bool, int
			def f := (id | id | id | id | id);
					 (inc | id | tof);
					 /2 3 1 4 5/;
					 (dec | id | id | id | id);
					 /1 3 4 5 2/
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_ORDER, "Different order between input and output types after operations")
	}
	
	/**
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testPermutationOrder7(){
		var model = '''module m {
			dcl f : int, bool, int, bool -> int, bool, int, bool
			def f := /2 4 3 1/;
				     /4 1 3 2/;
					 /2 4 3 1/;
					 inv[/2 3 1 4/]
		}'''.parse
		model.assertError(YarelPackage::eINSTANCE.getDefinition(), YarelValidator::ERROR_ORDER, "Different order between input and output types after operations")
	}
	
}