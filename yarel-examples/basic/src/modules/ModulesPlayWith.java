package modules;
import yarelcore.*;
import java.util.Arrays;

public class ModulesPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP gRPP = new modules.G();
		 for(int i : gRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP permutationRPP = new modules.Permutation();
		 for(int i : permutationRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
	}
}
