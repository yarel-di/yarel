package CantorPairing;
import Yarelcore.*;
import java.util.Arrays;

public class CantorPairingPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP cpRPP = new CantorPairing.cp();
		 for(int i : cpRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP cuRPP = new CantorPairing.cu();
		 for(int i : cuRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
	}
}
