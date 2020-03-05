package Quotient;
import Yarelcore.*;
import java.util.Arrays;

public class QuotientPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP quoStepRPP = new Quotient.quoStep();
		 for(int i : quoStepRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
		 RPP quoRPP = new Quotient.quo();
		 for(int i : quoRPP.b(new int[] {1,2,3,4,5,5})) {
		 		System.out.println(i);
		 	}
	}
}
