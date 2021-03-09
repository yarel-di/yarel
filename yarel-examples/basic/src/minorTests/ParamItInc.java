package minorTests;
import yarelcore.*;	

public class ParamItInc implements RPP {
	public ParamItInc(//arities:
		int K
		,
		int Amount
		){
		this.__fixedRegistersAmount__ = 0;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
		// if(Amount < 0){ throw new WrongArityException("The parameter \"Amount\" cannot be negative: " + Amount); }
		this.Amount = Amount;
		
		// constraint natural
		if( Amount < 0 ){ throw new IllegalArgumentException("The parameter Amount must be a natural (>= 0)."); }
	}
	protected ParamItInc(){
		this(1,0);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int K;
	protected final int Amount;
	
	
	public int getFixedRegistersAmount(){
		return this.__fixedRegistersAmount__;
	}
	public int getK(){ return this.K; }
	public int getAmount(){ return this.Amount; }
	
	protected RPP __theWholeBody__ = null;

	
	public InvParamItInc getInverse(){
		return new InvParamItInc(this.K,Amount);
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
				// Iteration start
				RPP __function__ = new RPP() { // BodyParamIncImpl
					private RPP __f__ = Inc.SINGLETON_Inc;
					public int getA() { return 0 + (1*K); }
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
				protected final int __iterationsAmount__ = 0 + (1*Amount);
				public int getA() {
					return this.__iterationsAmount__; //__function__.getA();
				}
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					int __endIndexBody__ = (__startIndex__ + __iterationsAmount__);
					int __iterationsLeft__ = __iterationsAmount__;
					while(__iterationsLeft__-->0){
						__function__.b(__x__, __startIndex__, __endIndexBody__);
					}
				}
				// Iteration stop
			};
		}
	}
}