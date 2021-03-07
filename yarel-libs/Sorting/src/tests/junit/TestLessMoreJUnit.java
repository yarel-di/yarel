package tests.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import yarelLib.CompareThan;
import yarelLib.LessThan;
import yarelLib.MoreThan;

public class TestLessMoreJUnit {
	static final int ADDITIONAL_REGISTERS = 6;

	@Test
	public void testLessPosPosLower() {
		int m, k = 1, i = 2, j = 4, p = 5, q = 6;
		int[] exp, regs = { 0, 5, 0, 7, 0, 0, //
				0, 0, 0, 0, 0, 0 };
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
		int[] exp, regs = { 0, 6, 0, 4, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testLessPosNeg() {
		int m, k = 5, i = 2, j = 4, p = 3, q = 1;
		int[] exp, regs = { 0, 5, 0, -7, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testLessNegPos() {
		int m, k = 5, i = 2, j = 4, p = 6, q = 3;
		int[] exp, regs = { 0, -2, 0, 4, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testLessNegNegGreater() {
		int m, k = 6, i = 2, j = 4, p = 5, q = 3;
		int[] exp, regs = { 0, -10, 0, -25, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testLessNegNegLower() {
		int m, k = 6, i = 2, j = 4, p = 5, q = 1;
		int[] exp, regs = { 0, -3, 0, -1, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testLessPosEquals() {
		int m, k = 1, i = 2, j = 4, p = 5, q = 2;
		int[] exp, regs = { 0, 0, 0, 6, 0, 6, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		exp[(i = m) - 1] = 6;
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testLessNegEquals() {
		int m, k = 5, i = 2, j = 4, p = 3, q = 1;
		int[] exp, regs = { 0, -13, 0, -13, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testLessZero() {
		int m, k = 5, i = 1, j = 3, p = 6, q = 3;
		int[] exp, regs = { 0, -2, 0, 4, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		LessThan less;
		less = new LessThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	///

	//

	@Test
	public void testMorePosPosLower() {
		int m, k = 1, i = 2, j = 4, p = 5, q = 6;
		int[] exp, regs = { 0, 5, 0, 7, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
//		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
//		System.out.println("original registers: " + Arrays.toString(regs));
//		(new PreparationMoreMore(m, i, j, p, q, k)).b(regs);
//		System.out.println("\t-> " + Arrays.toString(regs));
		MoreThan less;
		less = new MoreThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMorePosPosGreater() {
		int m, k = 1, i = 2, j = 4, p = 5, q = 6;
		int[] exp, regs = { 0, 6, 0, 4, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
		MoreThan less;
		less = new MoreThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMorePosNeg() {
		int m, k = 5, i = 2, j = 4, p = 3, q = 1;
		int[] exp, regs = { 0, 5, 0, -7, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
		MoreThan less;
		less = new MoreThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMoreNegPos() {
		int m, k = 5, i = 2, j = 4, p = 6, q = 3;
		int[] exp, regs = { 0, -2, 0, 4, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		MoreThan less;
		less = new MoreThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMoreNegNegGreater() {
		int m, k = 6, i = 2, j = 4, p = 5, q = 3;
		int[] exp, regs = { 0, -10, 0, -25, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
		MoreThan less;
		less = new MoreThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMoreNegNegLower() {
		int m, k = 6, i = 2, j = 4, p = 5, q = 1;
		int[] exp, regs = { 0, -3, 0, -1, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		MoreThan less;
		less = new MoreThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMorePosEquals() {
		int m, k = 2, i = -100, j = 4, p = 5, q = 1;
		int[] exp, regs = { 0, 0, 0, 3, 0, 3, //
				//
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[(i = m) - 1] = 3;
		exp[k - 1] = 0;
		MoreThan less;
		less = new MoreThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMoreNegEquals() {
		int m, k = 5, i = 2, j = 4, p = 3, q = 1;
		int[] exp, regs = { 0, -7, 0, -7, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		MoreThan less;
		less = new MoreThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testMoreZero() {
		int m, k = 5, i = 1, j = 3, p = 6, q = 3;
		int[] exp, regs = { 0, 0, 0, 0, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		MoreThan less;
		less = new MoreThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	///

	//

	@Test
	public void testComparePosPosLower() {
		int m, k = 1, i = 2, j = 4, p = 5, q = 6;
		int[] exp, regs = { 0, 5, 0, 7, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = -1;
//		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
//		System.out.println("original registers: " + Arrays.toString(regs));
//		(new PreparationCompareCompare(m, i, j, p, q, k)).b(regs);
//		System.out.println("\t-> " + Arrays.toString(regs));
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testComparePosPosGreater() {
		int m, k = 1, i = 2, j = 4, p = 5, q = 6;
		int[] exp, regs = { 0, 6, 0, 4, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testComparePosNeg() {
		int m, k = 5, i = 2, j = 4, p = 3, q = 1;
		int[] exp, regs = { 0, 5, 0, -7, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testCompareNegPos() {
		int m, k = 5, i = 2, j = 4, p = 6, q = 3;
		int[] exp, regs = { 0, -2, 0, 4, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = -1;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testCompareNegNegGreater() {
		int m, k = 6, i = 2, j = 4, p = 5, q = 3;
		int[] exp, regs = { 0, -10, 0, -25, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testCompareNegNegLower() {
		int m, k = 6, i = 2, j = 4, p = 5, q = 1;
		int[] exp, regs = { 0, -3, 0, -1, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = -1;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testComparePosEquals() {
		int m, k = 1, i = 2, j = 4, p = 5, q = 6;
		int[] exp, regs = { 0, 1, 0, 1, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testCompareNegEquals() {
		int m, k = 5, i = 2, j = 4, p = 3, q = 1;
		int[] exp, regs = { 0, -7, 0, -7, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testCompareZero() {
		int m, k = 5, i = 1, j = 3, p = 6, q = 3;
		int[] exp, regs = { 0, -2, 0, 4, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	///

	//

	@Test
	public void testComparePosPosLower_EXTREMIS() {
		int m, k = 2, i = 1, j = 6, p = 5, q = 3;
		int[] exp, regs = { -3, 0, 0, 0, 0, 9, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = -1;
//		System.out.println("\n\n\n m: " + m + ", k: " + k + ", i: " + i + ", j: " + j + ", p: " + p + ", q: " + q);
//		System.out.println("original registers: " + Arrays.toString(regs));
//		(new PreparationCompareCompare(m, i, j, p, q, k)).b(regs);
//		System.out.println("\t-> " + Arrays.toString(regs));
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testComparePosPosGreater_EXTREMIS() {
		int m, k = 2, i = 1, j = 6, p = 5, q = 3;
		int[] exp, regs = { 23, 0, 0, 0, 0, 9, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testComparePosNeg_EXTREMIS() {
		int m, k = 2, i = 1, j = 6, p = 5, q = 3;
		int[] exp, regs = { 3, 0, 0, 0, 0, -9, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testCompareNegPos_EXTREMIS() {
		int m, k = 2, i = 1, j = 6, p = 5, q = 3;
		int[] exp, regs = { -3, 0, 0, 0, 0, 9, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = -1;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testCompareNegNegGreater_EXTREMIS() {
		int m, k = 2, i = 1, j = 6, p = 5, q = 3;
		int[] exp, regs = { -3, 0, 0, 0, 0, -9, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 1;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testCompareNegNegLower_EXTREMIS() {
		int m, k = 2, i = 1, j = 6, p = 5, q = 3;
		int[] exp, regs = { -3, 0, 0, 0, 0, 9, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = -1;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testComparePosEquals_EXTREMIS() {
		int m, k = 2, i = 1, j = 6, p = 5, q = 3;
		int[] exp, regs = { 9, 0, 0, 0, 0, 9, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testCompareNegEquals_EXTREMIS() {
		int m, k = 2, i = 1, j = 6, p = 5, q = 3;
		int[] exp, regs = { -3, 0, 0, 0, 0, -3, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

	@Test
	public void testCompareZero_EXTREMIS() {
		int m, k = 2, i = 1, j = 6, p = 5, q = 3;
		int[] exp, regs = { 0, 0, 0, 0, 0, 0, //
				0, 0, 0, 0, 0, 0 };
		m = regs.length - ADDITIONAL_REGISTERS;
		exp = Arrays.copyOf(regs, regs.length);
		exp[k - 1] = 0;
		CompareThan less;
		less = new CompareThan(m, i, j, p, q, k);
		less.b(regs);
		assertArrayEquals(exp, regs, "Got array: " + Arrays.toString(regs) + ",\n\t exp: " + Arrays.toString(exp));
	}

}