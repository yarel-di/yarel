package parallelTest;
import yarelcore.*;	

public class VeryAloneInc implements RPP {
	public VeryAloneInc() { }
	
	
	

	
	public InvVeryAloneInc getInverse(){
		return new InvVeryAloneInc();
	}
	
	private RPP __f__ = new RPP(){
		private RPP __f__ = Inc.SINGLETON_Inc;
		private final int __a__ = __f__.getA();
		public void b(int[] __x__, int __startIndex__, int __endIndex__) {
			this.__f__.b(__x__, __startIndex__, __endIndex__);
		}
		public int getA() { return this.__a__; }
	};
	public int getA() { return 10; }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.__f__.b(__x__,
			__startIndex__ + 3,
			__startIndex__ + (3) + this.__f__.getA()
			);
	}
}