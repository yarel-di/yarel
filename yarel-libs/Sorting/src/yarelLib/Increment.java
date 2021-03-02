package yarelLib;
import yarelcore.*;	

public class Increment implements RPP {
	public Increment(//arities:
		int M
		,
		int I,
		int J
		){
		this.__fixedRegistersAmount__ = 1;
		if(M < 0){ throw new WrongArityException("The arity \"M\" cannot be negative: " + M); }
		this.M = M;
		if(I < 0){ throw new WrongArityException("The parameter \"I\" cannot be negative: " + I); }
		this.I = I;
		if(J < 0){ throw new WrongArityException("The parameter \"J\" cannot be negative: " + J); }
		this.J = J;
	}
	protected Increment(){
		this(1,0, 0);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int M;
	protected final int I;
	protected final int J;
	
	
	public int getFixedRegistersAmount(){
		return this.__fixedRegistersAmount__;
	}
	public int getM(){ return this.M; }
	public int getI(){ return this.I; }
	
	public int getJ(){ return this.J; }
	
	protected RPP __theWholeBody__ = null;

	
	public InvIncrement getInverse(){
		return new InvIncrement(this.M,I, J);
	}
	
	public int getA() {
		this.checkTheWholeBody();
		//return this.__theWholeBody__.getA();
		return this.__fixedRegistersAmount__ + this.M;
	}
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.checkTheWholeBody();
		this.__theWholeBody__.b(__x__, __startIndex__, __endIndex__);
	}
	protected void checkTheWholeBody(){
		if(this.__theWholeBody__ == null){
			this.__theWholeBody__ = new RPP(){
				private final RPP[] __steps__ = new RPP[]{
					new RPP() { // BodySwapImpl
						public int getA() { return 1 + 0 + (1*M); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							int __arity__ = this.getA() - 1;
							RPP __f__ = new Swap(
								__arity__, //
								((0 + (1*I)) - 1) % __arity__, // Yarel's indexes are 1-based
								((-1 + (1*M)) - 1) % __arity__ //
							);
							__f__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodySwapImpl
						public int getA() { return 1 + 0 + (1*M); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							int __arity__ = this.getA() - 1;
							RPP __f__ = new Swap(
								__arity__, //
								((0 + (1*J)) - 1) % __arity__, // Yarel's indexes are 1-based
								((0 + (1*M)) - 1) % __arity__ //
							);
							__f__.b(__x__, __startIndex__, __endIndex__);
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
						public int getA() { return 1 + (1*M); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + -1 + (1*M),
								__startIndex__ + (-1 + (1*M)) + (2)
								);
						}
					},
					
					new RPP() { // BodySwapImpl
						public int getA() { return 1 + 0 + (1*M); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							int __arity__ = this.getA() - 1;
							RPP __f__ = new Swap(
								__arity__, //
								((0 + (1*I)) - 1) % __arity__, // Yarel's indexes are 1-based
								((-1 + (1*M)) - 1) % __arity__ //
							);
							__f__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodySwapImpl
						public int getA() { return 1 + 0 + (1*M); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							int __arity__ = this.getA() - 1;
							RPP __f__ = new Swap(
								__arity__, //
								((0 + (1*J)) - 1) % __arity__, // Yarel's indexes are 1-based
								((0 + (1*M)) - 1) % __arity__ //
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