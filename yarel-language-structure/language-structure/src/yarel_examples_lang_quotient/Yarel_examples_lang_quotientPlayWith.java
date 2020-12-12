package yarel_examples_lang_quotient;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_examples_lang_quotientPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP quoStepRPP = new yarel_examples_lang_quotient.QuoStep();
		 for(int i : quoStepRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
		 RPP quoRPP = new yarel_examples_lang_quotient.Quo();
		 for(int i : quoRPP.b(new int[] {1,2,3,4,5,5})) {
		 		System.out.println(i);
		 	}
	}
}
