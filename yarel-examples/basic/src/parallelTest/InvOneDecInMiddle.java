package parallelTest;
import java.math.BigInteger;
import yarelcore.*;	

public class InvOneDecInMiddle implements RPP {
	public InvOneDecInMiddle() { }
	
	
	public OneDecInMiddle getInverse(){
		return new OneDecInMiddle();
	}
	
	private RPP __f__ = new RPP(){
		private RPP __f__ = InvDec.SINGLETON_InvDec;
		private final int __a__ = __f__.getA();
		public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
			this.__f__.b(__x__, __startIndex__, __endIndex__);
		}
		public int getA() { return this.__a__; }
	};
	public int getA() { return 3; }
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
		this.__f__.b(__x__,
			__startIndex__ + 1,
			__startIndex__ + (1) + this.__f__.getA()
			);
	}
}