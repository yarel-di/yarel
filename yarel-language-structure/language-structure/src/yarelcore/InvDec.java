package yarelcore;
public class InvDec implements RPP {
	private RPP f = new Inc();
	private final int a = this.f.getA();;
	public int[] b(int[] x) {
		return this.f.b(x);
	}
	public int getA() { return this.a; }
}
