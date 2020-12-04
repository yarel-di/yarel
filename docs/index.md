## YAREL

### An intuition

**YAREL** is a paradigmatic first-order functional programming language.

It stands for **Y**(et)**A**(nother)**RE**(versible)**L**(language), i.e. if ```P``` is a program in YAREL, then the inverse ```inv[P]``` of ```P``` exists for free in YAREL.

YAREL is an experimental implementation of the class **RPP** of Reversible Primitive Permutations.
The work ["A class of Recursive Permutations which is Primitive Recursive complete"](https://www.sciencedirect.com/science/article/abs/pii/S0304397519307558) (["Preliminary version"](http://www.di.unito.it/~rover/RESEARCH/PUBLICATIONS/2020-TCS-RPP/2017RPPFinalAutors.pdf)) introduces RPP.


An example of a YAREL module is:
```Java
/**
 * Defines a multiplication on natural numbers and checks the
 * existence of the inverse inv[multiplication] of the multiplication.
 */
module Multiplication {
	
	///// multiplication
	dcl permutation: 3 int
	def permutation := //t u v
	                   /3 1 2/ 
	                   //v t u
	
	dcl multiplication : 3 int 
	/* Works on natural numbers only.
	 * Yields v*u if and only if a is 0. */
	def multiplication := // v u a
	                      permutation;it[it[inc]];inv[permutation]
			      // v u a+v*u
	
	dcl identity: 3 int
	/* The inverse of the multiplication exists. */
	def identity := multiplication;inv[multiplication]
}
```
It declares that the permutation we are going to define takes three integers its input. To ease the presentation we assume to use natural numbers only.
The definition of the permutation says that the third input becomes the first output, the first input becomes the second output and the second input becomes 
the third output.

For example:
```Java
permutation 5 4 0 // yields the tuple 0 5 4
```

Also the multiplication is declared as a function with three inputs.

For example:
```Java
multiplication 5 4 0 // yields the tuple 5 4 0+(5*4)
```
In general, if v and u are natural numbers, then:
```Java
multiplication v u a // yields the tuple v u a+(v*u)
```
The point is that inside the module ```Multiplication``` the inverse ```inv[multiplication]``` of ```multiplication``` exists for free without explicitly defining it.

The behavior of ```inv[multiplication]``` is the one we may expect:
```Java
inv[multiplication] 5 4 20 // yields the tuple 5 4 0
```
In general:
```Java
inv[multiplication] v u a+(v*u) // yields the tuple v u a
```
which means that the sequential compositions
```Java
multiplication;inv[multiplication]
``` 
or 
```Java
inv[muliplication];multiplication
```
are equivalent to the identity.

YAREL inherits the main properties of RPP:

-   it is complete with respect to the class of Primitive Recursive Functions;
-   it allows to program functions with type Z<sup>n</sup> → Z<sup>n</sup> only.

### Documentation
Still under development in the [Wiki section about YAREL](https://github.com/yarel-di/yarel/wiki).

### News
- [2020] A short video on the possible contibution that reversible programming languages may have to improve the green-footrpint of computers (in Italian) [Green UniTo VIDEO](https://www.facebook.com/UniToGO/videos/123160272789622/?t=71).
