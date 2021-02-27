package quotient;
import yarelcore.*;	

public class InvQuo implements RPP {
	public InvQuo() { }
	
	public Quo getInverse(){
		return new Quo();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // BodyPermImpl
			private final int a = 6;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 1]; 
				x[startIndex + 1] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 4]; 
				x[startIndex + 4] = x[startIndex + 5]; 
				x[startIndex + 5] = tmp; 
			}
			
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new arithNat.InvSumN();
				private final int a = function.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
				 public int getA() { return this.a; }
			};
			private final int a = 6 ;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex + 0, startIndex + this.a + 0);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 6;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 5]; 
				x[startIndex + 5] = x[startIndex + 4]; 
				x[startIndex + 4] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 1]; 
				x[startIndex + 1] = tmp; 
			}
			
			public int getA() { return this.a; }
		},
		
		new RPP() { // BodyItImpl
			// Iteration start
			RPP function = new RPP() { // SerCompImpl
				private final RPP[] steps = new RPP[]{
					new RPP() { // ParCompImpl
						private RPP f = new RPP(){
							RPP function = new InvQuoStep();
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
					},
					
					new RPP() { // BodyPermImpl
						private final int a = 5;
						public void b(int[] x, int startIndex, int endIndex) {
							int tmp=0;
							tmp = x[startIndex + 3]; 
							x[startIndex + 3] = x[startIndex + 4]; 
							x[startIndex + 4] = tmp; 
						}
						
						public int getA() { return this.a; }
					},
					
					new RPP() { // BodyIfImpl
						RPP pos=new RPP() {
							private final int a = 4;
							public int getA() { return this.a; }
							public void b(int[] x, int startIndex, int endIndex) {
								// There were only parallels identities, nothing interesting to show and run
							}
						};
						RPP zero=new RPP() {
							private final int a = 4;
							public int getA() { return this.a; }
							public void b(int[] x, int startIndex, int endIndex) {
								// There were only parallels identities, nothing interesting to show and run
							}
						};
						RPP neg=new RPP() {
							private RPP f = new RPP(){
								private RPP f = new InvInc();
								private final int a = f.getA();
								public void b(int[] x, int startIndex, int endIndex) {
									this.f.b(x, startIndex, endIndex);
								}
								public int getA() { return this.a; }
							};
							private final int a = 4 ;
							public int getA() { return this.a; }
							public void b(int[] x, int startIndex, int endIndex) {
								this.f.b(x, startIndex + 3, startIndex + this.a + 3);
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
					},
					
					new RPP() { // BodyPermImpl
						private final int a = 5;
						public void b(int[] x, int startIndex, int endIndex) {
							int tmp=0;
							tmp = x[startIndex + 3]; 
							x[startIndex + 3] = x[startIndex + 4]; 
							x[startIndex + 4] = tmp; 
						}
						
						public int getA() { return this.a; }
					},
					
					new RPP() { // BodyIfImpl
						RPP pos=new RPP() {
							private final RPP[] steps = new RPP[]{
								new RPP() { // BodyPermImpl
									private final int a = 4;
									public void b(int[] x, int startIndex, int endIndex) {
										int tmp=0;
										tmp = x[startIndex + 1]; 
										x[startIndex + 1] = x[startIndex + 2]; 
										x[startIndex + 2] = x[startIndex + 3]; 
										x[startIndex + 3] = tmp; 
									}
									
									public int getA() { return this.a; }
								},
								
								new RPP() { // ParCompImpl
									private RPP f = new RPP(){
										RPP function = new arithNat.InvSumN();
										private final int a = function.getA();
										public void b(int[] x, int startIndex, int endIndex) {
											this.function.b(x, startIndex, endIndex);
										}
										 public int getA() { return this.a; }
									};
									private final int a = 4 ;
									public int getA() { return this.a; }
									public void b(int[] x, int startIndex, int endIndex) {
										this.f.b(x, startIndex + 1, startIndex + this.a + 1);
									}
								},
								
								new RPP() { // BodyPermImpl
									private final int a = 4;
									public void b(int[] x, int startIndex, int endIndex) {
										int tmp=0;
										tmp = x[startIndex + 1]; 
										x[startIndex + 1] = x[startIndex + 3]; 
										x[startIndex + 3] = x[startIndex + 2]; 
										x[startIndex + 2] = tmp; 
									}
									
									public int getA() { return this.a; }
								}
							};
							private final int a = steps[0].getA();
							public int getA() { return this.a; }
							public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
								int i;
								i = steps.length;
								while( i-->0 ){
									steps[i].b(x, startIndex, endIndex);
								}
							}
						};
						RPP zero=new RPP() {
							private final int a = 4;
							public int getA() { return this.a; }
							public void b(int[] x, int startIndex, int endIndex) {
								// There were only parallels identities, nothing interesting to show and run
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
					}
				};
				private final int a = steps[0].getA();
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
					int i;
					i = steps.length;
					while( i-->0 ){
						steps[i].b(x, startIndex, endIndex);
					}
				}
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
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new arithNat.InvSubN();
				private final int a = function.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
				 public int getA() { return this.a; }
			};
			private final int a = 6 ;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex + 4, startIndex + this.a + 4);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 6;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 4]; 
				x[startIndex + 4] = tmp; 
			}
			
			public int getA() { return this.a; }
		},
		
		new RPP() { // ParCompImpl
			private RPP f = new RPP(){
				RPP function = new arithNat.InvSumN();
				private final int a = function.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.function.b(x, startIndex, endIndex);
				}
				 public int getA() { return this.a; }
			};
			private final int a = 6 ;
			public int getA() { return this.a; }
			public void b(int[] x, int startIndex, int endIndex) {
				this.f.b(x, startIndex + 2, startIndex + this.a + 2);
			}
		},
		
		new RPP() { // BodyPermImpl
			private final int a = 6;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 3]; 
				x[startIndex + 3] = x[startIndex + 2]; 
				x[startIndex + 2] = x[startIndex + 5]; 
				x[startIndex + 5] = tmp; 
			}
			
			public int getA() { return this.a; }
		}
	};
	private final int a = steps[0].getA();
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		int i;
		i = steps.length;
		while( i-->0 ){
			steps[i].b(x, startIndex, endIndex);
		}
	}
}