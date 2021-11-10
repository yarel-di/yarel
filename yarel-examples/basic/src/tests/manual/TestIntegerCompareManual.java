package tests.manual;

import java.math.BigInteger;
import java.util.Arrays;

import tests.junit.TestCompareJunit;
import yarelcore.RPP;

public class TestIntegerCompareManual {

	public static void main(String[] args) {
		TestCompareJunit.IntCompTest[] tests = TestCompareJunit.IntCompTest.values();
		System.out.println("START test less manual");
		for (TestCompareJunit.IntCompTest t : tests) {
			test(t);
		}
		System.out.println("END test less manual");
	}

	public static void test(TestCompareJunit.IntCompTest itc) {
		int errorsCounter = 0;
		final BigInteger[] dataset = TestALL.registersFrom(new int[itc.getArity()]), //
				registers = TestALL.registersFrom(new int[itc.getArity()]);
		final RPP fnToTest;
		Arrays.fill(dataset, BigInteger.ZERO);
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
		System.out.println("\n\n\n---------------------------------------------------");
		System.out.println("\tstart testing: " + itc.name());
		if (TestCompareJunit.IntCompTest.Less == itc || TestCompareJunit.IntCompTest.More == itc) {
			boolean isLess = TestCompareJunit.IntCompTest.Less == itc;
			for (BigInteger[] data : TestCompareJunit.DATASET_LESS) {
				registers[0] = registers[1] = registers[2] = BigInteger.ZERO;
				registers[3] = data[0];
				registers[4] = data[1];
				fnToTest.b(registers);
//				if ( // case 1
//				((data[0] == data[1]) && (registers[0] != 0))// if "i" and "j" are equals, the result must be 0
//						// case 2
//						|| (((registers[0] == data[2]) ^ isLess)) // data[2] refers only to "Less" ..
//								&& (data[0] != data[1]) // .. unless "i" ad "j" are equals: that's the first case
//				) {
//					errorsCounter++;
//					System.out.println("ERROR: with data: " + Arrays.toString(data) + ", got registers: "
//							+ Arrays.toString(registers));
//				}
				if ( // case 1
				((data[0].compareTo(data[1]) == 0) && //
				// if "i" and "j" are equals, the result must be 0
						(BigInteger.ZERO.compareTo(registers[0]) != 0))
						// case 2
						|| (((registers[0].compareTo(data[2]) == 0) ^ isLess)) // data[2] refers only to "Less" ..
								&& (data[0] != data[1]) // .. unless "i" ad "j" are equals: that's the first case
				) {
					errorsCounter++;
					System.out.println("ERROR: with data: " + Arrays.toString(data) + ", got registers: "
							+ Arrays.toString(registers));
				}
			}
			System.out.println(errorsCounter + " errors over " + TestCompareJunit.DATASET_LESS.length + " tests.");
		} else {
			boolean isCompact = TestCompareJunit.IntCompTest.CompareOverflowUnsafe == itc;
			for (BigInteger[] data : TestCompareJunit.DATASET_LESS) {
				if (isCompact) {
					registers[0] = BigInteger.ZERO;
					registers[1] = data[0];
					registers[2] = data[1];
				} else {
					registers[0] = registers[1] = registers[2] = BigInteger.ZERO;
					registers[3] = data[0];
					registers[4] = data[1];
				}
				fnToTest.b(registers);
				if (registers[0].intValue() != data[0].compareTo(data[1])) {
					errorsCounter++;
					System.out.println("ERROR: with data: " + Arrays.toString(data) + ", got registers: "
							+ Arrays.toString(registers) + " and expected : " + data[0].compareTo(data[1]));
				}
			}
			System.out.println(errorsCounter + " errors over " + TestCompareJunit.DATASET_LESS.length + " tests.");
		}
	}
}