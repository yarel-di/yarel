package arithNat;
import java.math.BigInteger;
import yarelcore.*;	

public class InvDisSelN implements RPP {
	public InvDisSelN() { }
	
	
	public DisSelN getInverse(){
		return new DisSelN();
	}
	
	RPP __pos__=new RPP() {
		private final RPP[] __steps__ = new RPP[]{ //
			new RPP() { // BodyIfImpl // index: 0
				RPP __pos__=new RPP() {
					private RPP __f__ = InvId.SINGLETON_InvId;
					public int getA() { return __f__.getA(); }
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
				};
				RPP __zero__=new RPP() {
					private RPP __f__ = InvId.SINGLETON_InvId;
					public int getA() { return __f__.getA(); }
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
				};
				RPP __neg__=new RPP() {
					private RPP __f__ = InvId.SINGLETON_InvId;
					public int getA() { return __f__.getA(); }
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
				};
				private int __a__ = this.__pos__.getA()+1;
				public int getA() { return this.__a__; }
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
			},
			
			new RPP() { // ParCompImpl // index: 1
				public int getA() { return 2; }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					// There were only parallels identities, nothing interesting to show and run
				}
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
	};
	RPP __zero__=new RPP() {
		private final RPP[] __steps__ = new RPP[]{ //
			new RPP() { // BodyIfImpl // index: 0
				RPP __pos__=new RPP() {
					private RPP __f__ = InvId.SINGLETON_InvId;
					public int getA() { return __f__.getA(); }
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
				};
				RPP __zero__=new RPP() {
					private RPP __f__ = InvId.SINGLETON_InvId;
					public int getA() { return __f__.getA(); }
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
				};
				RPP __neg__=new RPP() {
					private RPP __f__ = InvId.SINGLETON_InvId;
					public int getA() { return __f__.getA(); }
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
				};
				private int __a__ = this.__pos__.getA()+1;
				public int getA() { return this.__a__; }
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
			},
			
			new RPP() { // ParCompImpl // index: 1
				private RPP __f__ = new RPP(){
					private RPP __f__ = InvInc.SINGLETON_InvInc;
					public int getA() { return this.__f__.getA(); }
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
				};
				public int getA() { return 2; }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__,
						__startIndex__ + 1,
						__startIndex__ + (1) + this.__f__.getA()
						);
				}
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
	};
	RPP __neg__=new RPP() {
		private final RPP[] __steps__ = new RPP[]{ //
			new RPP() { // BodyIfImpl // index: 0
				RPP __pos__=new RPP() {
					private RPP __f__ = InvDec.SINGLETON_InvDec;
					public int getA() { return this.__f__.getA(); }
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
				};
				RPP __zero__=new RPP() {
					private RPP __f__ = InvDec.SINGLETON_InvDec;
					public int getA() { return this.__f__.getA(); }
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
				};
				RPP __neg__=new RPP() {
					private RPP __f__ = InvId.SINGLETON_InvId;
					public int getA() { return __f__.getA(); }
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
				};
				private int __a__ = this.__pos__.getA()+1;
				public int getA() { return this.__a__; }
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
			},
			
			new RPP() { // ParCompImpl // index: 1
				private RPP __f__ = new RPP(){
					private RPP __f__ = InvInc.SINGLETON_InvInc;
					public int getA() { return this.__f__.getA(); }
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
				};
				public int getA() { return 2; }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__,
						__startIndex__ + 1,
						__startIndex__ + (1) + this.__f__.getA()
						);
				}
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
	};
	private int __a__ = this.__pos__.getA()+1;
	public int getA() { return this.__a__; }
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
}