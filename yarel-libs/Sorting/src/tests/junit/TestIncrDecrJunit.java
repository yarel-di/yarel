package tests.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import yarelLib.Decrement;
import yarelLib.Increment;

public class TestIncrDecrJunit {
//	@Rule
//	public final ExpectedException exception = ExpectedException.none();

	public static int[] newRegs() {
		return new int[] { 20, -15, 8, 0, 2, -3, 77, 0, 0, 0, 0 };
	}

	@Test
	public void testInc2_5() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[1] = -13;
		incr = new Increment(7, 2, 5);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc5_2() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[4] = 17;
		incr = new Increment(7, 5, 2);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc4_1() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[3] = 20;
		incr = new Increment(7, 4, 1);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc1_4() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[0] = 20;
		incr = new Increment(7, 1, 4);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc4_2() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[3] = 15;
		incr = new Increment(7, 4, 2);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc2_4() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[1] = -15;
		incr = new Increment(7, 2, 4);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc3_2() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[2] = 23;
		incr = new Increment(7, 3, 2);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc2_3() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[1] = -7;
		incr = new Increment(7, 2, 3);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc4_3() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[3] = 8;
		incr = new Increment(7, 4, 3);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc3_4() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[2] = 8;
		incr = new Increment(7, 3, 4);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc7_6() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[6] = 80;
		incr = new Increment(7, 7, 6);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc6_7() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[5] = 74;
		incr = new Increment(7, 6, 7);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc6_2() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[5] = 12;
		incr = new Increment(7, 6, 2);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc2_6() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[1] = -12;
		incr = new Increment(7, 2, 6);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testInc1_1() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[0] = 40;
		incr = new Increment(7, 1, 1);
		incr.b(r);
		if (Arrays.equals(exp, r)) {
			Assert.fail();
		}
	}

	@Test
	public void testInc2_2() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[1] = 0;
		incr = new Increment(7, 2, 2);
		incr.b(r);
		if (Arrays.equals(exp, r)) {
			Assert.fail();
		}
	}

	@Test
	public void testInc5_5() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[4] = 4;
		incr = new Increment(7, 5, 5);
		incr.b(r);
		if (Arrays.equals(exp, r)) {
			Assert.fail();
		}
	}

	@Test
	public void testInc6_6() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[5] = 0;
		incr = new Increment(7, 6, 6);
		incr.b(r);
		if (Arrays.equals(exp, r)) {
			Assert.fail();
		}
	}

	@Test
	public void testInc7_7() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
//		exp[6] = 154;
		incr = new Increment(7, 7, 7);
		incr.b(r);
		if (Arrays.equals(exp, r)) {
			Assert.fail();
		}
	}

	//

	// DEC

	//

	//

	@Test
	public void testDec2_5() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[1] = -17;
		decr = new Decrement(7, 2, 5);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec5_2() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[4] = -13;
		decr = new Decrement(7, 5, 2);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec4_1() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[3] = -20;
		decr = new Decrement(7, 4, 1);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec1_4() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[0] = 20;
		decr = new Decrement(7, 1, 4);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec4_2() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[3] = -15;
		decr = new Decrement(7, 4, 2);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec2_4() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[1] = -15;
		decr = new Decrement(7, 2, 4);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec3_2() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[2] = -7;
		decr = new Decrement(7, 3, 2);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec2_3() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[1] = -23;
		decr = new Decrement(7, 2, 3);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec4_3() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[3] = -8;
		decr = new Decrement(7, 4, 3);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec3_4() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[2] = 8;
		decr = new Decrement(7, 3, 4);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec7_6() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[6] = 74;
		decr = new Decrement(7, 7, 6);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec6_7() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[5] = -80;
		decr = new Decrement(7, 6, 7);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec6_2() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[5] = -18;
		decr = new Decrement(7, 6, 2);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec2_6() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[1] = -18;
		decr = new Decrement(7, 2, 6);
		decr.b(r);
		assertArrayEquals(exp, r);
	}

	@Test
	public void testDec1_1() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[0] = 40;
		decr = new Decrement(7, 1, 1);
		decr.b(r);
		if (Arrays.equals(exp, r)) {
			Assert.fail();
		}
	}

	@Test
	public void testDec2_2() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[1] = 0;
		decr = new Decrement(7, 2, 2);
		decr.b(r);
		if (Arrays.equals(exp, r)) {
			Assert.fail();
		}
	}

	@Test
	public void testDec5_5() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[4] = 4;
		decr = new Decrement(7, 5, 5);
		decr.b(r);
		if (Arrays.equals(exp, r)) {
			Assert.fail();
		}
	}

	@Test
	public void testDec6_6() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[5] = 0;
		decr = new Decrement(7, 6, 6);
		decr.b(r);
		if (Arrays.equals(exp, r)) {
			Assert.fail();
		}
	}

	@Test
	public void testDec7_7() {
		Decrement decr;
		int[] r = newRegs();
		int[] exp = newRegs();
//		exp[6] = 154;
		decr = new Decrement(7, 7, 7);
		decr.b(r);
		if (Arrays.equals(exp, r)) {
			Assert.fail();
		}
	}

//	@Test
//	public void testInc8_8_IIOB() {
//		Increment incr;
//		int[] r = newRegs();
//		int[] exp = newRegs();
//		exp[5] = 40;
//		try {
//			incr = new Increment(7, 8, 8);
//			incr.b(r);
//			System.out.println("REGS at testInc8_8_IIOB: " + Arrays.toString(r));
//			assertArrayEquals(exp, r);
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//			assertTrue(true);
//		}
//	}
}
