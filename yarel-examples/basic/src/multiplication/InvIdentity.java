package multiplication;
import yarelcore.*;	

public class InvIdentity implements RPP {
	public InvIdentity() { }
	
	@Override
	public Identity getInverse(){
		return new Identity();
	}
	
	RPP l = new RPP() { // BodyFunImpl
		RPP function = new InvMultiplication();
		private final int a = function.getA();
		public void b(int[] x, int startIndex, int endIndex) {
			this.function.b(x, startIndex, endIndex);
		}
		 public int getA() { return this.a; }
	};
	RPP r = new RPP() { // BodyInvImpl
		RPP function = new Multiplication();
		private final int a = function.getA();
		public void b(int[] x, int startIndex, int endIndex) {
			this.function.b(x, startIndex, endIndex);
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