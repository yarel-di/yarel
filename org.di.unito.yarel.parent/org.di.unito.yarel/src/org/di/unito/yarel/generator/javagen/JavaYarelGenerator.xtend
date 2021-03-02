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
import java.util.LinkedList
import java.util.Map
import org.di.unito.yarel.utils.ComposedArity
import org.di.unito.yarel.utils.YarelUtils
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
import org.di.unito.yarel.yarel.BodyParamDec
import org.di.unito.yarel.yarel.BodyParamId
import org.di.unito.yarel.yarel.BodyParamInc
import org.di.unito.yarel.yarel.BodyParamNeg
import org.di.unito.yarel.yarel.BodyParamPerm
import org.di.unito.yarel.yarel.BodyPerm
import org.di.unito.yarel.yarel.BodySwap
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
import org.di.unito.yarel.yarel.SwapIndexed

// Modified by Marco Ottina
class JavaYarelGenerator implements IGenerator2 {
//	@Inject extension YarelUtils yarelUtils
	
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
	// Modified by Marco Ottina
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
			public static final RPP SINGLETON_Id = new Id();
			private final int __a__ = 1;
			public int getA() { return this.__a__; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__){  }
		}
		'''}
		
	//Implements the inverse of the identity function	
	private def InvIdGenerator(String packageName) {
		'''
		package «packageName»;
		public class InvId implements RPP {
			public static final RPP SINGLETON_InvId = new InvId();
			private RPP __f__ = Id.SINGLETON_Id;
			private final int __a__ = this.__f__.getA();
			public int getA() { return this.__a__; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__){
				this.__f__.b(__x__, __startIndex__, __endIndex__);
			}
		}
		'''}
	
	//Implements the increase function
	private def IncGenerator(String packageName) {
		'''
		package «packageName»;
		public class Inc implements RPP {
			public static final RPP SINGLETON_Inc = new Inc();
			private final int __a__ = 1;
			public int getA() { return this.__a__; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				__x__[__startIndex__]++;
			}
		}
		'''}
	
	//Implements the inverse of the increase function
	private def InvIncGenerator(String packageName) {
		'''
		package «packageName»;
		public class InvInc implements RPP {
			public static final RPP SINGLETON_InvInc = new InvInc();
			private RPP __f__ = Dec.SINGLETON_Dec;
			private final int __a__ = this.__f__.getA();
			public int getA() { return this.__a__; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__, __startIndex__, __endIndex__);
			}
		}
		'''}
	
	//Implements the decrease function
	private def DecGenerator(String packageName) {
		'''
		package «packageName»;
		public class Dec implements RPP {
			public static final RPP SINGLETON_Dec = new Dec();
			private final int __a__ = 1;
			public int getA() { return this.__a__; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				__x__[__startIndex__]--;
			}
		}
		'''}
	
	//Implements the inverse of the decrease function
	private def InvDecGenerator(String packageName) {
		'''
		package «packageName»;
		public class InvDec implements RPP {
			public static final RPP SINGLETON_InvDec = new InvDec();
			private RPP __f__ = Inc.SINGLETON_Inc;
			private final int __a__ = this.__f__.getA();
			public int getA() { return this.__a__; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__, __startIndex__, __endIndex__);
			}
		}
		'''}
	
	//Implements the neg function
	private def NegGenerator(String packageName) {
		'''
		package «packageName»;
		public class Neg implements RPP {
			public static final RPP SINGLETON_Neg = new Neg();
			private final int __a__ = 1;
			public int getA() { return this.__a__; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				__x__[__startIndex__] = -__x__[__startIndex__];
			}
		}
		'''}
	
	//Implements the inverse of the neg function
	private def InvNegGenerator(String packageName) {
		'''
		package «packageName»;
		public class InvNeg implements RPP {
			public static final RPP SINGLETON_InvNeg = new InvNeg();
			private RPP __f__ = Neg.SINGLETON_Neg;
			private final int __a__ = this.__f__.getA();
			public int getA() { return this.__a__; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__, __startIndex__, __endIndex__);
			}
		}
		'''}
	
	//Implements the swap function
	// Made by Marco Ottina
	private def SwapGenerator(String packageName) {
		'''
		package «packageName»;
		public class Swap implements RPP {
			public Swap(int arity, int firstIndex, int secondIndex){
				if(arity < 1) throw new IllegalArgumentException("Swap arity cannot be less than 1");
				this.__arity__ = arity;
				firstIndex %= __arity__;
				if(firstIndex < 0){ firstIndex = -firstIndex; }
				this.__firstIndex__ = firstIndex;
				secondIndex %= __arity__;
				if(secondIndex < 0){ secondIndex = -secondIndex; }
				this.__secondIndex__ = secondIndex;
			}
			protected Swap(){
				this(1, 0, 0);
			}
			protected final int __arity__;
			protected final int __firstIndex__;
			protected final int __secondIndex__;
			public int getA() { return 1 + this.__arity__; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __temp__ = __x__[__startIndex__ + this.__firstIndex__]; 
				__x__[__startIndex__ + this.__firstIndex__] = __x__[__startIndex__ + this.__secondIndex__];
				__x__[__startIndex__ + this.__secondIndex__] = __temp__;
				/**
				 * SRL implementation: // <br>
				int __temp__ = __x__[__startIndex__ + this.__firstIndex__]; // <br>
				for(int __i__ = 0; __i__ < __temp__; i++){ __x__[__startIndex__ + this.__arity__]++; } // <br>
				for(int __i__ = 0; __i__ < __temp__; i++){ __x__[__startIndex__ + this.__firstIndex__]--; } // <br>
				__temp__ = __x__[__startIndex__ + this.__secondIndex__]; // <br>
				for(int __i__ = 0; __i__ < __temp__; i++){ __x__[__startIndex__ + this.__firstIndex__]++; } // <br>
				for(int __i__ = 0; __i__ < __temp__; i++){ __x__[__startIndex__ + this.__secondIndex__]--; } // <br>
				__temp__ = __startIndex__ + this.__arity__; // <br>
				for(int __i__ = 0; __i__ < __temp__; i++){ __x__[__startIndex__ + this.__secondIndex__]++; } // <br>
				for(int __i__ = 0; __i__ < __temp__; i++){ __x__[__startIndex__ + this.__arity__]--; } // <br>
				*/
			}
		}
		'''}
	
	//Implements the inverse of the Swap function
	// Made by Marco Ottina
	private def InvSwapGenerator(String packageName) {
		'''
		package «packageName»;
		public class InvSwap implements RPP { // the Swap is the identity of itself
			public InvSwap(int __arity__, int __firstIndex__, int __secondIndex__){
				this.__f__ = new Swap(__arity__, __firstIndex__, __secondIndex__);
			}
			public InvSwap(){
				this.__f__ = new Swap();
			}
			private final RPP __f__;
			public int getA() { return this.__f__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__, __startIndex__, __endIndex__);
			}
		}
		'''}
	
	//Implements useful in parallel executions
	// Made by Marco Ottina
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
	
	// Made by Marco Ottina
//	private def AritySupplierGenerator(String packageName) {
//		return '''
//		package «packageName»;
//		
//		import java.util.function.Supplier;
//		
//		/**
//		 * Simple interface to provide an integer, used in a parallel contex.<br>
//		 * This definition is required since Java forbids defining (and also
//		 * instantiation too) arrays of classes whose have generics in their definition.
//		*/
//		interface AritySupplier extends Supplier<Integer> {
//		}
//		'''
//	}
	
	//Generates an executable java file to run a simple test on the function/s declared in the .rl file.
	// Modified by Marco Ottina
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
				val decl = (element as Declaration)
				var arity = (decl.aritySignature !== null && decl.aritySignature.parametricArities !== null)
					? decl.aritySignature.parametricArities.size : 0;
				for(var j = 0; j < decl.aritySignature.types.size; j++) // every type component
					if (decl.aritySignature.types.get(j).value != 0)
						arity += decl.aritySignature.types.get(j).value // counts the explicit number of occurrences
					else  
						arity++ // counts +1
				arities.put(decl.name, arity)
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
		var r = new StringBuilder()
		val imports = m.imports
		for(impt : imports){
			if(impt.importedNamespace.endsWith('*')){//the import use a wildcard
				r.append("import ").append(impt.importedNamespace).append("; \n");
			}
			else{//import of a single function
				val pointIndex = impt.importedNamespace.lastIndexOf('.')
				val packageName = impt.importedNamespace.substring(0, pointIndex)
				val functionName = impt.importedNamespace.substring(pointIndex + 1).toFirstUpper
				//import also the inverse function
				val invFunctionName = "Inv" + impt.importedNamespace.substring(pointIndex + 1).toFirstUpper
				r.append("import ").append(packageName).append('.').append(functionName).append("; \n");
				r.append( "import ").append(packageName).append('.').append(invFunctionName).append("; \n");
			}
		}
		r.toString()
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
	
	// Changed by Marco Ottina
	// class compilation
	private def compile(Model model, Definition definition, boolean fwd) {
		val hasParallelBlock = newBooleanArrayOfSize(1);
		hasParallelBlock.set(0, false);
		
		val Declaration declaration = YarelUtils.getDeclaration(definition)
		if(declaration === null){
			throw new NullPointerException("declaration not found for definition: "+ definition.declarationName.name)
		}
		val declArity     = YarelUtils.getArity(declaration)
		val declParams    = declaration.invocParamsSignat === null ? null : declaration.invocParamsSignat.invocParam.map[it.parName];
		val hasDeclParams = (declParams !== null && (! declParams.empty))
		val className = (fwd?"":"Inv") + definition.declarationName.name.toFirstUpper
		val compiledBody = compile(definition.body, fwd, hasParallelBlock, declArity);
		return '''
		package «model.name.toFirstLower»;
		«IF hasParallelBlock.get(0)»
		import java.util.concurrent.ExecutorService;
		import java.util.concurrent.Executors;
		// import java.util.function.Supplier;
		«ENDIF»
		import yarelcore.*;	
		
		public class «className» implements RPP {
			«IF declArity.isParametric || hasDeclParams»
			public «className»(«FOR parName : declArity.parametersCoefficients.keySet BEFORE "//arities:\n\t" SEPARATOR ", "»int «parName.replace('\b', '_')»«ENDFOR»
				«IF hasDeclParams»«IF declArity.isParametric»,«"\n"»«ENDIF»«FOR par: declParams SEPARATOR ",\n"»int «par»«ENDFOR»«ENDIF»
				){
				this.__fixedRegistersAmount__ = «declArity.scalar»;
				«FOR par : declArity.parametersCoefficients.entrySet SEPARATOR "\n"»
				if(«par.key.replace('\b', '_')» < 0){ throw new WrongArityException("The arity \"«par.key.replace('\b', '_')»\" cannot be negative: " + «par.key.replace('\b', '_')»); }
				this.«par.key.replace('\b', '_')» = «par.key.replace('\b', '_')»;
				«ENDFOR»
				«IF hasDeclParams»«FOR par: declParams»
				if(«par.replace('\b', '_')» < 0){ throw new WrongArityException("The parameter \"«par.replace('\b', '_')»\" cannot be negative: " + «par.replace('\b', '_')»); }
				this.«par.replace('\b', '_')» = «par.replace('\b', '_')»;
				«ENDFOR»«ENDIF»
			}
			protected «className»(){
				this(«FOR par : declArity.parametersCoefficients.entrySet SEPARATOR ", "»«par.value»«ENDFOR»«IF hasDeclParams»«IF declArity.isParametric»,«ENDIF»«FOR par: declParams SEPARATOR ", "»0«ENDFOR»«ENDIF»);
			}
			
			protected final int __fixedRegistersAmount__;
			«FOR par: declArity.parametersCoefficients.entrySet»protected final int «par.key.replace('\b', '_')»;«ENDFOR»
			«IF hasDeclParams»«FOR par: declParams SEPARATOR "\n"»protected final int «par.replace('\b', '_')»;«ENDFOR»«ENDIF»
			«ELSE»
			public «className»() { }
			«ENDIF»
			
			
			«IF hasDeclParams»
			public int getFixedRegistersAmount(){
				return this.__fixedRegistersAmount__;
			}
			«FOR par: declArity.parametersCoefficients.entrySet»
			public int get«par.key.replace('\b', '_').toFirstUpper»(){ return this.«par.key.replace('\b', '_')»; }
			«ENDFOR»«ENDIF»
			«IF hasDeclParams»«FOR par: declParams SEPARATOR "\n"»
			public int get«par.replace('\b', '_').toFirstUpper»(){ return this.«par.replace('\b', '_')»; }
			«ENDFOR»«ENDIF»
			
			«IF declArity.isParametric  || hasDeclParams»protected RPP __theWholeBody__ = null;«ENDIF»
		
			«IF hasParallelBlock.get(0)»
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
				this.destructor«definition.declarationName.name.toFirstUpper»();
			}
			protected void destructor«definition.declarationName.name.toFirstUpper»(){
				if(__threadPoolExecutor__ != null){
					// __threadPoolExecutor__.shutdown(); // required only if "newCachedThreadPool" is choosed to instantiate "threadPoolExecutor"
					__threadPoolExecutor__ = null; // mark it as shut-down
				}
			}
			«ENDIF»
			
			«IF declArity.isParametric || hasDeclParams»
			public «IF fwd»Inv«ENDIF»«definition.declarationName.name.toFirstUpper» getInverse(){
				return new «IF fwd»Inv«ENDIF»«definition.declarationName.name.toFirstUpper»(«FOR parName : declArity.parametersCoefficients.keySet SEPARATOR ", "»this.«parName.replace('\b', '_')»«ENDFOR»«IF hasDeclParams»«IF declArity.isParametric»,«ENDIF»«FOR par: declParams SEPARATOR ", "»«par»«ENDFOR»«ENDIF»);
			}
			
			public int getA() {
				this.checkTheWholeBody();
				//return this.__theWholeBody__.getA();
				return this.__fixedRegistersAmount__«FOR par: declArity.parametersCoefficients.entrySet BEFORE " + " SEPARATOR" + "»this.«par.key.replace('\b', '_')»«ENDFOR»;
			}
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.checkTheWholeBody();
				this.__theWholeBody__.b(__x__, __startIndex__, __endIndex__);
			}
			protected void checkTheWholeBody(){
				if(this.__theWholeBody__ == null){
					this.__theWholeBody__ = new RPP(){
						«compiledBody»
					};
				}
			}
			«ELSE»
			public «IF fwd»Inv«ENDIF»«definition.declarationName.name.toFirstUpper» getInverse(){
				return new «IF fwd»Inv«ENDIF»«definition.declarationName.name.toFirstUpper»();
			}
			
			«compiledBody»
			«ENDIF»
		}'''
	}

	/*Generates java code for the functions. The fwd variable is used to generate code corresponding
	 * to the regular function (fwd=true) or the inverse function (fwd=false)*/
	// Changed by Marco Ottina
	private def String compile(Body b, boolean  fwd, boolean[] hasParallelBlock, ComposedArity declarationArity) {
	  //This switch works by checking the variable type of b, similar to a java instanceof
	  switch (b) {
		//For each type of function, different java code is generated
		SerComp: {
			val serialSubblocksSequence = YarelUtils.getAllSequentialBodyBlocks(b)
			if(serialSubblocksSequence.size <= 1){
				'''
				«compile(b, fwd, hasParallelBlock, declarationArity)»
				'''
			}else{
				'''
				private final RPP[] __steps__ = new RPP[]{
					«FOR step : serialSubblocksSequence SEPARATOR ",\n"»
					new RPP() { // «step.class.simpleName»
						«compile(step, fwd, hasParallelBlock, declarationArity)»
					}
					«ENDFOR»
				};
				public int getA() { return this.__steps__[0].getA(); }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
					int __i__;
					«IF fwd»
					__i__ = -1;
					while( ++__i__ < __steps__.length ){
					«ELSE»
					__i__ = __steps__.length;
					while( __i__-->0 ){
					«ENDIF»
						__steps__[__i__].b(__x__, __startIndex__, __endIndex__);«/*It's not required, here, to think about the composed arity: all available space must be used*/»
					}
				}
				'''
			}
			}
		ParComp:{
			/*Start refactoring ParComp by Marco Ottina */
			val totalArityParallelBody = YarelUtils.getArity(b as Body);
			val startIndexOffset = totalArityParallelBody.clone(); // since the tree is left-deep, otherwise would start from 0 and grow
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
//					startIndexOffset--; // the arity of "id" is just one
					startIndexOffset.removeScalar(1)
				} else if(subBlockToParallelize instanceof BodyParamId){
					// don't waste time on "identities"
					startIndexOffset.subtract(YarelUtils.getArity(subBlockToParallelize))
				} else {
					val currentBlockArity = YarelUtils.getArity(subBlockToParallelize);
//					startIndexOffset -= currentBlockArity;
					startIndexOffset.subtract(currentBlockArity)
					parallelSubBodies.addFirst(
						new BodySubblockParallel(
							startIndexOffset.clone(),
							subBlockToParallelize,
							currentBlockArity.clone()
						)
					);
				}
				parallelNodeIterator = (parallelNodeIterator as ParComp).left;
			}
			if(!(parallelNodeIterator instanceof BodyId || parallelNodeIterator instanceof BodyParamId)){
				 // don't waste time on "identit(y/ies)"
				val currentBlockArity = YarelUtils.getArity( subBlockToParallelize);
				parallelSubBodies.addFirst(
					new BodySubblockParallel(
						new ComposedArity(0),
						parallelNodeIterator,
						currentBlockArity
				));
			}
			// check the amount of useful code blocks
			if(parallelSubBodies.size == 1){
				val theOnlySubBlock = parallelSubBodies.get(0)
				'''
				private RPP __f__ = new RPP(){
					«compile(theOnlySubBlock.body, fwd, hasParallelBlock, declarationArity)»
				};
				public int getA() { return «totalArityParallelBody.toString()»; }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__,
						__startIndex__ + «theOnlySubBlock.startIndexOffset.toString()»,
						__startIndex__ + («theOnlySubBlock.startIndexOffset.toString()») + («theOnlySubBlock.bodyArity.toString»)
						);
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
				private final RPP[] __subtasks__ = new RPP[]{
					«FOR subtask : parallelSubBodies SEPARATOR ",\n"»
						new RPP(){ // «subtask.body.class.simpleName»
							«compile(subtask.body, fwd, hasParallelBlock, declarationArity)»
						}
						
					«ENDFOR»
				};
				/*
				private final AritySupplier[] __startIndexOffsetSuppliers__ = { //
					«FOR subtask : parallelSubBodies  SEPARATOR ", //\n"»() -> { return «subtask.startIndexOffset.toString()»;}«ENDFOR»
				};
				*/
				private final int[] __startIndexOffset__ = {
					«FOR subtask : parallelSubBodies  SEPARATOR ", //\n"»«subtask.startIndexOffset.toString()»«ENDFOR»
				};
				public int getA() { return («totalArityParallelBody.toString() /*FOR i : 0..< parallelSubBodies.size SEPARATOR " + "»__subtasks__[«i»].getA()«ENDFOR*/»); }
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
			'''
			}else { // nothing to do, also do not alter hasParallelBlock
				'''
				public int getA() { return «totalArityParallelBody.toString()»; }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					// There were only parallels identities, nothing interesting to show and run
				}
				'''
			}
			/*End refactoring ParComp by Marco Ottina */
		}
		BodyId:
			'''
			private RPP __f__ = «IF !fwd»Inv«ENDIF»Id.SINGLETON_«IF !fwd»Inv«ENDIF»Id;
			private final int __a__ = __f__.getA();
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__, __startIndex__, __endIndex__);
			}
			public int getA() { return __f__.getA(); }
			'''
		BodyParamId:
			'''
			public int getA() { return «YarelUtils.getArity(b.arity).toString()»; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) { }
			'''
		BodyInc: 
			'''
			private RPP __f__ = «IF !fwd»Inv«ENDIF»Inc.SINGLETON_«IF !fwd»Inv«ENDIF»Inc;
			private final int __a__ = __f__.getA();
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__, __startIndex__, __endIndex__);
			}
			public int getA() { return this.__a__; }
			'''
		BodyDec:
			'''
			private RPP __f__ = «IF !fwd»Inv«ENDIF»Dec.SINGLETON_«IF !fwd»Inv«ENDIF»Dec;
			private final int __a__ = __f__.getA();
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__, __startIndex__, __endIndex__);
			}
			public int getA() { return this.__a__; }
			''' 
		BodyNeg: 
			'''
			private RPP __f__ = «IF !fwd»Inv«ENDIF»Neg.SINGLETON_«IF !fwd»Inv«ENDIF»Neg;
			private final int __a__ = __f__.getA();
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__, __startIndex__, __endIndex__);
			}
			public int getA() { return this.__a__; }
			'''
		BodyParamInc:{
			val bParArity = YarelUtils.getArity(b.arity)
			val ComposedArity repetitions = (b.paramsAssign === null || b.paramsAssign.parameters === null || b.paramsAssign.parameters.size === 0)?
				new ComposedArity(1) : YarelUtils.getArity(b.paramsAssign.parameters.get(0));
			'''
			private RPP __f__ = «IF !fwd»Inv«ENDIF»Inc.SINGLETON_«IF !fwd»Inv«ENDIF»Inc;
			public int getA() { return «bParArity.toString()»; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __arity__ = this.getA();
				«IF repetitions !== null»
				int __repsAmount__ = «repetitions.toString()»;
				for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
				«ENDIF»
				for(int __i__ = 0; __i__ < __arity__; __i__++){
					this.__f__.b(__x__, __startIndex__ + __i__, __startIndex__ + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
				} 
				«IF repetitions !== null»
				}
				«ENDIF»
			}
			'''
		}
		BodyParamDec:{
			val bParArity = YarelUtils.getArity(b.arity)
			val ComposedArity repetitions = (b.paramsAssign === null || b.paramsAssign.parameters === null || b.paramsAssign.parameters.size === 0)?
				new ComposedArity(1) : YarelUtils.getArity(b.paramsAssign.parameters.get(0));
			'''
			private RPP __f__ = «IF !fwd»Inv«ENDIF»Dec.SINGLETON_«IF !fwd»Inv«ENDIF»Dec;
			public int getA() { return «bParArity.toString()»; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __arity__ = this.getA();
				«IF repetitions !== null»
				int __repsAmount__ = «repetitions.toString()»;
				for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
				«ENDIF»
				for(int __i__ = 0; __i__ < __arity__; __i__++){
					this.__f__.b(__x__, __startIndex__ + __i__, __startIndex__ + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
				} 
				«IF repetitions !== null»
				}
				«ENDIF»
			}
			'''
		}
		BodyParamNeg:{
			val bParArity = YarelUtils.getArity(b.arity)
			val ComposedArity repetitions = (b.paramsAssign === null || b.paramsAssign.parameters === null || b.paramsAssign.parameters.size === 0)?
				new ComposedArity(1) : YarelUtils.getArity(b.paramsAssign.parameters.get(0));
			'''
			private RPP __f__ = «IF !fwd»Inv«ENDIF»Neg.SINGLETON_«IF !fwd»Inv«ENDIF»Neg;
			public int getA() { return «bParArity.toString()»; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __arity__ = this.getA();
				«IF repetitions !== null»
				int __repsAmount__ = «repetitions.toString()»;
				if( __repsAmount__ > 0 ){ __repsAmount__ = __repsAmount__ & 0x1; } // === "% 2"
				for(int __reps__ = 0; __reps__ < __repsAmount__; __reps__++){
				«ENDIF»
				for(int __i__ = 0; __i__ < __arity__; __i__++){
					this.__f__.b(__x__, __startIndex__ + __i__, __startIndex__ + __i__ + 1); // "1" because "f.getA()" will surely returns "1"
				} 
				«IF repetitions !== null»
				}
				«ENDIF»
			}
			'''
		}
		BodySwap:{ //Added by Marco Ottina, could be removed since can be implemented directly in Yarel
			val swapFun = b.function as SwapIndexed
			val swapArity  = YarelUtils.getArity(swapFun.arity)
			val firstIndex = YarelUtils.getArity(swapFun.paramsAssign.parameters.get(0))
			val secondIndex= YarelUtils.getArity(swapFun.paramsAssign.parameters.get(1))
			'''
			public int getA() { return 1 + «swapArity.toString()»; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __arity__ = this.getA() - 1;
				RPP __f__ = new «IF !fwd»Inv«ENDIF»Swap(
					__arity__, //
					((«firstIndex.toString()») - 1) % __arity__, // Yarel's indexes are 1-based
					((«secondIndex.toString()») - 1) % __arity__ //
				);
				__f__.b(__x__, __startIndex__, __endIndex__);
			}
			'''
		}
		BodyFun: {
			/*Changed by Matteo Palazzo and Marco Ottina*/
			/*
			 * First provide the arities, then the invocation parameters
			  */
			val theFunc = b.function
			val qualifiedName = qnp.getFullyQualifiedName(theFunc.funName);
			val moduleName = qualifiedName.firstSegment;
			var functionName = (fwd ? "" : "Inv") + qualifiedName.lastSegment.toFirstUpper;
//			val funcArity = yarelUtils.getArityOfFunctionName(b, functionName)
			if(moduleName != b.getContainerOfType(typeof(Model)).name)
			functionName = moduleName.toFirstLower + "." + functionName;
			'''
			«IF YarelUtils.hasSomeParameters(theFunc)»
			RPP __function__ = new «functionName»(
				«IF theFunc.aritiesAssign !== null && theFunc.aritiesAssign.arities.size > 0»
				«FOR arityParam : theFunc.aritiesAssign.arities SEPARATOR ",\n"»«YarelUtils.getArity(arityParam).toString()»«ENDFOR»
				«/*if also params exists..*/IF theFunc.paramsAssign !== null && theFunc.paramsAssign.parameters.size > 0»,«ENDIF»
				«ENDIF»
				«IF theFunc.paramsAssign !== null && theFunc.paramsAssign.parameters.size > 0»
				«FOR arityParam : theFunc.paramsAssign.parameters SEPARATOR ",\n"»«YarelUtils.getArity(arityParam).toString()»«ENDFOR»
				«ENDIF»
			);
			«ELSE»
			RPP __function__ = new «functionName»();
			«ENDIF»
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
			'''
		}
		BodyPerm:
			'''
				private final int __a__ = «b.permutation.indexes.length»;
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					int __tmp__=0;
					«compileBodyPerm(b.permutation, fwd)»
				}
				public int getA() { return this.__a__; }
			'''
		BodyParamPerm:
			'''
			public int getA() { return 1 + «YarelUtils.getArity(b.arity)»; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				final int __permutArity__ = this.getA() - 1;
				int __tmp__ = __x__[__startIndex__], __indexToWithdraw__;
				__indexToWithdraw__ = __x__[__startIndex__ + __permutArity__];
				if(__indexToWithdraw__ < 0){ __indexToWithdraw__ = -__indexToWithdraw__; }
				__indexToWithdraw__--; // the index is 1-based
				__indexToWithdraw__ = __startIndex__ + (__indexToWithdraw__ % __permutArity__);
				__x__[__startIndex__] = __x__[__indexToWithdraw__];
				__x__[__indexToWithdraw__] = __tmp__;
			}
			'''
		BodyInv:
			'''
				«compile(b.body, !fwd, hasParallelBlock, declarationArity)»
			'''
		BodyIt:
			'''
			// Iteration start
			RPP __function__ = new RPP() { // «b.body.class.simpleName»
				«compile(b.body,fwd, hasParallelBlock, declarationArity.clone().addScalar(-1))»
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
			'''
		BodyFor:
			/*
			 * Added by Paolo Parker as a recursive version,
			 * modified to the equivalent iterative version by Marco Ottina.
			 */
			'''
			/** regular function used when v > 0 */
			RPP __function__ = new RPP() { // «b.body.class.simpleName»
				«/*the following call generates java code for the body of the "for" statement 
				(the expression contained in its square brackets)*/
				compile(b.body, fwd, hasParallelBlock, declarationArity.clone().addScalar(-1))»
			};
			
			/** inverse function used when v < 0 */
			RPP __inv_function__ = new RPP() { // Inv«b.body.class.simpleName»
				«compile(b.body,!fwd, hasParallelBlock, declarationArity)»
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
			'''
			
		BodyIf:
			'''
			«val declArityBodies = declarationArity.clone().addScalar(-1)»
			RPP __pos__=new RPP() {
				«compile(b.pos,fwd, hasParallelBlock, declArityBodies)»
			};
			RPP __zero__=new RPP() {
				«compile(b.zero,fwd, hasParallelBlock, declArityBodies)»
			};
			RPP __neg__=new RPP() {
				«compile(b.neg,fwd, hasParallelBlock, declArityBodies)»
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
			'''
//		AtomicParametricRepetition:{
//			println("E che classe è? " + b.class.name )
//			println("\t has it an funName? " + b.funName)
//			compile(b.func, fwd, hasParallelBlock, declarationArity)
//		}
		default:
			throw new RuntimeException("Unrecognized body: " + b.toString + " ------- ")
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
				r=r+"__tmp__ = __x__[__startIndex__ + " + startCycle + "]; \n"
			}
			while(p.get(i)!=startCycle){
				r=r+"__x__[__startIndex__ + " + i +"] = __x__[__startIndex__ + " + p.get(i) + "]; \n"
				c.set(k++, p.get(i)); // store the "next step"
				i = p.get(i); // read the "next step" as an index, which will become the "current index" in the next iteration
			}
			
			if (enterCycle){
				r=r+"__x__[__startIndex__ + " + i + "] = __tmp__; \n";
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
//		fsa.generateFile(packageName+"/AritySupplier.java", AritySupplierGenerator(packageName))
		fsa.generateFile(packageName+"/SubBodyRunner.java", SubBodyRunnerGenerator(packageName))
		fsa.generateFile(packageName+"/Id.java", IdGenerator(packageName))
		fsa.generateFile(packageName+"/InvId.java", InvIdGenerator(packageName))
		fsa.generateFile(packageName+"/Inc.java", IncGenerator(packageName))
		fsa.generateFile(packageName+"/InvInc.java", InvIncGenerator(packageName))
		fsa.generateFile(packageName+"/Dec.java", DecGenerator(packageName))
		fsa.generateFile(packageName+"/InvDec.java", InvDecGenerator(packageName))
		fsa.generateFile(packageName+"/Neg.java", NegGenerator(packageName))
		fsa.generateFile(packageName+"/InvNeg.java", InvNegGenerator(packageName))
		fsa.generateFile(packageName+"/Swap.java", SwapGenerator(packageName))
		fsa.generateFile(packageName+"/InvSwap.java", InvSwapGenerator(packageName))
		
		
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
		var ComposedArity startIndexOffset;
		val ComposedArity bodyArity;
		val Body body;
		
		protected new(ComposedArity startIndexOffset, Body body){
			this(startIndexOffset, body, YarelUtils.getArity(body));
		}
		protected new(ComposedArity startIndexOffset, Body body, ComposedArity bodyArity){
			this.startIndexOffset = startIndexOffset;
			this.body = body;
			this.bodyArity = bodyArity;
		}
		def ComposedArity getStartIndexOffset(){
			 return this.startIndexOffset;
		}
		def Body getBody(){
			 return this.body;
		}
		def ComposedArity getBodyArity(){
			 return this.bodyArity;
		}
	}
}