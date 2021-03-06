
module minorTests {
		
	dcl justASwap(I): int, K
	def justASwap :=
		id{K}|inc{1}(I)
		;/{K}/
		;id{K}|dec{1}(I)
		
	dcl justASwap2(I): 3 int, K
	def justASwap2 :=
		id{K+2}|inc{1}(I)
		;id|id|/{K}/
		;id{K+2}|dec{1}(I)
		
		
	dcl paramInc(Amount) : K
	def paramInc :=
		inc{K}(Amount)
	
	dcl paramDec(Amount) : K
	def paramDec :=
		dec{K}(Amount)
	
	dcl paramNeg(Amount) : K
	def paramNeg :=
		neg{K}(Amount)
	
	dcl paramItInc(Amount) : K
	def paramItInc :=
		it(Amount)[inc{K}(1)]
	
	dcl paramItFor(Amount) : K
	def paramItFor :=
		for(Amount)[inc{K}(1)]
}