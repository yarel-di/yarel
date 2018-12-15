package Multiplication;
import Yarelcore.*;
import java.util.Arrays;

public class MultiplicationPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP permutationRPP = new Multiplication.permutation();
		 for(int i : permutationRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP multiplicationRPP = new Multiplication.multiplication();
		 for(int i : multiplicationRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP identityRPP = new Multiplication.identity();
		 for(int i : identityRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
	}
}
