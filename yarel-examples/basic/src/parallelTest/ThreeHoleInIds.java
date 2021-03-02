package parallelTest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// import java.util.function.Supplier;
import yarelcore.*;	

public class ThreeHoleInIds implements RPP {
	public ThreeHoleInIds() { }
	
	

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
		this.destructorThreeHoleInIds();
	}
	protected void destructorThreeHoleInIds(){
		if(threadPoolExecutor != null){
			// threadPoolExecutor.shutdown(); // required only if "newCachedThreadPool" is choosed to instantiate "threadPoolExecutor"
			threadPoolExecutor = null; // mark it as shut-down
		}
	}
	
	public InvThreeHoleInIds getInverse(){
		return new InvThreeHoleInIds();
	}
	
	/**
	 * Yarel's code is a sequence of instructions, we could name them "code blocks". <br>
	 * Those blocks could be formed by a set of sub-blocks that requires to be executed in a parallel way. <br>
	 * This is the set of those sub-blocks (for a given code block), which are {@link RPP} instances. <br>
	 * The order is preserved from the Yarel source code.
	*/
	private final RPP[] subtasks = new RPP[]{
		new RPP(){ // SerCompImpl
			private final RPP[] steps = new RPP[]{
				new RPP() { // BodyPermImpl
					private final int a = 3;
					public void b(int[] x, int startIndex, int endIndex) {
						int tmp=0;
						tmp = x[startIndex + 0]; 
						x[startIndex + 0] = x[startIndex + 1]; 
						x[startIndex + 1] = x[startIndex + 2]; 
						x[startIndex + 2] = tmp; 
					}
					public int getA() { return this.a; }
				},
				
				new RPP() { // BodyFunImpl
					RPP function = new Empty3();
					public int getA() { return function.getA(); }
					public void b(int[] x, int startIndex, int endIndex) {
						this.function.b(x, startIndex, endIndex);
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
		},
		
		new RPP(){ // BodyForImpl
			/** regular function used when v > 0 */
			RPP function = new RPP() { // BodyForImpl
				/** regular function used when v > 0 */
				RPP function = new RPP() { // BodyDecImpl
					private RPP f = Dec.SINGLETON_Dec;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				
				/** inverse function used when v < 0 */
				RPP inv_function = new RPP() { // InvBodyDecImpl
					private RPP f = InvDec.SINGLETON_InvDec;
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
			
			/** inverse function used when v < 0 */
			RPP inv_function = new RPP() { // InvBodyForImpl
				/** regular function used when v > 0 */
				RPP function = new RPP() { // BodyDecImpl
					private RPP f = InvDec.SINGLETON_InvDec;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				
				/** inverse function used when v < 0 */
				RPP inv_function = new RPP() { // InvBodyDecImpl
					private RPP f = Dec.SINGLETON_Dec;
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
		
		new RPP(){ // BodyFunImpl
			RPP function = new Empty2();
			public int getA() { return function.getA(); }
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
		}
	};
	/*
	private final AritySupplier[] startIndexOffsetSuppliers = { //
		() -> { return 2;}, //
		() -> { return 6;}, //
		() -> { return 10;}
	};
	*/
	private final int[] startIndexOffset = {
		2, //
		6, //
		10
	};
	public int getA() { return (13); }
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