package ArithNat;
import Yarelcore.*;
import java.util.Arrays;

public class ArithNatPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP sumRPP = new ArithNat.sum();
		 for(int i : sumRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP subRPP = new ArithNat.sub();
		 for(int i : subRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP mulRPP = new ArithNat.mul();
		 for(int i : mulRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP disSelRPP = new ArithNat.disSel();
		 for(int i : disSelRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP disStepRPP = new ArithNat.disStep();
		 for(int i : disStepRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
		 RPP quoRPP = new ArithNat.quo();
		 for(int i : quoRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
	}
}
