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
					private RPP f = new Id();
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				RPP zero=new RPP() {
					private RPP f = new Id();
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				RPP neg=new RPP() {
					private RPP f = new Id();
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
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
			},
			
			new RPP() { // ParCompImpl
				private final int a = 2;
				public int getA() { return this.a; }
				public void b(int[] x, int startIndex, int endIndex) {
					// There were only parallels identities, nothing interesting to show and run
				}
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
	};
	RPP zero=new RPP() {
		private final RPP[] steps = new RPP[]{
			new RPP() { // BodyIfImpl
				RPP pos=new RPP() {
					private RPP f = new Id();
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				RPP zero=new RPP() {
					private RPP f = new Id();
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				RPP neg=new RPP() {
					private RPP f = new Id();
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
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
			},
			
			new RPP() { // ParCompImpl
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
					this.f.b(x, startIndex + 1, startIndex + this.a + 1);
				}
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
	};
	RPP neg=new RPP() {
		private final RPP[] steps = new RPP[]{
			new RPP() { // BodyIfImpl
				RPP pos=new RPP() {
					private RPP f = new Dec();
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				RPP zero=new RPP() {
					private RPP f = new Dec();
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
					}
					public int getA() { return this.a; }
				};
				RPP neg=new RPP() {
					private RPP f = new Id();
					private final int a = f.getA();
					public void b(int[] x, int startIndex, int endIndex) {
						this.f.b(x, startIndex, endIndex);
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
			},
			
			new RPP() { // ParCompImpl
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
					this.f.b(x, startIndex + 1, startIndex + this.a + 1);
				}
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