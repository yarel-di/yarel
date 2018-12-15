package ArithNat;
import Yarelcore.*;
import java.util.Arrays;

public class disStepIteration8div3 {
	public static void main(String[] args) throws Exception {
		 RPP disStep = new ArithNat.disStep();

		 /* Iterates disStep 8 times.
		  * It prints the output of disStep at every iteration.
		  * The starting configuration {8,3,0,0} indicates that
		  * we want to compute the integer part of 8/3.
		  */
		 int[] delta = {8,3,0,0};
		 for(int i = 0; i < 8; i++) {
			 delta = disStep.b(delta);
			 System.out.println(Arrays.toString(delta));			 
		 }
	}
}
