package yarelLib;
import yarelcore.*;	

public class DupNumbersStep implements RPP {
	public DupNumbersStep(//arities:
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
	protected DupNumbersStep(){
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

	
	public InvDupNumbersStep getInverse(){
		return new InvDupNumbersStep(this.M,I, J, P, Q, K);
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
					new RPP() { // BodyFunImpl // index: 0
						RPP __function__ = new AddFrom(
							2 + (1*M)
							,
							0 + (1*Q),
							0 + (1*J)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodyFunImpl // index: 1
						RPP __function__ = new AddFrom(
							2 + (1*M)
							,
							0 + (1*P),
							0 + (1*I)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodyFunImpl // index: 2
						RPP __function__ = new SwapSRLlike(
							4 + (1*M)
							,
							2 + (1*M),
							0 + (1*J)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodyFunImpl // index: 3
						RPP __function__ = new SwapSRLlike(
							4 + (1*M)
							,
							1 + (1*M),
							0 + (1*I)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // ParCompImpl // index: 4
						private RPP __f__ = new RPP(){
							private final int __a__ = 6;
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __tmp__=0;
								__tmp__ = __x__[__startIndex__ + 0]; 
								__x__[__startIndex__ + 0] = __x__[__startIndex__ + 2]; 
								__x__[__startIndex__ + 2] = __x__[__startIndex__ + 4]; 
								__x__[__startIndex__ + 4] = __tmp__; 
								__tmp__ = __x__[__startIndex__ + 1]; 
								__x__[__startIndex__ + 1] = __x__[__startIndex__ + 3]; 
								__x__[__startIndex__ + 3] = __x__[__startIndex__ + 5]; 
								__x__[__startIndex__ + 5] = __tmp__; 
							}
							public int getA() { return this.__a__; }
						};
						public int getA() { return 6 + (1*M); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0 + (1*M),
								__startIndex__ + (0 + (1*M)) + this.__f__.getA()
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