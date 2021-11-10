package arithNat;
import java.math.BigInteger;
import yarelcore.*;	

public class QuoN implements RPP {
	public QuoN() { }
	
	
	public InvQuoN getInverse(){
		return new InvQuoN();
	}
	
	private final RPP[] __steps__ = new RPP[]{ //
		new RPP() { // BodyPermImpl // index: 0
			private final int __a__ = 5;
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // ParCompImpl // index: 1
			private RPP __f__ = new RPP(){
				RPP __function__ = new SumN();
				public int getA() { return __function__.getA(); }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
			public int getA() { return 5; }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 0,
					__startIndex__ + (0) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 2
			private final int __a__ = 5;
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __x__[__startIndex__ + 4]; 
				__x__[__startIndex__ + 4] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // BodyItImpl // index: 3
			// Iteration start
			RPP __function__ = new RPP() { // BodyFunImpl
				RPP __function__ = new DisStepN();
				public int getA() { return __function__.getA(); }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
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