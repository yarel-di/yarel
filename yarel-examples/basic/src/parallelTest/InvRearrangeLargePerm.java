package parallelTest;
import java.math.BigInteger;
import yarelcore.*;	

public class InvRearrangeLargePerm implements RPP {
	public InvRearrangeLargePerm() { }
	
	
	public RearrangeLargePerm getInverse(){
		return new RearrangeLargePerm();
	}
	
	private final int __a__ = 10;
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
		BigInteger __tmp__ = BigInteger.ZERO;
		__tmp__ = __x__[__startIndex__ + 0]; 
		__x__[__startIndex__ + 0] = __x__[__startIndex__ + 7]; 
		__x__[__startIndex__ + 7] = __x__[__startIndex__ + 8]; 
		__x__[__startIndex__ + 8] = __x__[__startIndex__ + 6]; 
		__x__[__startIndex__ + 6] = __x__[__startIndex__ + 9]; 
		__x__[__startIndex__ + 9] = __x__[__startIndex__ + 4]; 
		__x__[__startIndex__ + 4] = __tmp__; 
		__tmp__ = __x__[__startIndex__ + 2]; 
		__x__[__startIndex__ + 2] = __x__[__startIndex__ + 5]; 
		__x__[__startIndex__ + 5] = __tmp__; 
	}
	public int getA() { return this.__a__; }
}