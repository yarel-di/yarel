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

import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Body
import org.di.unito.yarel.yarel.SerComp
import org.di.unito.yarel.yarel.ParComp
import org.di.unito.yarel.yarel.BodyInv
import org.di.unito.yarel.yarel.BodyFun
import org.di.unito.yarel.yarel.BodyIt
import org.di.unito.yarel.yarel.BodyIf
import org.di.unito.yarel.yarel.BodyPerm
import org.di.unito.yarel.yarel.BodyInc
import org.di.unito.yarel.yarel.BodyNeg
import org.di.unito.yarel.yarel.BodyDec
import org.di.unito.yarel.yarel.BodyId
import org.di.unito.yarel.yarel.BodyFor
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.Model
import java.util.HashMap
import java.util.Map

import static extension org.eclipse.xtext.EcoreUtil2.*
import org.di.unito.yarel.yarel.Permutation
import org.di.unito.yarel.yarel.Import
import com.google.inject.Inject
//import static extension org.eclipse.xtext.naming.IQualifiedNameProvider.*
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.IQualifiedNameProvider.AbstractImpl
import org.di.unito.yarel.scoping.YarelIndex
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.nodemodel.INode
import com.google.common.collect.Iterables
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.resource.ILocationInFileProvider

class JavaYarelGenerator implements IGenerator2 {
	
	static final String OUTPUT_TEST = "output_test"
	
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
		public interface RPP {
			public int getA();
			public int[] b(int[] x);
		}
		'''}
		
	//Implements the identity function
	private def IdGenerator(String packageName) {
		'''
		package «packageName»;
		public class Id implements RPP {
			private final int a = 1;
			public int[] b(int[] x) {
				return x;
			}
			public int getA() { return this.a; }
		}
		'''}
		
	//Implements the inverse of the identity function	
	private def InvIdGenerator(String packageName) {
		'''
		package «packageName»;
		public class InvId implements RPP {
			private RPP f = new Id();
			private final int a = this.f.getA();
			public int[] b(int[] x) {
				return this.f.b(x);
			}
			public int getA() { return this.a; }
		}
		'''}
	
	//Implements the increase function
	private def IncGenerator(String packageName) {
		'''
		package «packageName»;
		public class Inc implements RPP {
			private final int a = 1;
			public int[] b(int[] x) {
				x[0] = x[0] + 1;
				return x;
			}
			public int getA() { return this.a; }
		}
		'''}
	
	//Implements the inverse of the increase function
	private def InvIncGenerator(String packageName) {
		'''
		package «packageName»;
		public class InvInc implements RPP {
			private RPP f = new Dec();
			private final int a = this.f.getA();
			public int[] b(int[] x) {
				return this.f.b(x);
			}
			public int getA() { return this.a; }
		}
		'''}
	
	//Implements the decrease function
	private def DecGenerator(String packageName) {
		'''
		package «packageName»;
		public class Dec implements RPP {
			private final int a = 1;
			public int[] b(int[] x) {
				x[0] = x[0] - 1;
				return x;
			}
			public int getA() { return this.a; }
		}
		'''}
	
	//Implements the inverse of the decrease function
	private def InvDecGenerator(String packageName) {
		'''
		package «packageName»;
		public class InvDec implements RPP {
			private RPP f = new Inc();
			private final int a = this.f.getA();;
			public int[] b(int[] x) {
				return this.f.b(x);
			}
			public int getA() { return this.a; }
		}
		'''}
	
	//Implements the neg function
	private def NegGenerator(String packageName) {
		'''
		package «packageName»;
		public class Neg implements RPP {
			private final int a = 1;
			public int[] b(int[] x) {
				x[0] = -x[0];
				return x;
			}
			public int getA() { return this.a; }
		}
		'''}
	
	//Implements the inverse of the neg function
	private def InvNegGenerator(String packageName) {
		'''
		package «packageName»;
		public class InvNeg implements RPP {
			private RPP f = new Neg();
			private final int a = this.f.getA();;
			public int[] b(int[] x) {
				return this.f.b(x);
			}
			public int getA() { return this.a; }
		}
		'''}
	
	//Generates an executable java file to run a simple test on the function/s declared in the .rl file.
	private def playGenerator(String packageName, Model model) {
		
		val functionNames = model.elements.filter(Definition).map[ it.declarationName.name ]
		
		'''
		package «packageName»;
		import yarelcore.*;
		import java.util.Arrays;
		
		public class «packageName.toFirstUpper»PlayWith {
			public static void main(String[] args) throws Exception {
				 «FOR name : functionNames»
				 	RPP «name»RPP = new «packageName».«name.toFirstUpper»();
				 	for(int i : «name»RPP.b(new int[] {«FOR i : 0 ..< arities.get(name) - 1»«i+1»,«ENDFOR»5})) {
				 			System.out.println(i);
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
			if(m.elements.get(i).getContainerOfType(Declaration)!==null) { // if a declaration exists
				var arity = 0
				for(var j = 0; j < (m.elements.get(i) as Declaration).signature.types.length; j++) // every type component
					if ((m.elements.get(i) as Declaration).signature.types.get(j).value != 0)
						arity = arity + (m.elements.get(i) as Declaration).signature.types.get(j).value // counts the explicit number of occurrences
					else  
					    arity++ // counts +1
			   arities.put((m.elements.get(i) as Declaration).name, arity)
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
	 * future uses
	 */
	private def generateImports(Model m){
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
	    '''
		package «model.name.toFirstLower»;
		import java.util.Arrays;
		import java.lang.Math;
		import yarelcore.*;	
		public class «IF !fwd»Inv«ENDIF»«definition.declarationName.name.toFirstUpper» implements RPP {
		    public «IF !fwd»Inv«ENDIF»«definition.declarationName.name.toFirstUpper»() { }
		    «compile(definition.body, fwd)»
		}'''
	}

/*Generates java code for the functions. The fwd variable is used to generate code corresponding
 * to the regular function (fwd=true) or the inverse function (fwd=false)*/
    private def String compile(Body b, boolean  fwd ) {
        //This switch works by checking the variable type of b, similar to a java instanceof
        switch (b) {
          //For each type of function, different java code is generated
          SerComp: 
          	'''
          	RPP l = new RPP() {
          		«compile(b.left, fwd)»
          	};
          	RPP r = new RPP() {
          		«compile(b.right, fwd)»
          	};
          	private final int a = l.getA();
          	public int[] b(int[] x) { // Implements a serial composition.
          		return «IF fwd»this.r.b(this.l.b(x))«ENDIF»«IF !fwd»this.l.b(this.r.b(x))«ENDIF»;
          	}
          	public int getA() { return this.a; }
          	'''
          ParComp: 
          	'''
          	RPP l = new RPP() {
          		«compile(b.left, fwd)»
          	};
          	RPP r = new RPP() {
          		«compile(b.right, fwd)»
          	};
          	private final int a = l.getA() + r.getA();
          	public int[] b(int[] x) { // Implements a parallel composition
          		return append(l.b(Arrays.copyOfRange(x,0       ,l.getA()         ))
          		,r.b(Arrays.copyOfRange(x,l.getA(),l.getA()+r.getA())));
          	}
          	public int getA() { return this.a; }
          	private int[] append(int[] l, int[] r) {
          		int[] res = new int[l.length + r.length];
          		for(int i = 0; i < l.length; i++)
          			res[i] = l[i];
          		for(int i = 0; i < r.length; i++) 
          		  	res[i + l.length] = r[i];
          	 	return res;
          	}
          '''
          BodyId:
          	'''
          	private RPP f = new «IF !fwd»Inv«ENDIF»Id();
          	private final int a = f.getA();
          	public int[] b(int[] x) {
          		return this.f.b(x);
          	}
          	public int getA() { return this.a; }
          	''' 
          BodyInc: 
          	'''
          	private RPP f = new «IF !fwd»Inv«ENDIF»Inc();
          	private final int a = f.getA();
          	public int[] b(int[] x) {
          		return this.f.b(x);
          	}
          	public int getA() { return this.a; }
          	'''
          BodyDec:
          	'''
          	private RPP f = new «IF !fwd»Inv«ENDIF»Dec();
          	private final int a = f.getA();
          	public int[] b(int[] x) {
          		return this.f.b(x);
          	}
          	public int getA() { return this.a; }
          	''' 
          BodyNeg: 
          	'''
          	private RPP f = new «IF !fwd»Inv«ENDIF»Neg();
          	private final int a = f.getA();
          	public int[] b(int[] x) {
          		return this.f.b(x);
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
          	public int[] b(int[] x) { 
          		  	return this.function.b(x);
          	}
          	 public int getA() { return this.a; }
          	'''
          	/*
          	SOLUTION No1:
          	val funName = b.getActualString()
          	val pointIndex = funName.lastIndexOf('.')
          	var containingPackage = "" //the name of the module (and so the package) that contain the function
          	var functionName = ""
          	if(pointIndex >= 0){//the functionName is a QualifiedName
          		containingPackage = funName.substring(0, pointIndex + 1)//include the point
          		functionName = funName.substring(pointIndex + 1)
          	}
          	else{
          		functionName = funName
          	}
          	'''
          	RPP function = new «containingPackage»«IF !fwd»Inv«ENDIF»«functionName.toFirstUpper»();
          	private final int a = function.getA();
          	public int[] b(int[] x) { 
          		  	return this.function.b(x);
          	}
          	 public int getA() { return this.a; }          
          	'''
          	*/
          }
          BodyPerm:
          	'''
          	private final int a = «b.permutation.indexes.length»;
          	public int[] b(int[] x) {
          		int tmp=0;
          		«compileBodyPerm(b.permutation, fwd)»
          		return x;
          	}
          	public int getA() { return this.a; }
	      	'''
	      BodyInv:
          	'''
          	«compile(b.body, !fwd)»
	      	'''
	      BodyIt:
          	'''
		  	// Iteration start
		  	RPP function = new RPP() {
		  		«compile(b.body,fwd)»
		  	};
		  	private final int a = function.getA()+1;
		  	public int[] b(int[] x) {
		  		int[] t=Arrays.copyOfRange(x,0,function.getA());
		  		for(int i = 0 ; i < Math.abs(x[x.length - 1]); i++){
		  			t = function.b(t);
		  		}
		  		int[] r=new int[x.length];
		  		for (int i=0; i<t.length; i++){
		  			r[i]=t[i];
		  		}
		  		r[r.length-1]=x[x.length-1];
		  		return r;
		  	}
		  	public int getA() { return this.a; } 
		  	// Iteration stop
	      	'''
	      BodyFor: /*Added by Paolo Parker*/
          	'''
		  	RPP function = new RPP() //regular function used when v > 0
		  	{
		  		«/*the following call generates java code for the body of the "for" statement 
		  		  (the expression contained in its square brackets)*/
		  		compile(b.body,fwd)»
		  	};
		  	
		  	RPP inv_function = new RPP() //inverse function used when v < 0
		  	{
		  		«compile(b.body,!fwd)»
		  	};
		  	
		  	private final int a = function.getA()+1;
		  	public int[] b(int[] x) //b stands for behaviour and x are the delta and v function parameters
		  	{
		  		int[] t = new int[x.length-1]; //t stands for temporary array, as it's used each time only locally
		  		
		  		for(int i=0; i<t.length; i++)
		  		{
		  			t[i] = x[i];
		  		}
		  		
		  		if(x[x.length-1] > 0) //if v is greater than zero, recursion goes on and v decreases each time
		  		{
		  			t = function.b(t);
		  			x[x.length-1] = x[x.length-1] - 1;
		  			for(int i=0; i<x.length-1; i++)
		  			{
		  				x[i] = t[i];
		  			}
		  			x = b(x);
		  			x[x.length-1] = x[x.length-1] + 1; //takes v back to its original value in the later stage of recursion
		  		}
		  		
		  		if(x[x.length-1] < 0) //if v is less than zero, recursion goes on and v increases each time
		  		{
		  			t = inv_function.b(t);
		  			x[x.length-1] = x[x.length-1] + 1;
		  			for(int i=0; i<x.length-1; i++)
		  			{
		  				x[i] = t[i];
		  			}
		  			x = b(x);
		  			x[x.length-1] = x[x.length-1] - 1; //takes v back to its original value in the later stage of recursion
		  		}
		  	
		  		if(x[x.length-1] == 0) //when v is equal to zero, recursive calls stop as a value is returned
		  		{
		  			return x;
		  		}
		  		return x;
		  	}
		  	public int getA() { return this.a; } 
	      	'''
	      BodyIf:
          	'''
	  		RPP pos=new RPP() {
	  			«compile(b.pos,fwd)»
	  		};
	  		RPP zero=new RPP() {
	  			«compile(b.zero,fwd)»
	  		};
	  		RPP neg=new RPP() {
	  			«compile(b.neg,fwd)»
	  		};
	  		private final int a=pos.getA()+1;
	  		public int getA() {return this.a;}
	  		public int[] b(int[] x) {
	  			int[] t=Arrays.copyOfRange(x,0,pos.getA());	  		
	  			if(x[x.length-1]>0){
	  				t=pos.b(t);
	  			}
	  			if(x[x.length-1]==0){
	  				t=zero.b(t);
	  			}
	  			if(x[x.length-1]<0){
	  				t=neg.b(t);
	  			}
	  			int[] r = new int[x.length];
	  			for (int i = 0; i < t.length; i++){
	  				r[i]=t[i];
	  			}
	  			r[r.length-1]=x[x.length-1];
	  			return r;
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
				r=r+"tmp = x["+startCycle+"]; \n"
			}
			while(p.get(i)!=startCycle){
				r=r+"x["+ i +"] = x["+ p.get(i) + "]; \n"
				c.set(k, p.get(i));
				k = k + 1;
				i = p.get(i);	
			}
			
			if (enterCycle){
			    r=r+"x["+i+"] = tmp; \n";
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
        collectArities(model)
        //Generates java code starting from the Model
        compile(fsa, model)
       
        //Tests
        fsa.generateFile(model.name.toFirstLower + "/" + model.name.toFirstUpper + "Test.java", testFileGenerator(model))
        
        //Play source
       	fsa.generateFile(model.name.toFirstLower + "/" + model.name.toFirstUpper + "PlayWith.java", playGenerator(model.name.toFirstLower, model))
	}	


	/*private def getActualString(EObject elem){
		val ICompositeNode node = NodeModelUtils.getNode(elem);
		node.text.trim
	}*/
	
	/**
	 * MEMO:
	 * Ho trovato due soluzioni per risolvere il problema degli import
	 * SOLUZIONE No1:
	 * La prima consiste nel accedere direttamente al testo corrispondente a BodyFun
	 * In questa maniera è immediatamente possibile sapere se la cross reference è stata risolta
	 * usando il nome qualificato dell'oggetto oppure no.
	 * Tuttavia attraverso questa soluzione si naviga nell'albero di parsing
	 * (E' un operazione dispensiosa?)
	 * --
	 * SOLUZIONE No2:
	 * La seconda consiste nell'usare in ogni caso i nomi qualificati delle funzioni.
	 * Sia in presenza di un ambiguità che no.
	 * In questo modo diventano anche non necessari gli import nel codice java generato.
	 * L'operazione è sicuramente meno dispensiosa della prima, tuttavia il codice generato
	 * potrebbe diventare meno leggibile
	 */
}