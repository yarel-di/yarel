package parallelTest;
import yarelcore.*;	

public class AnotherOneIncInTheDust implements RPP {
	public AnotherOneIncInTheDust() { }
	
	@Override
	public InvAnotherOneIncInTheDust getInverse(){
		return new InvAnotherOneIncInTheDust();
	}
	
	private RPP f = new RPP(){
		private RPP f = new Inc();
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