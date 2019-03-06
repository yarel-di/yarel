package ArithInt;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class sumTest {

	@Test
	void testSumBasicBehavior() {
		RPP sumRPP = new ArithInt.sum();
		RPP subRPP = new ArithInt.sub();
		assertArrayEquals(new int[] { 0, 0, 0,0,0},sumRPP.b(new int[] { 0, 0,0,0,0}));
		assertArrayEquals(new int[] { 3, 2, 1,0,0},sumRPP.b(new int[] { 2, 1,0,0,0}));
		assertArrayEquals(new int[] { 1, 2,-1,0,0},sumRPP.b(new int[] { 2,-1,0,0,0}));
		assertArrayEquals(new int[] {-1,-2, 1,0,0},sumRPP.b(new int[] {-2, 1,0,0,0}));
		assertArrayEquals(new int[] {-3,-2,-1,0,0},sumRPP.b(new int[] {-2,-1,0,0,0}));
	}

	@Test
	void testSubBasicBehavior() {
		RPP subRPP = new ArithInt.sub();
		assertArrayEquals(new int[] { 0, 0,0,0,0},subRPP.b(new int[] { 0, 0,0,0,0}));
		assertArrayEquals(new int[] { 2, 1,0,0,0},subRPP.b(new int[] { 3, 2, 1,0,0}));
		assertArrayEquals(new int[] { 2,-1,0,0,0},subRPP.b(new int[] { 1, 2,-1,0,0}));
		assertArrayEquals(new int[] {-2, 1,0,0,0},subRPP.b(new int[] {-1,-2, 1,0,0}));
		assertArrayEquals(new int[] {-2,-1,0,0,0},subRPP.b(new int[] {-3,-2,-1,0,0}));
	}	
	
	@Test
	void testReversibleOverflow() {
		RPP sumRPP = new ArithInt.sum();
		RPP subRPP = new ArithInt.sub();
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MIN_VALUE-1);
		System.out.println((Integer.MIN_VALUE-1)+1);
		assertArrayEquals(new int[] {Integer.MAX_VALUE,1,0,0,0}
                         ,subRPP.b(sumRPP.b(new int[] {Integer.MAX_VALUE,1,0,0,0})));
		assertArrayEquals(new int[] {Integer.MAX_VALUE,-1,0,0,0}
                         ,sumRPP.b(subRPP.b(new int[] {Integer.MAX_VALUE,-1,0,0,0})));
		assertArrayEquals(new int[] {Integer.MIN_VALUE,1,0,0,0}
                         ,sumRPP.b(subRPP.b(new int[] {Integer.MIN_VALUE,1,0,0,0})));
		assertArrayEquals(new int[] {Integer.MIN_VALUE,-1,0,0,0}
                         ,subRPP.b(sumRPP.b(new int[] {Integer.MIN_VALUE,-1,0,0,0})));
	}
}