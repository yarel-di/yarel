package tests.manual;

public class CP_InvCU {
	public static int triangularNumber(int n) {
		if ((n & 0x1) == 0) { // is even?
			return (n >> 1) * (n + 1);
		} else {
			return ((n + 1) >> 1) * n;
		}
	}

	public static int cp(int x, int y) {
		return triangularNumber(x + y) + x;
	}
}