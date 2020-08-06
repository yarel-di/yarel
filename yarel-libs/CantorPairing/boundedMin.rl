import ArithNat.*
import funcH12.*
module BoundedMin {
	
	/* 
	 * This module provides bounded minimization for the function H12. It defines the RPP version with arity 7
	 * and another version with arity 5, which almost halves the arity 8 expected in the original article.
	 */
    
    
    /* This version of RPP is not present in the original article but has only arity of 5.
     * Just to recall, we wish to find v* such that:
     * 
     *  v* = min{ v : Function[A_1,..,A_i + v,..,A_n] = < B_1,..,B_j,..,B_n > AND B_j < 0 }
     * 
     * In particular case of Cantor Unpairing, i=1,j=2, A_i := x , B_j := y and x initially set to 0,
     * 
     * and the function we need is H12, where H12[x,y]= < x, y-Sum[x] >,
     * 
     *  where Sum[x] := (\sum_{i=0}^{x}i). See the file funcH12.rl for further comments and details.
     * 
     * The core idea behind is to store in a variable c the number of times we've incremented x
     * and didn't obtain y<0 after the application of H12. The other operations are quite easy.
     * 
     */
                           
    dcl minH12 : 5 int
    
    /*
     * input:  < x, y, 0, 0, 0 >
     * 
     * Note: in the use for Cantor Unpairing, x should be set initially to 0.
     * 
     * output: < v*, y, x, 0, 0 > or < v*, y, 0, 0, 0 > in case the input x was set to 0
     * 
     * See the comment above for v* definition
     */
    def minH12 :=  /1 5 2 3 4/    /* x y   0 0 0 */
				; id| sumN|id|id  /* x 0+y y 0 0 */
				; /1 3 4 5 2/     /* x y   0 0 y */
				
				; it[ /* x y 0 c */
                 
	                  H12_v2 |id          /* x    y'=y-Sum[x]   0   c        */
	                  ; /1 3 4 2/         /* x    0             c   y-Sum[x] */
	                  ; if[ /* x 0 c */
	                        id|id|id,
	                        id|id|id,
	                        id|id|dec /* x 0  c'=c-1 */
	                      ]
	                   ; /1 4 2 3/        /* x     y' 0   c'   */
	                   ; inv[H12_v2] |id  /* x     y  0   c'   */
	                   ; inc|id|id|inc    /* x+1   y  0   c'+1 */
	                   /* c'+1 = c-1+1 = c if in case y-Sum[x] was negative, else c'=c */
                    ]
                /* now, we have on the first wire x+y, in the second and the fifth y.
                 * c, on the fourth wire, represents the number of times we incremented x hoping to
                 * turn the y negative once applied H12_v2[x++,y,0]. This is exactly the number we are searching!
                 */
                ; /1 5 2 3 4/          /* x+y y   y  0  c */
                ; subN |id|id|id       /* x   y   y  0  c */
                ; id|subN |id|id       /* x   0   y  0  c */
                ; /5 3 1 4 2/          /* c   y   x  0  0 */
                         
    
    
    
    
    
    
    /* RPP original version translated in Yarel. For further comment and details, see the article about RPP. */
    dcl minH12_original : 7 int
    def minH12_original := it[
		                     H12 |id|id|id
		                     ; /1 3 4 5 6 2/
		                     ; if[
		                           id|id|id|id|id,
		                           id|id|id|id|id,
		                           if[
		                               id|id|id|id,
		                               id|id|sumN, /* if it's the first time that j <0, write the number of iterations (x[n+2]) in x[n+1] */
		                               id|id|id|id
		                           ]
		                           ; id|id|id|id|inc /* x[n+3] > 0 iff j gone under 0 at least one time */
		                         ]
		                         
		                     ; /1 6 2 3 4 5/
		                     ; inv[H12] |id|id|id
		                     ; inc|id|id|id|inc|id  /* increments i to try again in the next iteration; x[n+2] counts another iteration */
		                     
		                   ]
		                   
	                   ; /1 2 3 4 7 5 6/ 
	                   ; if[id|id|id|id|id|id
	                        , id|id|id|sumN|id /* if x[n+3] = 0, minimum v hasn't been found and it's chosen x[n+4] as arbitrary value for v */
	                        , id|id|id|id|id|id ]
	                   ; /1 2 3 4 6 7 5/
	                   
	                   ; inv[it[
	                             H12 |id|id|id
	                             ; /1 3 4 5 6 2/
	                             ; if[
	                                   id|id|id|id|id,
	                                   id|id|id|id|id,
	                                   id|id|id|id|inc /* reverse iteration undoes all but x[n+1]=v, which is our minimum */
	                                 ]
	                             ; /1 6 2 3 4 5/
	                             ; inv[H12] |id|id|id
	                             ; inc|id|id|id|inc|id 
	                             ]
	                         ]
	                    ; /4 2 1 3 5 6 7/

}