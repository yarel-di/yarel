package CantorPairing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Yarelcore.RPP;

class cuTest {
	

	@Test
	void testB() {
		RPP cuRPP = new CantorPairing.cu();
		RPP cpinvRPP = new CantorPairing.inv_cp();
		
		
		int[] unp = new int[5];
		int j = 0;
		
		assertArrayEquals( unp = cuRPP.b(new int[] {0,0,0,0,0}), new int[] {0,0,0,0,0});
		
		for(int i : cpinvRPP.b(new int[] {0,0,0})) {
	 		assertTrue(i == unp[j++]);
		}
		
		assertArrayEquals( unp = cuRPP.b(new int[] {33,0,0,0,0}), new int[] {5,2,0,0,0});
		
		j = 0;
		for(int i : cpinvRPP.b(new int[] {7,33,0})) {
	 		assertTrue(i == unp[j++]);
		}
		
		assertArrayEquals( unp = cuRPP.b(new int[] {30,0,0,0,0}), new int[] {2,5,0,0,0});
		
		j = 0;
		for(int i : cpinvRPP.b(new int[] {7,30,0})) {
	 		assertTrue(i == unp[j++]);
		}
		
		assertArrayEquals( unp = cuRPP.b(new int[] {4,0,0,0,0}), new int[] {1,1,0,0,0});
		
		j = 0;
		for(int i : cpinvRPP.b(new int[] {2,4,0})) {
	 		assertTrue(i == unp[j++]);
		}
		
		assertArrayEquals( unp = cuRPP.b(new int[] {4,0,0,0,0}), new int[] {1,1,0,0,0});
		
		j = 0;
		for(int i : cpinvRPP.b(new int[] {2,4,0})) {
	 		assertTrue(i == unp[j++]);
		}
		
		assertArrayEquals( unp = cuRPP.b(new int[] {20,0,0,0,0}), new int[] {5,0,0,0,0});
		
		j = 0;
		for(int i : cpinvRPP.b(new int[] {5,20,0})) {
		 		assertTrue(i == unp[j++]);
		}
		
		assertArrayEquals( unp = cuRPP.b(new int[] {220,0,0,0,0}), new int[] {10,10,0,0,0});
		
		j = 0;
		for(int i : cpinvRPP.b(new int[] {20,220,0})) {
		 		assertTrue(i == unp[j++]);
		}
		
	}

}
