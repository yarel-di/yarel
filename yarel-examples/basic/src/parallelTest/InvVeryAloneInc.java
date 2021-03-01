package parallelTest;
import yarelcore.*;	

public class InvVeryAloneInc implements RPP {
	public InvVeryAloneInc() { }

	
	public VeryAloneInc getInverse(){
		return new VeryAloneInc();
	}
	
	private RPP f = new RPP(){
		private RPP f = InvInc.SINGLETON_InvInc;
		private final int a = f.getA();
		public void b(int[] x, int startIndex, int endIndex) {
			this.f.b(x, startIndex, endIndex);
		}
		public int getA() { return this.a; }
	};
	public int getA() { return 10; }
	public void b(int[] x, int startIndex, int endIndex) {
		this.f.b(x,
			startIndex + 3,
			startIndex + (3) + (1)
			);
	}
}