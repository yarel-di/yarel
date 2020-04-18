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
import org.junit.Before
import org.di.unito.yarel.yarel.YarelPackage
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import static extension org.junit.Assert.assertEquals
import org.di.unito.yarel.utils.YarelUtils

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(YarelInjectorProvider))
class YarelImportTest {
	
	@Inject extension ParseHelper<Model>
	@Inject extension ValidationTestHelper
	@Inject extension IScopeProvider
	@Inject extension YarelUtils
	
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
}