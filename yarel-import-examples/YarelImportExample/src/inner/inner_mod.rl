//The import works even though mod1 is in another folder
import mod1.*
module inner_mod{
	dcl inner_f : int 
	def inner_f := to_import
}