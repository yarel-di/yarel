import yarel_examples_lang_import1.*
module yarel_examples_lang_import2 {
	dcl F : int
	dcl G : int
	//The function to import declared in mod1 can be called both with
	//her fully qualified name and without
	def F := ToImport
	def G := yarel_examples_lang_import1.ToImport
	
	//The function to_override declared in mod1 can be overridden
	dcl ToOverride : int
	def ToOverride := neg 
	
	dcl AmbiguousName : int
	def AmbiguousName := neg
} 