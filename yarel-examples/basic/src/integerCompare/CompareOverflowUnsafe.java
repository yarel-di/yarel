package integerCompare;
import java.math.BigInteger;
import yarelcore.*;	

public class CompareOverflowUnsafe implements RPP {
	public CompareOverflowUnsafe() { }
	
	
	public InvCompareOverflowUnsafe getInverse(){
		return new InvCompareOverflowUnsafe();
	}
	
	RPP __function__ = new SameSignCompare();
	public int getA() { return __function__.getA(); }
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
		this.__function__.b(__x__, __startIndex__, __endIndex__);
	}
}