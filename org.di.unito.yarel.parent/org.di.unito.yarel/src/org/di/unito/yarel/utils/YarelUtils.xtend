package org.di.unito.yarel.utils

import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.Import

/* Added by Matteo Palazzo */
class YarelUtils {
	def declarations(Model module){module.elements.filter(typeof(Declaration))}
	def definitions(Model module){module.elements.filter(typeof(Definition))}

	def importedModule(Import impt){
		val importedNamespace = impt.importedNamespace
		val splitIndex = impt.importedNamespace.lastIndexOf('.')
		if(splitIndex >= 0){		
			return importedNamespace.substring(0, splitIndex)
		}
		else return null
	}
	
	def importedFunction(Import impt){
		val importedNamespace = impt.importedNamespace
		val splitIndex = impt.importedNamespace.lastIndexOf('.')
		if(splitIndex >= 0){
			return importedNamespace.substring(splitIndex + 1)
		}
		else return null
	}
}