package boundedMin;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// import java.util.function.Supplier;
import yarelcore.*;	

public class InvMinH12 implements RPP {
	public InvMinH12() { }
	
	

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
		this.destructorMinH12();
	}
	protected void destructorMinH12(){
		if(threadPoolExecutor != null){
			// threadPoolExecutor.shutdown(); // required only if "newCachedThreadPool" is choosed to instantiate "threadPoolExecutor"
			threadPoolExecutor = null; // mark it as shut-down
		}
	}
	
	public MinH12 getInverse(){
		return new MinH12();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // BodyPermImpl
			private final int a = 5;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 4]; 
				x[startIndex + 4] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new arithNat.InvSumN();
				public int getA() { return function.getA(); }
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
			};
			public int getA() { return 5; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 1,
					startIndex + (1) + (2)
					);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 5;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 4]; 
				x[startIndex + 4] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 2]; 
				x[startIndex + 2] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // BodyItImpl
			// Iteration start
			RPP function = new RPP() { // SerCompImpl
				private final RPP[] steps = new RPP[]{
					new RPP() { // ParCompImpl
						private RPP f = new RPP(){
							RPP function = new funcH12.InvH12_v2();
							public int getA() { return function.getA(); }
							public void b(int[] x, int startIndex, int endIndex) {
								this.function.b(x, startIndex, endIndex);
							}
						};
						public int getA() { return 4; }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x,
								startIndex + 0,
								startIndex + (0) + (1)
								);
						}
					},
					
					new RPP() { // BodyPermImpl
						private final int a = 4;
						public void b(int[] x, int startIndex, int endIndex) {
							int tmp=0;
							tmp = x[startIndex + 1]; 
							x[startIndex + 1] = x[startIndex + 3]; 
							x[startIndex + 3] = x[startIndex + 2]; 
							x[startIndex + 2] = tmp; 
						}
						public int getA() { return this.a; }
					},
					
					new RPP() { // BodyIfImpl
						RPP pos=new RPP() {
							public int getA() { return 3; }
							public void b(int[] x, int startIndex, int endIndex) {
								// There were only parallels identities, nothing interesting to show and run
							}
						};
						RPP zero=new RPP() {
							public int getA() { return 3; }
							public void b(int[] x, int startIndex, int endIndex) {
								// There were only parallels identities, nothing interesting to show and run
							}
						};
						RPP neg=new RPP() {
							private RPP f = new RPP(){
								private RPP f = InvDec.SINGLETON_InvDec;
								private final int a = f.getA();
								public void b(int[] x, int startIndex, int endIndex) {
									this.f.b(x, startIndex, endIndex);
								}
								public int getA() { return this.a; }
							};
							public int getA() { return 3; }
							public void b(int[] x, int startIndex, int endIndex) {
								this.f.b(x,
									startIndex + 2,
									startIndex + (2) + (1)
									);
							}
						};
						public int getA() { return this.pos.getA()+1; }
						public void b(int[] x, int startIndex, int endIndex) {
							final int testValue = x[(startIndex + this.getA()) - 1];
							if(testValue > 0){
								pos.b(x, startIndex, startIndex + pos.getA());
							} else if(testValue == 0){
								zero.b(x, startIndex, startIndex + zero.getA());
							} else { // The "testValue<0" test is a tautology
								neg.b(x, startIndex, startIndex + neg.getA());
							}
						}
					},
					
					new RPP() { // BodyPermImpl
						private final int a = 4;
						public void b(int[] x, int startIndex, int endIndex) {
							int tmp=0;
							tmp = x[startIndex + 1]; 
							x[startIndex + 1] = x[startIndex + 2]; 
							x[startIndex + 2] = x[startIndex + 3]; 
							x[startIndex + 3] = tmp; 
						}
						public int getA() { return this.a; }
					},
					
					new RPP() { // ParCompImpl
						private RPP f = new RPP(){
							RPP function = new funcH12.H12_v2();
							public int getA() { return function.getA(); }
							public void b(int[] x, int startIndex, int endIndex) {
								this.function.b(x, startIndex, endIndex);
							}
						};
						public int getA() { return 4; }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x,
								startIndex + 0,
								startIndex + (0) + (1)
								);
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
							new RPP(){ // BodyIncImpl
								private RPP f = InvInc.SINGLETON_InvInc;
								private final int a = f.getA();
								public void b(int[] x, int startIndex, int endIndex) {
									this.f.b(x, startIndex, endIndex);
								}
								public int getA() { return this.a; }
							},
							
							new RPP(){ // BodyIncImpl
								private RPP f = InvInc.SINGLETON_InvInc;
								private final int a = f.getA();
								public void b(int[] x, int startIndex, int endIndex) {
									this.f.b(x, startIndex, endIndex);
								}
								public int getA() { return this.a; }
							}
						};
						/*
						private final AritySupplier[] startIndexOffsetSuppliers = { //
							() -> { return 0;}, //
							() -> { return 3;}
						};
						*/
						private final int[] startIndexOffset = {
							0, //
							3
						};
						public int getA() { return (4); }
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
					i = steps.length;
					while( i-->0 ){
						steps[i].b(x, startIndex, endIndex);
					}
				}
			};
			public int getA() { return function.getA()+1; }
			public void b(int[] x, int startIndex, int endIndex) {
				int endIndexBody = (startIndex + this.getA()) - 1;
				int iterationsLeft = Math.abs(x[endIndexBody]);
				while(iterationsLeft-->0){
					function.b(x, startIndex, endIndexBody);
				}
			}
			// Iteration stop
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 5;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 4]; 
				x[startIndex + 4] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new arithNat.InvSubN();
				public int getA() { return function.getA(); }
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
			};
			public int getA() { return 5; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 0,
					startIndex + (0) + (1)
					);
			}
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new arithNat.InvSubN();
				public int getA() { return function.getA(); }
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
			};
			public int getA() { return 5; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x,
					startIndex + 1,
					startIndex + (1) + (2)
					);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 5;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 4]; 
				x[startIndex + 4] = tmp; 
			}
			public int getA() { return this.a; }
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
}