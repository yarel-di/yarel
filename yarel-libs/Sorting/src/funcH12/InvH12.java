package funcH12;
import yarelcore.*;	

public class InvH12 implements RPP {
	public InvH12() { }
	
	

	
	public H12 getInverse(){
		return new H12();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // BodyPermImpl
			private final int a = 3;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 2]; 
				x[startIndex + 2] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // BodyFunImpl
			RPP function = new InvT3sub();
			public int getA() { return function.getA(); }
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new Dup_2();
				public int getA() { return function.getA(); }
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
			};
			public int getA() { return 3; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 0,
					startIndex + (0) + (1)
					);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 3;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 1]; 
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