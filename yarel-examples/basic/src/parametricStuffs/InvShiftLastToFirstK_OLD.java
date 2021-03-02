package parametricStuffs;
import yarelcore.*;	

public class InvShiftLastToFirstK_OLD implements RPP {
	public InvShiftLastToFirstK_OLD(//arities:
		int K
		){
		this.__fixedRegistersAmount__ = 2;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
	}
	protected InvShiftLastToFirstK_OLD(){
		this(1);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int K;
	
	
	
	protected RPP __theWholeBody__ = null;

	
	public ShiftLastToFirstK_OLD getInverse(){
		return new ShiftLastToFirstK_OLD(this.K);
	}
	
	public int getA() {
		this.checkTheWholeBody();
		//return this.__theWholeBody__.getA();
		return this.__fixedRegistersAmount__ + this.K;
	}
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.checkTheWholeBody();
		this.__theWholeBody__.b(__x__, __startIndex__, __endIndex__);
	}
	protected void checkTheWholeBody(){
		if(this.__theWholeBody__ == null){
			this.__theWholeBody__ = new RPP(){
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
						public int getA() { return 2 + (1*K); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0 + (1*K),
								__startIndex__ + (0 + (1*K)) + (2)
								);
						}
					},
					
					new RPP() { // BodyForImpl
						/** regular function used when v > 0 */
						RPP __function__ = new RPP() { // SerCompImpl
							private final RPP[] __steps__ = new RPP[]{
								new RPP() { // BodyParamPermImpl
									public int getA() { return 1 + 0 + (1*K); }
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
									public int getA() { return 1 + (1*K); }
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__,
											__startIndex__ + 0 + (1*K),
											__startIndex__ + (0 + (1*K)) + (1)
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
									public int getA() { return 1 + 0 + (1*K); }
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
									public int getA() { return 1 + (1*K); }
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__,
											__startIndex__ + 0 + (1*K),
											__startIndex__ + (0 + (1*K)) + (1)
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
			};
		}
	}
}