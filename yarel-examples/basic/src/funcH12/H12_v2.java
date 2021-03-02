package funcH12;
import yarelcore.*;	

public class H12_v2 implements RPP {
	public H12_v2() { }
	
	
	

	
	public InvH12_v2 getInverse(){
		return new InvH12_v2();
	}
	
	RPP __function__ = new P3sub();
	public int getA() { return __function__.getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.__function__.b(__x__, __startIndex__, __endIndex__);
	}
}