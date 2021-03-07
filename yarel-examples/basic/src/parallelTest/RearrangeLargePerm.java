package parallelTest;
import yarelcore.*;	

public class RearrangeLargePerm implements RPP {
	public RearrangeLargePerm() { }
	
	
	

	
	public InvRearrangeLargePerm getInverse(){
		return new InvRearrangeLargePerm();
	}
	
	private final int __a__ = 10;
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		int __tmp__=0;
		__tmp__ = __x__[__startIndex__ + 0]; 
		__x__[__startIndex__ + 0] = __x__[__startIndex__ + 4]; 
		__x__[__startIndex__ + 4] = __x__[__startIndex__ + 9]; 
		__x__[__startIndex__ + 9] = __x__[__startIndex__ + 6]; 
		__x__[__startIndex__ + 6] = __x__[__startIndex__ + 8]; 
		__x__[__startIndex__ + 8] = __x__[__startIndex__ + 7]; 
		__x__[__startIndex__ + 7] = __tmp__; 
		__tmp__ = __x__[__startIndex__ + 2]; 
		__x__[__startIndex__ + 2] = __x__[__startIndex__ + 5]; 
		__x__[__startIndex__ + 5] = __tmp__; 
	}
	public int getA() { return this.__a__; }
}