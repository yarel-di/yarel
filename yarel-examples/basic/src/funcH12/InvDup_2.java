package funcH12;
import yarelcore.*;	

public class InvDup_2 implements RPP {
	public InvDup_2() { }
	
	
	

	
	public Dup_2 getInverse(){
		return new Dup_2();
	}
	
	private final RPP[] __steps__ = new RPP[]{
		new RPP() { // BodyPermImpl
			private final int __a__ = 2;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // BodyItImpl
			// Iteration start
			RPP __function__ = new RPP() { // BodyIncImpl
				private RPP __f__ = InvInc.SINGLETON_InvInc;
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
		},
		
		new RPP() { // BodyIfImpl
			RPP __pos__=new RPP() {
				private RPP __f__ = InvId.SINGLETON_InvId;
				private final int __a__ = __f__.getA();
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__, __startIndex__, __endIndex__);
				}
				public int getA() { return __f__.getA(); }
			};
			RPP __zero__=new RPP() {
				private RPP __f__ = InvId.SINGLETON_InvId;
				private final int __a__ = __f__.getA();
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__, __startIndex__, __endIndex__);
				}
				public int getA() { return __f__.getA(); }
			};
			RPP __neg__=new RPP() {
				private RPP __f__ = InvNeg.SINGLETON_InvNeg;
				private final int __a__ = __f__.getA();
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__, __startIndex__, __endIndex__);
				}
				public int getA() { return this.__a__; }
			};
			public int getA() { return this.__pos__.getA()+1; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				final int __testValue__ = __x__[(__startIndex__ + this.getA()) - 1];
				if(__testValue__ > 0){
					__pos__.b(__x__, __startIndex__, __startIndex__ + __pos__.getA());
				} else if(__testValue__ == 0){
					__zero__.b(__x__, __startIndex__, __startIndex__ + __zero__.getA());
				} else { // The "__testValue__<0" test is a tautology
					__neg__.b(__x__, __startIndex__, __startIndex__ + __neg__.getA());
				}
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
}