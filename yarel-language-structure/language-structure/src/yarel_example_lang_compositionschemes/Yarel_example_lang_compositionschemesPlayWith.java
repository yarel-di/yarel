package yarel_example_lang_compositionschemes;
import yarelcore.*;
import java.util.Arrays;

public class Yarel_example_lang_compositionschemesPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP IncrementRPP = new yarel_example_lang_compositionschemes.Increment();
		 for(int i : IncrementRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP DecrementRPP = new yarel_example_lang_compositionschemes.Decrement();
		 for(int i : DecrementRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP SeqCompositionRPP = new yarel_example_lang_compositionschemes.SeqComposition();
		 for(int i : SeqCompositionRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP ParCompositionRPP = new yarel_example_lang_compositionschemes.ParComposition();
		 for(int i : ParCompositionRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
	}
}
