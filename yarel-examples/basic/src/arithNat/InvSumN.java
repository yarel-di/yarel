package arithNat;
import yarelcore.*;	

public class InvSumN implements RPP {
	public InvSumN() { }
	
	public SumN getInverse(){
		return new SumN();
	}
	
	// Iteration start
	RPP function = new RPP() { // BodyIncImpl
		private RPP f = InvInc.SINGLETON_InvInc;
		private final int a = f.getA();
		public void b(int[] x, int startIndex, int endIndex) {
			this.f.b(x, startIndex, endIndex);
		}
		public int getA() { return this.a; }
	};
	private final int a = function.getA()+1;
	public void b(int[] x, int startIndex, int endIndex) {
		int endIndexBody = (startIndex + a) - 1;
		int iterationsLeft = Math.abs(x[endIndexBody]);
		while(iterationsLeft-->0){
			function.b(x, startIndex, endIndexBody);
		}
	}
	public int getA() { return this.a; } 
	// Iteration stop
}