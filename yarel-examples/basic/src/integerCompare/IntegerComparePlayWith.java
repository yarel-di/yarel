package integerCompare;
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
* <li> {@link integerCompare.SameSignLess}</li>
* <li> {@link integerCompare.SameSignMore}</li>
* <li> {@link integerCompare.DupStep}</li>
* <li> {@link integerCompare.Less}</li>
* <li> {@link integerCompare.More}</li>
* <li> {@link integerCompare.SameSignCompare}</li>
* <li> {@link integerCompare.Compare}</li>
* <li> {@link integerCompare.CompareOverflowUnsafe}</li>
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
public class IntegerComparePlayWith {
	
	public static void main(String[] args) throws Exception {
		testSameSignLess();
		
		testSameSignMore();
		
		testDupStep();
		
		testLess();
		
		testMore();
		
		testSameSignCompare();
		
		testCompare();
		
		testCompareOverflowUnsafe();
	}
	
	//
	
	public static void testSameSignLess(){
		RPP sameSignLessRPP = new integerCompare.SameSignLess();
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
			System.out.println("\nTesting the function sameSignLess with values:" + Arrays.toString(data));
			sameSignLessRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSameSignMore(){
		RPP sameSignMoreRPP = new integerCompare.SameSignMore();
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
			System.out.println("\nTesting the function sameSignMore with values:" + Arrays.toString(data));
			sameSignMoreRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testDupStep(){
		RPP dupStepRPP = new integerCompare.DupStep();
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
			System.out.println("\nTesting the function dupStep with values:" + Arrays.toString(data));
			dupStepRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testLess(){
		RPP lessRPP = new integerCompare.Less();
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
			System.out.println("\nTesting the function less with values:" + Arrays.toString(data));
			lessRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testMore(){
		RPP moreRPP = new integerCompare.More();
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
			System.out.println("\nTesting the function more with values:" + Arrays.toString(data));
			moreRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSameSignCompare(){
		RPP sameSignCompareRPP = new integerCompare.SameSignCompare();
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
			System.out.println("\nTesting the function sameSignCompare with values:" + Arrays.toString(data));
			sameSignCompareRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testCompare(){
		RPP compareRPP = new integerCompare.Compare();
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
			System.out.println("\nTesting the function compare with values:" + Arrays.toString(data));
			compareRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testCompareOverflowUnsafe(){
		RPP compareOverflowUnsafeRPP = new integerCompare.CompareOverflowUnsafe();
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
			System.out.println("\nTesting the function compareOverflowUnsafe with values:" + Arrays.toString(data));
			compareOverflowUnsafeRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
}
