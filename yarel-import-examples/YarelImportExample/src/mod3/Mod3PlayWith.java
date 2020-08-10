package mod3;
import yarelcore.*;
import java.util.Arrays;

public class Mod3PlayWith {
	public static void main(String[] args) throws Exception {
		 RPP fRPP = new mod3.F();
		 for(int i : fRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP gRPP = new mod3.G();
		 for(int i : gRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP hRPP = new mod3.H();
		 for(int i : hRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
	}
}
