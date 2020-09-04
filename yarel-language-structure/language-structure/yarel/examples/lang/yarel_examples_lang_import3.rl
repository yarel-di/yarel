import yarel_examples_lang_import1.AmbiguousName
import yarel_examples_lang_import2.AmbiguousName
module yarel_examples_lang_import3 {
	dcl F : int
	
	//the function to_import declared in mod1 can be used with her qualified name
	//even though the function is not imported
	def F := yarel_examples_lang_import1.ToImport
	
	dcl G : int
	dcl H : int
	
	//the ambiguity of the function ambiguous_name is resolved using the qualified name 
	def G := yarel_examples_lang_import1.AmbiguousName
	def H := yarel_examples_lang_import2.AmbiguousName
}