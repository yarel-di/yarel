package parametricStuffs;
import yarelcore.*;	

public class IncrAll implements RPP {
	public IncrAll(//arities:
		int K
		){
		this.__fixedRegistersAmount__ = 0;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
	}
	protected IncrAll(){
		this(1);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int K;
	
	
	
	protected RPP __theWholeBody__ = null;

	
	public InvIncrAll getInverse(){
		return new InvIncrAll(this.K);
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
				private RPP __f__ = Inc.SINGLETON_Inc;
				public int getA() { return 0 + (1*K); }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					int __arity__ = this.getA();
					int __repsAmount__ = 1;
					for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
					for(int __i__ = 0; __i__ < __arity__; __i__++){
						this.__f__.b(__x__, __startIndex__ + __i__, __startIndex__ + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
					} 
					}
				}
			};
		}
	}
}