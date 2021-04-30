package yarelLib;
import yarelcore.*;	

public class ShiftFirstToLastK implements RPP {
	public ShiftFirstToLastK(//arities:
		int K
		){
		this.__fixedRegistersAmount__ = 2;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
	}
	protected ShiftFirstToLastK(){
		this(1);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int K;
	
	
	
	protected RPP __theWholeBody__ = null;

	
	public InvShiftFirstToLastK getInverse(){
		return new InvShiftFirstToLastK(this.K);
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
				RPP __function__ = new InvShiftLastToFirstK(
					0 + (1*K)
				);
				public int getA() { return __function__.getA(); }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
		}
	}
}