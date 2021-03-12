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
import static org.junit.Assert.assertArrayEquals

/*Added by Matteo Palazzo */
@RunWith(typeof(XtextRunner))
@InjectWith(typeof(YarelInjectorProvider))
class YarelIndexTest {
	
	@Inject extension ParseHelper<Model>
	@Inject extension ValidationTestHelper
	@Inject extension IScopeProvider
	@Inject extension YarelUtils
	@Inject extension YarelIndex
	@Inject extension CompilationTestHelper
	@Inject extension ReflectExtensions
	
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
		import mod1.*
		module mod2{
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
		'''
		import mod1.*
		import mod2.*
		module mod3{
			dcl g : int
			def g := f
		}
		'''.parse(mod2.eResource.resourceSet).assertError(//check that there is an error due to the ambiguity
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
		'''
		import mod1.*
		import mod2.*
		module mod3{
			dcl g : 2 int
			def g := mod1.f | mod2.f
		}
		'''.parse(mod2.eResource.resourceSet).assertNoErrors 
	}
}