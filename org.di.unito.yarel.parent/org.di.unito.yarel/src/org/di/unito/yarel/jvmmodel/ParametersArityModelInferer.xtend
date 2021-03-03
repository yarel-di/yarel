package org.di.unito.yarel.jvmmodel

import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import javax.inject.Inject
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.di.unito.yarel.utils.ComposedArity
import org.di.unito.yarel.yarel.ParametricArity
import org.eclipse.xtext.common.types.JvmDeclaredType

class ParametersArityModelInferer extends AbstractModelInferrer{
	@Inject extension JvmTypesBuilder
	
	def dispatch void infer(org.di.unito.yarel.yarel.Model model, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		val className = model.eResource.URI.trimFileExtension.lastSegment
//		acceptor.accept(model.toClass(className),[
//			// TODO
//			
//		])

// V1
//		acceptor.accept(model.toClass(className)).
//		initializeLater
////		accept(vmDeclaredType ..
//		 [
//		members += model.toMethod('main',
//		model.newTypeRef(Void::TYPE)) [
//		parameters += model.toParameter
//		("args", model.newTypeRef(typeof(String)).
//		addArrayTypeDimension)
//		static = true
//		// Associate the model with the body of the main method
//		body = model // ERROR: Type mismatch: cannot convert from Model to XExpression
//		]
//		]
	}
}