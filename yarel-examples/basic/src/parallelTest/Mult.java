package parallelTest;
import yarelcore.*;	

public class Mult implements RPP {
	public Mult() { }
	
	public InvMult getInverse(){
		return new InvMult();
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
		
		new RPP() { // BodyForImpl
			/** regular function used when v > 0 */
			RPP function = new RPP() { // BodyForImpl
				/** regular function used when v > 0 */
				RPP function = new RPP() { // BodyIncImpl
					private RPP f = new Inc();
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				
				/** inverse function used when v < 0 */
				RPP inv_function = new RPP() { // InvBodyIncImpl
					private RPP f = new InvInc();
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
			};
			
			/** inverse function used when v < 0 */
			RPP inv_function = new RPP() { // InvBodyForImpl
				/** regular function used when v > 0 */
				RPP function = new RPP() { // BodyIncImpl
					private RPP f = new InvInc();
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				
				/** inverse function used when v < 0 */
				RPP inv_function = new RPP() { // InvBodyIncImpl
					private RPP f = new Inc();
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
		i = -1;
		while( ++i < steps.length ){
			steps[i].b(x, startIndex, endIndex);
		}
	}
}