package org.di.unito.yarel.jvmmodel

import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import javax.inject.Inject
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.di.unito.yarel.utils.ComposedArity
import org.di.unito.yarel.yarel.ParametricArity

class ParametersArityModelInferer extends AbstractModelInferrer{
	@Inject extension JvmTypesBuilder
	
	def dispatch void infer(ParametricArity model, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		val className = model.eResource.URI.trimFileExtension.lastSegment
//		acceptor.accept(model.toClass(className),[
//			// TODO
//			
//		])
	}
}