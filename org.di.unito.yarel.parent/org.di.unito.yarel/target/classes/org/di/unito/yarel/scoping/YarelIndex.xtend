package org.di.unito.yarel.scoping

import com.google.inject.Inject
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.YarelPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider

/*Added by Matteo Palazzo */
class YarelIndex {
	@Inject static ResourceDescriptionsProvider rdp
	@Inject static IContainer.Manager cm

	/*
	 * Return all the visible modules from the object o
	 */
	def static getVisibleModules(EObject o){
		val index = rdp.getResourceDescriptions(o.eResource)
 		val rd = index.getResourceDescription(o.eResource.URI)
 		cm.getVisibleContainers(rd, index)
 			.map[
 		  		container | container.getExportedObjectsByType(YarelPackage::eINSTANCE.model)
 		  	]
 			.flatten
 			.map[mod | 
 				var modObj = mod.EObjectOrProxy //the result could be a proxy
 				if(modObj.eIsProxy){
 					modObj = o.eResource.resourceSet.getEObject(mod.EObjectURI, true) //resolve the proxy
 				}
 				modObj as Model
 			]
	}
	
	// moved here by Marco Ottina
	/*
	 * Return all the declarations of a module
	 */
	def static declarations(Model module){module.elements.filter(typeof(Declaration))}

	// moved here by Marco Ottina
	/*
	 * Return all the definitions of a module
	 */
	def static definitions(Model module){module.elements.filter(typeof(Definition))}
	
	
	/*Added by Marco Ottina */
	
	
	def static Model getModelOfFunction(EObject contextFunctionInvocation, String functionName){
		return contextFunctionInvocation.visibleModules.findFirst[
			mod |
				mod.declarations.map[ declInMod|
						declInMod.name
					].contains(functionName)
		]
	}
	
	def static dispatch Model getModelContaining(Declaration decl){
		return getModelOfFunction(decl, decl.name)
	}
	
	def static dispatch Model getModelContaining(Definition deff){
		return getModelOfFunction(deff, deff.declarationName.name)
	}
}