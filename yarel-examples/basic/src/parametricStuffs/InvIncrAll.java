package parametricStuffs;
import yarelcore.*;	

public class InvIncrAll implements RPP {
	public InvIncrAll(//arities:
		int K
		){
		this.__fixedRegistersAmount__ = 0;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
	}
	protected InvIncrAll(){
		this(1);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int K;
	
	
	
	protected RPP __theWholeBody__ = null;

	
	public IncrAll getInverse(){
		return new IncrAll(this.K);
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
				private RPP __f__ = InvInc.SINGLETON_InvInc;
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
		}
	}
}