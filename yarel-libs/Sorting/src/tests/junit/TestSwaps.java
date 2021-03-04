package tests.junit;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import yarelLib.SwapSRLlike;
import yarelcore.Swap;

public class TestSwaps {
	static int[] newRegs() {
		return new int[] { 4, 0, 1, -5, 2, -8, -0, 13, -1, 0, 0 };
	}

	// used "r.length -1" instead of "r.length" as the Swap's K because the last
	// register is the 0-ancilla

	@Test
	public void testPosPosInsideNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 3;
		second = 5;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testPosPosInsideYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 3;
		second = 5;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testPosPosInsideBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 3;
		second = 5;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	//

	@Test
	public void testPosNegInsideNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 5;
		second = 6;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testPosNegInsideYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 5;
		second = 6;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testPosNegInsideBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 5;
		second = 6;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	//

	@Test
	public void testNegPosInsideNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 4;
		second = 5;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testNegPosInsideYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 4;
		second = 5;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testNegPosInsideBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 4;
		second = 5;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	//

	@Test
	public void testNegNegInsideNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 6;
		second = 9;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testNegNegInsideYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 6;
		second = 9;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testNegNegInsideBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 6;
		second = 9;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	//

	@Test
	public void testFirstMiddNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 1;
		second = 3;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testFirstMiddYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 1;
		second = 3;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testFirstMiddBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 1;
		second = 3;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	//

	@Test
	public void testMiddLastNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 9;
		second = 2;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testMiddLastYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 9;
		second = 2;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testMiddLastBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 9;
		second = 2;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	//

	@Test
	public void testFirstLastNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 1;
		second = 9;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testFirstLastYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 1;
		second = 9;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testFirstLastBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 1;
		second = 9;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	//

	@Test
	public void testFirstSecondNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 1;
		second = 2;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testFirstSecondYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 1;
		second = 2;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testFirstSecondBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 1;
		second = 2;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	//

	@Test
	public void testLastPrevNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 9;
		second = 8;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testLastPrevYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 9;
		second = 8;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testLastPrevBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 9;
		second = 8;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	//

	//

	//

	@Test
	public void testBothFirstNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 1;
		second = 1;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testBothFirstYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 1;
		second = 1;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testBothFirstBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 1;
		second = 1;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	//

	@Test
	public void testBothSecondNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 2;
		second = 2;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testBothSecondYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 2;
		second = 2;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testBothSecondBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 2;
		second = 2;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	//

	@Test
	public void testBothMiddleNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 6;
		second = 6;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testBothMiddleYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 6;
		second = 6;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testBothMiddleBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 6;
		second = 6;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	//

	@Test
	public void testBothPrevThanLastNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 8;
		second = 8;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testBothPrevThanLastYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 8;
		second = 8;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testBothPrevThanLastBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 8;
		second = 8;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	//

	@Test
	public void testBothLastNative() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 9;
		second = 9;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		Swap s = new Swap(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testBothLastYarel() {
		int t, first, second;
		int[] r = newRegs(), e = newRegs();
		first = 9;
		second = 9;
		t = e[first - 1];
		e[first - 1] = e[second - 1];
		e[second - 1] = t;
		SwapSRLlike s = new SwapSRLlike(r.length - 2, first, second);
		s.b(r);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

	@Test
	public void testBothLastBoth() {
		int first, second;
		int[] r = newRegs(), e = newRegs();
		first = 9;
		second = 9;
		Swap ssrl = new Swap(r.length - 2, first, second);
		SwapSRLlike syarel = new SwapSRLlike(r.length - 2, first, second);
		ssrl.b(r);
		syarel.b(e);
		assertArrayEquals("Got array: " + Arrays.toString(r) + ",\n\t exp: " + Arrays.toString(e), e, r);
	}

}
