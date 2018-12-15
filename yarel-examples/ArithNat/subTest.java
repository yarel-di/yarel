package ArithNat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class subTest {

	@Test
	void testSub0() {
		int[] in  = {1, 0};
		int[] out = {1, 0};
		RPP sub = new ArithNat.sub();
		assertArrayEquals(sub.b(in),out);
	}
	@Test
	void testSub1() {
		int[] in  = {1, 1};
		int[] out = {0, 1};
		RPP sub = new ArithNat.sub();
		assertArrayEquals(sub.b(in),out);
	}

	@Test
	void testSub2() {
		int[] in  = { 0, 1};
		int[] out = {-1, 1};
		RPP sub = new ArithNat.sub();
		assertArrayEquals(sub.b(in),out);
	}

	@Test
	void testSub3() {
		int[] in  = { 2, 3};
		int[] out = {-1, 3};
		RPP sub = new ArithNat.sub();
		assertArrayEquals(sub.b(in),out);
	}

}
