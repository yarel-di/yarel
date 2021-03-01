package funcH12;
import yarelcore.*;	

public class InvH12_v2 implements RPP {
	public InvH12_v2() { }

	
	public H12_v2 getInverse(){
		return new H12_v2();
	}
	
	RPP function = new InvP3sub();
	 public int getA() { return function.getA(); }
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
}