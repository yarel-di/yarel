package ArithNat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class mulTest {

	@Test
	void testMul0() {
		int[] in  = {0, 0, 0};
		int[] out = {0, 0, 0};
		RPP mul = new ArithNat.mul();
		assertArrayEquals(mul.b(in),out);
	}

	@Test
	void testMul1() {
		int[] in  = {1, 0, 0};
		int[] out = {0, 1, 0};
		RPP mul = new ArithNat.mul();
		assertArrayEquals(mul.b(in),out);
	}

	@Test
	void testMul2() {
		int[] in  = {0, 1, 0};
		int[] out = {0, 0, 1};
		RPP mul = new ArithNat.mul();
		assertArrayEquals(mul.b(in),out);
	}

	@Test
	void testMul3() {
		int[] in  = {1, 1, 0};
		int[] out = {1, 1, 1};
		RPP mul = new ArithNat.mul();
		assertArrayEquals(mul.b(in),out);
	}

	@Test
	void testMul4() {
		int[] in  = {2, 1, 0};
		int[] out = {2, 2, 1};
		RPP mul = new ArithNat.mul();
		assertArrayEquals(mul.b(in),out);
	}

	@Test
	void testMul5() {
		int[] in  = {1, 2, 0};
		int[] out = {2, 1, 2};
		RPP mul = new ArithNat.mul();
		assertArrayEquals(mul.b(in),out);
	}

	@Test
	void testMul6() {
		int[] in  = {2, 3, 0};
		int[] out = {6, 2, 3};
		RPP mul = new ArithNat.mul();
		assertArrayEquals(mul.b(in),out);
	}

}
