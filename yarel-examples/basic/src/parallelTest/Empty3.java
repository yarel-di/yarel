package parallelTest;
import yarelcore.*;	

public class Empty3 implements RPP {
	public Empty3() { }

	
	public InvEmpty3 getInverse(){
		return new InvEmpty3();
	}
	
	public int getA() { return 3; }
	public void b(int[] x, int startIndex, int endIndex) {
		// There were only parallels identities, nothing interesting to show and run
	}
}