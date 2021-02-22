package parallelTest;
import yarelcore.*;	

public class To_odd implements RPP {
	public To_odd() { }
	
	@Override
	public InvTo_odd getInverse(){
		return new InvTo_odd();
	}
	
	RPP l = new RPP() { // SerCompImpl
		RPP l = new RPP() { // SerCompImpl
			RPP l = new RPP() { // BodyPermImpl
				private final int a = 2;
				public void b(int[] x, int startIndex, int endIndex) {
					int tmp=0;
					tmp = x[startIndex + 0]; 
					x[startIndex + 0] = x[startIndex + 1]; 
					x[startIndex + 1] = tmp; 
				}
				
				public int getA() { return this.a; }
			};
			RPP r = new RPP() { // BodyForImpl
				/** regular function used when v > 0 */
				RPP function = new RPP() { // SerCompImpl
					RPP l = new RPP() { // BodyIncImpl
						private RPP f = new Inc();
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					};
					RPP r = new RPP() { // BodyIncImpl
						private RPP f = new Inc();
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
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
				
				/** inverse function used when v < 0 */
				RPP inv_function = new RPP() { // InvSerCompImpl
					RPP l = new RPP() { // BodyIncImpl
						private RPP f = new InvInc();
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					};
					RPP r = new RPP() { // BodyIncImpl
						private RPP f = new InvInc();
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					};
					private final int a = l.getA();
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
						this.r.b(x, startIndex, endIndex);
						this.l.b(x, startIndex, endIndex);
					}
				};
				
				private final int a = function.getA()+1;
				public void b(int[] x, int startIndex, int endIndex) { //b stands for behaviour and x are the delta and v function parameters
					final int repCounterIndex = (startIndex + a) - 1, originalRepCounter;
					int repetitionCounter = x[repCounterIndex];
					originalRepCounter = repetitionCounter;
				
					if(repetitionCounter > 0){ //if v is greater than zero, recursion goes on and v decreases each time
						endIndex = startIndex + function.getA();
						while(repetitionCounter-->0){
							function.b(x, startIndex, repCounterIndex);
							x[repCounterIndex]--;
						}
					}else if(repetitionCounter < 0){ //if v is greater than zero, recursion goes on and v decreases each time
						endIndex = startIndex + inv_function.getA();
						while(repetitionCounter++<0){
							inv_function.b(x, startIndex, repCounterIndex);
							x[repCounterIndex]++;
						}
					} //else: when v is equal to zero, recursive calls stop as a value is returned
					x[repCounterIndex] = originalRepCounter; // restore the original value
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
				private RPP f = new Inc();
				private final int a = f.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x, startIndex, endIndex);
				}
				public int getA() { return this.a; }
			};
			private final int a = 2 ;
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
		private final int a = 2;
		public void b(int[] x, int startIndex, int endIndex) {
			int tmp=0;
			tmp = x[startIndex + 0]; 
			x[startIndex + 0] = x[startIndex + 1]; 
			x[startIndex + 1] = tmp; 
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