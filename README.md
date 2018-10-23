# YAREL

**YAREL** is a paradigmatic first-order functional programming language.

Its stands for **Y**(et)**A**(nother)**RE**(versible)**L**(language), i.e. if P is a program in YAREL, then the inverse of P exists for free in YAREL.

YAREL is an experimental implementation of the class Reversible Primitive Permutations (RPP) of which a preliminary version can be found [here](http://www.di.unito.it/~paolini/papers/2017rpp.pdf).

For example, a program of YAREL is:
```
module multiplication {
    dec main : Int, // value x
               Int, // value y
               Int  // result

    def main := /1 3 2/ . it[/2 1/ . it[inc] . /2 1/] . /1 3 2/
}
```

It defines the function main that takes three arguments of type integer and yields three integers as its result.

For example:
```
main 5 4 0 // evaluates to the tuple 5 4 0+(5*4)
main 3 4 0 // evaluates to the tuple 3 4 0+(3*4)
```
I.e., in general, if x and y are nonnegative integer numbers, then:
```
main x y z // evaluates to the tuple x y z+(x*y)
```
The point is that inside the module multiplication the inverse inv_main of main exists for free without explicitly defining it.

The behavior of inv_main is the one we may expect:
```
inv_main 5 4 20 // evaluates to 5 4 0
inv_main 3 4 12 // evaluates to 3 4 0
```
I.e., in general:
```
inv_main x y z+(x*y) // evaluates to x y z
```
which means that the sequential compositions\
(main . inv_main) or (inv_main . main)

are equivalent to the identity. This equivalence keeps holding with any value supplied for x, y and z, negative ones included.

YAREL inherits the main properties of RPP:

-   is complete with respect to the class of Primitive Recursive Functions;
-   allows the programming of functions with type Z^n → Z^n only.

The details about how experimenting YAREL will be subject of a user manual under construction.
