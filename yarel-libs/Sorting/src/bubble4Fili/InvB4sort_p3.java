package bubble4Fili;
import yarelcore.*;	

public class InvB4sort_p3 implements RPP {
	public InvB4sort_p3() { }
	
	

	
	public B4sort_p3 getInverse(){
		return new B4sort_p3();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new cantorPairing.InvCu();
				public int getA() { return function.getA(); }
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
			};
			public int getA() { return 10; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 4,
					startIndex + (4) + (5)
					);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 10;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 5]; 
				x[startIndex + 5] = x[startIndex + 7]; 
				x[startIndex + 7] = tmp; 
				tmp = x[startIndex + 6]; 
				x[startIndex + 6] = x[startIndex + 8]; 
				x[startIndex + 8] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 10;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 6]; 
				x[startIndex + 6] = x[startIndex + 4]; 
				x[startIndex + 4] = x[startIndex + 2]; 
				x[startIndex + 2] = tmp; 
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 5]; 
				x[startIndex + 5] = x[startIndex + 3]; 
				x[startIndex + 3] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new integerCompare.InvMore();
				public int getA() { return function.getA(); }
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
			};
			public int getA() { return 10; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 2,
					startIndex + (2) + (5)
					);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 10;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 4]; 
				x[startIndex + 4] = x[startIndex + 6]; 
				x[startIndex + 6] = tmp; 
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 5]; 
				x[startIndex + 5] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP pos=new RPP() {
					private final int a = 4;
					public void b(int[] x, int startIndex, int endIndex) {
						int tmp=0;
						tmp = x[startIndex + 0]; 
						x[startIndex + 0] = x[startIndex + 1]; 
						x[startIndex + 1] = tmp; 
					}
					public int getA() { return this.a; }
				};
				RPP zero=new RPP() {
					public int getA() { return 4; }
					public void b(int[] x, int startIndex, int endIndex) {
						// There were only parallels identities, nothing interesting to show and run
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
			};
			public int getA() { return 10; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 0,
					startIndex + (0) + (1)
					);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 10;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 1]; 
				x[startIndex + 1] = tmp; 
				tmp = x[startIndex + 4]; 
				x[startIndex + 4] = x[startIndex + 7]; 
				x[startIndex + 7] = tmp; 
				tmp = x[startIndex + 8]; 
				x[startIndex + 8] = x[startIndex + 9]; 
				x[startIndex + 9] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 10;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 5]; 
				x[startIndex + 5] = x[startIndex + 8]; 
				x[startIndex + 8] = x[startIndex + 6]; 
				x[startIndex + 6] = x[startIndex + 9]; 
				x[startIndex + 9] = x[startIndex + 7]; 
				x[startIndex + 7] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new cantorPairing.Cu();
				public int getA() { return function.getA(); }
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
			};
			public int getA() { return 10; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 5,
					startIndex + (5) + (5)
					);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 10;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 5]; 
				x[startIndex + 5] = x[startIndex + 9]; 
				x[startIndex + 9] = x[startIndex + 8]; 
				x[startIndex + 8] = x[startIndex + 7]; 
				x[startIndex + 7] = x[startIndex + 6]; 
				x[startIndex + 6] = tmp; 
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