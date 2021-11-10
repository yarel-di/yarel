package multiplication;
import java.math.BigInteger;
import yarelcore.*;	

public class InvPermutation implements RPP {
	public InvPermutation() { }
	
	
	public Permutation getInverse(){
		return new Permutation();
	}
	
	private final int __a__ = 3;
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
		BigInteger __tmp__ = BigInteger.ZERO;
		__tmp__ = __x__[__startIndex__ + 0]; 
		__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
		__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
		__x__[__startIndex__ + 2] = __tmp__; 
	}
	public int getA() { return this.__a__; }
}