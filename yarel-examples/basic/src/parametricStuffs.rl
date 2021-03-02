module ParametricStuffs{
	
	dcl shiftLastToFirstK_OLD: 2 int , K
	def shiftLastToFirstK_OLD := // a[1..K] 0 K
		id{K} | for[inc]     // a[1..K] K K
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
		;swap{K+J+1}( K-1, J+K-2)
	
	dcl hello: int , K
	def hello:=
		swap{K}(2,4)
		;id|neg{2}(3)|inc{K-2}
		;neg{1}(4)|id|id|inc{K-2}(4)

	dcl shiftFirstToLastK : 2 int , K
	def shiftFirstToLastK := // a[1..K] 0 0
		id{K} | inc{1}( K ) | inc{1}(K-1) // a[1..K] K K-1
		;for[
			/{K}/
			;id{K}|dec
		]
		;inv[id{K} | dec{1}(K) | dec{1}(K-1)]

	dcl shiftLastToFirstK : 2 int , K
	def shiftLastToFirstK := // a[1..K] 0 0
		id{K} | inc{1}(2) | inc{1}(K-1)
		;for[
			/{K}/
			;id{K}|inc
		]
		;id{K} | ((id|inc);for[dec])
		;id{K+1} | dec{1}(K-1)

	dcl swapNonNative(S,E) : int , K // similar to SRL implementation
	def swapNonNative := //a[1, 2, .. S, S+1, .. E, E+1, .., K], 0
		id{K}|inc{1}(E)  //a[1, 2, .. S, S+1, .. E, E+1, .., K], E
		;/{K}/           //a[E, 2, .. S, S+1,.., 1, E+1, .., K], E
		;id{K}|dec{1}(E) //a[E, 2, .. S, S+1,.., 1, E+1, .., K], 0
		;id{K}|inc{1}(S) //a[E, 2, .. S, S+1, .. 1, E+1, .., K], S
		;/{K}/           //a[S, 2, .. E, S+1,.., 1, E+1, .., K], S
		;id{K}|dec{1}(S) //a[S, 2, .. E, S+1,.., 1, E+1, .., K], 0
		;id{K}|inc{1}(E) //a[S, 2, .. E, S+1, .. 1, E+1, .., K], E
		;/{K}/           //a[1, 2, .. E, S+1,.., S, E+1, .., K], E
		;id{K}|dec{1}(E) //a[1, 2, .. E, S+1,.., S, E+1, .., K], 0


}