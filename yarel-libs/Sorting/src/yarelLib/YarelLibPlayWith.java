package yarelLib;
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
* <li> {@link yarelLib.ShiftFirstToLastK}</li>
* <li> {@link yarelLib.ShiftLastToFirstK}</li>
* <li> {@link yarelLib.SwapParamHelper}</li>
* <li> {@link yarelLib.SwapSRLlike}</li>
* <li> {@link yarelLib.Increment}</li>
* <li> {@link yarelLib.Decrement}</li>
* <li> {@link yarelLib.AddFrom}</li>
* <li> {@link yarelLib.SubFrom}</li>
* <li> {@link yarelLib.SameSignYLess}</li>
* <li> {@link yarelLib.SameSignYMore}</li>
* <li> {@link yarelLib.SameSignYCompare}</li>
* <li> {@link yarelLib.DupNumbersStep}</li>
* <li> {@link yarelLib.LessThan}</li>
* <li> {@link yarelLib.MoreThan}</li>
* <li> {@link yarelLib.CompareThan}</li>
* <li> {@link yarelLib.CompareThanOverflowUnsafe}</li>
* <li> {@link yarelLib.Mult}</li>
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
public class YarelLibPlayWith {
	
	public static void main(String[] args) throws Exception {
		testShiftFirstToLastK();
		
		testShiftLastToFirstK();
		
		testSwapParamHelper();
		
		testSwapSRLlike();
		
		testIncrement();
		
		testDecrement();
		
		testAddFrom();
		
		testSubFrom();
		
		testSameSignYLess();
		
		testSameSignYMore();
		
		testSameSignYCompare();
		
		testDupNumbersStep();
		
		testLessThan();
		
		testMoreThan();
		
		testCompareThan();
		
		testCompareThanOverflowUnsafe();
		
		testMult();
	}
	
	//
	
	public static void testShiftFirstToLastK(){
		RPP shiftFirstToLastKRPP = new yarelLib.ShiftFirstToLastK();
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
		RPP shiftLastToFirstKRPP = new yarelLib.ShiftLastToFirstK();
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
		RPP swapParamHelperRPP = new yarelLib.SwapParamHelper();
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
		RPP swapSRLlikeRPP = new yarelLib.SwapSRLlike();
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
			System.out.println("\nTesting the function swapSRLlike with values:" + Arrays.toString(data));
			swapSRLlikeRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testIncrement(){
		RPP incrementRPP = new yarelLib.Increment();
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
			System.out.println("\nTesting the function increment with values:" + Arrays.toString(data));
			incrementRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testDecrement(){
		RPP decrementRPP = new yarelLib.Decrement();
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
			System.out.println("\nTesting the function decrement with values:" + Arrays.toString(data));
			decrementRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testAddFrom(){
		RPP addFromRPP = new yarelLib.AddFrom();
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
			System.out.println("\nTesting the function addFrom with values:" + Arrays.toString(data));
			addFromRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSubFrom(){
		RPP subFromRPP = new yarelLib.SubFrom();
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
			System.out.println("\nTesting the function subFrom with values:" + Arrays.toString(data));
			subFromRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSameSignYLess(){
		RPP sameSignYLessRPP = new yarelLib.SameSignYLess();
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
			System.out.println("\nTesting the function sameSignYLess with values:" + Arrays.toString(data));
			sameSignYLessRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSameSignYMore(){
		RPP sameSignYMoreRPP = new yarelLib.SameSignYMore();
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
			System.out.println("\nTesting the function sameSignYMore with values:" + Arrays.toString(data));
			sameSignYMoreRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testSameSignYCompare(){
		RPP sameSignYCompareRPP = new yarelLib.SameSignYCompare();
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
			System.out.println("\nTesting the function sameSignYCompare with values:" + Arrays.toString(data));
			sameSignYCompareRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testDupNumbersStep(){
		RPP dupNumbersStepRPP = new yarelLib.DupNumbersStep();
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
			System.out.println("\nTesting the function dupNumbersStep with values:" + Arrays.toString(data));
			dupNumbersStepRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testLessThan(){
		RPP lessThanRPP = new yarelLib.LessThan();
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
			System.out.println("\nTesting the function lessThan with values:" + Arrays.toString(data));
			lessThanRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testMoreThan(){
		RPP moreThanRPP = new yarelLib.MoreThan();
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
			System.out.println("\nTesting the function moreThan with values:" + Arrays.toString(data));
			moreThanRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testCompareThan(){
		RPP compareThanRPP = new yarelLib.CompareThan();
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
			System.out.println("\nTesting the function compareThan with values:" + Arrays.toString(data));
			compareThanRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testCompareThanOverflowUnsafe(){
		RPP compareThanOverflowUnsafeRPP = new yarelLib.CompareThanOverflowUnsafe();
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
			System.out.println("\nTesting the function compareThanOverflowUnsafe with values:" + Arrays.toString(data));
			compareThanOverflowUnsafeRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
	
	
	
	public static void testMult(){
		RPP multRPP = new yarelLib.Mult();
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
			System.out.println("\nTesting the function mult with values:" + Arrays.toString(data));
			multRPP.b(data);
			System.out.println("Resulting in: " + Arrays.toString(data));
		}
	}
}
