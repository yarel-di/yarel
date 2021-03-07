package parallelTest;
import yarelcore.*;	

public class OneDecInMiddle implements RPP {
	public OneDecInMiddle() { }
	
	
	

	
	public InvOneDecInMiddle getInverse(){
		return new InvOneDecInMiddle();
	}
	
	private RPP __f__ = new RPP(){
		private RPP __f__ = Dec.SINGLETON_Dec;
		private final int __a__ = __f__.getA();
		public void b(int[] __x__, int __startIndex__, int __endIndex__) {
			this.__f__.b(__x__, __startIndex__, __endIndex__);
		}
		public int getA() { return this.__a__; }
	};
	public int getA() { return 3; }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.__f__.b(__x__,
			__startIndex__ + 1,
			__startIndex__ + (1) + this.__f__.getA()
			);
	}
}