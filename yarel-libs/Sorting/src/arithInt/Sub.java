package arithInt;
import yarelcore.*;	

public class Sub implements RPP {
	public Sub() { }
	
	
	public InvSub getInverse(){
		return new InvSub();
	}
	
	RPP __function__ = new InvSum();
	public int getA() { return __function__.getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.__function__.b(__x__, __startIndex__, __endIndex__);
	}
}