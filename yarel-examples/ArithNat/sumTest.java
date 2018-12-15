package ArithNat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class sumTest {

	@Test
	void testSum0() {
		int[] in  = {0, 0};
		int[] out = {0, 0};
		RPP sum = new ArithNat.sum();
		assertArrayEquals(sum.b(in),out);
	}
	@Test
	void testSum1() {
		int[] in  = {0, 1};
		int[] out = {1, 1};
		RPP sum = new ArithNat.sum();
		assertArrayEquals(sum.b(in),out);
	}
	@Test
	void testSum2() {
		int[] in  = {1, 0};
		int[] out = {1, 0};
		RPP sum = new ArithNat.sum();
		assertArrayEquals(sum.b(in),out);
	}

}
