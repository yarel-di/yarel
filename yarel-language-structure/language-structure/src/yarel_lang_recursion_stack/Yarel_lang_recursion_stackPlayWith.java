package yarel_lang_recursion_stack;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_lang_recursion_stackPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP PushRPP = new yarel_lang_recursion_stack.Push();
		 for(int i : PushRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
		 RPP PopRPP = new yarel_lang_recursion_stack.Pop();
		 for(int i : PopRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
	}
}
