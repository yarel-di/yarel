package tests.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

import minorTests.JustASwap;

public class TestJustASwap {
	public static final int ADDITIONAL_REGISTERS = 1;

	public static int[] newRegs() {
		return new int[] { -3, 7, 5, 0, 1, 2, 0, -8, 4, 0, 3, 0, 0 };
	}

	@Test
	public void testJustASwap_ANegativeNumber2() {
		int k, i, t;
		int[] regs, exp;
		JustASwap s;
		regs = newRegs();
		exp = newRegs();
		k = 10;
		i = 7;
		t = exp[1];
		exp[1] = exp[i];
		exp[i] = t;
		s = new JustASwap(k, i);
		s.b(regs, 1, k + 2);
//		System.out.println(Arrays.toString(regs));
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testJustASwap_ANegativeNumber() {
		int k, i, t;
		int[] regs, exp;
		JustASwap s;
		regs = newRegs();
		exp = newRegs();
		k = 11;
		i = 8;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new JustASwap(k, i);
		s.b(regs);
//		System.out.println(Arrays.toString(regs));
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testJustASwap_First() {
		int k, i, t;
		int[] regs, exp;
		JustASwap s;
		regs = newRegs();
		exp = newRegs();
		k = 3;
		i = 1;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new JustASwap(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testJustASwap_Second() {
		int k, i, t;
		int[] regs, exp;
		JustASwap s;
		regs = newRegs();
		exp = newRegs();
		k = 3;
		i = 2;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new JustASwap(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testJustASwap_PreLast() {
		int k, i, t;
		int[] regs, exp;
		JustASwap s;
		regs = newRegs();
		exp = newRegs();
		k = 6;
		i = 5;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new JustASwap(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testJustASwap_Last() {
		int k, i, t;
		int[] regs, exp;
		JustASwap s;
		regs = newRegs();
		exp = newRegs();
		k = 6;
		i = 6;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new JustASwap(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testJustASwap_Middle() {
		int k, i, t;
		int[] regs, exp;
		JustASwap s;
		regs = newRegs();
		exp = newRegs();
		k = 6;
		i = 5;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new JustASwap(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	//

	@Test
	public void testJustASwap_First_LongerArray() {
		int k, i, t;
		int[] regs, exp;
		JustASwap s;
		regs = newRegs();
		exp = newRegs();
		k = 11;
		i = 1;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new JustASwap(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testJustASwap_Second_LongerArray() {
		int k, i, t;
		int[] regs, exp;
		JustASwap s;
		regs = newRegs();
		exp = newRegs();
		k = 11;
		i = 2;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new JustASwap(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testJustASwap_PreLast_LongerArray() {
		int k, i, t;
		int[] regs, exp;
		JustASwap s;
		regs = newRegs();
		exp = newRegs();
		k = 11;
		i = 10;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new JustASwap(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testJustASwap_Last_LongerArray() {
		int k, i, t;
		int[] regs, exp;
		JustASwap s;
		regs = newRegs();
		exp = newRegs();
		k = 11;
		i = 11;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new JustASwap(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testJustASwap_Middle_LongerArray() {
		int k, i, t;
		int[] regs, exp;
		JustASwap s;
		regs = newRegs();
		exp = newRegs();
		k = 11;
		i = 5;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new JustASwap(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testJustASwap_MiddleOverZero_LongerArray() {
		int k, i, t;
		int[] regs, exp;
		JustASwap s;
		regs = newRegs();
		exp = newRegs();
		k = 11;
		i = 7;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new JustASwap(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}
}
