 module funcH12 {   
    /*
     * This code contains a bit different version of H function in respect to RPP. It is called H12 because
     * it works on its first and second parameters and takes one less input.
     * It also defines a very simple H12_v2 which doesn't seemingly belong to the concept of "Triangular numbers".
     */
     
     
    import ArithNat.*
    
    /* T2 function */
    dcl T2 : 2 int
    /*
     * input:  < x, y >
     * output: < x + 1, x + y + 1 >
     */
    def T2 := inc | id /* x+1   y   */
    		; /2 1/    /* y     x+1 */
    		; sumN     /* y+x+1 x   */
    		; /2 1/
    		/* x x+y+1 */
    		
    		
	/* T2sub function: different from T2 because it does the subtraction instead of sum. */
    dcl T2sub : 2 int
    /*
	 * input: < x, y >
	 * output: < x + 1, y - x - 1 >
	 */
    def T2sub := inc | id
    		   ; /2 1/
    		   ; subN
    		   ; /2 1/
    		   
    
    /* T3 function */
    dcl T3 : 3 int
    /*
     * input: < x, y, z >
     * output: < x, y + x, z + yx + Sum[x] >
     * where Sum[x] := (\sum_{i=0}^{x}i)
     */
    def T3 := /2 3 1/ /* y z x */
    		; it /* y z */[T2] /*   y+x z+yx+Sum */
    		; /3 1 2/          /* x y+x z+yx+Sum */
    
    
    /* T3sub function */
    dcl T3sub : 3 int
    /*
     * input:  < x, y, z >
     * output: < x, y + x, z - yx - Sum[x] >
     * where Sum[x] := (\sum_{i=0}^{x}i)
     */
    def T3sub := /2 3 1/
    		   ; it[T2sub]
    		   ; /3 1 2/
    		   
    		   
  
   /* 
    * It is similar to T3, but it returns (z + Sum[x]) on its last argument instead of (z + yx + Sum[x]) as T3 does,
    * where Sum[x] := (\sum_{i=0}^{x}i)
    * 
    * I defined it because it is not strictly necessary the sum of xy: in fact in Cantor pairing y=0 holds, so the two results listed
    * above are identical. 
    * But P3 doesn't have to use triangular numbers and is very simple. Besides, it terminates with a "<res,res,0>" configuration, while
    * T3 ends with a "<res,res,dirty>" configuration, so you don't have to revert some operation to transform dirty bits into zero.
    */        
    dcl P3 : 3 int
    /*
     * input:  < x, z, 0 >
     * output: < x, z + Sum[x], 0>
     */
    def P3 := /1 3 2/     /* x 0 z */
    		; dup_2|id    /* x x z */
            ; /3 2 1/     /* z x x */
            ; it /* z x */
                [sumN;    /* z+x   x   */
            	 id|dec   /* z+x   x-1 */
                ]
                /* repeating this for x times, we have at the end z=z+Sum[x] and x=0 */
            ; /3 1 2/     /* x z+Sum[0] 0 */
    
    
    /* IMPORTANT: it is exactly what we want from H12! See below H12_v2 */ 
    dcl P3sub : 3 int
    /*
     * input:  < x, z, 0 >
     * output: < x, z - Sum[x], 0>
     */
    def P3sub := /1 3 2/     /* x 0 z */
    		; dup_2|id    /* x x z */
            ; /3 2 1/     /* z x x */
            ; it /* z x */
                [subN;    /* z-x x   */
            	 id|dec   /* z-x x-1 */
                ]
                /* repeating this for x times, we have at the end z=z-Sum[x] and x=0 */
            ; /3 1 2/     /* x z-Sum[0] 0 */
    
    /* Ad hoc duplication with two inputs, useful for P3 */
    dcl dup_2 : 2 int
    /*
     * input:  < x, 0 >
     * output: < x, x >
     */
    def dup_2 := /2 1/
    		  ; it[inc]
    		  ; if[ id
    		  	  , id
    		  	  , neg
    		  	  ]
    
    
    
	/* Like H34 in original article but with one less parameter */
    dcl H12 : 3 int
    /*
     * input:  < x, y, 0 >
     * output: < x, y - Sum[x], 0>
     * where Sum[x] := (\sum_{i=0}^{x}i)
     */
    def H12 := /1 3 2/ /* x 0    y                */
    		 ; T3sub   /* x 0+x  y - x*0 - Sum[x] */
    		 /* x x y-Sum[x] */
             ; inv[dup_2] |id /* x 0         y-Sum[x] */
             ; /1 3 2/        /* x y-Sum[x]  0        */
             
    
    
    
    /* Note that this function never uses sub-modules on Triangular numbers. We described above P3 and P3sub.
     * For our purposes, the latter performs exactly the operation required by MinH12, but with less redundancy (and, obviously,
     * less generality for other purposes). So, the second version H12 just performs the simple operations done by P3sub!
     * I've simply used the new name H12_v2 for a question of semantics. I can remove it and call P3sub directly if efficency will force me...
     */
    dcl H12_v2 : 3 int
    /*
     * input:  < x, y, 0 >
     * output: < x, y - Sum[x], 0>
     */
    def H12_v2 := P3sub
}
