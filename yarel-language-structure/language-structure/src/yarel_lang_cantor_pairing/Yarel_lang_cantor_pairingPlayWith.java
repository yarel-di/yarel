package yarel_lang_cantor_pairing;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_lang_cantor_pairingPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP cpRPP = new yarel_lang_cantor_pairing.Cp();
		 for(int i : cpRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP cuRPP = new yarel_lang_cantor_pairing.Cu();
		 for(int i : cuRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
	}
}
