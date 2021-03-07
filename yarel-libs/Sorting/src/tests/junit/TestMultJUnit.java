package tests.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import yarelLib.Mult;

public class TestMultJUnit {
	public static final int ADDITIONAL_REGISTERS = 4;

	///

	//

	@Test
	public void testMultPosPosLowerOne() {
		int m, k = 1, i = 2, j = 4;
		int[] exp, regs = { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
//	System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
//	System.out.println("original registers: " + Arrays.toString(regs));
//	(new PreparationCompareCompare(m, i, j, p, q, k)).b(regs);
//	System.out.println("\t-> " + Arrays.toString(regs));
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMultPosPosLower() {
		int m, k = 1, i = 2, j = 4;
		int[] exp, regs = { 0, 5, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 35;
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMultPosPosGreater() {
		int m, k = 1, i = 2, j = 4;
		int[] exp, regs = { 7, 6, 0, 4, 7, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 31;
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMultPosNeg() {
		int m, k = 6, i = 2, j = 4;
		int[] exp, regs = { 0, 5, 0, -7, 0, 10, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = -45;
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMultNegPos() {
		int m, k = 5, i = 2, j = 4;
		int[] exp, regs = { 0, -2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = -8;
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMultNegNegGreater() {
		int m, k = 6, i = 2, j = 4;
		int[] exp, regs = { 0, -10, 0, -25, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 250;
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMultNegNegLower() {
		int m, k = 6, i = 2, j = 4;
		int[] exp, regs = { 0, -3, 0, -8, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 24;
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMultNegNegLowerOne() {
		int m, k = 6, i = 2, j = 4;
		int[] exp, regs = { 0, -3, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 3;
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMultPosEquals() {
		int m, k = 1, i = 2, j = 4;
		int[] exp, regs = { 0, 2, 0, 25, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 50;
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMultPosEqualsOne() {
		int m, k = 1, i = 2, j = 4;
		int[] exp, regs = { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMultNegEquals() {
		int m, k = 5, i = 2, j = 4;
		int[] exp, regs = { 0, -7, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 49;
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMultZero() {
		int m, k = 5, i = 1, j = 3;
		int[] exp, regs = { 0, -2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMultDifferentSignPosExistingRegister() {
		int m, k = 3, i = 4, j = 2;
		int[] exp, regs = { 0, -2, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = -9;
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMultDifferentSignNegExistingRegister() {
		int m, k = 3, i = 4, j = 2;
		int[] exp, regs = { 0, -2, -12, 4, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 4;
		Mult mult;
		mult = new Mult(m, k, j, i);
		mult.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}
}
