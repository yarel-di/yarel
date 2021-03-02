package parallelTest;
import yarelcore.*;	

public class InvOneNegAtStart implements RPP {
	public InvOneNegAtStart() { }
	
	

	
	public OneNegAtStart getInverse(){
		return new OneNegAtStart();
	}
	
	private RPP f = new RPP(){
		private RPP f = InvNeg.SINGLETON_InvNeg;
		private final int a = f.getA();
		public void b(int[] x, int startIndex, int endIndex) {
			this.f.b(x, startIndex, endIndex);
		}
		public int getA() { return this.a; }
	};
	public int getA() { return 3; }
	public void b(int[] x, int startIndex, int endIndex) {
		this.f.b(x,
			startIndex + 0,
			startIndex + (0) + (1)
			);
	}
}