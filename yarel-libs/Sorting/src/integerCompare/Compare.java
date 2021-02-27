package integerCompare;
import yarelcore.*;	

public class Compare implements RPP {
	public Compare() { }
	
	public InvCompare getInverse(){
		return new InvCompare();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // BodyFunImpl
			RPP function = new DupStep();
			private final int a = function.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
			 public int getA() { return this.a; }
		},
		
		new RPP() { // BodyIfImpl
			RPP pos=new RPP() {
				RPP pos=new RPP() {
					RPP function = new SameSignCompare();
					private final int a = function.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.function.b(x, startIndex, endIndex);
					}
					 public int getA() { return this.a; }
				};
				RPP zero=new RPP() {
					private RPP f = new RPP(){
						private RPP f = new Dec();
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					};
					private final int a = 3 ;
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex + 0, startIndex + this.a + 0);
					}
				};
				RPP neg=new RPP() {
					private RPP f = new RPP(){
						private RPP f = new Dec();
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					};
					private final int a = 3 ;
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex + 0, startIndex + this.a + 0);
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
			RPP zero=new RPP() {
				RPP pos=new RPP() {
					private RPP f = new RPP(){
						private RPP f = new Inc();
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					};
					private final int a = 3 ;
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex + 0, startIndex + this.a + 0);
					}
				};
				RPP zero=new RPP() {
					private final int a = 3;
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) {
						// There were only parallels identities, nothing interesting to show and run
					}
				};
				RPP neg=new RPP() {
					private RPP f = new RPP(){
						private RPP f = new Dec();
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					};
					private final int a = 3 ;
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex + 0, startIndex + this.a + 0);
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
			RPP neg=new RPP() {
				RPP pos=new RPP() {
					private RPP f = new RPP(){
						private RPP f = new Inc();
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					};
					private final int a = 3 ;
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex + 0, startIndex + this.a + 0);
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
					private final int a = 3 ;
					public int getA() { return this.a; }
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex + 0, startIndex + this.a + 0);
					}
				};
				RPP neg=new RPP() {
					RPP function = new SameSignCompare();
					private final int a = function.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.function.b(x, startIndex, endIndex);
					}
					 public int getA() { return this.a; }
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
		
		new RPP() { // BodyInvImpl
			RPP function = new InvDupStep();
			private final int a = function.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
			 public int getA() { return this.a; }
		}
	};
	private final int a = steps[0].getA();
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		int i;
		i = -1;
		while( ++i < steps.length ){
			steps[i].b(x, startIndex, endIndex);
		}
	}
}