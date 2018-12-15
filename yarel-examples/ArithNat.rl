/**
 * Basic arithmetic functions.
 * This module contains sum, sub(traction), mul(tiplication), quo(tient).
 * The overall assumption is that every function expects natural numbers as its inputs. 
 */
module ArithNat { 

	//////// sum	
	dcl sum : 2 int
	/* in : x    , y both equal or greater than 0
	 * out: x + y, y
     * Iterates inc as many times as y, starting from x.
	 */
	def sum := it[inc]

	//////// subtraction	
	dcl sub : 2 int
	/* in : x    , y
	 * out: x - y, y
	 * Eventually, iterates dec on x as many times as y.
	 * Behavior achieved by inverting sum, i.e. by iterating the inverse of inc.
	 */
	def sub := inv[sum]
	
	//////// multiplication	
	dcl mul : 3 int
	/* in : x        , y, a
	 * out: a+x+...+x, x, y where x+...+x has y occurrences of x
	 * Iterates sum as many times as y, using the value of the 
	 * ancilla a as a starting point.
	 */
	def mul := /3 1 2/;it[sum] 
	
	//////// quotient
	dcl disSel: 3 int
	/* in : q(otient) , n(egative)o(verflow)c(ounter), r(eminder)
	 * out: q(otient)', noc'                         , r'
	 * disSel stands for 'distribution selection'.
	 * It is the selection tree that decides which between q and noc
	 * to leave unchanged, depending on the value of the reminder.
	 */
	def disSel := if[if[id  //// q   if noc > 0 (impossible)
	  	               ,id  //// q   if noc = 0
	  	               ,id  //// q   if noc < 0 (impossible)
	                   ];(id|id)   // q, noc   if r-d > 0
	  	            ,if[id  //// q   if noc > 0 (impossible)
	  	               ,id  //// q   if noc = 0
	  	               ,id  //// q   if noc < 0 (impossible)
	  	               ];(id|inc)  // q, noc+1 if r-d = 0
	  	            ,if[dec //// q-1 if noc > 0 
	  	               ,dec //// q-1 if noc = 0
	  	               ,id  //// q   if noc < 0 (impossible)
	  	               ];(id|inc)  // q, noc+1 if r-d < 0
	                ]
	        	
	dcl disStep : 4 int 
	/* in : r(eminder) , d(ivisor) , q(otient) , n(egative)o(verflow)c(ounter)
	 * out: r(eminder)', d(ivisor)', q(otient)', noc'
	 * disStep stands for 'distribution step'.
	 * disStep is part of the definition of quo(tient).
	 * disStep takes d elements from what remains to be distributed in r and 
	 * counts a new distribution round in q, when possible. 
	 * The distribution is forbidden by positive values of noc which counts 
	 * the attempts to distribute more that what remains in r.
	 * The value of noc becomes positive as soon as the difference r-d becomes negative.
	 */
 	def disStep :=  (sub |inc |id )
	               ;/2 3 4 1/
	               ;(id|disSel)
	               ;/4 1 2 3/
  
	dcl quo : 5 int
	/* in : D(ividend) , d(ivisor), q(otient) , i(teration unfolder), n(egative)o(verflow)c(ounter)
	 * out: r'         , d        , q'        , i                   , noc' 
     * Gives the quotient of D/d. 
	 */
	def quo :=  /4 1 2 3 5/ 
	           ;(sum|id|id|id) 
	           ;/2 3 4 5 1/
	           ;it[disStep]
}









