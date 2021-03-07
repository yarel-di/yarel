package multiplication;
import yarelcore.*;	

public class InvMultiplication implements RPP {
	public InvMultiplication() { }
	
	
	

	
	public Multiplication getInverse(){
		return new Multiplication();
	}
	
	private final RPP[] __steps__ = new RPP[]{
		new RPP() { // BodyFunImpl
			RPP __function__ = new InvPermutation();
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
			}
		},
		
		new RPP() { // BodyItImpl
			// Iteration start
			RPP __function__ = new RPP() { // BodyItImpl
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
		
		new RPP() { // BodyInvImpl
			RPP __function__ = new Permutation();
			public int getA() { return __function__.getA(); }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__function__.b(__x__, __startIndex__, __endIndex__);
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