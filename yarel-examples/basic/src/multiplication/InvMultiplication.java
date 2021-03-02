package multiplication;
import yarelcore.*;	

public class InvMultiplication implements RPP {
	public InvMultiplication() { }
	
	

	
	public Multiplication getInverse(){
		return new Multiplication();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // BodyFunImpl
			RPP function = new InvPermutation();
			public int getA() { return function.getA(); }
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
		},
		
		new RPP() { // BodyItImpl
			// Iteration start
			RPP function = new RPP() { // BodyItImpl
				// Iteration start
				RPP function = new RPP() { // BodyIncImpl
					private RPP f = InvInc.SINGLETON_InvInc;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				public int getA() { return function.getA()+1; }
				public void b(int[] x, int startIndex, int endIndex) {
					int endIndexBody = (startIndex + this.getA()) - 1;
					int iterationsLeft = Math.abs(x[endIndexBody]);
					while(iterationsLeft-->0){
						function.b(x, startIndex, endIndexBody);
					}
				}
				// Iteration stop
			};
			public int getA() { return function.getA()+1; }
			public void b(int[] x, int startIndex, int endIndex) {
				int endIndexBody = (startIndex + this.getA()) - 1;
				int iterationsLeft = Math.abs(x[endIndexBody]);
				while(iterationsLeft-->0){
					function.b(x, startIndex, endIndexBody);
				}
			}
			// Iteration stop
		},
		
		new RPP() { // BodyInvImpl
			RPP function = new Permutation();
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