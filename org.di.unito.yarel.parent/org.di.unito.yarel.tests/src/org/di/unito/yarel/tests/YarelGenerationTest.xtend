/*Added by Paolo Parker*/
package org.di.unito.yarel.tests

import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(YarelInjectorProvider))
class YarelGenerationTest 
{
	@Inject extension CompilationTestHelper
	@Inject extension ReflectExtensions
	
 	@Test
	def void testFunctionInc()
	{
		//Code in triple quotes gets compiled by calling compile() which in turn compiles with JavaYarelGenerator
		//NOTE: if the code below has errors, the compilation doesn't even start
		'''module mod
		{
			dcl f: int
			def f := inc
		}'''.compile([
			/* The goal here is to run the compiled class's b(ehaviour) method with java reflection
			 * to check if: 1) there are no java compilation errors
			 * 				2) the implementation of the function declared in the module actually does what it's intended to do*/
			
			//Gets the class we will be using reflection on
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			
			//parameters to be used when invoking the b(ehaviour) method
			val int[] x = #[0]
			
			/*Invokes the b(ehaviour) method in the generated function, with a simple parameter array x which
			contains only the value 0. Since the operation is "inc", we expect this value to increase to 1.*/
			var int[] actualx = function.invoke("b",x) as int[]
			
			//actualx now contains the new parameter/s (changed after the invoke call) function in mod.f)
			assertEquals(1,actualx.get(0))
			
			//Doing the same as above for the inverse function (mod.inv_f)
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val int[] x_inv = #[0]
			actualx = inv_function.invoke("b",x_inv) as int[]
			assertEquals(-1,actualx.get(0))
			
			//Verifying that the arity of dcl f: int is actually 1 from the compiled java code
			val actualArity = function.invoke("getA")
			assertEquals(1,actualArity);
			])
	}
	
	/*Each following test can be understood by reading the comments in the test above, because
	they all have the same structure.*/
	
	//Tests a simple dec function
	@Test
	def void testFunctionDec()
	{
		'''module mod
		{
			dcl f: int
			def f := dec
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			val int[] x = #[0]
			var int[] actualx = function.invoke("b",x) as int[]
			assertEquals(-1,actualx.get(0))
			
			var actualArity = function.invoke("getA")
			assertEquals(1,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val int[] x_inv = #[0]
			actualx = inv_function.invoke("b",x_inv) as int[]
			assertEquals(1,actualx.get(0))
			
			actualArity = inv_function.invoke("getA")
			assertEquals(1,actualArity);
			])
	}
	
	//Tests a simple id function
	@Test
	def void testFunctionId()
	{
		'''module mod
		{
			dcl f: int
			def f := id
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			val int[] x = #[0]
			var int[] actualx = function.invoke("b",x) as int[]
			assertEquals(0,actualx.get(0))
			
			//testing arity
			var actualArity = function.invoke("getA")
			assertEquals(1,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val int[] x_inv = #[0]
			actualx = inv_function.invoke("b",x_inv) as int[]
			assertEquals(0,actualx.get(0))
			
			//testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(1,actualArity);
			])
	}
	
	//Tests a simple neg function
	@Test
	def void testFunctionNeg()
	{
		'''module mod
		{
			dcl f: int
			def f := neg
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			val int[] x = #[5]
			var int[] actualx = function.invoke("b",x) as int[]
			assertEquals(-5,actualx.get(0))
			
			//testing arity
			var actualArity = function.invoke("getA")
			assertEquals(1,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val int[] x_inv = #[5]
			actualx = inv_function.invoke("b",x_inv) as int[]
			assertEquals(-5,actualx.get(0))
			
			//testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(1,actualArity);
			])
	}
	
	//Tests a function with 3 serially executed primitive functions (inc and dec)
	@Test
	def void testFunctionSerComp()
	{
		'''module mod
		{
			dcl f: int
			def f := inc;dec;inc
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			println(getGeneratedCode("mod.f"))
			val int[] x = #[10]
			var int[] actualx = function.invoke("b",x) as int[]
			assertEquals(11,actualx.get(0))
			
			//testing arity
			var actualArity = function.invoke("getA")
			assertEquals(1,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val int[] x_inv = #[4]
			actualx = inv_function.invoke("b",x_inv) as int[]
			assertEquals(3,actualx.get(0))
			
			//testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(1,actualArity);
			])
	}
	
	//Tests a function with 3 parallel-executed primitive functions (inc and dec)
	@Test
	def void testFunctionParComp()
	{
		'''module mod
		{
			dcl f: int,int,int
			def f := inc|dec|inc
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			println(getGeneratedCode("mod.f"))
			val int[] x = #[10,15,20]
			var int[] actualx = function.invoke("b",x) as int[]
			var int[] expectedx = #[11,14,21]
			assertArrayEquals(expectedx,actualx)
			
			//testing arity
			var actualArity = function.invoke("getA")
			assertEquals(3,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val int[] x_inv = #[4,5,6]
			actualx = inv_function.invoke("b",x_inv) as int[]
			expectedx = #[3,6,5]
			assertArrayEquals(expectedx,actualx)
			
			actualArity = inv_function.invoke("getA")
			assertEquals(3,actualArity);
			])
	}
	
	//Tests a function with a simple permutation with 4 indices
	@Test
	def void testFunctionPerm()
	{
		'''module mod
		{
			dcl f: int,int,int,int
			def f := /2 4 3 1/
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			println(getGeneratedCode("mod.f"))
			val int[] x = #[1,2,3,4]
			var int[] actualx = function.invoke("b",x) as int[]
			var int[] expectedx = #[2,4,3,1]
			assertArrayEquals(expectedx,actualx)
			
			//testing arity
			var actualArity = function.invoke("getA")
			assertEquals(4,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val int[] x_inv = #[1,2,3,4]
			actualx = inv_function.invoke("b",x_inv) as int[]
			expectedx = #[4,1,3,2]
			assertArrayEquals(expectedx,actualx)
			
			//testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(4,actualArity);
			])
	}
	
	//Various tests for the iteration (it)
	@Test
	def void testFunctionIt()
	{
		//Testing the iteration based on its definition v = 0 (ITZ)
		'''module mod
		{
			dcl premise: int,int /* Premise of the rule ITZ */
		        def premise := (id|id)
		
			dcl conclusion: int,int /* Conlcusion of the rule ITZ */
		        def conclusion := it[inc]
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val premise = getCompiledClass("mod.premise").getDeclaredConstructor.newInstance
		 	val conclusion = getCompiledClass("mod.conclusion").getDeclaredConstructor.newInstance
			
		 	val int[] input = #[5,0]
			var int[] outputOfPremise = premise.invoke("b",input) as int[]
			var int[] outputOfConclusion = conclusion.invoke("b",input) as int[]
			assertArrayEquals(premise.invoke("b",input) as int[],outputOfConclusion)
		])
		
		//Testing the iteration based on its definition for positive v (ITG)
		'''module mod
		{
			dcl premise: int,int /* Premise of the rule ITG */
		        def premise := (inc|dec);it[inc];(id|inc)
		
			dcl conclusion: int,int /* Conlcusion of the rule ITG */
		        def conclusion := it[inc]
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val premise = getCompiledClass("mod.premise").getDeclaredConstructor.newInstance
		 	val conclusion = getCompiledClass("mod.conclusion").getDeclaredConstructor.newInstance
			
		 	val int[] input = #[5,10]
			var int[] outputOfPremise = premise.invoke("b",input) as int[]
			var int[] outputOfConclusion = conclusion.invoke("b",input) as int[]
			assertArrayEquals(outputOfPremise,outputOfConclusion)
		])
		
		//Testing the iteration based on its definition for negative v (ITS)
		'''module mod
		{
			dcl premise: int,int /* Premise of the rule ITS */
		        def premise := (inc|inc);it[inc];(id|dec)
		
			dcl conclusion: int,int /* Conlcusion of the rule ITS */
		        def conclusion := it[inc]
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val premise = getCompiledClass("mod.premise").getDeclaredConstructor.newInstance
		 	val conclusion = getCompiledClass("mod.conclusion").getDeclaredConstructor.newInstance
			
		 	val int[] input = #[5,-10]
			var int[] outputOfPremise = premise.invoke("b",input) as int[]
			var int[] outputOfConclusion = conclusion.invoke("b",input) as int[]
			assertArrayEquals(outputOfPremise,outputOfConclusion)
		])
	}
	
	@Test
	def void testFunctionFor()
	{
		
		//Testing the for loop based on its definition v = 0
		'''module mod
		{
			dcl premise: int,int
		        def premise := (id|id)
		
			dcl conclusion: int,int
		        def conclusion := for[inc]
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val premise = getCompiledClass("mod.premise").getDeclaredConstructor.newInstance
		 	val conclusion = getCompiledClass("mod.conclusion").getDeclaredConstructor.newInstance
			
		 	val int[] input = #[5,0]
			var int[] outputOfPremise = premise.invoke("b",input) as int[]
			var int[] outputOfConclusion = conclusion.invoke("b",input) as int[]
			assertArrayEquals(outputOfPremise,outputOfConclusion)
		])
		
		//Testing the for loop based on its definition for positive v
		'''module mod
		{
			dcl premise: int,int
		        def premise := (inc|dec);for[inc];(id|inc)
		
			dcl conclusion: int,int
		        def conclusion := for[inc]
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val premise = getCompiledClass("mod.premise").getDeclaredConstructor.newInstance
		 	val conclusion = getCompiledClass("mod.conclusion").getDeclaredConstructor.newInstance
			
		 	val int[] input = #[5,10]
			var int[] outputOfPremise = premise.invoke("b",input) as int[]
			var int[] outputOfConclusion = conclusion.invoke("b",input) as int[]
			assertArrayEquals(outputOfPremise,outputOfConclusion)
		])
		
		//Testing the for loop based on its definition for negative v
		'''module mod
		{
			dcl premise: int,int
		        def premise := (inv[inc]|inc);for[inc];(id|dec)
		
			dcl conclusion: int,int
		        def conclusion := for[inc]
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val premise = getCompiledClass("mod.premise").getDeclaredConstructor.newInstance
		 	val conclusion = getCompiledClass("mod.conclusion").getDeclaredConstructor.newInstance
			
		 	val int[] input = #[5,-10]
			var int[] outputOfPremise = premise.invoke("b",input) as int[]
			var int[] outputOfConclusion = conclusion.invoke("b",input) as int[]
			assertArrayEquals(outputOfPremise,outputOfConclusion)
		])
	}
	
	//Tests a function with a simple inverse function
	@Test
	def void testFunctionInv()
	{
		'''module mod
		{
			dcl f: int
			def f := inv[inc]
		}'''.compile([
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			println(getGeneratedCode("mod.f"))
			val int[] x = #[5]
			var int[] actualx = function.invoke("b",x) as int[]
			assertEquals(4,actualx.get(0))
			
			//Testing arity
			var actualArity = function.invoke("getA")
			assertEquals(1,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			val int[] x_inv = #[5]
			actualx = inv_function.invoke("b",x_inv) as int[]
			assertEquals(6,actualx.get(0))
			
			//Testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(1,actualArity);
			])
	}
	
	//Tests a function with a simple if statement
	@Test
	def void testFunctionIf()
	{
		'''module mod
		{
			dcl f: int,int
			def f := if[inc,id,dec]
		}'''.compile([
			
			//----------------REGULAR FUNCTION-----------------
			val function = getCompiledClass("mod.f").getDeclaredConstructor.newInstance
			println(getGeneratedCode("mod.f"))
			
			//testing for positive v
			val int[] x_pos = #[5,13]
			var int[] actualx = function.invoke("b",x_pos) as int[]
			var int[] expectedx = #[6,13]
			assertArrayEquals(expectedx,actualx)
			
			//testing for v = 0
			val int[] x_zero = #[5,0]
			actualx = function.invoke("b",x_zero) as int[]
			expectedx = #[5,0]
			assertArrayEquals(expectedx,actualx)
			
			//testing for negative v
			val int[] x_neg = #[5,-8]
			actualx = function.invoke("b",x_neg) as int[]
			expectedx = #[4,-8]
			assertArrayEquals(expectedx,actualx)
			
			//Testing arity
			var actualArity = function.invoke("getA")
			assertEquals(2,actualArity);
			
			//----------------INVERSE FUNCTION-----------------
			val inv_function = getCompiledClass("mod.inv_f").getDeclaredConstructor.newInstance
			
			//testing for positive v
			val int[] x_invPos = #[5,13]
			actualx = inv_function.invoke("b",x_invPos) as int[]
			expectedx = #[4,13]
			assertArrayEquals(expectedx,actualx)
			
			//testing for v = 0
			val int[] x_invZero = #[5,0]
			actualx = inv_function.invoke("b",x_invZero) as int[]
			expectedx = #[5,0]
			assertArrayEquals(expectedx,actualx)
			
			//testing for negative v
			val int[] x_invNeg = #[5,-3]
			actualx = inv_function.invoke("b",x_invNeg) as int[]
			expectedx = #[6,-3]
			assertArrayEquals(expectedx,actualx)
			
			//Testing arity
			actualArity = inv_function.invoke("getA")
			assertEquals(2,actualArity);
			])
	}
}