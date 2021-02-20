package arithNat;
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
* <li> {@link arithNat.SumN}</li>
* <li> {@link arithNat.SubN}</li>
* <li> {@link arithNat.MulN}</li>
* <li> {@link arithNat.DisSelN}</li>
* <li> {@link arithNat.DisStepN}</li>
* <li> {@link arithNat.QuoN}</li>
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
public class ArithNatPlayWith {
	
	public static void main(String[] args) throws Exception {
		testSumN();
		
		testSubN();
		
		testMulN();
		
		testDisSelN();
		
		testDisStepN();
		
		testQuoN();
	}
	
	//
	
	public static void testSumN(){
		RPP sumNRPP = new arithNat.SumN();
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
			System.out.println("\nTesting the function sumN with values:" + Arrays.toString(data));
			sumNRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSubN(){
		RPP subNRPP = new arithNat.SubN();
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
			System.out.println("\nTesting the function subN with values:" + Arrays.toString(data));
			subNRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testMulN(){
		RPP mulNRPP = new arithNat.MulN();
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
			System.out.println("\nTesting the function mulN with values:" + Arrays.toString(data));
			mulNRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testDisSelN(){
		RPP disSelNRPP = new arithNat.DisSelN();
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
			System.out.println("\nTesting the function disSelN with values:" + Arrays.toString(data));
			disSelNRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testDisStepN(){
		RPP disStepNRPP = new arithNat.DisStepN();
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
			System.out.println("\nTesting the function disStepN with values:" + Arrays.toString(data));
			disStepNRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testQuoN(){
		RPP quoNRPP = new arithNat.QuoN();
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
			System.out.println("\nTesting the function quoN with values:" + Arrays.toString(data));
			quoNRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
}
