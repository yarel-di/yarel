package parametricStuffs;
import yarelcore.*;	

public class SwapNonNative implements RPP {
	public SwapNonNative(//arities:
		int K
		,
		int S,
		int E
		){
		this.fixedRegistersAmount = 1;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
		if(S < 0){ throw new WrongArityException("The parameter \"S\" cannot be negative: " + S); }
		this.S = S;
		if(E < 0){ throw new WrongArityException("The parameter \"E\" cannot be negative: " + E); }
		this.E = E;
	}
	protected SwapNonNative(){
		this(1,0, 0);
	}
	
	protected final int fixedRegistersAmount;
	protected final int K;
	protected final int S;
	
	protected final int E;
	
	public int getK(){ return this.K; }
	public int getS(){ return this.S; }
	
	public int getE(){ return this.E; }
	
	protected RPP theWholeBody = null;

	
	public InvSwapNonNative getInverse(){
		return new InvSwapNonNative(this.K,S, E);
	}
	
	public int getA() {
		this.checkTheWholeBody();
		//return this.theWholeBody.getA();
		return this.fixedRegistersAmount + this.K;
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
							public int getA() { return 1; }
							public void b(int[] x, int startIndex, int endIndex) {
								int arity = this.getA();
								int __repsAmount__ = 0 + (1*E);
								for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
								for(int __i__ = 0; __i__ < arity; __i__++){
									this.f.b(x, startIndex + __i__, startIndex + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
								} 
								}
							}
						};
						public int getA() { return 1 + (1*K); }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x,
								startIndex + 0 + (1*K),
								startIndex + (0 + (1*K)) + (1)
								);
						}
					},
					
					new RPP() { // BodyParamPermImpl
						public int getA() { return 1 + 0 + (1*K); }
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
							public int getA() { return 1; }
							public void b(int[] x, int startIndex, int endIndex) {
								int arity = this.getA();
								int __repsAmount__ = 0 + (1*E);
								for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
								for(int __i__ = 0; __i__ < arity; __i__++){
									this.f.b(x, startIndex + __i__, startIndex + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
								} 
								}
							}
						};
						public int getA() { return 1 + (1*K); }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x,
								startIndex + 0 + (1*K),
								startIndex + (0 + (1*K)) + (1)
								);
						}
					},
					
					new RPP() { // ParCompImpl
						private RPP f = new RPP(){
							private RPP f = Inc.SINGLETON_Inc;
							public int getA() { return 1; }
							public void b(int[] x, int startIndex, int endIndex) {
								int arity = this.getA();
								int __repsAmount__ = 0 + (1*S);
								for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
								for(int __i__ = 0; __i__ < arity; __i__++){
									this.f.b(x, startIndex + __i__, startIndex + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
								} 
								}
							}
						};
						public int getA() { return 1 + (1*K); }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x,
								startIndex + 0 + (1*K),
								startIndex + (0 + (1*K)) + (1)
								);
						}
					},
					
					new RPP() { // BodyParamPermImpl
						public int getA() { return 1 + 0 + (1*K); }
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
							public int getA() { return 1; }
							public void b(int[] x, int startIndex, int endIndex) {
								int arity = this.getA();
								int __repsAmount__ = 0 + (1*S);
								for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
								for(int __i__ = 0; __i__ < arity; __i__++){
									this.f.b(x, startIndex + __i__, startIndex + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
								} 
								}
							}
						};
						public int getA() { return 1 + (1*K); }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x,
								startIndex + 0 + (1*K),
								startIndex + (0 + (1*K)) + (1)
								);
						}
					},
					
					new RPP() { // ParCompImpl
						private RPP f = new RPP(){
							private RPP f = Inc.SINGLETON_Inc;
							public int getA() { return 1; }
							public void b(int[] x, int startIndex, int endIndex) {
								int arity = this.getA();
								int __repsAmount__ = 0 + (1*E);
								for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
								for(int __i__ = 0; __i__ < arity; __i__++){
									this.f.b(x, startIndex + __i__, startIndex + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
								} 
								}
							}
						};
						public int getA() { return 1 + (1*K); }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x,
								startIndex + 0 + (1*K),
								startIndex + (0 + (1*K)) + (1)
								);
						}
					},
					
					new RPP() { // BodyParamPermImpl
						public int getA() { return 1 + 0 + (1*K); }
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
							public int getA() { return 1; }
							public void b(int[] x, int startIndex, int endIndex) {
								int arity = this.getA();
								int __repsAmount__ = 0 + (1*E);
								for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
								for(int __i__ = 0; __i__ < arity; __i__++){
									this.f.b(x, startIndex + __i__, startIndex + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
								} 
								}
							}
						};
						public int getA() { return 1 + (1*K); }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x,
								startIndex + 0 + (1*K),
								startIndex + (0 + (1*K)) + (1)
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
		}
	}
}