package funcH12;
import yarelcore.*;	

public class T2sub implements RPP {
	public T2sub() { }
	
	
	

	
	public InvT2sub getInverse(){
		return new InvT2sub();
	}
	
	private final RPP[] __steps__ = new RPP[]{ //
		new RPP() { // ParCompImpl // index: 0
			private RPP __f__ = new RPP(){
				private RPP __f__ = Inc.SINGLETON_Inc;
				private final int __a__ = __f__.getA();
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__, __startIndex__, __endIndex__);
				}
				public int getA() { return this.__a__; }
			};
			public int getA() { return 2; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 0,
					__startIndex__ + (0) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 1
			private final int __a__ = 2;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // BodyFunImpl // index: 2
			RPP __function__ = new arithNat.SubN();
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 3
			private final int __a__ = 2;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
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