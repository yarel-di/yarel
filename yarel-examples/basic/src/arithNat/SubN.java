package arithNat;
import yarelcore.*;	

public class SubN implements RPP {
	public SubN() { }
	
	

	
	public InvSubN getInverse(){
		return new InvSubN();
	}
	
	RPP function = new InvSumN();
	public int getA() { return function.getA(); }
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
}