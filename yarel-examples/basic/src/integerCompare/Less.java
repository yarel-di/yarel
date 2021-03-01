package integerCompare;
import yarelcore.*;	

public class Less implements RPP {
	public Less() { }

	
	public InvLess getInverse(){
		return new InvLess();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // BodyFunImpl
			RPP function = new DupStep();
			 public int getA() { return function.getA(); }
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
		},
		
		new RPP() { // BodyIfImpl
			RPP pos=new RPP() {
				RPP pos=new RPP() {
					RPP function = new SameSignLess();
					 public int getA() { return function.getA(); }
					public void b(int[] x, int startIndex, int endIndex) {
						this.function.b(x, startIndex, endIndex);
					}
				};
				RPP zero=new RPP() {
					private RPP f = new RPP(){
						private RPP f = Inc.SINGLETON_Inc;
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					};
					public int getA() { return 3; }
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x,
							startIndex + 0,
							startIndex + (0) + (1)
							);
					}
				};
				RPP neg=new RPP() {
					private RPP f = new RPP(){
						private RPP f = Inc.SINGLETON_Inc;
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					};
					public int getA() { return 3; }
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x,
							startIndex + 0,
							startIndex + (0) + (1)
							);
					}
				};
				public int getA() {return this.pos.getA()+1;}
				public void b(int[] x, int startIndex, int endIndex) {
					final int testValue = x[(startIndex + this.getA()) - 1];
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
					public int getA() { return 3; }
					public void b(int[] x, int startIndex, int endIndex) {
						// There were only parallels identities, nothing interesting to show and run
					}
				};
				RPP zero=new RPP() {
					public int getA() { return 3; }
					public void b(int[] x, int startIndex, int endIndex) {
						// There were only parallels identities, nothing interesting to show and run
					}
				};
				RPP neg=new RPP() {
					private RPP f = new RPP(){
						private RPP f = Inc.SINGLETON_Inc;
						private final int a = f.getA();
						public void b(int[] x, int startIndex, int endIndex) {
							this.f.b(x, startIndex, endIndex);
						}
						public int getA() { return this.a; }
					};
					public int getA() { return 3; }
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x,
							startIndex + 0,
							startIndex + (0) + (1)
							);
					}
				};
				public int getA() {return this.pos.getA()+1;}
				public void b(int[] x, int startIndex, int endIndex) {
					final int testValue = x[(startIndex + this.getA()) - 1];
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
					public int getA() { return 3; }
					public void b(int[] x, int startIndex, int endIndex) {
						// There were only parallels identities, nothing interesting to show and run
					}
				};
				RPP zero=new RPP() {
					public int getA() { return 3; }
					public void b(int[] x, int startIndex, int endIndex) {
						// There were only parallels identities, nothing interesting to show and run
					}
				};
				RPP neg=new RPP() {
					RPP function = new SameSignLess();
					 public int getA() { return function.getA(); }
					public void b(int[] x, int startIndex, int endIndex) {
						this.function.b(x, startIndex, endIndex);
					}
				};
				public int getA() {return this.pos.getA()+1;}
				public void b(int[] x, int startIndex, int endIndex) {
					final int testValue = x[(startIndex + this.getA()) - 1];
					if(testValue > 0){
						pos.b(x, startIndex, startIndex + pos.getA());
					} else if(testValue == 0){
						zero.b(x, startIndex, startIndex + zero.getA());
					} else { // The "testValue<0" test is a tautology
						neg.b(x, startIndex, startIndex + neg.getA());
					}
				}
			};
			public int getA() {return this.pos.getA()+1;}
			public void b(int[] x, int startIndex, int endIndex) {
				final int testValue = x[(startIndex + this.getA()) - 1];
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
			 public int getA() { return function.getA(); }
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
		}
	};
	public int getA() { return this.steps[0].getA(); }
	public void b(int[] x, int startIndex, int endIndex) { // Implements a serial composition.
		int i;
		i = -1;
		while( ++i < steps.length ){
			steps[i].b(x, startIndex, endIndex);
		}
	}
}