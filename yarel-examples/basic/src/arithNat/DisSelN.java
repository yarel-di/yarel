package arithNat;
import yarelcore.*;	

public class DisSelN implements RPP {
	public DisSelN() { }

	
	public InvDisSelN getInverse(){
		return new InvDisSelN();
	}
	
	RPP pos=new RPP() {
		private final RPP[] steps = new RPP[]{
			new RPP() { // BodyIfImpl
				RPP pos=new RPP() {
					private RPP f = Id.SINGLETON_Id;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return f.getA(); }
				};
				RPP zero=new RPP() {
					private RPP f = Id.SINGLETON_Id;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return f.getA(); }
				};
				RPP neg=new RPP() {
					private RPP f = Id.SINGLETON_Id;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return f.getA(); }
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
			
			new RPP() { // ParCompImpl
				public int getA() { return 2; }
				public void b(int[] x, int startIndex, int endIndex) {
					// There were only parallels identities, nothing interesting to show and run
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
	};
	RPP zero=new RPP() {
		private final RPP[] steps = new RPP[]{
			new RPP() { // BodyIfImpl
				RPP pos=new RPP() {
					private RPP f = Id.SINGLETON_Id;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return f.getA(); }
				};
				RPP zero=new RPP() {
					private RPP f = Id.SINGLETON_Id;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return f.getA(); }
				};
				RPP neg=new RPP() {
					private RPP f = Id.SINGLETON_Id;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return f.getA(); }
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
			
			new RPP() { // ParCompImpl
				private RPP f = new RPP(){
					private RPP f = Inc.SINGLETON_Inc;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				public int getA() { return 2; }
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x,
						startIndex + 1,
						startIndex + (1) + (1)
						);
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
	};
	RPP neg=new RPP() {
		private final RPP[] steps = new RPP[]{
			new RPP() { // BodyIfImpl
				RPP pos=new RPP() {
					private RPP f = Dec.SINGLETON_Dec;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				RPP zero=new RPP() {
					private RPP f = Dec.SINGLETON_Dec;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				RPP neg=new RPP() {
					private RPP f = Id.SINGLETON_Id;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return f.getA(); }
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
			
			new RPP() { // ParCompImpl
				private RPP f = new RPP(){
					private RPP f = Inc.SINGLETON_Inc;
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				public int getA() { return 2; }
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x,
						startIndex + 1,
						startIndex + (1) + (1)
						);
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
}