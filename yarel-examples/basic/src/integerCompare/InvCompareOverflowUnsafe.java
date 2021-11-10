package integerCompare;
import java.math.BigInteger;
import yarelcore.*;	

public class InvCompareOverflowUnsafe implements RPP {
	public InvCompareOverflowUnsafe() { }
	
	
	public CompareOverflowUnsafe getInverse(){
		return new CompareOverflowUnsafe();
	}
	
	RPP __function__ = new InvSameSignCompare();
	public int getA() { return __function__.getA(); }
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
		this.__function__.b(__x__, __startIndex__, __endIndex__);
	}
}