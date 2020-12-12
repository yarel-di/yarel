import yarel_lang_arithmetics_nat.*
import yarel_lang_recursion_halve.*
import yarel_lang_cantor_pairing.*

module yarel_lang_recursion_unfold { 
	
	dcl push: 5 int
	def push :=  
	  /*   x   y 0 0 0 */
	  inv[cu]
	  /* <x,y> 0 0 0 0 */
	  
	dcl pop: 5 int
	def pop :=  
	  /* <x,y> 0 0 0 0 */
	  cu
	  /*   x   y 0 0 0 */
	  
	dcl unfold: 7 int
	def unfold :=
	 /*n qe qo re 0 0 0*/ 
	   (yarel_lang_recursion_halve.Halve   |id|id|id)
	 /*n qo qe re ro 0 0 0 s.t. n=2*qo+re & 0<=re<=1 */
     ; yarel_lang_arithmetics_nat.sub |id|id|id|id|id
	 /*n-qo qo qe re ro 0 0 0 s.t. n=2*qo+re & 0<=re<=1 */
}