package ArithInt;
import Yarelcore.*;
import java.util.Arrays;

public class ArithIntPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP sumRPP = new ArithInt.sum();
		 for(int i : sumRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
		 RPP subRPP = new ArithInt.sub();
		 for(int i : subRPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
	}
}
