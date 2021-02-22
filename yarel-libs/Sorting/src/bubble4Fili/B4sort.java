package bubble4Fili;
import yarelcore.*;	

public class B4sort implements RPP {
	public B4sort() { }
	
	public InvB4sort getInverse(){
		return new InvB4sort();
	}
	
	RPP l = new RPP() { // SerCompImpl
		RPP l = new RPP() { // SerCompImpl
			RPP l = new RPP() { // SerCompImpl
				RPP l = new RPP() { // SerCompImpl
					RPP l = new RPP() { // BodyFunImpl
						RPP function = new B4sort_p1();
						private final int a = function.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.function.b(x, startIndex, endIndex);
						}
						 public int getA() { return this.a; }
					};
					RPP r = new RPP() { // BodyFunImpl
						RPP function = new B4sort_p1();
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
				RPP r = new RPP() { // BodyFunImpl
					RPP function = new B4sort_p1();
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
			RPP r = new RPP() { // BodyFunImpl
				RPP function = new B4sort_p2();
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
		RPP r = new RPP() { // BodyFunImpl
			RPP function = new B4sort_p2();
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
	RPP r = new RPP() { // BodyFunImpl
		RPP function = new B4sort_p3();
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
}