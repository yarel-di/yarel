import IntegerCompare.*

module YarelLib{
	
	dcl shiftFirstToLastK : 2 int , K
	def shiftFirstToLastK := // a[1..K] 0 0
		id{K} | inc{1}( K ) | inc{1}(K-1) // a[1..K] K K-1
		;for[
			/{K}/
			;id{K}|dec
		]
		;id{K} | dec | dec{1}(K-1)

	dcl shiftLastToFirstK : 2 int , K
	def shiftLastToFirstK := // a[1..K] 0 0
		id{K} | inc{1}(2) | inc{1}(K-1)
		;for[
			/{K}/
			;id{K}|inc
		]
		;id{K} | ((id|inc);for[dec])
		;id{K} | dec | dec{1}(K)

	dcl swapParamHelper(I) : int, K
	def swapParamHelper :=     //a[1 .. K] 0
		id{K}|inc{1}(I)  //a[1, 2, .. I-1, I, I+1, .., K] I
		;/{K}/           //a[I, 2, .. I-1, 1, I+1, .., K] I
		;id{K}|dec{1}(I) //a[I, 2, .. I-1, 1, I+1, .., K] 0
	
	dcl swapSRLlike(S,E) : int , K // similar to SRL implementation
	def swapSRLlike :=         //a[1, 2, .. S, S+1, .. E, E+1, .., K], 0
		swapParamHelper{K}(E)  //a[E, 2, .. S, S+1,.., 1, E+1, .., K], 0
		;swapParamHelper{K}(S) //a[E, 2, .. S, S+1,.., 1, E+1, .., K], 0
		;swapParamHelper{K}(E) //a[1, 2, .. E, S+1,.., S, E+1, .., K], 0

	
	/**From chapter
	 * "A library of functions in RPP"
	 * of the paper
	 * "A class of Recursive Permutations which is Primitive Recursive complete"
	 * writen by: Luca Paolini, Mauro Piccolo, Luca Roversi,
	 * Dipartimento di Informatica - Universita' di Torino, Italy
	 */

	dcl increment(I,J) : int, M
	def increment :=
		swap{M}(I, M-1)
		;swap{M}(J, M)
		;id{M-1}|for[inc]
		;swap{M}(I, M-1)
		;swap{M}(J, M)

	dcl decrement(I,J) : int, M
	def decrement :=
		swap{M}(I, M-1)
		;swap{M}(J, M)
		;id{M-1}|for[dec]
		;swap{M}(I, M-1)
		;swap{M}(J, M)
//		for[
//			id{I-1} // The parameter "I" is not an arity parameter (check the "dcl", after the colon) or is undefined.
//				|
//		]
}