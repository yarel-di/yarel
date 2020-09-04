/* Legenda
 *    n >= 0 
 *     e = 1
 *     o = 0 
 * nhalf = 0 */
module yarel_lang_recursion_halve {
	
	dcl Step : 3 int
	def Step :=
	  /* e o nhalf  */   
	   /1 3 2/ 
	  /* e nhalf o  */   
	  ; id|it[inc]
	  /* e nhalf+o o*/ 
	  ;inv[/1 3 2/] 
	  /* e o nhalf+o*/ 
	  ;/2 1 3/ 
	  /* o e nhalf+o*/ 

    dcl Halve : 4 int
    /* n = 2*nhalf+o && 0<=o<=1 && (n odd <==> o=1) */

	def Halve :=
	  /*n e o nhalf  */ 
	   /2 3 4 1/ 
	  /*e o nhalf n*/ 
	 ;it[Step]
	 ;inv[/2 3 4 1/]
	  /*n e o nhalf s.t. n=2*nhalf+o */
}