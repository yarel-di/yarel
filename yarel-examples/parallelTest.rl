module ParallelTest{
	dcl someAtomicStuffs : 7 int
	def someAtomicStuffs :=
		inc | dec | id | (it[inc];(neg|id)) | neg | (inc;inc;inc)
		
	dcl iLikeParallelism : 7 int
	def iLikeParallelism :=
		for[inc | inc | inc | inc | inc | inc]
		
		
	dcl largePermutation : 10 int
	def largePermutation :=
		/8 2 6 4 1 3 10 9 7 5/
		;inc|inc|inc|inc|inc|inc|inc|inc|inc|inc
		
	dcl rearrangeLargePerm : 10 int
	def rearrangeLargePerm :=
		/5 2 6 4 10 3 9 1 8 7/
}