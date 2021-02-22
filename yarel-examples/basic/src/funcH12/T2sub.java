package funcH12;
import yarelcore.*;	

public class T2sub implements RPP {
	public T2sub() { }
	
	@Override
	public InvT2sub getInverse(){
		return new InvT2sub();
	}
	
	RPP l = new RPP() { // SerCompImpl
		RPP l = new RPP() { // SerCompImpl
			RPP l = new RPP() { // ParCompImpl
				private RPP f = new RPP(){
					private RPP f = new Inc();
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				private final int a = 2 ;
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x, startIndex + 0, startIndex + this.a + 0);
				}
			};
			RPP r = new RPP() { // BodyPermImpl
				private final int a = 2;
				public void b(int[] x, int startIndex, int endIndex) {
					int tmp=0;
					tmp = x[startIndex + 0]; 
					x[startIndex + 0] = x[startIndex + 1]; 
					x[startIndex + 1] = tmp; 
				}
				
				public int getA() { return this.a; }
			};
			private final int a = l.getA();
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
				this.l.b(x, startIndex, endIndex);
				this.r.b(x, startIndex, endIndex);
			}
		};
		RPP r = new RPP() { // BodyFunImpl
			RPP function = new arithNat.SubN();
			private final int a = function.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
			 public int getA() { return this.a; }
		};
		private final int a = l.getA();
		public int getA() { return this.a; }
		public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
			this.l.b(x, startIndex, endIndex);
			this.r.b(x, startIndex, endIndex);
		}
	};
	RPP r = new RPP() { // BodyPermImpl
		private final int a = 2;
		public void b(int[] x, int startIndex, int endIndex) {
			int tmp=0;
			tmp = x[startIndex + 0]; 
			x[startIndex + 0] = x[startIndex + 1]; 
			x[startIndex + 1] = tmp; 
		}
		
		public int getA() { return this.a; }
	};
	private final int a = l.getA();
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		this.l.b(x, startIndex, endIndex);
		this.r.b(x, startIndex, endIndex);
	}
}