package arithNat;
import yarelcore.*;	

public class InvSubN implements RPP {
	public InvSubN() { }
	
	@Override
	public SubN getInverse(){
		return new SubN();
	}
	
	RPP function = new SumN();
	private final int a = function.getA();
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
	 public int getA() { return this.a; }
}