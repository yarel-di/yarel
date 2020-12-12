package yarelcore;
public class InvNeg implements RPP {
	private RPP f = new Neg();
	private final int a = this.f.getA();;
	public int[] b(int[] x) {
		return this.f.b(x);
	}
	public int getA() { return this.a; }
}
