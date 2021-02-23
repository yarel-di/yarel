package funcH12;
import yarelcore.*;	

public class InvH12 implements RPP {
	public InvH12() { }
	
	public H12 getInverse(){
		return new H12();
	}
	
	RPP l = new RPP() { // SerCompImpl
		RPP l = new RPP() { // SerCompImpl
			RPP l = new RPP() { // BodyPermImpl
				private final int a = 3;
				public void b(int[] x, int startIndex, int endIndex) {
					int tmp=0;
					tmp = x[startIndex + 1]; 
					x[startIndex + 1] = x[startIndex + 2]; 
					x[startIndex + 2] = tmp; 
				}
				
				public int getA() { return this.a; }
			};
			RPP r = new RPP() { // BodyFunImpl
				RPP function = new InvT3sub();
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
		};
		RPP r = new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new Dup_2();
				private final int a = function.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
				 public int getA() { return this.a; }
			};
			private final int a = 3 ;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex + 0, startIndex + this.a + 0);
			}
		};
		private final int a = l.getA();
		public int getA() { return this.a; }
		public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
			this.r.b(x, startIndex, endIndex);
			this.l.b(x, startIndex, endIndex);
		}
	};
	RPP r = new RPP() { // BodyPermImpl
		private final int a = 3;
		public void b(int[] x, int startIndex, int endIndex) {
			int tmp=0;
			tmp = x[startIndex + 1]; 
			x[startIndex + 1] = x[startIndex + 2]; 
			x[startIndex + 2] = tmp; 
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