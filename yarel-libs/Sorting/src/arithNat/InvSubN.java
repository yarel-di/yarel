package arithNat;
import yarelcore.*;	

public class InvSubN implements RPP {
	public InvSubN() { }
	
	

	
	public SubN getInverse(){
		return new SubN();
	}
	
	RPP function = new SumN();
	public int getA() { return function.getA(); }
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
}