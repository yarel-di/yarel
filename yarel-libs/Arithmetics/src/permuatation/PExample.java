package permuatation;
import java.math.BigInteger;
import yarelcore.*;	

public class PExample implements RPP {
	public PExample() { }
	
	
	public InvPExample getInverse(){
		return new InvPExample();
	}
	
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
		BigInteger __tmp__ = BigInteger.ZERO;
		__tmp__ = __x__[__startIndex__ + 0]; 
		__x__[__startIndex__ + 0] = __x__[__startIndex__ + 2]; 
		__x__[__startIndex__ + 2] = __tmp__; 
		__tmp__ = __x__[__startIndex__ + 1]; 
		__x__[__startIndex__ + 1] = __x__[__startIndex__ + 3]; 
		__x__[__startIndex__ + 3] = __tmp__; 
	}
	public int getA() { return 4; }
}