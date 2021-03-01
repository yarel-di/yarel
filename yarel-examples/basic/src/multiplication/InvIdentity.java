package multiplication;
import yarelcore.*;	

public class InvIdentity implements RPP {
	public InvIdentity() { }

	
	public Identity getInverse(){
		return new Identity();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // BodyFunImpl
			RPP function = new InvMultiplication();
			 public int getA() { return function.getA(); }
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
		},
		
		new RPP() { // BodyInvImpl
			RPP function = new Multiplication();
			 public int getA() { return function.getA(); }
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
		}
	};
	public int getA() { return this.steps[0].getA(); }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		int i;
		i = steps.length;
		while( i-->0 ){
			steps[i].b(x, startIndex, endIndex);
		}
	}
}