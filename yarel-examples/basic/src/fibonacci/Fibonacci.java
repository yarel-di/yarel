package fibonacci;
import yarelcore.*;	

public class Fibonacci implements RPP {
	public Fibonacci() { }
	
	@Override
	public InvFibonacci getInverse(){
		return new InvFibonacci();
	}
	
	RPP l = new RPP() { // SerCompImpl
		RPP l = new RPP() { // SerCompImpl
			RPP l = new RPP() { // SerCompImpl
				RPP l = new RPP() { // SerCompImpl
					RPP l = new RPP() { // ParCompImpl
						private RPP f = new RPP(){
							RPP function = new Fib();
							private final int a = function.getA();
							public void b(int[] x, int startIndex, int endIndex) {
								this.function.b(x, startIndex, endIndex);
							}
							 public int getA() { return this.a; }
						};
						private final int a = 4 ;
						public int getA() { return this.a; }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex + 0, startIndex + this.a + 0);
						}
					};
					RPP r = new RPP() { // BodyPermImpl
						private final int a = 4;
						public void b(int[] x, int startIndex, int endIndex) {
							int tmp=0;
							tmp = x[startIndex + 1]; 
							x[startIndex + 1] = x[startIndex + 2]; 
							x[startIndex + 2] = x[startIndex + 3]; 
							x[startIndex + 3] = tmp; 
						}
						
						public int getA() { return this.a; }
					};
					private final int a = l.getA();
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
						this.l.b(x, startIndex, endIndex);
						this.r.b(x, startIndex, endIndex);
					}
				};
				RPP r = new RPP() { // ParCompImpl
					private RPP f = new RPP(){
						// Iteration start
						RPP function = new RPP() { // BodyIncImpl
							private RPP f = new Inc();
							private final int a = f.getA();
							public void b(int[] x, int startIndex, int endIndex) {
								this.f.b(x, startIndex, endIndex);
							}
							public int getA() { return this.a; }
						};
						private final int a = function.getA()+1;
						public void b(int[] x, int startIndex, int endIndex) {
							int endIndexBody = (startIndex + a) - 1;
							int iterationsLeft = Math.abs(x[endIndexBody]);
							while(iterationsLeft-->0){
								function.b(x, startIndex, endIndexBody);
							}
						}
						public int getA() { return this.a; } 
						// Iteration stop
					};
					private final int a = 4 ;
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex + 2, startIndex + this.a + 2);
					}
				};
				private final int a = l.getA();
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
					this.l.b(x, startIndex, endIndex);
					this.r.b(x, startIndex, endIndex);
				}
			};
			RPP r = new RPP() { // BodyInvImpl
				private final int a = 4;
				public void b(int[] x, int startIndex, int endIndex) {
					int tmp=0;
					tmp = x[startIndex + 1]; 
					x[startIndex + 1] = x[startIndex + 3]; 
					x[startIndex + 3] = x[startIndex + 2]; 
					x[startIndex + 2] = tmp; 
				}
				
				public int getA() { return this.a; }
			};
			private final int a = l.getA();
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
				this.l.b(x, startIndex, endIndex);
				this.r.b(x, startIndex, endIndex);
			}
		};
		RPP r = new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new InvFib();
				private final int a = function.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
				 public int getA() { return this.a; }
			};
			private final int a = 4 ;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex + 0, startIndex + this.a + 0);
			}
		};
		private final int a = l.getA();
		public int getA() { return this.a; }
		public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
			this.l.b(x, startIndex, endIndex);
			this.r.b(x, startIndex, endIndex);
		}
	};
	RPP r = new RPP() { // BodyPermImpl
		private final int a = 4;
		public void b(int[] x, int startIndex, int endIndex) {
			int tmp=0;
			tmp = x[startIndex + 1]; 
			x[startIndex + 1] = x[startIndex + 3]; 
			x[startIndex + 3] = x[startIndex + 2]; 
			x[startIndex + 2] = tmp; 
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