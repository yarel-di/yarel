package quotient;
import yarelcore.*;
import java.util.Arrays;

public class QuotientPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP quoStepRPP = new quotient.QuoStep();
		 for(int i : quoStepRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
		 RPP quoRPP = new quotient.Quo();
		 for(int i : quoRPP.b(new int[] {1,2,3,4,5,5})) {
		 		System.out.println(i);
		 	}
	}
}
