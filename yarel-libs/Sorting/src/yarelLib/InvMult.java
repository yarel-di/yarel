package yarelLib;
import yarelcore.*;	

public class InvMult implements RPP {
	public InvMult(//arities:
		int M
		,
		int K,
		int J,
		int I
		){
		this.__fixedRegistersAmount__ = 4;
		if(M < 0){ throw new WrongArityException("The arity \"M\" cannot be negative: " + M); }
		this.M = M;
		// if(K < 0){ throw new WrongArityException("The parameter \"K\" cannot be negative: " + K); }
		this.K = K;
		// if(J < 0){ throw new WrongArityException("The parameter \"J\" cannot be negative: " + J); }
		this.J = J;
		// if(I < 0){ throw new WrongArityException("The parameter \"I\" cannot be negative: " + I); }
		this.I = I;
	}
	protected InvMult(){
		this(1,0, 0, 0);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int M;
	protected final int K;
	protected final int J;
	protected final int I;
	
	
	public int getFixedRegistersAmount(){
		return this.__fixedRegistersAmount__;
	}
	public int getM(){ return this.M; }
	public int getK(){ return this.K; }
	
	public int getJ(){ return this.J; }
	
	public int getI(){ return this.I; }
	
	protected RPP __theWholeBody__ = null;

	
	public Mult getInverse(){
		return new Mult(this.M,K, J, I);
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
					new RPP() { // BodyFunImpl
						RPP __function__ = new InvSwapSRLlike(
							2 + (1*M)
							,
							2 + (1*M),
							0 + (1*I)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodyFunImpl
						RPP __function__ = new InvSwapSRLlike(
							2 + (1*M)
							,
							1 + (1*M),
							0 + (1*J)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // ParCompImpl
						private RPP __f__ = new RPP(){
							private final int __a__ = 4;
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __tmp__=0;
								__tmp__ = __x__[__startIndex__ + 0]; 
								__x__[__startIndex__ + 0] = __x__[__startIndex__ + 2]; 
								__x__[__startIndex__ + 2] = __tmp__; 
								__tmp__ = __x__[__startIndex__ + 1]; 
								__x__[__startIndex__ + 1] = __x__[__startIndex__ + 3]; 
								__x__[__startIndex__ + 3] = __tmp__; 
							}
							public int getA() { return this.__a__; }
						};
						public int getA() { return 4 + (1*M); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0 + (1*M),
								__startIndex__ + (0 + (1*M)) + (4)
								);
						}
					},
					
					new RPP() { // BodyItImpl
						// Iteration start
						RPP __function__ = new RPP() { // BodyItImpl
							// Iteration start
							RPP __function__ = new RPP() { // ParCompImpl
								private RPP __f__ = new RPP(){
									private RPP __f__ = InvInc.SINGLETON_InvInc;
									private final int __a__ = __f__.getA();
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__, __startIndex__, __endIndex__);
									}
									public int getA() { return this.__a__; }
								};
								public int getA() { return 2 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__,
										__startIndex__ + -1 + (1*K),
										__startIndex__ + (-1 + (1*K)) + (1)
										);
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
					
					new RPP() { // BodyIfImpl
						RPP __pos__=new RPP() {
							RPP __pos__=new RPP() {
								public int getA() { return 2 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
							};
							RPP __zero__=new RPP() {
								public int getA() { return 2 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
							};
							RPP __neg__=new RPP() {
								private RPP __f__ = new RPP(){
									private RPP __f__ = InvNeg.SINGLETON_InvNeg;
									private final int __a__ = __f__.getA();
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__, __startIndex__, __endIndex__);
									}
									public int getA() { return this.__a__; }
								};
								public int getA() { return 2 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__,
										__startIndex__ + -1 + (1*K),
										__startIndex__ + (-1 + (1*K)) + (1)
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
						};
						RPP __zero__=new RPP() {
							RPP __pos__=new RPP() {
								public int getA() { return 2 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
							};
							RPP __zero__=new RPP() {
								public int getA() { return 2 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
							};
							RPP __neg__=new RPP() {
								public int getA() { return 2 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
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
						};
						RPP __neg__=new RPP() {
							RPP __pos__=new RPP() {
								private RPP __f__ = new RPP(){
									private RPP __f__ = InvNeg.SINGLETON_InvNeg;
									private final int __a__ = __f__.getA();
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__, __startIndex__, __endIndex__);
									}
									public int getA() { return this.__a__; }
								};
								public int getA() { return 2 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__,
										__startIndex__ + -1 + (1*K),
										__startIndex__ + (-1 + (1*K)) + (1)
										);
								}
							};
							RPP __zero__=new RPP() {
								public int getA() { return 2 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
							};
							RPP __neg__=new RPP() {
								public int getA() { return 2 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
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
					
					new RPP() { // ParCompImpl
						private RPP __f__ = new RPP(){
							private final int __a__ = 4;
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __tmp__=0;
								__tmp__ = __x__[__startIndex__ + 0]; 
								__x__[__startIndex__ + 0] = __x__[__startIndex__ + 2]; 
								__x__[__startIndex__ + 2] = __tmp__; 
								__tmp__ = __x__[__startIndex__ + 1]; 
								__x__[__startIndex__ + 1] = __x__[__startIndex__ + 3]; 
								__x__[__startIndex__ + 3] = __tmp__; 
							}
							public int getA() { return this.__a__; }
						};
						public int getA() { return 4 + (1*M); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0 + (1*M),
								__startIndex__ + (0 + (1*M)) + (4)
								);
						}
					},
					
					new RPP() { // BodyFunImpl
						RPP __function__ = new InvSwapSRLlike(
							2 + (1*M)
							,
							1 + (1*M),
							0 + (1*J)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodyFunImpl
						RPP __function__ = new InvSwapSRLlike(
							2 + (1*M)
							,
							2 + (1*M),
							0 + (1*I)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
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