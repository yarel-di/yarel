package org.di.unito.yarel.tests

import org.eclipse.xtext.testing.XtextRunner
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.InjectWith
import org.junit.Test
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.Definition
import org.eclipse.xtext.testing.util.ParseHelper
import com.google.inject.Inject
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.di.unito.yarel.yarel.YarelPackage
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import static extension org.junit.Assert.assertEquals
import org.di.unito.yarel.utils.YarelUtils
import org.di.unito.yarel.scoping.YarelIndex
import org.di.unito.yarel.validation.YarelValidator
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import static extension org.junit.Assert.assertArrayEquals

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(YarelInjectorProvider))
class YarelImportTest {
	
	@Inject extension ParseHelper<Model>
	@Inject extension ValidationTestHelper
	@Inject extension IScopeProvider
	@Inject extension YarelUtils
	@Inject extension YarelIndex
	@Inject extension CompilationTestHelper
	@Inject extension ReflectExtensions
	
	//----PARSING TEST----//
	
	//Test if there are no error when not using an import
	@Test def void testNoImport(){
		'''
		module mod{
			dcl f : int
			def f := id
			
			dcl g : int
			def g := f
		}
		'''.parse.assertNoErrors
	}
	
	//Test if you can use a function declared in the same module by calling it with the qualified name
	@Test def void testQualifiedNameOfSameModule(){
		'''
		module mod{
			dcl f : int
			def f := id
			
			dcl g : int
			def g := mod.f
		}
		'''.parse.assertNoErrors
	}
	
	//Test if you can use a function of another module if you import his namespace
	@Test def void testImport(){
		val mod1 = '''
		module mod1{
			dcl f : int
			def f := id
		}
		'''.parse
		mod1.assertNoErrors
		val mod2 = '''
		module mod2{
			import mod1.*
			dcl g : int
			def g := f
		}
		'''.parse(mod1.eResource.resourceSet)//use the resource set of the first module as a resource set of the second one
		mod2.assertNoErrors
	}
	
	//Test if you can reference a function of a different module by using its qualified name
	@Test def void testDifferentModuleCrossReference(){
		val mod1 = '''
		module mod1{
			dcl f : int
			def f := id
		}
		'''.parse
		mod1.assertNoErrors
		'''
		module mod2{
			dcl g : int
			def g := mod1.f
		}
		'''.parse(mod1.eResource.resourceSet).assertNoErrors
	}
	
	//Test that if you import two modules that have a function with the same name there
	//is an ambiguity that cannot be resolved
	@Test def void testAmbiguityWithoutQualifiedName(){
		val mod1 = 
		'''
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
		'''module mod3{
			import mod1.*
			import mod2.*
			dcl g : int
			def g := f
		}'''.parse(mod2.eResource.resourceSet).assertError(//check that there is an error due to the ambiguity
				YarelPackage::eINSTANCE.bodyFun, 
				"org.eclipse.xtext.diagnostics.Diagnostic.Linking",
				"Couldn't resolve reference to Declaration 'f'"
			)
	}
	
	//Test that if you import two modules that have a function with the same name, but
	//you call it with a QualifiedName the ambiguity is solved
	@Test def void testNoAmbiguityWithQualifiedName(){
		val mod1 = 
		'''
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
		'''module mod3{
			import mod1.*
			import mod2.*
			dcl g : 2 int
			def g := mod1.f | mod2.f
		}'''.parse(mod2.eResource.resourceSet).assertNoErrors 
	}
	
	//Test if the scope seen in a function body is correct
	@Test def void testCorrectScope(){
		val mod1 = 
		'''
		module mod1{
			dcl f : int
			def f := id
		}
		'''.parse
		mod1.assertNoErrors
		val mod2 = '''
		module mod2{
			import mod1.*
			dcl g : int
			def g := id
		}
		'''.parse(mod1.eResource.resourceSet)
		mod2.assertNoErrors
		val mod1FDef = mod1.definitions.head //get the definition of f in mod1
		val mod2GDef = mod2.definitions.filter(typeof(Definition)).head//get the definition of g in mod2 
		mod1FDef.assertScope(YarelPackage::eINSTANCE.bodyFun_FunName, "f, mod1.f, mod2.g")
		mod2GDef.assertScope(YarelPackage::eINSTANCE.bodyFun_FunName, "g, f, mod2.g, mod1.f")
	}
	
	//Assert if the expected scope is equals to the actual one
	def private assertScope(EObject context, EReference reference, CharSequence expected){
		val scope = context.getScope(reference)
		expected.toString.assertEquals(
			scope.allElements.map[name].join(", ")
		)
	}
	
	//----VALIDATION TEST----//
	
	//Test if there is an error if you try to import a module that does not exist
	@Test def void testImportedModuleExistCheck(){
		val mod1 = '''
			module mod1{
				dcl f : int
				def f := id
			}
		'''.parse
		mod1.assertNoErrors
		val mod2 = '''
			module mod2{
				import mod4.*
				import mod1.*
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
		val mod2 = '''
			module mod2{
				import mod1.f
				import mod1.h
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
			module mod2{
				import mod1.f
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
		module mod2{
			import mod1.*
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
			module mod2{
				import mod1.*
				def f := id
			}
		'''.parse(mod1.eResource.resourceSet) => [
				assertError(
					YarelPackage::eINSTANCE.definition,
					YarelValidator::ERROR_IMPORT,
					"Trying to define the imported function 'f'"
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
	
	//--COMPILATION TESTS:--//
	
	static val CharSequence importedModuleMod1 = 
		'''
		module mod1{
			dcl g : int
			def g := id
		}'''
		
	static val CharSequence importedModuleMod2 = 
		'''
		module mod2{
			dcl g : int
			def g := neg
			dcl h : int
			def h := neg
		}'''
	
	@Test def void testImportWithNoAmbiguityCode(){
		(#[
			importedModuleMod1,
			'''module mod{
				import mod1.*
				dcl f : int
				def f := g
			}'''
		] as Iterable<CharSequence>).assertCorrectCodeGeneration("mod.F", #[1], #[1])
	}
	
	private def void assertCorrectGeneratedBodyFun(CharSequence rlCode,
		String moduleName,
		String funName,
		String expectedBodyFun
	){
		rlCode.compile[
			getGeneratedCode(moduleName + "." + funName).trim.assertEquals(
				'''
				package mod;
				import java.util.Arrays;
				import java.lang.Math;
				import Yarelcore.*;	
				public class «funName» implements RPP {
				    public «funName»() { }
				    RPP function = «expectedBodyFun»;
				    private final int a = function.getA();
				    public int[] b(int[] x) { 
				    	  	return this.function.b(x);
				    }
				     public int getA() { return this.a; }
				}
				'''.toString.trim	
			)
		]
	}
	
	private def void assertCorrectGeneratedBodyFun(Iterable<CharSequence> files,
		String moduleName,
		String funName,
		String expectedBodyFun
	){
		files.compile[
			getGeneratedCode(moduleName + "." + funName).trim.assertEquals(
				'''
				package mod;
				import java.util.Arrays;
				import java.lang.Math;
				import Yarelcore.*;	
				public class «funName» implements RPP {
				    public «funName»() { }
				    RPP function = «expectedBodyFun»;
				    private final int a = function.getA();
				    public int[] b(int[] x) { 
				    	  	return this.function.b(x);
				    }
				     public int getA() { return this.a; }
				}
				'''.toString.trim	
			)
		]
	}
	
	@Test def void testCorrectGeneratedCode(){
		'''
		module mod{
			dcl f : int
			def f := id
			dcl g : int
			def g := f
		}
		'''.assertCorrectGeneratedBodyFun("mod", "G", "new F()")
	}
	
	@Test def void testCorrectGeneratedCode1(){
		(#[
			importedModuleMod1,
			'''
			module mod{
				import mod1.g
				dcl f : int
				def f := g		
			}
			'''	
		] as Iterable<CharSequence>)
			.assertCorrectGeneratedBodyFun("mod", "F", "new mod1.G()")
	}
	
	@Test def void testCorrectGeneratedCode2(){
		(#[
			importedModuleMod1,
			'''
			module mod{				
				dcl f : int
				def f := mod1.g		
			}
			'''	
		] as Iterable<CharSequence>)
			.assertCorrectGeneratedBodyFun("mod", "F", "new mod1.G()")
	}
	
	@Test def void testCorrectGeneratedCodeInvertedFunction(){	
		'''
		module mod{
			dcl f : int
			def f := id
			dcl g : int
			def g := f
		}
		'''.assertCorrectGeneratedBodyFun("mod", "InvG", "new InvF()")
	}
	
	@Test def void testCorrectGeneratedCodeInvertedFunction1(){
		(#[
			importedModuleMod1,
			'''
			module mod{
				import mod1.g
				dcl f : int
				def f := g		
			}
			'''	
		] as Iterable<CharSequence>)
			.assertCorrectGeneratedBodyFun("mod", "InvF", "new mod1.InvG()")
	}
	
	@Test def void testCorrectGeneratedCodeInv(){	
		'''
		module mod{
			dcl f : int
			def f := id
			dcl g : int
			def g := inv[f]
		}
		'''.assertCorrectGeneratedBodyFun("mod", "G", "new InvF()")
	}
	
	@Test def void testCorrectGeneratedCodeInv1(){
		(#[
			importedModuleMod1,
			'''
			module mod{
				import mod1.g
				dcl f : int
				def f := inv[g]		
			}
			'''	
		] as Iterable<CharSequence>)
			.assertCorrectGeneratedBodyFun("mod", "F", "new mod1.InvG()")
	}
	
	@Test def void testImportWithNoAmbiguityCode1(){
		(#[
			importedModuleMod1,
			'''module mod{
				import mod1.g
				dcl f : int
				def f := g
			}'''
		] as Iterable<CharSequence>).assertCorrectCodeGeneration("mod.F", #[1], #[1])
	}
	
	@Test def void testImportWithNoAmbiguityCode2(){
		(#[
			importedModuleMod1,
			importedModuleMod2,
			'''module mod{
				import mod1.*
				import mod2.h
				dcl f : int
				def f := g
			}'''
		] as Iterable<CharSequence>).assertCorrectCodeGeneration("mod.F", #[1], #[1])
	}
	
	@Test def void testImportFunctionWithQualifiedNameCode(){
		(#[
			importedModuleMod1,
			'''
			module mod{
				dcl f : int
				def f := mod1.g
			}
			'''
		] as Iterable<CharSequence>).assertCorrectCodeGeneration("mod.F", #[1], #[1])
	}
	
	@Test def void testNoAmbiguityWithQualifiedNameInGeneratedCode(){
		(#[
			importedModuleMod1,
			importedModuleMod2,
			'''
			module mod{
				import mod1.*
				import mod2.*
				dcl f : int
				def f := id ; mod1.g ; id
			}
			'''
		] as Iterable<CharSequence>).assertCorrectCodeGeneration("mod.F", #[1], #[1])
	}
	
	@Test def void testNoAmbiguityWithQualifiedNameInGeneratedCode1(){
		(#[
			importedModuleMod1,
			importedModuleMod2,
			'''
			module mod{
				import mod1.*
				import mod2.*
				dcl f : int
				def f := mod1.g ; mod2.g
			}
			'''
		] as Iterable<CharSequence>).assertCorrectCodeGeneration("mod.F", #[1], #[-1])
	}
	
	def private assertCorrectCodeGeneration(Iterable<CharSequence> files, String functionToTest, int[] input, int[] expectedResuslt){
		files.compile([
			val function = getCompiledClass(functionToTest).getDeclaredConstructor.newInstance
			val int[] result = function.invoke("b", input) as int[]
			result.assertArrayEquals(expectedResuslt)
		])
	}
	
	@Test def void testImportedFunctionOverrideInGeneratedCode(){
		(#[
			importedModuleMod1,
			'''
			module mod{
				import mod1.*
				dcl g : int
				def g := neg[mod1.g] 
			}
			'''
		] as Iterable<CharSequence>).assertCorrectCodeGeneration("mod.G", #[1], #[-1])
	}
	
	@Test def void prova(){
		'''
		module mod1{
			dcl f : int
			def f := id
			dcl g : int
			def g := f
		}
		'''.compile[
			getCompiledClass("mod1.G")
		]
	}
}