package bitStack;
import yarelcore.*;	

public class InvBitpop implements RPP {
	public InvBitpop() { }
	
	
	

	
	public Bitpop getInverse(){
		return new Bitpop();
	}
	
	RPP __function__ = new Bitpush();
	public int getA() { return __function__.getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.__function__.b(__x__, __startIndex__, __endIndex__);
	}
}