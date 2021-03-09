import IntegerCompare.*

module YarelLib{
	
	dcl shiftFirstToLastK {2 int , K}  // returns a[2, 3, .. K, 1]
	def shiftFirstToLastK := // a[1..K] 0 0
		id{K} | inc{1}( K ) | inc{1}(K-1) // a[1..K] K K-1
		;for[
			/{K}/
			;id{K}|dec
		]
		;id{K} | dec | dec{1}(K-1)
		;/3 4 5 1 2/ | id{K-3}

	dcl shiftLastToFirstK {2 int , K}  // returns a[k, 1, 2, .. K-1]
	def shiftLastToFirstK := // a[1..K] 0 0
		id{K} | inc{1}(2) | inc{1}(K-1)
		;for[
			/{K}/
			;id{K}|inc
		]
		;id{K} | ((id|inc);for[dec])
		;id{K} | dec | dec{1}(K)

	dcl swapParamHelper {int, K}(Index):  //a[1 .. K] 0
		bound(Index, K)
	def swapParamHelper :=
		id{K}|inc{1}(Index)  //a[1, 2, .. Index-1, Index, Index+1, .., K] Index
		;/{K}/               //a[Index, 2, .. Index-1, 1, Index+1, .., K] Index
		;id{K}|dec{1}(Index) //a[Index, 2, .. Index-1, 1, Index+1, .., K] 0
	
	
	/*
	 * [0 , 1 2 3 4 5 6][
	 * 
	 */
	
	dcl swapSRLlike {2 int , K} (S,E): // similar to SRL implementation
		distinct(S, E), bound(S, K), bound(E, K)
	def swapSRLlike :=         //a[1, 2, .., S-1, S, S+1, .., E-1, E, E+1, .., K], 0, 0
		id{K+1}|(inc{1}(E);dec{1}(S)) //a[1, 2, .., S-1, S, S+1, .., E-1, E, E+1, .., K], 0, E-S
		;if[
			id{S-1}|swapParamHelper{1+K-S}(1+E-S), //
			id{K+1},
			id{E-1}|swapParamHelper{1+K-E}(1+S-E)
		]
		;id{K+1}|(inc{1}(S);dec{1}(E)) 
	
	/**From chapter
	 * "A library of functions in RPP"
	 * of the paper
	 * "A class of Recursive Permutations which is Primitive Recursive complete"
	 * writen by{} Luca Paolini, Mauro Piccolo, Luca Roversi,
	 * Dipartimento di Informatica - Universita' di Torino, Italy
	 * 
	 * NOTE{}
	 * on the paper, "I" and "J" are swapped{} it's written as "inc_j{}i"
	 */
	dcl increment {4 int, M} (I , J) :  //a[1..M] 0 0 0 0
		distinct(I, J), bound(I, M), bound(J, M)
	def increment := // TODO {} if I == J -> "a[M+1] == oldValue(a[I])" ... inserire i constrain nei parametri
		swapSRLlike{M+2}(I, M+2)  //a[1, .., I-1, 0, I+1, .., M] 0 I 0 0
		;id{M}|for[inc]|id|id     //a[1, .., I-1, 0, I+1, .., M] I I 0 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I, I+1, .., M] 0 0 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I J 0 0
		;id{M}|it[inc]|id|id      //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I+|J| J 0 0
		;id{M}| /2 1 3/|id        //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] J I+|J| 0 0
		;swapSRLlike{M+2}(J, M+1) //a[1, .., I-1, I, I+1, .., J-1, J, J +1, .., M] 0 I+|J| 0 0
		;swapSRLlike{M+2}(I, M+1) //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] I I+|J| 0 0
		;id{M}|for[dec]|id|id     //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] -|J| I+|J| 0 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I+|J|, I+1, .., J-1, J, J +1, .., M] -|J| 0 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+|J|, I+1, .., J-1, 0, J +1, .., M] -|J| J 0 0
		;id{M}|it[inc]|id|id      //a[1, .., I-1, I+|J|, I+1, .., J-1, 0, J +1, .., M] 0 J 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+|J|, I+1, .., J-1, J, J +1, .., M] 0 0 0 0




	/**From chapter
	 * "A library of functions in RPP"
	 * of the paper
	 * "A class of Recursive Permutations which is Primitive Recursive complete"
	 * writen by{} Luca Paolini, Mauro Piccolo, Luca Roversi,
	 * Dipartimento di Informatica - Universita' di Torino, Italy
	 * 
	 * NOTE{}
	 * on the paper, "I" and "J" are swapped{} it's written as "inc_j{}i"
	 */
	dcl decrement {4 int, M} (I,J) :  //a[1..M] 0 0 0 0
		distinct(I, J), bound(I, M), bound(J, M)
	def decrement := // TODO{} if I == J -> "a[M+1] == oldValue(a[I])" ... inserire i constrain nei parametri
		swapSRLlike{M+2}(I, M+2)  //a[1, .., I-1, 0, I+1, .., M] 0 I 0 0
		;id{M}|for[inc]|id |id    //a[1, .., I-1, 0, I+1, .., M] I I 0 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I, I+1, .., M] 0 0 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I J 0 0
		;id{M}|it[dec]|id|id      //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I-|J| J 0 0
		;id{M}| /2 1 3/|id        //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] J I-|J| 0 0
		;swapSRLlike{M+2}(J, M+1) //a[1, .., I-1, I, I+1, .., J-1, J, J +1, .., M] 0 I-|J| 0 0
		;swapSRLlike{M+2}(I, M+1) //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] I I-|J| 0 0
		;id{M}|for[dec]|id|id     //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] +|J| I-|J| 0 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I+|J|, I+1, .., J-1, J, J +1, .., M] +|J| 0 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+|J|, I+1, .., J-1, 0, J +1, .., M] +|J| J 0 0
		;id{M}|it[dec]|id|id      //a[1, .., I-1, I+|J|, I+1, .., J-1, 0, J +1, .., M] 0 J 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+|J|, I+1, .., J-1, J, J +1, .., M] 0 0 0 0

	dcl addFrom {4 int, M} (I,J) :  //a[1..M] 0 0 0 0
		distinct(I, J), bound(I, M), bound(J, M)
	def addFrom := // TODO {} if I == J -> "a[M+1] == oldValue(a[I])" ... inserire i constrain nei parametri
		swapSRLlike{M+2}(I, M+2)  //a[1, .., I-1, 0, I+1, .., M] 0 I 0 0
		;id{M}|for[inc]|id|id     //a[1, .., I-1, 0, I+1, .., M] I I 0 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I, I+1, .., M] 0 0 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I J 0 0
		;id{M}|for[inc]|id|id     //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I+J J 0 0
		;id{M}| /2 1 3/|id        //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] J I+J 0 0
		;swapSRLlike{M+2}(J, M+1) //a[1, .., I-1, I, I+1, .., J-1, J, J +1, .., M] 0 I+J 0 0
		;swapSRLlike{M+2}(I, M+1) //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] I I+J 0 0
		;id{M}|for[dec]|id|id     //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] -J I+J 0 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I+J, I+1, .., J-1, J, J +1, .., M] -J 0 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+J, I+1, .., J-1, 0, J +1, .., M] -J J 0 0
		;id{M}|for[inc]|id|id     //a[1, .., I-1, I+J, I+1, .., J-1, 0, J +1, .., M] 0 J 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I+J, I+1, .., J-1, J, J +1, .., M] 0 0 0 0


	dcl subFrom {4 int, M} (I,J) :
		distinct(I, J), bound(I, M), bound(J, M)
	def subFrom := // TODO{} if I == J -> "a[M+1] == oldValue(a[I])" ... inserire i constrain nei parametri
		swapSRLlike{M+2}(I, M+2)  //a[1, .., I-1, 0, I+1, .., M] 0 I 0 0
		;id{M}|for[inc]|id|id     //a[1, .., I-1, 0, I+1, .., M] I I 0 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I, I+1, .., M] 0 0 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I J 0 0
		;id{M}|for[dec]|id|id     //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] I-J J 0 0
		;id{M}| /2 1 3/|id        //a[1, .., I-1, I, I+1, .., J-1, 0, J +1, .., M] J I-J 0 0
		;swapSRLlike{M+2}(J, M+1) //a[1, .., I-1, I, I+1, .., J-1, J, J +1, .., M] 0 I-J 0 0
		;swapSRLlike{M+2}(I, M+1) //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] I I-J 0 0
		;id{M}|for[dec]|id|id     //a[1, .., I-1, 0, I+1, .., J-1, J, J +1, .., M] +J I-J 0 0
		;swapSRLlike{M+2}(I, M+2) //a[1, .., I-1, I-J, I+1, .., J-1, J, J +1, .., M] +J 0 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I-J, I+1, .., J-1, 0, J +1, .., M] +J J 0 0
		;id{M}|for[dec]|id|id     //a[1, .., I-1, I-J, I+1, .., J-1, 0, J +1, .., M] 0 J 0 0
		;swapSRLlike{M+2}(J, M+2) //a[1, .., I-1, I-J, I+1, .., J-1, J, J +1, .., M] 0 0 0 0



	dcl sameSignYLess{4 int , M} (K,P,Q) :
		distinct(P,Q,K), bound(K, M), bound(P, M), bound(Q, M)
	
	def sameSignYLess :=
		subFrom{M}(P,Q)
		;swapSRLlike{M+2}(P,  M+2)//a[] 0 P-Q 0 0
		;id{M} | /1 4 3 2/       // a[] 0 0 0 P-Q
		;if[
			id{M+3},
			id{M+3},
			id{K-1}|inc|id{3+M-K}
		]
		;id{M} | /1 4 3 2/       // a[] 0 P-Q 0 0
		;swapSRLlike{M+2}(P,  M+2)
		;addFrom{M}(P,Q)

	dcl sameSignYMore{4 int , M} (K,P,Q) :
		distinct(P,Q,K), bound(K, M), bound(P, M), bound(Q, M)
	
	def sameSignYMore :=
		subFrom{M}(P,Q)
		;swapSRLlike{M+2}(P,  M+2)//a[] 0 P-Q 0 0
		;id{M} | /1 4 3 2/       // a[] 0 0 0 P-Q
		;if[
			id{K-1}|inc|id{3+M-K},
			id{M+3},
			id{M+3}
		]
		;id{M} | /1 4 3 2/       // a[] 0 P-Q 0 0
		;swapSRLlike{M+2}(P,  M+2)
		;addFrom{M}(P,Q)

	dcl sameSignYCompare{4 int , M} (K,P,Q) :
		distinct(P,Q,K), bound(K, M), bound(P, M), bound(Q, M)
	def sameSignYCompare  :=
		subFrom{M}(P,Q)
		;swapSRLlike{M+2}(P,  M+2)//a[] 0 P-Q 0 0
		;id{M} | /1 4 3 2/       // a[] 0 0 0 P-Q
		;if[
			id{K-1}|inc|id{3+M-K},
			id{M+3},
			id{K-1}|dec|id{3+M-K}
		]
		;id{M} | /1 4 3 2/       // a[] 0 P-Q 0 0
		;swapSRLlike{M+2}(P,  M+2)
		;addFrom{M}(P,Q)

	
	dcl dupNumbersStep {6 int, M} (I,J,P,Q,K)
	def dupNumbersStep :=
		addFrom{M+2}(Q, J)
		;addFrom{M+2}(P,I)
		;swapSRLlike{M+4}(M+2,J)// a[] 0 J 0 0 0 0
		;swapSRLlike{M+4}(M+1,I)// a[] I J 0 0 0 0
		;id{M}|/3 4 5 6 1 2/    // a[] 0 0 0 0 I J


	dcl lessThan {6 int, M} (I,J,P,Q,K) :
		distinct(I,J,P,Q,K), bound(I, M), bound(J, M), bound(K, M), bound(P, M), bound(Q, M)
	def lessThan :=
		dupNumbersStep{M}(I,J,P,Q,K)
		;if[
			if[
				sameSignYLess{M}(K,P,Q),
				id{K-1}|inc|id{4+M-K},
				id{K-1}|inc|id{4+M-K}
			],
			if[
				id{M+4},
				id{M+4},
				id{K-1}|inc|id{4+M-K}
			],
			if[
				id{M+4},
				id{M+4},
				sameSignYLess{M}(K,P,Q)
			]
		]
		;inv[
			dupNumbersStep{M}(I,J,P,Q,K)
		]

	dcl moreThan {6 int, M}  (I,J,P,Q,K) :
		distinct(I,J,P,Q,K), bound(I, M), bound(J, M), bound(K, M), bound(P, M), bound(Q, M)
	def moreThan :=
		dupNumbersStep{M}(I,J,P,Q,K)
		;if[ // if J
			if[ // if I
				sameSignYMore{M}(K,P,Q),
				id{M+4},
				id{M+4}
			],
			if[
				id{K-1}|inc|id{4+M-K},
				id{M+4},
				id{M+4}
			],
			if[
				id{K-1}|inc|id{4+M-K},
				id{K-1}|inc|id{4+M-K},
				sameSignYMore{M}(K,P,Q)
			]
		]
		;inv[
			dupNumbersStep{M}(I,J,P,Q,K)
		]

	dcl compareThan {6 int, M} (I,J,P,Q,K) :
		distinct(I,J,P,Q,K), bound(I, M), bound(J, M), bound(K, M), bound(P, M), bound(Q, M)
	def compareThan :=
		dupNumbersStep{M}(I,J,P,Q,K)
		;if[
			if[
				sameSignYCompare{M}(K,P,Q),
				id{K-1}|dec|id{4+M-K},
				id{K-1}|dec|id{4+M-K}
			],
			if[
				id{K-1}|inc|id{4+M-K},
				id{M+4},
				id{K-1}|dec|id{4+M-K}
			],
			if[
				id{K-1}|inc|id{4+M-K},
				id{K-1}|inc|id{4+M-K},
				sameSignYCompare{M}(K,P,Q)
			]
		]
		;inv[
			dupNumbersStep{M}(I,J,P,Q,K)
		]


	dcl compareThanOverflowUnsafe {4 int, M} (I,J,P,Q,K):
		distinct(I,J,P,Q,K), bound(I, M), bound(J, M), bound(K, M), bound(P, M), bound(Q, M)
	def compareThanOverflowUnsafe :=
		sameSignYCompare{M}(K,I,J)


	dcl mult {4 int , M} (K,J,I) :
		distinct(I,J, K), bound(I, M), bound(J, M), bound(K, M)
	def mult :=
	swapSRLlike{M+2}(M+2,I)
	;swapSRLlike{M+2}(M+1,J)
	;id{M} | /3 4 1 2/
	;it[it[id{K-1} | inc | id{2+M-K}]]
	;if[
		if[
			id{M+2},
			id{M+2},
			id{K-1}|neg|id{2+M-K}
		],
		if[
			
			id{M+2},
			id{M+2},
			id{M+2}
		],
		if[
			
			id{K-1}|neg|id{2+M-K},
			id{M+2},
			id{M+2}
		]
	]
	;id{M} | /3 4 1 2/
	;swapSRLlike{M+2}(M+1,J)
	;swapSRLlike{M+2}(M+2,I)

}