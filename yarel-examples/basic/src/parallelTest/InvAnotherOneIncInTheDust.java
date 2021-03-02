package parallelTest;
import yarelcore.*;	

public class InvAnotherOneIncInTheDust implements RPP {
	public InvAnotherOneIncInTheDust() { }
	
	

	
	public AnotherOneIncInTheDust getInverse(){
		return new AnotherOneIncInTheDust();
	}
	
	private RPP f = new RPP(){
		private RPP f = InvInc.SINGLETON_InvInc;
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