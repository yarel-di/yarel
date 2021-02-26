module Sorting{
	
//	dcl sort : 10 + K int // a[1 .. K] K 0 0 0 0 0 0 g 0 0
//	def sort :=
//		... preparazione ...
//		// a[1 .. K] K-1 0 0 0 0 0 g K-1 K-1 K
//		for[//a[1;K] i_t 0 0 0 0 0 g i_t  i  K
//			for[
//				if[
//					( // NOTE: arity( /{N}/ ) = N+1
//						pop
//						// a[1..K] i_t
//						swap to prepare to less, like: // .. FIRST number
//							;/{K}/|id.... // bring to a[0] the a[i]
//						//a[i_t] a[2] .. a[k-1] a[1] i_t 0 0 0 0 0 0 g
//							;swap{K+3}(1, K+3)| id...
//						//0 a[2] .. a[k-1] a[1] i_t 0 a[i_t] 0 0 0 g
//							;id{k+1}|for[inc]|id.. // copy
//						//0 a[2] .. a[k-1] a[1] i_t a[i_t] a[i_t] 0 0 0 g
//							;swap{K+2}(1, K+2)|/2 1 /|id..
//						//a[i_t] a[2] .. a[k-1] a[1] i_t 0 0 a[i_t] 0 0 g
//							;/{K}/|id.... // bring back
//						// a[1..K] i_t 0 0 a[i_t] 0 0 g
//							;id{K}|inc|id... // i_t++ adjacent index -> SECOND NUMBER
//							;/{K}/|id.... // bring to a[0] the a[i]
//						//a[i_t+1] a[2] .. a[k-1] a[1] i_t+1 0 0 a[i_t] 0 0 g
//							;swap{K+3}(1, K+3)| id...
//						//0 a[2] .. a[k-1] a[1] i_t+1 0 a[i_t+1] a[i_t] 0 0 g
//							;id{k+1}|for[inc]|id.. // copy
//						//0 a[2] .. a[k-1] a[1] i_t+1 a[i_t+1] a[i_t+1] a[i_t] 0 0 g
//							;swap{K+2}(1, K+2)|/2 1 /|id..
//						//a[i_t+1] a[2] .. a[k-1] a[1] i_t+1 0 a[i_t] a[i_t+1] 0 0 g
//							;/{K}/|/2 3 1/|id.... // bring back and swap the pair
//						// a[1..K] i_t+1 a[i_t] a[i_t+1] 0 0 0 g
//						less // that is .... ->
//							;id{k+1}|less|id
//						if less then swap
//						green & yellow block
//						push
//						arrangement
//					)
//					, id{6+K} // useless: K == 1
//					, id{6+K} // impossible: (K <= 0) == error 
//				]
//				;id{K}|dec|id{6}|dec
//			]
//			// a[1..k] 0 0 0 0 0 0 g 0 i K
//			;id{K+8}|dec|K // i--
//			;for[ id{K}| inc | id{6}| inc ]
//			// a[1..k] i-1 0 0 0 0 0 g i-1 i-1 K
//		]
	
}