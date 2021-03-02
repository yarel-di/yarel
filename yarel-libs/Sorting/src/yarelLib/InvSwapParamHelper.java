package yarelLib;
import yarelcore.*;	

public class InvSwapParamHelper implements RPP {
	public InvSwapParamHelper(//arities:
		int K
		,
		int I
		){
		this.__fixedRegistersAmount__ = 1;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
		if(I < 0){ throw new WrongArityException("The parameter \"I\" cannot be negative: " + I); }
		this.I = I;
	}
	protected InvSwapParamHelper(){
		this(1,0);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int K;
	protected final int I;
	
	
	public int getFixedRegistersAmount(){
		return this.__fixedRegistersAmount__;
	}
	public int getK(){ return this.K; }
	public int getI(){ return this.I; }
	
	protected RPP __theWholeBody__ = null;

	
	public SwapParamHelper getInverse(){
		return new SwapParamHelper(this.K,I);
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
							private RPP __f__ = InvInc.SINGLETON_InvInc;
							public int getA() { return 1; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __arity__ = this.getA();
								int __repsAmount__ = 0 + (1*I);
								for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
								for(int __i__ = 0; __i__ < __arity__; __i__++){
									this.__f__.b(__x__, __startIndex__ + __i__, __startIndex__ + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
								} 
								}
							}
						};
						public int getA() { return 1 + (1*K); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0 + (1*K),
								__startIndex__ + (0 + (1*K)) + (1)
								);
						}
					},
					
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
							public int getA() { return 1; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __arity__ = this.getA();
								int __repsAmount__ = 0 + (1*I);
								for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
								for(int __i__ = 0; __i__ < __arity__; __i__++){
									this.__f__.b(__x__, __startIndex__ + __i__, __startIndex__ + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
								} 
								}
							}
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
		}
	}
}