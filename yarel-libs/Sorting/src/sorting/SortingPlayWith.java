package sorting;
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
* <li> {@link sorting.PairExtraction}</li>
* <li> {@link sorting.SortGrowing}</li>
* <li> {@link sorting.SortUngrowing}</li>
* <li> {@link sorting.PairExtraction2}</li>
* <li> {@link sorting.SortGrowingOpt}</li>
* <li> {@link sorting.SortUngrowingOpt}</li>
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
public class SortingPlayWith {
	
	public static void main(String[] args) throws Exception {
		testPairExtraction();
		
		testSortGrowing();
		
		testSortUngrowing();
		
		testPairExtraction2();
		
		testSortGrowingOpt();
		
		testSortUngrowingOpt();
	}
	
	//
	
	public static void testPairExtraction(){
		RPP pairExtractionRPP = new sorting.PairExtraction();
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
			System.out.println("\nTesting the function pairExtraction with values:" + Arrays.toString(data));
			pairExtractionRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSortGrowing(){
		RPP sortGrowingRPP = new sorting.SortGrowing();
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
			System.out.println("\nTesting the function sortGrowing with values:" + Arrays.toString(data));
			sortGrowingRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSortUngrowing(){
		RPP sortUngrowingRPP = new sorting.SortUngrowing();
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
			System.out.println("\nTesting the function sortUngrowing with values:" + Arrays.toString(data));
			sortUngrowingRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testPairExtraction2(){
		RPP pairExtraction2RPP = new sorting.PairExtraction2();
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
			System.out.println("\nTesting the function pairExtraction2 with values:" + Arrays.toString(data));
			pairExtraction2RPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSortGrowingOpt(){
		RPP sortGrowingOptRPP = new sorting.SortGrowingOpt();
		final int[][] datasets = {
			new int[]{1,2,3,4,5,6,7,8,9,5},
			new int[]{9,8,7,6,5,4,3,2,1,5},
			new int[]{ 0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			new int[]{ 1,  1,  1,  1,  1,  1,  1,  1,  1,  1},
			new int[]{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			new int[]{ 2,  2,  2,  2,  2,  2,  2,  2,  2,  2},
			new int[]{ -2,  -2,  -2,  -2,  -2,  -2,  -2,  -2,  -2,  -2},
			new int[]{ 3,  3,  3,  3,  3,  3,  3,  3,  3,  3},
			new int[]{ -3,  -3,  -3,  -3,  -3,  -3,  -3,  -3,  -3,  -3},
			new int[]{ 4,  4,  4,  4,  4,  4,  4,  4,  4,  4},
			new int[]{ -4,  -4,  -4,  -4,  -4,  -4,  -4,  -4,  -4,  -4},
			new int[]{ 10,  10,  10,  10,  10,  10,  10,  10,  10,  10},
			new int[]{ -10,  -10,  -10,  -10,  -10,  -10,  -10,  -10,  -10,  -10},
			new int[]{ 11,  11,  11,  11,  11,  11,  11,  11,  11,  11},
			new int[]{ -11,  -11,  -11,  -11,  -11,  -11,  -11,  -11,  -11,  -11},
		};
		for( int[] data: datasets ){
			System.out.println("\nTesting the function sortGrowingOpt with values:" + Arrays.toString(data));
			sortGrowingOptRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSortUngrowingOpt(){
		RPP sortUngrowingOptRPP = new sorting.SortUngrowingOpt();
		final int[][] datasets = {
			new int[]{1,2,3,4,5,6,7,8,9,5},
			new int[]{9,8,7,6,5,4,3,2,1,5},
			new int[]{ 0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
			new int[]{ 1,  1,  1,  1,  1,  1,  1,  1,  1,  1},
			new int[]{ -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1},
			new int[]{ 2,  2,  2,  2,  2,  2,  2,  2,  2,  2},
			new int[]{ -2,  -2,  -2,  -2,  -2,  -2,  -2,  -2,  -2,  -2},
			new int[]{ 3,  3,  3,  3,  3,  3,  3,  3,  3,  3},
			new int[]{ -3,  -3,  -3,  -3,  -3,  -3,  -3,  -3,  -3,  -3},
			new int[]{ 4,  4,  4,  4,  4,  4,  4,  4,  4,  4},
			new int[]{ -4,  -4,  -4,  -4,  -4,  -4,  -4,  -4,  -4,  -4},
			new int[]{ 10,  10,  10,  10,  10,  10,  10,  10,  10,  10},
			new int[]{ -10,  -10,  -10,  -10,  -10,  -10,  -10,  -10,  -10,  -10},
			new int[]{ 11,  11,  11,  11,  11,  11,  11,  11,  11,  11},
			new int[]{ -11,  -11,  -11,  -11,  -11,  -11,  -11,  -11,  -11,  -11},
		};
		for( int[] data: datasets ){
			System.out.println("\nTesting the function sortUngrowingOpt with values:" + Arrays.toString(data));
			sortUngrowingOptRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
}
