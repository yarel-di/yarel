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
* <li> {@link parametricStuffs.ShiftLastToFirstK_OLD}</li>
* <li> {@link parametricStuffs.ShiftFirstToLastK_OLD}</li>
* <li> {@link parametricStuffs.ParamSum}</li>
* <li> {@link parametricStuffs.NegativeParamWarning}</li>
* <li> {@link parametricStuffs.Hello}</li>
* <li> {@link parametricStuffs.DoubleSwapSomewhere}</li>
* <li> {@link parametricStuffs.DecIncr}</li>
* <li> {@link parametricStuffs.DecIncrDouble}</li>
* <li> {@link parametricStuffs.IncrAll}</li>
* <li> {@link parametricStuffs.MultipleParArities}</li>
* <li> {@link parametricStuffs.ShiftFirstToLastK}</li>
* <li> {@link parametricStuffs.ShiftLastToFirstK}</li>
* <li> {@link parametricStuffs.SwapParamHelper}</li>
* <li> {@link parametricStuffs.SwapSRLlike}</li>
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
		testShiftLastToFirstK_OLD();
		
		testShiftFirstToLastK_OLD();
		
		testParamSum();
		
		testNegativeParamWarning();
		
		testHello();
		
		testDoubleSwapSomewhere();
		
		testDecIncr();
		
		testDecIncrDouble();
		
		testIncrAll();
		
		testMultipleParArities();
		
		testShiftFirstToLastK();
		
		testShiftLastToFirstK();
		
		testSwapParamHelper();
		
		testSwapSRLlike();
	}
	
	//
	
	public static void testShiftLastToFirstK_OLD(){
		RPP shiftLastToFirstK_OLDRPP = new parametricStuffs.ShiftLastToFirstK_OLD();
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
			System.out.println("\nTesting the function shiftLastToFirstK_OLD with values:" + Arrays.toString(data));
			shiftLastToFirstK_OLDRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testShiftFirstToLastK_OLD(){
		RPP shiftFirstToLastK_OLDRPP = new parametricStuffs.ShiftFirstToLastK_OLD();
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
			System.out.println("\nTesting the function shiftFirstToLastK_OLD with values:" + Arrays.toString(data));
			shiftFirstToLastK_OLDRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testParamSum(){
		RPP paramSumRPP = new parametricStuffs.ParamSum();
		final int[][] datasets = {
			new int[]{1,2,3,4,5},
			new int[]{4,3,2,1,5},
			new int[]{ 0,  0,  0,  0,  0},
			new int[]{ 1,  1,  1,  1,  1},
			new int[]{ -1,  -1,  -1,  -1,  -1},
			new int[]{ 2,  2,  2,  2,  2},
			new int[]{ -2,  -2,  -2,  -2,  -2},
			new int[]{ 3,  3,  3,  3,  3},
			new int[]{ -3,  -3,  -3,  -3,  -3},
			new int[]{ 4,  4,  4,  4,  4},
			new int[]{ -4,  -4,  -4,  -4,  -4},
			new int[]{ 10,  10,  10,  10,  10},
			new int[]{ -10,  -10,  -10,  -10,  -10},
			new int[]{ 11,  11,  11,  11,  11},
			new int[]{ -11,  -11,  -11,  -11,  -11},
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
			new int[]{1,2,3,5},
			new int[]{3,2,1,5},
			new int[]{ 0,  0,  0,  0},
			new int[]{ 1,  1,  1,  1},
			new int[]{ -1,  -1,  -1,  -1},
			new int[]{ 2,  2,  2,  2},
			new int[]{ -2,  -2,  -2,  -2},
			new int[]{ 3,  3,  3,  3},
			new int[]{ -3,  -3,  -3,  -3},
			new int[]{ 4,  4,  4,  4},
			new int[]{ -4,  -4,  -4,  -4},
			new int[]{ 10,  10,  10,  10},
			new int[]{ -10,  -10,  -10,  -10},
			new int[]{ 11,  11,  11,  11},
			new int[]{ -11,  -11,  -11,  -11},
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
			System.out.println("\nTesting the function hello with values:" + Arrays.toString(data));
			helloRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testDoubleSwapSomewhere(){
		RPP doubleSwapSomewhereRPP = new parametricStuffs.DoubleSwapSomewhere();
		final int[][] datasets = {
			new int[]{1,2,3,4,5,6,7,8,5},
			new int[]{8,7,6,5,4,3,2,1,5},
			new int[]{ 0,  0,  0,  0,  0,  0,  0,  0,  0},
			new int[]{ 1,  1,  1,  1,  1,  1,  1,  1,  1},
			new int[]{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			new int[]{ 2,  2,  2,  2,  2,  2,  2,  2,  2},
			new int[]{ -2,  -2,  -2,  -2,  -2,  -2,  -2,  -2,  -2},
			new int[]{ 3,  3,  3,  3,  3,  3,  3,  3,  3},
			new int[]{ -3,  -3,  -3,  -3,  -3,  -3,  -3,  -3,  -3},
			new int[]{ 4,  4,  4,  4,  4,  4,  4,  4,  4},
			new int[]{ -4,  -4,  -4,  -4,  -4,  -4,  -4,  -4,  -4},
			new int[]{ 10,  10,  10,  10,  10,  10,  10,  10,  10},
			new int[]{ -10,  -10,  -10,  -10,  -10,  -10,  -10,  -10,  -10},
			new int[]{ 11,  11,  11,  11,  11,  11,  11,  11,  11},
			new int[]{ -11,  -11,  -11,  -11,  -11,  -11,  -11,  -11,  -11},
		};
		for( int[] data: datasets ){
			System.out.println("\nTesting the function doubleSwapSomewhere with values:" + Arrays.toString(data));
			doubleSwapSomewhereRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testDecIncr(){
		RPP decIncrRPP = new parametricStuffs.DecIncr();
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
			System.out.println("\nTesting the function decIncr with values:" + Arrays.toString(data));
			decIncrRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testDecIncrDouble(){
		RPP decIncrDoubleRPP = new parametricStuffs.DecIncrDouble();
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
			System.out.println("\nTesting the function decIncrDouble with values:" + Arrays.toString(data));
			decIncrDoubleRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testIncrAll(){
		RPP incrAllRPP = new parametricStuffs.IncrAll();
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
			System.out.println("\nTesting the function incrAll with values:" + Arrays.toString(data));
			incrAllRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testMultipleParArities(){
		RPP multipleParAritiesRPP = new parametricStuffs.MultipleParArities();
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
			System.out.println("\nTesting the function multipleParArities with values:" + Arrays.toString(data));
			multipleParAritiesRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testShiftFirstToLastK(){
		RPP shiftFirstToLastKRPP = new parametricStuffs.ShiftFirstToLastK();
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
			System.out.println("\nTesting the function shiftFirstToLastK with values:" + Arrays.toString(data));
			shiftFirstToLastKRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testShiftLastToFirstK(){
		RPP shiftLastToFirstKRPP = new parametricStuffs.ShiftLastToFirstK();
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
			System.out.println("\nTesting the function shiftLastToFirstK with values:" + Arrays.toString(data));
			shiftLastToFirstKRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSwapParamHelper(){
		RPP swapParamHelperRPP = new parametricStuffs.SwapParamHelper();
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
			System.out.println("\nTesting the function swapParamHelper with values:" + Arrays.toString(data));
			swapParamHelperRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSwapSRLlike(){
		RPP swapSRLlikeRPP = new parametricStuffs.SwapSRLlike();
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
			System.out.println("\nTesting the function swapSRLlike with values:" + Arrays.toString(data));
			swapSRLlikeRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
}
