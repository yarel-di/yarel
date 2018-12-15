package SequentialComposition;
import Yarelcore.*;
import java.util.Arrays;

public class SequentialCompositionPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP scExampleRPP = new SequentialComposition.scExample();
		 for(int i : scExampleRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
	}
}
