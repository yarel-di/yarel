import yarel_lang_recursion_sp1.*

module yarel_lang_recursion_sp2 {
	dcl sp2 : 6 int
	def sp2 := 
	 /*n e o nhalf s.t. n=2*nhalf+o execHalf nexecHalf*/
	 /1 4 2 3 5 6/
	 /*n nhalf e o execHalf nexecHalf*/
	 ;it[dec]|id|id|id|id
	 /*n-nhalf=nhalf nhalf e o execHalf nexecHalf*/
	 ;/2 1 3 4 5 6/
	 /*nhalf nhalf e o execHalf nexecHalf*/
	 ;it[dec]|id|id|id|id
	 /*nhalf-nhalf=0 nhalf e o execHalf nexecHalf*/
	 ;/2 3 4 1 5 6/
	 /*nhalf e o nhalf-nhalf execHalf nexecHalf*/
}