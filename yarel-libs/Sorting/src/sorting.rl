//import YarelLib.*
import CantorPairing.*
import IntegerCompare.*
import BitStack.*

module Sorting{
	
	dcl pairExtraction {4 int , K}
	def pairExtraction:=
		// PHASE 1: extract values from the array into a comfortable place (i.e., outside the array)
						// a[1..K] 0 0 0 ii
		id{K+2}|inc{1}(K+1)|id // a[1..K] 0 0 K+1 ii
		;/{K+3}/               // a[ii,2,..,ii-1,1,ii+1,..K] 0 0 K+1 ii
		;/{K+2}/|id           // a["0",2,..,ii-1,1,ii+1,..K] a[ii] 0 K+1 ii
		;/{K+3}/              // a[1,2,..,ii-1,"0",ii+1,..K] a[ii] 0 K+1 ii
		;id{K+2}|inc{2}(1)    // a[1,2,..,ii-1,"0",ii+1,..K] a[ii] 0 K+2 ii+1
		;/{K+3}/         // a[ii+1,2,..,ii-1,"0",1,ii+2,..K] a[ii] 0 K+2 ii+1
		;/{K+2}/|id       // a["0",2,..,ii-1,"0",1,ii+2,..K] a[ii] a[ii+1] K+2 ii+1
		;/{K+3}/          // a[1,2,..,ii-1,"0","0",ii+1,..K] a[ii] a[ii+1] K+2 ii+1
	

	dcl sortGrowing {11 int , K}
	def sortGrowing := //x and y are useless values  // a[1;K] x:=0 y:=0 0 0 0 0 0 g:=(0) 0 0 0
		id{K+8} | inc| inc{2}(K-1)				// a[1;K] x:=0 y:=0 0 0 0 0 0 g:=(0) 1 K-1 K-1
		// the "1" before the pair of "K-1" is placed because Yarel's permutations and indexes are 1-based
		;it[	//for rep = k-1; rep > 0; rep--) {
			it[ //for i = 1; i < rep; i-- { ... "ii" is a usable copy of "i"
													// a[1..K] 0 0 0, 0 0 0 0 g ii(start:=1)

				id{K+3}|/6 5 3 4 1 2/		// a[1..K] 0 0 0, ii g 0 0 0 0
				;pairExtraction{K}|id{5}
							//a[1,2,..,ii-1,"0","0",ii+1,..K] a[ii] a[ii+1] K+2 ii+1 g 0 0 0 0
				
				;id{K}|/6 7 8 1 2 3 4 5 9/			 // a[..] 0 0 0 a[ii] a[ii+1] K+2 ii+1 g 0
				;id{K}|more|id{4}					 // a[..] M 0 0 a[ii] a[ii+1] K+2 ii+1 g 0
				;id{K}|/4 5 1 6 7 8 2 3 9/			 // a[..] a[ii] a[ii+1] M K+2 ii+1 g 0 0 0
				;id{K}| if[/2 1/,id|id,id|id] |id{6} // a[..] a[sor ; ted]  M K+2 ii+1 g 0 0 0
				;id{K+2}|/2 3 4 1 5 6 7/			 // a[..] a[sor ; ted], K+2 ii+1 g M 0 0 0
				
				;inv[
				pairExtraction{K}
				
				]|inv[cu]							// a[1..K] 0 0 0,ii cp(g,M) 0 0 0 0
				;id{K+3}|/5 6 3 4 2 1/				// a[1..K] 0 0 0,0 0 0 0 cp(g,M) ii
				//.. at the end, clean up the registers AND increase the index conter
				;id{K+8}|inc
			]
										// a[1..K] 0 0 0,0 0 0 0 cp(g,M) ii i
			;id{K+8} | for[dec] // restores "ii" to 1
			;id{K+9} | dec				// a[1..K] 0 0 0,0 0 0 0 cp(..cp(cp(g,M'),M''),..) 1 i-1
		]
		;id{K+8}|(dec|id|dec{1}(K-1))//last cleanup

	dcl sortUngrowing {11 int , K}
	def sortUngrowing := //x and y are useless values  // a[1;K] x:=0 y:=0 0 0 0 0 0 g:=(0) 0 0 0
		id{K+8} | inc| inc{2}(K-1)				// a[1;K] x:=0 y:=0 0 0 0 0 0 g:=(0) 1 K-1 K-1
		// the "1" before the pair of "K-1" is placed because Yarel's permutations and indexes are 1-based
		;it[	//for rep = k-1; rep > 0; rep--) {
			it[ //for i = 1; i < rep; i-- { ... "ii" is a usable copy of "i"
													// a[1..K] 0 0 0, 0 0 0 0 g ii(start:=1)

				id{K+3}|/6 5 3 4 1 2/		// a[1..K] 0 0 0, ii g 0 0 0 0
				;pairExtraction{K}|id{5}
							//a[1,2,..,ii-1,"0","0",ii+1,..K] a[ii] a[ii+1] K+2 ii+1 g 0 0 0 0
				
				;id{K}|/6 7 8 1 2 3 4 5 9/			 // a[..] 0 0 0 a[ii] a[ii+1] K+2 ii+1 g 0
				;id{K}|less|id{4}					 // a[..] M 0 0 a[ii] a[ii+1] K+2 ii+1 g 0
				;id{K}|/4 5 1 6 7 8 2 3 9/			 // a[..] a[ii] a[ii+1] M K+2 ii+1 g 0 0 0
				;id{K}| if[/2 1/,id|id,id|id] |id{6} // a[..] a[sor ; ted]  M K+2 ii+1 g 0 0 0
				;id{K+2}|/2 3 4 1 5 6 7/			 // a[..] a[sor ; ted], K+2 ii+1 g M 0 0 0
				
				;inv[
				pairExtraction{K}
				
				]|inv[cu]							// a[1..K] 0 0 0,ii cp(g,M) 0 0 0 0
				;id{K+3}|/5 6 3 4 2 1/				// a[1..K] 0 0 0,0 0 0 0 cp(g,M) ii
				//.. at the end, clean up the registers AND increase the index conter
				;id{K+8}|inc
			]
										// a[1..K] 0 0 0,0 0 0 0 cp(g,M) ii i
			;id{K+8} | for[dec] // restores "ii" to 0
			;id{K+9} | dec				// a[1..K] 0 0 0,0 0 0 0 cp(..cp(cp(g,M'),M''),..) 0 i+1
		]
		;id{K+8}|(dec|id|dec{1}(K-1))//last cleanup



		
	dcl pairExtraction2 {4 int , K}
	def pairExtraction2:=
		/{K+3}/               // a[ii,2,..,ii-1,1,ii+1,..K] 0 0 K+1 ii
		;/{K+2}/|id           // a["0",2,..,ii-1,1,ii+1,..K] a[ii] 0 K+1 ii
		;/{K+3}/              // a[1,2,..,ii-1,"0",ii+1,..K] a[ii] 0 K+1 ii
		;id{K+2}|inc{2}(1)    // a[1,2,..,ii-1,"0",ii+1,..K] a[ii] 0 K+2 ii+1
		;/{K+3}/         // a[ii+1,2,..,ii-1,"0",1,ii+2,..K] a[ii] 0 K+2 ii+1
		;/{K+2}/|id       // a["0",2,..,ii-1,"0",1,ii+2,..K] a[ii] a[ii+1] K+2 ii+1
		;/{K+3}/          // a[1,2,..,ii-1,"0","0",ii+1,..K] a[ii] a[ii+1] K+2 ii+1


	dcl sortGrowingOpt {9 int , K} // "s" is the bit-stack
	def sortGrowingOpt :=             // a[1;K] 0 s:=0 0 0 0 0 0 0 0
		id{K+5}|inc|inc{3}(K-1)  // a[1;K] 0 s 0 0 0 i:=1 K-1 j:=K-1 K-1
		;id{K+6}|(inc;inc)|id|id // a[1;K] 0 s 0 0 0 i:=1 K+1 j:=K-1 K-1
		;id{K+2}|/5 4 3 1 2 6 7/ // a[1;K] 0 s K+1 i 0 0 0 j:=K-1 K-1
		;it[
			it[ // iterated j times
				                   // a[1;K] 0 s K+1 i 0 0 0 
				pairExtraction2{K}|id|id|id
					//a[1,2,..,i-1,"0",s,i+1,..K] a[i] a[i+1] K+2 i+1 0 0 0 
				; id{K}|/5 6 7 1 2 3 4/
				; id{K}|more|id|id      // M 0 0 a[i] a[i+1] K+2 i+1
				; id{K}|/4 5 1 6 7 2 3/ // a[i] a[i+1] M K+2 i+1 0 0
				; id{K}| if[/2 1/, id|id, id|id] | id{4}
				; id{K+2}|/2 3 1/|id|id //a[sor] a[ted] K+2 i+1 M 0 0
				; inv[pairExtraction2{K}]|id{3} // a[..] 0 s K+1 i M 0 0
				; id{K}|/2 5 1 6 7 3 4/ // a[..] s M 0 0 0 K+1 i
				; id{K}|bitpush|id|inc  // a[..] bp(s) 0^4 K+1 i+1
				; id{K}|/2 1 6 7 3 4 5/ // a[1;K] 0 bp(s) K+1 i+1 0 0 0 
			] // a[..] 0 s K+1 j+1 0 0 0 j
			; id{K+4}|/4 2 3 1/         // a[..] 0 s K+1 j+1 j 0 0 0
			; id{K+3}|for[dec]|id|id|id // a[..] 0 s K+1 1 j 0 0 0
			; id{K+4}|dec|id|id|id      // a[..] 0 s K+1 1 j-1 0 0 0
			; id{K+4}|/4 2 3 1/         // a[..] 0 s K+1 1 0 0 0 j-1
		]                    // a[..] 0 s K+1 1 0 0 0 0 K-1
		; id{K}|/2 1/|dec{1}(K+1)|dec|id{4}|dec{1}(K-1)


	dcl sortUngrowingOpt {9 int , K} // "s" is the bit-stack
	def sortUngrowingOpt :=      // a[1;K] 0 s:=0 0 0 0 0 0 0 0
		id{K+5}|inc|inc{3}(K-1)  // a[1;K] 0 s 0 0 0 i:=1 K-1 j:=K-1 K-1
		;id{K+6}|(inc;inc)|id|id // a[1;K] 0 s 0 0 0 i:=1 K+1 j:=K-1 K-1
		;id{K+2}|/5 4 3 1 2 6 7/ // a[1;K] 0 s K+1 i 0 0 0 j:=K-1 K-1
		;it[
			it[ // iterated j times
				                   // a[1;K] 0 s K+1 i 0 0 0 
				pairExtraction2{K}|id|id|id
					//a[1,2,..,i-1,"0",s,i+1,..K] a[i] a[i+1] K+2 i+1 0 0 0 
				; id{K}|/5 6 7 1 2 3 4/
				; id{K}|less|id|id      // M 0 0 a[i] a[i+1] K+2 i+1
				; id{K}|/4 5 1 6 7 2 3/ // a[i] a[i+1] M K+2 i+1 0 0
				; id{K}| if[/2 1/, id|id, id|id] | id{4}
				; id{K+2}|/2 3 1/|id|id //a[sor] a[ted] K+2 i+1 M 0 0
				; inv[pairExtraction2{K}]|id{3} // a[..] 0 s K+1 i M 0 0
				; id{K}|/2 5 1 6 7 3 4/ // a[..] s M 0 0 0 K+1 i
				; id{K}|bitpush|id|inc  // a[..] bp(s) 0^4 K+1 i+1
				; id{K}|/2 1 6 7 3 4 5/
			] // a[..] 0 s K+1 j+1 0 0 0 j
			; id{K+4}|/4 2 3 1/         // a[..] 0 s K+1 j+1 j 0 0 0
			; id{K+3}|for[dec]|id|id|id // a[..] 0 s K+1 1 j 0 0 0
			; id{K+4}|dec|id|id|id      // a[..] 0 s K+1 1 j-1 0 0 0
			; id{K+4}|/4 2 3 1/         // a[..] 0 s K+1 1 0 0 0 j-1
		]                    // a[..] 0 s K+1 1 0 0 0 0 K-1
		; id{K}|/2 1/|dec{1}(K+1)|dec|id{4}|dec{1}(K-1)

}