package arithNat;
import yarelcore.*;	

public class SubN implements RPP {
	public SubN() { }
	
	
	

	
	public InvSubN getInverse(){
		return new InvSubN();
	}
	
	RPP __function__ = new InvSumN();
	public int getA() { return __function__.getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.__function__.b(__x__, __startIndex__, __endIndex__);
	}
}