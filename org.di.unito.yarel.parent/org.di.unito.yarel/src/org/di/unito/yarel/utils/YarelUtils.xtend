package org.di.unito.yarel.utils

import java.util.LinkedList
import org.di.unito.yarel.yarel.AdditionLEWP
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
import org.di.unito.yarel.yarel.BodyParamId
import org.di.unito.yarel.yarel.BodyPerm
import org.di.unito.yarel.yarel.BodyPermIndex
import org.di.unito.yarel.yarel.BracketLEWP
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.Import
import org.di.unito.yarel.yarel.IntLEWP
import org.di.unito.yarel.yarel.LinearExpressionWithParameters
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.ParComp
import org.di.unito.yarel.yarel.ParamLEWP
import org.di.unito.yarel.yarel.ParametricArity
import org.di.unito.yarel.yarel.SerComp
import org.di.unito.yarel.yarel.SubtractionLEWP

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.di.unito.yarel.scoping.YarelIndex.*
import org.eclipse.emf.ecore.EObject
import org.di.unito.yarel.yarel.FunctionInvocation
import org.di.unito.yarel.scoping.YarelIndex
import org.di.unito.yarel.yarel.MinusLEWP
import org.di.unito.yarel.yarel.PlusLEWP

/* Added by Matteo Palazzo */
class YarelUtils {
	
	def static Definition getDefinition(Declaration decl){
		var i = 0
		var Definition deff = null
		val currentModule = decl.getContainerOfType(typeof(Model))
		val defs = currentModule.definitions
		while(deff === null && i < defs.size){
			if(defs.get(i).declarationName == decl){
				deff = defs.get(i)
			}
			i++
		}
		return deff;
	}
	
	def static Declaration getDeclaration(Definition deff){
//		var i = 0
//		var Declaration decl = null
//		val currentModule = deff.getContainerOfType(typeof(Model))
//		val decls = currentModule.declarations
//		while(decl === null && i < decls.size){
//			if(decls.get(i).name == deff.declarationName){
//				decl = decls.get(i)
//			}
//			i++
//		}
//		return decl;
		deff.declarationName
	}
	
	
	/*
	 * Return the name of the module used in the import
	 */
	def importedModule(Import impt){
		val importedNamespace = impt.importedNamespace
		val splitIndex = impt.importedNamespace.lastIndexOf('.')
		if(splitIndex >= 0){		
			return importedNamespace.substring(0, splitIndex)
		}
		else return null
	}
	
	/*
	 * Return the name of the imported function
	 */
	def importedFunction(Import impt){
		val importedNamespace = impt.importedNamespace
		val splitIndex = impt.importedNamespace.lastIndexOf('.')
		if(splitIndex >= 0){
			return importedNamespace.substring(splitIndex + 1)
		}
		else return null
	}


	/*Start added by Marco Ottina */

	static def dispatch LinkedList<Body> getAllSequentialBodyBlocks(Body rootBody){
		var Body body = rootBody;
		val allBodies = new LinkedList<Body>();
		while(body instanceof SerComp){// all second-to-last steps (whose are atomic or parallel sub-bodies), if any
			allBodies.addFirst(body.right)
			body = body.left
		}
		allBodies.addFirst(body) // the first function's step (atomic or parallel sub-body)
		return allBodies
	}

	static def dispatch LinkedList<Body> getAllSequentialBodyBlocks(Definition defin){
		return getAllSequentialBodyBlocks(defin.body)
	}


	private static def void lewpToArity(ComposedArity ca, LinearExpressionWithParameters lewp, boolean isAdding){
		switch lewp {
			MinusLEWP: lewpToArity(ca,lewp.sub, ! isAdding)
			PlusLEWP : lewpToArity(ca,lewp.sub, isAdding)
			AdditionLEWP: {
				lewpToArity(ca, lewp.left, isAdding);
				lewpToArity(ca, lewp.right, isAdding);
			}
			SubtractionLEWP: {
				lewpToArity(ca, lewp.left, isAdding);
				lewpToArity(ca, lewp.right, ! isAdding); // the negation is applied only to right part
			}
			BracketLEWP: lewpToArity(ca, lewp.sub, isAdding)
			IntLEWP: {
				if(isAdding){
					ca.addScalar(lewp.value.value);
				}else {
					ca.addScalar(-lewp.value.value);
				}
			}
			ParamLEWP:{
				if(isAdding){
					ca.addParameterCoefficient(lewp.value.paramName);
				}else {
					ca.subParameterCoefficient(lewp.value.paramName);
				}
			}
		}
	}
	
	static def ComposedArity linearExpressionParametrizableToArity(LinearExpressionWithParameters lewp){
		val ComposedArity ca = new ComposedArity();
		lewpToArity(ca, lewp, true);
		return ca;
	}
	
	static def dispatch ComposedArity getArity(LinearExpressionWithParameters lewp){
		return linearExpressionParametrizableToArity(lewp)
	}
 
	static def dispatch ComposedArity getArity(ParametricArity pa){
		return linearExpressionParametrizableToArity(pa.arity)
	}
	
	
	static def dispatch ComposedArity getArity(Declaration declaration) {
		val ComposedArity ca = new ComposedArity ();
		ca.scalar = declaration.signature.types.map[ if(it.value == 0)  1 else it.value ].reduce[p1, p2 | p1 + p2]
		if(declaration.signature.params !== null ){
			declaration.signature.params.forEach[ param |
				ca.addParameterCoefficient(param.parName)
			]
		}
		return ca;
	}
//	static def ComposedArity getArityDeclaration(Declaration declaration) {
//		val ComposedArity ca = new ComposedArity ();
//		ca.scalar = declaration.signature.types.map[ if(it.value == 0)  1 else it.value ].reduce[p1, p2 | p1 + p2]
//		if(declaration.signature.params !== null ){
//			declaration.signature.params.forEach[ param |
//				ca.addParameterCoefficient(param.parName)
//			]
//		}
//		return ca;
//	}
	
	static def dispatch ComposedArity getArity(Definition defin){
		return getArity(defin.body)
	}
	
	static def dispatch ComposedArity getArity(FunctionInvocation fun){
		return getArity(fun.funName)
//		return getArityOfFunctionName(fun, fun.funName.name);
	}
	
	
	/*Modified by Marco Ottina */
	static def dispatch ComposedArity getArity(Body body) {
		switch body {
			SerComp : body.left.arity
			ParComp : body.right.arity.sum(body.left.arity)
			BodyInv : body.body.arity
			BodyFun : body.function.arity
			BodyIt  : body.body.arity.addScalar(1)
			BodyFor : body.body.arity.addScalar(1)
			BodyIf  : body.pos.arity.addScalar(1)
			BodyPerm: new ComposedArity(body.permutation.indexes.size)
			BodyInc : new ComposedArity(1)
			BodyDec : new ComposedArity(1)
			BodyNeg : new ComposedArity(1)
			BodyId  : new ComposedArity(1)
			BodyPermIndex: getArity(body.permIndexed.permutationArity).addScalar(1)
			BodyParamId  : getArity(body.paramId.arity)
			default:
				throw new RuntimeException("Body unrecognized to compute arity: " + body)
		}
	}
	
	
	def static ComposedArity getArityOfFunctionName(EObject contextFunctionInvocation, String funcName) {
		val modelContaining = YarelIndex.getModelOfFunction(contextFunctionInvocation, funcName)
		if(modelContaining !== null){
			val Declaration decl = modelContaining.declarations.findFirst[d|d.name.equals(funcName)]
			if(decl!==null){
				return decl.arity
			}
		}
		return null;
	}
	
	/*End added by Marco Ottina */
	
	
//	private static def void getAllAtomicBodiesRecursivePart(LinkedList<Body> list, Body body){
//		if((body instanceof SerComp) || (body instanceof ParComp)){
//			val isSer = (body instanceof SerComp);
//			val left = isSer? ((body as SerComp).left) : ((body as ParComp).left);
//			val right = isSer? ((body as SerComp).right) : ((body as ParComp).right);
//			getAllAtomicBodiesRecursivePart(list, left)
//			getAllAtomicBodiesRecursivePart(list, right)
//		}
//		// TODO else parts
//	}
//	static def dispatch LinkedList<Body> getAllAtomicBodies(Body body){
//		val allBodies = new LinkedList<Body>();
//		getAllAtomicBodiesRecursivePart(allBodies, body);
//		return allBodies;
//	}
//	static def dispatch LinkedList<Body> getAllAtomicBodies(Definition defin){
//		return getAllAtomicBodies(defin.body);
//	}
}