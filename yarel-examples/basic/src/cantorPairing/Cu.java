package cantorPairing;
import yarelcore.*;	

public class Cu implements RPP {
	public Cu() { }
	
	@Override
	public InvCu getInverse(){
		return new InvCu();
	}
	
	RPP l = new RPP() { // SerCompImpl
		RPP l = new RPP() { // SerCompImpl
			RPP l = new RPP() { // SerCompImpl
				RPP l = new RPP() { // SerCompImpl
					RPP l = new RPP() { // SerCompImpl
						RPP l = new RPP() { // SerCompImpl
							RPP l = new RPP() { // SerCompImpl
								RPP l = new RPP() { // BodyPermImpl
									private final int a = 5;
									public void b(int[] x, int startIndex, int endIndex) {
										int tmp=0;
										tmp = x[startIndex + 0]; 
										x[startIndex + 0] = x[startIndex + 1]; 
										x[startIndex + 1] = tmp; 
									}
									
									public int getA() { return this.a; }
								};
								RPP r = new RPP() { // BodyFunImpl
									RPP function = new boundedMin.MinH12();
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
								private final int a = 5;
								public void b(int[] x, int startIndex, int endIndex) {
									int tmp=0;
									tmp = x[startIndex + 1]; 
									x[startIndex + 1] = x[startIndex + 2]; 
									x[startIndex + 2] = x[startIndex + 3]; 
									x[startIndex + 3] = x[startIndex + 4]; 
									x[startIndex + 4] = tmp; 
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
						RPP r = new RPP() { // BodyIfImpl
							RPP pos=new RPP() {
								private final int a = 4;
								public int getA() { return this.a; }
								public void b(int[] x, int startIndex, int endIndex) {
									// There were only parallels identities, nothing interesting to show and run
								}
							};
							RPP zero=new RPP() {
								private RPP f = new RPP(){
									private RPP f = new Inc();
									private final int a = f.getA();
									public void b(int[] x, int startIndex, int endIndex) {
										this.f.b(x, startIndex, endIndex);
									}
									public int getA() { return this.a; }
								};
								private final int a = 4 ;
								public int getA() { return this.a; }
								public void b(int[] x, int startIndex, int endIndex) {
									this.f.b(x, startIndex + 0, startIndex + this.a + 0);
								}
							};
							RPP neg=new RPP() {
								private final int a = 4;
								public int getA() { return this.a; }
								public void b(int[] x, int startIndex, int endIndex) {
									// There were only parallels identities, nothing interesting to show and run
								}
							};
							private final int a=pos.getA()+1;
							public int getA() {return this.a;}
							public void b(int[] x, int startIndex, int endIndex) {
								final int testValue = x[(startIndex + a) - 1];
								if(testValue > 0){
									pos.b(x, startIndex, startIndex + pos.getA());
								} else if(testValue == 0){
									zero.b(x, startIndex, startIndex + zero.getA());
								} else { // The "testValue<0" test is a tautology
									neg.b(x, startIndex, startIndex + neg.getA());
								}
							}
						};
						private final int a = l.getA();
						public int getA() { return this.a; }
						public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
							this.l.b(x, startIndex, endIndex);
							this.r.b(x, startIndex, endIndex);
						}
					};
					RPP r = new RPP() { // BodyPermImpl
						private final int a = 5;
						public void b(int[] x, int startIndex, int endIndex) {
							int tmp=0;
							tmp = x[startIndex + 1]; 
							x[startIndex + 1] = x[startIndex + 4]; 
							x[startIndex + 4] = x[startIndex + 3]; 
							x[startIndex + 3] = x[startIndex + 2]; 
							x[startIndex + 2] = tmp; 
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
				RPP r = new RPP() { // ParCompImpl
					private RPP f = new RPP(){
						private RPP f = new Dec();
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					};
					private final int a = 5 ;
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex + 0, startIndex + this.a + 0);
					}
				};
				private final int a = l.getA();
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
					this.l.b(x, startIndex, endIndex);
					this.r.b(x, startIndex, endIndex);
				}
			};
			RPP r = new RPP() { // ParCompImpl
				private RPP f = new RPP(){
					RPP function = new funcH12.H12_v2();
					private final int a = function.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.function.b(x, startIndex, endIndex);
					}
					 public int getA() { return this.a; }
				};
				private final int a = 5 ;
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x, startIndex + 0, startIndex + this.a + 0);
				}
			};
			private final int a = l.getA();
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
				this.l.b(x, startIndex, endIndex);
				this.r.b(x, startIndex, endIndex);
			}
		};
		RPP r = new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new arithNat.SubN();
				private final int a = function.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
				 public int getA() { return this.a; }
			};
			private final int a = 5 ;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex + 0, startIndex + this.a + 0);
			}
		};
		private final int a = l.getA();
		public int getA() { return this.a; }
		public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
			this.l.b(x, startIndex, endIndex);
			this.r.b(x, startIndex, endIndex);
		}
	};
	RPP r = new RPP() { // BodyPermImpl
		private final int a = 5;
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