package fibonacci;
import yarelcore.*;	

public class Fibonacci implements RPP {
	public Fibonacci() { }
	
	

	
	public InvFibonacci getInverse(){
		return new InvFibonacci();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new Fib();
				public int getA() { return function.getA(); }
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
			};
			public int getA() { return 4; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 0,
					startIndex + (0) + (1)
					);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 4;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 3]; 
				x[startIndex + 3] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				// Iteration start
				RPP function = new RPP() { // BodyIncImpl
					private RPP f = Inc.SINGLETON_Inc;
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
			public int getA() { return 4; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 2,
					startIndex + (2) + (2)
					);
			}
		},
		
		new RPP() { // BodyInvImpl
			private final int a = 4;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 2]; 
				x[startIndex + 2] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new InvFib();
				public int getA() { return function.getA(); }
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
			};
			public int getA() { return 4; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 0,
					startIndex + (0) + (1)
					);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 4;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 2]; 
				x[startIndex + 2] = tmp; 
			}
			public int getA() { return this.a; }
		}
	};
	public int getA() { return this.steps[0].getA(); }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		int i;
		i = -1;
		while( ++i < steps.length ){
			steps[i].b(x, startIndex, endIndex);
		}
	}
}