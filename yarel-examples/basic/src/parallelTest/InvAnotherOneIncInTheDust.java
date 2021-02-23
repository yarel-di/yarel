package parallelTest;
import yarelcore.*;	

public class InvAnotherOneIncInTheDust implements RPP {
	public InvAnotherOneIncInTheDust() { }
	
	public AnotherOneIncInTheDust getInverse(){
		return new AnotherOneIncInTheDust();
	}
	
	private RPP f = new RPP(){
		private RPP f = new InvInc();
		private final int a = f.getA();
		public void b(int[] x, int startIndex, int endIndex) {
			this.f.b(x, startIndex, endIndex);
		}
		public int getA() { return this.a; }
	};
	private final int a = 3 ;
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) {
		this.f.b(x, startIndex + 2, startIndex + this.a + 2);
	}
}