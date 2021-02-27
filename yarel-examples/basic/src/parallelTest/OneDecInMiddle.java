package parallelTest;
import yarelcore.*;	

public class OneDecInMiddle implements RPP {
	public OneDecInMiddle() { }
	
	public InvOneDecInMiddle getInverse(){
		return new InvOneDecInMiddle();
	}
	
	private RPP f = new RPP(){
		private RPP f = Dec.SINGLETON_Dec;
		private final int a = f.getA();
		public void b(int[] x, int startIndex, int endIndex) {
			this.f.b(x, startIndex, endIndex);
		}
		public int getA() { return this.a; }
	};
	private final int a = 3 ;
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) {
		this.f.b(x, startIndex + 1, startIndex + this.a + 1);
	}
}