import arithNat.*
import funcH12.*
import BoundedMin.*
module CantorPairing {
    
    /* note: Sum[a] := (\sum_{i=0}^{a}i) */
    
    /* Cantor pairing */
    dcl cp {3 int}
    
    /*
     * input:  < x, y, 0>
     * output: < x + y, x + Sum[x+y], 0 >
     */
    def cp := /2 1 3 / /* y   x 0 */
            ; sumN|id  /* y+x x 0 */
            ; P3 
            /* y+x x+Sum[x+y] 0 */
   
   /* Open question: cantor unpairing needs just one parameter, the encoding z = x+Sum[x,y].
    * Is there a way to hide y+x ie the first output of cantor pairing?
    */
 
    
    
    /* Cantor unpairing */
    dcl cu {5 int}
    
    /* 
     * input:  < z, 0, 0, 0, 0 >
     * output: < x, y, 0, 0, 0 > such that cp<x,y> = z.
     */
    def cu := /2 1 3 4 5/      /* 0     z  0  0  0 */
            ; minH12           /* v*    z  0  0  0 */
  /* check minH12.rl for a precise definition and further explanations about v* */
            
  /* 
   * The next uncommented sequence is just a way to avoid the little bug - present also in RPP algorithm -
   * of decoding z=0 into a wrong couple of numbers. Now with this check it works: <0> is correctly decoded into 0,0 couple.
   * You can simply ignore it so it doesn't interrupt the flow.
   */
   
    /* Bugfix start */
            ; /1 3 4 5 2/    
            ; if[
            	  id|id|id|id,
            	  inc|id|id|id,
            	  id|id|id|id
                ]
            ; /1 5 2 3 4/          
    /* End of bugfix */ 
   			   
            ; dec|id|id|id|id  /* v*-1                 z            0 0 0 */
            ; H12_v2|id|id     /* v*-1                 z-Sum[v*-1]  0 0 0 */
            
            ; subN|id|id|id    /* v*-1-(z-Sum[v*-1])   z-Sum[v*-1]  0 0 0 */
			; /2 1 3 4 5/
			/* x y 0 0 0 where x,y are such that cp<x,y> = z, the encoding */
}  


/*
 * 
 * Observations:
 * 
 * The Cantor pairing output is of the form { x + y, z=<x,y>, 0 }; it is clear that is redundant
 * if we thing about the bijectivity of Cantor isomorphism, such that we just need to have the encoding z
 * as input of Cantor unpairing to re-obtain the original x and y.
 * One may consider to create a better function of pairing which returns just < z, 0, 0 >, cleaning the
 * redundant parameter. But in my opinion no better design can solve this intrinsic redundancy.
 * 
 * This is because I think that in this language, given two inputs a and b, if a != b, then you have
 * at least two non-zero outputs. In other words, in case of two different inputs,
 * you can't flush an output and set it to 0, no matter how much acrobatics you can do.
 * 
 * This is a "lemma" of a sort of theorem I have in mind which tells more or less:
 * "If the function has at least two different inputs, then it's going to have at least two non-zero outputs."
 * And this is clearly a limit for data compression/encryption...
 * I haven't got a demonstration of it, but I think of this fact as pretty true.
 * 
 * Obviously we expect Cantor unpairing to have the same behavior of inv[cp]. But the first has nothing utility
 * except showing us we are not wrong about the equivalence with the behavior of arithmetics definition of Cantor unpairing
 * (with triangular numbers, etc...) and the behavior of inv[cp] syntactically defined.
 * 
 * But why a definition of Cantor unpairing is useless? The simple answer is: because we already have, syntactically, inv[cp]!
 * And this is true, but not complete. 
 * The complete answer is that Cantor pairing (cp) seemingly wastes a memory location
 *  (as we saw above, it returns { x + y, z, 0 } where the first x + y is redundant!),
 *  so the real input of Cantor unpairing is not {z, 0s} as we may hope, but it has to be { x + y, z, 0s }.
 * 
 *  Now it is clear that the only way to flush that dirty location is to call inv[cp] -
 *   in fact, by definition, inv[cp] takes { x + y, z, 0 } and returns { x, y, 0 },
 *  allowing us to go back to the initial situation without any waste.
 * And that ugly x+y finally disappeared.
 * 
 * But what if we want to run n times encryption - Cantor pairing - without its unpairing decryption - e.g. if we want to push n times
 * in a stack without any pop? We'll waste n memory location.
 * 
 * Another problem is that we don't take advantage of bijectivity of Cantor isomorphism. As we said, unpairing doesn't need
 * { x+y, z, 0s } but it just needs { z, 0s }. Since we give { x+y, z, 0s }, we are ignoring the bijectivity, which is
 * paradoxically useless in this context.
 * So to speak, we could do a unique encoding also with sum, which is clearly not bijective, assuming we can waste a memory location:
 * given { m, n, 0s }, we return { m+n, n, 0s } and, after k encodings operation, we have an output such that { m+n_1+..+n_k, n_1,...,n_k }
 * and all we must do to decode is subtract, in turn, n_k, n_k-1,... 
 * 
 * In conclusion, the good use of bijectivity is directly connected to the avoidance of the waste of memory. We want to use Cantor isomorphism
 * because of its special property that, given just z *and nothing other*, returns the initial x and y. No more information than z is
 * needed for this reverse application, each redundancy damages rather than helps us.
 * For the constraints exposed above, I don't think it's possible a clean definition of Cantor pairing which returns only z.
 * The versions in the article on RPP and my experimental versions, even if they are optimized, confirm that. But I haven't lost the hope.
 * 
 * 
 */        