package sorting;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// import java.util.function.Supplier;
import yarelcore.*;	

public class SortGrowing implements RPP {
	public SortGrowing(//arities:
		int K
		){
		this.__fixedRegistersAmount__ = 11;
		if(K < 0){ throw new WrongArityException("The arity \"K\" cannot be negative: " + K); }
		this.K = K;
	}
	protected SortGrowing(){
		this(1);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int K;
	
	
	
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
		this.destructorSortGrowing();
	}
	protected void destructorSortGrowing(){
		if(__threadPoolExecutor__ != null){
			// __threadPoolExecutor__.shutdown(); // required only if "newCachedThreadPool" is choosed to instantiate "threadPoolExecutor"
			__threadPoolExecutor__ = null; // mark it as shut-down
		}
	}
	
	public InvSortGrowing getInverse(){
		return new InvSortGrowing(this.K);
	}
	
	public int getA() {
		this.checkTheWholeBody();
		//return this.__theWholeBody__.getA();
		return this.__fixedRegistersAmount__ + this.K;
	}
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.checkTheWholeBody();
		this.__theWholeBody__.b(__x__, __startIndex__, __endIndex__);
	}
	protected void checkTheWholeBody(){
		if(this.__theWholeBody__ == null){
			this.__theWholeBody__ = new RPP(){
				private final RPP[] __steps__ = new RPP[]{
					new RPP() { // ParCompImpl // index: 0
						/**
						 * Yarel's code is a sequence of instructions, we could name them "code blocks". <br>
						 * Those blocks could be formed by a set of sub-blocks that requires to be executed in a parallel way. <br>
						 * This is the set of those sub-blocks (for a given code block), which are {@link RPP} instances. <br>
						 * The order is preserved from the Yarel source code.
						*/
						private final RPP[] __subtasks__ = new RPP[]{
							new RPP(){ // BodyIncImpl // index: 0
								private RPP __f__ = Inc.SINGLETON_Inc;
								private final int __a__ = __f__.getA();
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__, __startIndex__, __endIndex__);
								}
								public int getA() { return this.__a__; }
							},
							
							new RPP(){ // BodyParamIncImpl // index: 1
								private RPP __f__ = Inc.SINGLETON_Inc;
								public int getA() { return 1; }
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									int __arity__;
									int __repsAmount__ = -1 + (1*K);
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
							() -> { return 9 + (1*K);}, //
							() -> { return 10 + (1*K);}
						};
						*/
						private final int[] __startIndexOffset__ = {
							9 + (1*K), //
							10 + (1*K)
						};
						public int getA() { return (11 + (1*K)); }
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
					},
					
					new RPP() { // BodyItImpl // index: 1
						// Iteration start
						RPP __function__ = new RPP() { // SerCompImpl
							private final RPP[] __steps__ = new RPP[]{
								new RPP() { // BodyItImpl // index: 0
									// Iteration start
									RPP __function__ = new RPP() { // SerCompImpl
										private final RPP[] __steps__ = new RPP[]{
											new RPP() { // ParCompImpl // index: 0
												private RPP __f__ = new RPP(){
													private RPP __f__ = Inc.SINGLETON_Inc;
													private final int __a__ = __f__.getA();
													public void b(int[] __x__, int __startIndex__, int __endIndex__) {
														this.__f__.b(__x__, __startIndex__, __endIndex__);
													}
													public int getA() { return this.__a__; }
												};
												public int getA() { return 9 + (1*K); }
												public void b(int[] __x__, int __startIndex__, int __endIndex__) {
													this.__f__.b(__x__,
														__startIndex__ + 8 + (1*K),
														__startIndex__ + (8 + (1*K)) + this.__f__.getA()
														);
												}
											},
											
											new RPP() { // ParCompImpl // index: 1
												private RPP __f__ = new RPP(){
													private final int __a__ = 6;
													public void b(int[] __x__, int __startIndex__, int __endIndex__) {
														int __tmp__=0;
														__tmp__ = __x__[__startIndex__ + 0]; 
														__x__[__startIndex__ + 0] = __x__[__startIndex__ + 5]; 
														__x__[__startIndex__ + 5] = __x__[__startIndex__ + 1]; 
														__x__[__startIndex__ + 1] = __x__[__startIndex__ + 4]; 
														__x__[__startIndex__ + 4] = __tmp__; 
													}
													public int getA() { return this.__a__; }
												};
												public int getA() { return 9 + (1*K); }
												public void b(int[] __x__, int __startIndex__, int __endIndex__) {
													this.__f__.b(__x__,
														__startIndex__ + 3 + (1*K),
														__startIndex__ + (3 + (1*K)) + this.__f__.getA()
														);
												}
											},
											
											new RPP() { // ParCompImpl // index: 2
												private RPP __f__ = new RPP(){
													RPP __function__ = new SortPreComparisonPart(
														0 + (1*K)
													);
													public int getA() { return __function__.getA(); }
													public void b(int[] __x__, int __startIndex__, int __endIndex__) {
														this.__function__.b(__x__, __startIndex__, __endIndex__);
													}
												};
												public int getA() { return 9 + (1*K); }
												public void b(int[] __x__, int __startIndex__, int __endIndex__) {
													this.__f__.b(__x__,
														__startIndex__ + 0,
														__startIndex__ + (0) + this.__f__.getA()
														);
												}
											},
											
											new RPP() { // ParCompImpl // index: 3
												private RPP __f__ = new RPP(){
													private final int __a__ = 9;
													public void b(int[] __x__, int __startIndex__, int __endIndex__) {
														int __tmp__=0;
														__tmp__ = __x__[__startIndex__ + 0]; 
														__x__[__startIndex__ + 0] = __x__[__startIndex__ + 5]; 
														__x__[__startIndex__ + 5] = __x__[__startIndex__ + 2]; 
														__x__[__startIndex__ + 2] = __x__[__startIndex__ + 7]; 
														__x__[__startIndex__ + 7] = __x__[__startIndex__ + 4]; 
														__x__[__startIndex__ + 4] = __x__[__startIndex__ + 1]; 
														__x__[__startIndex__ + 1] = __x__[__startIndex__ + 6]; 
														__x__[__startIndex__ + 6] = __x__[__startIndex__ + 3]; 
														__x__[__startIndex__ + 3] = __tmp__; 
													}
													public int getA() { return this.__a__; }
												};
												public int getA() { return 9 + (1*K); }
												public void b(int[] __x__, int __startIndex__, int __endIndex__) {
													this.__f__.b(__x__,
														__startIndex__ + 0 + (1*K),
														__startIndex__ + (0 + (1*K)) + this.__f__.getA()
														);
												}
											},
											
											new RPP() { // ParCompImpl // index: 4
												private RPP __f__ = new RPP(){
													RPP __function__ = new integerCompare.More();
													public int getA() { return __function__.getA(); }
													public void b(int[] __x__, int __startIndex__, int __endIndex__) {
														this.__function__.b(__x__, __startIndex__, __endIndex__);
													}
												};
												public int getA() { return 9 + (1*K); }
												public void b(int[] __x__, int __startIndex__, int __endIndex__) {
													this.__f__.b(__x__,
														__startIndex__ + 0 + (1*K),
														__startIndex__ + (0 + (1*K)) + this.__f__.getA()
														);
												}
											},
											
											new RPP() { // ParCompImpl // index: 5
												private RPP __f__ = new RPP(){
													private final int __a__ = 9;
													public void b(int[] __x__, int __startIndex__, int __endIndex__) {
														int __tmp__=0;
														__tmp__ = __x__[__startIndex__ + 0]; 
														__x__[__startIndex__ + 0] = __x__[__startIndex__ + 3]; 
														__x__[__startIndex__ + 3] = __x__[__startIndex__ + 5]; 
														__x__[__startIndex__ + 5] = __x__[__startIndex__ + 7]; 
														__x__[__startIndex__ + 7] = __x__[__startIndex__ + 2]; 
														__x__[__startIndex__ + 2] = __tmp__; 
														__tmp__ = __x__[__startIndex__ + 1]; 
														__x__[__startIndex__ + 1] = __x__[__startIndex__ + 4]; 
														__x__[__startIndex__ + 4] = __x__[__startIndex__ + 6]; 
														__x__[__startIndex__ + 6] = __tmp__; 
													}
													public int getA() { return this.__a__; }
												};
												public int getA() { return 9 + (1*K); }
												public void b(int[] __x__, int __startIndex__, int __endIndex__) {
													this.__f__.b(__x__,
														__startIndex__ + 0 + (1*K),
														__startIndex__ + (0 + (1*K)) + this.__f__.getA()
														);
												}
											},
											
											new RPP() { // ParCompImpl // index: 6
												private RPP __f__ = new RPP(){
													RPP __pos__=new RPP() {
														private final int __a__ = 2;
														public void b(int[] __x__, int __startIndex__, int __endIndex__) {
															int __tmp__=0;
															__tmp__ = __x__[__startIndex__ + 0]; 
															__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
															__x__[__startIndex__ + 1] = __tmp__; 
														}
														public int getA() { return this.__a__; }
													};
													RPP __zero__=new RPP() {
														public int getA() { return 2; }
														public void b(int[] __x__, int __startIndex__, int __endIndex__) {
															// There were only parallels identities, nothing interesting to show and run
														}
													};
													RPP __neg__=new RPP() {
														public int getA() { return 2; }
														public void b(int[] __x__, int __startIndex__, int __endIndex__) {
															// There were only parallels identities, nothing interesting to show and run
														}
													};
													public int getA() { return this.__pos__.getA()+1; }
													public void b(int[] __x__, int __startIndex__, int __endIndex__) {
														final int __testValue__ = __x__[(__startIndex__ + this.getA()) - 1];
														if(__testValue__ > 0){
															__pos__.b(__x__, __startIndex__, __startIndex__ + __pos__.getA());
														} else if(__testValue__ == 0){
															__zero__.b(__x__, __startIndex__, __startIndex__ + __zero__.getA());
														} else { // The "__testValue__<0" test is a tautology
															__neg__.b(__x__, __startIndex__, __startIndex__ + __neg__.getA());
														}
													}
												};
												public int getA() { return 9 + (1*K); }
												public void b(int[] __x__, int __startIndex__, int __endIndex__) {
													this.__f__.b(__x__,
														__startIndex__ + 0 + (1*K),
														__startIndex__ + (0 + (1*K)) + this.__f__.getA()
														);
												}
											},
											
											new RPP() { // ParCompImpl // index: 7
												private RPP __f__ = new RPP(){
													private final int __a__ = 7;
													public void b(int[] __x__, int __startIndex__, int __endIndex__) {
														int __tmp__=0;
														__tmp__ = __x__[__startIndex__ + 0]; 
														__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
														__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
														__x__[__startIndex__ + 2] = __x__[__startIndex__ + 3]; 
														__x__[__startIndex__ + 3] = __tmp__; 
													}
													public int getA() { return this.__a__; }
												};
												public int getA() { return 9 + (1*K); }
												public void b(int[] __x__, int __startIndex__, int __endIndex__) {
													this.__f__.b(__x__,
														__startIndex__ + 2 + (1*K),
														__startIndex__ + (2 + (1*K)) + this.__f__.getA()
														);
												}
											},
											
											new RPP() { // ParCompImpl // index: 8
												/**
												 * Yarel's code is a sequence of instructions, we could name them "code blocks". <br>
												 * Those blocks could be formed by a set of sub-blocks that requires to be executed in a parallel way. <br>
												 * This is the set of those sub-blocks (for a given code block), which are {@link RPP} instances. <br>
												 * The order is preserved from the Yarel source code.
												*/
												private final RPP[] __subtasks__ = new RPP[]{
													new RPP(){ // BodyInvImpl // index: 0
														RPP __function__ = new InvSortPreComparisonPart(
															0 + (1*K)
														);
														public int getA() { return __function__.getA(); }
														public void b(int[] __x__, int __startIndex__, int __endIndex__) {
															this.__function__.b(__x__, __startIndex__, __endIndex__);
														}
													},
													
													new RPP(){ // BodyInvImpl // index: 1
														RPP __function__ = new cantorPairing.InvCu();
														public int getA() { return __function__.getA(); }
														public void b(int[] __x__, int __startIndex__, int __endIndex__) {
															this.__function__.b(__x__, __startIndex__, __endIndex__);
														}
													}
												};
												/*
												private final AritySupplier[] __startIndexOffsetSuppliers__ = { //
													() -> { return 0;}, //
													() -> { return 4 + (1*K);}
												};
												*/
												private final int[] __startIndexOffset__ = {
													0, //
													4 + (1*K)
												};
												public int getA() { return (9 + (1*K)); }
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
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										int __endIndexBody__ = (__startIndex__ + this.getA()) - 1;
										int __iterationsLeft__ = Math.abs(__x__[__endIndexBody__]);
										while(__iterationsLeft__-->0){
											__function__.b(__x__, __startIndex__, __endIndexBody__);
										}
									}
									// Iteration stop
								},
								
								new RPP() { // ParCompImpl // index: 1
									private RPP __f__ = new RPP(){
										private final int __a__ = 7;
										public void b(int[] __x__, int __startIndex__, int __endIndex__) {
											int __tmp__=0;
											__tmp__ = __x__[__startIndex__ + 0]; 
											__x__[__startIndex__ + 0] = __x__[__startIndex__ + 4]; 
											__x__[__startIndex__ + 4] = __x__[__startIndex__ + 1]; 
											__x__[__startIndex__ + 1] = __x__[__startIndex__ + 5]; 
											__x__[__startIndex__ + 5] = __tmp__; 
										}
										public int getA() { return this.__a__; }
									};
									public int getA() { return 10 + (1*K); }
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__,
											__startIndex__ + 3 + (1*K),
											__startIndex__ + (3 + (1*K)) + this.__f__.getA()
											);
									}
								},
								
								new RPP() { // ParCompImpl // index: 2
									private RPP __f__ = new RPP(){
										/** regular function used when v > 0 */
										RPP __function__ = new RPP() { // BodyDecImpl
											private RPP __f__ = Dec.SINGLETON_Dec;
											private final int __a__ = __f__.getA();
											public void b(int[] __x__, int __startIndex__, int __endIndex__) {
												this.__f__.b(__x__, __startIndex__, __endIndex__);
											}
											public int getA() { return this.__a__; }
										};
										
										/** inverse function used when v < 0 */
										RPP __inv_function__ = new RPP() { // InvBodyDecImpl
											private RPP __f__ = InvDec.SINGLETON_InvDec;
											private final int __a__ = __f__.getA();
											public void b(int[] __x__, int __startIndex__, int __endIndex__) {
												this.__f__.b(__x__, __startIndex__, __endIndex__);
											}
											public int getA() { return this.__a__; }
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
									};
									public int getA() { return 10 + (1*K); }
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__,
											__startIndex__ + 8 + (1*K),
											__startIndex__ + (8 + (1*K)) + this.__f__.getA()
											);
									}
								},
								
								new RPP() { // ParCompImpl // index: 3
									private RPP __f__ = new RPP(){
										private RPP __f__ = Inc.SINGLETON_Inc;
										private final int __a__ = __f__.getA();
										public void b(int[] __x__, int __startIndex__, int __endIndex__) {
											this.__f__.b(__x__, __startIndex__, __endIndex__);
										}
										public int getA() { return this.__a__; }
									};
									public int getA() { return 10 + (1*K); }
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__,
											__startIndex__ + 9 + (1*K),
											__startIndex__ + (9 + (1*K)) + this.__f__.getA()
											);
									}
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
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							int __endIndexBody__ = (__startIndex__ + this.getA()) - 1;
							int __iterationsLeft__ = Math.abs(__x__[__endIndexBody__]);
							while(__iterationsLeft__-->0){
								__function__.b(__x__, __startIndex__, __endIndexBody__);
							}
						}
						// Iteration stop
					},
					
					new RPP() { // ParCompImpl // index: 2
						private RPP __f__ = new RPP(){
							private final RPP[] __steps__ = new RPP[]{
								new RPP() { // ParCompImpl // index: 0
									private RPP __f__ = new RPP(){
										private RPP __f__ = Dec.SINGLETON_Dec;
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
								},
								
								new RPP() { // BodyParamDecImpl // index: 1
									private RPP __f__ = Dec.SINGLETON_Dec;
									public int getA() { return 2; }
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										int __arity__;
										int __repsAmount__ = -1 + (1*K);
										while(__repsAmount__-->0){
										__arity__ = this.getA();
										while(__arity__-->0){
											this.__f__.b(__x__, __startIndex__ + __arity__, __startIndex__ + __arity__ + 1); // "1" because "f.getA()" will surely returns "1"
										}
										}
									}
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
						public int getA() { return 11 + (1*K); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 9 + (1*K),
								__startIndex__ + (9 + (1*K)) + this.__f__.getA()
								);
						}
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
		}
	}
}