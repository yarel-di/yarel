package parallelTest;
import java.math.BigInteger;
import yarelcore.*;	

public class InvVeryAloneInc implements RPP {
	public InvVeryAloneInc() { }
	
	
	public VeryAloneInc getInverse(){
		return new VeryAloneInc();
	}
	
	private RPP __f__ = new RPP(){
		private RPP __f__ = InvInc.SINGLETON_InvInc;
		private final int __a__ = __f__.getA();
		public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
			this.__f__.b(__x__, __startIndex__, __endIndex__);
		}
		public int getA() { return this.__a__; }
	};
	public int getA() { return 10; }
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
		this.__f__.b(__x__,
			__startIndex__ + 3,
			__startIndex__ + (3) + this.__f__.getA()
			);
	}
}