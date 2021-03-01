package parametricStuffs;
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
* <li> {@link parametricStuffs.ShiftLastToFirstK}</li>
* <li> {@link parametricStuffs.ShiftFirstToLastK}</li>
* <li> {@link parametricStuffs.ParamSum}</li>
* <li> {@link parametricStuffs.NegativeParamWarning}</li>
* <li> {@link parametricStuffs.Hello}</li>
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
public class ParametricStuffsPlayWith {
	
	public static void main(String[] args) throws Exception {
		testShiftLastToFirstK();
		
		testShiftFirstToLastK();
		
		testParamSum();
		
		testNegativeParamWarning();
		
		testHello();
	}
	
	//
	
	public static void testShiftLastToFirstK(){
		RPP shiftLastToFirstKRPP = new parametricStuffs.ShiftLastToFirstK();
		final int[][] datasets = {
			new int[]{1,5},
			new int[]{1,5},
			new int[]{ 0,  0},
			new int[]{ 1,  1},
			new int[]{ -1,  -1},
			new int[]{ 2,  2},
			new int[]{ -2,  -2},
			new int[]{ 3,  3},
			new int[]{ -3,  -3},
			new int[]{ 4,  4},
			new int[]{ -4,  -4},
			new int[]{ 10,  10},
			new int[]{ -10,  -10},
			new int[]{ 11,  11},
			new int[]{ -11,  -11},
		};
		for( int[] data: datasets ){
			System.out.println("\nTesting the function shiftLastToFirstK with values:" + Arrays.toString(data));
			shiftLastToFirstKRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testShiftFirstToLastK(){
		RPP shiftFirstToLastKRPP = new parametricStuffs.ShiftFirstToLastK();
		final int[][] datasets = {
			new int[]{1,5},
			new int[]{1,5},
			new int[]{ 0,  0},
			new int[]{ 1,  1},
			new int[]{ -1,  -1},
			new int[]{ 2,  2},
			new int[]{ -2,  -2},
			new int[]{ 3,  3},
			new int[]{ -3,  -3},
			new int[]{ 4,  4},
			new int[]{ -4,  -4},
			new int[]{ 10,  10},
			new int[]{ -10,  -10},
			new int[]{ 11,  11},
			new int[]{ -11,  -11},
		};
		for( int[] data: datasets ){
			System.out.println("\nTesting the function shiftFirstToLastK with values:" + Arrays.toString(data));
			shiftFirstToLastKRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testParamSum(){
		RPP paramSumRPP = new parametricStuffs.ParamSum();
		final int[][] datasets = {
			new int[]{1,5},
			new int[]{1,5},
			new int[]{ 0,  0},
			new int[]{ 1,  1},
			new int[]{ -1,  -1},
			new int[]{ 2,  2},
			new int[]{ -2,  -2},
			new int[]{ 3,  3},
			new int[]{ -3,  -3},
			new int[]{ 4,  4},
			new int[]{ -4,  -4},
			new int[]{ 10,  10},
			new int[]{ -10,  -10},
			new int[]{ 11,  11},
			new int[]{ -11,  -11},
		};
		for( int[] data: datasets ){
			System.out.println("\nTesting the function paramSum with values:" + Arrays.toString(data));
			paramSumRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testNegativeParamWarning(){
		RPP negativeParamWarningRPP = new parametricStuffs.NegativeParamWarning();
		final int[][] datasets = {
			new int[]{1,5},
			new int[]{1,5},
			new int[]{ 0,  0},
			new int[]{ 1,  1},
			new int[]{ -1,  -1},
			new int[]{ 2,  2},
			new int[]{ -2,  -2},
			new int[]{ 3,  3},
			new int[]{ -3,  -3},
			new int[]{ 4,  4},
			new int[]{ -4,  -4},
			new int[]{ 10,  10},
			new int[]{ -10,  -10},
			new int[]{ 11,  11},
			new int[]{ -11,  -11},
		};
		for( int[] data: datasets ){
			System.out.println("\nTesting the function negativeParamWarning with values:" + Arrays.toString(data));
			negativeParamWarningRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testHello(){
		RPP helloRPP = new parametricStuffs.Hello();
		final int[][] datasets = {
			new int[]{5},
			new int[]{5},
			new int[]{ 0},
			new int[]{ 1},
			new int[]{ -1},
			new int[]{ 2},
			new int[]{ -2},
			new int[]{ 3},
			new int[]{ -3},
			new int[]{ 4},
			new int[]{ -4},
			new int[]{ 10},
			new int[]{ -10},
			new int[]{ 11},
			new int[]{ -11},
		};
		for( int[] data: datasets ){
			System.out.println("\nTesting the function hello with values:" + Arrays.toString(data));
			helloRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
}
