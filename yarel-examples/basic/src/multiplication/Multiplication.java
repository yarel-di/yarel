package multiplication;
import java.math.BigInteger;
import yarelcore.*;	

public class Multiplication implements RPP {
	public Multiplication() { }
	
	
	public InvMultiplication getInverse(){
		return new InvMultiplication();
	}
	
	private final RPP[] __steps__ = new RPP[]{ //
		new RPP() { // BodyFunImpl // index: 0
			RPP __function__ = new Permutation();
			public int getA() { return __function__.getA(); }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		},
		
		new RPP() { // BodyItImpl // index: 1
			// Iteration start
			RPP __function__ = new RPP() { // BodyItImpl
				// Iteration start
				RPP __function__ = new RPP() { // BodyIncImpl
					private RPP __f__ = Inc.SINGLETON_Inc;
					private final int __a__ = __f__.getA();
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return this.__a__; }
				};
				public int getA() { return __function__.getA()+1; }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					int __endIndexBody__ = (__startIndex__ + this.getA()) - 1;
					BigInteger __iterationsLeft__ = __x__[__endIndexBody__].abs();
					while(__iterationsLeft__.compareTo(BigInteger.ZERO) > 0){
						__function__.b(__x__, __startIndex__, __endIndexBody__);
						__iterationsLeft__ = __iterationsLeft__.subtract(BigInteger.ONE);
					}
				}
				// Iteration stop
			};
			public int getA() { return __function__.getA()+1; }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				int __endIndexBody__ = (__startIndex__ + this.getA()) - 1;
				BigInteger __iterationsLeft__ = __x__[__endIndexBody__].abs();
				while(__iterationsLeft__.compareTo(BigInteger.ZERO) > 0){
					__function__.b(__x__, __startIndex__, __endIndexBody__);
					__iterationsLeft__ = __iterationsLeft__.subtract(BigInteger.ONE);
				}
			}
			// Iteration stop
		},
		
		new RPP() { // BodyInvImpl // index: 2
			RPP __function__ = new InvPermutation();
			public int getA() { return __function__.getA(); }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		}
	};
	public int getA() { return this.__steps__[0].getA(); }
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
		int __i__;
		__i__ = -1;
		while( ++__i__ < __steps__.length ){
			__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
		}
	}
}