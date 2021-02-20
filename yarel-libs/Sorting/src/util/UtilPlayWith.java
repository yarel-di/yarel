package util;
import yarelcore.*;
import java.util.Arrays;

/**
 * Automatically generated usage class.<p>
 *
 * This is a draft, providing examples of instantiation and usage and invocation,
 * in a Java context, of the functions/operators written in Yarel. <br>
 * In further developments, this will be a JUnit class.<br>
 * For instance, currently this tests looks like:
 * <pre><code>
 	int[] data = {8 3 0 0 0};
 	RPP op = new Some_5ary_Operator();
 	op.b(data);
 * </pre></code>
 * For further informations, check the documentation:
 * <ul>
 * <li> {@link RPP}</li>
* <li> {@link util.Dup}</li>
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
public class UtilPlayWith {
	
	public static void main(String[] args) throws Exception {
		testDup();
	}
	
	//
	
	public static void testDup(){
		RPP dupRPP = new util.Dup();
		final int[][] datasets = {
			new int[]{1,2,5},
			new int[]{2,1,5},
			new int[]{ 0,  0,  0},
			new int[]{ 1,  1,  1},
			new int[]{ -1,  -1,  -1},
			new int[]{ 2,  2,  2},
			new int[]{ -2,  -2,  -2},
			new int[]{ 3,  3,  3},
			new int[]{ -3,  -3,  -3},
			new int[]{ 4,  4,  4},
			new int[]{ -4,  -4,  -4},
			new int[]{ 10,  10,  10},
			new int[]{ -10,  -10,  -10},
			new int[]{ 11,  11,  11},
			new int[]{ -11,  -11,  -11},
		};
		for( int[] data: datasets ){
			System.out.println("\nTesting the function dup with values:" + Arrays.toString(data));
			dupRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
}
