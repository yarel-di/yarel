/*
 * generated by Xtext 2.15.0
 */
package org.di.unito.yarel


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class YarelStandaloneSetup extends YarelStandaloneSetupGenerated {

	def static void doSetup() {
		new YarelStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
