package Yarelcore;
public class inv_inc implements RPP {
	private RPP f = new dec();
	private final int a = this.f.getA();
	public int[] b(int[] x) {
		return this.f.b(x);
	}
	public int getA() { return this.a; }
}
