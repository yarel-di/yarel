package parallelTest;
import yarelcore.*;	

public class InvEmpty2 implements RPP {
	public InvEmpty2() { }

	
	public Empty2 getInverse(){
		return new Empty2();
	}
	
	public int getA() { return 2; }
	public void b(int[] x, int startIndex, int endIndex) {
		// There were only parallels identities, nothing interesting to show and run
	}
}