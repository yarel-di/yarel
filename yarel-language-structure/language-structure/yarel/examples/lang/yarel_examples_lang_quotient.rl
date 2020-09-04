import yarel_lang_arithmetics_nat.*
module yarel_examples_lang_quotient {
	
	/* Definitions for division on Naturals */
	
	/*
	 * It performs a single step of division. Returns <r-d d q 0> iff d >= r[case A], <r d q -d> else[case B].
	 */
	
	/* r d q 0(k)
	 *
	 * r: remainder
	 * d: divisor
	 * q: quotient
	 * k: will be r-d at first, then it'll be 0 if the subtraction step has been executed, -d otherwise.
	 */
	dcl quoStep : 4 int
	
	/* 
	 * We set k = r-d, so if k >= 0 [case A], we execute the subtraction step; else we don't do it[case B].
	 * So, we have: r'= r-d if we've executed the subtraction step [case A], otherwise is just r'=r [case B].
	 * The next move is to do k'= k-r'=(r-d)-r'. So, in [case A], we have: k'= (r-d)-r'=(r-d)-(r-d)=0.
	 * Instead, in [case B], k'=(r-d)-r'=r-d-r=-d.
	 */
	
	def quoStep := /4 1 2 3/   /* k=0  r d   q */
				 ; sumN|id|id  /* r    r d   q */
				 ; /1 3 2 4/   /* r    d r   q */
				 ; yarel_lang_arithmetics_nat.sub|id|id  /* r-d  d r   q */
				 ; /3 2 4 1/   /* r    d q r-d */
				 
				 ; if[
				 	 /* k>0, so r>d: [case A] */ yarel_lang_arithmetics_nat.sub|inc, /* r-d d q */
				 	 /* k=0, so r=d: [case A] */ yarel_lang_arithmetics_nat.sub|inc, /* r-d d q */
				 	 /* k<0, so r<d: [case B] */ id|id|id  /* r   d q */
				 	 ]
				 
				 ; /4 1 2 3/   /* k'=r-d    r' d q */ 
				 ; yarel_lang_arithmetics_nat.sub|id|id  /* k'=r-d-r' r' d q */
				 
				 /* if[case A]: r'=r-d, so k'= r-d-r'= r-d-(r-d)= 0;
				  * if[case B]: r'=r, so k'= r-d-r'=r-d-r=-d;
				  */
				 ; /2 3 4 1/   /* r' d q k' */
	
	/* 
	 * Clean definition of division which takes 6 arguments of the type <D(ividend),d(ivisor),0,0,0,0> and returns
	 * <D(ividend),d(ivisor),q(uotient),r(emainder),0,0>
	 */
	
	/* D d 0(q) 0(k) 0(c) 0(it)
	 * 
	 * D: dividend
	 * d: divisor
	 * q: quotient
	 * k: 0 if last quoStep was executed (r'=r-d), -d else. 0 at the start of each iteration
	 * 
	 * c: counts the number of times we have tried to do r'=r-d, but we couldn't because
	 *    r(emainder) was smaller than d(ivisor)
	 * 
	 * it: number of times we iterate. It is set to D.
	 * 
	 */
	dcl quo : 6 int
	
	/*
	 * At each iteration, it performs quoStep. In case r<d, quoStep does nothing but setting k=-d.
	 * If this is the case, we set c=1 and we restore k to 0. From this
	 * moment on, we are sure that, for each future call of quoStep, it will returns k=-d. In other words,
	 * we have reached the condition d(ivisor)>r(emainder), so quoStep won't do steps of division anymore.
	 * In the end, c has counted how many times we've called quoStep in the situation of d(ivisor)>r(emainder).
	 * Its "complementary" is q, which counts how many times the step of division has been successful.
	 * So we can do c = c - D + q and we get c=0.
	 */
	def quo  := /6 1 2 3 4 5/
			  ; sumN|id|id|id|id
			  ; / 2 3 4 5 6 1/    /* r d q=0 k=0 c=0 it=D */
			  
			  ; it[ /* r d q k=0 c */
			  		
			  		/* k is 0 at the start of each iteration */
			  		
			  	    quoStep|id /* r' d q k' c */
			  	    /* see quoStep [case A] and [case B].
			  	     * [case A, r>=d]: r'=r-d, k'=0;
			  	     * [case B, r<d]: r'=r, k'=-d.
			  	     */
			  	     
			  	    ; /1 2 3 5 4/  /* r' d q' c k' */
			  	    ; if[ /* we increment c every time d goes negative */
			  	    	
			  	    	 /* impossible */ id|id|id|id, 
			  	    	 /*  [case A]  */ id|id|id|id, /* r' d q'   c */
			  	    	 /*  [case B]  */ id|id|id|inc /* r' d q' c+1 */
			  	    	 
			  	        ]
			  	    ; /1 2 3 5 4/ /* r' d q' k' c' */
			  	    
			  	    /* if c'>0, it means that while performing quoStep,
			  	     * we've encountered [case B], so k'=-d. We want to
			  	     * restore its value to 0: k''= k' + d.
			  	     * Else, k'=0 and k'' is invariate.
			  	     */
			  	    ; if[
			  	    	 /*  [case B]  */ /1 4 2 3/; id|sumN|id; /1 3 4 2/, /* r' d q' k''=0 */
			  	    	 /*  [case A]  */ id|id|id|id,                      /* r' d q' k''=0 */
			  	    	 /* impossible */ id|id|id|id
			  	        ]
			      ]
			   /* r d q   0 c r */   
			   ; id|id|id|id|yarel_lang_arithmetics_nat.sub /* r d        q   0 c-D D */
			   ; /1 2 5 3 4 6/    /* r d      c-D   q   0 D */
			   ; id|id|sumN|id|id /* r d  c-D+q=0   q   0 D */
			   ; /6 2 4 1 5 3/    /* D d q r 0 0 */
			   
}