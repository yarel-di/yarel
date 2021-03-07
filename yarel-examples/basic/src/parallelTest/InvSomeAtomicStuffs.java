package parallelTest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// import java.util.function.Supplier;
import yarelcore.*;	

public class InvSomeAtomicStuffs implements RPP {
	public InvSomeAtomicStuffs() { }
	
	
	

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
		this.destructorSomeAtomicStuffs();
	}
	protected void destructorSomeAtomicStuffs(){
		if(__threadPoolExecutor__ != null){
			// __threadPoolExecutor__.shutdown(); // required only if "newCachedThreadPool" is choosed to instantiate "threadPoolExecutor"
			__threadPoolExecutor__ = null; // mark it as shut-down
		}
	}
	
	public SomeAtomicStuffs getInverse(){
		return new SomeAtomicStuffs();
	}
	
	/**
	 * Yarel's code is a sequence of instructions, we could name them "code blocks". <br>
	 * Those blocks could be formed by a set of sub-blocks that requires to be executed in a parallel way. <br>
	 * This is the set of those sub-blocks (for a given code block), which are {@link RPP} instances. <br>
	 * The order is preserved from the Yarel source code.
	*/
	private final RPP[] __subtasks__ = new RPP[]{
		new RPP(){ // BodyIncImpl
			private RPP __f__ = InvInc.SINGLETON_InvInc;
			private final int __a__ = __f__.getA();
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__, __startIndex__, __endIndex__);
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP(){ // BodyDecImpl
			private RPP __f__ = InvDec.SINGLETON_InvDec;
			private final int __a__ = __f__.getA();
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__, __startIndex__, __endIndex__);
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP(){ // SerCompImpl
			private final RPP[] __steps__ = new RPP[]{
				new RPP() { // BodyItImpl
					// Iteration start
					RPP __function__ = new RPP() { // BodyIncImpl
						private RPP __f__ = InvInc.SINGLETON_InvInc;
						private final int __a__ = __f__.getA();
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__, __startIndex__, __endIndex__);
						}
						public int getA() { return this.__a__; }
					};
					public int getA() { return __function__.getA()+1; }
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						int __endIndexBody__ = (__startIndex__ + this.getA()) - 1;
						int __iterationsLeft__ = Math.abs(__x__[__endIndexBody__]);
						while(__iterationsLeft__-->0){
							__function__.b(__x__, __startIndex__, __endIndexBody__);
						}
					}
					// Iteration stop
				},
				
				new RPP() { // ParCompImpl
					private RPP __f__ = new RPP(){
						private RPP __f__ = InvNeg.SINGLETON_InvNeg;
						private final int __a__ = __f__.getA();
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__, __startIndex__, __endIndex__);
						}
						public int getA() { return this.__a__; }
					};
					public int getA() { return 2; }
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__,
							__startIndex__ + 0,
							__startIndex__ + (0) + this.__f__.getA()
							);
					}
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
		
		new RPP(){ // BodyNegImpl
			private RPP __f__ = InvNeg.SINGLETON_InvNeg;
			private final int __a__ = __f__.getA();
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__, __startIndex__, __endIndex__);
			}
			public int getA() { return this.__a__; }
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
		}
	};
	/*
	private final AritySupplier[] __startIndexOffsetSuppliers__ = { //
		() -> { return 0;}, //
		() -> { return 1;}, //
		() -> { return 3;}, //
		() -> { return 5;}, //
		() -> { return 6;}
	};
	*/
	private final int[] __startIndexOffset__ = {
		0, //
		1, //
		3, //
		5, //
		6
	};
	public int getA() { return (7); }
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
}