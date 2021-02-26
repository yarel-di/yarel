package permuatation;
import yarelcore.*;	

public class InvPIndexed_0 implements RPP {
	public InvPIndexed_0() { }
	
	public PIndexed_0 getInverse(){
		return new PIndexed_0();
	}
	
	RPP l = new RPP() { // ParCompImpl
		private RPP f = new RPP(){
			RPP function = new InvPInd_dataset();
			private final int a = function.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
			 public int getA() { return this.a; }
		};
		private final int a = 5 ;
		public int getA() { return this.a; }
		public void b(int[] x, int startIndex, int endIndex) {
			this.f.b(x, startIndex + 0, startIndex + this.a + 0);
		}
	};
	RPP r = new RPP() { // BodyPermIndexImpl
		private final int a = 1 + 4;
		public void b(int[] x, int startIndex, int endIndex) {
			int tmp = x[startIndex], indexToWithdraw;
			indexToWithdraw = x[startIndex + this.a];
			if(indexToWithdraw < 0){ indexToWithdraw = -indexToWithdraw; }
			indexToWithdraw--; // the index is 1-based
			indexToWithdraw = startIndex + (indexToWithdraw % this.a);
			x[startIndex] = x[indexToWithdraw];
			x[indexToWithdraw] = tmp;
		}
		
		public int getA() { return this.a; }
	};
	private final int a = l.getA();
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		this.r.b(x, startIndex, endIndex);
		this.l.b(x, startIndex, endIndex);
	}
}