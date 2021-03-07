package parametricStuffs;
import yarelcore.*;	

public class NegativeParamWarning implements RPP {
	public NegativeParamWarning(//arities:
		int K, int J
		){
		this.__fixedRegistersAmount__ = 2;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
		if(J < 0){ throw new WrongArityException("The arity \"J\" cannot be negative: " + J); }
		this.J = J;
	}
	protected NegativeParamWarning(){
		this(1, 1);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int K;
	protected final int J;
	
	
	
	protected RPP __theWholeBody__ = null;

	
	public InvNegativeParamWarning getInverse(){
		return new InvNegativeParamWarning(this.K, this.J);
	}
	
	public int getA() {
		this.checkTheWholeBody();
		//return this.__theWholeBody__.getA();
		return this.__fixedRegistersAmount__ + this.K + this.J;
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
							private RPP __f__ = Inc.SINGLETON_Inc;
							public int getA() { return 5 + ((-1)*K); }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __arity__;
								int __repsAmount__ = 1;
								while(__repsAmount__-->0){
								__arity__ = this.getA();
								while(__arity__-->0){
									this.__f__.b(__x__, __startIndex__ + __arity__, __startIndex__ + __arity__ + 1); // "1" because "f.getA()" will surely returns "1"
								}
								}
							}
						};
						public int getA() { return 2 + (1*K) + (1*J); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + -3 + (1*J) + (1*K),
								__startIndex__ + (-3 + (1*J) + (1*K)) + this.__f__.getA()
								);
						}
					},
					
					new RPP() { // ParCompImpl
						private RPP __f__ = new RPP(){
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
						};
						public int getA() { return 2 + (1*K) + (1*J); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0 + (1*J),
								__startIndex__ + (0 + (1*J)) + this.__f__.getA()
								);
						}
					},
					
					new RPP() { // BodySwapImpl
						public int getA() { return 2 + (1*K) + (1*J); } // "1 +" is removed
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							int __arity__ = this.getA(); // "- 1" is removed
							RPP __f__ = new Swap( // Swap itselfwill adjust indexes on arity
								__arity__, //
								(-1 + (1*K)), //
								(-2 + (1*J) + (1*K))//
							);
							__f__.b(__x__, __startIndex__, __endIndex__);
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
		}
	}
}