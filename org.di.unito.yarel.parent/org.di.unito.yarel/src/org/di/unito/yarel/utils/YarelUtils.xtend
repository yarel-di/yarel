package org.di.unito.yarel.utils

import java.util.LinkedList
import org.di.unito.yarel.scoping.YarelIndex
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
import org.di.unito.yarel.yarel.FunctionInvocation
import org.di.unito.yarel.yarel.Import
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.ParComp
import org.di.unito.yarel.yarel.SerComp
import org.di.unito.yarel.yarel.Type
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject

import static extension org.di.unito.yarel.scoping.YarelIndex.*
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

/* Added by Matteo Palazzo */
class YarelUtils {
	
	def static Definition getDefinition(Declaration decl){
		val currentModule = decl.getContainerOfType(typeof(Model))
		val declName = decl.name
		return currentModule.definitions.findFirst[it.declarationName.name == declName]
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



/*Start added/modified by Marco Ottina */

	def static int getFixedRegistersRequired(EList<Type> registersAllocations){
		return registersAllocations.empty ? 0 :
			registersAllocations.map[ if(it.value == 0)  1 else it.value ].reduce[p1, p2 | p1 + p2]
	}

	static def dispatch LinkedList<Body> getAllSequentialBodyBlocks(Body rootBody){
		var Body body = rootBody;
		val allBodies = new LinkedList<Body>();
		while(body instanceof SerComp){// all second-to-last steps (whose are atomic or parallel sub-bodies), if any
			allBodies.addFirst(body.right)
			body = body.left
		}
		if(body !== null) allBodies.addFirst(body) // the first function's step (atomic or parallel sub-body)
		return allBodies
	}

	static def dispatch LinkedList<Body> getAllSequentialBodyBlocks(Definition defin){
		return getAllSequentialBodyBlocks(defin.body)
	}

	static def LinkedList<Body> getAllParallelBodyBlocks(Body rootBody){
		var Body body = rootBody;
		val allBodies = new LinkedList<Body>();
		while(body instanceof ParComp){// all second-to-last steps (whose are atomic or parallel sub-bodies), if any
			allBodies.addFirst(body.right)
			body = body.left
		}
		if(body !== null) allBodies.addFirst(body) // the first function's step (atomic or parallel sub-body)
		return allBodies
	}

	static def LinkedList<Body> getAllParallelBodyBlocks(SerComp rootBody){
		return getAllParallelBodyBlocks(rootBody.right)
	}
	
	static def dispatch int getArity(Declaration declaration) {
		return getFixedRegistersRequired(declaration.types);
	}
	
	static def dispatch int getArity(Definition defin){
		return getArity(defin.body);
	}
	
	static def dispatch int getArity(FunctionInvocation fun){
		return getArity(fun.funName);
	}
	
	/*Modified by Marco Ottina */
	static def dispatch int getArity(Body body) {
		switch body {
			BodyId       : 1
			BodyInc      : 1
			BodyDec      : 1
			BodyNeg      : 1
			BodyPerm     : body.permutation.indexes.size
			SerComp      : getArity(body.right) // left
			ParComp      : getArity(body.right) + getArity(body.left)
			BodyInv      : getArity(body.body)
			BodyIt       : getArity(body.body) + 1
			BodyFor      : getArity(body.body) + 1
			BodyIf       : getArity(body.pos) + 1
			BodyFun      : getArity(body.function)
			default:
				throw new RuntimeException("Body unrecognized to compute arity: " + body)
		}
	}
	
	
	def static int getArityOfFunctionName(EObject contextFunctionInvocation, String funcName) {
		val modelContaining = YarelIndex.getModelOfFunction(contextFunctionInvocation, funcName)
		if(modelContaining !== null){
			val Declaration decl = modelContaining.declarations.findFirst[d|d.name.equals(funcName)]
			if(decl!==null){
				return decl.arity
			}
		}
		return 0;
	}
	
	/* end ARITY COMPUTATION BLOCK */
	
/*End added by Marco Ottina */
}