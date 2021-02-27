package arithNat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import yarelcore.*;	

public class InvDisStepN implements RPP {
	public InvDisStepN() { }
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
		this.destructorDisStepN();
	}
	protected void destructorDisStepN(){
		if(threadPoolExecutor != null){
			// threadPoolExecutor.shutdown(); // required only if "newCachedThreadPool" is choosed to instantiate "threadPoolExecutor"
			threadPoolExecutor = null; // mark it as shut-down
		}
	}
	
	public DisStepN getInverse(){
		return new DisStepN();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // ParCompImpl
			/**
			 * Yarel's code is a sequence of instructions, we could name them "code blocks". <br>
			 * Those blocks could be formed by a set of sub-blocks that requires to be executed in a parallel way. <br>
			 * This is the set of those sub-blocks (for a given code block), which are {@link RPP} instances. <br>
			 * The order is preserved from the Yarel source code.
			*/
			private final RPP[] subtasks = new RPP[]{
				new RPP(){ // BodyFunImpl
					RPP function = new InvSubN();
					private final int a = function.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.function.b(x, startIndex, endIndex);
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
			private final int[] startIndexOffsets = { 0,2 };
			private final int a = 4;
			public int getA() { return this.a; }
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
				
				boolean areChildrenRunning = true;
				int startingIndex;
				final int[] semaphore = new int[]{ subtasks.length };
				final Runnable[] tasks = new Runnable[ semaphore[0] ];
			
				// PHASE 1 convert the RPP in runnable tasks
				for(int i = 0; i < tasks.length; i++){
					startingIndex = startIndex + startIndexOffsets[i];
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
				
				// PHASE 2: put the "sprinters" at the "race's starting blocks".
				synchronized (semaphore) { // acquire the lock, so that the parallel executions must be performed AFTER this thread sleeps.
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
					
					// PHASE 3: the main thread sleeps and the "parallel sub-tasks" could now (be submitted and) run.
					try {
						semaphore.wait(); 
						/* The "wait" let the main thread to sleep, releasing the lock.
							NOW the submitter can submit the parallel tasks, which can then to be executed.
						*/
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				do{
					synchronized (semaphore) {
						if(semaphore[0] <= 0){
							areChildrenRunning = false;
						} else {
							try {
								semaphore.wait(); // some child(dren) is still running
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				} while(areChildrenRunning);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 4;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 1]; 
				x[startIndex + 1] = tmp; 
			}
			
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new InvDisSelN();
				private final int a = function.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
				 public int getA() { return this.a; }
			};
			private final int a = 4 ;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex + 1, startIndex + this.a + 1);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 4;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 3]; 
				x[startIndex + 3] = tmp; 
			}
			
			public int getA() { return this.a; }
		}
	};
	private final int a = steps[0].getA();
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		int i;
		i = steps.length;
		while( i-->0 ){
			steps[i].b(x, startIndex, endIndex);
		}
	}
}