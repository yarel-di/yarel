package yarel_example_compound;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_example_compoundPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP IncrementRPP = new yarel_example_compound.Increment();
		 for(int i : IncrementRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP DecrementRPP = new yarel_example_compound.Decrement();
		 for(int i : DecrementRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP SeqCompositionRPP = new yarel_example_compound.SeqComposition();
		 for(int i : SeqCompositionRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP ParCompositionRPP = new yarel_example_compound.ParComposition();
		 for(int i : ParCompositionRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
	}
}
