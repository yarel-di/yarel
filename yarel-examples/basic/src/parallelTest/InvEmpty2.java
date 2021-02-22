package parallelTest;
import yarelcore.*;	

public class InvEmpty2 implements RPP {
	public InvEmpty2() { }
	
	@Override
	public Empty2 getInverse(){
		return new Empty2();
	}
	
	private final int a = 2;
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) {
		// There were only parallels identities, nothing interesting to show and run
	}
}