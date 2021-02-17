module Gioco{
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
}