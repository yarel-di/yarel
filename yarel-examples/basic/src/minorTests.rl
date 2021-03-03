
module minorTests {
	
	dcl negSRL : 2 int
	def negSRL :=
		// < n, a >
		for[inc] //n+a,  a
		;/2 1/   // a ,n+a
		;for[dec]// -n,n+a
		;/2 1/   //n+a, -n
		;for[inc]// a , -n
		;/2 1/   // -n,  a
}