package tests.junit;

import java.util.Arrays;
import java.util.Objects;

import bubble4Fili.B4sort_p2;

public class Test_B4F_Part2 extends Test_B4F_General {
//	@BeforeClass
	public static void instantiateBubble4Sorter_Part1() {
		bubble4FiliSection = new B4sort_p2();
	}

//	@Override
//	@ParameterizedTest
//
//	@MethodSource(value = "providerB4FInts")
//	public void testB4Sort(int[] r) {
//		super.testB4Sort(r);
//	}

	public static void main(String[] args) {
//		Test_B4F_Part1 b;
//		b = new Test_B4F_Part1();
		instantiateBubble4Sorter_Part1();
		Objects.requireNonNull(bubble4FiliSection);
		System.out.println("START Test_B4F_Part2");
		Test_B4F_General.providerB4FInts().forEach(
				// b::testB4Sort
				Test_B4F_Part2::testB4Manual);
		System.out.println("END Test_B4F_Part2");
	}

	public static void testB4Manual(int[] r) {
		int[] registers = TestBubble4FiliJUnit.newRegisters(r);
		bubble4FiliSection.b(registers);
		registers[4] = 0; // reset the "k"
		bubble4FiliSection.b(registers);
		System.out.println("Using " + Arrays.toString(r) + ", the result is: " + Arrays.toString(registers));
	}
}