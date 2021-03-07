package arithNat;
import yarelcore.*;	

public class SumN implements RPP {
	public SumN() { }
	
	
	

	
	public InvSumN getInverse(){
		return new InvSumN();
	}
	
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
}