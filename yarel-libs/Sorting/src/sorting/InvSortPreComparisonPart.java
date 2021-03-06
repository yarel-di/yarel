package sorting;
import yarelcore.*;	

public class InvSortPreComparisonPart implements RPP {
	public InvSortPreComparisonPart(//arities:
		int K
		){
		this.__fixedRegistersAmount__ = 4;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
	}
	protected InvSortPreComparisonPart(){
		this(1);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int K;
	
	
	
	protected RPP __theWholeBody__ = null;

	
	public SortPreComparisonPart getInverse(){
		return new SortPreComparisonPart(this.K);
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
							private RPP __f__ = InvInc.SINGLETON_InvInc;
							public int getA() { return 1; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __arity__;
								int __repsAmount__ = 1 + (1*K);
								while(__repsAmount__-->0){
								__arity__ = this.getA();
								while(__arity__-->0){
									this.__f__.b(__x__, __startIndex__ + __arity__, __startIndex__ + __arity__ + 1); // "1" because "f.getA()" will surely returns "1"
								}
								}
							}
						};
						public int getA() { return 4 + (1*K); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 2 + (1*K),
								__startIndex__ + (2 + (1*K)) + this.__f__.getA()
								);
						}
					},
					
					new RPP() { // BodyParamPermImpl // index: 1
						public int getA() { return 1 + 3 + (1*K); }
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
							public int getA() { return 1 + 2 + (1*K); }
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
						};
						public int getA() { return 4 + (1*K); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0,
								__startIndex__ + (0) + this.__f__.getA()
								);
						}
					},
					
					new RPP() { // BodyParamPermImpl // index: 3
						public int getA() { return 1 + 3 + (1*K); }
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
					
					new RPP() { // ParCompImpl // index: 4
						private RPP __f__ = new RPP(){
							private RPP __f__ = InvInc.SINGLETON_InvInc;
							public int getA() { return 2; }
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
						public int getA() { return 4 + (1*K); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 2 + (1*K),
								__startIndex__ + (2 + (1*K)) + this.__f__.getA()
								);
						}
					},
					
					new RPP() { // BodyParamPermImpl // index: 5
						public int getA() { return 1 + 3 + (1*K); }
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
					
					new RPP() { // ParCompImpl // index: 6
						private RPP __f__ = new RPP(){
							public int getA() { return 1 + 2 + (1*K); }
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
						};
						public int getA() { return 4 + (1*K); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0,
								__startIndex__ + (0) + this.__f__.getA()
								);
						}
					},
					
					new RPP() { // BodyParamPermImpl // index: 7
						public int getA() { return 1 + 3 + (1*K); }
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