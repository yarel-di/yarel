package arithInt;
import yarelcore.*;	

public class Sub implements RPP {
	public Sub() { }

	
	public InvSub getInverse(){
		return new InvSub();
	}
	
	RPP function = new InvSum();
	 public int getA() { return function.getA(); }
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
}