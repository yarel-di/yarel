import yarel_lang_arithmetics_nat.*
import yarel_lang_recursion_halve.*
import yarel_lang_cantor_pairing.* 

module yarel_lang_recursion_stack { 
	
	dcl Push: 5 int
	def Push :=  
	  /*   x   y 0 0 0 */
	  inv[cu]
	  /* <x,y> 0 0 0 0 */
	  
	dcl Pop: 5 int
	def Pop :=  
	  /* <x,y> 0 0 0 0 */
	  cu
	  /*   x   y 0 0 0 */
}