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
class YarelScopeTest {
	@Inject extension ParseHelper<Model>
	@Inject extension ValidationTestHelper
	@Inject extension IScopeProvider
	@Inject extension YarelUtils
	@Inject extension YarelIndex
	@Inject extension CompilationTestHelper
	@Inject extension ReflectExtensions
	
	//Assert if the expected scope is equals to the actual one
	def private assertScope(EObject context, EReference reference, String[] expected){
		val scope = context.getScope(reference).allElements.map[name.toString]
		expected.sort.assertArrayEquals(scope.sort)
	}
	
	//Test if the scope seen in a function body is correct
	@Test def void testCorrectBodyFunScope(){
		val mod1 = 
		'''
		module mod1{
			dcl f : int
			def f := id
		}
		'''.parse
		mod1.assertNoErrors
		val mod2 = 
		'''
		import mod1.*
		module mod2{
			dcl g : int
			def g := id
		}
		'''.parse(mod1.eResource.resourceSet)
		mod2.assertNoErrors
		val mod1FDef = mod1.definitions.head.body //get the definition of f in mod1
		val mod2GDef = mod2.definitions.filter(typeof(Definition)).head.body//get the definition of g in mod2 
		mod1FDef.assertScope(YarelPackage::eINSTANCE.bodyFun_FunName, #['f', 'mod1.f', 'mod2.g'])
		mod2GDef.assertScope(YarelPackage::eINSTANCE.bodyFun_FunName, #['f', 'g', 'mod2.g', 'mod1.f'])
	}
	
	@Test def void testCorrectDefinitionScope(){
		'''
		module mod1{
			dcl f : int
			def f := id
			dcl g : int
			def g := f
		}
		'''.parse => [
			assertNoErrors
				val gDef = definitions.head
				val fDef = definitions.last
				gDef.assertScope(YarelPackage::eINSTANCE.definition_DeclarationName, #['f', 'g'])
				fDef.assertScope(YarelPackage::eINSTANCE.definition_DeclarationName, #['f', 'g'])				
		]
	}
	
	@Test def void testCorrectDefinitionScope1(){
		val mod = 
		'''
		module mod{
			dcl f : int
			def f := id
			dcl g : int
			def g := id
			dcl h : int
			def h := id
		}
		'''.parse
		mod.assertNoErrors
		'''
		import mod.f
		import mod.g
		import mod.h
		module mod1{
			dcl f : int
			def f := id
			dcl g : int
			def g := f
		}
		'''.parse(mod.eResource.resourceSet) => [
			assertNoErrors
				val gDef = definitions.head
				val fDef = definitions.last
				gDef.assertScope(YarelPackage::eINSTANCE.definition_DeclarationName, #['f', 'g'])
				fDef.assertScope(YarelPackage::eINSTANCE.definition_DeclarationName, #['f', 'g'])			
		]
	}
}