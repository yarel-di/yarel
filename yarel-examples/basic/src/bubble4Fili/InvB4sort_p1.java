package bubble4Fili;
import java.math.BigInteger;
import yarelcore.*;	

public class InvB4sort_p1 implements RPP {
	public InvB4sort_p1() { }
	
	
	public B4sort_p1 getInverse(){
		return new B4sort_p1();
	}
	
	private final RPP[] __steps__ = new RPP[]{ //
		new RPP() { // ParCompImpl // index: 0
			private RPP __f__ = new RPP(){
				RPP __function__ = new cantorPairing.InvCu();
				public int getA() { return __function__.getA(); }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
			public int getA() { return 10; }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 4,
					__startIndex__ + (4) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 1
			private final int __a__ = 10;
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 5]; 
				__x__[__startIndex__ + 5] = __x__[__startIndex__ + 7]; 
				__x__[__startIndex__ + 7] = __tmp__; 
				__tmp__ = __x__[__startIndex__ + 6]; 
				__x__[__startIndex__ + 6] = __x__[__startIndex__ + 8]; 
				__x__[__startIndex__ + 8] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // BodyPermImpl // index: 2
			private final int __a__ = 10;
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 6]; 
				__x__[__startIndex__ + 6] = __x__[__startIndex__ + 4]; 
				__x__[__startIndex__ + 4] = __tmp__; 
				__tmp__ = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __x__[__startIndex__ + 5]; 
				__x__[__startIndex__ + 5] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // ParCompImpl // index: 3
			private RPP __f__ = new RPP(){
				RPP __function__ = new integerCompare.InvMore();
				public int getA() { return __function__.getA(); }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
			public int getA() { return 10; }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 2,
					__startIndex__ + (2) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 4
			private final int __a__ = 10;
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 4]; 
				__x__[__startIndex__ + 4] = __x__[__startIndex__ + 6]; 
				__x__[__startIndex__ + 6] = __tmp__; 
				__tmp__ = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __x__[__startIndex__ + 5]; 
				__x__[__startIndex__ + 5] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // ParCompImpl // index: 5
			private RPP __f__ = new RPP(){
				RPP __pos__=new RPP() {
					private final int __a__ = 4;
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						BigInteger __tmp__ = BigInteger.ZERO;
						__tmp__ = __x__[__startIndex__ + 2]; 
						__x__[__startIndex__ + 2] = __x__[__startIndex__ + 3]; 
						__x__[__startIndex__ + 3] = __tmp__; 
					}
					public int getA() { return this.__a__; }
				};
				RPP __zero__=new RPP() {
					public int getA() { return 4; }
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						// There were only parallels identities, nothing interesting to show and run
					}
				};
				RPP __neg__=new RPP() {
					public int getA() { return 4; }
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						// There were only parallels identities, nothing interesting to show and run
					}
				};
				public int getA() { return this.__pos__.getA()+1; }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					final int __testPositivity__ = __x__[(__startIndex__ + this.getA()) - 1].compareTo(BigInteger.ZERO);
					if(__testPositivity__ > 0){
						__pos__.b(__x__, __startIndex__, __startIndex__ + __pos__.getA());
					} else if(__testPositivity__ == 0){
						__zero__.b(__x__, __startIndex__, __startIndex__ + __zero__.getA());
					} else { // The "__testPositivity__ < 0" test is a tautology
						__neg__.b(__x__, __startIndex__, __startIndex__ + __neg__.getA());
					}
				}
			};
			public int getA() { return 10; }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 0,
					__startIndex__ + (0) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 6
			private final int __a__ = 10;
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __tmp__; 
				__tmp__ = __x__[__startIndex__ + 4]; 
				__x__[__startIndex__ + 4] = __x__[__startIndex__ + 7]; 
				__x__[__startIndex__ + 7] = __tmp__; 
				__tmp__ = __x__[__startIndex__ + 8]; 
				__x__[__startIndex__ + 8] = __x__[__startIndex__ + 9]; 
				__x__[__startIndex__ + 9] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // BodyPermImpl // index: 7
			private final int __a__ = 10;
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 5]; 
				__x__[__startIndex__ + 5] = __x__[__startIndex__ + 8]; 
				__x__[__startIndex__ + 8] = __x__[__startIndex__ + 6]; 
				__x__[__startIndex__ + 6] = __x__[__startIndex__ + 9]; 
				__x__[__startIndex__ + 9] = __x__[__startIndex__ + 7]; 
				__x__[__startIndex__ + 7] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // ParCompImpl // index: 8
			private RPP __f__ = new RPP(){
				RPP __function__ = new cantorPairing.Cu();
				public int getA() { return __function__.getA(); }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
			public int getA() { return 10; }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 5,
					__startIndex__ + (5) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 9
			private final int __a__ = 10;
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 5]; 
				__x__[__startIndex__ + 5] = __x__[__startIndex__ + 9]; 
				__x__[__startIndex__ + 9] = __x__[__startIndex__ + 8]; 
				__x__[__startIndex__ + 8] = __x__[__startIndex__ + 7]; 
				__x__[__startIndex__ + 7] = __x__[__startIndex__ + 6]; 
				__x__[__startIndex__ + 6] = __tmp__; 
			}
			public int getA() { return this.__a__; }
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