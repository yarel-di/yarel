package multiplication;
import yarelcore.*;	

public class Identity implements RPP {
	public Identity() { }
	
	@Override
	public InvIdentity getInverse(){
		return new InvIdentity();
	}
	
	RPP l = new RPP() { // BodyFunImpl
		RPP function = new Multiplication();
		private final int a = function.getA();
		public void b(int[] x, int startIndex, int endIndex) {
			this.function.b(x, startIndex, endIndex);
		}
		 public int getA() { return this.a; }
	};
	RPP r = new RPP() { // BodyInvImpl
		RPP function = new InvMultiplication();
		private final int a = function.getA();
		public void b(int[] x, int startIndex, int endIndex) {
			this.function.b(x, startIndex, endIndex);
		}
		 public int getA() { return this.a; }
	};
	private final int a = l.getA();
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		this.l.b(x, startIndex, endIndex);
		this.r.b(x, startIndex, endIndex);
	}
}