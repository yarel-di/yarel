package funcH12;
import yarelcore.*;	

public class Dup_2 implements RPP {
	public Dup_2() { }
	
	

	
	public InvDup_2 getInverse(){
		return new InvDup_2();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // BodyPermImpl
			private final int a = 2;
			public void b(int[] x, int startIndex, int endIndex) {
				int tmp=0;
				tmp = x[startIndex + 0]; 
				x[startIndex + 0] = x[startIndex + 1]; 
				x[startIndex + 1] = tmp; 
			}
			public int getA() { return this.a; }
		},
		
		new RPP() { // BodyItImpl
			// Iteration start
			RPP function = new RPP() { // BodyIncImpl
				private RPP f = Inc.SINGLETON_Inc;
				private final int a = f.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x, startIndex, endIndex);
				}
				public int getA() { return this.a; }
			};
			public int getA() { return function.getA()+1; }
			public void b(int[] x, int startIndex, int endIndex) {
				int endIndexBody = (startIndex + this.getA()) - 1;
				int iterationsLeft = Math.abs(x[endIndexBody]);
				while(iterationsLeft-->0){
					function.b(x, startIndex, endIndexBody);
				}
			}
			// Iteration stop
		},
		
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
				private RPP f = Neg.SINGLETON_Neg;
				private final int a = f.getA();
				public void b(int[] x, int startIndex, int endIndex) {
					this.f.b(x, startIndex, endIndex);
				}
				public int getA() { return this.a; }
			};
			public int getA() { return this.pos.getA()+1; }
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