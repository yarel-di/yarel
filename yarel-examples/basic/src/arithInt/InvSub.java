package arithInt;
import yarelcore.*;	

public class InvSub implements RPP {
	public InvSub() { }

	
	public Sub getInverse(){
		return new Sub();
	}
	
	RPP function = new Sum();
	 public int getA() { return function.getA(); }
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
}