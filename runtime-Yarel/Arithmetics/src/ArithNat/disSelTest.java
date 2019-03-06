package ArithNat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class disSelTest {

	@Test
	void testDisSelN() {
		RPP disSel = new ArithNat.disSelN();
//		System.out.println(Arrays.toString(disSel.b()));
		assertArrayEquals(disSel.b(new int[] {1, 1, 1}),new int[] {1, 1, 1});
		assertArrayEquals(disSel.b(new int[] {1, 0, 1}),new int[] {1, 0, 1});
		assertArrayEquals(disSel.b(new int[] {1,-1, 1}),new int[] {1,-1, 1});
		assertArrayEquals(disSel.b(new int[] {1, 1, 0}),new int[] {1, 2, 0});
		assertArrayEquals(disSel.b(new int[] {1, 0, 0}),new int[] {1, 1, 0});
		assertArrayEquals(disSel.b(new int[] {1,-1, 0}),new int[] {1, 0, 0});
		assertArrayEquals(disSel.b(new int[] {1, 1,-1}),new int[] {0, 2,-1});
		assertArrayEquals(disSel.b(new int[] {1, 0,-1}),new int[] {0, 1,-1});
		assertArrayEquals(disSel.b(new int[] {1,-1,-1}),new int[] {1, 0,-1});
	}


}
