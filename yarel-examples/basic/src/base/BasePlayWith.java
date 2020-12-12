package base;
import yarelcore.*;
import java.util.Arrays;

public class BasePlayWith {
	public static void main(String[] args) throws Exception {
		 RPP gRPP = new base.G();
		 for(int i : gRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
		 RPP fRPP = new base.F();
		 for(int i : fRPP.b(new int[] {5})) {
		 		System.out.println(i);
		 	}
	}
}
