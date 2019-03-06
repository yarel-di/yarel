package ArithNat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class subTest {

	@Test
	void testSubN() {
		RPP sub = new ArithNat.subN();
		assertArrayEquals(sub.b(new int[] {1,0}),new int[] { 1,0});
		assertArrayEquals(sub.b(new int[] {1,1}),new int[] { 0,1});
		assertArrayEquals(sub.b(new int[] {0,1}),new int[] {-1,1});
		assertArrayEquals(sub.b(new int[] {2,3}),new int[] {-1,3});
	}
}
