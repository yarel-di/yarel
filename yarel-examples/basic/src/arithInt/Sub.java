package arithInt;
import yarelcore.*;	

public class Sub implements RPP {
	public Sub() { }
	
	public InvSub getInverse(){
		return new InvSub();
	}
	
	RPP function = new InvSum();
	private final int a = function.getA();
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
	 public int getA() { return this.a; }
}