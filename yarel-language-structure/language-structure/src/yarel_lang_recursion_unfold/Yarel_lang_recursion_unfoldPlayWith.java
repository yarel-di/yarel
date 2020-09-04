package yarel_lang_recursion_unfold;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_lang_recursion_unfoldPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP pushRPP = new yarel_lang_recursion_unfold.Push();
		 for(int i : pushRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
		 RPP popRPP = new yarel_lang_recursion_unfold.Pop();
		 for(int i : popRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
		 RPP unfoldRPP = new yarel_lang_recursion_unfold.Unfold();
		 for(int i : unfoldRPP.b(new int[] {1,2,3,4,5,6,5})) {
		 		System.out.println(i);
		 	}
	}
}
