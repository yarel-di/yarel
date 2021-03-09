
module minorTests {
		
	dcl justASwap{int, K} (I): bound(I,K) 
	def justASwap :=
		id{K}|inc{1}(I)
		;/{K}/
		;id{K}|dec{1}(I)
		
	dcl justASwap2{3 int, K} (I): bound(I,K)
	def justASwap2 :=
		id{K+2}|inc{1}(I)
		;id|id|/{K}/
		;id{K+2}|dec{1}(I)
				
	dcl swapSRLLike2{1 int, K} (I, J):
		distinct(I, J), bound(I,K), bound(J,K)
	def swapSRLLike2:=
		id{K}|inc{1}(I) 
		;/{K}/
		;id{K}|dec{1}(I)
		;id{K}|inc{1}(J)
		;/{K}/
		;id{K}|dec{1}(J)
		;id{K}|inc{1}(I)
		;/{K}/
		;id{K}|dec{1}(I)
		
	dcl paramInc{K} (Amount) : positive(Amount)
	def paramInc :=
		inc{K}(Amount)
	
	dcl paramDec{K}(Amount) : natural(Amount)
	def paramDec :=
		dec{K}(Amount)
	
	dcl paramNeg{K}(Amount) : natural(Amount)
	def paramNeg :=
		neg{K}(Amount)
	
	dcl paramItInc{K}(Amount) : natural(Amount)
	def paramItInc :=
		it(Amount)[inc{K}(1)]
	
	dcl paramItFor{K}(Amount) : natural(Amount)
	def paramItFor :=
		for(Amount)[inc{K}(1)]
}