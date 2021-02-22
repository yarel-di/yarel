import CantorPairing.*
import IntegerCompare.*

module Bubble4Fili{
	
	dcl b4sort_p1 : 10 int
	def b4sort_p1 :=
		id|id|id|id|cu|id
		;/1 2 3 4 5 8 9 6 7 10/
		/**
		 * more inputs are:  k 0(p) 0(q) i j
		 * (in the paper is more_i_j_p_q;k)
		 * we require (as it's written in the paper/work):
		 * k = 5
		 * i = 4
		 * j = 3
		 * p = 6
		 * q = 7
		 * so we must place those variables in these indexes:
		 * k = 3
		 * p = 4
		 * q = 5
		 * i = 6
		 * j = 7
		 * also, we know
		 * i = a[3]
		 * j = a[2]
		 * 
		 *                         a[0] a[1] a[2] a[3] k:=0 0 0,0 0 g
		 */
		;/1 2 5 6 7 4 3 8 9 10 / //a[0] a[1] 0 0 0 a[3] a[2] other3stuffs
		; id|id|more|id|id|id   // a[0] a[1] k 0 0 a[3] a[2] other3stuffs
		;/1 2 7 6 3 4 5 8 9 10/ // a[0] a[1] a[2] a[3] k 0 0 other3stuffs
		;if[ /1 2 4 3/, id|id|id|id, id|id|id|id] |id|id|id|id|id
		;/4 1 2 3 8 6 7 5 10 9/ // green and yellow "permutation blocks" combined
		//;id|id|id|id|id|id|id|cp // cp has the collateral effect of producing "<z, x+y, 0>" instead of "<z, 0, 0>" 
		//modify the green to use the two "grey" zeros to do inv[cu]
		;/ 1 2 3 4 5 8 9 10 6 7/ // the two "gray" zeros are at the end
		;id|id|id|id|id|inv[cu]
		;/1 2 3 4 5 7 8 9 10 6/
		//;/1 2 3 4 5 9 10 6 7 8/


	dcl b4sort_p2 : 10 int
	def b4sort_p2 :=
		id|id|id|id|cu|id
		;/1 2 3 4 5 8 9 6 7 10/
		/**
		 * more inputs are:  k 0(p) 0(q) i j
		 * (in the paper is more_i_j_p_q;k)
		 * we require (as it's written in the paper/work):
		 * k = 5
		 * i = 3
		 * j = 2
		 * p = 6
		 * q = 7
		 * so we must place those variables in these indexes:
		 * k = 3
		 * p = 4
		 * q = 5
		 * i = 6
		 * j = 7
		 * also, we know
		 * i = a[2]
		 * j = a[1]
		 * 
		 *                          a[0] a[1] a[2] a[3] k:=0 0 0,0 0 g
		 */
		;/1 4 5 6 7 3 2 8 9 10 / // a[0] a[3] k(0) 0 0 a[2] a[1],0 0 g
		;id|id|more|id|id|id     // a[0] a[3] k 0 0 a[2] a[1] , 0 0 g
		;/1 7 6 2 3 4 5 8 9 10/  // a[0] a[1] a[2] a[3] k 0 0 , 0 0 g
		;if[ /1 3 2 4/, id|id|id|id, id|id|id|id] |id|id|id|id|id
		;/3 1 2 4 8 6 7 5 10 9/ // green and yellow "permutation blocks" combined
		//;id|id|id|id|id|id|id|cp
		//modify the green to use the two "grey" zeros to do inv[cu]
		;/ 1 2 3 4 5 8 9 10 6 7/ // the two "gray" zeros are at the end
		;id|id|id|id|id|inv[cu]
		;/1 2 3 4 5 7 8 9 10 6/
		//;/1 2 3 4 5 9 10 6 7 8/


	dcl b4sort_p3 : 10 int
	def b4sort_p3 :=
		id|id|id|id|cu|id
		;/1 2 3 4 5 8 9 6 7 10/
		/**
		 * more inputs are:  k 0(p) 0(q) i j
		 * (in the paper is more_i_j_p_q;k)
		 * we require (as it's written in the paper/work):
		 * k = 5
		 * i = 2
		 * j = 1
		 * p = 6
		 * q = 7
		 * so we must place those variables in these indexes:
		 * k = 3
		 * p = 4
		 * q = 5
		 * i = 6
		 * j = 7
		 * also, we know
		 * i = a[1]
		 * j = a[0]
		 * 
		 *                         a[0] a[1] a[2] a[3] k:=0 0 0,0 0 g
		 */
		;/3 4 5 6 7 2 1 8 9 10/ // a[2] a[3] 0 0 0 a[1] a[0]   ,0 0 g
		;id|id|more|id|id|id    // a[2] a[3] k 0 0 a[1] a[0]   ,0 0 g
		;/7 6 1 2 3 4 5 8 9 10/ // a[0] a[1] a[2] a[3] k 0 0   ,0 0 g
		;if[ /2 1 3 4/, id|id|id|id, id|id|id|id] |id|id|id|id|id
		;/2 1 3 4 8 6 7 5 10 9/ // green and yellow "permutation blocks" combined
		//;id|id|id|id|id|id|id|cp
		//modify the green to use the two "grey" zeros to do inv[cu]
		;/ 1 2 3 4 5 8 9 10 6 7/ // the two "gray" zeros are at the end
		;id|id|id|id|id|inv[cu]
		;/1 2 3 4 5 7 8 9 10 6/
		//;/1 2 3 4 5 9 10 6 7 8/
	
	dcl b4sort : 10 int /*a[0..4], S(tack), 0, 0^8, 0, 0, g*/
	def b4sort :=
		 b4sort_p1
		;b4sort_p1
		;b4sort_p1
		;b4sort_p2
		;b4sort_p2
		;b4sort_p3
}