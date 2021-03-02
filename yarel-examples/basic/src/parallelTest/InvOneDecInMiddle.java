package parallelTest;
import yarelcore.*;	

public class InvOneDecInMiddle implements RPP {
	public InvOneDecInMiddle() { }
	
	

	
	public OneDecInMiddle getInverse(){
		return new OneDecInMiddle();
	}
	
	private RPP f = new RPP(){
		private RPP f = InvDec.SINGLETON_InvDec;
		private final int a = f.getA();
		public void b(int[] x, int startIndex, int endIndex) {
			this.f.b(x, startIndex, endIndex);
		}
		public int getA() { return this.a; }
	};
	public int getA() { return 3; }
	public void b(int[] x, int startIndex, int endIndex) {
		this.f.b(x,
			startIndex + 1,
			startIndex + (1) + (1)
			);
	}
}