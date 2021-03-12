package arithInt;
import yarelcore.*;	

public class InvSub implements RPP {
	public InvSub() { }
	
	
	public Sub getInverse(){
		return new Sub();
	}
	
	RPP __function__ = new Sum();
	public int getA() { return __function__.getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.__function__.b(__x__, __startIndex__, __endIndex__);
	}
}