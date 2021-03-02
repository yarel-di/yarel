package permuatation;
import yarelcore.*;	

public class InvPExample implements RPP {
	public InvPExample() { }
	
	
	

	
	public PExample getInverse(){
		return new PExample();
	}
	
	private final int __a__ = 4;
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		int __tmp__=0;
		__tmp__ = __x__[__startIndex__ + 0]; 
		__x__[__startIndex__ + 0] = __x__[__startIndex__ + 2]; 
		__x__[__startIndex__ + 2] = __tmp__; 
		__tmp__ = __x__[__startIndex__ + 1]; 
		__x__[__startIndex__ + 1] = __x__[__startIndex__ + 3]; 
		__x__[__startIndex__ + 3] = __tmp__; 
	}
	public int getA() { return this.__a__; }
}