package yarel_examples_lang_import1;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_examples_lang_import1PlayWith {
	public static void main(String[] args) throws Exception {
		 RPP ToImportRPP = new yarel_examples_lang_import1.ToImport();
		 for(int i : ToImportRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP ToOverrideRPP = new yarel_examples_lang_import1.ToOverride();
		 for(int i : ToOverrideRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP AmbiguousNameRPP = new yarel_examples_lang_import1.AmbiguousName();
		 for(int i : AmbiguousNameRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
	}
}
