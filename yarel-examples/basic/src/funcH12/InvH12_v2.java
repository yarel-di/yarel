package funcH12;
import yarelcore.*;	

public class InvH12_v2 implements RPP {
	public InvH12_v2() { }
	
	
	

	
	public H12_v2 getInverse(){
		return new H12_v2();
	}
	
	RPP __function__ = new InvP3sub();
	public int getA() { return __function__.getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.__function__.b(__x__, __startIndex__, __endIndex__);
	}
}