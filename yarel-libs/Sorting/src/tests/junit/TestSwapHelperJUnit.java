package tests.junit;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import yarelLib.SwapParamHelper;

public class TestSwapHelperJUnit {
	public static final int ADDITIONAL_REGISTERS = 1;

	public static int[] newRegs() {
		return new int[] { -3, 7, 5, 0, 1, 2, 0, -8, 4, 0, 3, 0, 0 };
	}

	@Test
	public void testSH_First() {
		int k, i, t;
		int[] regs, exp;
		SwapParamHelper s;
		regs = newRegs();
		exp = newRegs();
		k = 3;
		i = 1;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new SwapParamHelper(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testSH_Second() {
		int k, i, t;
		int[] regs, exp;
		SwapParamHelper s;
		regs = newRegs();
		exp = newRegs();
		k = 3;
		i = 2;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new SwapParamHelper(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testSH_PreLast() {
		int k, i, t;
		int[] regs, exp;
		SwapParamHelper s;
		regs = newRegs();
		exp = newRegs();
		k = 6;
		i = 5;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new SwapParamHelper(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testSH_Last() {
		int k, i, t;
		int[] regs, exp;
		SwapParamHelper s;
		regs = newRegs();
		exp = newRegs();
		k = 6;
		i = 6;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new SwapParamHelper(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testSH_Middle() {
		int k, i, t;
		int[] regs, exp;
		SwapParamHelper s;
		regs = newRegs();
		exp = newRegs();
		k = 6;
		i = 5;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new SwapParamHelper(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	//

	@Test
	public void testSH_First_LongerArray() {
		int k, i, t;
		int[] regs, exp;
		SwapParamHelper s;
		regs = newRegs();
		exp = newRegs();
		k = 11;
		i = 1;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new SwapParamHelper(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testSH_Second_LongerArray() {
		int k, i, t;
		int[] regs, exp;
		SwapParamHelper s;
		regs = newRegs();
		exp = newRegs();
		k = 11;
		i = 2;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new SwapParamHelper(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testSH_PreLast_LongerArray() {
		int k, i, t;
		int[] regs, exp;
		SwapParamHelper s;
		regs = newRegs();
		exp = newRegs();
		k = 11;
		i = 10;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new SwapParamHelper(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testSH_Last_LongerArray() {
		int k, i, t;
		int[] regs, exp;
		SwapParamHelper s;
		regs = newRegs();
		exp = newRegs();
		k = 11;
		i = 11;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new SwapParamHelper(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testSH_Middle_LongerArray() {
		int k, i, t;
		int[] regs, exp;
		SwapParamHelper s;
		regs = newRegs();
		exp = newRegs();
		k = 11;
		i = 5;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new SwapParamHelper(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}

	@Test
	public void testSH_MiddleOverZero_LongerArray() {
		int k, i, t;
		int[] regs, exp;
		SwapParamHelper s;
		regs = newRegs();
		exp = newRegs();
		k = 11;
		i = 7;
		t = exp[0];
		exp[0] = exp[i - 1];
		exp[i - 1] = t;
		s = new SwapParamHelper(k, i);
		s.b(regs);
		assertArrayEquals(exp, regs);
	}
}