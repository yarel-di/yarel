package tests.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import bubble4Fili.B4sort;
import yarelcore.RPP;

public class Test_B4F_General {

	/** Could be just one of the three sub-sections or the whole function- */
	public static RPP bubble4FiliSection = new B4sort();

	// this method is left as default
//	@BeforeClass
//	public static void instantiateBubble4Sorter() {
//		bubble4FiliSection = new B4sort();
//	}

	@ParameterizedTest
	@MethodSource(value = "providerB4FInts")
	public void testB4Sort(int[] reg) {
		int[] copyOriginal, registersSorted, registers;
		copyOriginal = Arrays.copyOf(reg, reg.length);
		Arrays.sort(copyOriginal);
		registersSorted = TestBubble4FiliJUnit.newRegisters(copyOriginal);
		copyOriginal = null; // free the memory
		registers = TestBubble4FiliJUnit.newRegisters(reg);
		bubble4FiliSection//
				.b(registers);
		if (!Arrays.equals(registers, registersSorted)) {
			System.out.println("\nWith reg: " + Arrays.toString(reg) + ",\n\t got: " + Arrays.toString(registers)
					+ ",\n\t expected: " + Arrays.toString(registersSorted));
		}
		assertArrayEquals(registers, registersSorted);
	}

//	static class Bubble4Registers {
//		int[] registers;
//
//		Bubble4Registers(int a0, int a1, int a2, int a3) {
//			registers[0] = a0;
//			registers[1] = a1;
//			registers[2] = a2;
//			registers[3] = a3;
//		}
//	}

	//

//	public static Stream<Bubble4Registers> providerBubble4Registers() {
//		return Stream.of(new Bubble4Registers[] { new Bubble4Registers(0, 0, 0, 0), // 0
//				new Bubble4Registers(1, 1, 1, 1), //
//				new Bubble4Registers(7, 7, 7, 7), //
//				new Bubble4Registers(-1, -1, -1, -1), //
//				new Bubble4Registers(-7, -7, -7, -7), //
//				new Bubble4Registers(-2, 0, 1, 3), // 5
//				new Bubble4Registers(5, 2, -1, -10), //
//				new Bubble4Registers(22, 100, 5, 1000), //
//				new Bubble4Registers(0, 7, -3, 1), //
//				new Bubble4Registers(2, -5, 3, 10), //
//				new Bubble4Registers(-2, 5, 3, 10), // 10
//				new Bubble4Registers(1, 2, 4, 3), //
//		});
//	}

	public static Stream<int[]> providerB4FInts() {
		return Stream.of(new int[][] { new int[] { 1, 1, 1, 1 }, //
				new int[] { 7, 7, 7, 7 }, //
				new int[] { -1, -1, -1, -1 }, //
				new int[] { -7, -7, -7, -7 }, //
				new int[] { -2, 0, 1, 3 }, // 5 // pure lui ...
				new int[] { 5, 2, -1, -10 }, //
				new int[] { 7, 12, 5, 15 }, // pure lui ...
				new int[] { 0, 7, -3, 1 }, // pure lui ...
				new int[] { 2, -5, 3, 10 }, // pure lui ...
				new int[] { -2, 5, 3, 10 }, // 10 pure lui ...
				new int[] { 1, 2, 4, 3 }, // pure lui ...
				new int[] { 1, 3, 2, 4 }, // pure lui ...
				new int[] { 8, -3, 0, 2 }, // pure lui ...
				new int[] { 4, 3, 2, 1 }, // 15
				new int[] { 2, 1, 3, 4 }, // pure lui ...
				new int[] { 1, 2, 3, 4 }, // pure lui ...
		});
	}

	// TOTALE: quelli non-crescenti (o mix) si impiantano

	public static void main(String[] args) {
		Objects.requireNonNull(bubble4FiliSection);
		System.out.println("START Test_B4F ALL");
		Test_B4F_General.providerB4FInts().forEach(
				// b::testB4Sort
				Test_B4F_General::testB4Manual_ALL);
		System.out.println("END Test_B4F ALL");
	}

	public static void testB4Manual_ALL(int[] r) {
		int[] registers = TestBubble4FiliJUnit.newRegisters(r);
		bubble4FiliSection.b(registers);
		System.out.println("Using " + Arrays.toString(r) + ", the result is: " + Arrays.toString(registers));
	}
}