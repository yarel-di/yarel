import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class modulesTest {

	@Test
	void test() {
		 RPP permutationRPP = new modules.permutation();
		 System.out.println(Arrays.toString(permutationRPP.b(new int[] {1,2,3,5})));
	}
}
