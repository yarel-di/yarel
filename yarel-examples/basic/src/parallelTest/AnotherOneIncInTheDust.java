package parallelTest;
import java.math.BigInteger;
import yarelcore.*;	

public class AnotherOneIncInTheDust implements RPP {
	public AnotherOneIncInTheDust() { }
	
	
	public InvAnotherOneIncInTheDust getInverse(){
		return new InvAnotherOneIncInTheDust();
	}
	
	private RPP __f__ = new RPP(){
		private RPP __f__ = Inc.SINGLETON_Inc;
		private final int __a__ = __f__.getA();
		public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
			this.__f__.b(__x__, __startIndex__, __endIndex__);
		}
		public int getA() { return this.__a__; }
	};
	public int getA() { return 3; }
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
		this.__f__.b(__x__,
			__startIndex__ + 2,
			__startIndex__ + (2) + this.__f__.getA()
			);
	}
}