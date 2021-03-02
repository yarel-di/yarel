package parallelTest;
import yarelcore.*;	

public class To_odd implements RPP {
	public To_odd() { }
	
	

	
	public InvTo_odd getInverse(){
		return new InvTo_odd();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // BodyPermImpl
			private final int a = 2;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 1]; 
				x[startIndex + 1] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // BodyForImpl
			/** regular function used when v > 0 */
			RPP function = new RPP() { // SerCompImpl
				private final RPP[] steps = new RPP[]{
					new RPP() { // BodyIncImpl
						private RPP f = Inc.SINGLETON_Inc;
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					},
					
					new RPP() { // BodyIncImpl
						private RPP f = Inc.SINGLETON_Inc;
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
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
			};
			
			/** inverse function used when v < 0 */
			RPP inv_function = new RPP() { // InvSerCompImpl
				private final RPP[] steps = new RPP[]{
					new RPP() { // BodyIncImpl
						private RPP f = InvInc.SINGLETON_InvInc;
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					},
					
					new RPP() { // BodyIncImpl
						private RPP f = InvInc.SINGLETON_InvInc;
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
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
			};
			
			public int getA() { return function.getA()+1; } 
			public void b(int[] x, int startIndex, int endIndex) { //b stands for behaviour and x are the delta and v function parameters
				final int repCounterIndex = (startIndex + this.getA()) - 1, originalRepCounter;
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
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				private RPP f = Inc.SINGLETON_Inc;
				private final int a = f.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x, startIndex, endIndex);
				}
				public int getA() { return this.a; }
			};
			public int getA() { return 2; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 0,
					startIndex + (0) + (1)
					);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 2;
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