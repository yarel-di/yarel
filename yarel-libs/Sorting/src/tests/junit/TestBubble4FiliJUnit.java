package tests.junit;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import bubble4Fili.B4sort;
import yarelcore.RPP;

public class TestBubble4FiliJUnit {
	public static RPP bubble4Fili;

	@BeforeClass
	public static void instantiateBubble4Sorter() {
		bubble4Fili = new B4sort();
	}

	@Test
	public void testAllZeros() {
		int[] registers = newRegisters(0, 0, 0, 0);
		bubble4Fili.b(registers);
		registers = newRegisters(registers[0], registers[1], registers[2], registers[3]);
		assertArrayEquals(registers, newRegisters(0, 0, 0, 0));
	}

	@Test
	public void testAllEqualsOne() {
		int[] registers = newRegisters(1, 1, 1, 1);
		bubble4Fili.b(registers);
		registers = newRegisters(registers[0], registers[1], registers[2], registers[3]);
		assertArrayEquals(registers, newRegisters(1, 1, 1, 1));
	}

	@Test
	public void testAllEquals() {
		int[] registers = newRegisters(7, 7, 7, 7);
		bubble4Fili.b(registers);
		registers = newRegisters(registers[0], registers[1], registers[2], registers[3]);
		assertArrayEquals(registers, newRegisters(7, 7, 7, 7));
	}

	@Test
	public void testAllEqualsOneNegative() {
		int[] registers = newRegisters(-1, -1, -1, -1);
		bubble4Fili.b(registers);
		registers = newRegisters(registers[0], registers[1], registers[2], registers[3]);
		assertArrayEquals(registers, newRegisters(-1, -1, -1, -1));
	}

	@Test
	public void testAllEqualsNegative() {
		int[] registers = newRegisters(-7, -7, -7, -7);
		bubble4Fili.b(registers);
		registers = newRegisters(registers[0], registers[1], registers[2], registers[3]);
		assertArrayEquals(registers, newRegisters(-7, -7, -7, -7));
	}

	@Test
	public void testAlreadySorted() {
		int[] registers = newRegisters(-2, 0, 1, 3);
		bubble4Fili.b(registers);
		registers = newRegisters(registers[0], registers[1], registers[2], registers[3]);
		assertArrayEquals(registers, newRegisters(-2, 0, 1, 3));
	}

	@Test
	public void testSortedInverted() {
		int[] registers = newRegisters(5, 2, -1, -10);
		bubble4Fili.b(registers);
		registers = newRegisters(registers[0], registers[1], registers[2], registers[3]);
		assertArrayEquals(registers, newRegisters(-10, -1, 2, 5));
	}

	@Test
	public void test3MixTop() {
		int[] registers = newRegisters(22, 100, 5, 1000);
		bubble4Fili.b(registers);
		registers = newRegisters(registers[0], registers[1], registers[2], registers[3]);
		assertArrayEquals(registers, newRegisters(5, 22, 100, 1000));
	}

	@Test
	public void test3MixBottom() {
		int[] registers = newRegisters(0, 7, -3, 1);
		bubble4Fili.b(registers);
		registers = newRegisters(registers[0], registers[1], registers[2], registers[3]);
		assertArrayEquals(registers, newRegisters(-3, 0, 1, 7));
	}

	@Test
	public void testPairSwappedTop() {
		int[] registers = newRegisters(2, -5, 3, 10);
		bubble4Fili.b(registers);
		registers = newRegisters(registers[0], registers[1], registers[2], registers[3]);
		assertArrayEquals(registers, newRegisters(-5, 2, 3, 10));
	}

	@Test
	public void testPairSwappedMiddle() {
		int[] registers = newRegisters(-2, 5, 3, 10);
		bubble4Fili.b(registers);
		registers = newRegisters(registers[0], registers[1], registers[2], registers[3]);
		assertArrayEquals(registers, newRegisters(-2, 3, 5, 10));
	}

	@Test
	public void testPairSwappedBottom() {
		int[] registers = newRegisters(1, 2, 4, 3);
		bubble4Fili.b(registers);
		registers = newRegisters(registers[0], registers[1], registers[2], registers[3]);
		assertArrayEquals(registers, newRegisters(1, 2, 3, 4));
	}

	public static int[] newRegisters(int... a) {
		int[] registers = new int[10];
		Arrays.fill(registers, 0);
//		registers[0] = a0;
//		registers[1] = a1;
//		registers[2] = a2;
//		registers[3] = a3;
		for (int i = 0; i < a.length; i++) {
			registers[i] = a[i];
		}
		return registers;
	}
}