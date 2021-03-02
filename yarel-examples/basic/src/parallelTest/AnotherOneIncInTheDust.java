package parallelTest;
import yarelcore.*;	

public class AnotherOneIncInTheDust implements RPP {
	public AnotherOneIncInTheDust() { }
	
	

	
	public InvAnotherOneIncInTheDust getInverse(){
		return new InvAnotherOneIncInTheDust();
	}
	
	private RPP f = new RPP(){
		private RPP f = Inc.SINGLETON_Inc;
		private final int a = f.getA();
		public void b(int[] x, int startIndex, int endIndex) {
			this.f.b(x, startIndex, endIndex);
		}
		public int getA() { return this.a; }
	};
	public int getA() { return 3; }
	public void b(int[] x, int startIndex, int endIndex) {
		this.f.b(x,
			startIndex + 2,
			startIndex + (2) + (1)
			);
	}
}