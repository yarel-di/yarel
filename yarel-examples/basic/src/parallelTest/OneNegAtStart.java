package parallelTest;
import java.math.BigInteger;
import yarelcore.*;	

public class OneNegAtStart implements RPP {
	public OneNegAtStart() { }
	
	
	public InvOneNegAtStart getInverse(){
		return new InvOneNegAtStart();
	}
	
	private RPP __f__ = new RPP(){
		private RPP __f__ = Neg.SINGLETON_Neg;
		private final int __a__ = __f__.getA();
		public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
			this.__f__.b(__x__, __startIndex__, __endIndex__);
		}
		public int getA() { return this.__a__; }
	};
	public int getA() { return 3; }
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
		this.__f__.b(__x__,
			__startIndex__ + 0,
			__startIndex__ + (0) + this.__f__.getA()
			);
	}
}