package funcH12;
import yarelcore.*;	

public class InvP3 implements RPP {
	public InvP3() { }
	
	
	

	
	public P3 getInverse(){
		return new P3();
	}
	
	private final RPP[] __steps__ = new RPP[]{
		new RPP() { // BodyPermImpl
			private final int __a__ = 3;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // ParCompImpl
			private RPP __f__ = new RPP(){
				RPP __function__ = new InvDup_2();
				public int getA() { return __function__.getA(); }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
			public int getA() { return 3; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 0,
					__startIndex__ + (0) + (1)
					);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int __a__ = 3;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // BodyItImpl
			// Iteration start
			RPP __function__ = new RPP() { // SerCompImpl
				private final RPP[] __steps__ = new RPP[]{
					new RPP() { // BodyFunImpl
						RPP __function__ = new arithNat.InvSumN();
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // ParCompImpl
						private RPP __f__ = new RPP(){
							private RPP __f__ = InvDec.SINGLETON_InvDec;
							private final int __a__ = __f__.getA();
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								this.__f__.b(__x__, __startIndex__, __endIndex__);
							}
							public int getA() { return this.__a__; }
						};
						public int getA() { return 2; }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 1,
								__startIndex__ + (1) + (1)
								);
						}
					}
				};
				public int getA() { return this.__steps__[0].getA(); }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
					int __i__;
					__i__ = __steps__.length;
					while( __i__-->0 ){
						__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
					}
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
		
		new RPP() { // BodyPermImpl
			private final int __a__ = 3;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		}
	};
	public int getA() { return this.__steps__[0].getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
		int __i__;
		__i__ = __steps__.length;
		while( __i__-->0 ){
			__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
		}
	}
}