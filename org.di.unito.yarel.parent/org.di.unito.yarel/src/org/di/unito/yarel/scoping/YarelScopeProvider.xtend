/*
 * generated by Xtext 2.15.0
 */
package org.di.unito.yarel.scoping

import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.YarelPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.Scopes

import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.di.unito.yarel.scoping.YarelIndex.*

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
 
/* Added by Matteo Palazzo */
class YarelScopeProvider extends AbstractYarelScopeProvider {
	
	/*
	 * Define the scope of the Definition.
	 * In this way the user can define only the function that are declared in the same module
	 * where the definition is made
	 */
	override getScope(EObject context, EReference reference){	
		if(reference == YarelPackage::eINSTANCE.definition_DeclarationName){
			if(context instanceof Definition){
				val dclFuns = context.getContainerOfType(typeof(Model)).declarations
				return Scopes::scopeFor(dclFuns)
			}
		}
		return super.getScope(context, reference)
	}
}
