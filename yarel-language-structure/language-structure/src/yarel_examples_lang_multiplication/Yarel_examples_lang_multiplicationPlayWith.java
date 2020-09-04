package yarel_examples_lang_multiplication;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_examples_lang_multiplicationPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP permutationRPP = new yarel_examples_lang_multiplication.Permutation();
		 for(int i : permutationRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP multiplicationRPP = new yarel_examples_lang_multiplication.Multiplication();
		 for(int i : multiplicationRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP identityRPP = new yarel_examples_lang_multiplication.Identity();
		 for(int i : identityRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
	}
}
