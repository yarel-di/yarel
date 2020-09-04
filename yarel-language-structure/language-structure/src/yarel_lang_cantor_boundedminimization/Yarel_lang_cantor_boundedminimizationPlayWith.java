package yarel_lang_cantor_boundedminimization;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_lang_cantor_boundedminimizationPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP minH12RPP = new yarel_lang_cantor_boundedminimization.MinH12();
		 for(int i : minH12RPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
		 RPP minH12_originalRPP = new yarel_lang_cantor_boundedminimization.MinH12_original();
		 for(int i : minH12_originalRPP.b(new int[] {1,2,3,4,5,6,5})) {
		 		System.out.println(i);
		 	}
	}
}
