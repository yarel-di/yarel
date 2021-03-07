package fibonacci;
import yarelcore.*;	

public class Fib implements RPP {
	public Fib() { }
	
	
	

	
	public InvFib getInverse(){
		return new InvFib();
	}
	
	private final RPP[] __steps__ = new RPP[]{
		new RPP() { // BodyPermImpl // index: 0
			private final int __a__ = 3;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // ParCompImpl // index: 1
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
		},
		
		new RPP() { // BodyItImpl // index: 2
			// Iteration start
			RPP __function__ = new RPP() { // SerCompImpl
				private final RPP[] __steps__ = new RPP[]{
					new RPP() { // BodyForImpl // index: 0
						/** regular function used when v > 0 */
						RPP __function__ = new RPP() { // BodyIncImpl
							private RPP __f__ = Inc.SINGLETON_Inc;
							private final int __a__ = __f__.getA();
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								this.__f__.b(__x__, __startIndex__, __endIndex__);
							}
							public int getA() { return this.__a__; }
						};
						
						/** inverse function used when v < 0 */
						RPP __inv_function__ = new RPP() { // InvBodyIncImpl
							private RPP __f__ = InvInc.SINGLETON_InvInc;
							private final int __a__ = __f__.getA();
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								this.__f__.b(__x__, __startIndex__, __endIndex__);
							}
							public int getA() { return this.__a__; }
						};
						
						public int getA() { return __function__.getA()+1; } 
						public void b(int[] __x__, int __startIndex__, int __endIndex__) { //b stands for behaviour and x are the delta and v function parameters
							final int __repCounterIndex__ = (__startIndex__ + this.getA()) - 1, __originalRepCounter__;
							int __repetitionCounter__ = __x__[__repCounterIndex__];
							__originalRepCounter__ = __repetitionCounter__;
						
							if(__repetitionCounter__ > 0){ //if v is greater than zero, recursion goes on and v decreases each time
								__endIndex__ = __startIndex__ + __function__.getA();
								while(__repetitionCounter__-->0){
									__function__.b(__x__, __startIndex__, __repCounterIndex__);
									__x__[__repCounterIndex__]--;
								}
							}else if(__repetitionCounter__ < 0){ //if v is greater than zero, recursion goes on and v decreases each time
								__endIndex__ = __startIndex__ + __inv_function__.getA();
								while(__repetitionCounter__++<0){
									__inv_function__.b(__x__, __startIndex__, __repCounterIndex__);
									__x__[__repCounterIndex__]++;
								}
							} //else: when v is equal to zero, recursive calls stop as a value is returned
							__x__[__repCounterIndex__] = __originalRepCounter__; // restore the original value
						}
					},
					
					new RPP() { // BodyPermImpl // index: 1
						private final int __a__ = 2;
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							int __tmp__=0;
							__tmp__ = __x__[__startIndex__ + 0]; 
							__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
							__x__[__startIndex__ + 1] = __tmp__; 
						}
						public int getA() { return this.__a__; }
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
			public int getA() { return __function__.getA()+1; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __endIndexBody__ = (__startIndex__ + this.getA()) - 1;
				int __iterationsLeft__ = Math.abs(__x__[__endIndexBody__]);
				while(__iterationsLeft__-->0){
					__function__.b(__x__, __startIndex__, __endIndexBody__);
				}
			}
			// Iteration stop
		},
		
		new RPP() { // BodyIfImpl // index: 3
			RPP __pos__=new RPP() {
				public int getA() { return 2; }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					// There were only parallels identities, nothing interesting to show and run
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
				public int getA() { return 2; }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__,
						__startIndex__ + 0,
						__startIndex__ + (0) + this.__f__.getA()
						);
				}
			};
			RPP __neg__=new RPP() {
				public int getA() { return 2; }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					// There were only parallels identities, nothing interesting to show and run
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
		
		new RPP() { // BodyPermImpl // index: 4
			private final int __a__ = 3;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __tmp__; 
			}
			public int getA() { return this.__a__; }
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