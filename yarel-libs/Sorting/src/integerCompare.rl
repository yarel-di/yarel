module IntegerCompare{
/*
	dcl sameSignPosLess : 3 int
	def sameSignPosLess := // k:=0 i j -----> k := 1 <-> j > i
		id | for[dec] // 0 i-j j 
		;/1 3 2/ // 0 j i-j
		;if[
			id|id, // j < i
			id|id, // j == i
			inc|id // j > i
		]
		;/1 3 2/ // ? i-j j 
		;id | for[inc] // ? i j 
	
	dcl sameSignNegLess : 3 int
	def sameSignNegLess := // k:=0 -|i| -|j| -----> k := 1 <-> j > i
		id | it[inc] // 0 -|i|+|j| -|j|  ... it[inc] === for[dec] if the repetition counter is negative
		;/1 3 2/ // 0 -|j| -|i|+|j| 
		;if[
			id|id, // -|i|+|j| > 0 --> -|i| > -|j|
			id|id, // j == i
			inc|id // -|i|+|j| < 0 --> -|i| < -|j|
		]
		;/1 3 2/ // 0 -|i|+|j| -|j| 
		;id | it[dec] // ? i j 
	*/

	// clearly, they are the same
	
	
	dcl sameSignLess {3 int}
	def sameSignLess :=  // k i j .... k == 1 <-> j > i
		id | for[dec] // k (i-j) j
		;/1 3 2/ // k j (i-j)
		;if[ (id|id), (id|id), (inc|id) ]
		;/1 3 2/ // k (i-j) j
		;id | for[inc]  // k i j
	
	dcl sameSignMore {3 int}
	def sameSignMore :=  // k i j .... k == 1 <-> j < i
		id | for[dec] // k (i-j) j
		;/1 3 2/ // k j (i-j)
		;if[ (inc|id), (id|id), (id|id)] // note that the "inc" is now on positive branch
		;/1 3 2/ // k (i-j) j
		;id | for[inc]  // k i j
	
	
	dcl dupStep {5 int}
	def dupStep:= // k 0(p) 0(q) i j
		/1 2 5 3 4/ // k 0 j 0 i
		;id | for[inc] | for[inc] // k j j i i
		;/1 5 3 4 2/              // k i j i j
	
	
	dcl less {5 int} // 0(k) 0(p) 0(q) i j .. then holds k == 1 <-> i < j
	def less :=
		dupStep // k i j i j
		;if[ //this "if" is the "F" function 
			if[sameSignLess, inc|id|id, inc|id|id],// if j > 0
			if[id|id|id, id|id|id, inc|id|id],     // if j == 0
			if[id|id|id, id|id|id, sameSignLess]   // if j < 0
		]
		;inv[dupStep]
	
	dcl more {5 int} // 0(k) 0(p) 0(q) i j .. then holds k == 1 <-> i > j
	def more:=
		dupStep // k i j i j
		;if[ //this "if" is the "F" function 
			if[sameSignMore, id|id|id, id|id|id], // if j > 0
			if[inc|id|id, id|id|id, id|id|id],    // if j == 0
			if[inc|id|id, inc|id|id, sameSignMore]// if j < 0
		]
		;inv[dupStep]

	//

	//

	dcl sameSignCompare {3 int}
	def sameSignCompare :=  // k i j .... k == 1 <-> j < i && k == 0 <-> j == i && k == -1 
		id | for[dec]
		;/1 3 2/ // k j (i-j)
		;if[ (inc|id), (id|id), (dec|id)] // note that the "inc" is now on positive branch
		;/1 3 2/
		;id | for[inc]


	dcl compare {5 int}
	def compare :=
		dupStep // k i j i j
		;if[ //this "if" is the "F" function 
			if[sameSignCompare, dec|id|id, dec|id|id],// if j > 0
			if[inc|id|id, id|id|id, dec|id|id],       // if j == 0
			if[inc|id|id, inc|id|id, sameSignCompare] // if j < 0
		]
		;inv[dupStep]

	dcl compareOverflowUnsafe {3 int}
	def compareOverflowUnsafe :=
		sameSignCompare
}