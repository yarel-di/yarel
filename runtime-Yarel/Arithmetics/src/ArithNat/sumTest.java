package ArithNat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class sumTest {

	@Test
	void testSum() {
		RPP sum = new ArithNat.sumN();
		assertArrayEquals(sum.b(new int[] {0,0}),new int[] {0,0});
		assertArrayEquals(sum.b(new int[] {0,1}),new int[] {1,1});
		assertArrayEquals(sum.b(new int[] {1,0}),new int[] {1,0});
	}
}
