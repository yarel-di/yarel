package parallelTest;
import yarelcore.*;	

public class InvAnotherOneIncInTheDust implements RPP {
	public InvAnotherOneIncInTheDust() { }
	
	
	

	
	public AnotherOneIncInTheDust getInverse(){
		return new AnotherOneIncInTheDust();
	}
	
	private RPP __f__ = new RPP(){
		private RPP __f__ = InvInc.SINGLETON_InvInc;
		private final int __a__ = __f__.getA();
		public void b(int[] __x__, int __startIndex__, int __endIndex__) {
			this.__f__.b(__x__, __startIndex__, __endIndex__);
		}
		public int getA() { return this.__a__; }
	};
	public int getA() { return 3; }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.__f__.b(__x__,
			__startIndex__ + 2,
			__startIndex__ + (2) + this.__f__.getA()
			);
	}
}