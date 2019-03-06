package Quotient;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

public class quoTest {

	@Test
	void testB() {
		RPP quoRPP = new Quotient.quo();
		
		assertArrayEquals(new int[] {1,1,1,0,0,0}, quoRPP.b(new int[] {1,1,0,0,0,0}));
		assertArrayEquals(new int[] {1,200,0,1,0,0}, quoRPP.b(new int[] {1,200,0,0,0,0}));
		assertArrayEquals(new int[] {0,10,0,0,0,0}, quoRPP.b(new int[] {0,10,0,0,0,0}));
		
		assertArrayEquals(new int[] {11,1,11,0,0,0}, quoRPP.b(new int[] {11,1,0,0,0,0}));
		assertArrayEquals(new int[] {11,11,1,0,0,0}, quoRPP.b(new int[] {11,11,0,0,0,0}));
		assertArrayEquals(new int[] {11,3,3,2,0,0}, quoRPP.b(new int[] {11,3,0,0,0,0}));
		
		assertArrayEquals(new int[] {15,3,5,0,0,0}, quoRPP.b(new int[] {15,3,0,0,0,0}));
		assertArrayEquals(new int[] {28,27,1,1,0,0}, quoRPP.b(new int[] {28,27,0,0,0,0}));
		assertArrayEquals(new int[] {28,7,4,0,0,0}, quoRPP.b(new int[] {28,7,0,0,0,0}));
	}

}
