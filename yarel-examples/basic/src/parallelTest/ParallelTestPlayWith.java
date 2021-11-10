package parallelTest;
import yarelcore.*;
import java.util.Arrays;
import java.math.BigInteger;

/**
 * Automatically generated usage class.<p>
 *
 * This is a draft, providing examples of instantiation and usage and invocation,
 * in a Java context, of the functions/operators written in Yarel. <br>
 * In further developments, this will be a JUnit class.<br>
 * For instance, currently this tests looks like:
 * <pre><code>
 	BigInteger[] data = {8 3 0 0 0};
 	RPP op = new Some_5ary_Operator();
 	op.b(data);
 * </pre></code>
 * For further informations, check the documentation:
 * <ul>
 * <li> {@link RPP}</li>
* <li> {@link parallelTest.To_odd}</li>
* <li> {@link parallelTest.BiIncPar}</li>
* <li> {@link parallelTest.TriIncPar}</li>
* <li> {@link parallelTest.TriIncParExplicit}</li>
* <li> {@link parallelTest.EsaIncParExplicit}</li>
* <li> {@link parallelTest.Mult}</li>
* <li> {@link parallelTest.UpAndDown}</li>
* <li> {@link parallelTest.SomeSwaps}</li>
* <li> {@link parallelTest.SomeAtomicStuffs}</li>
* <li> {@link parallelTest.ILikeParallelism}</li>
* <li> {@link parallelTest.LargePermutation}</li>
* <li> {@link parallelTest.RearrangeLargePerm}</li>
* <li> {@link parallelTest.Empty2}</li>
* <li> {@link parallelTest.Empty3}</li>
* <li> {@link parallelTest.AnotherOneIncInTheDust}</li>
* <li> {@link parallelTest.OneDecInMiddle}</li>
* <li> {@link parallelTest.OneNegAtStart}</li>
* <li> {@link parallelTest.WastingSomeID}</li>
* <li> {@link parallelTest.CosmicVoid}</li>
* <li> {@link parallelTest.VeryAloneInc}</li>
* <li> {@link parallelTest.OneHoleInIds}</li>
* <li> {@link parallelTest.ThreeHoleInIds}</li>
 * </ul>
 * <p>
 *
 * NOTE:<br>
 * The following "usages" not tests, they are just invocations over a pre-determined dataset
 * that requires to be manually observed and verified and has currently nothing related
 * with the "semantic"/meaning/functionality of the executed operator. That means that the
 * inputs and the outputs are currently "static" and unrelated with the expected inputs and outputs
 * of the functions. (This is a "further development".)<br>
 * For instance, an operator could expect to receive some registers as input values and others
 * as 0-ancillae or 1-ancillae (or "truth-pair"). <br>
 * Currently, that information cannot be provided in this current version of the Yarel language,
 * so some automatic validation, formal or informal, cannot be performed.<br>
 * In short, <strong>You</strong>, the programmer, has to run the class, read the console output
 * and see the results.
 * <p>
 * TL;DR:<p>
 * This class is, or presents: <br>
 * <ul>
 * <li>Instantiation and invocation of the compiled {@link RPP} subclasses.</li>
 * <li>Those instances runs on meaningless example data.</li>
 * <li>Manual check required by <strong>You</strong> yourself by <italic>reading</italic> the <code>console output</code></li>
 * <li><i>Wanna-be</i> JUnit</li>
 * </ul>
*/
public class ParallelTestPlayWith {
	
	public static void main(String[] args) throws Exception {
		testTo_odd();
		
		testBiIncPar();
		
		testTriIncPar();
		
		testTriIncParExplicit();
		
		testEsaIncParExplicit();
		
		testMult();
		
		testUpAndDown();
		
		testSomeSwaps();
		
		testSomeAtomicStuffs();
		
		testILikeParallelism();
		
		testLargePermutation();
		
		testRearrangeLargePerm();
		
		testEmpty2();
		
		testEmpty3();
		
		testAnotherOneIncInTheDust();
		
		testOneDecInMiddle();
		
		testOneNegAtStart();
		
		testWastingSomeID();
		
		testCosmicVoid();
		
		testVeryAloneInc();
		
		testOneHoleInIds();
		
		testThreeHoleInIds();
	}
	
	//
	
	public static void testTo_odd(){
		RPP to_oddRPP = new parallelTest.To_odd();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function to_odd with values:" + Arrays.toString(data));
			to_oddRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testBiIncPar(){
		RPP biIncParRPP = new parallelTest.BiIncPar();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function biIncPar with values:" + Arrays.toString(data));
			biIncParRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testTriIncPar(){
		RPP triIncParRPP = new parallelTest.TriIncPar();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function triIncPar with values:" + Arrays.toString(data));
			triIncParRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testTriIncParExplicit(){
		RPP triIncParExplicitRPP = new parallelTest.TriIncParExplicit();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function triIncParExplicit with values:" + Arrays.toString(data));
			triIncParExplicitRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testEsaIncParExplicit(){
		RPP esaIncParExplicitRPP = new parallelTest.EsaIncParExplicit();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(4),BigInteger.valueOf(5),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(5),BigInteger.valueOf(4),BigInteger.valueOf(3),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function esaIncParExplicit with values:" + Arrays.toString(data));
			esaIncParExplicitRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testMult(){
		RPP multRPP = new parallelTest.Mult();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function mult with values:" + Arrays.toString(data));
			multRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testUpAndDown(){
		RPP upAndDownRPP = new parallelTest.UpAndDown();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(3),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function upAndDown with values:" + Arrays.toString(data));
			upAndDownRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSomeSwaps(){
		RPP someSwapsRPP = new parallelTest.SomeSwaps();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(4),BigInteger.valueOf(5),BigInteger.valueOf(6),BigInteger.valueOf(7),BigInteger.valueOf(8),BigInteger.valueOf(9),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(9),BigInteger.valueOf(8),BigInteger.valueOf(7),BigInteger.valueOf(6),BigInteger.valueOf(5),BigInteger.valueOf(4),BigInteger.valueOf(3),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function someSwaps with values:" + Arrays.toString(data));
			someSwapsRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSomeAtomicStuffs(){
		RPP someAtomicStuffsRPP = new parallelTest.SomeAtomicStuffs();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(4),BigInteger.valueOf(5),BigInteger.valueOf(6),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(6),BigInteger.valueOf(5),BigInteger.valueOf(4),BigInteger.valueOf(3),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function someAtomicStuffs with values:" + Arrays.toString(data));
			someAtomicStuffsRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testILikeParallelism(){
		RPP iLikeParallelismRPP = new parallelTest.ILikeParallelism();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(4),BigInteger.valueOf(5),BigInteger.valueOf(6),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(6),BigInteger.valueOf(5),BigInteger.valueOf(4),BigInteger.valueOf(3),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function iLikeParallelism with values:" + Arrays.toString(data));
			iLikeParallelismRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testLargePermutation(){
		RPP largePermutationRPP = new parallelTest.LargePermutation();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(4),BigInteger.valueOf(5),BigInteger.valueOf(6),BigInteger.valueOf(7),BigInteger.valueOf(8),BigInteger.valueOf(9),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(9),BigInteger.valueOf(8),BigInteger.valueOf(7),BigInteger.valueOf(6),BigInteger.valueOf(5),BigInteger.valueOf(4),BigInteger.valueOf(3),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function largePermutation with values:" + Arrays.toString(data));
			largePermutationRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testRearrangeLargePerm(){
		RPP rearrangeLargePermRPP = new parallelTest.RearrangeLargePerm();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(4),BigInteger.valueOf(5),BigInteger.valueOf(6),BigInteger.valueOf(7),BigInteger.valueOf(8),BigInteger.valueOf(9),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(9),BigInteger.valueOf(8),BigInteger.valueOf(7),BigInteger.valueOf(6),BigInteger.valueOf(5),BigInteger.valueOf(4),BigInteger.valueOf(3),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function rearrangeLargePerm with values:" + Arrays.toString(data));
			rearrangeLargePermRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testEmpty2(){
		RPP empty2RPP = new parallelTest.Empty2();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function empty2 with values:" + Arrays.toString(data));
			empty2RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testEmpty3(){
		RPP empty3RPP = new parallelTest.Empty3();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function empty3 with values:" + Arrays.toString(data));
			empty3RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testAnotherOneIncInTheDust(){
		RPP anotherOneIncInTheDustRPP = new parallelTest.AnotherOneIncInTheDust();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function anotherOneIncInTheDust with values:" + Arrays.toString(data));
			anotherOneIncInTheDustRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testOneDecInMiddle(){
		RPP oneDecInMiddleRPP = new parallelTest.OneDecInMiddle();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function oneDecInMiddle with values:" + Arrays.toString(data));
			oneDecInMiddleRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testOneNegAtStart(){
		RPP oneNegAtStartRPP = new parallelTest.OneNegAtStart();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function oneNegAtStart with values:" + Arrays.toString(data));
			oneNegAtStartRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testWastingSomeID(){
		RPP wastingSomeIDRPP = new parallelTest.WastingSomeID();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(4),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(4),BigInteger.valueOf(3),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function wastingSomeID with values:" + Arrays.toString(data));
			wastingSomeIDRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testCosmicVoid(){
		RPP cosmicVoidRPP = new parallelTest.CosmicVoid();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(4),BigInteger.valueOf(5),BigInteger.valueOf(6),BigInteger.valueOf(7),BigInteger.valueOf(8),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(8),BigInteger.valueOf(7),BigInteger.valueOf(6),BigInteger.valueOf(5),BigInteger.valueOf(4),BigInteger.valueOf(3),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function cosmicVoid with values:" + Arrays.toString(data));
			cosmicVoidRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testVeryAloneInc(){
		RPP veryAloneIncRPP = new parallelTest.VeryAloneInc();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(4),BigInteger.valueOf(5),BigInteger.valueOf(6),BigInteger.valueOf(7),BigInteger.valueOf(8),BigInteger.valueOf(9),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(9),BigInteger.valueOf(8),BigInteger.valueOf(7),BigInteger.valueOf(6),BigInteger.valueOf(5),BigInteger.valueOf(4),BigInteger.valueOf(3),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function veryAloneInc with values:" + Arrays.toString(data));
			veryAloneIncRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testOneHoleInIds(){
		RPP oneHoleInIdsRPP = new parallelTest.OneHoleInIds();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(4),BigInteger.valueOf(5),BigInteger.valueOf(6),BigInteger.valueOf(7),BigInteger.valueOf(8),BigInteger.valueOf(9),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(9),BigInteger.valueOf(8),BigInteger.valueOf(7),BigInteger.valueOf(6),BigInteger.valueOf(5),BigInteger.valueOf(4),BigInteger.valueOf(3),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function oneHoleInIds with values:" + Arrays.toString(data));
			oneHoleInIdsRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testThreeHoleInIds(){
		RPP threeHoleInIdsRPP = new parallelTest.ThreeHoleInIds();
		final BigInteger[][] datasets = {
			new BigInteger[]{BigInteger.valueOf(1),BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(4),BigInteger.valueOf(5),BigInteger.valueOf(6),BigInteger.valueOf(7),BigInteger.valueOf(8),BigInteger.valueOf(9),BigInteger.valueOf(10),BigInteger.valueOf(11),BigInteger.valueOf(12),BigInteger.valueOf(5)},
			new BigInteger[]{BigInteger.valueOf(12),BigInteger.valueOf(11),BigInteger.valueOf(10),BigInteger.valueOf(9),BigInteger.valueOf(8),BigInteger.valueOf(7),BigInteger.valueOf(6),BigInteger.valueOf(5),BigInteger.valueOf(4),BigInteger.valueOf(3),BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(5)},
			new BigInteger[]{ BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0),  BigInteger.valueOf(0)},
			new BigInteger[]{ BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1),  BigInteger.valueOf(1)},
			new BigInteger[]{ BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1),  BigInteger.valueOf(-1)},
			new BigInteger[]{ BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2),  BigInteger.valueOf(2)},
			new BigInteger[]{ BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2),  BigInteger.valueOf(-2)},
			new BigInteger[]{ BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3),  BigInteger.valueOf(3)},
			new BigInteger[]{ BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3),  BigInteger.valueOf(-3)},
			new BigInteger[]{ BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4),  BigInteger.valueOf(4)},
			new BigInteger[]{ BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4),  BigInteger.valueOf(-4)},
			new BigInteger[]{ BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10),  BigInteger.valueOf(10)},
			new BigInteger[]{ BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10),  BigInteger.valueOf(-10)},
			new BigInteger[]{ BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11),  BigInteger.valueOf(11)},
			new BigInteger[]{ BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11),  BigInteger.valueOf(-11)},
		};
		for( BigInteger[] data: datasets ){
			System.out.println("\nTesting the function threeHoleInIds with values:" + Arrays.toString(data));
			threeHoleInIdsRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
}
