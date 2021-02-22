package arithNat;
import yarelcore.*;	

public class InvMulN implements RPP {
	public InvMulN() { }
	
	@Override
	public MulN getInverse(){
		return new MulN();
	}
	
	RPP l = new RPP() { // BodyPermImpl
		private final int a = 3;
		public void b(int[] x, int startIndex, int endIndex) {
			int tmp=0;
			tmp = x[startIndex + 0]; 
			x[startIndex + 0] = x[startIndex + 1]; 
			x[startIndex + 1] = x[startIndex + 2]; 
			x[startIndex + 2] = tmp; 
		}
		
		public int getA() { return this.a; }
	};
	RPP r = new RPP() { // BodyItImpl
		// Iteration start
		RPP function = new RPP() { // BodyFunImpl
			RPP function = new InvSumN();
			private final int a = function.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
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
	};
	private final int a = l.getA();
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		this.r.b(x, startIndex, endIndex);
		this.l.b(x, startIndex, endIndex);
	}
}