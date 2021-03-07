package parametricStuffs;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// import java.util.function.Supplier;
import yarelcore.*;	

public class InvDoubleSwapSomewhere implements RPP {
	public InvDoubleSwapSomewhere(//arities:
		int a, int B
		){
		this.__fixedRegistersAmount__ = 7;
		if(a < 0){ throw new WrongArityException("The arity \"a\" cannot be negative: " + a); }
		this.a = a;
		if(B < 0){ throw new WrongArityException("The arity \"B\" cannot be negative: " + B); }
		this.B = B;
	}
	protected InvDoubleSwapSomewhere(){
		this(1, 1);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int a;
	protected final int B;
	
	
	
	protected RPP __theWholeBody__ = null;

	/**
	 * Yarel's parallel computation is performed by executing the required subtasks in a parallel context.<br>
	 * Instances of {@link Executors} are "natively" designed for it.<br>
	 * The "WorkStealingPool" strategy is desidered over other due to a easier management and could use up to
	 * the whole amount of processors the underlying machine provides. The previously chosen strategy
	 * "CachedThreadPool" requires to be manually turned off (via invoking {@link ExecutorService#shutdown()}),
	 * which could be tricky to be performed or easily forgotten, blocking the whole program to finish and exit.
	*/
	protected ExecutorService __threadPoolExecutor__ = Executors.newWorkStealingPool(); // needed for parallel computation
	protected void finalize(){
		this.destructorDoubleSwapSomewhere();
	}
	protected void destructorDoubleSwapSomewhere(){
		if(__threadPoolExecutor__ != null){
			// __threadPoolExecutor__.shutdown(); // required only if "newCachedThreadPool" is choosed to instantiate "threadPoolExecutor"
			__threadPoolExecutor__ = null; // mark it as shut-down
		}
	}
	
	public DoubleSwapSomewhere getInverse(){
		return new DoubleSwapSomewhere(this.a, this.B);
	}
	
	public int getA() {
		this.checkTheWholeBody();
		//return this.__theWholeBody__.getA();
		return this.__fixedRegistersAmount__ + this.a + this.B;
	}
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.checkTheWholeBody();
		this.__theWholeBody__.b(__x__, __startIndex__, __endIndex__);
	}
	protected void checkTheWholeBody(){
		if(this.__theWholeBody__ == null){
			this.__theWholeBody__ = new RPP(){
				/**
				 * Yarel's code is a sequence of instructions, we could name them "code blocks". <br>
				 * Those blocks could be formed by a set of sub-blocks that requires to be executed in a parallel way. <br>
				 * This is the set of those sub-blocks (for a given code block), which are {@link RPP} instances. <br>
				 * The order is preserved from the Yarel source code.
				*/
				private final RPP[] __subtasks__ = new RPP[]{
					new RPP(){ // BodyDecImpl
						private RPP __f__ = InvDec.SINGLETON_InvDec;
						private final int __a__ = __f__.getA();
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__, __startIndex__, __endIndex__);
						}
						public int getA() { return this.__a__; }
					},
					
					new RPP(){ // BodySwapImpl
						public int getA() { return 0 + (1*a); } // "1 +" is removed
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							int __arity__ = this.getA(); // "- 1" is removed
							RPP __f__ = new InvSwap( // Swap itselfwill adjust indexes on arity
								__arity__, //
								(2), //
								(-2 + (1*a))//
							);
							__f__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP(){ // BodyForImpl
						/** regular function used when v > 0 */
						RPP __function__ = new RPP() { // SerCompImpl
							private final RPP[] __steps__ = new RPP[]{
								new RPP() { // BodyIncImpl
									private RPP __f__ = InvInc.SINGLETON_InvInc;
									private final int __a__ = __f__.getA();
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__, __startIndex__, __endIndex__);
									}
									public int getA() { return this.__a__; }
								},
								
								new RPP() { // BodyIncImpl
									private RPP __f__ = InvInc.SINGLETON_InvInc;
									private final int __a__ = __f__.getA();
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__, __startIndex__, __endIndex__);
									}
									public int getA() { return this.__a__; }
								}
							};
							public int getA() { return this.__steps__[0].getA(); }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
								int __i__;
								__i__ = __steps__.length;
								while( __i__-->0 ){
									__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
								}
							}
						};
						
						/** inverse function used when v < 0 */
						RPP __inv_function__ = new RPP() { // InvSerCompImpl
							private final RPP[] __steps__ = new RPP[]{
								new RPP() { // BodyIncImpl
									private RPP __f__ = Inc.SINGLETON_Inc;
									private final int __a__ = __f__.getA();
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__, __startIndex__, __endIndex__);
									}
									public int getA() { return this.__a__; }
								},
								
								new RPP() { // BodyIncImpl
									private RPP __f__ = Inc.SINGLETON_Inc;
									private final int __a__ = __f__.getA();
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__, __startIndex__, __endIndex__);
									}
									public int getA() { return this.__a__; }
								}
							};
							public int getA() { return this.__steps__[0].getA(); }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
								int __i__;
								__i__ = -1;
								while( ++__i__ < __steps__.length ){
									__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
								}
							}
						};
						
						public int getA() { return __function__.getA()+1; } 
						public void b(int[] __x__, int __startIndex__, int __endIndex__) { //b stands for behaviour and x are the delta and v function parameters
							final int __repCounterIndex__ = (__startIndex__ + this.getA()) - 1, __originalRepCounter__;
							int __repetitionCounter__ = __x__[__repCounterIndex__];
							__originalRepCounter__ = __repetitionCounter__;
						
							if(__repetitionCounter__ > 0){ //if v is greater than zero, recursion goes on and v decreases each time
								__endIndex__ = __startIndex__ + __function__.getA();
								while(__repetitionCounter__-->0){
									__function__.b(__x__, __startIndex__, __repCounterIndex__);
									__x__[__repCounterIndex__]--;
								}
							}else if(__repetitionCounter__ < 0){ //if v is greater than zero, recursion goes on and v decreases each time
								__endIndex__ = __startIndex__ + __inv_function__.getA();
								while(__repetitionCounter__++<0){
									__inv_function__.b(__x__, __startIndex__, __repCounterIndex__);
									__x__[__repCounterIndex__]++;
								}
							} //else: when v is equal to zero, recursive calls stop as a value is returned
							__x__[__repCounterIndex__] = __originalRepCounter__; // restore the original value
						}
					},
					
					new RPP(){ // BodyFunImpl
						RPP __function__ = new InvSwapSRLlike(
							0 + (1*B)
							,
							3,
							-3 + (1*B)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP(){ // SerCompImpl
						private final RPP[] __steps__ = new RPP[]{
							new RPP() { // BodyIncImpl
								private RPP __f__ = InvInc.SINGLETON_InvInc;
								private final int __a__ = __f__.getA();
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__, __startIndex__, __endIndex__);
								}
								public int getA() { return this.__a__; }
							},
							
							new RPP() { // BodyNegImpl
								private RPP __f__ = InvNeg.SINGLETON_InvNeg;
								private final int __a__ = __f__.getA();
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__, __startIndex__, __endIndex__);
								}
								public int getA() { return this.__a__; }
							}
						};
						public int getA() { return this.__steps__[0].getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
							int __i__;
							__i__ = __steps__.length;
							while( __i__-->0 ){
								__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
							}
						}
					},
					
					new RPP(){ // BodyParamIncImpl
						private RPP __f__ = InvInc.SINGLETON_InvInc;
						public int getA() { return 1; }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							int __arity__;
							int __repsAmount__ = 0 + (1*a) + (1*B);
							while(__repsAmount__-->0){
							__arity__ = this.getA();
							while(__arity__-->0){
								this.__f__.b(__x__, __startIndex__ + __arity__, __startIndex__ + __arity__ + 1); // "1" because "f.getA()" will surely returns "1"
							}
							}
						}
					}
				};
				/*
				private final AritySupplier[] __startIndexOffsetSuppliers__ = { //
					() -> { return 0;}, //
					() -> { return 2;}, //
					() -> { return 2 + (1*a);}, //
					() -> { return 4 + (1*a);}, //
					() -> { return 5 + (1*B) + (1*a);}, //
					() -> { return 6 + (1*B) + (1*a);}
				};
				*/
				private final int[] __startIndexOffset__ = {
					0, //
					2, //
					2 + (1*a), //
					4 + (1*a), //
					5 + (1*B) + (1*a), //
					6 + (1*B) + (1*a)
				};
				public int getA() { return (7 + (1*B) + (1*a)); }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a parallel composition
					/**
					 * The Yarel's compiled code runs on a single {@link Thread}, which We could name
					 * as "the main thread", executing sequentially a "block" of code after the other.<br>
					 * The easiest way to parallelize the "sub-blocks" of a given block is run them
					 * in separated threads and letting the main thread wait all of their terminations.
					 * <p>
					 * The parallel composition execution is divided in 3 parts:
					 * <ol>
					 * <li>
					 * Conversion of {@link RPP} (the sub-operators into a literally {@link Runnable} task,
					 * ready to be run.
					 * </li>
					 * <li>
					 * Makes those tasks ready to be run. To help imaging that, let's use a metaphore: <br>
					 * all tasks are sprinters (human runners) at starting blocks, waiting the referee (the main thread)
					 * to fire the gun to indicate that the race has started.
					 * </li>t
					 * <li>
					 * The main thread (the "referee") sleeps, waiting the tasks to be completed.
					 * </li>
					 * </ol>
					 * <p>
					 * To do this, it's required a <i>__semaphore__</i>-like object, recording the amount of
					 * "still running tasks", that lets the main thread to sleep and being awakened
					 * when all of those tasks has been completed.<br>
					 * Java's objects (arrays are objects) natively supports this: using the <i>monitor's lock</i>.
					*/
					
					boolean __areChildrenRunning__ = true, __neverStarted__;
					int __startingIndex__;
					final int[] __semaphore__ = new int[]{ __subtasks__.length };
					final Runnable[] __tasks__ = new Runnable[ __semaphore__[0] ];
				
					// PHASE 1 convert the RPP in runnable tasks
					for(int __i__ = 0; __i__ < __tasks__.length; __i__++){
						__startingIndex__ = __startIndex__ + __startIndexOffset__[__i__]; // __startIndexOffsetSuppliers__[__i__].get();
						__tasks__[__i__] = new SubBodyRunner(__startingIndex__, __subtasks__[__i__], __x__){
							public void run(){
								// execute the main body (delegate inside the superclass implementation)
								super.run();
								
								// after the body execution, manage the __semaphore__
								synchronized (__semaphore__) {
									// if all tasks are successfully finished, awake the main thread
									__semaphore__[0]--;
									__semaphore__.notifyAll();
								}
							}
						};
						// each tasks performs over their own registers segment, so update the starting point
					}
					__neverStarted__ = true;
					do{
						synchronized (__semaphore__) {  // acquire the lock, so that the parallel executions must be performed AFTER this thread sleeps.
							if(__neverStarted__){
								__neverStarted__ = false;
							// PHASE 2: put the "sprinters" at the "race's starting blocks".
								__threadPoolExecutor__.submit( ()-> {
									/* This runner is the "submitter", which task is to submit all parallel tasks,
										and can't run while the main thread has the lock, because that main thread is still working.
										It's required since this task *could* be concurrently executed BEFORE the main thread sleeps
										due to race conditions.
									*/
									synchronized (__semaphore__) {
										// the "submitter" can enter this section only after the main thread release the lock (via sleeping)
										for(Runnable __t__ : __tasks__){ // let's start the tasks
											__threadPoolExecutor__.submit(__t__);
										}
									}
								});
							}
							
							__areChildrenRunning__ = __semaphore__[0] > 0;
							if(__areChildrenRunning__){
							// PHASE 3: the main thread sleeps and the "parallel sub-tasks" could now (be submitted and) run.
								try {
									/* The "wait" let the main thread to sleep, releasing the lock.
										NOW the submitter can submit the parallel tasks, which can then to be executed.
									*/
									__semaphore__.wait(); // some child(dren) is(are) still running
								} catch (InterruptedException __e__) {
									__e__.printStackTrace();
								}
							}
						}
					} while(__areChildrenRunning__);
				}
			};
		}
	}
}