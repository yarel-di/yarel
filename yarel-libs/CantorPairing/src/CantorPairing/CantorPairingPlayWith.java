package cantorPairing;
import yarelcore.*;
import java.util.Arrays;

public class CantorPairingPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP cpRPP = new cantorPairing.Cp();
		 for(int i : cpRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP cuRPP = new cantorPairing.Cu();
		 for(int i : cuRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
	}
}
