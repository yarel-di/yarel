package tests.manual;

public class TestCantorPairingManual {

	public static int cp(int x, int y) {
//		return // x+ (
//		((x * (x + 1)) >> 1) //
//				+ ((y * (y + 1)) >> 1) //
////				+x*y );
//				+ y * (x + 1);
		int t = x + y;
		return x + ((t * (t + 1)) >> 1);
	}

	public static void main(String[] args) {

	}

}
