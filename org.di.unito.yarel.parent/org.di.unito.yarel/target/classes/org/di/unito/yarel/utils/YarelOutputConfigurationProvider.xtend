package org.di.unito.yarel.utils

import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.generator.OutputConfiguration

class YarelOutputConfigurationProvider implements IOutputConfigurationProvider {
	
	public static final String OUTPUT_TEST = "output_test"
	
	override getOutputConfigurations() {
		val defaultConf = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
		defaultConf.description = "Generated Java files folder"
		defaultConf.outputDirectory = "./src"
		defaultConf.overrideExistingResources = true
		defaultConf.createOutputDirectory = true
		defaultConf.cleanUpDerivedResources = true
		defaultConf.setDerivedProperty = true
		
		val testConf = new OutputConfiguration(OUTPUT_TEST)
		testConf.description = "Generated test files folder"
		testConf.outputDirectory = "./src-gen-test"
		testConf.overrideExistingResources = true
		testConf.createOutputDirectory = true
		testConf.cleanUpDerivedResources = true
		testConf.setDerivedProperty = true
		
		return newHashSet(defaultConf, testConf)
	}
	
}