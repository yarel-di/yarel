package minorTests;
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
* <li> {@link minorTests.JustASwap}</li>
* <li> {@link minorTests.JustASwap2}</li>
* <li> {@link minorTests.SwapSRLLike2}</li>
* <li> {@link minorTests.ParamInc}</li>
* <li> {@link minorTests.ParamDec}</li>
* <li> {@link minorTests.ParamNeg}</li>
* <li> {@link minorTests.ParamItInc}</li>
* <li> {@link minorTests.ParamItFor}</li>
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
public class MinorTestsPlayWith {
	
	public static void main(String[] args) throws Exception {
		testJustASwap();
		
		testJustASwap2();
		
		testSwapSRLLike2();
		
		testParamInc();
		
		testParamDec();
		
		testParamNeg();
		
		testParamItInc();
		
		testParamItFor();
	}
	
	//
	
	public static void testJustASwap(){
		RPP justASwapRPP = new minorTests.JustASwap();
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
			System.out.println("\nTesting the function justASwap with values:" + Arrays.toString(data));
			justASwapRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testJustASwap2(){
		RPP justASwap2RPP = new minorTests.JustASwap2();
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
			System.out.println("\nTesting the function justASwap2 with values:" + Arrays.toString(data));
			justASwap2RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSwapSRLLike2(){
		RPP swapSRLLike2RPP = new minorTests.SwapSRLLike2();
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
			System.out.println("\nTesting the function swapSRLLike2 with values:" + Arrays.toString(data));
			swapSRLLike2RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testParamInc(){
		RPP paramIncRPP = new minorTests.ParamInc();
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
			System.out.println("\nTesting the function paramInc with values:" + Arrays.toString(data));
			paramIncRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testParamDec(){
		RPP paramDecRPP = new minorTests.ParamDec();
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
			System.out.println("\nTesting the function paramDec with values:" + Arrays.toString(data));
			paramDecRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testParamNeg(){
		RPP paramNegRPP = new minorTests.ParamNeg();
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
			System.out.println("\nTesting the function paramNeg with values:" + Arrays.toString(data));
			paramNegRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testParamItInc(){
		RPP paramItIncRPP = new minorTests.ParamItInc();
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
			System.out.println("\nTesting the function paramItInc with values:" + Arrays.toString(data));
			paramItIncRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testParamItFor(){
		RPP paramItForRPP = new minorTests.ParamItFor();
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
			System.out.println("\nTesting the function paramItFor with values:" + Arrays.toString(data));
			paramItForRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
}
