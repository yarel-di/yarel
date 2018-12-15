package Yarelcore;
public class inv_dec implements RPP {
	private RPP f = new inc();
	private final int a = this.f.getA();;
	public int[] b(int[] x) {
		return this.f.b(x);
	}
	public int getA() { return this.a; }
}
