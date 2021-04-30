package yarelLib;
import yarelcore.*;	

public class InvSwapSRLlike implements RPP {
	public InvSwapSRLlike(//arities:
		int K
		,
		int S,
		int E
		){
		this.__fixedRegistersAmount__ = 1;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
		// if(S < 0){ throw new WrongArityException("The parameter \"S\" cannot be negative: " + S); }
		this.S = S;
		
		// if(E < 0){ throw new WrongArityException("The parameter \"E\" cannot be negative: " + E); }
		this.E = E;
		
		// constraint distinct
		if(S == E){ throw new IllegalArgumentException("The parameters S and E must be different."); }
		
		// constraint bound
		if( 1 > S || S > K ){ throw new IllegalArgumentException("The parameter S should be greater than zero and lower or equal than K (" + K + ")."); }
		
		// constraint bound
		if( 1 > E || E > K ){ throw new IllegalArgumentException("The parameter E should be greater than zero and lower or equal than K (" + K + ")."); }
	}
	protected InvSwapSRLlike(){
		this(1,0, 0);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int K;
	protected final int S;
	protected final int E;
	
	
	public int getFixedRegistersAmount(){
		return this.__fixedRegistersAmount__;
	}
	public int getK(){ return this.K; }
	public int getS(){ return this.S; }
	
	public int getE(){ return this.E; }
	
	protected RPP __theWholeBody__ = null;

	
	public SwapSRLlike getInverse(){
		return new SwapSRLlike(this.K,S, E);
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
				private final RPP[] __steps__ = new RPP[]{ //
					new RPP() { // ParCompImpl // index: 0
						private RPP __f__ = new RPP(){
							private RPP __f__ = InvInc.SINGLETON_InvInc;
							public int getA() { return 1; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __arity__;
								int __repsAmount__ = 0 + (1*S);
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
							private RPP __f__ = InvDec.SINGLETON_InvDec;
							public int getA() { return 1; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __arity__;
								int __repsAmount__ = 0 + (1*S);
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
					
					new RPP() { // ParCompImpl // index: 3
						private RPP __f__ = new RPP(){
							private RPP __f__ = InvInc.SINGLETON_InvInc;
							public int getA() { return 1; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __arity__;
								int __repsAmount__ = 0 + (1*E);
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
					
					new RPP() { // BodyParamPermImpl // index: 4
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
					
					new RPP() { // ParCompImpl // index: 5
						private RPP __f__ = new RPP(){
							private RPP __f__ = InvDec.SINGLETON_InvDec;
							public int getA() { return 1; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __arity__;
								int __repsAmount__ = 0 + (1*E);
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
					
					new RPP() { // ParCompImpl // index: 6
						private RPP __f__ = new RPP(){
							private RPP __f__ = InvInc.SINGLETON_InvInc;
							public int getA() { return 1; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __arity__;
								int __repsAmount__ = 0 + (1*S);
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
					
					new RPP() { // BodyParamPermImpl // index: 7
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
					
					new RPP() { // ParCompImpl // index: 8
						private RPP __f__ = new RPP(){
							private RPP __f__ = InvDec.SINGLETON_InvDec;
							public int getA() { return 1; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __arity__;
								int __repsAmount__ = 0 + (1*S);
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
					__i__ = __steps__.length;
					while( __i__-->0 ){
						__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
					}
				}
			};
		}
	}
}