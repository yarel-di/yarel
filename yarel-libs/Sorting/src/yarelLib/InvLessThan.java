package yarelLib;
import yarelcore.*;	

public class InvLessThan implements RPP {
	public InvLessThan(//arities:
		int M
		,
		int I,
		int J,
		int P,
		int Q,
		int K
		){
		this.__fixedRegistersAmount__ = 5;
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
		
		// constraint distinct
		java.util.Map<Integer, String> distincValues_0 = new java.util.HashMap<>(5);
		if( distincValues_0.containsKey(I) ){ throw new IllegalArgumentException("The parameter I has the same value as " + distincValues_0.get(I) + "."); }
		else{ distincValues_0.put(I, "I"); }
		
		if( distincValues_0.containsKey(J) ){ throw new IllegalArgumentException("The parameter J has the same value as " + distincValues_0.get(J) + "."); }
		else{ distincValues_0.put(J, "J"); }
		
		if( distincValues_0.containsKey(P) ){ throw new IllegalArgumentException("The parameter P has the same value as " + distincValues_0.get(P) + "."); }
		else{ distincValues_0.put(P, "P"); }
		
		if( distincValues_0.containsKey(Q) ){ throw new IllegalArgumentException("The parameter Q has the same value as " + distincValues_0.get(Q) + "."); }
		else{ distincValues_0.put(Q, "Q"); }
		
		if( distincValues_0.containsKey(K) ){ throw new IllegalArgumentException("The parameter K has the same value as " + distincValues_0.get(K) + "."); }
		else{ distincValues_0.put(K, "K"); }
		
		// constraint bound
		if( 1 > I || I > M ){ throw new IllegalArgumentException("The parameter I should be greater than zero and lower or equal than M (" + M + ")."); }
		
		// constraint bound
		if( 1 > J || J > M ){ throw new IllegalArgumentException("The parameter J should be greater than zero and lower or equal than M (" + M + ")."); }
		
		// constraint bound
		if( 1 > K || K > M ){ throw new IllegalArgumentException("The parameter K should be greater than zero and lower or equal than M (" + M + ")."); }
		
		// constraint bound
		if( 1 > P || P > M ){ throw new IllegalArgumentException("The parameter P should be greater than zero and lower or equal than M (" + M + ")."); }
		
		// constraint bound
		if( 1 > Q || Q > M ){ throw new IllegalArgumentException("The parameter Q should be greater than zero and lower or equal than M (" + M + ")."); }
	}
	protected InvLessThan(){
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

	
	public LessThan getInverse(){
		return new LessThan(this.M,I, J, P, Q, K);
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
				private final RPP[] __steps__ = new RPP[]{ //
					new RPP() { // BodyFunImpl // index: 0
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
					
					new RPP() { // BodyIfImpl // index: 1
						RPP __pos__=new RPP() {
							RPP __pos__=new RPP() {
								RPP __function__ = new InvSameSignYLess(
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
								private RPP __f__ = new RPP(){
									private RPP __f__ = InvInc.SINGLETON_InvInc;
									private final int __a__ = __f__.getA();
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__, __startIndex__, __endIndex__);
									}
									public int getA() { return this.__a__; }
								};
								public int getA() { return 3 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__,
										__startIndex__ + -1 + (1*K),
										__startIndex__ + (-1 + (1*K)) + this.__f__.getA()
										);
								}
							};
							RPP __neg__=new RPP() {
								private RPP __f__ = new RPP(){
									private RPP __f__ = InvInc.SINGLETON_InvInc;
									private final int __a__ = __f__.getA();
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__, __startIndex__, __endIndex__);
									}
									public int getA() { return this.__a__; }
								};
								public int getA() { return 3 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__,
										__startIndex__ + -1 + (1*K),
										__startIndex__ + (-1 + (1*K)) + this.__f__.getA()
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
								public int getA() { return 3 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
							};
							RPP __zero__=new RPP() {
								public int getA() { return 3 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
							};
							RPP __neg__=new RPP() {
								private RPP __f__ = new RPP(){
									private RPP __f__ = InvInc.SINGLETON_InvInc;
									private final int __a__ = __f__.getA();
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__, __startIndex__, __endIndex__);
									}
									public int getA() { return this.__a__; }
								};
								public int getA() { return 3 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__,
										__startIndex__ + -1 + (1*K),
										__startIndex__ + (-1 + (1*K)) + this.__f__.getA()
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
						RPP __neg__=new RPP() {
							RPP __pos__=new RPP() {
								public int getA() { return 3 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
							};
							RPP __zero__=new RPP() {
								public int getA() { return 3 + (1*M); }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
							};
							RPP __neg__=new RPP() {
								RPP __function__ = new InvSameSignYLess(
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
					
					new RPP() { // BodyInvImpl // index: 2
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