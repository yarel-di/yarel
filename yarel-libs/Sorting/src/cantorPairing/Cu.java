package cantorPairing;
import yarelcore.*;	

public class Cu implements RPP {
	public Cu() { }
	
	

	
	public InvCu getInverse(){
		return new InvCu();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // BodyPermImpl
			private final int a = 5;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 1]; 
				x[startIndex + 1] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // BodyFunImpl
			RPP function = new boundedMin.MinH12();
			public int getA() { return function.getA(); }
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 5;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 4]; 
				x[startIndex + 4] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // BodyIfImpl
			RPP pos=new RPP() {
				public int getA() { return 4; }
				public void b(int[] x, int startIndex, int endIndex) {
					// There were only parallels identities, nothing interesting to show and run
				}
			};
			RPP zero=new RPP() {
				private RPP f = new RPP(){
					private RPP f = Inc.SINGLETON_Inc;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				public int getA() { return 4; }
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x,
						startIndex + 0,
						startIndex + (0) + (1)
						);
				}
			};
			RPP neg=new RPP() {
				public int getA() { return 4; }
				public void b(int[] x, int startIndex, int endIndex) {
					// There were only parallels identities, nothing interesting to show and run
				}
			};
			public int getA() { return this.pos.getA()+1; }
			public void b(int[] x, int startIndex, int endIndex) {
				final int testValue = x[(startIndex + this.getA()) - 1];
				if(testValue > 0){
					pos.b(x, startIndex, startIndex + pos.getA());
				} else if(testValue == 0){
					zero.b(x, startIndex, startIndex + zero.getA());
				} else { // The "testValue<0" test is a tautology
					neg.b(x, startIndex, startIndex + neg.getA());
				}
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 5;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 4]; 
				x[startIndex + 4] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 2]; 
				x[startIndex + 2] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				private RPP f = Dec.SINGLETON_Dec;
				private final int a = f.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x, startIndex, endIndex);
				}
				public int getA() { return this.a; }
			};
			public int getA() { return 5; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 0,
					startIndex + (0) + (1)
					);
			}
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new funcH12.H12_v2();
				public int getA() { return function.getA(); }
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
			};
			public int getA() { return 5; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 0,
					startIndex + (0) + (1)
					);
			}
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new arithNat.SubN();
				public int getA() { return function.getA(); }
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
			};
			public int getA() { return 5; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 0,
					startIndex + (0) + (1)
					);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 5;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 1]; 
				x[startIndex + 1] = tmp; 
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