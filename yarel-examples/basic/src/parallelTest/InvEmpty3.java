package parallelTest;
import yarelcore.*;	

public class InvEmpty3 implements RPP {
	public InvEmpty3() { }
	
	public Empty3 getInverse(){
		return new Empty3();
	}
	
	private final int a = 3;
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) {
		// There were only parallels identities, nothing interesting to show and run
	}
}