package bubble4Fili;
import yarelcore.*;	

public class InvB4sort_p2 implements RPP {
	public InvB4sort_p2() { }
	
	public B4sort_p2 getInverse(){
		return new B4sort_p2();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new cantorPairing.InvCu();
				private final int a = function.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
				 public int getA() { return this.a; }
			};
			private final int a = 10 ;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex + 4, startIndex + this.a + 4);
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
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 6]; 
				x[startIndex + 6] = x[startIndex + 4]; 
				x[startIndex + 4] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 5]; 
				x[startIndex + 5] = x[startIndex + 3]; 
				x[startIndex + 3] = tmp; 
			}
			
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new integerCompare.InvMore();
				private final int a = function.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
				 public int getA() { return this.a; }
			};
			private final int a = 10 ;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex + 2, startIndex + this.a + 2);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 10;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 5]; 
				x[startIndex + 5] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 4]; 
				x[startIndex + 4] = x[startIndex + 6]; 
				x[startIndex + 6] = tmp; 
			}
			
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP pos=new RPP() {
					private final int a = 4;
					public void b(int[] x, int startIndex, int endIndex) {
						int tmp=0;
						tmp = x[startIndex + 1]; 
						x[startIndex + 1] = x[startIndex + 2]; 
						x[startIndex + 2] = tmp; 
					}
					
					public int getA() { return this.a; }
				};
				RPP zero=new RPP() {
					private final int a = 4;
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) {
						// There were only parallels identities, nothing interesting to show and run
					}
				};
				RPP neg=new RPP() {
					private final int a = 4;
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) {
						// There were only parallels identities, nothing interesting to show and run
					}
				};
				private final int a=pos.getA()+1;
				public int getA() {return this.a;}
				public void b(int[] x, int startIndex, int endIndex) {
					final int testValue = x[(startIndex + a) - 1];
					if(testValue > 0){
						pos.b(x, startIndex, startIndex + pos.getA());
					} else if(testValue == 0){
						zero.b(x, startIndex, startIndex + zero.getA());
					} else { // The "testValue<0" test is a tautology
						neg.b(x, startIndex, startIndex + neg.getA());
					}
				}
			};
			private final int a = 10 ;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex + 0, startIndex + this.a + 0);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 10;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 2]; 
				x[startIndex + 2] = tmp; 
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
				private final int a = function.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
				 public int getA() { return this.a; }
			};
			private final int a = 10 ;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex + 5, startIndex + this.a + 5);
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
	private final int a = steps[0].getA();
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		int i;
		i = steps.length;
		while( i-->0 ){
			steps[i].b(x, startIndex, endIndex);
		}
	}
}