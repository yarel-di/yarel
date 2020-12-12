package yarel_lang_arithmetics_int;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_lang_arithmetics_intPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP dupRPP = new yarel_lang_arithmetics_int.Dup();
		 for(int i : dupRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP sumRPP = new yarel_lang_arithmetics_int.Sum();
		 for(int i : sumRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
		 RPP subRPP = new yarel_lang_arithmetics_int.Sub();
		 for(int i : subRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
	}
}
