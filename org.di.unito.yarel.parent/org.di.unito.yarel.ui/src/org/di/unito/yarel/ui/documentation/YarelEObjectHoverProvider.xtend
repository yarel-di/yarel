package org.di.unito.yarel.ui.documentation

import java.util.Objects
import java.util.Arrays
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.Diagnostician
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.ParameterLEWP
import org.di.unito.yarel.yarel.FunctionInvocation
import org.di.unito.yarel.yarel.Permutation
import org.di.unito.yarel.yarel.BodyFor
import org.di.unito.yarel.utils.YarelUtils
import org.di.unito.yarel.yarel.BodyIt
import org.di.unito.yarel.yarel.BodyIf
import org.di.unito.yarel.yarel.AtomicParRep
import org.di.unito.yarel.yarel.BodySwap
import org.di.unito.yarel.yarel.BodyParamId
import org.di.unito.yarel.yarel.BodyParamPerm
import org.di.unito.yarel.yarel.LinearExpressionWithParameters
import org.di.unito.yarel.yarel.BodyId
import org.di.unito.yarel.yarel.BodyInc
import org.di.unito.yarel.yarel.BodyDec
import org.di.unito.yarel.yarel.BodyNeg
import org.di.unito.yarel.yarel.SerComp
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import org.di.unito.yarel.yarel.ParComp
import org.di.unito.yarel.yarel.BodyInv
import org.di.unito.yarel.yarel.BodyParamIt
import org.di.unito.yarel.yarel.BodyParamFor
import org.di.unito.yarel.yarel.BodyParamInc
import org.di.unito.yarel.yarel.BodyFun
import org.di.unito.yarel.yarel.BodyParamDec
import org.di.unito.yarel.yarel.BodyParamNeg
import org.di.unito.yarel.yarel.SwapIndexed

class YarelEObjectHoverProvider extends DefaultEObjectHoverProvider implements IEObjectHoverProvider{ 
	
	override getHoverInfoAsHtml(EObject o) {
		switch o {
			BodyId: '''Native operator. Arity = 1<br>Does nothing, just consume the current register.'''
			BodyInc: '''Native operator. Arity = 1<br>Increment the current register by one.'''
			BodyDec: '''Native operator. Arity = 1<br>Decrement the current register by one.'''
			BodyNeg:
				'''
				Native operator. Arity = 1<br>
				Inverts the positivity, or negativity, of the current register.<br>
				A non-native implementation, like SRL ones, could require two registers. A Yarel's implementation:<br>
				<pre><code>
				// < n, a >
				for[inc] //n+a,  a
				;/2 1/   // a ,n+a
				;for[dec]// -n,n+a
				;/2 1/   //n+a, -n
				;for[inc]// a , -n
				;/2 1/   // -n,  a
				</code></pre>
			'''
			Permutation:'''Permutation of a finite set of registers: «o.indexes.size». Indexes are 1-based.'''
			BodyFor:
				'''
				For loop, which repeats its argument (some operations inside a square brackets) an amount of time equal to the absolute value of the last register on which this loop spans.<br>
				If that value is negative, then the inverse of the argument is performed instead.<br>
				Due to linearity constraints, that register's value cannot be modified by this loop's body instructions.<br>
				The arity of this statement is equals to 1 plus its body arity; in this case that sum is:<br>
					«YarelUtils.getArity(o)»
				'''
			BodyIt:
				'''
				Iteration loop, which repeats its argument (some operations inside a square brackets) an amount of time equal to the absolute value of the last register on which this loop spans.<br>
				It differs from the <code>for</code> loop because the argument is not inverted if that value is negative.<br>
				Due to linearity constraints, that register's value cannot be modified by this loop's body instructions.<br>
				The arity of this statement is equals to 1 plus its body arity; in this case that sum is:<br>
					«YarelUtils.getArity(o)»
				'''
			BodyIf:
				'''
				Conditional branching, which performs one out of three different blocks of operations ("sub-bodies") depending on three cases: if the "control value" is either positive, equals to zero or negative.<br>
				Due to linearity constraints, that register's value (the "control value") cannot be modified by the sub-bodies' instructions.<br>
				All of the sub-bodies must have the same arity.<br>
				The arity of this statement is equals to 1 plus one of its sub-body's arity; in this case that sum is:<br>
					«YarelUtils.getArity(o)»
				'''
			BodyInv:
				'''
				Inverts the provided body.
				'''
			BodyParamId:
				'''Does nothing useful, except for spanning over an amount of registers («YarelUtils.getArity(o.arity)» to be precise) and validate the whole sequential block's arity it's in.'''
			BodyParamInc:
				'''Parametric increment. Increments some registers («YarelUtils.getArity(o.arity)» to be precise) by an amount specified on its parameter («YarelUtils.getArity(o.paramsAssign)»).'''
			BodyParamDec:
				'''Parametric decrement. Decrements some registers («YarelUtils.getArity(o.arity)» to be precise) by an amount specified on its parameter («YarelUtils.getArity(o.paramsAssign)»).'''
			BodyParamNeg:
				'''Parametric Negation. Negates the value some registers («YarelUtils.getArity(o.arity)» to be precise), performing the sign inversion by an amount specified on its parameter («YarelUtils.getArity(o.paramsAssign)»).'''
			BodyParamPerm:
				'''
				Applies a permutation, spanning over an amount of registers (specified in curly brackets), plus 1.<br>
				The first register is swapped with the register whose index is stored in the last ones.<br>
				That additional, last register is used in a way similar to "for" and "iteration" loops and conditional branching:<br>
					stores the index previously mentioned and cannot be modified due to linear constraints.<br>
				So, the arity of this statement is equals to 1 plus the provided ones:
					«YarelUtils.getArity(o)»
				'''
			BodyParamIt:
				'''
				Parametric iteration. Iterate the body for an amount of times equal to the absolute value of its parameter.
						The arity is exactly of its body: [«YarelUtils.getArity(o)»].
				'''
			BodyParamFor:
				'''
				Parametric sign-based iteration. Iterate the body for an amount of times equal to the absolute value of its parameter.
				If that amount is negative, then the inverse of the body is performed instead.
				The arity is exactly of its body: [«YarelUtils.getArity(o)»].
				'''
			BodySwap: getHoverInfoAsHtml(o.function)
			SwapIndexed:{
				val swapArity = YarelUtils.getArity(o.arity);
				'''
				Applies a permutation, spanning over an amount of registers (specified in curly brackets), involving at most two indexes.<br>
				Those indexes are specified in curve brackets.<br>
				This is a native implementation and some Yarel's ones may require more additional registers other than the provided ones (whose are: «swapArity.toString»).<br>
				A pure SRL implementation, for instance, requires one more register. The Java compilation does not require additional registers.<br>
				So, We decided to keep the arity exactly equal to the provided one: «swapArity.toString».<br>
				If a SRL-like implementation is required, provide an additional register and compose parametric incements/decrements with parametric permutations.
				'''
			}
			BodyFun: 
				'''
				Invocation of the function «o.function.funName.name» with <strong>declared</strong> arity [«YarelUtils.getArity(o.function.funName)»].
				The optional arities and parameters are "given" with the same order as they are placed during invocation.
				'''
			Declaration:
				'''
				Function declaration:<br>
					name              = «o.name»<br>
					arity             = «YarelUtils.getArity(o).toString()»<br>
				«IF o.invocParamsSignat !== null»	parameters' names= «Arrays.toString(o.invocParamsSignat.invocParam.map[it.parName])»«ELSE»Non parametric«ENDIF»
				'''
			Definition:
				'''
				Function definition:<br>
					Declaration =<br>
						«getDocumentation(o.declarationName)»<br>
					steps amount= «YarelUtils.getAllSequentialBodyBlocks(o.body).size»
				'''
			ParameterLEWP: '''Parameter: «o.paramName»'''
			FunctionInvocation :
				'''
				Invocation of «o.funName.name»<br>
					provided arity    = «YarelUtils.getArity(o.aritiesAssign).toString()»<br>
					«IF o.paramsAssign !== null»parameters given  = «YarelUtils.getArity(o.paramsAssign)»«ELSE»Non parametric«ENDIF»<br>
					Original function declaration:<br>
					«getDocumentation(o.funName)»
				'''
			AtomicParRep:
				'''
				A primitve operation («o.funName») which can be repeated across one or more registers and multiple times, depending on the given parameter.<br>
				The amount of registers affected is specified in curly brackets (and it's equal to «YarelUtils.getArity(o.arity)»).<br>
				The amount of repetitions performed is specified in curve brackets (and it's equal to «YarelUtils.getArity(o.paramsAssign)»).
				'''
			LinearExpressionWithParameters:
				'''Value: «YarelUtils.getArity(o)»'''
			SerComp:
				'''
				A serial block of code. Two subsequent serial blocks are separate by a semicolon.<br>
				Each serial block of code could be defined as a set of sub-blocks that are executed concurrently and indipendently. All parallel sub-blocks must be fully executed before the next serial block can start being executed.
				A function is defined as a finite sequence of steps. A serial block is one of those.<br>
				A serial block cannot be performed before the previous ones are completed.<br>
				A serial block must have the same arity of the other serial blocks or, if all of those blocks have just a Definition as a parent node, the function which is defined:<ul>
				<li>current arity:«YarelUtils.getArity(o)»</li>
				<li>defining function arity: «YarelUtils.getArity(o.getContainerOfType(Definition).declarationName)»</li>
				</ul>
				'''
			ParComp:
				'''
				A parallel block of code.<br>
				Each serial block of code could be defined as a set of sub-blocks (i.e., a parallel block, a.k.a. "sub-block") that are executed concurrently and indipendently. A parallel block is one of those sub-blocks and all sub-blocks needs to be executed before executing the next sequential block.<br>
				A parallel sub-block can (and should) have an arity different to the defining function's arity; the constraint is: the sum of all parallel sub-blocks inside a single serial block must be equal to the defining function's arity.
				'''
			default:
			'''
				No documentation available for object; «Objects.toString(o)»
			'''
		}.toString
	}
	def programHasNoError(EObject o) {
		Diagnostician::INSTANCE.validate(EcoreUtil.getRootContainer(o)).children.empty
	}
}