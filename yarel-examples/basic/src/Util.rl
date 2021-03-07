module util {
	/** in : a, 0, 0
	 *  out: a, a, 0
	 *  Duplicates the first argument, given two ancillae intialized
	 *  to the value 0. The first ancilla assume the value a.
	 *  The second ancilla remains 0.
	 */
	dcl dup: 3 int
	def dup:= /*  a   0  0*/ /2 3 1/
	        ; /*  0   0  a*/ it[dec|inc] 
	        ; /*-|a| |a| a*/ it[inc]|id 
	        ; /*  0  |a| a*/ (id | if[/*|a|*/ id  /* |a|*/
	        	                     ,/*|a|*/ id  /* |a|*/
	                                 ,/*|a|*/ neg /*-|a|*/ 
	                                 ])
	        ; /* 0    a  a*/ /2 3 1/
              /* a    a  0*/
              
              

	dcl negSRL : 2 int
	def negSRL :=
		// < n, a >
		for[inc] //n+a,  a
		;/2 1/   // a ,n+a
		;for[dec]// -n,n+a
		;/2 1/   //n+a, -n
		;for[inc]// a , -n
		;/2 1/   // -n,  a
}