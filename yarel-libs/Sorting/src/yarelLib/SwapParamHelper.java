package yarelLib;
import yarelcore.*;	

public class SwapParamHelper implements RPP {
	public SwapParamHelper(//arities:
		int K
		,
		int Index
		){
		this.__fixedRegistersAmount__ = 1;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
		// if(Index < 0){ throw new WrongArityException("The parameter \"Index\" cannot be negative: " + Index); }
		this.Index = Index;
		
	}
	protected SwapParamHelper(){
		this(1,0);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int K;
	protected final int Index;
	
	
	public int getFixedRegistersAmount(){
		return this.__fixedRegistersAmount__;
	}
	public int getK(){ return this.K; }
	public int getIndex(){ return this.Index; }
	
	protected RPP __theWholeBody__ = null;

	
	public InvSwapParamHelper getInverse(){
		return new InvSwapParamHelper(this.K,Index);
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
					new RPP() { // ParCompImpl // index: 0
						private RPP __f__ = new RPP(){
							private RPP __f__ = Inc.SINGLETON_Inc;
							public int getA() { return 1; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __arity__;
								int __repsAmount__ = 0 + (1*Index);
								while(__repsAmount__-->0){
								__arity__ = this.getA();
								while(__arity__-->0){
									this.__f__.b(__x__, __startIndex__ + __arity__, __startIndex__ + __arity__ + 1); // "1" because "f.getA()" will surely returns "1"
								}
								}
							}
						};
						public int getA() { return 1 + (1*K); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0 + (1*K),
								__startIndex__ + (0 + (1*K)) + this.__f__.getA()
								);
						}
					},
					
					new RPP() { // BodyParamPermImpl // index: 1
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
					
					new RPP() { // ParCompImpl // index: 2
						private RPP __f__ = new RPP(){
							private RPP __f__ = Dec.SINGLETON_Dec;
							public int getA() { return 1; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __arity__;
								int __repsAmount__ = 0 + (1*Index);
								while(__repsAmount__-->0){
								__arity__ = this.getA();
								while(__arity__-->0){
									this.__f__.b(__x__, __startIndex__ + __arity__, __startIndex__ + __arity__ + 1); // "1" because "f.getA()" will surely returns "1"
								}
								}
							}
						};
						public int getA() { return 1 + (1*K); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0 + (1*K),
								__startIndex__ + (0 + (1*K)) + this.__f__.getA()
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
		}
	}
}