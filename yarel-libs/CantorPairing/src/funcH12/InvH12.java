package funcH12;
import java.math.BigInteger;
import yarelcore.*;	

public class InvH12 implements RPP {
	public InvH12() { }
	
	
	public H12 getInverse(){
		return new H12();
	}
	
	private final RPP[] __steps__ = new RPP[]{ //
		new RPP() { // BodyPermImpl // index: 0
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __tmp__; 
			}
			public int getA() { return 3; }
		},
		
		new RPP() { // BodyFunImpl // index: 1
			RPP __function__ = new InvT3sub();
			public int getA() { return __function__.getA(); }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		},
		
		new RPP() { // ParCompImpl // index: 2
			private RPP __f__ = new RPP(){
				RPP __function__ = new Dup_2();
				public int getA() { return __function__.getA(); }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
			public int getA() { return 3; }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 0,
					__startIndex__ + (0) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 3
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __tmp__; 
			}
			public int getA() { return 3; }
		}
	};
	public int getA() { return this.__steps__[0].getA(); }
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
		int __i__;
		__i__ = __steps__.length;
		while( __i__-->0 ){
			__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
		}
	}
}