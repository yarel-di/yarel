package compound;
import Yarelcore.*;
import java.util.Arrays;

public class compoundPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP incrementRPP = new compound.increment();
		 for(int i : incrementRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP decrementRPP = new compound.decrement();
		 for(int i : decrementRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP seqCompositionRPP = new compound.seqComposition();
		 for(int i : seqCompositionRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP parCompositionRPP = new compound.parComposition();
		 for(int i : parCompositionRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
	}
}
