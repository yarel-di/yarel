package multiplication;
import yarelcore.*;	

public class Identity implements RPP {
	public Identity() { }
	
	
	

	
	public InvIdentity getInverse(){
		return new InvIdentity();
	}
	
	private final RPP[] __steps__ = new RPP[]{
		new RPP() { // BodyFunImpl
			RPP __function__ = new Multiplication();
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		},
		
		new RPP() { // BodyInvImpl
			RPP __function__ = new InvMultiplication();
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		}
	};
	public int getA() { return this.__steps__[0].getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
		int __i__;
		__i__ = -1;
		while( ++__i__ < __steps__.length ){
			__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
		}
	}
}