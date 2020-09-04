package yarel_lang_recursion_halve;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_lang_recursion_halvePlayWith {
	public static void main(String[] args) throws Exception {
		 RPP StepRPP = new yarel_lang_recursion_halve.Step();
		 for(int i : StepRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP HalveRPP = new yarel_lang_recursion_halve.Halve();
		 for(int i : HalveRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
	}
}
