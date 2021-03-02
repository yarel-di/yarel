package permuatation;
import yarelcore.*;	

public class ShiftLastToFirst10 implements RPP {
	public ShiftLastToFirst10() { }
	
	

	
	public InvShiftLastToFirst10 getInverse(){
		return new InvShiftLastToFirst10();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				/** regular function used when v > 0 */
				RPP function = new RPP() { // BodyIncImpl
					private RPP f = Inc.SINGLETON_Inc;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				
				/** inverse function used when v < 0 */
				RPP inv_function = new RPP() { // InvBodyIncImpl
					private RPP f = InvInc.SINGLETON_InvInc;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
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
			};
			public int getA() { return 12; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 10,
					startIndex + (10) + (2)
					);
			}
		},
		
		new RPP() { // BodyForImpl
			/** regular function used when v > 0 */
			RPP function = new RPP() { // SerCompImpl
				private final RPP[] steps = new RPP[]{
					new RPP() { // BodyParamPermImpl
						public int getA() { return 1 + 10; }
						public void b(int[] x, int startIndex, int endIndex) {
							final int permutArity = this.getA() - 1;
							int tmp = x[startIndex], indexToWithdraw;
							indexToWithdraw = x[startIndex + permutArity];
							if(indexToWithdraw < 0){ indexToWithdraw = -indexToWithdraw; }
							indexToWithdraw--; // the index is 1-based
							indexToWithdraw = startIndex + (indexToWithdraw % permutArity);
							x[startIndex] = x[indexToWithdraw];
							x[indexToWithdraw] = tmp;
						}
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
						public int getA() { return 11; }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x,
								startIndex + 10,
								startIndex + (10) + (1)
								);
						}
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
					new RPP() { // BodyParamPermImpl
						public int getA() { return 1 + 10; }
						public void b(int[] x, int startIndex, int endIndex) {
							final int permutArity = this.getA() - 1;
							int tmp = x[startIndex], indexToWithdraw;
							indexToWithdraw = x[startIndex + permutArity];
							if(indexToWithdraw < 0){ indexToWithdraw = -indexToWithdraw; }
							indexToWithdraw--; // the index is 1-based
							indexToWithdraw = startIndex + (indexToWithdraw % permutArity);
							x[startIndex] = x[indexToWithdraw];
							x[indexToWithdraw] = tmp;
						}
					},
					
					new RPP() { // ParCompImpl
						private RPP f = new RPP(){
							private RPP f = InvDec.SINGLETON_InvDec;
							private final int a = f.getA();
							public void b(int[] x, int startIndex, int endIndex) {
								this.f.b(x, startIndex, endIndex);
							}
							public int getA() { return this.a; }
						};
						public int getA() { return 11; }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x,
								startIndex + 10,
								startIndex + (10) + (1)
								);
						}
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