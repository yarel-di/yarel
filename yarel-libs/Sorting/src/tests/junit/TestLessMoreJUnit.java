package tests.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import yarelLib.LessThan;

public class TestLessMoreJUnit {
	static final int ADDITIONAL_REGISTERS = 6;

	@Test
	public void testLessPosPosLower() {
		int m, k = 1, i = 2, j = 4, p = 5, q = 6;
		int[] exp, regs = { 0, 5, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
//		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
//		System.out.println("original registers: " + Arrays.toString(regs));
//		(new PreparationLessMore(m, i, j, p, q, k)).b(regs);
//		System.out.println("\t-> " + Arrays.toString(regs));
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testLessPosPosGreater() {
		int m, k = 1, i = 2, j = 4, p = 5, q = 6;
		int[] exp, regs = { 0, 6, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
//		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
//		System.out.println("original registers: " + Arrays.toString(regs));
//		(new PreparationLessMore(m, i, j, p, q, k)).b(regs);
//		System.out.println("\t-> " + Arrays.toString(regs));
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testLessPosNeg() {
		int m, k = 5, i = 2, j = 4, p = 3, q = 1;
		int[] exp, regs = { 0, 5, 0, -7, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
//		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
//		System.out.println("original registers: " + Arrays.toString(regs));
//		(new PreparationLessMore(m, i, j, p, q, k)).b(regs);
//		System.out.println("\t-> " + Arrays.toString(regs));
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testLessNegPos() {
		int m, k = 5, i = 2, j = 4, p = 6, q = 3;
		int[] exp, regs = { 0, -2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
//		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
//		System.out.println("original registers: " + Arrays.toString(regs));
//		(new PreparationLessMore(m, i, j, p, q, k)).b(regs);
//		System.out.println("\t-> " + Arrays.toString(regs));
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testLessNegNegGreater() {
		int m, k = 6, i = 2, j = 4, p = 5, q = 3;
		int[] exp, regs = { 0, -10, 0, -25, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
//		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
//		System.out.println("original registers: " + Arrays.toString(regs));
//		(new PreparationLessMore(m, i, j, p, q, k)).b(regs);
//		System.out.println("\t-> " + Arrays.toString(regs));
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testLessNegNegLower() {
		int m, k = 6, i = 2, j = 4, p = 5, q = 1;
		int[] exp, regs = { 0, -3, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
//		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
//		System.out.println("original registers: " + Arrays.toString(regs));
//		(new PreparationLessMore(m, i, j, p, q, k)).b(regs);
//		System.out.println("\t-> " + Arrays.toString(regs));
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

}