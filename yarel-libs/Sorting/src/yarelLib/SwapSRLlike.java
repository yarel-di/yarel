package yarelLib;
import yarelcore.*;	

public class SwapSRLlike implements RPP {
	public SwapSRLlike(//arities:
		int K
		,
		int S,
		int E
		){
		this.__fixedRegistersAmount__ = 2;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
		// if(S < 0){ throw new WrongArityException("The parameter \"S\" cannot be negative: " + S); }
		this.S = S;
		
		// if(E < 0){ throw new WrongArityException("The parameter \"E\" cannot be negative: " + E); }
		this.E = E;
		
	}
	protected SwapSRLlike(){
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

	
	public InvSwapSRLlike getInverse(){
		return new InvSwapSRLlike(this.K,S, E);
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
							private final RPP[] __steps__ = new RPP[]{
								new RPP() { // BodyParamIncImpl // index: 0
									private RPP __f__ = Inc.SINGLETON_Inc;
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
								},
								
								new RPP() { // BodyParamDecImpl // index: 1
									private RPP __f__ = Dec.SINGLETON_Dec;
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
						public int getA() { return 2 + (1*K); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 1 + (1*K),
								__startIndex__ + (1 + (1*K)) + this.__f__.getA()
								);
						}
					},
					
					new RPP() { // BodyIfImpl // index: 1
						RPP __pos__=new RPP() {
							private RPP __f__ = new RPP(){
								RPP __function__ = new SwapParamHelper(
									1 + (1*K) + ((-1)*S)
									,
									1 + (1*E) + ((-1)*S)
								);
								public int getA() { return __function__.getA(); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__function__.b(__x__, __startIndex__, __endIndex__);
								}
							};
							public int getA() { return 1 + (1*K); }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								this.__f__.b(__x__,
									__startIndex__ + -1 + (1*S),
									__startIndex__ + (-1 + (1*S)) + this.__f__.getA()
									);
							}
						};
						RPP __zero__=new RPP() {
							public int getA() { return 1 + (1*K); }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
						};
						RPP __neg__=new RPP() {
							private RPP __f__ = new RPP(){
								RPP __function__ = new SwapParamHelper(
									1 + (1*K) + ((-1)*E)
									,
									1 + (1*S) + ((-1)*E)
								);
								public int getA() { return __function__.getA(); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__function__.b(__x__, __startIndex__, __endIndex__);
								}
							};
							public int getA() { return 1 + (1*K); }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								this.__f__.b(__x__,
									__startIndex__ + -1 + (1*E),
									__startIndex__ + (-1 + (1*E)) + this.__f__.getA()
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
					},
					
					new RPP() { // ParCompImpl // index: 2
						private RPP __f__ = new RPP(){
							private final RPP[] __steps__ = new RPP[]{
								new RPP() { // BodyParamIncImpl // index: 0
									private RPP __f__ = Inc.SINGLETON_Inc;
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
								},
								
								new RPP() { // BodyParamDecImpl // index: 1
									private RPP __f__ = Dec.SINGLETON_Dec;
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
						public int getA() { return 2 + (1*K); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 1 + (1*K),
								__startIndex__ + (1 + (1*K)) + this.__f__.getA()
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