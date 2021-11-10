package arithNat;
import java.math.BigInteger;
import yarelcore.*;	

public class InvSumN implements RPP {
	public InvSumN() { }
	
	
	public SumN getInverse(){
		return new SumN();
	}
	
	// Iteration start
	RPP __function__ = new RPP() { // BodyIncImpl
		private RPP __f__ = InvInc.SINGLETON_InvInc;
		private final int __a__ = __f__.getA();
		public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
			this.__f__.b(__x__, __startIndex__, __endIndex__);
		}
		public int getA() { return this.__a__; }
	};
	public int getA() { return __function__.getA()+1; }
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
		int __endIndexBody__ = (__startIndex__ + this.getA()) - 1;
		BigInteger __iterationsLeft__ = __x__[__endIndexBody__].abs();
		while(__iterationsLeft__.compareTo(BigInteger.ZERO) > 0){
			__function__.b(__x__, __startIndex__, __endIndexBody__);
			__iterationsLeft__ = __iterationsLeft__.subtract(BigInteger.ONE);
		}
	}
	// Iteration stop
}