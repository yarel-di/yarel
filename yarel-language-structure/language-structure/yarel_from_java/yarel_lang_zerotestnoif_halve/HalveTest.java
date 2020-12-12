package yarel_lang_zerotestnoif_halve;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import yarelcore.RPP;

class HalveTest {
 
//	@Test
	void testStepRPP() {
		 RPP StepRPP = new yarel_lang_recursion_halve.Step();
		 
		 assertArrayEquals(new int[] {0,1,0}, StepRPP.b(new int[] {1,0,0}));
		 assertArrayEquals(new int[] {1,0,1}, StepRPP.b(new int[] {0,1,0}));

	}

	@Test
	void testHalveRPP() {
		 RPP HalveRPP = new yarel_lang_recursion_halve.Halve();

		 assertArrayEquals(new int[] {0,1,0}, HalveRPP.b(new int[] {1,0,0}));
//		 assertArrayEquals(new int[] {1,0,1}, HalveRPP.b(new int[] {0,1,0}));
	}

}
