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
import org.di.unito.yarel.yarel.BodyTof
import org.di.unito.yarel.yarel.BodyNot
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.Model
import java.util.HashMap
import java.util.Map

import static extension org.eclipse.xtext.EcoreUtil2.*
import org.di.unito.yarel.yarel.Import
import org.di.unito.yarel.yarel.Permutation

class JavaYarelGenerator implements IGenerator2 {
	
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
	
	/**
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
	private def RPPGenerator(String packageName) {
		'''
		package «packageName»;
		import java.util.ArrayList;
		public interface RPP {
			public int getA();
			public ArrayList<Object> b(ArrayList<Object> x);
		}
		'''}
	
	/**
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
	private def IdGenerator(String packageName) {
		'''
		package «packageName»;
		import java.util.ArrayList;
		public class id implements RPP {
			private final int a = 1;
			public ArrayList<Object> b(ArrayList<Object> x) {
				return x;
			}
			public int getA() { return this.a; }
		}
		'''}
	
	/**
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */	
	private def InvIdGenerator(String packageName) {
		'''
		package «packageName»;
		import java.util.ArrayList;
		public class inv_id implements RPP {
			private RPP f = new id();
			private final int a = this.f.getA();
			public ArrayList<Object> b(ArrayList<Object> x) {
				return this.f.b(x);
			}
			public int getA() { return this.a; }
		}
		'''}
	
	/**
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
	private def IncGenerator(String packageName) {
		'''
		package «packageName»;
		import java.util.ArrayList;
		public class inc implements RPP {
			private final int a = 1;
			public ArrayList<Object> b(ArrayList<Object> x) {
				x.set(0, (Integer)x.get(0) + 1);
				return x;
			}
			public int getA() { return this.a; }
		}
		'''}
	
	/**
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
	private def InvIncGenerator(String packageName) {
		'''
		package «packageName»;
		import java.util.ArrayList;
		public class inv_inc implements RPP {
			private RPP f = new dec();
			private final int a = this.f.getA();
			public ArrayList<Object> b(ArrayList<Object> x) {
				return this.f.b(x);
			}
			public int getA() { return this.a; }
		}
		'''}
	
	/**
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
	private def DecGenerator(String packageName) {
		'''
		package «packageName»;
		import java.util.ArrayList;
		public class dec implements RPP {
			private final int a = 1;
			public ArrayList<Object> b(ArrayList<Object> x) {
				x.set(0, (Integer)x.get(0) - 1);
				return x;
			}
			public int getA() { return this.a; }
		}
		'''}
	
	/**
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
	private def InvDecGenerator(String packageName) {
		'''
		package «packageName»;
		import java.util.ArrayList;
		public class inv_dec implements RPP {
			private RPP f = new inc();
			private final int a = this.f.getA();;
			public ArrayList<Object> b(ArrayList<Object> x) {
				return this.f.b(x);
			}
			public int getA() { return this.a; }
		}
		'''}
	
	/**
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
	private def NegGenerator(String packageName) {
		'''
		package «packageName»;
		import java.util.ArrayList;
		public class neg implements RPP {
			private final int a = 1;
			public ArrayList<Object> b(ArrayList<Object> x) {
				x.set(0, - (Integer) x.get(0));
				return x;
			}
			public int getA() { return this.a; }
		}
		'''}
	
	/**
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
	private def InvNegGenerator(String packageName) {
		'''
		package «packageName»;
		import java.util.ArrayList;
		public class inv_neg implements RPP {
			private RPP f = new neg();
			private final int a = this.f.getA();;
			public ArrayList<Object> b(ArrayList<Object> x) {
				return this.f.b(x);
			}
			public int getA() { return this.a; }
		}
		'''}
	
	/**
	 * Added by Riccardo Viola.
	 */
	private def TofGenerator(String packageName) {
		'''
		package «packageName»;
		import java.util.ArrayList;
		public class tof implements RPP {
			private final int a = 3;
			public ArrayList<Object> b(ArrayList<Object> x) {
				ArrayList<Object> r = new ArrayList<Object>();
				r.add(x.get(0));
				r.add(x.get(1));
				Boolean c = (Boolean) x.get(2);
				if(c.booleanValue() == false){
					r.add(  ((Boolean) x.get(0)) && ((Boolean) x.get(1)));
				}else{
					r.add(!(((Boolean) x.get(0)) && ((Boolean) x.get(1))) );
				}
				return r;
			}
			public int getA() { return this.a; }
		}
		'''}
	
	/**
	 * Added by Riccardo Viola.
	 */
	private def InvTofGenerator(String packageName) {
		'''
		package «packageName»;
		import java.util.ArrayList;
		public class inv_tof implements RPP {
			private RPP f = new tof();
			private final int a = this.f.getA();;
			public ArrayList<Object> b(ArrayList<Object> x) {
				return this.f.b(x);
			}
			public int getA() { return this.a; }
		}
		'''}
	
	/**
	 * Added by Riccardo Viola.
	 */
	private def NotGenerator(String packageName) {
		'''
		package «packageName»;
		import java.util.ArrayList;
		public class not implements RPP {
			private final int a = 1;
			public ArrayList<Object> b(ArrayList<Object> x) {
				ArrayList<Object> r = new ArrayList<Object>();
				r.add(!((Boolean) x.get(0)));
				return r;
			}
			public int getA() { return this.a; }
		}
		'''}
	
	/**
	 * Added by Riccardo Viola.
	 */
	private def InvNotGenerator(String packageName) {
		'''
		package «packageName»;
		import java.util.ArrayList;
		public class inv_not implements RPP {
			private RPP f = new not();
			private final int a = this.f.getA();;
			public ArrayList<Object> b(ArrayList<Object> x) {
				return this.f.b(x);
			}
			public int getA() { return this.a; }
		}
		'''}
	
	/**
	 * Generates an executable java file to run a simple test on the function/s declared in the .rl file
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
	private def playGenerator(String packageName, Model model) {
		val functionNames = model.elements.filter(Definition).map[ it.declarationName.name ]
		'''
		package «packageName»;
		import Yarelcore.*;
		import java.util.ArrayList;
		
		public class «packageName»PlayWith {
			public static void main(String[] args) throws Exception {
				 «FOR name : functionNames»
				 	RPP «name»RPP = new «packageName».«name»();
				 	ArrayList<Object> x = new ArrayList<Object>();
				 	x.add(«arities.get(name)»);
				 	System.out.println( «name»RPP.b(x).toString() );
				 «ENDFOR»
			}
		}
		'''}
	
    /**
	 * Stores the arity of every declared name
	 */
	val Map<String,Integer> arities = new HashMap<String,Integer>;
	
	/**
	 * Associates every declared name to its arity
	 */
	private def collectArities(Model m) {
		for(var i = 0; i < m.elements.length; i++){
			if(m.elements.get(i).getContainerOfType(Declaration)!==null) { // if a declaration exists
				var arity = 0
				for(var j = 0; j < (m.elements.get(i) as Declaration).signaturesL.types.length; j++) // every type component
					if ((m.elements.get(i) as Declaration).signaturesL.types.get(j).value != 0)
						arity = arity + (m.elements.get(i) as Declaration).signaturesL.types.get(j).value // counts the explicit number of occurrences
					else  
					    arity++ // counts +1
			   arities.put((m.elements.get(i) as Declaration).name, arity)
			}
		}
	}

	/**
	 * Reads the arity of the given declared name
	 */
	private def getArity(String name) {
		return arities.get(name);
	}
	
	private def generateImports(Model m){
		var r=""  
		for(var i = 0; i < m.elements.length; i++){
			if(m.elements.get(i).getContainerOfType(Import)!==null) {
				//println("IMPORT: " + (m.elements.get(i) as Import).name)
				r=r + "import "+(m.elements.get(i) as Import).importedNamespace.toString+"; \n"
				
			}
		}
		return r		
	}	
	
	/**
	 * Starts the compilation from the root of the AST which is Model
	 */
	private def compile(IFileSystemAccess2 fsa, Model model) {
		var definitions = model.elements.filter(Definition)
		val folder = model.name + "/"
        for(definition: definitions) {
        	var compilation = compile(model, definition, true)
            fsa.generateFile(folder + definition.declarationName.name+".java", compilation)
            compilation = compile(model, definition, false)
            fsa.generateFile(folder + "inv_"+definition.declarationName.name+".java", compilation)
        }
	}
	    
	/**
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
    private def compile(Model model, Definition definition, boolean fwd) {
	    '''
		package «model.name»;
		import java.util.ArrayList;
		import java.lang.Math;
		import Yarelcore.*;
		«generateImports(model)»
		public class «IF !fwd»inv_«ENDIF»«definition.declarationName.name» implements RPP {
		    public «IF !fwd»inv_«ENDIF»«definition.declarationName.name»() { }
		    «compile(definition.body, fwd)»
		}'''}

	/**
	 * Generates java code for the functions. The fwd variable is used to generate code corresponding
	 * to the regular function (fwd=true) or the inverse function (fwd=false)
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
    private def String compile(Body b, boolean  fwd ) {
        switch (b) {
          SerComp: 
          	'''
          	RPP l = new RPP() {
          		«compile(b.left, fwd)»
          	};
          	RPP r = new RPP() {
          		«compile(b.right, fwd)»
          	};
          	private final int a = l.getA();
          	public ArrayList<Object> b(ArrayList<Object> x) {
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
          	public ArrayList<Object> b(ArrayList<Object> x) {
          		ArrayList<Object> lA = new ArrayList<Object>();
          		ArrayList<Object> rA = new ArrayList<Object>();
          		for(int i=0       ; i < l.getA()         ; i++){
          			lA.add(x.get(i));
          		}
          		for(int i=l.getA(); i < l.getA()+r.getA(); i++){
          			rA.add(x.get(i));
          		}
          		ArrayList<Object> res = l.b(lA);
          		res.addAll(r.b(rA));
          		return res;
          	}
          	public int getA() { return this.a; }
          '''
          BodyId:
          	'''
          	private RPP f = new «IF !fwd»inv_«ENDIF»id();
          	private final int a = f.getA();
          	public ArrayList<Object> b(ArrayList<Object> x) {
          		return this.f.b(x);
          	}
          	public int getA() { return this.a; }
          	''' 
          BodyInc: 
          	'''
          	private RPP f = new «IF !fwd»inv_«ENDIF»inc();
          	private final int a = f.getA();
          	public ArrayList<Object> b(ArrayList<Object> x) {
          		return this.f.b(x);
          	}
          	public int getA() { return this.a; }
          	'''
          BodyDec:
          	'''
          	private RPP f = new «IF !fwd»inv_«ENDIF»dec();
          	private final int a = f.getA();
          	public ArrayList<Object> b(ArrayList<Object> x) {
          		return this.f.b(x);
          	}
          	public int getA() { return this.a; }
          	''' 
          BodyNeg: 
          	'''
          	private RPP f = new «IF !fwd»inv_«ENDIF»neg();
          	private final int a = f.getA();
          	public ArrayList<Object> b(ArrayList<Object> x) {
          		return this.f.b(x);
          	}
          	public int getA() { return this.a; }
          	'''
          BodyTof: 
          	'''
          	private RPP f = new «IF !fwd»inv_«ENDIF»tof();
          	private final int a = f.getA();
          	public ArrayList<Object> b(ArrayList<Object> x) {
          		return this.f.b(x);
          	}
          	public int getA() { return this.a; }
          	'''
          BodyNot: 
          	'''
          	private RPP f = new «IF !fwd»inv_«ENDIF»not();
          	private final int a = f.getA();
          	public ArrayList<Object> b(ArrayList<Object> x) {
          		return this.f.b(x);
          	}
          	public int getA() { return this.a; }
          	'''
          BodyFun: 
          	'''
          	RPP function = new «IF !fwd»inv_«ENDIF»«b.funName.name»();
          	private final int a = function.getA();
          	public ArrayList<Object> b(ArrayList<Object> x) { 
          		  	return this.function.b(x);
          	}
          	 public int getA() { return this.a; }          
          	'''
          BodyPerm:
          	'''
          	private final int a = «b.permutation.indexes.length»;
          	public ArrayList<Object> b(ArrayList<Object> x) {
          		Integer tmp = new Integer(0);
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
		  	public ArrayList<Object> b(ArrayList<Object> x) {
		  		ArrayList<Object> t = new ArrayList<Object>();
		  		for(int i=0; i <= function.getA(); i++){
		  			t.add(x.get(i));
		  		}
		  		for(int i=0; i < Math.abs((Integer)x.get(x.size()-1)); i++){
		  			t = function.b(t);
		  		}
		  		ArrayList<Object> r = new ArrayList<Object>();
		  		for(int i=0; i < t.size(); i++){
		  			r.add(t.get(i));
		  		}
		  		r.set(r.size()-1, x.get(x.size()-1));
		  		return r;
		  	}
		  	public int getA() { return this.a; } 
		  	// Iteration stop
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
	  		public ArrayList<Object> b(ArrayList<Object> x) {
	  			ArrayList<Object> t = new ArrayList<Object>();
	  			for(int i=0; i <= pos.getA(); i++){
	  				t.add(x.get(i));
	  			} 		
	  			if((Integer)x.get(x.size()-1)>0){
	  				t=pos.b(t);
	  			}
	  			if((Integer)x.get(x.size()-1)==0){
	  				t=zero.b(t);
	  			}
	  			if((Integer)x.get(x.size()-1)<0){
	  				t=neg.b(t);
	  			}
	  			ArrayList<Object> r = new ArrayList<Object>();
	  			for (int i = 0; i < t.size(); i++){
	  				r.add(t.get(i));
	  			}
	  			r.set(r.size()-1, x.get(x.size()-1));
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
    
    /**
	 * Implements the permutation function
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
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
				r=r+"tmp = (Integer) x.get("+startCycle+"); \n"
			}
			while(p.get(i)!=startCycle){
				r=r+"x.set("+ i +", x.get("+ p.get(i) +")); \n"
				c.set(k, p.get(i));
				k = k + 1;
				i = p.get(i);	
			}
			if (enterCycle){
			    r=r+"x.set("+i+", tmp); \n";
			}
			i = update(p,c,k);					
		}
		return r
	}
	
	/**
	 * Builds a java file that can be used to test the function/s declared and defined in the .rl file
	 * Taken from Paolo Parker. Modified by Riccardo Viola.
	 */
	def CharSequence testFileGenerator(Model model){
		val testFile = '''
		package «model.name»;
		import Yarelcore.*;
		import java.util.ArrayList;
		
		public class «model.name»Test
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
	
	/**
	 * The compiler's execution starts from this method
	 * Taken from Dariush. Modified by Riccardo Viola.
	 */
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		//Looks for the Model in the .rl file
		val model = resource.allContents.toIterable.filter(Model).get(0)
        val packageName = "Yarelcore"//model.name
        fsa.generateFile(packageName+"/WrongArityException.java", exceptionsGenerator(packageName))
        fsa.generateFile(packageName+"/RPP.java", RPPGenerator(packageName))
        fsa.generateFile(packageName+"/id.java", IdGenerator(packageName))
        fsa.generateFile(packageName+"/inv_id.java", InvIdGenerator(packageName))
        fsa.generateFile(packageName+"/inc.java", IncGenerator(packageName))
        fsa.generateFile(packageName+"/inv_inc.java", InvIncGenerator(packageName))
        fsa.generateFile(packageName+"/dec.java", DecGenerator(packageName))
        fsa.generateFile(packageName+"/inv_dec.java", InvDecGenerator(packageName))
        fsa.generateFile(packageName+"/neg.java", NegGenerator(packageName))
        fsa.generateFile(packageName+"/inv_neg.java", InvNegGenerator(packageName))
        fsa.generateFile(packageName+"/tof.java", TofGenerator(packageName))
        fsa.generateFile(packageName+"/inv_tof.java", InvTofGenerator(packageName))
        fsa.generateFile(packageName+"/not.java", NotGenerator(packageName))
        fsa.generateFile(packageName+"/inv_not.java", InvNotGenerator(packageName))
        
        collectArities(model)
        //Generates java code starting from the Model
        compile(fsa, model)
       
        //Tests
        fsa.generateFile(model.name + "/" + model.name + "Test.java", testFileGenerator(model))
        
        //Play source
       	fsa.generateFile(model.name + "/" + model.name + "PlayWith.java", playGenerator(model.name, model))
	}
	
}