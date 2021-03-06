//import YarelLib.*
import CantorPairing.*
import IntegerCompare.*

module Sorting{

	dcl sortGrowing_old : 11 int , K
	def sortGrowing_old := //x and y are useless values  // a[1;K] x:=0 y:=0 0 0 0 0 0 0 g:=(0) 0 0
		id{K}| id{8} | inc{3}(K-1) // LA PARTE FRAGILE DA RIVEDERE
											// a[1;K] x y 0 0 0 0 0 g K-1 K-1 K-1
		;it[// for repeat K-1 times
			it[ // for i = K-1; i > 0; i--
				// ii serves to span across [1;i+1] , while the for spans over [0;i]
										                 // a[1;K] x y 0 0 0 0 0 g ii
				id{K+2} | inc{1}(K+1) | /6 5 3 4 1 2/    // a[1;K] x y k+1 ii g 0 0 0 0
				;(
					/{K+3}/         //a[ii,2,..,ii-1,1,ii+1,..K] x y K+1 ii computing{inv[cu]}{5}
					;/{K+2}/|id //a[x,2,..,ii-1,1,ii+1,..K] a[t_1] y K+1 ii ..comp{inv[cu]}{5}
					;/{K+3}/ // swap the x at a[1] with the original(a[1]1) that is at ii
								//a[1,2,..,ii-1,x,ii+1,..K] a[t_i] y K+1 ii
					;id{K+2}|inc{2}(1)       // a[..] a[t_i] y K+2 ii+1 ...
					;/{K+3}/    //a[ii+1,2,..,ii-1,x, 1,ii+2,..K] a[ii] y K+2 ii+1 ...
					;/{K+2}/|id //a[y,2,..,ii-1,x, 1,ii+2,..K] a[ii] a[ii+1] K+2 ii+1 ...
					;/{K+3}/    //a[1,2,..,ii-1,x, y,ii+2,..K] a[ii] a[ii+1] K+2 ii+1 ...
							    //a[1,2,..,ii-1,x, y,ii+2,..K] a[ii] a[ii+1] K+2 ii+1 ...
				) | id{5}         //a[1,2,..,ii-1,x, y,ii+2,..K] a[ii] a[ii+1] K+2 ii+1 pop(g) ? 0 0 0
				/*should be "cu" instead of id{5}? if not, then the "?" register is 0 and "pop(g)" is "g"
				 * I'll use "gg" and "(0)" just to not confuse them with weird values or other zeros
				*/
												//a[1..K] a[ii] a[ii+1] K+2 ii+1 pop(g) ? 0 0 0
				;id{K} | /1 2 7 8 9 3 4 5 6/     // a[..] a[ii] a[ii+1] 0 0 0 K+2 ii+1 gg (0)
				;id{K} | (/4 5 3 1 2/;more;/4 5 1 2 3/) | id{4} // a[..] a[ii] a[ii+1] M 0 0 K+2 ii+1 gg (0)
				//L == 1 <-> inverted order (so, requires a sorting)
				;id{K} | if[ /2 1/, id|id, id|id ] | id{6} // a[..] a[sor,ted] M 0 0 K+2 ii+1 gg (0)
				;/{K+5}/| id{3} //a[ted,2,..,ii-1,x, y,ii+2,..K] a[sor] a[1] M 0 0 K+2 ii+1 gg (0)
				;/{K+6}/| id{2} //a[y,2,..,ii-1,x, ted,ii+2,..K] a[sor] a[1] M 0 0 K+2 ii+1 gg (0)
				;/{K+5}/| id{3} //a[1,2,..,ii-1,x, ted,ii+2,..K] a[sor] y M 0 0 K+2 ii+1 gg (0)
				;id{K+5}|dec|dec|id|id // K+2 -> K+1 ; ii+1 -> ii

				;/{K+5}/| id{3} //a[sor,2,..,ii-1,x, ted,ii+2,..K] a[1] y M 0 0 K+1 ii gg (0)
				
				//bugfix
				// if the "sor"'s index is 1 (i.e., ii == 1), then do NOT swap ... because there's a bug
//				;/{K+5}/| (/2 3 1/;(id|for[inc]);(id|id|dec)) //a[sor,2,..,ii-1,x, ted,ii+2,..K] a[1] y M 0 0 K+1 gg ii ii-1
//				;if[
//					(					 //a[sor,2,..,ii-1,x, ted,ii+2,..K] a[1] y M, 0 0 K+1 gg ii
//					id{K+3}|/3 2 4 5 1/	 //a[sor,2,..,ii-1,x, ted,ii+2,..K] a[1] y M, K+1 0 gg ii 0
//					;/{K+6}/|id			 //a[x,2,..,ii-1,sor, ted,ii+2,..K] a[1] y M, K+1 0 gg ii 0
//					;/{K+3}/|id{4}		 //a[1,2,..,ii-1,sor, ted,ii+2,..K] x    y M, K+1 0 gg ii 0
//					;id{K+3}|/5 2 1 3 4/ //a[1,2,..,ii-1,sor, ted,ii+2,..K] x    y M, 0 0 K+1 gg ii
//					),
//					id{K+8}, // fix the bug by skipping the swap
//					id{K+8} // impossible
//				]
//					//a[1,2,..,ii-1,sor, ted,ii+2,..K] x    y M 0 0 K+1 gg ii ii-1
//				;id{K+2} | (
//					id{5}|/2 1/
//					;id{5}|inc|id	 // a[..] x y , M 0 0 K+1 gg ii ii
//					;id{5}|for[dec]  // a[..] x y , M 0 0 K+1 gg 0  ii
//					;/4 7 5 1 2 6 3/ // a[..] x y , K+1 ii gg M (0) 0 0
//				)

					// a[..] x y K+1 ii gg M (0) 0 0
				; (
					id{K+2} | dec{1}(K+1) | dec
				) |inv[cu]
				// a[..] x y 0 , ii-1 cp(gg,M) 0 (0) 0 0
				;id{K+3} | /5 6 3 4 2 1/
				// a[..] x y 0 0 (0) 0 0 cp(gg,M) ii-1
			]
							  // a[1..k] x y 0 0 0 0 0 pop(g) ii=0 i-1
			;id{K+9}|dec      // a[1..k] x y 0 0 0 0 0 pop(g) ii=0 i-2
			;id{K+8}|it[inc] // a[1..k] x y 0 0 0 0 0 pop(g) ii=i-2 i-2
		]
		// we should have, now
//		// a[all sorted] x y 0 0 0 0 0 cp(cp(..)) 0 -1 K-1
		// a[all sorted] x y 0 0 0 0 0 cp(cp(..)) 0 0 K-1
		; id{K} | /8 1 2 4 5 6 7 3/ | id| id| dec{1}(K-1)
//		; TODO CLEANUP of "I-?" and "K-bla" AND ARRANGEMENT OF "cp(cp(...))"
	
	
	
	dcl sortPreComparisonPart: 4 int , K
	def sortPreComparisonPart:=
		// PHASE 1: extract values from the array into a comfortable place (i.e., outside the array)
						// a[1..K] 0 0 0 ii
		id{K+2}|inc{1}(K+1)|id	// a[1..K] 0 0 K+1 ii
		;/{K+3}/		//a[ii,2,..,ii-1,1,ii+1,..K] 0 0 K+1 ii
		;/{K+2}/|id //a["0",2,..,ii-1,1,ii+1,..K] a[ii] 0 K+1 ii
		;/{K+3}/ //a[1,2,..,ii-1,"0",ii+1,..K] a[ii] 0 K+1 ii
		;id{K+2}|inc{2}(1) //a[1,2,..,ii-1,"0",ii+1,..K] a[ii] 0 K+2 ii+1
		;/{K+3}/ //a[ii+1,2,..,ii-1,"0",1,ii+2,..K] a[ii] 0 K+2 ii+1
		;/{K+2}/|id //a["0",2,..,ii-1,"0",1,ii+2,..K] a[ii] a[ii+1] K+2 ii+1
		;/{K+3}/ //a[1,2,..,ii-1,"0","0",ii+1,..K] a[ii] a[ii+1] K+2 ii+1
		

	dcl sortGrowing : 11 int , K
	def sortGrowing := //x and y are useless values  // a[1;K] x:=0 y:=0 0 0 0 0 0 g:=(0) 0 0 0
		id{K+9} | inc | inc{1}(K-1)				// a[1;K] x:=0 y:=0 0 0 0 0 0 g:=(0) 0 K-1 K-1
		;it[	//for rep = k-1; rep > 0; rep--) {
			it[ //for i = 1; i < rep; i-- { ... "ii" is a usable copy of "i"
													// a[1..K] 0 0 0 0 0 0 0 g ii(start:=0)
				id{K+8}|inc// indexes are 1-based
				;id{K+3}|/6 5 3 4 1 2/		// a[1..K] 0 0 0 ii g 0 0 0 0
				;sortPreComparisonPart{K}|id{5}
							//a[1,2,..,ii-1,"0","0",ii+1,..K] a[ii] a[ii+1] K+2 ii+1 g 0 0 0 0
				
				;id{K}|/6 7 8 1 2 3 4 5 9/			 // a[..] 0 0 0 a[ii] a[ii+1] K+2 ii+1 g 0
				;id{K}|more|id{4}					 // a[..] M 0 0 a[ii] a[ii+1] K+2 ii+1 g 0
				;id{K}|/4 5 1 6 7 8 2 3 9/			 // a[..] a[ii] a[ii+1] M K+2 ii+1 g 0 0 0
				;id{K}| if[/2 1/,id|id,id|id] |id{6} // a[..] a[sor ; ted]  M K+2 ii+1 g 0 0 0
				;id{K+2}|/2 3 4 1 5 6 7/			 // a[..] a[sor ; ted]  K+2 ii+1 g M 0 0 0
				
				// THE INVERSE AFTER THE CHECKPOINT (so that the registers will not be messup by the incompleteness
				;inv[
				sortPreComparisonPart{K}
//				;id{K}|/6 7 8 1 2 3 4 5 9/			 // a[..] 0 0 0 a[ii] a[ii+1] K+2 ii+1 g 0
//				;id{K}|more|id{4}					 // a[..] M 0 0 a[ii] a[ii+1] K+2 ii+1 g 0
//				;id{K}|/4 5 1 6 7 8 2 3 9/			 // a[..] a[ii] a[ii+1] M K+2 ii+1 g 0 0 0
//				;id{K}| if[/2 1/,id|id,id|id] |id{6} // a[..] a[sor ; ted]  M K+2 ii+1 g 0 0 0
//				;id{K+2}|/2 3 4 1 5 6 7/			 // a[..] a[sor ; ted]  M K+2 ii+1 g 0 0 0
				
				]|inv[cu]							// a[1..K] 0 0 0 ii cp(g,M) 0 0 0 0
				
				
				//.. at the end, clean up the registers AND increase the index conter
//				;id{K+8}|inc
			]
										// a[1..K] 0 0 0 ii cp(..cp(cp(g,M'),M''),..) 0 0 0 0 i
			;id{K+3} | /5 6 3 4 2 1 7/	// a[1..K] 0 0 0 0 0 0 0 cp(..cp(cp(g,M'),M''),..) ii i
			;id{K+8} | for[dec] // restores "ii" to 0
			;id{K+9} | inc // i++
		]
		;id{K+9}|(dec|id;dec{2}(K-1))//last cleanup
	
}