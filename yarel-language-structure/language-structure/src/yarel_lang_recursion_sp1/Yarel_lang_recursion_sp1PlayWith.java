package yarel_lang_recursion_sp1;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_lang_recursion_sp1PlayWith {
	public static void main(String[] args) throws Exception {
		 RPP sp1RPP = new yarel_lang_recursion_sp1.Sp1();
		 for(int i : sp1RPP.b(new int[] {1,2,3,4,5,5})) {
		 		System.out.println(i);
		 	}
	}
}
