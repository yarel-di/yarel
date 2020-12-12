package permuatation;
import yarelcore.*;
import java.util.Arrays;

public class PermuatationPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP pExampleRPP = new permuatation.PExample();
		 for(int i : pExampleRPP.b(new int[] {1,2,3,5})) {
		 		System.out.println(i);
		 	}
	}
}
