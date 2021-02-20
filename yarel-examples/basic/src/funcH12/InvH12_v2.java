package funcH12;
import yarelcore.*;	

public class InvH12_v2 implements RPP {
	public InvH12_v2() { }
	
	public H12_v2 getInverse(){
		return new H12_v2();
	}
	
	RPP function = new InvP3sub();
	private final int a = function.getA();
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
	 public int getA() { return this.a; }
}