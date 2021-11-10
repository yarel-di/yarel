package permutation;
import java.math.BigInteger;
import yarelcore.*;	

public class InvPExample2 implements RPP {
	public InvPExample2() { }
	
	
	public PExample2 getInverse(){
		return new PExample2();
	}
	
	private final int __a__ = 5;
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
		BigInteger __tmp__ = BigInteger.ZERO;
		__tmp__ = __x__[__startIndex__ + 0]; 
		__x__[__startIndex__ + 0] = __x__[__startIndex__ + 2]; 
		__x__[__startIndex__ + 2] = __tmp__; 
		__tmp__ = __x__[__startIndex__ + 1]; 
		__x__[__startIndex__ + 1] = __x__[__startIndex__ + 4]; 
		__x__[__startIndex__ + 4] = __x__[__startIndex__ + 3]; 
		__x__[__startIndex__ + 3] = __tmp__; 
	}
	public int getA() { return this.__a__; }
}