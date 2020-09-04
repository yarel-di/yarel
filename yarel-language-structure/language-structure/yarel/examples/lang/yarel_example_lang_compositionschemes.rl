module yarel_example_lang_compositionschemes {
	dcl Increment : 2 int
	def Increment := 
    /* x   y */ it[inc]	   
	/* x+y y */	   
	
	dcl Decrement : 2 int
	def Decrement :=
    /* x   y */ it[dec]	   
	/* x-y y */

	dcl SeqComposition : 2 int
	def SeqComposition :=
    /* x   y */  Increment
    /* x+y y */ ;Decrement
    /* x   y */

	dcl ParComposition : 4 int
	def ParComposition :=
    /* x   y   w   z */   Increment  
    /* x+y y   w   z */ | Decrement  
    /* x   y   w-z z*/
}