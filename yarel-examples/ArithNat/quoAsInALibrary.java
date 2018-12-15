package ArithNat;
import Yarelcore.*;
import java.util.Arrays;

public class quoAsInALibrary {
	public static void main(String[] args) throws Exception {
		 RPP quo = new ArithNat.quo();

		 /* Given a pair x and y calls ArithNat.quo()
		  * to compute the quotient of x/y. 
		  */
		 for(int x = 0; x < 8; x++)
			 for(int y = 1; y < 8; y++) {
			    int[] delta = quo.b(new int[] {x, y, 0, 0, 0});
			    System.out.println(x+"/"+y+"="+delta[2]);
			 }
	}
}
