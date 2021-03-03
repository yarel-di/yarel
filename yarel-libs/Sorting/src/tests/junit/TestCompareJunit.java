package tests.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class TestCompareJunit {

	public static enum IntCompTest {
		Less, More, Comp, CompareOverflowUnsafe {
			@Override
			public int getArity() {
				return 3;
			}
		};

		public int getArity() {
			return 5;
		}
	}

	public static class DataTest {
		int i, j;
		/**
		 * 1 <-> (i > j); 0 otherwise
		 */
		int expected;
	}

	public static boolean checkMismatch(IntCompTest itc, int result, DataTest data) {
		if (IntCompTest.Less == itc || IntCompTest.More == itc) {
			boolean isLess = IntCompTest.Less == itc;
			return
			// case 2
			(((result == data.expected) ^ isLess) // data[2] refers only to "Less" ..
					&& (data.i != data.j))// .. unless "i" ad "j" are equals: that's the first case
					// case 1
					|| ((data.i == data.j) && (result != 0))// if "i" and "j" are equals, the result must be 0
			;
		} else {
			return result != Integer.compare(data.i, data.j);
		}
	}

	public static final int[][] DATASET_LESS = { // i j expected (if j > i)
			new int[] { 0, 0, 0 }, //

			new int[] { 1, 0, 0 }, //
			new int[] { 0, 1, 1 }, //
			new int[] { 2, 0, 0 }, //
			new int[] { 2, 2, 0 }, //
			new int[] { 1, 1, 0 }, //
			new int[] { 0, 2, 1 }, //
			new int[] { 2, 1, 0 }, //
			new int[] { 1, 2, 1 }, //
			new int[] { 3, 2, 0 }, //
			new int[] { 2, 3, 1 }, //
			new int[] { 4, 2, 0 }, //
			new int[] { 2, 4, 1 }, //
			new int[] { 7, 5, 0 }, //
			new int[] { 5, 7, 1 }, //
			new int[] { 8, 8, 0 }, //
			new int[] { 9, 9, 0 }, //

			new int[] { -1, 0, 1 }, //
			new int[] { 0, -1, 0 }, //
			new int[] { -2, 0, 1 }, //
			new int[] { 0, -2, 0 }, ///
			new int[] { -2, -2, 0 }, //
			new int[] { -1, -1, 0 }, //
			new int[] { -2, -1, 1 }, //
			new int[] { -1, -2, 0 }, //
			new int[] { -3, -2, 1 }, //
			new int[] { -2, -3, 0 }, //
			new int[] { -4, -2, 1 }, //
			new int[] { -2, -4, 0 }, //
			new int[] { -7, -5, 1 }, //
			new int[] { -5, -7, 0 }, //
			new int[] { -8, -8, 0 }, //
			new int[] { -9, -9, 0 }, //

			new int[] { -2, 2, 1 }, //
			new int[] { -1, 1, 1 }, //
			new int[] { -2, 1, 1 }, //
			new int[] { -1, 2, 1 }, //
			new int[] { -3, 2, 1 }, //
			new int[] { -2, 3, 1 }, //
			new int[] { -4, 2, 1 }, //
			new int[] { -2, 4, 1 }, //
			new int[] { -7, 5, 1 }, //
			new int[] { -5, 7, 1 }, //
			new int[] { -8, 8, 1 }, //
			new int[] { -9, 9, 1 }, //

			new int[] { 2, -2, 0 }, //
			new int[] { 1, -1, 0 }, //
			new int[] { 2, -1, 0 }, //
			new int[] { 1, -2, 0 }, //
			new int[] { 3, -2, 0 }, //
			new int[] { 2, -3, 0 }, //
			new int[] { 4, -2, 0 }, //
			new int[] { 2, -4, 0 }, //
			new int[] { 7, -5, 0 }, //
			new int[] { 5, -7, 0 }, //
			new int[] { 8, -8, 0 }, //
			new int[] { 9, -9, 0 }, //
	};

	@Test
	public void datTest() {
		int errorsAmount;
		IntCompTest[] tests = IntCompTest.values();
		errorsAmount = 0;
		for (IntCompTest t : tests) {
//			allOk &= 
			errorsAmount += test(t) ? 0 : 1;
		}
//		assertTrue(allOk);
		assertEquals(0, errorsAmount);
	}

	public static boolean test(IntCompTest itc) {
		int errorsCounter = 0;
		final int[] dataset = new int[itc.getArity()], registers = new int[itc.getArity()];
		final yarelcore.RPP fnToTest;
		Arrays.fill(dataset, 0);
		switch (itc) {
		case Comp:
			fnToTest = new integerCompare.Compare();
			break;
		case Less:
			fnToTest = new integerCompare.Less();
			break;
		case More:
			fnToTest = new integerCompare.More();
			break;
		case CompareOverflowUnsafe:
			fnToTest = new integerCompare.CompareOverflowUnsafe();
			break;
		default:
			throw new RuntimeException("WHAT IntCompTest? " + itc);
		}
		if (IntCompTest.Less == itc || IntCompTest.More == itc) {
			boolean isLess = IntCompTest.Less == itc;
			for (int[] data : DATASET_LESS) {
				registers[0] = registers[1] = registers[2] = 0;
				registers[3] = data[0];
				registers[4] = data[1];
				fnToTest.b(registers);
				if ( // case 1
				((data[0] == data[1]) && (registers[0] != 0))// if "i" and "j" are equals, the result must be 0
						// case 2
						|| (((registers[0] == data[2]) ^ isLess)) // data[2] refers only to "Less" ..
								&& (data[0] != data[1]) // .. unless "i" ad "j" are equals: that's the first case
				) {
					errorsCounter++;
					System.out.println("ERROR: with data: " + Arrays.toString(data) + ", got registers: "
							+ Arrays.toString(registers));
				}
			}
		} else {
			boolean isCompact = IntCompTest.CompareOverflowUnsafe == itc;
			for (int[] data : DATASET_LESS) {
				if (isCompact) {
					registers[0] = 0;
					registers[1] = data[0];
					registers[2] = data[1];
				} else {
					registers[0] = registers[1] = registers[2] = 0;
					registers[3] = data[0];
					registers[4] = data[1];
				}
				fnToTest.b(registers);
				if (registers[0] != Integer.compare(data[0], data[1])) {
					errorsCounter++;
					System.out.println("ERROR: with data: " + Arrays.toString(data) + ", got registers: "
							+ Arrays.toString(registers) + " and expected : " + Integer.compare(data[0], data[1]));
				}
			}
		}
		return errorsCounter == 0;
	}

}
