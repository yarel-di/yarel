/**
 * Yarel
 * Copyright (C) 2018  Claudio Grandi, Dariush Moshiri, Luca Roversi
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
 
package org.di.unito.yarel.generator

import org.di.unito.yarel.generator.javagen.JavaYarelGenerator
import org.di.unito.yarel.generator.latex.LatexYarelGenerator
import org.di.unito.yarel.generator.sagemath.SageMathYarelGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.ILocationInFileProvider

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class YarelGenerator extends AbstractGenerator {

	@Inject IQualifiedNameProvider qnp //USE THIS IF YOU GO FOR THE SOLUTION No 2:

	val latexGenerator = new LatexYarelGenerator
	val sageMathGenerator = new SageMathYarelGenerator
	val javaGenerator = new JavaYarelGenerator

	/************/
	/* Compiler */
	/************/
    override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
       latexGenerator.doGenerate(resource, fsa, context);
       sageMathGenerator.doGenerate(resource, fsa, context);
       javaGenerator.doGenerate(resource, fsa, context, qnp);
    }
}
