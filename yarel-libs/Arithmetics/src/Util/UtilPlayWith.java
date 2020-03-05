package Util;
import Yarelcore.*;
import java.util.Arrays;

public class UtilPlayWith {
	public static void main(String[] args) throws Exception {
		 RPP dupRPP = new Util.dup();
		 for(int i : dupRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
	}
}
