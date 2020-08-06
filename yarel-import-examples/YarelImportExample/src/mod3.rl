import mod1.ambiguous_name
import mod2.ambiguous_name
module mod3{
	dcl f : int
	
	//the function to_import declared in mod1 can be used with her qualified name
	//even though the function is not imported
	def f := mod1.to_import
	
	dcl g : int
	dcl h : int
	
	//the ambiguity of the function ambiguous_name is resolved using the qualified name 
	def g := mod1.ambiguous_name
	def h := mod2.ambiguous_name
}