/**
 * Basic arithmetic functions.
 * This module contains sum, sub(traction), mul(tiplication), quo(tient)
 * that take any integer value as their arguments. 
 */
import yarel_lang_arithmetics_nat.*
module yarel_lang_arithmetics_int {
	
   /** in : a, 0, 0
	 *  out: a, a, 0
	 *  Duplicates the first argument, given two ancillae intialized
	 *  to the value 0. The first ancilla assume the value a.
	 *  The second ancilla remains 0.
	 */
	dcl dup: 3 int
	def dup:= /*  a   0  0*/ /2 3 1/
	        ; /*  0   0  a*/ it[dec|inc] 
	        ; /*-|a| |a| a*/ it[inc]|id 
	        ; /*  0  |a| a*/ (id | if[/*|a|*/ id  /* |a|*/
	        	                     ,/*|a|*/ id  /* |a|*/
	                                 ,/*|a|*/ neg /*-|a|*/ 
	                                 ])
	        ; /* 0    a  a*/ /2 3 1/
              /* a    a  0*/
	
	//////// sum
	/* in : a  , b, 0, 0, 0
	 * out: a+b, a, b, 0, 0
	 */
	dcl sum : 5 int
	def sum := /*a b 0 0 0*/ /1 3 2 4 5/
	         ; /*a 0 b 0 0*/ id|id|dup
	         ; /*a 0 b b 0*/ /1 2 5 3 4/
	         ; /*a 0 0 b b*/ dup|id|id
	         ; /*a a 0 b b*/ /1 4 2 5 3/
	         ; /*a b a b 0*/
	          (/*a b a b*/
	           if[if[sumN                  ,id|id,(neg|id );yarel_lang_arithmetics_nat.sub;(neg|id )]
	             ,id|id|id                         
	             ,if[(id|neg);yarel_lang_arithmetics_nat.sub;(id|neg),id|id,(neg|neg);sumN;(neg|neg)]
                 ]
               /*a b a b*/|/*0*/id
               )
	         ; /*a+b b a b 0*/ /1 3 2 4 5/
	         ; /*a+b a b b 0*/ (id|id|inv[dup])
	           /*a+b a b 0 0*/

	//////// sub(traction)
	/* in : a  , b, 0, 0, 0
	 * out: a-b, a, b, 0, 0
	 */
	dcl sub : 5 int
	def sub := inv[sum]
}