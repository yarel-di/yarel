package tests.manual;

import java.util.Arrays;

import tests.junit.TestIncrDecrJunit;
import yarelLib.Increment;

public class TestIncrManual {

	public static void main(String[] args) {
		final int m = 7;
		int[] regs;
		Increment inc;
		ExpectationsTest[] expecteds = { //
				new ExpectationsTest(2, 5, -13) //
				, new ExpectationsTest(5, 2, 17) //
				, new ExpectationsTest(4, 1, 20) //
				, new ExpectationsTest(1, 4, 20) //
				, new ExpectationsTest(4, 2, 15) //
				, new ExpectationsTest(2, 4, -15) //
				, new ExpectationsTest(3, 2, 23) //
				, new ExpectationsTest(2, 3, -7) //
				, new ExpectationsTest(3, 4, 8) //
				, new ExpectationsTest(4, 3, 8) //
				, new ExpectationsTest(7, 6, 80) //
				, new ExpectationsTest(6, 7, 74) //
				, new ExpectationsTest(6, 2, 12) //
				, new ExpectationsTest(2, 6, -12) //
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
			inc = new Increment(m, et.i, et.j);
			regs = TestIncrDecrJunit.newRegs();
			inc.b(regs);
			System.out.println("got: " + Arrays.toString(regs));
			System.out.println("\tis expected? " + (regs[(et.i - 1) % m] == et.expectedValue));
		}
		System.out.println("\n\n\nEND");
	}

	public static class ExpectationsTest {
		final int i, j, expectedValue;

		public ExpectationsTest(int i, int j, int expectedValue) {
			super();
			this.i = i;
			this.j = j;
			this.expectedValue = expectedValue;
		}

		@Override
		public String toString() {
			return "ExpectationsTest [i=" + i + ", j=" + j + ", expectedValue=" + expectedValue + "]";
		}
	}
}
