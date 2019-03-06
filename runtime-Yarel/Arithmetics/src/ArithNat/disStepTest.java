package ArithNat;
import Yarelcore.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class disStepTest {

	@Test
	void testDisStepN() {
		RPP disStep = new ArithNat.disStepN();
//		System.out.println(Arrays.toString(disStep.b(in)));
		assertArrayEquals(disStep.b(new int[] {2, 2, 0, 0}),new int[] { 0, 2, 1, 1});
		assertArrayEquals(disStep.b(new int[] {4, 2, 0, 0}),new int[] { 2, 2, 1, 0});
		assertArrayEquals(disStep.b(new int[] {6, 2, 0, 0}),new int[] { 4, 2, 1, 0});
		assertArrayEquals(disStep.b(new int[] {0, 1, 0, 0}),new int[] {-1, 1, 0, 1});
		assertArrayEquals(disStep.b(new int[] {2, 3, 0, 0}),new int[] {-1, 3, 0, 1});
   }
}
