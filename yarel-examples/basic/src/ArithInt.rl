/**
 * Basic arithmetic functions.
 * This module contains sum, sub(traction), mul(tiplication), quo(tient)
 * that take any integer value as their arguments. 
 */
import util.*
import arithNat.*
module arithInt {
	//////// sum
	/* in : a  , b, 0, 0, 0
	 * out: a+b, a, b, 0, 0
	 */
	dcl sum {5 int}
	def sum := /*a b 0 0 0*/ /1 3 2 4 5/
	         ; /*a 0 b 0 0*/ id|id|dup
	         ; /*a 0 b b 0*/ /1 2 5 3 4/
	         ; /*a 0 0 b b*/ dup|id|id
	         ; /*a a 0 b b*/ /1 4 2 5 3/
	         ; /*a b a b 0*/
	          (/*a b a b*/
	           if[if[sumN                  ,id|id,(neg|id );subN;(neg|id )]
	             ,id|id|id                         
	             ,if[(id|neg);subN;(id|neg),id|id,(neg|neg);sumN;(neg|neg)]
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
	dcl sub {5 int}
	def sub := inv[sum]
}