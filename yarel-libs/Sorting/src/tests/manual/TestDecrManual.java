package tests.manual;

import java.util.Arrays;

import tests.junit.TestIncrDecrJunit;
import tests.manual.TestIncrManual.ExpectationsTest;
import yarelLib.Decrement;

public class TestDecrManual {

	public static void main(String[] args) {
		final int m = 7;
		int[] regs;
		Decrement dec;
		ExpectationsTest[] expecteds = { //
				new ExpectationsTest(2, 5, -17) //
				, new ExpectationsTest(5, 2, -13) //
				, new ExpectationsTest(4, 1, -20) //
				, new ExpectationsTest(1, 4, 20) //
				, new ExpectationsTest(4, 2, -15) //
				, new ExpectationsTest(2, 4, -15) //
				, new ExpectationsTest(3, 2, -7) //
				, new ExpectationsTest(2, 3, -23) //
				, new ExpectationsTest(3, 4, 8) //
				, new ExpectationsTest(4, 3, -8) //
				, new ExpectationsTest(7, 6, 74) //
				, new ExpectationsTest(6, 7, -80) //
				, new ExpectationsTest(6, 2, -18) //
				, new ExpectationsTest(2, 6, -18) //
				//
//				, new ExpectationsTest(1, 1, 40) //
//				, new ExpectationsTest(2, 2, 0) //
//				, new ExpectationsTest(5, 5, 4) //
//				, new ExpectationsTest(6, 6, 0) //
//				, new ExpectationsTest(7, 7, 154) //
//				//, new ExpectationsTest(8, 8, 20) //
//				//, new ExpectationsTest(1000, 1000, 0) //
		};
		System.out.println("START\n\n\n");
		for (ExpectationsTest et : expecteds) {
			System.out.println("\n\nstart new test: " + et.toString());
			dec = new Decrement(m, et.i, et.j);
			regs = TestIncrDecrJunit.newRegs();
			dec.b(regs);
			System.out.println("got: " + Arrays.toString(regs));
			System.out.println("\tis expected? " + (regs[(et.i - 1) % m] == et.expectedValue));
		}
		System.out.println("\n\n\nEND");
	}
}
