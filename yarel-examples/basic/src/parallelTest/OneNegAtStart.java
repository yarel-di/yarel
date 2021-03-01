package parallelTest;
import yarelcore.*;	

public class OneNegAtStart implements RPP {
	public OneNegAtStart() { }

	
	public InvOneNegAtStart getInverse(){
		return new InvOneNegAtStart();
	}
	
	private RPP f = new RPP(){
		private RPP f = Neg.SINGLETON_Neg;
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