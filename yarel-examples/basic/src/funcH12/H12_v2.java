package funcH12;
import yarelcore.*;	

public class H12_v2 implements RPP {
	public H12_v2() { }
	
	

	
	public InvH12_v2 getInverse(){
		return new InvH12_v2();
	}
	
	RPP function = new P3sub();
	public int getA() { return function.getA(); }
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
}