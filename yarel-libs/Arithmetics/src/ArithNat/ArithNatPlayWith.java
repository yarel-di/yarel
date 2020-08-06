package arithNat;
import yarelcore.*;
import java.util.Arrays;

public class ArithNatPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP sumNRPP = new arithNat.SumN();
		 for(int i : sumNRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP subNRPP = new arithNat.SubN();
		 for(int i : subNRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP mulNRPP = new arithNat.MulN();
		 for(int i : mulNRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP disSelNRPP = new arithNat.DisSelN();
		 for(int i : disSelNRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP disStepNRPP = new arithNat.DisStepN();
		 for(int i : disStepNRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
		 RPP quoNRPP = new arithNat.QuoN();
		 for(int i : quoNRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
	}
}
