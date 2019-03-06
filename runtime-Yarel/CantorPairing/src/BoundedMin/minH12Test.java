package BoundedMin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class minH12Test {

	@Test
	void testB() {
		 RPP minH12RPP = new BoundedMin.minH12();
		
		assertArrayEquals( minH12RPP.b(new int[] {0,0,0,0,0}), new int[] {0,0,0,0,0} );
		assertArrayEquals( minH12RPP.b(new int[] {5,0,0,0,0}), new int[] {0,0,5,0,0} );
		assertArrayEquals( minH12RPP.b(new int[] {0,5,0,0,0}), new int[] {3,5,0,0,0} );
		
		assertArrayEquals( minH12RPP.b(new int[] {10,10,0,0,0}), new int[] {0,10,10,0,0} );
		assertArrayEquals( minH12RPP.b(new int[] {1,8,0,0,0}), new int[] {3,8,1,0,0} );
		assertArrayEquals( minH12RPP.b(new int[] {0,15,0,0,0}), new int[] {6,15,0,0,0} );
	}

}
