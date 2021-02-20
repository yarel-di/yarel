package tests.manual;

import java.util.Arrays;

import parallelTest.ILikeParallelism;
import parallelTest.InvSomeAtomicStuffs;
import parallelTest.InvSomeSwaps;
import parallelTest.InvTo_odd;
import parallelTest.InvTriIncParExplicit;
import parallelTest.InvUpAndDown;
import parallelTest.LargePermutation;
import parallelTest.RearrangeLargePerm;
import parallelTest.SomeAtomicStuffs;
import parallelTest.SomeSwaps;
import parallelTest.To_odd;
import parallelTest.TriIncParExplicit;
import parallelTest.UpAndDown;

public class TestParallel {

	static final int[] toTest = { 0, 1, -1, 2, -2, 3, -3, 4, -4, 5, -5, 6, -6, 10, -10, -11, -11, 1024, -1024 };

	public static void main(String[] args) {
		System.out.println("Start test gioco");
		testToOdd();
		//
		testTriIncPar();
		//
		testUpAndDown();
		//
		testSomeSwaps();

		//

		testParallelFirstMethods();

		System.out.println("End test gioco");
	}

	public static void testParallelFirstMethods() {
		int[] data = { 10, 10, 10, 10, 10, 10, 10 };
		SomeAtomicStuffs sas = new SomeAtomicStuffs();
		InvSomeAtomicStuffs invSas = new InvSomeAtomicStuffs();
		System.out.println("sas start");
		sas.b(data); // then expected: [11, 9, 10, -20, 10, -10, 13]
		System.out.println("sas produced: " + Arrays.toString(data));
		invSas.b(data);
		// expected: back to original
		System.out.println("INV sas produced: " + Arrays.toString(data));
		System.out.println("sas end");

		System.out.println("\n\n now iLikeParallelism after sas");
		ILikeParallelism ilp = new ILikeParallelism();
		sas.b(data); // then expected: [11, 9, 10, -20, 10, -10, 11]
		ilp.b(data); // then expected: [24, 22, 23, -7, 23, 3, 13]
		System.out.println("that thing produces: " + Arrays.toString(data));

		System.out.println("\n\n\n largePermutation:");
		LargePermutation lp = new LargePermutation();
		int[] lpData = new int[12];
		for (int i = 0; i < lpData.length; i++) {
			lpData[i] = i + 1;
		}
		lpData[10] = -77;
		System.out.println("at start: " + Arrays.toString(lpData));
		lp.b(lpData);
		System.out.println("then: : " + Arrays.toString(lpData));
		RearrangeLargePerm rlp = new RearrangeLargePerm();
		rlp.b(lpData);
		System.out.println("re-arranging values: : " + Arrays.toString(lpData));
	}

	///

	public static void testToOdd() {
		int[] a;
		To_odd toOdd;
		InvTo_odd toOddInv;
		toOdd = new To_odd();
		toOddInv = new InvTo_odd();
		System.out.println("\n\n-----------------------------------\ntest TO ODD\n-------------------------");
		for (int tt : toTest) {
			a = new int[] { tt, 0 };
			System.out.println("\ntesting: " + tt);
			toOdd.b(a);
			System.out.println("-> got -> " + Arrays.toString(a));
			toOddInv.b(a);
			System.out.println("-> got INV -> " + Arrays.toString(a));
		}
	}

	public static void testTriIncPar() {
		int[] a;
		TriIncParExplicit triIncPar;
		InvTriIncParExplicit triIncParInv;
		triIncPar = new TriIncParExplicit();
		triIncParInv = new InvTriIncParExplicit();
		System.out.println("\n\n-----------------------------------\ntest TRI INC PARALLEL\n-------------------------");
		for (int tt : toTest) {
			a = new int[] { tt, 1000 + tt, tt << 1 };
			System.out.println("\ntesting: " + tt + " -> " + Arrays.toString(a));
			triIncPar.b(a);
			System.out.println("-> got -> " + Arrays.toString(a));
			triIncParInv.b(a);
			System.out.println("-> got INV -> " + Arrays.toString(a));
		}
	}

	public static void testUpAndDown() {
		int[] a;
		UpAndDown triIncPar;
		InvUpAndDown triIncParInv;
		triIncPar = new UpAndDown();
		triIncParInv = new InvUpAndDown();
		System.out.println("\n\n-----------------------------------\ntest UP AND DOWN\n-------------------------");
		for (int tt : toTest) {
			a = new int[] { tt, 1000 + tt, tt << 1, 0 };
			System.out.println("\ntesting: " + tt + " -> " + Arrays.toString(a));
			triIncPar.b(a);
			System.out.println("-> got -> " + Arrays.toString(a));
			triIncParInv.b(a);
			System.out.println("-> got INV -> " + Arrays.toString(a));
		}
	}

	public static void testSomeSwaps() {
		int[] a = new int[10];
		SomeSwaps someSwaps;
		InvSomeSwaps invSomeSwaps;
		someSwaps = new SomeSwaps();
		invSomeSwaps = new InvSomeSwaps();
		for (int i = 0; i < a.length; i++) {
			a[i] = 1 + i;
		}
		System.out.println("\n\n-----------------------------------\ntest SOME SWAPS\n-------------------------");
		someSwaps.b(a);
		System.out.println("-> got -> " + Arrays.toString(a));
		invSomeSwaps.b(a);
		System.out.println("-> got INV -> " + Arrays.toString(a));

	}
}