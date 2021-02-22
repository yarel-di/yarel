package parallelTest;
import yarelcore.*;	

public class Empty3 implements RPP {
	public Empty3() { }
	
	@Override
	public InvEmpty3 getInverse(){
		return new InvEmpty3();
	}
	
	private final int a = 3;
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) {
		// There were only parallels identities, nothing interesting to show and run
	}
}