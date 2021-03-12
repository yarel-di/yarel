package arithNat;
import yarelcore.*;	

public class Halve implements RPP {
	public Halve() { }
	
	
	

	
	public InvHalve getInverse(){
		return new InvHalve();
	}
	
	private final RPP[] __steps__ = new RPP[]{ //
		new RPP() { // BodyPermImpl // index: 0
			private final int __a__ = 4;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // BodyItImpl // index: 1
			// Iteration start
			RPP __function__ = new RPP() { // BodyFunImpl
				RPP __function__ = new Step();
				public int getA() { return __function__.getA(); }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
			public int getA() { return __function__.getA()+1; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __endIndexBody__ = (__startIndex__ + this.getA()) - 1;
				int __iterationsLeft__ = Math.abs(__x__[__endIndexBody__]);
				while(__iterationsLeft__-->0){
					__function__.b(__x__, __startIndex__, __endIndexBody__);
				}
			}
			// Iteration stop
		},
		
		new RPP() { // BodyInvImpl // index: 2
			private final int __a__ = 4;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __tmp__; 
			}
			public int getA() { return this.__a__; }
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