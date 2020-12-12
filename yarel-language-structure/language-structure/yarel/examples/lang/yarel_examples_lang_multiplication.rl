/**
 * Defines a multiplication on natural numbers and checks the
 * existence of the inverse inv[multiplication] of the multiplication.
 */
module yarel_examples_lang_multiplication {
	
	///// multiplication
	dcl permutation: 3 int
	/*  v3 --> v1
	 *  v1 --> v2
	 *  v2 --> v3
	 */
	def permutation := /3 1 2/
	
	dcl multiplication : 3 int 
	/* in : v, u, a
	 * out: v, u, a + v*u
	 * Correctly works on natural numbers only.
	 * It yields v*u if and only if a is 0.
	 */
	def multiplication := permutation;it[it[inc]];inv[permutation]
	
	dcl identity: 3 int
	/* Just checking that the inverse of the multiplication exists. */
	def identity := multiplication;inv[multiplication]
}