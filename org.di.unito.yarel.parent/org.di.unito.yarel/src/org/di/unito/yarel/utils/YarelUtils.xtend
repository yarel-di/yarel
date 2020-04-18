package org.di.unito.yarel.utils

import org.di.unito.yarel.yarel.Model
import org.di.unito.yarel.yarel.Declaration
import org.di.unito.yarel.yarel.Definition
import org.di.unito.yarel.yarel.Import

class YarelUtils {
	def declarations(Model module){module.elements.filter(typeof(Declaration))}
	def definitions(Model module){module.elements.filter(typeof(Definition))}
	def imports(Model module){module.elements.filter(typeof(Import))}
}