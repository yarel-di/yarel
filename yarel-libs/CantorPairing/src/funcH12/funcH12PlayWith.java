package funcH12;
import Yarelcore.*;
import java.util.Arrays;

public class funcH12PlayWith {
	public static void main(String[] args) throws Exception {
		 RPP T2RPP = new funcH12.T2();
		 for(int i : T2RPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP T2subRPP = new funcH12.T2sub();
		 for(int i : T2subRPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP T3RPP = new funcH12.T3();
		 for(int i : T3RPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP T3subRPP = new funcH12.T3sub();
		 for(int i : T3subRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP P3RPP = new funcH12.P3();
		 for(int i : P3RPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP P3subRPP = new funcH12.P3sub();
		 for(int i : P3subRPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP dup_2RPP = new funcH12.dup_2();
		 for(int i : dup_2RPP.b(new int[] {1,5})) {
		 		System.out.println(i);
		 	}
		 RPP H12RPP = new funcH12.H12();
		 for(int i : H12RPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
		 RPP H12_v2RPP = new funcH12.H12_v2();
		 for(int i : H12_v2RPP.b(new int[] {1,2,5})) {
		 		System.out.println(i);
		 	}
	}
}
