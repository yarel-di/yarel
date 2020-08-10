package multiplication;
import yarelcore.*;
import java.util.Arrays;

public class MultiplicationPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP permutationRPP = new multiplication.Permutation();
		 for(int i : permutationRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP multiplicationRPP = new multiplication.Multiplication();
		 for(int i : multiplicationRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP identityRPP = new multiplication.Identity();
		 for(int i : identityRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
	}
}
