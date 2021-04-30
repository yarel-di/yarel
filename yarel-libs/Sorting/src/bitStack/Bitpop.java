package bitStack;
import yarelcore.*;	

public class Bitpop implements RPP {
	public Bitpop() { }
	
	
	

	
	public InvBitpop getInverse(){
		return new InvBitpop();
	}
	
	RPP __function__ = new InvBitpush();
	public int getA() { return __function__.getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.__function__.b(__x__, __startIndex__, __endIndex__);
	}
}