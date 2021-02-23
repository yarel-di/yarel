package parallelTest;
import yarelcore.*;	

public class OneNegAtStart implements RPP {
	public OneNegAtStart() { }
	
	public InvOneNegAtStart getInverse(){
		return new InvOneNegAtStart();
	}
	
	private RPP f = new RPP(){
		private RPP f = new Neg();
		private final int a = f.getA();
		public void b(int[] x, int startIndex, int endIndex) {
			this.f.b(x, startIndex, endIndex);
		}
		public int getA() { return this.a; }
	};
	private final int a = 3 ;
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) {
		this.f.b(x, startIndex + 0, startIndex + this.a + 0);
	}
}