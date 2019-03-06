package CantorPairing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class cpTest {

	@Test
	void testB() {
		RPP cpRPP = new CantorPairing.cp();
		
		assertArrayEquals( cpRPP.b(new int[] {0,0,0}), new int[] {0,0,0} );
		assertArrayEquals( cpRPP.b(new int[] {5,2,0}), new int[] {7,33,0} );
		assertArrayEquals( cpRPP.b(new int[] {2,5,0}), new int[] {7,30,0} );
		
		assertArrayEquals( cpRPP.b(new int[] {1,1,0}), new int[] {2,4,0} );
		assertArrayEquals( cpRPP.b(new int[] {5,0,0}), new int[] {5,20,0} );
		assertArrayEquals( cpRPP.b(new int[] {10,10,0}), new int[] {20,220,0} );
	
	}

}
