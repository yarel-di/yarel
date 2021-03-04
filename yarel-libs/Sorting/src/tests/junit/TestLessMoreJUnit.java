package tests.junit;

import java.util.Arrays;

import org.junit.Test;

import yarelLib.PreparationLessMore;

public class TestLessMoreJUnit {

	@Test
	public void testLessPosPosLower() {
		int m, k = 1, i = 2, j = 4, p = 5, q = 6;
		int[] regs = { 0, 5, 0, 7, 0, 0, 0 };
		int[] exp = { 1, 5, 0, 7, 0, 0, 0 };
		m = regs.length - 1;
		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
		System.out.println("original registers: " + Arrays.toString(regs));
		(new PreparationLessMore(m, i, j, p, q, k)).b(regs);
		System.out.println("\t-> " + Arrays.toString(regs));
//		LessThan less;
//		less = new LessThan(m, i, j, p, q, k);
//		less.b(regs);
//		assertArrayEquals(exp, regs);
	}

	@Test
	public void testLessPosPosGreater() {
		int m, k = 1, i = 2, j = 4, p = 5, q = 6;
		int[] regs = { 0, 6, 0, 4, 0, 0, 0 };
		int[] exp = { 0, 6, 0, 4, 0, 0, 0 };
		m = regs.length - 1;
		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
		System.out.println("original registers: " + Arrays.toString(regs));
		(new PreparationLessMore(m, i, j, p, q, k)).b(regs);
		System.out.println("\t-> " + Arrays.toString(regs));
//		LessThan less;
//		less = new LessThan(m, i, j, p, q, k);
//		less.b(regs);
//		assertArrayEquals(exp, regs);
	}

	@Test
	public void testLessPosNeg() {
		int m, k = 5, i = 2, j = 4, p = 3, q = 1;
		int[] regs = { 0, 5, 0, -7, 0, 0, 0 };
		int[] exp = { 0, 5, 0, -7, 0, 0, 0 };
		m = regs.length - 1;
		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
		System.out.println("original registers: " + Arrays.toString(regs));
		(new PreparationLessMore(m, i, j, p, q, k)).b(regs);
		System.out.println("\t-> " + Arrays.toString(regs));
//		LessThan less;
//		less = new LessThan(m, i, j, p, q, k);
//		less.b(regs);
//		assertArrayEquals(exp, regs);
	}

	@Test
	public void testLessNegPos() {
		int m, k = 5, i = 2, j = 4, p = 6, q = 3;
		int[] regs = { 0, -2, 0, 4, 0, 0, 0 };
		int[] exp = { 1, -2, 0, 4, 0, 0, 0 };
		m = regs.length - 1;
		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
		System.out.println("original registers: " + Arrays.toString(regs));
		(new PreparationLessMore(m, i, j, p, q, k)).b(regs);
		System.out.println("\t-> " + Arrays.toString(regs));
//		LessThan less;
//		less = new LessThan(m, i, j, p, q, k);
//		less.b(regs);
//		assertArrayEquals(exp, regs);
	}

	@Test
	public void testLessNegNegGreater() {
		int m, k = 6, i = 2, j = 4, p = 5, q = 3;
		int[] regs = { 0, 5, 0, 7, 0, 0, 0 };
		int[] exp = { 1, 5, 0, 7, 0, 0, 0 };
		m = regs.length - 1;
		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
		System.out.println("original registers: " + Arrays.toString(regs));
		(new PreparationLessMore(m, i, j, p, q, k)).b(regs);
		System.out.println("\t-> " + Arrays.toString(regs));
//		LessThan less;
//		less = new LessThan(m, i, j, p, q, k);
//		less.b(regs);
//		assertArrayEquals(exp, regs);
	}

	@Test
	public void testLessNegNegLower() {
		int m, k = 6, i = 2, j = 4, p = 5, q = 1;
		int[] regs = { 0, -3, 0, -1, 0, 0, 0 };
		int[] exp = { 1, -3, 0, -1, 0, 0, 0 };
		m = regs.length - 1;
		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
		System.out.println("original registers: " + Arrays.toString(regs));
		(new PreparationLessMore(m, i, j, p, q, k)).b(regs);
		System.out.println("\t-> " + Arrays.toString(regs));
//		LessThan less;
//		less = new LessThan(m, i, j, p, q, k);
//		less.b(regs);
//		assertArrayEquals(exp, regs);
	}

}