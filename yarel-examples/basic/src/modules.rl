module modules {
	import compound.*
	
	dcl g : int
	def g := id
	
	dcl permutation : 4 int
	def permutation :=
	                 /* x   y   w   z */
	  parComposition /* x+y y   w-z z */
	; /1 3 2 4/      /* x+y w-z y   z */
}