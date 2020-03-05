package BoundedMin;
import Yarelcore.*;
import java.util.Arrays;

public class BoundedMinPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP minH12RPP = new BoundedMin.minH12();
		 for(int i : minH12RPP.b(new int[] {1,2,3,4,5})) {
		 		System.out.println(i);
		 	}
		 RPP minH12_originalRPP = new BoundedMin.minH12_original();
		 for(int i : minH12_originalRPP.b(new int[] {1,2,3,4,5,6,5})) {
		 		System.out.println(i);
		 	}
	}
}
