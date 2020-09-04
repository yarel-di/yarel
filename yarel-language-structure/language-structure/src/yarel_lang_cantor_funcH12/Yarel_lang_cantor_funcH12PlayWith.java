package yarel_lang_cantor_funcH12;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_lang_cantor_funcH12PlayWith {
	public static void main(String[] args) throws Exception {
		 RPP T2RPP = new yarel_lang_cantor_funcH12.T2();
		 for(int i : T2RPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP T2subRPP = new yarel_lang_cantor_funcH12.T2sub();
		 for(int i : T2subRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP T3RPP = new yarel_lang_cantor_funcH12.T3();
		 for(int i : T3RPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP T3subRPP = new yarel_lang_cantor_funcH12.T3sub();
		 for(int i : T3subRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP P3RPP = new yarel_lang_cantor_funcH12.P3();
		 for(int i : P3RPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP P3subRPP = new yarel_lang_cantor_funcH12.P3sub();
		 for(int i : P3subRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP dup_2RPP = new yarel_lang_cantor_funcH12.Dup_2();
		 for(int i : dup_2RPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP H12RPP = new yarel_lang_cantor_funcH12.H12();
		 for(int i : H12RPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP H12_v2RPP = new yarel_lang_cantor_funcH12.H12_v2();
		 for(int i : H12_v2RPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
	}
}
