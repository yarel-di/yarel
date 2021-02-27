package arithNat;
import yarelcore.*;	

public class SumN implements RPP {
	public SumN() { }
	
	public InvSumN getInverse(){
		return new InvSumN();
	}
	
	// Iteration start
	RPP function = new RPP() { // BodyIncImpl
		private RPP f = Inc.SINGLETON_Inc;
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