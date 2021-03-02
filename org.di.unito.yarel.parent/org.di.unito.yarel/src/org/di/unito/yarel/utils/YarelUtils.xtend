package org.di.unito.yarel.utils

import java.util.LinkedList
import org.di.unito.yarel.scoping.YarelIndex
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
import org.di.unito.yarel.yarel.BodyParamPerm
import org.di.unito.yarel.yarel.BodyPerm
import org.di.unito.yarel.yarel.BodySwap
import org.di.unito.yarel.yarel.BracketLEWP
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.FunctionInvocation
import org.di.unito.yarel.yarel.Import
import org.di.unito.yarel.yarel.IntLEWP
import org.di.unito.yarel.yarel.LinearExpressionWithParameters
import org.di.unito.yarel.yarel.MinusLEWP
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.ParComp
import org.di.unito.yarel.yarel.ParamLEWP
import org.di.unito.yarel.yarel.ParametricArity
import org.di.unito.yarel.yarel.PlusLEWP
import org.di.unito.yarel.yarel.SerComp
import org.di.unito.yarel.yarel.SubtractionLEWP
import org.eclipse.emf.ecore.EObject

import static extension org.di.unito.yarel.scoping.YarelIndex.*
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import org.di.unito.yarel.yarel.AritiesAssignment
import org.di.unito.yarel.yarel.BodyParamId
import org.di.unito.yarel.yarel.BodyParamInc
import org.di.unito.yarel.yarel.BodyParamNeg
import org.di.unito.yarel.yarel.BodyParamDec

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

	static def dispatch boolean hasSomeParameters(FunctionInvocation fun){
		return (fun.aritiesAssign !== null && fun.aritiesAssign.arities.size > 0)
			|| (fun.paramsAssign !== null && fun.paramsAssign.parameters.size > 0);
	}

	static def dispatch boolean hasSomeParameters(Declaration decl){
		return ( decl.aritySignature !== null && decl.aritySignature.parametricArities.size > 0)
			|| (decl.invocParamsSignat !== null && decl.invocParamsSignat.invocParam.size > 0);
	}

	/* start ARITY COMPUTATION BLOCK */


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
		if(lewp === null) return null;
		val ComposedArity ca = new ComposedArity(0);
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
		ca.scalar = declaration.aritySignature.types.map[ if(it.value == 0)  1 else it.value ].reduce[p1, p2 | p1 + p2]
		if(declaration.aritySignature.parametricArities !== null ){
			declaration.aritySignature.parametricArities .forEach[ param |
				ca.addParameterCoefficient(param.parName)
			]
		}
		return ca;
	}
	
	static def dispatch ComposedArity getArity(Definition defin){
		return getArity(defin.body)
	}
	
	static def dispatch ComposedArity getArity(FunctionInvocation fun){
		return getArity(fun.funName)
//		return getArityOfFunctionName(fun, fun.funName.name);
	}
	
	static def dispatch ComposedArity getArity(AritiesAssignment aa){
		return aa.arities.map[ar| getArity(ar)].reduce[p1, p2| p1.sum(p2)]
	}
	
	
	
	/*Modified by Marco Ottina */
	static def dispatch ComposedArity getArity(Body body) {
		switch body {
			BodyId       : new ComposedArity(1)
			BodyInc      : new ComposedArity(1)
			BodyDec      : new ComposedArity(1)
			BodyNeg      : new ComposedArity(1)
			BodyPerm     : new ComposedArity(body.permutation.indexes.size)
			SerComp      : getArity(body.left)
			ParComp      : getArity(body.right).sum(getArity(body.left))
			BodyInv      : getArity(body.body)
			BodyIt       : getArity(body.body).addScalar(1)
			BodyFor      : getArity(body.body).addScalar(1)
			BodyIf       : getArity(body.pos).addScalar(1)
			BodyFun      : getArity(body.function)
			BodySwap     : getArity(body.function.arity).addScalar(1)
			BodyParamPerm: getArity(body.arity).addScalar(1)
			BodyParamId  : getArity(body.arity)
			BodyParamInc : getArity(body.arity)
			BodyParamDec : getArity(body.arity)
			BodyParamNeg : getArity(body.arity)
//			AtomicParametricArity: getArity(body.arity)
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
	
	/* end ARITY COMPUTATION BLOCK */
	
/*End added by Marco Ottina */
}