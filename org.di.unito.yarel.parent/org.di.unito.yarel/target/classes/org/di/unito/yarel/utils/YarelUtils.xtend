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
import org.di.unito.yarel.yarel.BodyPermIndex
import java.util.LinkedList

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
			BodyPermIndex: 1 + body.permIndexed.permutationArity
			BodyInc : 1
			BodyDec : 1
			BodyNeg : 1
			BodyId: 1
			default:
				throw new RuntimeException("Body not found " + body)
		}
	}
}