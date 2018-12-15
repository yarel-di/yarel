package ArithNat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import Yarelcore.RPP;

class quoTest {

	@Test
	void testQuo0div0() {
		int[] in  = { 0, 0, 0, 0, 0};
		int[] out = { 0, 0, 0, 0, 0};
		RPP quo = new ArithNat.quo();
//		System.out.println(Arrays.toString(quo.b(in)));
		assertArrayEquals(quo.b(in),out);
	}

	@Test
	void testQuo0div1() {
		int[] in  = { 0, 1, 0, 0, 0};
		int[] out = { 0, 1, 0, 0, 0};
		RPP quo = new ArithNat.quo();
//		System.out.println(Arrays.toString(quo.b(in)));
		assertArrayEquals(quo.b(in),out);
	}

	@Test
	void testQuo0div2() {
		int[] in  = { 0, 2, 0, 0, 0};
		int[] out = { 0, 2, 0, 0, 0};
		RPP quo = new ArithNat.quo();
//		System.out.println(Arrays.toString(quo.b(in)));
		assertArrayEquals(quo.b(in),out);
	}

	@Test
	void testQuo2div2() {
		int[] in  = { 2, 2, 0, 0, 0};
		int[] out = {-2, 2, 1, 2, 2};
		RPP quo = new ArithNat.quo();
//		System.out.println(Arrays.toString(quo.b(in)));
		assertArrayEquals(quo.b(in),out);
	}

	@Test
	void testQuo3div2() {
		int[] in  = { 3, 2, 0, 0, 0};
		int[] out = {-3, 2, 1, 2, 3};
		RPP quo = new ArithNat.quo();
//		System.out.println(Arrays.toString(quo.b(in)));
		assertArrayEquals(quo.b(in),out);
	}

	@Test
	void testQuo4div2() {
		int[] in  = { 4, 2, 0, 0, 0};
		int[] out = {-4, 2, 2, 3, 4};
		RPP quo = new ArithNat.quo();
//		System.out.println(Arrays.toString(quo.b(in)));
		assertArrayEquals(quo.b(in),out);
	}

	@Test
	void testQuo8div3() {
		int[] in  = { 8, 3, 0, 0, 0};
		int[] out = {-16, 3, 2, 6, 8};
		RPP quo = new ArithNat.quo();
//		System.out.println(Arrays.toString(quo.b(in)));
		assertArrayEquals(quo.b(in),out);
	}

	@Test
	void testQuo9div3() {
		int[] in  = { 9, 3, 0, 0, 0};
		int[] out = {-18, 3, 3, 7, 9};
		RPP quo = new ArithNat.quo();
//		System.out.println(Arrays.toString(quo.b(in)));
		assertArrayEquals(quo.b(in),out);
	}
}
