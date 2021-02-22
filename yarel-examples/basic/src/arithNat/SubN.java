package arithNat;
import yarelcore.*;	

public class SubN implements RPP {
	public SubN() { }
	
	@Override
	public InvSubN getInverse(){
		return new InvSubN();
	}
	
	RPP function = new InvSumN();
	private final int a = function.getA();
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
	 public int getA() { return this.a; }
}