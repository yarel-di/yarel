module compound {
	dcl increment : 2 int
	def increment := 
               /* x   y */	   
	it[inc]    /* x+y y */	   
	
	dcl decrement : 2 int
	def decrement :=
               /* x   y */	   
	  it[dec]  /* x-y y */

	dcl seqComposition : 2 int
	def seqComposition :=
                  /* x   y */	   
	   increment  /* x+y y */
	  ;decrement  /* x   y */

	dcl parComposition : 4 int
	def parComposition :=
                   /* x   y   w   z */	   
	    increment  /* x+y y   w   z */
	  | decrement  /* x   y   w-z z*/
}