module ParallelTest{
	
	/* First sequence of tests functions*/
	
	dcl to_odd : 2 int
	def to_odd := 
		/*x 0*/
		/2 1/ /*0 x -> swapped*/
		;for[inc; inc] /*2*x x*/
		;inc|id /*((2*x)+1) x*/
		;/2 1/ /*swap back */


	dcl biIncPar : 2 int
	def biIncPar := inc|inc


	dcl triIncPar : 3 int
	def triIncPar := biIncPar|inc


	dcl triIncParExplicit : 3 int
	def triIncParExplicit := inc|inc|inc


	dcl mult : 3 int
	def mult := /*x y 0*/
		/3 2 1/
		;for [ for[inc]]
		;/3 2 1/


	dcl upAndDown : 4 int
	def upAndDown := /* 0 x y 0 */
		/1 2 4 3/ /*0 x 0 y*/
		;it[dec]|it[inc]  /*x x y y*/


	dcl someSwaps : 10 int
	def someSwaps :=
		/10 6 5 2 8 4 9 3 1 7/
	
	
	
	/* Second sequence of tests functions*/
	
	
	dcl someAtomicStuffs : 7 int
	def someAtomicStuffs :=
		inc | dec | id | (it[inc];(neg|id)) | neg | (inc;inc;inc)
		
	dcl iLikeParallelism : 7 int
	def iLikeParallelism :=
		for[inc | inc | inc | inc | inc | inc]
		
		
	dcl largePermutation : 10 int
	def largePermutation :=
		/8 2 6 4 1 3 10 9 7 5/
		;inc|id|inc| (dec|dec) |inc|neg|inc|inc|inc
		
	dcl rearrangeLargePerm : 10 int
	def rearrangeLargePerm :=
		/5 2 6 4 10 3 9 1 8 7/
		
	dcl empty2 : 2 int
	def empty2 :=
		id|id
		
	dcl empty3 : 3 int
	def empty3 :=
		id|id|id

	dcl anotherOneIncInTheDust : 3 int
	def anotherOneIncInTheDust :=
		id|id|inc
	
	dcl oneDecInMiddle : 3 int
	def oneDecInMiddle :=
		id|dec|id

	dcl oneNegAtStart: 3 int
	def oneNegAtStart :=
		neg|id|id

	dcl wastingSomeID : 5 int
	def wastingSomeID :=
		inc|id|id|id|dec
		
		
	dcl cosmicVoid : 9 int
	def cosmicVoid :=
		id|id|id|id|id|id|id|id|id

	dcl veryAloneInc : 10 int
	def veryAloneInc :=
		id|id|id| inc |id|id|id|id|id|id
	
	
	dcl oneHoleInIds : 10 int
	def oneHoleInIds :=
		id|id|id|id|id|id| for[inc|inc]|neg
	
	dcl threeHoleInIds : 13 int
	def threeHoleInIds :=
		id|id| (/2 3 1/;empty3) |id| for[for[dec]]|id|empty2|id
}