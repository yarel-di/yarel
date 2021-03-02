package parametricStuffs;
import yarelcore.*;	

public class NegativeParamWarning implements RPP {
	public NegativeParamWarning(//arities:
		int K, int J
		){
		this.fixedRegistersAmount = 2;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
		
		if(J < 0){ throw new WrongArityException("The arity \"J\" cannot be negative: " + J); }
		this.J = J;
	}
	protected NegativeParamWarning(){
		this(1, 1);
	}
	
	protected final int fixedRegistersAmount;
	protected final int K;
	protected final int J;
	
	
	protected RPP theWholeBody = null;

	
	public InvNegativeParamWarning getInverse(){
		return new InvNegativeParamWarning(this.K, this.J);
	}
	
	public int getA() {
		this.checkTheWholeBody();
		//return this.theWholeBody.getA();
		return this.fixedRegistersAmount + this.K + this.J;
	}
	public void b(int[] x, int startIndex, int endIndex) {
		this.checkTheWholeBody();
		this.theWholeBody.b(x, startIndex, endIndex);
	}
	protected void checkTheWholeBody(){
		if(this.theWholeBody == null){
			this.theWholeBody = new RPP(){
				private final RPP[] steps = new RPP[]{
					new RPP() { // ParCompImpl
						private RPP f = new RPP(){
							private RPP f = Inc.SINGLETON_Inc;
							public int getA() { return 5 + ((-1)*K); }
							public void b(int[] x, int startIndex, int endIndex) {
								int arity = this.getA();
								int __repsAmount__ = 1;
								for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
								for(int __i__ = 0; __i__ < arity; __i__++){
									this.f.b(x, startIndex + __i__, startIndex + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
								} 
								}
							}
						};
						public int getA() { return 2 + (1*K) + (1*J); }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x,
								startIndex + -3 + (1*J) + (1*K),
								startIndex + (-3 + (1*J) + (1*K)) + (5 + ((-1)*K))
								);
						}
					},
					
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
						public int getA() { return 2 + (1*K) + (1*J); }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x,
								startIndex + 0 + (1*J),
								startIndex + (0 + (1*J)) + (2)
								);
						}
					},
					
					new RPP() { // BodySwapImpl
						public int getA() { return 1 + 1 + (1*K) + (1*J); }
						public void b(int[] x, int startIndex, int endIndex) {
							RPP f = new Swap(
								this.getA() - 1, //
								(-1 + (1*K)) - 1, // Yarel's indexes are 1-based
								(-2 + (1*J) + (1*K)) - 1 //
							);
							f.b(x, startIndex, endIndex);
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
		}
	}
}