package arithNat;
import yarelcore.*;	

public class InvSubN implements RPP {
	public InvSubN() { }
	
	
	

	
	public SubN getInverse(){
		return new SubN();
	}
	
	RPP __function__ = new SumN();
	public int getA() { return __function__.getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.__function__.b(__x__, __startIndex__, __endIndex__);
	}
}