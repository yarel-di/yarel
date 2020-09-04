package yarel_example_lang_basefunctions;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_example_lang_basefunctionsPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP GRPP = new yarel_example_lang_basefunctions.G();
		 for(int i : GRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP FRPP = new yarel_example_lang_basefunctions.F();
		 for(int i : FRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
	}
}
