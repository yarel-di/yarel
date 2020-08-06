package compound;
import yarelcore.*;
import java.util.Arrays;

public class CompoundPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP incrementRPP = new compound.Increment();
		 for(int i : incrementRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP decrementRPP = new compound.Decrement();
		 for(int i : decrementRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP seqCompositionRPP = new compound.SeqComposition();
		 for(int i : seqCompositionRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP parCompositionRPP = new compound.ParComposition();
		 for(int i : parCompositionRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
	}
}
