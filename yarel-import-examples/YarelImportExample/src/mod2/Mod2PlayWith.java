package mod2;
import yarelcore.*;
import java.util.Arrays;

public class Mod2PlayWith {
	public static void main(String[] args) throws Exception {
		 RPP fRPP = new mod2.F();
		 for(int i : fRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP gRPP = new mod2.G();
		 for(int i : gRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP to_overrideRPP = new mod2.To_override();
		 for(int i : to_overrideRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP ambiguous_nameRPP = new mod2.Ambiguous_name();
		 for(int i : ambiguous_nameRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP hRPP = new mod2.H();
		 for(int i : hRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
	}
}
