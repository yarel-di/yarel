package tests.manual;

import java.util.Arrays;

public class TestTestSwap {

	public static void main(String[] args) {
//		TestSwap ts;
		int[] r = { 0, 5, -3, 0, 8, 13//
				, -2 // the value expected to go to first position
				, 7 // the index
		};
//		ts = new TestSwap(6);
		/**
		 * dcl testSwap: 2 int , K //<br>
		 * def testSwap := //<br>
		 * /{K+1}/ //<br>
		 */
		System.out.println("Registers before: " + Arrays.toString(r));
//		ts.b(r);
		System.out.println("Registers after: " + Arrays.toString(r));
	}
}