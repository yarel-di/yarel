package yarelLib;
import yarelcore.*;	

public class InvMoreThan implements RPP {
	public InvMoreThan(//arities:
		int M
		,
		int I,
		int J,
		int P,
		int Q,
		int K
		){
		this.__fixedRegistersAmount__ = 6;
		if(M < 0){ throw new WrongArityException("The arity \"M\" cannot be negative: " + M); }
		this.M = M;
		// if(I < 0){ throw new WrongArityException("The parameter \"I\" cannot be negative: " + I); }
		this.I = I;
		// if(J < 0){ throw new WrongArityException("The parameter \"J\" cannot be negative: " + J); }
		this.J = J;
		// if(P < 0){ throw new WrongArityException("The parameter \"P\" cannot be negative: " + P); }
		this.P = P;
		// if(Q < 0){ throw new WrongArityException("The parameter \"Q\" cannot be negative: " + Q); }
		this.Q = Q;
		// if(K < 0){ throw new WrongArityException("The parameter \"K\" cannot be negative: " + K); }
		this.K = K;
	}
	protected InvMoreThan(){
		this(1,0, 0, 0, 0, 0);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int M;
	protected final int I;
	protected final int J;
	protected final int P;
	protected final int Q;
	protected final int K;
	
	
	public int getFixedRegistersAmount(){
		return this.__fixedRegistersAmount__;
	}
	public int getM(){ return this.M; }
	public int getI(){ return this.I; }
	
	public int getJ(){ return this.J; }
	
	public int getP(){ return this.P; }
	
	public int getQ(){ return this.Q; }
	
	public int getK(){ return this.K; }
	
	protected RPP __theWholeBody__ = null;

	
	public MoreThan getInverse(){
		return new MoreThan(this.M,I, J, P, Q, K);
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
						RPP __function__ = new InvDupNumbersStep(
							0 + (1*M)
							,
							0 + (1*I),
							0 + (1*J),
							0 + (1*P),
							0 + (1*Q),
							0 + (1*K)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodyIfImpl
						RPP __pos__=new RPP() {
							RPP __pos__=new RPP() {
								RPP __function__ = new InvSameSignYMore(
									0 + (1*M)
									,
									0 + (1*K),
									0 + (1*P),
									0 + (1*Q)
								);
								public int getA() { return __function__.getA(); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__function__.b(__x__, __startIndex__, __endIndex__);
								}
							};
							RPP __zero__=new RPP() {
								public int getA() { return 4 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
							};
							RPP __neg__=new RPP() {
								public int getA() { return 4 + (1*M); }
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
						RPP __zero__=new RPP() {
							RPP __pos__=new RPP() {
								private RPP __f__ = new RPP(){
									private RPP __f__ = InvInc.SINGLETON_InvInc;
									private final int __a__ = __f__.getA();
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__, __startIndex__, __endIndex__);
									}
									public int getA() { return this.__a__; }
								};
								public int getA() { return 4 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__,
										__startIndex__ + -1 + (1*K),
										__startIndex__ + (-1 + (1*K)) + (1)
										);
								}
							};
							RPP __zero__=new RPP() {
								public int getA() { return 4 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
							};
							RPP __neg__=new RPP() {
								public int getA() { return 4 + (1*M); }
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
									private RPP __f__ = InvInc.SINGLETON_InvInc;
									private final int __a__ = __f__.getA();
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__, __startIndex__, __endIndex__);
									}
									public int getA() { return this.__a__; }
								};
								public int getA() { return 4 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__,
										__startIndex__ + -1 + (1*K),
										__startIndex__ + (-1 + (1*K)) + (1)
										);
								}
							};
							RPP __zero__=new RPP() {
								private RPP __f__ = new RPP(){
									private RPP __f__ = InvInc.SINGLETON_InvInc;
									private final int __a__ = __f__.getA();
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__, __startIndex__, __endIndex__);
									}
									public int getA() { return this.__a__; }
								};
								public int getA() { return 4 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__,
										__startIndex__ + -1 + (1*K),
										__startIndex__ + (-1 + (1*K)) + (1)
										);
								}
							};
							RPP __neg__=new RPP() {
								RPP __function__ = new InvSameSignYMore(
									0 + (1*M)
									,
									0 + (1*K),
									0 + (1*P),
									0 + (1*Q)
								);
								public int getA() { return __function__.getA(); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__function__.b(__x__, __startIndex__, __endIndex__);
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
					
					new RPP() { // BodyInvImpl
						RPP __function__ = new DupNumbersStep(
							0 + (1*M)
							,
							0 + (1*I),
							0 + (1*J),
							0 + (1*P),
							0 + (1*Q),
							0 + (1*K)
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