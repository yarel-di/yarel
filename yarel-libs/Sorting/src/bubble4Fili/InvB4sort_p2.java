package bubble4Fili;
import yarelcore.*;	

public class InvB4sort_p2 implements RPP {
	public InvB4sort_p2() { }
	
	public B4sort_p2 getInverse(){
		return new B4sort_p2();
	}
	
	RPP l = new RPP() { // SerCompImpl
		RPP l = new RPP() { // SerCompImpl
			RPP l = new RPP() { // ParCompImpl
				private RPP f = new RPP(){
					RPP function = new cantorPairing.InvCu();
					private final int a = function.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.function.b(x, startIndex, endIndex);
					}
					 public int getA() { return this.a; }
				};
				private final int a = 10 ;
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x, startIndex + 4, startIndex + this.a + 4);
				}
			};
			RPP r = new RPP() { // BodyPermImpl
				private final int a = 10;
				public void b(int[] x, int startIndex, int endIndex) {
					int tmp=0;
					tmp = x[startIndex + 5]; 
					x[startIndex + 5] = x[startIndex + 7]; 
					x[startIndex + 7] = tmp; 
					tmp = x[startIndex + 6]; 
					x[startIndex + 6] = x[startIndex + 8]; 
					x[startIndex + 8] = tmp; 
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
		RPP r = new RPP() { // BodyPermImpl
			private final int a = 10;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 6]; 
				x[startIndex + 6] = x[startIndex + 4]; 
				x[startIndex + 4] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 5]; 
				x[startIndex + 5] = x[startIndex + 3]; 
				x[startIndex + 3] = tmp; 
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
			RPP function = new integerCompare.InvLess();
			private final int a = function.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
			 public int getA() { return this.a; }
		};
		private final int a = 10 ;
		public int getA() { return this.a; }
		public void b(int[] x, int startIndex, int endIndex) {
			this.f.b(x, startIndex + 2, startIndex + this.a + 2);
		}
	};
	private final int a = l.getA();
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		this.r.b(x, startIndex, endIndex);
		this.l.b(x, startIndex, endIndex);
	}
}