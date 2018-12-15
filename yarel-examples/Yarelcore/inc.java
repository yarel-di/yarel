package Yarelcore;
public class inc implements RPP {
	private final int a = 1;
	public int[] b(int[] x) {
		int[] r = new int[this.a];
		r[0] = x[0] + 1;
		return r;
	}
	public int getA() { return this.a; }
}
