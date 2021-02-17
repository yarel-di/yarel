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
			 * "Ariety".
			 * <p>
			 * Returns the ariety of this operator.<br>
			 * For instance, <i>increment</i> has <code>1</code> as ariety.
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
		public class SubBodyRunner implements Runnable{
			protected final int startingIndex;
			protected final int[] registers;
			protected final RPP subBody;
			
			protected SubBodyRunner(int startingIndex, RPP subBody, int[] registers){
				this.startingIndex = startingIndex;
				this.subBody = subBody;
				this.registers = registers;
			}
			
			public int getStartingIndex(){ return this.startingIndex; }
			public RPP getSubBody(){ return this.subBody; }
			
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
		
		public class «packageName.toFirstUpper»PlayWith {
			public static void main(String[] args) throws Exception {
				«FOR name : functionNames SEPARATOR "\n\n\n"»
					RPP «name»RPP = new «packageName».«name.toFirstUpper»();
					«val arity = getArity(name)»
					final int[][] datasetTest«name.toFirstUpper» = {
						new int[]{«FOR i : 0 ..< arity - 1»«i+1»,«ENDFOR»5},
						new int[]{«FOR i : arity - 1 >..0»«i+1»,«ENDFOR»5},
						«FOR i : 0..< baseValuesData.size »
							«val baseValue = baseValuesData.get(i)»
							new int[]{«FOR rep : 0 ..< arity SEPARATOR ", "» «baseValue»«ENDFOR»},
						«ENDFOR»
					};
					for( int[] data: datasetTest«name.toFirstUpper» ){
						System.out.println("\nTesting: " + Arrays.toString(data));
						«name»RPP.b(data);
						System.out.println("Resulting in: " + Arrays.toString(data));
					}
				«ENDFOR»
			}
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
			
			public «IF fwd»Inv«ENDIF»«definition.declarationName.name.toFirstUpper»  getInverse(){
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
			SerComp: 
				'''
				RPP l = new RPP() {
					«compile(b.left, fwd, hasParallelBlock)»
				};
				RPP r = new RPP() {
					«compile(b.right, fwd, hasParallelBlock)»
				};
				private final int a = l.getA();
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
					«IF fwd»
					this.l.b(x, startIndex, endIndex);
					this.r.b(x, startIndex, endIndex);
					«ENDIF»
					«IF !fwd»
					this.r.b(x, startIndex, endIndex);
					this.l.b(x, startIndex, endIndex);
					«ENDIF»
				}
				'''
			ParComp:{ 
				val parallelSubBodiesReversed = new LinkedList<Body>();
				var parallelNodeIterator = b as Body;
				hasParallelBlock.set(0, true); 
				//collects ALL sub parts of a Yarel's parallel execution, running down the parse-tree
				while(parallelNodeIterator instanceof ParComp){
					parallelSubBodiesReversed.addFirst(parallelNodeIterator.right ); 
					parallelNodeIterator = (parallelNodeIterator as ParComp).left;
				}
				parallelSubBodiesReversed.addFirst(parallelNodeIterator);
				'''
				private final RPP[] subtasks = new RPP[]{
					«FOR subtask : parallelSubBodiesReversed SEPARATOR ",\n"»
						new RPP(){
							«compile(subtask, fwd, hasParallelBlock)»
						}
					«ENDFOR»
				};
				private final int a = «FOR i : 0..< parallelSubBodiesReversed.size SEPARATOR " + "»subtasks[«i»].getA()«ENDFOR»;
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) { // Implements a parallel composition
					final int[] semaphore = new int[]{ subtasks.length };
					final Runnable[] tasks = new Runnable[ semaphore[0] ];
					int lowerIndex = startIndex;
					for(int i = 0; i < tasks.length; i++){
						tasks[i] = new SubBodyRunner(lowerIndex, subtasks[i], x){
							public void run(){
								super.run();
								synchronized (semaphore) {
									if(--semaphore[0] <= 0){
										semaphore.notifyAll();
									}
								}
							}
						};
						lowerIndex += subtasks[i].getA();
					}
					synchronized (semaphore) { // acquire the lock, so that the parallel executions must be performed AFTER this thread sleeps.
						threadPoolExecutor.submit( ()-> {
							/* This "submitter", whick task is to submit all parallel tasks, can't run while
								the main thread has the lock. It's required since this task *could* be
								executed BEFORE the main thread sleeps.
							*/
							synchronized (semaphore) {
								for(Runnable t : tasks){
									threadPoolExecutor.submit(t);
								}
							}
						});
						try {
							semaphore.wait(); // the main thread sleeps, releasing the lock and THEN allowing the parallel tasks to be exected
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			'''
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
		BodyInv:
			'''
				«compile(b.body, !fwd, hasParallelBlock)»
			'''
		BodyIt:
			'''
			// Iteration start
			RPP function = new RPP() {
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
		BodyFor: /*Added by Paolo Parker, modified to the iterative version by Marco Ottina.*/
			'''
		  	RPP function = new RPP() //regular function used when v > 0
		  	{
		  		«/*the following call generates java code for the body of the "for" statement 
		  		  (the expression contained in its square brackets)*/
		  		compile(b.body,fwd, hasParallelBlock)»
		  	};
		  	
		  	RPP inv_function = new RPP() //inverse function used when v < 0
		  	{
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
		  				function.b(x, startIndex, endIndex);
		  				x[repCounterIndex]--;
		  			}
		  		}else if(repetitionCounter < 0){ //if v is greater than zero, recursion goes on and v decreases each time
		  			endIndex = startIndex + inv_function.getA();
		  			while(repetitionCounter++<0){
		  				inv_function.b(x, startIndex, endIndex);
		  				x[repCounterIndex]++;
		  			}
		  		} //else: when v is equal to zero, recursive calls stop as a value is returned
		  		x[repCounterIndex] = originalRepCounter;
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
	  			if(testValue>0){
	  				pos.b(x, startIndex, startIndex + pos.getA());
	  			}else if(testValue==0){
	  				zero.b(x, startIndex, startIndex + zero.getA());
	  			}else { // The "testValue<0" test is a tautology
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
		var p = newIntArrayOfSize(permutation.indexes.length)
		var pVal=0
		var pPos=0
		
		for(var i=0; i<permutation.indexes.length; i++){
			if (fwd){
				p.set(i,permutation.indexes.get(i).value-1)
			}
			else{
				pVal = permutation.indexes.get(i).value -1
				pPos = permutation.indexes.get(pVal).value -1
				p.set(pPos,pVal)
			}
		}
		
		var i=0
		var k=0
		var startCycle=0
		var enterCycle=false
		var c = newIntArrayOfSize(permutation.indexes.length)
		var r=""
		
		while(i<permutation.indexes.length) {
			c.set(k,i)
			k += 1
			startCycle = i
			enterCycle = p.get(i) != startCycle
			
			if(enterCycle){
				r=r+"tmp = x[startIndex + " +startCycle + "]; \n"
			}
			while(p.get(i)!=startCycle){
				r=r+"x[startIndex + " + i +"] = x[startIndex + " + p.get(i) + "]; \n"
				c.set(k, p.get(i));
				k = k + 1;
				i = p.get(i);	
			}
			
			if (enterCycle){
				r=r+"x[startIndex + " + i + "] = tmp; \n";
			}
			
			i = update(p,c,k);
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
}