import CantorPairing.*
import Less.*

module Bubble4Fili{
	
	dcl b4sort_p1 : 10 int
	def b4sort_p1 :=
		id|id|id|id|cu|id
		;/1 2 3 4 5 8 9 6 7 10/
		/**
		 * less inputs are:  k 0(p) 0(q) j i
		 * (in the paper is less_i_j_p_q;k .. note the inversion of i and j)
		 * we require:
		 * k = 5
		 * i = 4
		 * j = 3
		 * p = 6
		 * q = 7
		 * 
		 * following the paper, the "k" must be placed at index 3
		 * to invoke "less" and then put at index 5
		 */
		;/1 2 5 6 7 4 3 8 9 10 /
		; id|id|less|id|id|id   // a[0] a[1] k 0 0 a[2] a[3] other3stuffs
		;/1 2 6 7 3 4 5 8 9 10/ // a[0] a[1] a[2] a[3] k 0 0 other3stuffs
		; if[ /1 2 4 3/, id|id|id|id, id|id|id|id] |id|id|id|id|id
		; /4 1 2 3 8 6 7 5 10 9/ // green and yellow "permutation blocks" combined
		;id|id|id|id|id|id|id|cp
		;/1 2 3 4 5 9 10 6 7 8/


	dcl b4sort_p2 : 10 int
	def b4sort_p2 :=
		id|id|id|id|cu|id
		;/1 2 3 4 5 8 9 6 7 10/
		/**
		 * less inputs are:  k 0(p) 0(q) j i
		 * we require:
		 * k = 5
		 * i = 3
		 * j = 2
		 * p = 6
		 * q = 7
		 * following the paper, the "k" must be placed at index 3
		 * to invoke "less" and then put at index 5
		 * -) at 4 and 5 we put the zeros from 6 and 7
		 * -) at 8 and 7 we want a[2] and a[3] respectively --> 3and 2
		 * -) note that a[3] is now put on perm-index 2
		*/
		;/1 4 5 6 7 3 2 8 9 10 /
		; id|id|less|id|id|id // a[0] a[3] k 0 0 a[1] a[2]
//		
//	
//	dcl b4sort_p3 : 10 int
//	def b4sort_p3 :=
		
	
	dcl b4sort : 10 int /*a[0..4], S(tack), 0, 0^8, 0, 0, g*/
	def b4sort :=
		 b4sort_p1
		;b4sort_p1
		;b4sort_p1
//		;b4sort_p2
//		;b4sort_p2
//		;b4sort_p3
}