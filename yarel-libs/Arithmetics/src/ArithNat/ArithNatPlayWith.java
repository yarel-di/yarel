package ArithNat;
import Yarelcore.*;
import java.util.Arrays;

public class ArithNatPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP sumNRPP = new ArithNat.sumN();
		 for(int i : sumNRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP subNRPP = new ArithNat.subN();
		 for(int i : subNRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP mulNRPP = new ArithNat.mulN();
		 for(int i : mulNRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP disSelNRPP = new ArithNat.disSelN();
		 for(int i : disSelNRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP disStepNRPP = new ArithNat.disStepN();
		 for(int i : disStepNRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
		 RPP quoNRPP = new ArithNat.quoN();
		 for(int i : quoNRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
	}
}
