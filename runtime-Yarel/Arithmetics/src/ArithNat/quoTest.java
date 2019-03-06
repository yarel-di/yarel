package ArithNat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import Yarelcore.RPP;

class quoTest {

	@Test
	void testQuoN() {
		RPP quo = new ArithNat.quoN();
//		System.out.println(Arrays.toString(quo.b(in)));
		assertArrayEquals(quo.b(new int[] { 0, 0, 0, 0, 0}),new int[] {  0, 0, 0, 0, 0});
		assertArrayEquals(quo.b(new int[] { 0, 1, 0, 0, 0}),new int[] {  0, 1, 0, 0, 0});
		assertArrayEquals(quo.b(new int[] { 0, 2, 0, 0, 0}),new int[] {  0, 2, 0, 0, 0});
		assertArrayEquals(quo.b(new int[] { 2, 2, 0, 0, 0}),new int[] { -2, 2, 1, 2, 2});
		assertArrayEquals(quo.b(new int[] { 3, 2, 0, 0, 0}),new int[] { -3, 2, 1, 2, 3});
		assertArrayEquals(quo.b(new int[] { 4, 2, 0, 0, 0}),new int[] { -4, 2, 2, 3, 4});
		assertArrayEquals(quo.b(new int[] { 8, 3, 0, 0, 0}),new int[] {-16, 3, 2, 6, 8});
		assertArrayEquals(quo.b(new int[] { 9, 3, 0, 0, 0}),new int[] {-18, 3, 3, 7, 9});
	}
}
