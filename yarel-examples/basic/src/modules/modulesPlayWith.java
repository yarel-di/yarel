package modules;
import Yarelcore.*;
import java.util.Arrays;

public class modulesPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP permutationRPP = new modules.permutation();
		 for(int i : permutationRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
	}
}
