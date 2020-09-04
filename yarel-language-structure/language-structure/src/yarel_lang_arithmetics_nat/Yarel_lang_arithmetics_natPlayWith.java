package yarel_lang_arithmetics_nat;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_lang_arithmetics_natPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP sumNRPP = new yarel_lang_arithmetics_nat.SumN();
		 for(int i : sumNRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP subRPP = new yarel_lang_arithmetics_nat.Sub();
		 for(int i : subRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP mulNRPP = new yarel_lang_arithmetics_nat.MulN();
		 for(int i : mulNRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP disSelNRPP = new yarel_lang_arithmetics_nat.DisSelN();
		 for(int i : disSelNRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP disStepNRPP = new yarel_lang_arithmetics_nat.DisStepN();
		 for(int i : disStepNRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
		 RPP quoNRPP = new yarel_lang_arithmetics_nat.QuoN();
		 for(int i : quoNRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
	}
}
