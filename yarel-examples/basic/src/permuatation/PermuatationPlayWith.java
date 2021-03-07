package permuatation;
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
* <li> {@link permuatation.PExample}</li>
* <li> {@link permuatation.PInd_dataset}</li>
* <li> {@link permuatation.PIndexed_1}</li>
* <li> {@link permuatation.PIndexed_2}</li>
* <li> {@link permuatation.PIndexed_3}</li>
* <li> {@link permuatation.PIndexed_4}</li>
* <li> {@link permuatation.PIndexed_5}</li>
* <li> {@link permuatation.PIndexed_6}</li>
* <li> {@link permuatation.PIndexed_8}</li>
* <li> {@link permuatation.PIndexed_7}</li>
* <li> {@link permuatation.PIndexed_10}</li>
* <li> {@link permuatation.PIndexed_12}</li>
* <li> {@link permuatation.PIndexed_min_14}</li>
* <li> {@link permuatation.PIndexed_min_11}</li>
* <li> {@link permuatation.PIndexed_min_1}</li>
* <li> {@link permuatation.ShiftLastToFirst5}</li>
* <li> {@link permuatation.ShiftLastToFirst10}</li>
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
public class PermuatationPlayWith {
	
	public static void main(String[] args) throws Exception {
		testPExample();
		
		testPInd_dataset();
		
		testPIndexed_1();
		
		testPIndexed_2();
		
		testPIndexed_3();
		
		testPIndexed_4();
		
		testPIndexed_5();
		
		testPIndexed_6();
		
		testPIndexed_8();
		
		testPIndexed_7();
		
		testPIndexed_10();
		
		testPIndexed_12();
		
		testPIndexed_min_14();
		
		testPIndexed_min_11();
		
		testPIndexed_min_1();
		
		testShiftLastToFirst5();
		
		testShiftLastToFirst10();
	}
	
	//
	
	public static void testPExample(){
		RPP pExampleRPP = new permuatation.PExample();
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
			System.out.println("\nTesting the function pExample with values:" + Arrays.toString(data));
			pExampleRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPInd_dataset(){
		RPP pInd_datasetRPP = new permuatation.PInd_dataset();
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
			System.out.println("\nTesting the function pInd_dataset with values:" + Arrays.toString(data));
			pInd_datasetRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPIndexed_1(){
		RPP pIndexed_1RPP = new permuatation.PIndexed_1();
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
			System.out.println("\nTesting the function pIndexed_1 with values:" + Arrays.toString(data));
			pIndexed_1RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPIndexed_2(){
		RPP pIndexed_2RPP = new permuatation.PIndexed_2();
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
			System.out.println("\nTesting the function pIndexed_2 with values:" + Arrays.toString(data));
			pIndexed_2RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPIndexed_3(){
		RPP pIndexed_3RPP = new permuatation.PIndexed_3();
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
			System.out.println("\nTesting the function pIndexed_3 with values:" + Arrays.toString(data));
			pIndexed_3RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPIndexed_4(){
		RPP pIndexed_4RPP = new permuatation.PIndexed_4();
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
			System.out.println("\nTesting the function pIndexed_4 with values:" + Arrays.toString(data));
			pIndexed_4RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPIndexed_5(){
		RPP pIndexed_5RPP = new permuatation.PIndexed_5();
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
			System.out.println("\nTesting the function pIndexed_5 with values:" + Arrays.toString(data));
			pIndexed_5RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPIndexed_6(){
		RPP pIndexed_6RPP = new permuatation.PIndexed_6();
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
			System.out.println("\nTesting the function pIndexed_6 with values:" + Arrays.toString(data));
			pIndexed_6RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPIndexed_8(){
		RPP pIndexed_8RPP = new permuatation.PIndexed_8();
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
			System.out.println("\nTesting the function pIndexed_8 with values:" + Arrays.toString(data));
			pIndexed_8RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPIndexed_7(){
		RPP pIndexed_7RPP = new permuatation.PIndexed_7();
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
			System.out.println("\nTesting the function pIndexed_7 with values:" + Arrays.toString(data));
			pIndexed_7RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPIndexed_10(){
		RPP pIndexed_10RPP = new permuatation.PIndexed_10();
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
			System.out.println("\nTesting the function pIndexed_10 with values:" + Arrays.toString(data));
			pIndexed_10RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPIndexed_12(){
		RPP pIndexed_12RPP = new permuatation.PIndexed_12();
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
			System.out.println("\nTesting the function pIndexed_12 with values:" + Arrays.toString(data));
			pIndexed_12RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPIndexed_min_14(){
		RPP pIndexed_min_14RPP = new permuatation.PIndexed_min_14();
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
			System.out.println("\nTesting the function pIndexed_min_14 with values:" + Arrays.toString(data));
			pIndexed_min_14RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPIndexed_min_11(){
		RPP pIndexed_min_11RPP = new permuatation.PIndexed_min_11();
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
			System.out.println("\nTesting the function pIndexed_min_11 with values:" + Arrays.toString(data));
			pIndexed_min_11RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPIndexed_min_1(){
		RPP pIndexed_min_1RPP = new permuatation.PIndexed_min_1();
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
			System.out.println("\nTesting the function pIndexed_min_1 with values:" + Arrays.toString(data));
			pIndexed_min_1RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testShiftLastToFirst5(){
		RPP shiftLastToFirst5RPP = new permuatation.ShiftLastToFirst5();
		final int[][] datasets = {
			new int[]{1,2,3,4,5,6,5},
			new int[]{6,5,4,3,2,1,5},
			new int[]{ 0,  0,  0,  0,  0,  0,  0},
			new int[]{ 1,  1,  1,  1,  1,  1,  1},
			new int[]{ -1,  -1,  -1,  -1,  -1,  -1,  -1},
			new int[]{ 2,  2,  2,  2,  2,  2,  2},
			new int[]{ -2,  -2,  -2,  -2,  -2,  -2,  -2},
			new int[]{ 3,  3,  3,  3,  3,  3,  3},
			new int[]{ -3,  -3,  -3,  -3,  -3,  -3,  -3},
			new int[]{ 4,  4,  4,  4,  4,  4,  4},
			new int[]{ -4,  -4,  -4,  -4,  -4,  -4,  -4},
			new int[]{ 10,  10,  10,  10,  10,  10,  10},
			new int[]{ -10,  -10,  -10,  -10,  -10,  -10,  -10},
			new int[]{ 11,  11,  11,  11,  11,  11,  11},
			new int[]{ -11,  -11,  -11,  -11,  -11,  -11,  -11},
		};
		for( int[] data: datasets ){
			System.out.println("\nTesting the function shiftLastToFirst5 with values:" + Arrays.toString(data));
			shiftLastToFirst5RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testShiftLastToFirst10(){
		RPP shiftLastToFirst10RPP = new permuatation.ShiftLastToFirst10();
		final int[][] datasets = {
			new int[]{1,2,3,4,5,6,7,8,9,10,11,5},
			new int[]{11,10,9,8,7,6,5,4,3,2,1,5},
			new int[]{ 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			new int[]{ 1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1},
			new int[]{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			new int[]{ 2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2},
			new int[]{ -2,  -2,  -2,  -2,  -2,  -2,  -2,  -2,  -2,  -2,  -2,  -2},
			new int[]{ 3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3},
			new int[]{ -3,  -3,  -3,  -3,  -3,  -3,  -3,  -3,  -3,  -3,  -3,  -3},
			new int[]{ 4,  4,  4,  4,  4,  4,  4,  4,  4,  4,  4,  4},
			new int[]{ -4,  -4,  -4,  -4,  -4,  -4,  -4,  -4,  -4,  -4,  -4,  -4},
			new int[]{ 10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10},
			new int[]{ -10,  -10,  -10,  -10,  -10,  -10,  -10,  -10,  -10,  -10,  -10,  -10},
			new int[]{ 11,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11},
			new int[]{ -11,  -11,  -11,  -11,  -11,  -11,  -11,  -11,  -11,  -11,  -11,  -11},
		};
		for( int[] data: datasets ){
			System.out.println("\nTesting the function shiftLastToFirst10 with values:" + Arrays.toString(data));
			shiftLastToFirst10RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
}
