module ParametricStuffs{
	
	dcl shiftLastToFirstK_OLD: 2 int , K
	def shiftLastToFirstK_OLD := // a[1..K] 0 K
		id{K} | for[inc]         // a[1..K] K K
		;for[
			/{K}/
			;id{K}|dec
		]

	dcl shiftFirstToLastK_OLD: 2 int , K
	def shiftFirstToLastK_OLD := // a[1..K] 0 K
		id{K}|inc|dec
		;for[
			/{K}/
			;id{K}|inc
		]
		;id{K} | ((id|inc);for[dec])

	dcl paramSum : 2 int, K_g, lel, I
	def paramSum :=
		id{K_g} | for[inc] | id{lel} | inc{I}
		;
		id{lel} | for[inc] |id{K_g} | inc{I}


	dcl negativeParamWarning: 2 int, K, J
	def negativeParamWarning :=
		id{J-3} |id{K}  |inc{-(-5)-K}  |id{K}
		;id{J} | for[inc] |id{K} 
		;swap{K+J+2}( K-1, J+K-2)
	
	dcl hello: int , K
	def hello:=	
		swap{K+1}(2,4)
		;id|neg{2}(3)|inc{K-2}
		;neg{1}(4)|id|id|inc{K-2}(4)
		
	dcl doubleSwapSomewhere : 7 int , a, B
	def doubleSwapSomewhere :=
		dec|id|swap{a}(2, a-2)|for[inc;inc]|swapSRLlike{B}(3,B-3)|(inc;neg)|inc{1}(a+B)

	dcl decIncr(Amount) : 2 int
	def decIncr :=
		dec{1}(Amount)|inc{1}(Amount)
	
	dcl decIncrDouble(Amount1, Amount2) : int,  int , K
	def decIncrDouble :=
		dec{1}(Amount1)| neg{K}(1) | inc{1}(Amount2)
	
	dcl incrAll : K
	def incrAll :=
		inc{K}(1)
		
		
	dcl multipleParArities(IncrAmount, NegAmount): IncrAr, NegAr
	def multipleParArities :=
		inc{IncrAr}(IncrAmount)|neg{NegAr}(NegAmount)
		
	

	/* start usefull staffs */

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



}