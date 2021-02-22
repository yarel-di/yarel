package multiplication;
import yarelcore.*;	

public class InvMultiplication implements RPP {
	public InvMultiplication() { }
	
	@Override
	public Multiplication getInverse(){
		return new Multiplication();
	}
	
	RPP l = new RPP() { // SerCompImpl
		RPP l = new RPP() { // BodyFunImpl
			RPP function = new InvPermutation();
			private final int a = function.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
			 public int getA() { return this.a; }
		};
		RPP r = new RPP() { // BodyItImpl
			// Iteration start
			RPP function = new RPP() { // BodyItImpl
				// Iteration start
				RPP function = new RPP() { // BodyIncImpl
					private RPP f = new InvInc();
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
	};
	RPP r = new RPP() { // BodyInvImpl
		RPP function = new Permutation();
		private final int a = function.getA();
		public void b(int[] x, int startIndex, int endIndex) {
			this.function.b(x, startIndex, endIndex);
		}
		 public int getA() { return this.a; }
	};
	private final int a = l.getA();
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		this.r.b(x, startIndex, endIndex);
		this.l.b(x, startIndex, endIndex);
	}
}