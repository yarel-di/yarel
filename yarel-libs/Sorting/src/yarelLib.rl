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

	dcl swapParamHelper(Index) : int, K //a[1 .. K] 0
	def swapParamHelper :=
		id{K}|inc{1}(Index)  //a[1, 2, .. Index-1, Index, Index+1, .., K] Index
		;/{K}/               //a[Index, 2, .. Index-1, 1, Index+1, .., K] Index
		;id{K}|dec{1}(Index) //a[Index, 2, .. Index-1, 1, Index+1, .., K] 0
	
	dcl swapSRLlike(S,E) : 2 int , K // similar to SRL implementation
	def swapSRLlike :=         //a[1, 2, .., S-1, S, S+1, .., E-1, E, E+1, .., K], 0
		// V1
//		swapParamHelper{K}(E)  //a[E, 2, .., S-1, S, S+1, .., E-1, 1, E+1, .., K], 0
//		;swapParamHelper{K}(S) //a[S, 2, .., S-1, E, S+1, .., E-1, 1, E+1, .., K], 0
//		;swapParamHelper{K}(E) //a[1, 2, .., S-1, E, S+1, .., E-1, S, E+1, .., K], 0
		// BUG: if E == 1, then nothing happens
		// IF E == S, then it's equal to swap(1, S)
		// V2
//		swapParamHelper{K}(S)                //a[S, 2, .., S-1, 1, S+1, .., E-1, E, E+1, .., K], 0
//		;id{E-1}|swapParamHelper{1+K-E}(K-E) //a[S, 2, .., S-1, 1, S+1, .., E-1, K, E+1, .., E], 0
//		;swapParamHelper{K}(K)               //a[E, 2, .., S-1, 1, S+1, .., E-1, K, E+1, .., S], 0
//		;swapParamHelper{K}(S)               //a[1, 2, .., S-1, E, S+1, .., E-1, K, E+1, .., S], 0
//		;id{E-1}|swapParamHelper{1+K-E}(K-E) //a[1, 2, .., S-1, E, S+1, .., E-1, S, E+1, .., K], 0
		// V3
		//                            //a[1, 2, .., S-1, S, S+1, .., E-1, E, E+1, .., K], 0, 0
		id{K+1}|(inc{1}(E);dec{1}(S)) //a[1, 2, .., S-1, S, S+1, .., E-1, E, E+1, .., K], 0, E-S
		;if[
			id{S-1}|swapParamHelper{1+K-S}(1+E-S), //
			id{K+1},
			id{E-1}|swapParamHelper{1+K-E}(1+S-E)
		]
		;id{K+1}|(dec{1}(E);inc{1}(S)) 
	
	/**From chapter
	 * "A library of functions in RPP"
	 * of the paper
	 * "A class of Recursive Permutations which is Primitive Recursive complete"
	 * writen by: Luca Paolini, Mauro Piccolo, Luca Roversi,
	 * Dipartimento di Informatica - Universita' di Torino, Italy
	 */

	dcl increment(I,J) : 4 int, M  //a[1..M] 0 0 0
	def increment := // TODO : if I == J -> "a[M+1] == oldValue(a[I])" ... inserire i constrain nei parametri
		swapSRLlike{M+2}(I, M+2)  //a[1, .., I-1, 0, I+1, .., M] 0 I 0
		;id{M}|for[inc]|id|id     //a[1, .., I-1, 0, I+1, .., M] I I 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I, I+1, .., M] 0 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I J 0
		;id{M}|it[inc]|id|id      //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I+|J| J 0
		;id{M}| /2 1 3/|id        //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] J I+|J| 0
		;swapSRLlike{M+2}(J, M+1) //a[1, .., I-1, I, I+1, .., J-1, J, J +1, .., M] 0 I+|J| 0
		;swapSRLlike{M+2}(I, M+1) //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] I I+|J| 0
		;id{M}|for[dec]|id|id     //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] -|J| I+|J| 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I+|J|, I+1, .., J-1, J, J +1, .., M] -|J| 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+|J|, I+1, .., J-1, 0, J +1, .., M] -|J| J 0
		;id{M}|it[inc]|id|id      //a[1, .., I-1, I+|J|, I+1, .., J-1, 0, J +1, .., M] 0 J 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+|J|, I+1, .., J-1, J, J +1, .., M] 0 0 0


	dcl decrement(I,J) : 4 int, M
	def decrement := // TODO: if I == J -> "a[M+1] == oldValue(a[I])" ... inserire i constrain nei parametri
		swapSRLlike{M+2}(I, M+2)  //a[1, .., I-1, 0, I+1, .., M] 0 I 0
		;id{M}|for[inc]|id |id    //a[1, .., I-1, 0, I+1, .., M] I I 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I, I+1, .., M] 0 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I J 0
		;id{M}|it[dec]|id|id      //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I-|J| J 0
		;id{M}| /2 1 3/|id        //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] J I-|J| 0
		;swapSRLlike{M+2}(J, M+1) //a[1, .., I-1, I, I+1, .., J-1, J, J +1, .., M] 0 I-|J| 0
		;swapSRLlike{M+2}(I, M+1) //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] I I-|J| 0
		;id{M}|for[dec]|id|id     //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] +|J| I+|J| 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I+|J|, I+1, .., J-1, J, J +1, .., M] +|J| 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+|J|, I+1, .., J-1, 0, J +1, .., M] +|J| J 0
		;id{M}|it[dec]|id|id      //a[1, .., I-1, I+|J|, I+1, .., J-1, 0, J +1, .., M] 0 J 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+|J|, I+1, .., J-1, J, J +1, .., M] 0 0 0

	dcl addFrom(I,J) : 4 int, M  //a[1..M] 0 0 0
	def addFrom := // TODO : if I == J -> "a[M+1] == oldValue(a[I])" ... inserire i constrain nei parametri
		swapSRLlike{M+2}(I, M+2)  //a[1, .., I-1, 0, I+1, .., M] 0 I 0
		;id{M}|for[inc]|id|id     //a[1, .., I-1, 0, I+1, .., M] I I 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I, I+1, .., M] 0 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I J 0
		;id{M}|for[inc]|id|id     //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I+J J 0
		;id{M}| /2 1 3/|id       //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] J I+J 0
		;swapSRLlike{M+2}(J, M+1) //a[1, .., I-1, I, I+1, .., J-1, J, J +1, .., M] 0 I+J 0
		;swapSRLlike{M+2}(I, M+1) //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] I I+J 0
		;id{M}|for[dec]|id|id    //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] -J I+J 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I+J, I+1, .., J-1, J, J +1, .., M] -J 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+J, I+1, .., J-1, 0, J +1, .., M] -J J 0
		;id{M}|for[inc]|id|id     //a[1, .., I-1, I+J, I+1, .., J-1, 0, J +1, .., M] 0 J 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+J, I+1, .., J-1, J, J +1, .., M] 0 0 0


	dcl subFrom(I,J) : 4 int, M
	def subFrom := // TODO: if I == J -> "a[M+1] == oldValue(a[I])" ... inserire i constrain nei parametri
		swapSRLlike{M+2}(I, M+2)  //a[1, .., I-1, 0, I+1, .., M] 0 I 0
		;id{M}|for[inc]|id|id     //a[1, .., I-1, 0, I+1, .., M] I I 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I, I+1, .., M] 0 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I J 0
		;id{M}|for[dec]|id|id     //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I-J J 0
		;id{M}| /2 1 3/|id        //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] J I-J 0
		;swapSRLlike{M+2}(J, M+1) //a[1, .., I-1, I, I+1, .., J-1, J, J +1, .., M] 0 I-J 0
		;swapSRLlike{M+2}(I, M+1) //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] I I-J 0
		;id{M}|for[dec]|id|id     //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] +J I+J 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I+J, I+1, .., J-1, J, J +1, .., M] +J 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+J, I+1, .., J-1, 0, J +1, .., M] +J J 0
		;id{M}|for[dec]|id|id     //a[1, .., I-1, I+J, I+1, .., J-1, 0, J +1, .., M] 0 J 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+J, I+1, .., J-1, J, J +1, .., M] 0 0 0


	dcl preparationLessMore(I,J,P,Q,K) : int, M
	def preparationLessMore :=
//		swapSRLlike{M}(1,K)
//		;swapSRLlike{M}(2,P)
//		;swapSRLlike{M}(3,Q)
//		;swapSRLlike{M}(4,I)
//		;swapSRLlike{M}(5,J)
		swap{M+1}(1,K)
		;swap{M+1}(2,P)
		;swap{M+1}(3,Q)
		;swap{M+1}(4,I)
		;swap{M+1}(5,J)

	dcl lessThan (I,J,P,Q,K) : int, M
	def lessThan :=
		preparationLessMore{M}(I,J,P,Q,K)
		;IntegerCompare.less|id{M-4}
		;preparationLessMore{M}(I,J,P,Q,K)
		

	dcl moreThan (I,J,P,Q,K) : int, M
	def moreThan :=
		preparationLessMore{M}(I,J,P,Q,K)
		;IntegerCompare.more|id{M-4}
		;preparationLessMore{M}(I,J,P,Q,K)
		
}