package inner_mod;
import yarelcore.*;
import java.util.Arrays;

public class Inner_modPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP inner_fRPP = new inner_mod.Inner_f();
		 for(int i : inner_fRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
	}
}
