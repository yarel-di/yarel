package Util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import Yarelcore.RPP;

class dupTest {

	@Test
	void testB() {
		RPP dupRPP = new Util.dup();
		assertArrayEquals(new int[] { 0, 0, 0},dupRPP.b(new int[] { 0, 0, 0 }));
		assertArrayEquals(new int[] { 1, 1, 0},dupRPP.b(new int[] { 1, 0, 0 }));
		assertArrayEquals(new int[] {-1,-1, 0},dupRPP.b(new int[] {-1, 0, 0 }));
		assertArrayEquals(new int[] { 2, 2, 0},dupRPP.b(new int[] { 2, 0, 0 }));
		assertArrayEquals(new int[] {-2,-2, 0},dupRPP.b(new int[] {-2, 0, 0 }));

	}

}
