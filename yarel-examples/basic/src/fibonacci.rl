module Fibonacci {
	dcl fib : 3 int // n 0 0
	def fib :=  // returns; n, fib(n), [ n>0 ? fib(n-1) : 0]
		/3 2 1/
		; inc|id|id // 1 0 n
		;it[
			for[inc]
			; /2 1/
		] // fib(n-1) fib(n) n
		;if[ id|id, // do nothing
			dec|id, // n == 0
			id|id   // impossible
		]
		;/3 2 1/


	dcl fibonacci : 4 int // n 0 0 0
	def fibonacci :=   // n fib(n) 0 0
		fib|id         // n fib(n) fib(n-1) 0
		;/1 3 4 2/     // n fib(n-1) 0 fib(n)
		;id|id|it[inc] // n fib(n-1) fib(n) fib(n)
		;inv[/1 3 4 2/]// n fib(n) fib(n-1) fib(n)
		;inv[fib]|id   // n 0 0 fib(n)
		;/1 4 2 3/     // n fib(n) 0 0
}