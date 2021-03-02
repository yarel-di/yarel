package parametricStuffs;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// import java.util.function.Supplier;
import yarelcore.*;	

public class ParamSum implements RPP {
	public ParamSum(//arities:
		int K_g, int lel, int I
		){
		this.fixedRegistersAmount = 2;
		if(K_g < 0){ throw new WrongArityException("The arity \"K_g\" cannot be negative: " + K_g); }
		this.K_g = K_g;
		
		if(lel < 0){ throw new WrongArityException("The arity \"lel\" cannot be negative: " + lel); }
		this.lel = lel;
		
		if(I < 0){ throw new WrongArityException("The arity \"I\" cannot be negative: " + I); }
		this.I = I;
	}
	protected ParamSum(){
		this(1, 1, 1);
	}
	
	protected final int fixedRegistersAmount;
	protected final int K_g;
	protected final int lel;
	protected final int I;
	
	
	protected RPP theWholeBody = null;

	/**
	 * Yarel's parallel computation is performed by executing the required subtasks in a parallel context.<br>
	 * Instances of {@link Executors} are "natively" designed for it.<br>
	 * The "WorkStealingPool" strategy is desidered over other due to a easier management and could use up to
	 * the whole amount of processors the underlying machine provides. The previously chosen strategy
	 * "CachedThreadPool" requires to be manually turned off (via invoking {@link ExecutorService#shutdown()}),
	 * which could be tricky to be performed or easily forgotten, blocking the whole program to finish and exit.
	*/
	protected ExecutorService threadPoolExecutor = Executors.newWorkStealingPool(); // needed for parallel computation
	protected void finalize(){
		this.destructorParamSum();
	}
	protected void destructorParamSum(){
		if(threadPoolExecutor != null){
			// threadPoolExecutor.shutdown(); // required only if "newCachedThreadPool" is choosed to instantiate "threadPoolExecutor"
			threadPoolExecutor = null; // mark it as shut-down
		}
	}
	
	public InvParamSum getInverse(){
		return new InvParamSum(this.K_g, this.lel, this.I);
	}
	
	public int getA() {
		this.checkTheWholeBody();
		//return this.theWholeBody.getA();
		return this.fixedRegistersAmount + this.K_g + this.lel + this.I;
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
						/**
						 * Yarel's code is a sequence of instructions, we could name them "code blocks". <br>
						 * Those blocks could be formed by a set of sub-blocks that requires to be executed in a parallel way. <br>
						 * This is the set of those sub-blocks (for a given code block), which are {@link RPP} instances. <br>
						 * The order is preserved from the Yarel source code.
						*/
						private final RPP[] subtasks = new RPP[]{
							new RPP(){ // BodyForImpl
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
							},
							
							
							new RPP(){ // BodyParamIncImpl
								private RPP f = Inc.SINGLETON_Inc;
								public int getA() { return 0 + (1*I); }
								public void b(int[] x, int startIndex, int endIndex) {
									int arity = this.getA();
									int __repsAmount__ = 1;
									for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
									for(int __i__ = 0; __i__ < arity; __i__++){
										this.f.b(x, startIndex + __i__, startIndex + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
									} 
									}
								}
							}
							
						};
						/*
						private final AritySupplier[] startIndexOffsetSuppliers = { //
							() -> { return 0 + (1*K_g);}, //
							() -> { return 2 + (1*lel) + (1*K_g);}
						};
						*/
						private final int[] startIndexOffset = {
							0 + (1*K_g), //
							2 + (1*lel) + (1*K_g)
						};
						public int getA() { return (2 + (1*I) + (1*lel) + (1*K_g)); }
						public void b(int[] x, int startIndex, int endIndex) { // Implements a parallel composition
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
							 * To do this, it's required a <i>semaphore</i>-like object, recording the amount of
							 * "still running tasks", that lets the main thread to sleep and being awakened
							 * when all of those tasks has been completed.<br>
							 * Java's objects (arrays are objects) natively supports this: using the <i>monitor's lock</i>.
							*/
							
							boolean areChildrenRunning = true, neverStarted;
							int startingIndex;
							final int[] semaphore = new int[]{ subtasks.length };
							final Runnable[] tasks = new Runnable[ semaphore[0] ];
						
							// PHASE 1 convert the RPP in runnable tasks
							for(int i = 0; i < tasks.length; i++){
								startingIndex = startIndex + startIndexOffset[i]; // startIndexOffsetSuppliers[i].get();
								tasks[i] = new SubBodyRunner(startingIndex, subtasks[i], x){
									public void run(){
										// execute the main body (delegate inside the superclass implementation)
										super.run();
										
										// after the body execution, manage the semaphore
										synchronized (semaphore) {
											// if all tasks are successfully finished, awake the main thread
											semaphore[0]--;
											semaphore.notifyAll();
										}
									}
								};
								// each tasks performs over their own registers segment, so update the starting point
							}
							neverStarted = true;
							do{
								synchronized (semaphore) {  // acquire the lock, so that the parallel executions must be performed AFTER this thread sleeps.
									if(neverStarted){
										neverStarted = false;
									// PHASE 2: put the "sprinters" at the "race's starting blocks".
										threadPoolExecutor.submit( ()-> {
											/* This runner is the "submitter", which task is to submit all parallel tasks,
												and can't run while the main thread has the lock, because that main thread is still working.
												It's required since this task *could* be concurrently executed BEFORE the main thread sleeps
												due to race conditions.
											*/
											synchronized (semaphore) {
												// the "submitter" can enter this section only after the main thread release the lock (via sleeping)
												for(Runnable t : tasks){ // let's start the tasks
													threadPoolExecutor.submit(t);
												}
											}
										});
									}
									
									areChildrenRunning = semaphore[0] > 0;
									if(areChildrenRunning){
									// PHASE 3: the main thread sleeps and the "parallel sub-tasks" could now (be submitted and) run.
										try {
											/* The "wait" let the main thread to sleep, releasing the lock.
												NOW the submitter can submit the parallel tasks, which can then to be executed.
											*/
											semaphore.wait(); // some child(dren) is(are) still running
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
								}
							} while(areChildrenRunning);
						}
					},
					
					new RPP() { // ParCompImpl
						/**
						 * Yarel's code is a sequence of instructions, we could name them "code blocks". <br>
						 * Those blocks could be formed by a set of sub-blocks that requires to be executed in a parallel way. <br>
						 * This is the set of those sub-blocks (for a given code block), which are {@link RPP} instances. <br>
						 * The order is preserved from the Yarel source code.
						*/
						private final RPP[] subtasks = new RPP[]{
							new RPP(){ // BodyForImpl
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
							},
							
							
							new RPP(){ // BodyParamIncImpl
								private RPP f = Inc.SINGLETON_Inc;
								public int getA() { return 0 + (1*I); }
								public void b(int[] x, int startIndex, int endIndex) {
									int arity = this.getA();
									int __repsAmount__ = 1;
									for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
									for(int __i__ = 0; __i__ < arity; __i__++){
										this.f.b(x, startIndex + __i__, startIndex + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
									} 
									}
								}
							}
							
						};
						/*
						private final AritySupplier[] startIndexOffsetSuppliers = { //
							() -> { return 0 + (1*lel);}, //
							() -> { return 2 + (1*K_g) + (1*lel);}
						};
						*/
						private final int[] startIndexOffset = {
							0 + (1*lel), //
							2 + (1*K_g) + (1*lel)
						};
						public int getA() { return (2 + (1*I) + (1*K_g) + (1*lel)); }
						public void b(int[] x, int startIndex, int endIndex) { // Implements a parallel composition
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
							 * To do this, it's required a <i>semaphore</i>-like object, recording the amount of
							 * "still running tasks", that lets the main thread to sleep and being awakened
							 * when all of those tasks has been completed.<br>
							 * Java's objects (arrays are objects) natively supports this: using the <i>monitor's lock</i>.
							*/
							
							boolean areChildrenRunning = true, neverStarted;
							int startingIndex;
							final int[] semaphore = new int[]{ subtasks.length };
							final Runnable[] tasks = new Runnable[ semaphore[0] ];
						
							// PHASE 1 convert the RPP in runnable tasks
							for(int i = 0; i < tasks.length; i++){
								startingIndex = startIndex + startIndexOffset[i]; // startIndexOffsetSuppliers[i].get();
								tasks[i] = new SubBodyRunner(startingIndex, subtasks[i], x){
									public void run(){
										// execute the main body (delegate inside the superclass implementation)
										super.run();
										
										// after the body execution, manage the semaphore
										synchronized (semaphore) {
											// if all tasks are successfully finished, awake the main thread
											semaphore[0]--;
											semaphore.notifyAll();
										}
									}
								};
								// each tasks performs over their own registers segment, so update the starting point
							}
							neverStarted = true;
							do{
								synchronized (semaphore) {  // acquire the lock, so that the parallel executions must be performed AFTER this thread sleeps.
									if(neverStarted){
										neverStarted = false;
									// PHASE 2: put the "sprinters" at the "race's starting blocks".
										threadPoolExecutor.submit( ()-> {
											/* This runner is the "submitter", which task is to submit all parallel tasks,
												and can't run while the main thread has the lock, because that main thread is still working.
												It's required since this task *could* be concurrently executed BEFORE the main thread sleeps
												due to race conditions.
											*/
											synchronized (semaphore) {
												// the "submitter" can enter this section only after the main thread release the lock (via sleeping)
												for(Runnable t : tasks){ // let's start the tasks
													threadPoolExecutor.submit(t);
												}
											}
										});
									}
									
									areChildrenRunning = semaphore[0] > 0;
									if(areChildrenRunning){
									// PHASE 3: the main thread sleeps and the "parallel sub-tasks" could now (be submitted and) run.
										try {
											/* The "wait" let the main thread to sleep, releasing the lock.
												NOW the submitter can submit the parallel tasks, which can then to be executed.
											*/
											semaphore.wait(); // some child(dren) is(are) still running
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
								}
							} while(areChildrenRunning);
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