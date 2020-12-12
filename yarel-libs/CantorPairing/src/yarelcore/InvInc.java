package yarelcore;
public class InvInc implements RPP {
	private RPP f = new Dec();
	private final int a = this.f.getA();
	public int[] b(int[] x) {
		return this.f.b(x);
	}
	public int getA() { return this.a; }
}
