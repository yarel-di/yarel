package bubble4Fili;
import yarelcore.*;	

public class InvB4sort implements RPP {
	public InvB4sort() { }
	
	public B4sort getInverse(){
		return new B4sort();
	}
	
	private final RPP[] steps = new RPP[]{
		new RPP() { // BodyFunImpl
			RPP function = new InvB4sort_p1();
			private final int a = function.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
			 public int getA() { return this.a; }
		},
		
		new RPP() { // BodyFunImpl
			RPP function = new InvB4sort_p1();
			private final int a = function.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
			 public int getA() { return this.a; }
		},
		
		new RPP() { // BodyFunImpl
			RPP function = new InvB4sort_p1();
			private final int a = function.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
			 public int getA() { return this.a; }
		},
		
		new RPP() { // BodyFunImpl
			RPP function = new InvB4sort_p2();
			private final int a = function.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
			 public int getA() { return this.a; }
		},
		
		new RPP() { // BodyFunImpl
			RPP function = new InvB4sort_p2();
			private final int a = function.getA();
			public void b(int[] x, int startIndex, int endIndex) {
				this.function.b(x, startIndex, endIndex);
			}
			 public int getA() { return this.a; }
		},
		
		new RPP() { // BodyFunImpl
			RPP function = new InvB4sort_p3();
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
		i = steps.length;
		while( i-->0 ){
			steps[i].b(x, startIndex, endIndex);
		}
	}
}