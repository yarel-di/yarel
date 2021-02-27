package fibonacci;
import yarelcore.*;	

public class InvFib implements RPP {
	public InvFib() { }
	
	public Fib getInverse(){
		return new Fib();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // BodyPermImpl
			private final int a = 3;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 2]; 
				x[startIndex + 2] = tmp; 
			}
			
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				private RPP f = InvInc.SINGLETON_InvInc;
				private final int a = f.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x, startIndex, endIndex);
				}
				public int getA() { return this.a; }
			};
			private final int a = 3 ;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex + 0, startIndex + this.a + 0);
			}
		},
		
		new RPP() { // BodyItImpl
			// Iteration start
			RPP function = new RPP() { // SerCompImpl
				private final RPP[] steps = new RPP[]{
					new RPP() { // BodyForImpl
						/** regular function used when v > 0 */
						RPP function = new RPP() { // BodyIncImpl
							private RPP f = InvInc.SINGLETON_InvInc;
							private final int a = f.getA();
							public void b(int[] x, int startIndex, int endIndex) {
								this.f.b(x, startIndex, endIndex);
							}
							public int getA() { return this.a; }
						};
						
						/** inverse function used when v < 0 */
						RPP inv_function = new RPP() { // InvBodyIncImpl
							private RPP f = Inc.SINGLETON_Inc;
							private final int a = f.getA();
							public void b(int[] x, int startIndex, int endIndex) {
								this.f.b(x, startIndex, endIndex);
							}
							public int getA() { return this.a; }
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
				private final int a = steps[0].getA();
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
					int i;
					i = steps.length;
					while( i-->0 ){
						steps[i].b(x, startIndex, endIndex);
					}
				}
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
		},
		
		new RPP() { // BodyIfImpl
			RPP pos=new RPP() {
				private final int a = 2;
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) {
					// There were only parallels identities, nothing interesting to show and run
				}
			};
			RPP zero=new RPP() {
				private RPP f = new RPP(){
					private RPP f = InvDec.SINGLETON_InvDec;
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
			RPP neg=new RPP() {
				private final int a = 2;
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
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 3;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 2]; 
				x[startIndex + 2] = tmp; 
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