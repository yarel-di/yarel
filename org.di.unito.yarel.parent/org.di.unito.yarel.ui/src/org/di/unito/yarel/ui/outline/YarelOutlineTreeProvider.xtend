/*
 * generated by Xtext 2.15.0
 */
package org.di.unito.yarel.ui.outline

import org.di.unito.yarel.utils.YarelUtils
import org.di.unito.yarel.yarel.AritiesAssignment
import org.di.unito.yarel.yarel.AritySignature
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
import org.di.unito.yarel.yarel.Element
import org.di.unito.yarel.yarel.Import
import org.di.unito.yarel.yarel.InvocationParametersSignature
import org.di.unito.yarel.yarel.LinearExpressionWithParameters
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.ParComp
import org.di.unito.yarel.yarel.ParametersAssignment
import org.di.unito.yarel.yarel.ParametricArity
import org.di.unito.yarel.yarel.SerComp
import org.di.unito.yarel.yarel.Type
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.di.unito.yarel.yarel.Digit
import org.di.unito.yarel.yarel.Permutation

//import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode

/**
 * Customization of the default outline structure.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
class YarelOutlineTreeProvider extends DefaultOutlineTreeProvider {
	override _isLeaf(EObject o ) {
		switch o {
			Body : 
				switch o {
					BodyId: false
					BodyInc: false
					BodyDec: false
					BodyNeg: false
					BodySwap: false
					BodyPerm: false
					BodyParamPerm: false
					BodyParamId: false
					BodyParamInc: false
					BodyParamDec: false
					BodyParamNeg: false
					/*
					BodyId: true
					BodyInc: true
					BodyDec: true
					BodyNeg: true
					BodySwap: true
					BodyPerm: true
					BodyParamPerm: true
					BodyParamId: true
					BodyParamInc: true
					BodyParamDec: true
					BodyParamNeg: true
					*/
					BodyInv: false
					BodyIf: false
					BodyFor: false
					BodyIt: false
					BodyFun: false
					ParComp: false
					SerComp:false
					default: false
				}
			Digit:true
			Type: true
			Model: false
			Declaration:false
			Definition:false
			Element: false
			Import: false
			Permutation: false
			AritySignature: true
			ParametricArity: true
			AritiesAssignment:true
			ParametersAssignment: true
			InvocationParametersSignature: true
			LinearExpressionWithParameters: true
			default: false
		}
	}
	
//	def void _createChildren(DocumentRootNode outlineNode, Model model) {
//		model.elements.forEach[ entity |
//			createNode(outlineNode, entity);
//		]
//	}

	def dispatch void createNode(IOutlineNode superNode, Declaration decl){
		val thisNode = super.createEObjectNode(superNode, decl)
		super.createEObjectNode(thisNode, decl.aritySignature)
		if(decl.invocParamsSignat !== null){
			super.createEObjectNode(thisNode, decl.invocParamsSignat)
		}
	}
	
	def dispatch void createNode(IOutlineNode superNode, AritySignature arSign){
		val thisNode = super.createEObjectNode(superNode, arSign)
		if(arSign.types !== null){
			arSign.types .forEach[t| super.createEObjectNode(thisNode, t)]
		}
		if(arSign.parametricArities !== null){
			arSign.parametricArities .forEach[t| super.createEObjectNode(thisNode, t)]
		}
	}

	def dispatch void createNode(IOutlineNode superNode, Definition deff){
		val thisNode = super.createEObjectNode(superNode, deff)
		val serialSteps = YarelUtils.getAllSequentialBodyBlocks(deff)
		serialSteps.forEach[ serialBody|
			val serialNode =  super.createEObjectNode(thisNode, serialBody)
			val parallelSteps = YarelUtils.getAllParallelBodyBlocks(serialBody)
			parallelSteps.forEach[ parallelBlock|
				super.createNode(serialNode, parallelBlock)
			]
		]
//		createNodeOfPotentiallySequentialBody(thisNode, deff.body)
	}
	
	protected def void createNodeOfPotentiallySequentialBody(IOutlineNode thisNode, Body b){
		val serialSteps = YarelUtils.getAllSequentialBodyBlocks(b)
		serialSteps.forEach[ serialBody|
			val serialNode =  super.createEObjectNode(thisNode, serialBody)
			val parallelSteps = YarelUtils.getAllParallelBodyBlocks(serialBody)
			parallelSteps.forEach[ parallelBlock|
				//super.
				createNode(serialNode, parallelBlock)
			]
		]
	}
	
	def dispatch void createNode(IOutlineNode superNode, Body b){
		val thisNode = super.createEObjectNode(superNode, b)
		switch b {
			BodyFor: createNodeOfPotentiallySequentialBody(thisNode, b.body)
			BodyIt:  createNodeOfPotentiallySequentialBody(thisNode, b.body)
			BodyInv: createNodeOfPotentiallySequentialBody(thisNode, b.body)
			BodyIf:{
				createNodeOfPotentiallySequentialBody(thisNode, b.pos)
				createNodeOfPotentiallySequentialBody(thisNode, b.zero)
				createNodeOfPotentiallySequentialBody(thisNode, b.neg)
			}
			BodyFun: createNode(thisNode, b.function.funName)
			SerComp: createNodeOfPotentiallySequentialBody(thisNode, b)
			ParComp:{
				val parallelSteps = YarelUtils.getAllParallelBodyBlocks(b)
				parallelSteps.forEach[ parallelBlock|
//					super.
					createNode(thisNode, parallelBlock)
				]
			}
			default: {
//				super.createNode(superNode,b)
			}
		}
	}
	

}
