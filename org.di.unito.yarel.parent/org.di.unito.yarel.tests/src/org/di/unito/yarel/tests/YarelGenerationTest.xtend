package org.di.unito.yarel.tests

import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import java.util.ArrayList

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(YarelInjectorProvider))
class YarelGenerationTest{
	
	@Inject extension CompilationTestHelper
	@Inject extension ReflectExtensions
	
	/**
	 * Tests a simple inc function
	 * Taken from Paolo Parker. Modified by Riccardo Viola.
	 */
	@Test
	def void testFunctionInc(){
		//Code in triple quotes gets compiled by calling compile() which in turn compiles with JavaYarelGenerator
		//NOTE: if the code below has errors, the compilation doesn't even start
		'''module mod {
			dcl f: int -> int
			def f := inc
		}'''.compile([
			/* The goal here is to run the compiled class's b(ehaviour) method with java reflection
			 * to check if: 1) there are no java compilation errors
			 * 				2) the implementation of the function declared in the module actually does what it's intended to do*/
			
			//Gets the class we will be using reflection on
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			
			//parameters to be used when invoking the b(ehaviour) method
			val ArrayList<Object> x = new ArrayList<Object>()
			x.add(0)
			
			/*Invokes the b(ehaviour) method in the generated function, with a simple parameter array x which
			contains only the value 0. Since the operation is "inc", we expect this value to increase to 1.*/
			var ArrayList<Object> actualx = function.invoke("b",x) as ArrayList<Object>
			
			//actualx now contains the new parameter/s (changed after the invoke call) function in mod.f)
			assertEquals(1,actualx.get(0))
			
			//Doing the same as above for the inverse function (mod.inv_f)
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x_inv = new ArrayList<Object>()
			x_inv.add(0)
			actualx = inv_function.invoke("b",x_inv) as ArrayList<Object>
			assertEquals(-1,actualx.get(0))
			
			//Verifying that the arity of dcl f: int is actually 1 from the compiled java code
			val actualArity = function.invoke("getA")
			assertEquals(1,actualArity);
			])
	}
	
	/**
	 * Tests a simple id function with int
	 * Taken from Paolo Parker. Modified by Riccardo Viola.
	 */
	@Test
	def void testFunctionId(){
		'''module mod {
			dcl f: int -> int
			def f := id
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x = new ArrayList<Object>()
			x.add(0)
			var ArrayList<Object> actualx = function.invoke("b", x) as ArrayList<Object>
			assertEquals(0, actualx.get(0))
			
			//testing arity
			var actualArity = function.invoke("getA")
			assertEquals(1, actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x_inv = new ArrayList<Object>()
			x_inv.add(0)
			actualx = inv_function.invoke("b", x_inv) as ArrayList<Object>
			assertEquals(0, actualx.get(0))
			
			//testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(1, actualArity);
			])
	}
	
	/**
	 * Tests a simple id function with bool
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testFunctionId2(){
		'''module mod {
			dcl f: bool -> bool
			def f := id
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x = new ArrayList<Object>()
			x.add(true)
			var ArrayList<Object> actualx = function.invoke("b", x) as ArrayList<Object>
			assertEquals(true, actualx.get(0))
			
			//testing arity
			var actualArity = function.invoke("getA")
			assertEquals(1, actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x_inv = new ArrayList<Object>()
			x_inv.add(false)
			actualx = inv_function.invoke("b", x_inv) as ArrayList<Object>
			assertEquals(false, actualx.get(0))
			
			//testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(1, actualArity);
			])
	}
	
	/**
	 * Tests a simple dec function
	 * Taken from Paolo Parker. Modified by Riccardo Viola.
	 */
	@Test
	def void testFunctionDec(){
		'''module mod {
			dcl f: int -> int
			def f := dec
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x = new ArrayList<Object>()
			x.add(0)
			var ArrayList<Object> actualx = function.invoke("b", x) as ArrayList<Object>
			assertEquals(-1, actualx.get(0))
			
			var actualArity = function.invoke("getA")
			assertEquals(1, actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x_inv = new ArrayList<Object>()
			x_inv.add(0)
			actualx = inv_function.invoke("b", x_inv) as ArrayList<Object>
			assertEquals(1, actualx.get(0))
			
			actualArity = inv_function.invoke("getA")
			assertEquals(1, actualArity);
			])
	}
	
	/**
	 * Tests a simple neg function
	 * Taken from Paolo Parker. Modified by Riccardo Viola.
	 */
	@Test
	def void testFunctionNeg(){
		'''module mod {
			dcl f: int -> int
			def f := neg
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x = new ArrayList<Object>()
			x.add(5)
			var ArrayList<Object> actualx = function.invoke("b",x) as ArrayList<Object>
			assertEquals(-5,actualx.get(0))
			
			//testing arity
			var actualArity = function.invoke("getA")
			assertEquals(1,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x_inv = new ArrayList<Object>()
			x_inv.add(5)
			actualx = inv_function.invoke("b",x_inv) as ArrayList<Object>
			assertEquals(-5,actualx.get(0))
			
			//testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(1,actualArity);
			])
	}
	
	/**
	 * Tests a function with 3 serially executed primitive functions (inc and dec)
	 * Taken from Paolo Parker. Modified by Riccardo Viola.
	 */
	@Test
	def void testFunctionSerComp(){
		'''module mod {
			dcl f: int -> int
			def f := inc;dec;inc
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance

			val ArrayList<Object> x = new ArrayList<Object>()
			x.add(10)
			var ArrayList<Object> actualx = function.invoke("b",x) as ArrayList<Object>
			assertEquals(11,actualx.get(0))
			
			//testing arity
			var actualArity = function.invoke("getA")
			assertEquals(1,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x_inv = new ArrayList<Object>()
			x_inv.add(4)
			actualx = inv_function.invoke("b",x_inv) as ArrayList<Object>
			assertEquals(3,actualx.get(0))
			
			//testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(1,actualArity);
			])
	}
	
	/**
	 * Tests a function with 3 parallel-executed primitive functions (inc and dec)
	 * Taken from Paolo Parker. Modified by Riccardo Viola.
	 */
	@Test
	def void testFunctionParComp(){
		'''module mod {
			dcl f: int,int,int -> int,int,int
			def f := inc|dec|inc
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance

			val ArrayList<Object> x = new ArrayList<Object>()
			x.add(10)
			x.add(15)
			x.add(20)
			var ArrayList<Object> actualx = function.invoke("b",x) as ArrayList<Object>
			assertEquals(11,actualx.get(0))
			assertEquals(14,actualx.get(1))
			assertEquals(21,actualx.get(2))
			
			//testing arity
			var actualArity = function.invoke("getA")
			assertEquals(3,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x_inv = new ArrayList<Object>()
			x_inv.add(4)
			x_inv.add(5)
			x_inv.add(6)
			actualx = inv_function.invoke("b",x_inv) as ArrayList<Object>
			assertEquals(3,actualx.get(0))
			assertEquals(6,actualx.get(1))
			assertEquals(5,actualx.get(2))
			
			actualArity = inv_function.invoke("getA")
			assertEquals(3,actualArity);
			])
	}
	
	/**
	 * Tests a function with a simple permutation with 4 indices
	 * Taken from Paolo Parker. Modified by Riccardo Viola.
	 */
	@Test
	def void testFunctionPerm(){
		'''module mod {
			dcl f: int,int,int,int -> int,int,int,int
			def f := /2 4 3 1/
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance

			val ArrayList<Object> x = new ArrayList<Object>()
			x.add(1)
			x.add(2)
			x.add(3)
			x.add(4)
			var ArrayList<Object> actualx = function.invoke("b",x) as ArrayList<Object>
			assertEquals(2,actualx.get(0))
			assertEquals(4,actualx.get(1))
			assertEquals(3,actualx.get(2))
			assertEquals(1,actualx.get(3))
			
			//testing arity
			var actualArity = function.invoke("getA")
			assertEquals(4,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x_inv = new ArrayList<Object>()
			x_inv.add(1)
			x_inv.add(2)
			x_inv.add(3)
			x_inv.add(4)
			actualx = inv_function.invoke("b",x_inv) as ArrayList<Object>
			assertEquals(4,actualx.get(0))
			assertEquals(1,actualx.get(1))
			assertEquals(3,actualx.get(2))
			assertEquals(2,actualx.get(3))
			
			//testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(4,actualArity);
			])
	}
	
	/**
	 * Tests a function with a simple iteration loop
	 * Taken from Paolo Parker. Modified by Riccardo Viola.
	 */
	@Test
	def void testFunctionIt(){
		'''module mod {
			dcl f: int,int -> int,int
			def f := it[inc]
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			
			//testing for positive v
			val ArrayList<Object> x_pos = new ArrayList<Object>()
			x_pos.add(5)
			x_pos.add(10)
			var ArrayList<Object> actualx = function.invoke("b",x_pos) as ArrayList<Object>
			assertEquals(15,actualx.get(0))
			assertEquals(10,actualx.get(1))
			
			//testing for v = 0
			val ArrayList<Object> x_zero = new ArrayList<Object>()
			x_zero.add(5)
			x_zero.add(0)
			actualx = function.invoke("b",x_zero) as ArrayList<Object>
			assertEquals(5,actualx.get(0))
			assertEquals(0,actualx.get(1))
			
			//testing for negative v
			val ArrayList<Object> x_neg = new ArrayList<Object>()
			x_neg.add(5)
			x_neg.add(-8)
			actualx = function.invoke("b",x_neg) as ArrayList<Object>
			assertEquals(13,actualx.get(0))
			assertEquals(-8,actualx.get(1))
			
			//Testing arity
			var actualArity = function.invoke("getA")
			assertEquals(2,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			
			//testing for positive v
			val ArrayList<Object> x_invPos = new ArrayList<Object>()
			x_invPos.add(5)
			x_invPos.add(10)
			actualx = inv_function.invoke("b",x_invPos) as ArrayList<Object>
			assertEquals(-5,actualx.get(0))
			assertEquals(10,actualx.get(1))
			
			//testing for v = 0
			val ArrayList<Object> x_invZero = new ArrayList<Object>()
			x_invZero.add(5)
			x_invZero.add(0)
			actualx = inv_function.invoke("b",x_invZero) as ArrayList<Object>
			assertEquals(5,actualx.get(0))
			assertEquals(0,actualx.get(1))
			
			//testing for negative v
			val ArrayList<Object> x_invNeg = new ArrayList<Object>()
			x_invNeg.add(5)
			x_invNeg.add(-3)
			actualx = inv_function.invoke("b",x_invNeg) as ArrayList<Object>
			assertEquals(2,actualx.get(0))
			assertEquals(-3,actualx.get(1))
			
			//Testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(2,actualArity);
			])
	}
	
	/**
	 * Tests a function with a simple inverse function
	 * Taken from Paolo Parker. Modified by Riccardo Viola.
	 */
	@Test
	def void testFunctionInv(){
		'''module mod {
			dcl f: int -> int
			def f := inv[inc]
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance

			val ArrayList<Object> x = new ArrayList<Object>()
			x.add(5)
			var ArrayList<Object> actualx = function.invoke("b",x) as ArrayList<Object>
			assertEquals(4,actualx.get(0))
			
			//Testing arity
			var actualArity = function.invoke("getA")
			assertEquals(1,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x_inv = new ArrayList<Object>()
			x_inv.add(5)
			actualx = inv_function.invoke("b",x_inv) as ArrayList<Object>
			assertEquals(6,actualx.get(0))
			
			//Testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(1,actualArity);
			])
	}
	
	/**
	 * Tests a function with a simple if statement
	 * Taken from Paolo Parker. Modified by Riccardo Viola.
	 */
	@Test
	def void testFunctionIf(){
		'''module mod {
			dcl f: int,int -> int,int
			def f := if[inc,id,dec]
		}'''.compile([
			
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			
			//testing for positive v
			val ArrayList<Object> x_pos = new ArrayList<Object>()
			x_pos.add(5)
			x_pos.add(13)
			var ArrayList<Object> actualx = function.invoke("b",x_pos) as ArrayList<Object>
			assertEquals(6,actualx.get(0))
			assertEquals(13,actualx.get(1))
			
			//testing for v = 0
			val ArrayList<Object> x_zero = new ArrayList<Object>()
			x_zero.add(5)
			x_zero.add(0)
			actualx = function.invoke("b",x_zero) as ArrayList<Object>
			assertEquals(5,actualx.get(0))
			assertEquals(0,actualx.get(1))
			
			//testing for negative v
			val ArrayList<Object> x_neg = new ArrayList<Object>()
			x_neg.add(5)
			x_neg.add(-8)
			actualx = function.invoke("b",x_neg) as ArrayList<Object>
			assertEquals(4,actualx.get(0))
			assertEquals(-8,actualx.get(1))
			
			//Testing arity
			var actualArity = function.invoke("getA")
			assertEquals(2,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			
			//testing for positive v
			val ArrayList<Object> x_invPos = new ArrayList<Object>()
			x_invPos.add(5)
			x_invPos.add(13)
			actualx = inv_function.invoke("b",x_invPos) as ArrayList<Object>
			assertEquals(4,actualx.get(0))
			assertEquals(13,actualx.get(1))
			
			//testing for v = 0
			val ArrayList<Object> x_invZero = new ArrayList<Object>()
			x_invZero.add(5)
			x_invZero.add(0)
			actualx = inv_function.invoke("b",x_invZero) as ArrayList<Object>
			assertEquals(5,actualx.get(0))
			assertEquals(0,actualx.get(1))
			
			//testing for negative v
			val ArrayList<Object> x_invNeg = new ArrayList<Object>()
			x_invNeg.add(5)
			x_invNeg.add(-3)
			actualx = inv_function.invoke("b",x_invNeg) as ArrayList<Object>
			assertEquals(6,actualx.get(0))
			assertEquals(-3,actualx.get(1))
			
			//Testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(2,actualArity);
			])
	}
	
	/**
	 * Tests a simple not function
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testFunctionNot(){
		'''module mod {
			dcl f: bool -> bool
			def f := not
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance			
			val ArrayList<Object> x = new ArrayList<Object>()
			x.add(false)
			var ArrayList<Object> actualx = function.invoke("b", x) as ArrayList<Object>
			assertEquals(true, actualx.get(0))
			
			//testing arity
			var actualArity = function.invoke("getA")
			assertEquals(1, actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x_inv = new ArrayList<Object>()
			x_inv.add(true)
			actualx = inv_function.invoke("b", x_inv) as ArrayList<Object>
			assertEquals(false, actualx.get(0))
			
			//testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(1, actualArity);
			])
	}
	
	/**
	 * Tests a simple tof function
	 * Added by Riccardo Viola.
	 */
	@Test
	def void testFunctionTof(){
		'''module mod {
			dcl f: 3 bool -> 3 bool
			def f := tof
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x = new ArrayList<Object>()
			x.add(true)
			x.add(true)
			x.add(false)
			var ArrayList<Object> actualx = function.invoke("b", x) as ArrayList<Object>
			assertEquals(true, actualx.get(0))
			assertEquals(true, actualx.get(1))
			assertEquals(true, actualx.get(2))
			
			//testing arity
			var actualArity = function.invoke("getA")
			assertEquals(3, actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val ArrayList<Object> x_inv = new ArrayList<Object>()
			x_inv.add(true)
			x_inv.add(true)
			x_inv.add(true)
			actualx = inv_function.invoke("b", x_inv) as ArrayList<Object>
			assertEquals(true, actualx.get(0))
			assertEquals(true, actualx.get(1))
			assertEquals(false, actualx.get(2))
			
			//testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(3, actualArity);
			])
	}
	
}