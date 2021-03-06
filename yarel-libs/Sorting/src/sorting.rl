import YarelLib.*
import CantorPairing.*
import IntegerCompare.*

module Sorting{
	
	dcl sortGrowing : 11 int , K
	def sortGrowing := //x and y are useless values  // a[1;K] x y 0 0 0 0 0 0 g:=(0) 0 0
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
					;/{K+3}/    //a[ii+1,2,..,a_t-1,x, 1,ii+2,..K] a[ii] y K+2 ii+1 ...
					;/{K+2}/|id //a[y,2,..,a_t-1,x, 1,ii+2,..K] a[ii] a[ii+1] K+2 ii+1 ...
					;/{K+3}/    //a[1,2,..,a_t-1,x, y,ii+2,..K] a[ii] a[ii+1] K+2 ii+1 ...
					//;id{K+2}|id|id
							    //a[1,2,..,a_t-1,x, y,ii+2,..K] a[ii] a[ii+1] K+2 ii+1 ...
				) | id{5}         //a[1,2,..,a_t-1,x, y,ii+2,..K] a[ii] a[ii+1] K+2 ii+1 pop(g) ? 0 0 0
				/*should be "cu" instead of id{5}? if not, then the "?" register is 0 and "pop(g)" is "g"
				 * I'll use "gg" and "(0)" just to not confuse them with weird values or other zeros
				*/
												//a[1..K] a[ii] a[ii+1] K+2 ii+1 pop(g) ? 0 0 0
				;id{K} | /1 2 7 8 9 3 4 5 6/     // a[..] a[ii] a[ii+1] 0 0 0 K+2 ii+1 gg (0)
				;id{K} | more | id{4}            // a[..] a[ii] a[ii+1] M 0 0 K+2 ii+1 gg (0)
				//L == 1 <-> inverted order (so, requires a sorting)
				;id{K} | if[ /2 1/, id|id, id|id ] | id{6} // a[..] a[sor,ted] M 0 0 K+2 ii+1 gg (0)
				;/{K+5}/| id{3} //a[ted,2,..,a_t-1,x, y,ii+2,..K] a[sor] a[1] M 0 0 K+2 ii+1 gg (0)
				;/{K+6+0}/| id{2} //a[y,2,..,a_t-1,x, ted,ii+2,..K] a[sor] a[1] M 0 0 K+2 ii+1 gg (0)
				;/{K+5}/| id{3} //a[1,2,..,a_t-1,x, ted,ii+2,..K] a[sor] y M 0 0 K+2 ii+1 gg (0)
				;id{K+5}|dec|dec|id|id // K+2 -> K+1 ; ii+1 -> ii
				;/{K+5}/| id{3} //a[sor,2,..,a_t-1,x, ted,ii+2,..K] a[1] y M 0 0 K+1 ii gg (0) BUGGGGGGGGGGGGGGGGGGG
				;/{K+6}/| id{2} //a[x,2,..,a_t-1,sor, ted,ii+2,..K] a[1] y M 0 0 K+1 ii gg (0)
				;/{K+5}/| id{3} //a[1,2,..,a_t-1,sor, ted,ii+2,..K] x y M 0 0 K+1 ii gg (0)
				;id{K} | /1 2 6 7 8 3 9 4 5/                // a[..] x y K+1 ii gg M (0) 0 0
				; (
					id{K+2} | dec{1}(K+1) | dec
				) |inv[cu]
				// a[..] x y 0 ii-1 cp(gg,M) 0 (0) 0 0
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
	
}