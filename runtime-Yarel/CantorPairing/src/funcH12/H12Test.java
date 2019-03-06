package funcH12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class H12Test {

	@Test
	void testB() {
		RPP H12RPP = new funcH12.H12();
		assertArrayEquals( H12RPP.b(new int[] {0,0,0}), new int[] {0,0,0} );
		assertArrayEquals( H12RPP.b(new int[] {0,4,0}), new int[] {0,4,0} );
		assertArrayEquals( H12RPP.b(new int[] {5,0,0}), new int[] {5,-15,0} );
		
		assertArrayEquals( H12RPP.b(new int[] {1,1,0}), new int[] {1,0,0} );
		assertArrayEquals( H12RPP.b(new int[] {10,18,0}), new int[] {10,-37,0} );
		assertArrayEquals( H12RPP.b(new int[] {3,7,0}), new int[] {3,1,0} );
	}

}
