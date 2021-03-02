package arithNat;
import yarelcore.*;	

public class DisSelN implements RPP {
	public DisSelN() { }
	
	
	

	
	public InvDisSelN getInverse(){
		return new InvDisSelN();
	}
	
	RPP __pos__=new RPP() {
		private final RPP[] __steps__ = new RPP[]{
			new RPP() { // BodyIfImpl
				RPP __pos__=new RPP() {
					private RPP __f__ = Id.SINGLETON_Id;
					private final int __a__ = __f__.getA();
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return __f__.getA(); }
				};
				RPP __zero__=new RPP() {
					private RPP __f__ = Id.SINGLETON_Id;
					private final int __a__ = __f__.getA();
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return __f__.getA(); }
				};
				RPP __neg__=new RPP() {
					private RPP __f__ = Id.SINGLETON_Id;
					private final int __a__ = __f__.getA();
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return __f__.getA(); }
				};
				public int getA() { return this.__pos__.getA()+1; }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					final int __testValue__ = __x__[(__startIndex__ + this.getA()) - 1];
					if(__testValue__ > 0){
						__pos__.b(__x__, __startIndex__, __startIndex__ + __pos__.getA());
					} else if(__testValue__ == 0){
						__zero__.b(__x__, __startIndex__, __startIndex__ + __zero__.getA());
					} else { // The "__testValue__<0" test is a tautology
						__neg__.b(__x__, __startIndex__, __startIndex__ + __neg__.getA());
					}
				}
			},
			
			new RPP() { // ParCompImpl
				public int getA() { return 2; }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					// There were only parallels identities, nothing interesting to show and run
				}
			}
		};
		public int getA() { return this.__steps__[0].getA(); }
		public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
			int __i__;
			__i__ = -1;
			while( ++__i__ < __steps__.length ){
				__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
			}
		}
	};
	RPP __zero__=new RPP() {
		private final RPP[] __steps__ = new RPP[]{
			new RPP() { // BodyIfImpl
				RPP __pos__=new RPP() {
					private RPP __f__ = Id.SINGLETON_Id;
					private final int __a__ = __f__.getA();
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return __f__.getA(); }
				};
				RPP __zero__=new RPP() {
					private RPP __f__ = Id.SINGLETON_Id;
					private final int __a__ = __f__.getA();
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return __f__.getA(); }
				};
				RPP __neg__=new RPP() {
					private RPP __f__ = Id.SINGLETON_Id;
					private final int __a__ = __f__.getA();
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return __f__.getA(); }
				};
				public int getA() { return this.__pos__.getA()+1; }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					final int __testValue__ = __x__[(__startIndex__ + this.getA()) - 1];
					if(__testValue__ > 0){
						__pos__.b(__x__, __startIndex__, __startIndex__ + __pos__.getA());
					} else if(__testValue__ == 0){
						__zero__.b(__x__, __startIndex__, __startIndex__ + __zero__.getA());
					} else { // The "__testValue__<0" test is a tautology
						__neg__.b(__x__, __startIndex__, __startIndex__ + __neg__.getA());
					}
				}
			},
			
			new RPP() { // ParCompImpl
				private RPP __f__ = new RPP(){
					private RPP __f__ = Inc.SINGLETON_Inc;
					private final int __a__ = __f__.getA();
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return this.__a__; }
				};
				public int getA() { return 2; }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__,
						__startIndex__ + 1,
						__startIndex__ + (1) + (1)
						);
				}
			}
		};
		public int getA() { return this.__steps__[0].getA(); }
		public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
			int __i__;
			__i__ = -1;
			while( ++__i__ < __steps__.length ){
				__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
			}
		}
	};
	RPP __neg__=new RPP() {
		private final RPP[] __steps__ = new RPP[]{
			new RPP() { // BodyIfImpl
				RPP __pos__=new RPP() {
					private RPP __f__ = Dec.SINGLETON_Dec;
					private final int __a__ = __f__.getA();
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return this.__a__; }
				};
				RPP __zero__=new RPP() {
					private RPP __f__ = Dec.SINGLETON_Dec;
					private final int __a__ = __f__.getA();
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return this.__a__; }
				};
				RPP __neg__=new RPP() {
					private RPP __f__ = Id.SINGLETON_Id;
					private final int __a__ = __f__.getA();
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return __f__.getA(); }
				};
				public int getA() { return this.__pos__.getA()+1; }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					final int __testValue__ = __x__[(__startIndex__ + this.getA()) - 1];
					if(__testValue__ > 0){
						__pos__.b(__x__, __startIndex__, __startIndex__ + __pos__.getA());
					} else if(__testValue__ == 0){
						__zero__.b(__x__, __startIndex__, __startIndex__ + __zero__.getA());
					} else { // The "__testValue__<0" test is a tautology
						__neg__.b(__x__, __startIndex__, __startIndex__ + __neg__.getA());
					}
				}
			},
			
			new RPP() { // ParCompImpl
				private RPP __f__ = new RPP(){
					private RPP __f__ = Inc.SINGLETON_Inc;
					private final int __a__ = __f__.getA();
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return this.__a__; }
				};
				public int getA() { return 2; }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__,
						__startIndex__ + 1,
						__startIndex__ + (1) + (1)
						);
				}
			}
		};
		public int getA() { return this.__steps__[0].getA(); }
		public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
			int __i__;
			__i__ = -1;
			while( ++__i__ < __steps__.length ){
				__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
			}
		}
	};
	public int getA() { return this.__pos__.getA()+1; }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		final int __testValue__ = __x__[(__startIndex__ + this.getA()) - 1];
		if(__testValue__ > 0){
			__pos__.b(__x__, __startIndex__, __startIndex__ + __pos__.getA());
		} else if(__testValue__ == 0){
			__zero__.b(__x__, __startIndex__, __startIndex__ + __zero__.getA());
		} else { // The "__testValue__<0" test is a tautology
			__neg__.b(__x__, __startIndex__, __startIndex__ + __neg__.getA());
		}
	}
}