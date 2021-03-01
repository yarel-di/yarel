module ParametricStuffs{
	
	dcl shiftLastToFirstK: 2 int , K
	def shiftLastToFirstK := // a[1..10] 0 10
		id{K} | for[inc]     // a[1..10] 10 10
		;for[
			/{K}/
			;id{K}|dec
		]
	
	dcl shiftFirstToLastK: 2 int , K
	def shiftFirstToLastK := // a[1..10] 0 10
		id{K}|inc|dec
		;for[
			/{K}/
			;id{K}|inc
		]
		;id{K} | ((id|inc);for[dec])
	
	dcl paramSum: 2 int, K, J
	def paramSum :=
		id{K} | for[inc] | id{J}
		;
		id{J} | for[inc] |id{K}
		
	
	dcl negativeParamWarning: 2 int, K, J
	def negativeParamWarning :=
		id{J} | for[inc] |id{K} 
		;id{J-3} |id{K}  |id{5-K}  |id{K}
		
	dcl hello: int , K
	def hello:=
		for[/{K-1}/]
}