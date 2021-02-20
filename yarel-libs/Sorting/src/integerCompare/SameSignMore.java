package integerCompare;
import yarelcore.*;	

public class SameSignMore implements RPP {
	public SameSignMore() { }
	
	public InvSameSignMore getInverse(){
		return new InvSameSignMore();
	}
	
	RPP l = new RPP() { // SerCompImpl
		RPP l = new RPP() { // SerCompImpl
			RPP l = new RPP() { // SerCompImpl
				RPP l = new RPP() { // ParCompImpl
					private RPP f = new RPP(){
						/** regular function used when v > 0 */
						RPP function = new RPP() { // BodyDecImpl
							private RPP f = new Dec();
							private final int a = f.getA();
							public void b(int[] x, int startIndex, int endIndex) {
								this.f.b(x, startIndex, endIndex);
							}
							public int getA() { return this.a; }
						};
						
						/** inverse function used when v < 0 */
						RPP inv_function = new RPP() { // InvBodyDecImpl
							private RPP f = new InvDec();
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
					private final int a = 3 ;
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex + 1, startIndex + this.a + 1);
					}
				};
				RPP r = new RPP() { // BodyPermImpl
					private final int a = 3;
					public void b(int[] x, int startIndex, int endIndex) {
						int tmp=0;
						tmp = x[startIndex + 1]; 
						x[startIndex + 1] = x[startIndex + 2]; 
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
			RPP r = new RPP() { // BodyIfImpl
				RPP pos=new RPP() {
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
				RPP zero=new RPP() {
					private final int a = 2;
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) {
						// There were only parallels identities, nothing interesting to show and run
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
			};
			private final int a = l.getA();
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
				this.l.b(x, startIndex, endIndex);
				this.r.b(x, startIndex, endIndex);
			}
		};
		RPP r = new RPP() { // BodyPermImpl
			private final int a = 3;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 2]; 
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
		private final int a = 3 ;
		public int getA() { return this.a; }
		public void b(int[] x, int startIndex, int endIndex) {
			this.f.b(x, startIndex + 1, startIndex + this.a + 1);
		}
	};
	private final int a = l.getA();
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		this.l.b(x, startIndex, endIndex);
		this.r.b(x, startIndex, endIndex);
	}
}