package yarelcore;
public class Inc implements RPP {
	private final int a = 1;
	public int[] b(int[] x) {
		x[0] = x[0] + 1;
		return x;
	}
	public int getA() { return this.a; }
}
