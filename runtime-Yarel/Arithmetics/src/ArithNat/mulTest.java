package ArithNat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class mulTest {

	@Test
	void testMulN() {
		RPP mul = new ArithNat.mulN();
		assertArrayEquals(mul.b(new int[] {0, 0, 0}),new int[] {0, 0, 0});
		assertArrayEquals(mul.b(new int[] {1, 0, 0}),new int[] {0, 1, 0});
		assertArrayEquals(mul.b(new int[] {0, 1, 0}),new int[] {0, 0, 1});
		assertArrayEquals(mul.b(new int[] {1, 1, 0}),new int[] {1, 1, 1});
		assertArrayEquals(mul.b(new int[] {2, 1, 0}),new int[] {2, 2, 1});
		assertArrayEquals(mul.b(new int[] {1, 2, 0}),new int[] {2, 1, 2});
		assertArrayEquals(mul.b(new int[] {2, 3, 0}),new int[] {6, 2, 3});
	}
}
