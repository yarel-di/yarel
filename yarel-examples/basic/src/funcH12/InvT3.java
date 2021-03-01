package funcH12;
import yarelcore.*;	

public class InvT3 implements RPP {
	public InvT3() { }

	
	public T3 getInverse(){
		return new T3();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // BodyPermImpl
			private final int a = 3;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 1]; 
				x[startIndex + 1] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // BodyItImpl
			// Iteration start
			RPP function = new RPP() { // BodyFunImpl
				RPP function = new InvT2();
				 public int getA() { return function.getA(); }
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
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
		
		new RPP() { // BodyPermImpl
			private final int a = 3;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 2]; 
				x[startIndex + 2] = tmp; 
			}
			public int getA() { return this.a; }
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