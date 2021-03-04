package yarelLib;
import yarelcore.*;	

public class InvSameSignY implements RPP {
	public InvSameSignY(//arities:
		int M
		,
		int K,
		int P,
		int Q
		){
		this.__fixedRegistersAmount__ = 4;
		if(M < 0){ throw new WrongArityException("The arity \"M\" cannot be negative: " + M); }
		this.M = M;
		// if(K < 0){ throw new WrongArityException("The parameter \"K\" cannot be negative: " + K); }
		this.K = K;
		// if(P < 0){ throw new WrongArityException("The parameter \"P\" cannot be negative: " + P); }
		this.P = P;
		// if(Q < 0){ throw new WrongArityException("The parameter \"Q\" cannot be negative: " + Q); }
		this.Q = Q;
	}
	protected InvSameSignY(){
		this(1,0, 0, 0);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int M;
	protected final int K;
	protected final int P;
	protected final int Q;
	
	
	public int getFixedRegistersAmount(){
		return this.__fixedRegistersAmount__;
	}
	public int getM(){ return this.M; }
	public int getK(){ return this.K; }
	
	public int getP(){ return this.P; }
	
	public int getQ(){ return this.Q; }
	
	protected RPP __theWholeBody__ = null;

	
	public SameSignY getInverse(){
		return new SameSignY(this.M,K, P, Q);
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
						RPP __function__ = new InvSubFrom(
							0 + (1*M)
							,
							0 + (1*Q),
							0 + (1*P)
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
							0 + (1*Q),
							2 + (1*M)
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
					
					new RPP() { // BodyIfImpl
						RPP __pos__=new RPP() {
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
									__startIndex__ + (-1 + (1*K)) + (1)
									);
							}
						};
						RPP __zero__=new RPP() {
							public int getA() { return 3 + (1*M); }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
						};
						RPP __neg__=new RPP() {
							public int getA() { return 3 + (1*M); }
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
					},
					
					new RPP() { // ParCompImpl
						private RPP __f__ = new RPP(){
							private final int __a__ = 4;
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __tmp__=0;
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
							0 + (1*Q),
							2 + (1*M)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodyFunImpl
						RPP __function__ = new InvAddFrom(
							0 + (1*M)
							,
							0 + (1*Q),
							0 + (1*P)
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