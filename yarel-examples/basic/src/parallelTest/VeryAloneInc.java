package parallelTest;
import yarelcore.*;	

public class VeryAloneInc implements RPP {
	public VeryAloneInc() { }

	
	public InvVeryAloneInc getInverse(){
		return new InvVeryAloneInc();
	}
	
	private RPP f = new RPP(){
		private RPP f = Inc.SINGLETON_Inc;
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