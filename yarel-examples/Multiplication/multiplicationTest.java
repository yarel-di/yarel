package Multiplication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class multiplicationTest {

	RPP multiplicationRPP = new Multiplication.multiplication();
	RPP identityRPP       = new Multiplication.identity();

	@Test
	void testMultiplication() {
		assertArrayEquals(multiplicationRPP.b(new int[] { 0,0,0}),new int[] { 0,0, 0});
		assertArrayEquals(multiplicationRPP.b(new int[] { 0,1,0}),new int[] { 0,1, 0});
		assertArrayEquals(multiplicationRPP.b(new int[] { 1,0,0}),new int[] { 1,0, 0});
		assertArrayEquals(multiplicationRPP.b(new int[] { 1,2,0}),new int[] { 1,2, 2});
		assertArrayEquals(multiplicationRPP.b(new int[] { 2,1,0}),new int[] { 2,1, 2});
		assertArrayEquals(multiplicationRPP.b(new int[] { 2,2,0}),new int[] { 2,2, 4});
		assertArrayEquals(multiplicationRPP.b(new int[] {10,2,0}),new int[] {10,2,20});
		assertArrayEquals(multiplicationRPP.b(new int[] {10,2,5}),new int[] {10,2,25});
	}
	
	@Test
	void testIdentity() {
		assertArrayEquals(identityRPP.b(new int[] { 0,0,0}),new int[] { 0,0, 0});
		assertArrayEquals(identityRPP.b(new int[] { 0,1,0}),new int[] { 0,1, 0});
		assertArrayEquals(identityRPP.b(new int[] { 1,0,0}),new int[] { 1,0, 0});
		assertArrayEquals(identityRPP.b(new int[] { 1,2,0}),new int[] { 1,2, 0});
		assertArrayEquals(identityRPP.b(new int[] { 2,1,0}),new int[] { 2,1, 0});
		assertArrayEquals(identityRPP.b(new int[] { 2,2,0}),new int[] { 2,2, 0});
		assertArrayEquals(identityRPP.b(new int[] {10,2,0}),new int[] {10,2, 0});
		assertArrayEquals(identityRPP.b(new int[] {10,2,5}),new int[] {10,2, 5});
	}
}
