package ArithNat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class disSelTest {

// reminder > 0
	@Test
	void testDisSel111() {
		int[] in  = {1, 1, 1};
		int[] out = {1, 1, 1};
		RPP disSel = new ArithNat.disSel();
//		System.out.println(Arrays.toString(disSel.b(in)));
		assertArrayEquals(disSel.b(in),out);
	}

 	@Test
	void testDisSel101() {
		int[] in  = {1, 0, 1};
		int[] out = {1, 0, 1};
		RPP disSel = new ArithNat.disSel();
//		System.out.println(Arrays.toString(disSel.b(in)));
		assertArrayEquals(disSel.b(in),out);
	}

 	@Test
	void testDisSel1m11() {
		int[] in  = {1,-1, 1};
		int[] out = {1,-1, 1};
		RPP disSel = new ArithNat.disSel();
//		System.out.println(Arrays.toString(disSel.b(in)));
		assertArrayEquals(disSel.b(in),out);
	}

// reminder == 0
 	@Test
	void testDisSel110() {
		int[] in  = {1, 1, 0};
		int[] out = {1, 2, 0};
		RPP disSel = new ArithNat.disSel();
//		System.out.println(Arrays.toString(disSel.b(in)));
		assertArrayEquals(disSel.b(in),out);
	}

 	@Test
	void testDisSel100() {
		int[] in  = {1, 0, 0};
		int[] out = {1, 1, 0};
		RPP disSel = new ArithNat.disSel();
//		System.out.println(Arrays.toString(disSel.b(in)));
		assertArrayEquals(disSel.b(in),out);
	}

 	@Test
	void testDisSel1m10() {
		int[] in  = {1,-1, 0};
		int[] out = {1, 0, 0};
		RPP disSel = new ArithNat.disSel();
//		System.out.println(Arrays.toString(disSel.b(in)));
		assertArrayEquals(disSel.b(in),out);
	}

// reminder < 0
 	@Test
	void testDisSel11m1() {
		int[] in  = {1, 1,-1};
		int[] out = {0, 2,-1};
		RPP disSel = new ArithNat.disSel();
//		System.out.println(Arrays.toString(disSel.b(in)));
		assertArrayEquals(disSel.b(in),out);
	}

 	@Test
	void testDisSel10m1() {
		int[] in  = {1, 0,-1};
		int[] out = {0, 1,-1};
		RPP disSel = new ArithNat.disSel();
//		System.out.println(Arrays.toString(disSel.b(in)));
		assertArrayEquals(disSel.b(in),out);
	}

 	@Test
	void testDisSel1m1m1() {
		int[] in  = {1,-1,-1};
		int[] out = {1, 0,-1};
		RPP disSel = new ArithNat.disSel();
//		System.out.println(Arrays.toString(disSel.b(in)));
		assertArrayEquals(disSel.b(in),out);
	}

}
