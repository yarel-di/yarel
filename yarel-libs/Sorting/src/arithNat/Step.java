package arithNat;
import yarelcore.*;	

public class Step implements RPP {
	public Step() { }
	
	
	

	
	public InvStep getInverse(){
		return new InvStep();
	}
	
	private final RPP[] __steps__ = new RPP[]{ //
		new RPP() { // BodyPermImpl // index: 0
			private final int __a__ = 3;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // ParCompImpl // index: 1
			private RPP __f__ = new RPP(){
				// Iteration start
				RPP __function__ = new RPP() { // BodyIncImpl
					private RPP __f__ = Inc.SINGLETON_Inc;
					private final int __a__ = __f__.getA();
					public void b(int[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return this.__a__; }
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
			};
			public int getA() { return 3; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 1,
					__startIndex__ + (1) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyInvImpl // index: 2
			private final int __a__ = 3;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // BodyPermImpl // index: 3
			private final int __a__ = 3;
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