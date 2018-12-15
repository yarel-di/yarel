package ArithNat;
import Yarelcore.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class disStepTest {

// Cases that do not generate negative overflow
	@Test
	void testDisStep1() {
		int[] in  = {2, 2, 0, 0};
		int[] out = {0, 2, 1, 1};
		RPP disStep = new ArithNat.disStep();
//		System.out.println(Arrays.toString(disStep.b(in)));
		assertArrayEquals(disStep.b(in),out);
	}

	@Test
	void testDisStep2() {
		int[] in  = {4, 2, 0, 0};
		int[] out = {2, 2, 1, 0};
		RPP disStep = new ArithNat.disStep();
//		System.out.println(Arrays.toString(disStep.b(in)));
		assertArrayEquals(disStep.b(in),out);
	}

	@Test
	void testDisStep3() {
		int[] in  = {6, 2, 0, 0};
		int[] out = {4, 2, 1, 0};
		RPP disStep = new ArithNat.disStep();
//		System.out.println(Arrays.toString(disStep.b(in)));
		assertArrayEquals(disStep.b(in),out);
	}

// Cases that generate negative overflow
		@Test
		void testDisStep4() {
			int[] in  = { 0, 1, 0, 0};
			int[] out = {-1, 1, 0, 1};
			RPP disStep = new ArithNat.disStep();
//			System.out.println(Arrays.toString(disStep.b(in)));
			assertArrayEquals(disStep.b(in),out);
		}
		@Test
		void testDisStep5() {
			int[] in  = { 2, 3, 0, 0};
			int[] out = {-1, 3, 0, 1};

			RPP disStep = new ArithNat.disStep();
//			System.out.println(Arrays.toString(disStep.b(in)));
			assertArrayEquals(disStep.b(in),out);
		}

}
