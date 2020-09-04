import yarel_lang_recursion_halve.*
module yarel_lang_recursion_sp0 {
	/* executes halve.Halve if (execHalf,nexecHalf)=(1,0) 
	 * does not execute halve.Halve if (execHalf,nexecHalf)=(0,1) */
	dcl Sp0: 6 int
	def Sp0 := 
	 /*n e o nhalf                  execHalf nexecHalf*/
	 it[yarel_lang_recursion_halve.Halve]|id
	 /*n e o nhalf s.t. n=2*nhalf+o execHalf nexecHalf*/
}