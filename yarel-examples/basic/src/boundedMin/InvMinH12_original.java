package boundedMin;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import yarelcore.*;	

public class InvMinH12_original implements RPP {
	public InvMinH12_original() { }
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
		this.destructorMinH12_original();
	}
	protected void destructorMinH12_original(){
		if(threadPoolExecutor != null){
			// threadPoolExecutor.shutdown(); // required only if "newCachedThreadPool" is choosed to instantiate "threadPoolExecutor"
			threadPoolExecutor = null; // mark it as shut-down
		}
	}
	
	public MinH12_original getInverse(){
		return new MinH12_original();
	}
	
	RPP l = new RPP() { // SerCompImpl
		RPP l = new RPP() { // SerCompImpl
			RPP l = new RPP() { // SerCompImpl
				RPP l = new RPP() { // SerCompImpl
					RPP l = new RPP() { // BodyItImpl
						// Iteration start
						RPP function = new RPP() { // SerCompImpl
							RPP l = new RPP() { // SerCompImpl
								RPP l = new RPP() { // SerCompImpl
									RPP l = new RPP() { // SerCompImpl
										RPP l = new RPP() { // SerCompImpl
											RPP l = new RPP() { // ParCompImpl
												private RPP f = new RPP(){
													RPP function = new funcH12.InvH12();
													private final int a = function.getA();
													public void b(int[] x, int startIndex, int endIndex) {
														this.function.b(x, startIndex, endIndex);
													}
													 public int getA() { return this.a; }
												};
												private final int a = 6 ;
												public int getA() { return this.a; }
												public void b(int[] x, int startIndex, int endIndex) {
													this.f.b(x, startIndex + 0, startIndex + this.a + 0);
												}
											};
											RPP r = new RPP() { // BodyPermImpl
												private final int a = 6;
												public void b(int[] x, int startIndex, int endIndex) {
													int tmp=0;
													tmp = x[startIndex + 1]; 
													x[startIndex + 1] = x[startIndex + 5]; 
													x[startIndex + 5] = x[startIndex + 4]; 
													x[startIndex + 4] = x[startIndex + 3]; 
													x[startIndex + 3] = x[startIndex + 2]; 
													x[startIndex + 2] = tmp; 
												}
												
												public int getA() { return this.a; }
											};
											private final int a = l.getA();
											public int getA() { return this.a; }
											public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
												this.r.b(x, startIndex, endIndex);
												this.l.b(x, startIndex, endIndex);
											}
										};
										RPP r = new RPP() { // BodyIfImpl
											RPP pos=new RPP() {
												private final int a = 5;
												public int getA() { return this.a; }
												public void b(int[] x, int startIndex, int endIndex) {
													// There were only parallels identities, nothing interesting to show and run
												}
											};
											RPP zero=new RPP() {
												private final int a = 5;
												public int getA() { return this.a; }
												public void b(int[] x, int startIndex, int endIndex) {
													// There were only parallels identities, nothing interesting to show and run
												}
											};
											RPP neg=new RPP() {
												RPP l = new RPP() { // BodyIfImpl
													RPP pos=new RPP() {
														private final int a = 4;
														public int getA() { return this.a; }
														public void b(int[] x, int startIndex, int endIndex) {
															// There were only parallels identities, nothing interesting to show and run
														}
													};
													RPP zero=new RPP() {
														private RPP f = new RPP(){
															RPP function = new arithNat.InvSumN();
															private final int a = function.getA();
															public void b(int[] x, int startIndex, int endIndex) {
																this.function.b(x, startIndex, endIndex);
															}
															 public int getA() { return this.a; }
														};
														private final int a = 4 ;
														public int getA() { return this.a; }
														public void b(int[] x, int startIndex, int endIndex) {
															this.f.b(x, startIndex + 2, startIndex + this.a + 2);
														}
													};
													RPP neg=new RPP() {
														private final int a = 4;
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
												RPP r = new RPP() { // ParCompImpl
													private RPP f = new RPP(){
														private RPP f = new InvInc();
														private final int a = f.getA();
														public void b(int[] x, int startIndex, int endIndex) {
															this.f.b(x, startIndex, endIndex);
														}
														public int getA() { return this.a; }
													};
													private final int a = 5 ;
													public int getA() { return this.a; }
													public void b(int[] x, int startIndex, int endIndex) {
														this.f.b(x, startIndex + 4, startIndex + this.a + 4);
													}
												};
												private final int a = l.getA();
												public int getA() { return this.a; }
												public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
													this.r.b(x, startIndex, endIndex);
													this.l.b(x, startIndex, endIndex);
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
											this.r.b(x, startIndex, endIndex);
											this.l.b(x, startIndex, endIndex);
										}
									};
									RPP r = new RPP() { // BodyPermImpl
										private final int a = 6;
										public void b(int[] x, int startIndex, int endIndex) {
											int tmp=0;
											tmp = x[startIndex + 1]; 
											x[startIndex + 1] = x[startIndex + 2]; 
											x[startIndex + 2] = x[startIndex + 3]; 
											x[startIndex + 3] = x[startIndex + 4]; 
											x[startIndex + 4] = x[startIndex + 5]; 
											x[startIndex + 5] = tmp; 
										}
										
										public int getA() { return this.a; }
									};
									private final int a = l.getA();
									public int getA() { return this.a; }
									public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
										this.r.b(x, startIndex, endIndex);
										this.l.b(x, startIndex, endIndex);
									}
								};
								RPP r = new RPP() { // ParCompImpl
									private RPP f = new RPP(){
										RPP function = new funcH12.H12();
										private final int a = function.getA();
										public void b(int[] x, int startIndex, int endIndex) {
											this.function.b(x, startIndex, endIndex);
										}
										 public int getA() { return this.a; }
									};
									private final int a = 6 ;
									public int getA() { return this.a; }
									public void b(int[] x, int startIndex, int endIndex) {
										this.f.b(x, startIndex + 0, startIndex + this.a + 0);
									}
								};
								private final int a = l.getA();
								public int getA() { return this.a; }
								public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
									this.r.b(x, startIndex, endIndex);
									this.l.b(x, startIndex, endIndex);
								}
							};
							RPP r = new RPP() { // ParCompImpl
								/**
								 * Yarel's code is a sequence of instructions, we could name them "code blocks". <br>
								 * Those blocks could be formed by a set of sub-blocks that requires to be executed in a parallel way. <br>
								 * This is the set of those sub-blocks (for a given code block), which are {@link RPP} instances. <br>
								 * The order is preserved from the Yarel source code.
								*/
								private final RPP[] subtasks = new RPP[]{
									new RPP(){ // BodyIncImpl
										private RPP f = new InvInc();
										private final int a = f.getA();
										public void b(int[] x, int startIndex, int endIndex) {
											this.f.b(x, startIndex, endIndex);
										}
										public int getA() { return this.a; }
									},
									
									new RPP(){ // BodyIncImpl
										private RPP f = new InvInc();
										private final int a = f.getA();
										public void b(int[] x, int startIndex, int endIndex) {
											this.f.b(x, startIndex, endIndex);
										}
										public int getA() { return this.a; }
									}
								};
								private final int[] startIndexOffsets = { 0,4 };
								private final int a = 6;
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
													if(--semaphore[0] <= 0){
														semaphore.notifyAll();
													}
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
								}
							};
							private final int a = l.getA();
							public int getA() { return this.a; }
							public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
								this.r.b(x, startIndex, endIndex);
								this.l.b(x, startIndex, endIndex);
							}
						};
						private final int a = function.getA()+1;
						public void b(int[] x, int startIndex, int endIndex) {
							int endIndexBody = (startIndex + a) - 1;
							int iterationsLeft = Math.abs(x[endIndexBody]);
							while(iterationsLeft-->0){
								function.b(x, startIndex, endIndexBody);
							}
						}
						public int getA() { return this.a; } 
						// Iteration stop
					};
					RPP r = new RPP() { // BodyPermImpl
						private final int a = 7;
						public void b(int[] x, int startIndex, int endIndex) {
							int tmp=0;
							tmp = x[startIndex + 4]; 
							x[startIndex + 4] = x[startIndex + 5]; 
							x[startIndex + 5] = x[startIndex + 6]; 
							x[startIndex + 6] = tmp; 
						}
						
						public int getA() { return this.a; }
					};
					private final int a = l.getA();
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
						this.r.b(x, startIndex, endIndex);
						this.l.b(x, startIndex, endIndex);
					}
				};
				RPP r = new RPP() { // BodyIfImpl
					RPP pos=new RPP() {
						private final int a = 6;
						public int getA() { return this.a; }
						public void b(int[] x, int startIndex, int endIndex) {
							// There were only parallels identities, nothing interesting to show and run
						}
					};
					RPP zero=new RPP() {
						private RPP f = new RPP(){
							RPP function = new arithNat.InvSumN();
							private final int a = function.getA();
							public void b(int[] x, int startIndex, int endIndex) {
								this.function.b(x, startIndex, endIndex);
							}
							 public int getA() { return this.a; }
						};
						private final int a = 6 ;
						public int getA() { return this.a; }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex + 3, startIndex + this.a + 3);
						}
					};
					RPP neg=new RPP() {
						private final int a = 6;
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
					this.r.b(x, startIndex, endIndex);
					this.l.b(x, startIndex, endIndex);
				}
			};
			RPP r = new RPP() { // BodyPermImpl
				private final int a = 7;
				public void b(int[] x, int startIndex, int endIndex) {
					int tmp=0;
					tmp = x[startIndex + 4]; 
					x[startIndex + 4] = x[startIndex + 6]; 
					x[startIndex + 6] = x[startIndex + 5]; 
					x[startIndex + 5] = tmp; 
				}
				
				public int getA() { return this.a; }
			};
			private final int a = l.getA();
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
				this.r.b(x, startIndex, endIndex);
				this.l.b(x, startIndex, endIndex);
			}
		};
		RPP r = new RPP() { // BodyInvImpl
			// Iteration start
			RPP function = new RPP() { // SerCompImpl
				RPP l = new RPP() { // SerCompImpl
					RPP l = new RPP() { // SerCompImpl
						RPP l = new RPP() { // SerCompImpl
							RPP l = new RPP() { // SerCompImpl
								RPP l = new RPP() { // ParCompImpl
									private RPP f = new RPP(){
										RPP function = new funcH12.H12();
										private final int a = function.getA();
										public void b(int[] x, int startIndex, int endIndex) {
											this.function.b(x, startIndex, endIndex);
										}
										 public int getA() { return this.a; }
									};
									private final int a = 6 ;
									public int getA() { return this.a; }
									public void b(int[] x, int startIndex, int endIndex) {
										this.f.b(x, startIndex + 0, startIndex + this.a + 0);
									}
								};
								RPP r = new RPP() { // BodyPermImpl
									private final int a = 6;
									public void b(int[] x, int startIndex, int endIndex) {
										int tmp=0;
										tmp = x[startIndex + 1]; 
										x[startIndex + 1] = x[startIndex + 2]; 
										x[startIndex + 2] = x[startIndex + 3]; 
										x[startIndex + 3] = x[startIndex + 4]; 
										x[startIndex + 4] = x[startIndex + 5]; 
										x[startIndex + 5] = tmp; 
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
									private final int a = 5;
									public int getA() { return this.a; }
									public void b(int[] x, int startIndex, int endIndex) {
										// There were only parallels identities, nothing interesting to show and run
									}
								};
								RPP zero=new RPP() {
									private final int a = 5;
									public int getA() { return this.a; }
									public void b(int[] x, int startIndex, int endIndex) {
										// There were only parallels identities, nothing interesting to show and run
									}
								};
								RPP neg=new RPP() {
									private RPP f = new RPP(){
										private RPP f = new Inc();
										private final int a = f.getA();
										public void b(int[] x, int startIndex, int endIndex) {
											this.f.b(x, startIndex, endIndex);
										}
										public int getA() { return this.a; }
									};
									private final int a = 5 ;
									public int getA() { return this.a; }
									public void b(int[] x, int startIndex, int endIndex) {
										this.f.b(x, startIndex + 4, startIndex + this.a + 4);
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
							private final int a = 6;
							public void b(int[] x, int startIndex, int endIndex) {
								int tmp=0;
								tmp = x[startIndex + 1]; 
								x[startIndex + 1] = x[startIndex + 5]; 
								x[startIndex + 5] = x[startIndex + 4]; 
								x[startIndex + 4] = x[startIndex + 3]; 
								x[startIndex + 3] = x[startIndex + 2]; 
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
							RPP function = new funcH12.InvH12();
							private final int a = function.getA();
							public void b(int[] x, int startIndex, int endIndex) {
								this.function.b(x, startIndex, endIndex);
							}
							 public int getA() { return this.a; }
						};
						private final int a = 6 ;
						public int getA() { return this.a; }
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex + 0, startIndex + this.a + 0);
						}
					};
					private final int a = l.getA();
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
						this.l.b(x, startIndex, endIndex);
						this.r.b(x, startIndex, endIndex);
					}
				};
				RPP r = new RPP() { // ParCompImpl
					/**
					 * Yarel's code is a sequence of instructions, we could name them "code blocks". <br>
					 * Those blocks could be formed by a set of sub-blocks that requires to be executed in a parallel way. <br>
					 * This is the set of those sub-blocks (for a given code block), which are {@link RPP} instances. <br>
					 * The order is preserved from the Yarel source code.
					*/
					private final RPP[] subtasks = new RPP[]{
						new RPP(){ // BodyIncImpl
							private RPP f = new Inc();
							private final int a = f.getA();
							public void b(int[] x, int startIndex, int endIndex) {
								this.f.b(x, startIndex, endIndex);
							}
							public int getA() { return this.a; }
						},
						
						new RPP(){ // BodyIncImpl
							private RPP f = new Inc();
							private final int a = f.getA();
							public void b(int[] x, int startIndex, int endIndex) {
								this.f.b(x, startIndex, endIndex);
							}
							public int getA() { return this.a; }
						}
					};
					private final int[] startIndexOffsets = { 0,4 };
					private final int a = 6;
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
										if(--semaphore[0] <= 0){
											semaphore.notifyAll();
										}
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
					}
				};
				private final int a = l.getA();
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
					this.l.b(x, startIndex, endIndex);
					this.r.b(x, startIndex, endIndex);
				}
			};
			private final int a = function.getA()+1;
			public void b(int[] x, int startIndex, int endIndex) {
				int endIndexBody = (startIndex + a) - 1;
				int iterationsLeft = Math.abs(x[endIndexBody]);
				while(iterationsLeft-->0){
					function.b(x, startIndex, endIndexBody);
				}
			}
			public int getA() { return this.a; } 
			// Iteration stop
		};
		private final int a = l.getA();
		public int getA() { return this.a; }
		public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
			this.r.b(x, startIndex, endIndex);
			this.l.b(x, startIndex, endIndex);
		}
	};
	RPP r = new RPP() { // BodyPermImpl
		private final int a = 7;
		public void b(int[] x, int startIndex, int endIndex) {
			int tmp=0;
			tmp = x[startIndex + 0]; 
			x[startIndex + 0] = x[startIndex + 2]; 
			x[startIndex + 2] = x[startIndex + 3]; 
			x[startIndex + 3] = tmp; 
		}
		
		public int getA() { return this.a; }
	};
	private final int a = l.getA();
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		this.r.b(x, startIndex, endIndex);
		this.l.b(x, startIndex, endIndex);
	}
}