package org.di.unito.yarel.scoping

import org.eclipse.emf.ecore.EObject
import com.google.inject.Inject
import org.eclipse.xtext.mwe.ResourceDescriptionsProvider
import org.eclipse.xtext.resource.IContainer
import org.di.unito.yarel.yarel.YarelPackage
import org.di.unito.yarel.yarel.Model
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.naming.IQualifiedNameProvider

/*Added by Matteo Palazzo */
class YarelIndex {
	@Inject org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider rdp
	@Inject IContainer$Manager cm
	
	def getVisibleModules(EObject o){
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
}