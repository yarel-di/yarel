package mod1;
import yarelcore.*;
import java.util.Arrays;

public class Mod1PlayWith {
	public static void main(String[] args) throws Exception {
		 RPP to_importRPP = new mod1.To_import();
		 for(int i : to_importRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP to_overrideRPP = new mod1.To_override();
		 for(int i : to_overrideRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP ambiguous_nameRPP = new mod1.Ambiguous_name();
		 for(int i : ambiguous_nameRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
	}
}
