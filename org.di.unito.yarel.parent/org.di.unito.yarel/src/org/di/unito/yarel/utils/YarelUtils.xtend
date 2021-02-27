package org.di.unito.yarel.utils

import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.Import
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
import org.di.unito.yarel.yarel.ParComp
import org.di.unito.yarel.yarel.SerComp
import org.di.unito.yarel.yarel.ParametricArity
import org.di.unito.yarel.yarel.ParamArityExprPlus
import org.di.unito.yarel.yarel.ParamArityExprMinus
import org.di.unito.yarel.yarel.BodyPermIndex 
import java.util.LinkedList
import org.di.unito.yarel.yarel.BodyParamId

/* Added by Matteo Palazzo */
class YarelUtils {
	/*
	 * Return all the declarations of a module
	 */
	def declarations(Model module){module.elements.filter(typeof(Declaration))}
	/*
	 * Return all the definitions of a module
	 */
	def definitions(Model module){module.elements.filter(typeof(Definition))}

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
	
	static def int calculateParametricArity(ParametricArity pa){
		if(pa.constantArityVariant !== null){
			return "+".equals(pa.sign)
				? (pa.constantArityVariant as ParamArityExprPlus).constantArity
				: -((pa.constantArityVariant as ParamArityExprMinus).constantArity);
		}
		return ( pa.paramName === null || "".equals(pa.paramName.trim)) ? pa.constantArity : 0;
	}
	
	static def String parametricArityToCompilable(ParametricArity pa){
		if(pa.constantArityVariant !== null){
//			return 
		}
	}
	
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
	
	
	static def dispatch int getArity(Declaration declaration) {
		return declaration.signature.types.map[ if(it.value == 0)  1 else it.value ].reduce[p1, p2 | p1 + p2]
	}
		
	static def dispatch int getArity(Body body) {
		switch body {
			SerComp: body.left.arity
			ParComp: body.right.arity + body.left.arity
			BodyInv : body.body.arity
			BodyFun : body.funName.arity
			BodyIt : 1 + body.body.arity
			BodyFor: 1 + body.body.arity
			BodyIf: 1 + body.pos.arity
			BodyPerm: body.permutation.indexes.size
			BodyPermIndex: 1  + calculateParametricArity(body.permIndexed.permutationArity)
			BodyParamId : calculateParametricArity(body.paramId.arity)
			BodyInc : 1
			BodyDec : 1
			BodyNeg : 1
			BodyId: 1
			default:
				throw new RuntimeException("Body not found " + body)
		}
	}
	
	
	
	private static def void getAllAtomicBodiesRecursivePart(LinkedList<Body> list, Body body){
		if((body instanceof SerComp) || (body instanceof ParComp)){
			val isSer = (body instanceof SerComp);
			val left = isSer? ((body as SerComp).left) : ((body as ParComp).left);
			val right = isSer? ((body as SerComp).right) : ((body as ParComp).right);
			getAllAtomicBodiesRecursivePart(list, left)
			getAllAtomicBodiesRecursivePart(list, right)
		}
		// TODO else parts
	}
	static def dispatch LinkedList<Body> getAllAtomicBodies(Body body){
		val allBodies = new LinkedList<Body>();
		getAllAtomicBodiesRecursivePart(allBodies, body);
		return allBodies;
	}
	static def dispatch LinkedList<Body> getAllAtomicBodies(Definition defin){
		return getAllAtomicBodies(defin.body);
	}
}