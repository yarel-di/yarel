package yarel_examples_lang_import2;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_examples_lang_import2PlayWith {
	public static void main(String[] args) throws Exception {
		 RPP FRPP = new yarel_examples_lang_import2.F();
		 for(int i : FRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP GRPP = new yarel_examples_lang_import2.G();
		 for(int i : GRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP ToOverrideRPP = new yarel_examples_lang_import2.ToOverride();
		 for(int i : ToOverrideRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP AmbiguousNameRPP = new yarel_examples_lang_import2.AmbiguousName();
		 for(int i : AmbiguousNameRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
	}
}
