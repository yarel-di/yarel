import mod1.*
//The import works even though mod1 is in another folder
import inner_mod.*
module mod2{
	dcl f : int
	dcl g : int
	//The function to import declared in mod1 can be called both with
	//her fullied qualified name and without
	def f := to_import
	def g := mod1.to_import
	
	//The funcion to_override declared in mod1 can be overrided 
	dcl to_override : int
	def to_override := neg 
	
	dcl ambiguous_name : int
	def ambiguous_name := neg
	
	dcl h : int
	def h := inner_f
}