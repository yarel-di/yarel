package integerCompare;
import yarelcore.*;	

public class Compare implements RPP {
	public Compare() { }
	
	
	

	
	public InvCompare getInverse(){
		return new InvCompare();
	}
	
	private final RPP[] __steps__ = new RPP[]{ //
		new RPP() { // BodyFunImpl // index: 0
			RPP __function__ = new DupStep();
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		},
		
		new RPP() { // BodyIfImpl // index: 1
			RPP __pos__=new RPP() {
				RPP __pos__=new RPP() {
					RPP __function__ = new SameSignCompare();
					public int getA() { return __function__.getA(); }
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__function__.b(__x__, __startIndex__, __endIndex__);
					}
				};
				RPP __zero__=new RPP() {
					private RPP __f__ = new RPP(){
						private RPP __f__ = Dec.SINGLETON_Dec;
						private final int __a__ = __f__.getA();
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__, __startIndex__, __endIndex__);
						}
						public int getA() { return this.__a__; }
					};
					public int getA() { return 3; }
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__,
							__startIndex__ + 0,
							__startIndex__ + (0) + this.__f__.getA()
							);
					}
				};
				RPP __neg__=new RPP() {
					private RPP __f__ = new RPP(){
						private RPP __f__ = Dec.SINGLETON_Dec;
						private final int __a__ = __f__.getA();
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__, __startIndex__, __endIndex__);
						}
						public int getA() { return this.__a__; }
					};
					public int getA() { return 3; }
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__,
							__startIndex__ + 0,
							__startIndex__ + (0) + this.__f__.getA()
							);
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
			};
			RPP __zero__=new RPP() {
				RPP __pos__=new RPP() {
					private RPP __f__ = new RPP(){
						private RPP __f__ = Inc.SINGLETON_Inc;
						private final int __a__ = __f__.getA();
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__, __startIndex__, __endIndex__);
						}
						public int getA() { return this.__a__; }
					};
					public int getA() { return 3; }
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__,
							__startIndex__ + 0,
							__startIndex__ + (0) + this.__f__.getA()
							);
					}
				};
				RPP __zero__=new RPP() {
					public int getA() { return 3; }
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						// There were only parallels identities, nothing interesting to show and run
					}
				};
				RPP __neg__=new RPP() {
					private RPP __f__ = new RPP(){
						private RPP __f__ = Dec.SINGLETON_Dec;
						private final int __a__ = __f__.getA();
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__, __startIndex__, __endIndex__);
						}
						public int getA() { return this.__a__; }
					};
					public int getA() { return 3; }
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__,
							__startIndex__ + 0,
							__startIndex__ + (0) + this.__f__.getA()
							);
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
			};
			RPP __neg__=new RPP() {
				RPP __pos__=new RPP() {
					private RPP __f__ = new RPP(){
						private RPP __f__ = Inc.SINGLETON_Inc;
						private final int __a__ = __f__.getA();
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__, __startIndex__, __endIndex__);
						}
						public int getA() { return this.__a__; }
					};
					public int getA() { return 3; }
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__,
							__startIndex__ + 0,
							__startIndex__ + (0) + this.__f__.getA()
							);
					}
				};
				RPP __zero__=new RPP() {
					private RPP __f__ = new RPP(){
						private RPP __f__ = Inc.SINGLETON_Inc;
						private final int __a__ = __f__.getA();
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__, __startIndex__, __endIndex__);
						}
						public int getA() { return this.__a__; }
					};
					public int getA() { return 3; }
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__,
							__startIndex__ + 0,
							__startIndex__ + (0) + this.__f__.getA()
							);
					}
				};
				RPP __neg__=new RPP() {
					RPP __function__ = new SameSignCompare();
					public int getA() { return __function__.getA(); }
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__function__.b(__x__, __startIndex__, __endIndex__);
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
		
		new RPP() { // BodyInvImpl // index: 2
			RPP __function__ = new InvDupStep();
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
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
}