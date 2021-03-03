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
				private final RPP[] __steps__ = new RPP[]{
					new RPP() { // BodyFunImpl
						RPP __function__ = new InvSwapParamHelper(
							0 + (1*K)
							,
							0 + (1*E)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodyFunImpl
						RPP __function__ = new InvSwapParamHelper(
							0 + (1*K)
							,
							0 + (1*S)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodyFunImpl
						RPP __function__ = new InvSwapParamHelper(
							0 + (1*K)
							,
							0 + (1*E)
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