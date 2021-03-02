package permuatation;
import yarelcore.*;	

public class InvShiftLastToFirst5 implements RPP {
	public InvShiftLastToFirst5() { }
	
	
	

	
	public ShiftLastToFirst5 getInverse(){
		return new ShiftLastToFirst5();
	}
	
	private final RPP[] __steps__ = new RPP[]{
		new RPP() { // ParCompImpl
			private RPP __f__ = new RPP(){
				/** regular function used when v > 0 */
				RPP __function__ = new RPP() { // BodyIncImpl
					private RPP __f__ = InvInc.SINGLETON_InvInc;
					private final int __a__ = __f__.getA();
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return this.__a__; }
				};
				
				/** inverse function used when v < 0 */
				RPP __inv_function__ = new RPP() { // InvBodyIncImpl
					private RPP __f__ = Inc.SINGLETON_Inc;
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
			};
			public int getA() { return 7; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 5,
					__startIndex__ + (5) + (2)
					);
			}
		},
		
		new RPP() { // BodyForImpl
			/** regular function used when v > 0 */
			RPP __function__ = new RPP() { // SerCompImpl
				private final RPP[] __steps__ = new RPP[]{
					new RPP() { // BodyParamPermImpl
						public int getA() { return 1 + 5; }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							final int __permutArity__ = this.getA() - 1;
							int __tmp__ = __x__[__startIndex__], __indexToWithdraw__;
							__indexToWithdraw__ = __x__[__startIndex__ + __permutArity__];
							if(__indexToWithdraw__ < 0){ __indexToWithdraw__ = -__indexToWithdraw__; }
							__indexToWithdraw__--; // the index is 1-based
							__indexToWithdraw__ = __startIndex__ + (__indexToWithdraw__ % __permutArity__);
							__x__[__startIndex__] = __x__[__indexToWithdraw__];
							__x__[__indexToWithdraw__] = __tmp__;
						}
					},
					
					new RPP() { // ParCompImpl
						private RPP __f__ = new RPP(){
							private RPP __f__ = InvDec.SINGLETON_InvDec;
							private final int __a__ = __f__.getA();
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								this.__f__.b(__x__, __startIndex__, __endIndex__);
							}
							public int getA() { return this.__a__; }
						};
						public int getA() { return 6; }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 5,
								__startIndex__ + (5) + (1)
								);
						}
					}
				};
				public int getA() { return this.__steps__[0].getA(); }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
					int __i__;
					__i__ = __steps__.length;
					while( __i__-->0 ){
						__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
					}
				}
			};
			
			/** inverse function used when v < 0 */
			RPP __inv_function__ = new RPP() { // InvSerCompImpl
				private final RPP[] __steps__ = new RPP[]{
					new RPP() { // BodyParamPermImpl
						public int getA() { return 1 + 5; }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							final int __permutArity__ = this.getA() - 1;
							int __tmp__ = __x__[__startIndex__], __indexToWithdraw__;
							__indexToWithdraw__ = __x__[__startIndex__ + __permutArity__];
							if(__indexToWithdraw__ < 0){ __indexToWithdraw__ = -__indexToWithdraw__; }
							__indexToWithdraw__--; // the index is 1-based
							__indexToWithdraw__ = __startIndex__ + (__indexToWithdraw__ % __permutArity__);
							__x__[__startIndex__] = __x__[__indexToWithdraw__];
							__x__[__indexToWithdraw__] = __tmp__;
						}
					},
					
					new RPP() { // ParCompImpl
						private RPP __f__ = new RPP(){
							private RPP __f__ = Dec.SINGLETON_Dec;
							private final int __a__ = __f__.getA();
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								this.__f__.b(__x__, __startIndex__, __endIndex__);
							}
							public int getA() { return this.__a__; }
						};
						public int getA() { return 6; }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 5,
								__startIndex__ + (5) + (1)
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
		}
	};
	public int getA() { return this.__steps__[0].getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
		int __i__;
		__i__ = __steps__.length;
		while( __i__-->0 ){
			__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
		}
	}
}