package yarel_lang_recursion_sp2;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_lang_recursion_sp2PlayWith {
	public static void main(String[] args) throws Exception {
		 RPP sp2RPP = new yarel_lang_recursion_sp2.Sp2();
		 for(int i : sp2RPP.b(new int[] {1,2,3,4,5,5})) {
		 		System.out.println(i);
		 	}
	}
}
