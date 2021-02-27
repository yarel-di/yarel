/**
 * Yarel
 * Copyright (C) 2018  Claudio Grandi, Dariush Moshiri, Luca Roversi
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
 
package org.di.unito.yarel.generator.javagen

import java.util.HashMap
import java.util.Map
import org.di.unito.yarel.yarel.Body
import org.di.unito.yarel.yarel.BodyDec
import org.di.unito.yarel.yarel.BodyFor
import org.di.unito.yarel.yarel.BodyFun
import org.di.unito.yarel.yarel.BodyId
import org.di.unito.yarel.yarel.BodyIf
import org.di.unito.yarel.yarel.BodyInc
import org.di.unito.yarel.yarel.BodyInv
import org.di.unito.yarel.yarel.BodyIt
import org.di.unito.yarel.yarel.BodyNeg
import org.di.unito.yarel.yarel.BodyPerm
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.ParComp
import org.di.unito.yarel.yarel.Permutation
import org.di.unito.yarel.yarel.SerComp
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.naming.IQualifiedNameProvider

import static extension org.eclipse.xtext.EcoreUtil2.*
import java.util.LinkedList
import org.di.unito.yarel.utils.YarelUtils
import org.di.unito.yarel.yarel.BodyPermIndex

class JavaYarelGenerator implements IGenerator2 {
	
//	static final String OUTPUT_TEST = "output_test"
	
	//the function does the same thing as the one declared in YarelUtils
	//which for an unknown reason does not work here
	
	private def exceptionsGenerator(String packageName) {
		'''
		package «packageName»;
		public class WrongArityException extends RuntimeException {
			public WrongArityException(){
			  super();
			}
			public WrongArityException(String message){
			  super(message);
			}
		}
		'''}
	
	/*Generates code for the RPP (Reversible Primitive Permutation) interface, 
	implemented in a different way by each function*/
	private def RPPGenerator(String packageName) {
		'''
		package «packageName»;
		/** Definition of an operator in RPP context. */
		public interface RPP {
			/**
			 * "Arity".
			 * <p>
			 * Returns the arity of this operator.<br>
			 * For instance, <i>increment</i> has <code>1</code> as arity.
			 */
			public int getA();
			
			/**
			 * "Behaves".
			 * <p>
			 * Implements the behavior of this statements, i.e. what it should do (for
			 * instance, an increment increments some values), applied to some of the given
			 * registers (which is the parameter).<br>
			 * Invokes {@link #b(int[], int, int)} passing <code>0</code> and
			 * <code>{@link #getA()}</code> as parameters.
			 * Notice that not all registers are forced to be considered.
			 * 
			 * @param x the vector of "registers", in particular their values.
			 */
			public default void b(int[] x) { this.b(x, 0, this.getA()); }
			
			/**
			 * As like as {@link #b(int[])}, but operating over a restricted subset of
			 * contiguous registers.<br>
			 * ALL of the indexes <b>MUST</b> be considered as <i>inclusive</i> and bounded
			 * to <code>0</code> and <code>x.length - 1</code>.
			 * 
			 * @param x			the vector of "registers", in particular their values.
			 * @param startIndex the minimum register's index considered by this operator,
			 *				   i.e. the first register affected by this call, which is inclusive.
			 *				   The {@link #b(int[])} implementation assign <code>0</code> to it.
			 *				   It's the most important index.
			 * @param endIndex   the maximum register's index considered by this operator, 
			 *				   i.e. the last register affected by this call, which is exclusive.
			 *				   The {@link #b(int[])} implementation assign <code>{@link #getA()}</code> to it.
			 *				   Usually this index is ignored.
			 */
			public void b(int[] x, int startIndex, int endIndex);
		}
		'''}
		
	//Implements the identity function
	private def IdGenerator(String packageName) {
		'''
		package «packageName»;
		public class Id implements RPP {
			private final int a = 1;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex){  }
		}
		'''}
		
	//Implements the inverse of the identity function	
	private def InvIdGenerator(String packageName) {
		'''
		package «packageName»;
		public class InvId implements RPP {
			private RPP f = new Id();
			private final int a = this.f.getA();
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex){
				this.f.b(x, startIndex, endIndex);
			}
		}
		'''}
	
	//Implements the increase function
	private def IncGenerator(String packageName) {
		'''
		package «packageName»;
		public class Inc implements RPP {
			private final int a = 1;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				x[startIndex]++;
			}
		}
		'''}
	
	//Implements the inverse of the increase function
	private def InvIncGenerator(String packageName) {
		'''
		package «packageName»;
		public class InvInc implements RPP {
			private RPP f = new Dec();
			private final int a = this.f.getA();
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex, endIndex);
			}
		}
		'''}
	
	//Implements the decrease function
	private def DecGenerator(String packageName) {
		'''
		package «packageName»;
		public class Dec implements RPP {
			private final int a = 1;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				x[startIndex]--;
			}
		}
		'''}
	
	//Implements the inverse of the decrease function
	private def InvDecGenerator(String packageName) {
		'''
		package «packageName»;
		public class InvDec implements RPP {
			private RPP f = new Inc();
			private final int a = this.f.getA();
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex, endIndex);
			}
		}
		'''}
	
	//Implements the neg function
	private def NegGenerator(String packageName) {
		'''
		package «packageName»;
		public class Neg implements RPP {
			private final int a = 1;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				x[startIndex] = -x[startIndex];
			}
		}
		'''}
	
	//Implements the inverse of the neg function
	private def InvNegGenerator(String packageName) {
		'''
		package «packageName»;
		public class InvNeg implements RPP {
			private RPP f = new Neg();
			private final int a = this.f.getA();;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex, endIndex);
			}
		}
		'''}
		
	//Implements usefull in parallel executions
	private def SubBodyRunnerGenerator(String packageName) {
		'''
		package «packageName»;
		
		/**
		 * Defines a {@link Runnable} that performs a given operator (an {@link RPP} instance)
		 * over a given set of registers (that is, an array of <code>int</code>). <br>
		 * The first constructor's parameter, i.e. <code>int startingIndex</code>, is the
		 * second parameter of {@link RPP#b(int[],int,int)}.
		*/
		public class SubBodyRunner implements Runnable{
			protected final int startingIndex;
			protected final int[] registers;
			protected final RPP subBody;
			
			protected SubBodyRunner(int startingIndex, RPP subBody, int[] registers){
				this.startingIndex = startingIndex;
				this.subBody = subBody;
				this.registers = registers;
			}
			
			/**
			 * Returns the lowest registers' index on which apply the operator (that is the result
			 * of {@link #getSubBody()}).
			*/
			public int getStartingIndex(){ return this.startingIndex; }
			
			/**
			 * Returns an instance of {@link RPP}, which is the operator to be executed.
			*/
			public RPP getSubBody(){ return this.subBody; }
			
			/**
			 * Runs the operator provided upon instantiation (retrievable via {@link #getSubBody()})
			 * over the set of registers similarly provided. <br>
			 * Basically, delegates the job to that {@link RPP} instance.
			 * <p>
			 * {@inheritDocs}
			*/
			public void run(){
				this.subBody.b(registers, this.startingIndex, this.startingIndex + this.subBody.getA());
			}
		}
		'''
		}
	
	//Generates an executable java file to run a simple test on the function/s declared in the .rl file.
	private def playGenerator(String packageName, Model model) {
		
		val functionNames = model.elements.filter(Definition).map[ it.declarationName.name ]
		val baseValuesData= newIntArrayOfSize(13)
		{
			var i = 0
			baseValuesData.set(i++,0)
			baseValuesData.set(i++,1)
			baseValuesData.set(i++,-1)
			baseValuesData.set(i++,2)
			baseValuesData.set(i++,-2)
			baseValuesData.set(i++,3)
			baseValuesData.set(i++,-3)
			baseValuesData.set(i++,4)
			baseValuesData.set(i++,-4)
			baseValuesData.set(i++,10)
			baseValuesData.set(i++,-10)
			baseValuesData.set(i++,11)
			baseValuesData.set(i++,-11)
		}
		'''
		package «packageName»;
		import yarelcore.*;
		import java.util.Arrays;
		
		/**
		 * Automatically generated usage class.<p>
		 *
		 * This is a draft, providing examples of instantiation and usage and invocation,
		 * in a Java context, of the functions/operators written in Yarel. <br>
		 * In further developments, this will be a JUnit class.<br>
		 * For instance, currently this tests looks like:
		 * <pre><code>
		 	int[] data = {8 3 0 0 0};
		 	RPP op = new Some_5ary_Operator();
		 	op.b(data);
		 * </pre></code>
		 * For further informations, check the documentation:
		 * <ul>
		 * <li> {@link RPP}</li>
		«FOR name : functionNames SEPARATOR "\n"»* <li> {@link «packageName».«name.toFirstUpper»}</li>«ENDFOR»
		 * </ul>
		 * <p>
		 *
		 * NOTE:<br>
		 * The following "usages" not tests, they are just invocations over a pre-determined dataset
		 * that requires to be manually observed and verified and has currently nothing related
		 * with the "semantic"/meaning/functionality of the executed operator. That means that the
		 * inputs and the outputs are currently "static" and unrelated with the expected inputs and outputs
		 * of the functions. (This is a "further development".)<br>
		 * For instance, an operator could expect to receive some registers as input values and others
		 * as 0-ancillae or 1-ancillae (or "truth-pair"). <br>
		 * Currently, that information cannot be provided in this current version of the Yarel language,
		 * so some automatic validation, formal or informal, cannot be performed.<br>
		 * In short, <strong>You</strong>, the programmer, has to run the class, read the console output
		 * and see the results.
		 * <p>
		 * TL;DR:<p>
		 * This class is, or presents: <br>
		 * <ul>
		 * <li>Instantiation and invocation of the compiled {@link RPP} subclasses.</li>
		 * <li>Those instances runs on meaningless example data.</li>
		 * <li>Manual check required by <strong>You</strong> yourself by <italic>reading</italic> the <code>console output</code></li>
		 * <li><i>Wanna-be</i> JUnit</li>
		 * </ul>
		*/
		public class «packageName.toFirstUpper»PlayWith {
			
			public static void main(String[] args) throws Exception {
				«FOR name : functionNames SEPARATOR "\n"»
					test«name.toFirstUpper»();
				«ENDFOR»
			}
			
			//
			
			«FOR name : functionNames SEPARATOR "\n\n\n"»
			public static void test«name.toFirstUpper»(){
				RPP «name»RPP = new «packageName».«name.toFirstUpper»();
				«val arity = getArity(name)»
				final int[][] datasets = {
					new int[]{«FOR i : 0 ..< arity - 1»«i+1»,«ENDFOR»5},
					new int[]{«FOR i : arity - 1 >..0»«i+1»,«ENDFOR»5},
					«FOR i : 0..< baseValuesData.size »
						«val baseValue = baseValuesData.get(i)»
						new int[]{«FOR rep : 0 ..< arity SEPARATOR ", "» «baseValue»«ENDFOR»},
					«ENDFOR»
				};
				for( int[] data: datasets ){
					System.out.println("\nTesting the function «name» with values:" + Arrays.toString(data));
					«name»RPP.b(data);
					System.out.println("Resulting in: " + Arrays.toString(data));
				}
			}
			«ENDFOR»
		}
		'''}
	
	
	/* Stores the arity of every declared name. */
	val Map<String,Integer> arities = new HashMap<String,Integer>;
	
	/* Associates every declared name to its arity. */
	private def collectArities(Model m) {
		for(var i = 0; i < m.elements.length; i++){
			var element = m.elements.get(i);
			if(element.getContainerOfType(Declaration)!==null) { // if a declaration exists
				var arity = 0
				for(var j = 0; j < (element as Declaration).signature.types.length; j++) // every type component
					if ((element as Declaration).signature.types.get(j).value != 0)
						arity = arity + (element as Declaration).signature.types.get(j).value // counts the explicit number of occurrences
					else  
						arity++ // counts +1
			   arities.put((element as Declaration).name, arity)
			}
		}
	}
	

	/* Reads the arity of the given declared name. */
	private def getArity(String name) {
		return arities.get(name);
	}
	
	/*
	 * There no need to use this function, because
	 * in the java code the call to each yarel function
	 * is made through its qualified name. So there is no 
	 * need to make the imports.
	 * This function is still here in case for some hypotheticals 
	 * future uses.
	 * Made protected by Marco Ottina to avoid potential automatic deletion.
	 */
	protected def generateImports(Model m){
		/*var r=""  
		for(var i = 0; i < m.elements.length; i++){
			if(m.elements.get(i).getContainerOfType(Import)!==null) {
				//println("IMPORT: " + (m.elements.get(i) as Import).name)
				r=r + "import "+(m.elements.get(i) as Import).importedNamespace.toString+"; \n"				
			}
		}
		return r*/
		//A better way to do it:
		var r = ""
		val imports = m.imports
		for(impt : imports){
			if(impt.importedNamespace.endsWith('*')){//the import use a wildcard
				r = r + "import "+ impt.importedNamespace +"; \n"
			}
			else{//import of a single function
				val pointIndex = impt.importedNamespace.lastIndexOf('.')
				val packageName = impt.importedNamespace.substring(0, pointIndex)
				val functionName = impt.importedNamespace.substring(pointIndex + 1).toFirstUpper
				//import also the inverse function
				val invFunctionName = "Inv" + impt.importedNamespace.substring(pointIndex + 1).toFirstUpper
				r = r + "import "+ packageName + '.' + functionName +"; \n"
				r = r + "import "+ packageName + '.' + invFunctionName +"; \n"
			}
		}
		r
	}	
	/**
	 * Starts the compilation from the root of the AST which is Model
	 */
	private def compile(IFileSystemAccess2 fsa, Model model) {
		var definitions = model.elements.filter(Definition)
		val folder = model.name.toFirstLower + "/"
	  for(definition: definitions) {
	  	var compilation = compile(model, definition, true)
			  fsa.generateFile(folder + definition.declarationName.name.toFirstUpper+".java", compilation)
			  compilation = compile(model, definition, false)
			  fsa.generateFile(folder + "Inv"+definition.declarationName.name.toFirstUpper+".java", compilation)
	  }
	}
		
	private def compile(Model model, Definition definition, boolean fwd) {
		val hasParallelBlock = newBooleanArrayOfSize(1);
		hasParallelBlock.set(0, false);
		val compiledBody = compile(definition.body, fwd, hasParallelBlock);
		return '''
		package «model.name.toFirstLower»;
		«IF hasParallelBlock.get(0)»
		import java.util.concurrent.ExecutorService;
		import java.util.concurrent.Executors;
		«ENDIF»
		import yarelcore.*;	
		
		public class «IF !fwd»Inv«ENDIF»«definition.declarationName.name.toFirstUpper» implements RPP {
			public «IF !fwd»Inv«ENDIF»«definition.declarationName.name.toFirstUpper»() { }
			«IF hasParallelBlock.get(0)»
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
				this.destructor«definition.declarationName.name.toFirstUpper»();
			}
			protected void destructor«definition.declarationName.name.toFirstUpper»(){
				if(threadPoolExecutor != null){
					// threadPoolExecutor.shutdown(); // required only if "newCachedThreadPool" is choosed to instantiate "threadPoolExecutor"
					threadPoolExecutor = null; // mark it as shut-down
				}
			}
			«ENDIF»
			
			public «IF fwd»Inv«ENDIF»«definition.declarationName.name.toFirstUpper» getInverse(){
				return new «IF fwd»Inv«ENDIF»«definition.declarationName.name.toFirstUpper»();
			}
			
			«compiledBody»
		}'''
	}

/*Generates java code for the functions. The fwd variable is used to generate code corresponding
 * to the regular function (fwd=true) or the inverse function (fwd=false)*/
	private def String compile(Body b, boolean  fwd, boolean[] hasParallelBlock) {
	  //This switch works by checking the variable type of b, similar to a java instanceof
	  switch (b) {
		//For each type of function, different java code is generated
		SerComp: {
			val serialSubblocksSequence = YarelUtils.getAllSequentialBodyBlocks(b)
			if(serialSubblocksSequence.size <= 1){
				'''
				«compile(b, fwd, hasParallelBlock)»
				'''
			}else{
				'''
				private final RPP[] steps = new RPP[]{
					«FOR step : serialSubblocksSequence SEPARATOR ",\n"»
					new RPP() { // «step.class.simpleName»
						«compile(step, fwd, hasParallelBlock)»
					}
					«ENDFOR»
				};
				private final int a = steps[0].getA();
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
					int i;
					«IF fwd»
					i = -1;
					while( ++i < steps.length ){
					«ELSE»
					i = steps.length;
					while( i-->0 ){
					«ENDIF»
						steps[i].b(x, startIndex, endIndex);
					}
				}
				'''
			}
			}
		ParComp:{
			/*Start refactoring ParComp by Marco Ottina */
			val totalArityParallelBody = YarelUtils.getArity(b as Body);
			var startIndexOffset = totalArityParallelBody; // since the tree is left-deep, otherwise would start from 0 and grow
			var Body subBlockToParallelize;
			var parallelNodeIterator = b as Body;
			val parallelSubBodies = new LinkedList<BodySubblockParallel>();
//				val identityBlocksOffsets = new LinkedList<Integer>();
			//collects ALL sub parts of a Yarel's parallel execution, running down the parse-tree
			while(parallelNodeIterator instanceof ParComp){
				// the grammar impose a left-deep tree, placing to the right the actual block of code
				subBlockToParallelize = (parallelNodeIterator as ParComp).right;
				// collect only non-identity bodies
				if(subBlockToParallelize instanceof BodyId){
					// don't waste time on "identity"
					startIndexOffset--; // the arity of "id" is just one 
				} else {
					val currentBlockArity = YarelUtils.getArity(subBlockToParallelize);
					startIndexOffset -= currentBlockArity; 
					parallelSubBodies.addFirst(new BodySubblockParallel(startIndexOffset, subBlockToParallelize, currentBlockArity));
				}
				parallelNodeIterator = (parallelNodeIterator as ParComp).left;
			}
			if(!(parallelNodeIterator instanceof BodyId)){ // don't waste time on "identity"
				val currentBlockArity = YarelUtils.getArity( subBlockToParallelize);
				parallelSubBodies.addFirst(new BodySubblockParallel(0, parallelNodeIterator, currentBlockArity));
			}
			// check the amount of useful code blocks
			if(parallelSubBodies.size == 1){
				val theOnlySubBlock = parallelSubBodies.get(0)
				'''
				private RPP f = new RPP(){
					«compile(theOnlySubBlock.body, fwd, hasParallelBlock)»
				};
				private final int a = «totalArityParallelBody» ;
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) {
					«IF startIndexOffset != 0»
					this.f.b(x, startIndex + «theOnlySubBlock.startIndexOffset», startIndex + this.a + «theOnlySubBlock.startIndexOffset»);
					«ELSE»
					this.f.b(x, startIndex, startIndex + this.a);
					«ENDIF»
				}
				'''
			}else if(parallelSubBodies.size > 1){
				hasParallelBlock.set(0, true); // truly parallel
				'''
				/**
				 * Yarel's code is a sequence of instructions, we could name them "code blocks". <br>
				 * Those blocks could be formed by a set of sub-blocks that requires to be executed in a parallel way. <br>
				 * This is the set of those sub-blocks (for a given code block), which are {@link RPP} instances. <br>
				 * The order is preserved from the Yarel source code.
				*/
				private final RPP[] subtasks = new RPP[]{
					«FOR subtask : parallelSubBodies SEPARATOR ",\n"»
						new RPP(){ // «subtask.body.class.simpleName»
							«compile(subtask.body, fwd, hasParallelBlock)»
						}
					«ENDFOR»
				};
				private final int[] startIndexOffsets = { «FOR subtask : parallelSubBodies SEPARATOR ","»«subtask.startIndexOffset»«ENDFOR» };
				private final int a = «totalArityParallelBody /*FOR i : 0..< parallelSubBodies.size SEPARATOR " + "»subtasks[«i»].getA()«ENDFOR*/»;
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
			'''
			}else { // nothing to do, also do not alter hasParallelBlock
				'''
				private final int a = «totalArityParallelBody»;
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) {
					// There were only parallels identities, nothing interesting to show and run
				}
				'''
			}
			/*End refactoring ParComp by Marco Ottina */
		}
		BodyId:
			'''
			private RPP f = new «IF !fwd»Inv«ENDIF»Id();
			private final int a = f.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex, endIndex);
			}
			public int getA() { return this.a; }
			''' 
		BodyInc: 
			'''
			private RPP f = new «IF !fwd»Inv«ENDIF»Inc();
			private final int a = f.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex, endIndex);
			}
			public int getA() { return this.a; }
			'''
		BodyDec:
			'''
			private RPP f = new «IF !fwd»Inv«ENDIF»Dec();
			private final int a = f.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex, endIndex);
			}
			public int getA() { return this.a; }
			''' 
		BodyNeg: 
			'''
			private RPP f = new «IF !fwd»Inv«ENDIF»Neg();
			private final int a = f.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex, endIndex);
			}
			public int getA() { return this.a; }
			'''
		BodyFun: {
			/*Changed by Matteo Palazzo*/
			val qualifiedName = qnp.getFullyQualifiedName(b.funName);
			val moduleName = qualifiedName.firstSegment;
			var functionName = (fwd ? "" : "Inv") + qualifiedName.lastSegment.toFirstUpper;
			if(moduleName != b.getContainerOfType(typeof(Model)).name)
			functionName = moduleName.toFirstLower + "." + functionName;	
			'''
			RPP function = new «functionName»();
			private final int a = function.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
			 public int getA() { return this.a; }
			'''
		}
		BodyPerm:
			'''
				private final int a = «b.permutation.indexes.length»;
				public void b(int[] x, int startIndex, int endIndex) {
					int tmp=0;
					«compileBodyPerm(b.permutation, fwd)»
				}
				
				public int getA() { return this.a; }
			'''
		BodyPermIndex:
			'''
			private final int permutArity = «b.permIndexed.permutationArity»;
			private final int a = 1 + permutArity;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp = x[startIndex], indexToWithdraw;
				indexToWithdraw = x[startIndex + this.permutArity];
				if(indexToWithdraw < 0){ indexToWithdraw = -indexToWithdraw; }
				indexToWithdraw--; // the index is 1-based
				indexToWithdraw = startIndex + (indexToWithdraw % this.permutArity);
				x[startIndex] = x[indexToWithdraw];
				x[indexToWithdraw] = tmp;
			}
			
			public int getA() { return this.a; }
			'''
		BodyInv:
			'''
				«compile(b.body, !fwd, hasParallelBlock)»
			'''
		BodyIt:
			'''
			// Iteration start
			RPP function = new RPP() { // «b.body.class.simpleName»
				«compile(b.body,fwd, hasParallelBlock)»
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
			'''
		BodyFor:
			/*
			 * Added by Paolo Parker as a recursive version,
			 * modified to the equivalent iterative version by Marco Ottina.
			 */
			'''
			/** regular function used when v > 0 */
			RPP function = new RPP() { // «b.body.class.simpleName»
				«/*the following call generates java code for the body of the "for" statement 
				(the expression contained in its square brackets)*/
				compile(b.body, fwd, hasParallelBlock)»
			};
			
			/** inverse function used when v < 0 */
			RPP inv_function = new RPP() { // Inv«b.body.class.simpleName»
				«compile(b.body,!fwd, hasParallelBlock)»
			};
			
			private final int a = function.getA()+1;
			public void b(int[] x, int startIndex, int endIndex) { //b stands for behaviour and x are the delta and v function parameters
				final int repCounterIndex = (startIndex + a) - 1, originalRepCounter;
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
			public int getA() { return this.a; } 
			'''
			
		BodyIf:
			'''
			RPP pos=new RPP() {
				«compile(b.pos,fwd, hasParallelBlock)»
			};
			RPP zero=new RPP() {
				«compile(b.zero,fwd, hasParallelBlock)»
			};
			RPP neg=new RPP() {
				«compile(b.neg,fwd, hasParallelBlock)»
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
			'''
	  }.toString
	}
	
	private def update(int[]p, int[]c,int k){
		var i = 0;
		var trovatoInizioCiclo = false;
		while (i < p.length && !trovatoInizioCiclo) {
		   var nonEsiste = true; 
		   var j = 0;
		   while (j < c.length && j < k &&  nonEsiste) {
			nonEsiste = i != c.get(j);
			j += 1;
		   }
		   trovatoInizioCiclo = nonEsiste;
  		   i = i + 1;
		}
		if (trovatoInizioCiclo)
			i = i - 1;
		return i ;
	}
	
	//Implements the permutation function
	private def compileBodyPerm(Permutation permutation, boolean fwd) {
		var p = newIntArrayOfSize(permutation.indexes.length) // stores the indexes
		var pVal=0
		var pPos=0
		
		// collect all permutations indexes
		for(var i=0; i<permutation.indexes.length; i++){
			if (fwd){
				p.set(i,permutation.indexes.get(i).value-1)
			}
			else{
				/*
				 * In forward, the values written in the permutation ("perm-entries") are
				 * the indexes indicating where to take register's value,
				 * while the "perm-entry" 's index inside the permutation is the index
				 * telling where to put that register's value.
				 * 
				 * In inverse, the "perm-entry" 's value tells the index where to put the
				 * register's value stored at tha "perm-entry" 's index.
				 */
				/**
				 * <pre> 
				 * For instance, the top permutations has the bottom ones as inverse:
				 * /  5    1    4    2    3    7    6  /
				 *    |    |    |    |    |    |    |
				 *     '\__/    | _/'  _/'      \  /
				 *        /'\_  \/   _/          ||
				 *       /    \/'\  /3           \/
				 *      /    / 5\_\/_            /\
				 *    1/   2/    / \ \5_         ||
				 *    /    /   3/  4\   \_5     /  \
				 *    |    |    |    |    |    |    |
				 * /  2    4    5    3    1    7    6  /
				 * </pre>
				 */
				pVal = permutation.indexes.get(i).value -1
				pPos = permutation.indexes.get(pVal).value -1
				p.set(pPos,pVal)
			}
		}
		
		var i=0
		var k=0
		var startCycle=0
		var enterCycle=false
		var c = newIntArrayOfSize(permutation.indexes.length) // stores all the cycles' steps in sequence, "k" is used as index
		var r=""
		
		/**
		 * A cycle in a permutations is a set of values which everyone "jumps" into
		 * another place (index), whose value "jumps" somewhere else, recursively to
		 * the last one, which jumps to the first one's place. Two example of a single
		 * cycle are <code> /1 2/ </code> and <code> / 4 5 3 6 1 2/ </code> ("3" is not
		 * "moving" and is not part of the cycle). Two subsequent cycles are <code> /4 3 1 2 7 5 6/ </code>
		 * <br>
		 * 
		 */
		
		while(i<permutation.indexes.length) {
			c.set(k,i) // store the start of the cycle (for instance, "4" of the second example above)
			k += 1
			startCycle = i
			enterCycle = p.get(i) != startCycle
			
			if(enterCycle){
				r=r+"tmp = x[startIndex + " + startCycle + "]; \n"
			}
			while(p.get(i)!=startCycle){
				r=r+"x[startIndex + " + i +"] = x[startIndex + " + p.get(i) + "]; \n"
				c.set(k++, p.get(i)); // store the "next step"
				i = p.get(i); // read the "next step" as an index, which will become the "current index" in the next iteration
			}
			
			if (enterCycle){
				r=r+"x[startIndex + " + i + "] = tmp; \n";
			}
			
			i = update(p,c,k); // look for the next cycle's start's index
		}
		return r
	}
	
	
	//Builds a java file that can be used to test the function/s declared and defined in the .rl file
	def CharSequence testFileGenerator(Model model) /*Added by Paolo Parker*/
	{
		val testFile = '''
		package «model.name.toFirstLower»;
		import yarelcore.*;
		import java.util.Arrays;
		
		public class «model.name.toFirstUpper»Test
		{
			public static void main(String[] args)
			{
				//Scrivere i test qui
			}
		}
		'''
		return testFile
	}
	
	override afterGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
	}
	
	override beforeGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
	}
	
	
	//USE THIS IF YOU GO FOR THE SOLUTION No 2: 
	var IQualifiedNameProvider qnp
		
	def doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context, IQualifiedNameProvider qnp){
		this.qnp = qnp
		doGenerate(resource, fsa, context)
	}
	
	/*The compiler's execution starts from this method*/
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
		//Looks for the Model in the .rl file
		val model = resource.allContents.toIterable.filter(Model).get(0)
	  val packageName = "yarelcore"//model.name
	  fsa.generateFile(packageName+"/WrongArityException.java", exceptionsGenerator(packageName))
	  fsa.generateFile(packageName+"/RPP.java", RPPGenerator(packageName))
	  fsa.generateFile(packageName+"/Id.java", IdGenerator(packageName))
	  fsa.generateFile(packageName+"/InvId.java", InvIdGenerator(packageName))
	  fsa.generateFile(packageName+"/Inc.java", IncGenerator(packageName))
	  fsa.generateFile(packageName+"/InvInc.java", InvIncGenerator(packageName))
	  fsa.generateFile(packageName+"/Dec.java", DecGenerator(packageName))
	  fsa.generateFile(packageName+"/InvDec.java", InvDecGenerator(packageName))
	  fsa.generateFile(packageName+"/Neg.java", NegGenerator(packageName))
	  fsa.generateFile(packageName+"/InvNeg.java", InvNegGenerator(packageName))
	  fsa.generateFile(packageName+"/SubBodyRunner.java", SubBodyRunnerGenerator(packageName))
	  
	  collectArities(model)
	  //Generates java code starting from the Model
	  compile(fsa, model)
	 
	  //Tests
	  fsa.generateFile(model.name.toFirstLower + "/" + model.name.toFirstUpper + "Test.java", testFileGenerator(model))
	  
	  //Play source
	 	fsa.generateFile(model.name.toFirstLower + "/" + model.name.toFirstUpper + "PlayWith.java", playGenerator(model.name.toFirstLower, model))
	}
	
	//
	
	static class BodySubblockParallel{
		var int startIndexOffset;
		val int bodyArity;
		val Body body;
		
		protected new(int startIndexOffset, Body body){
			this(startIndexOffset, body, YarelUtils.getArity(body));
		}
		protected new(int startIndexOffset, Body body, int bodyArity){
			this.startIndexOffset = startIndexOffset;
			this.body = body;
			this.bodyArity = bodyArity;
		}
		def int getStartIndexOffset(){
			 return this.startIndexOffset;
		}
		def Body getBody(){
			 return this.body;
		}
		def int getBodyArity(){
			 return this.bodyArity;
		}
	}
}