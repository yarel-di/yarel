package parallelTest;
import yarelcore.*;	

public class Empty2 implements RPP {
	public Empty2() { }
	
	@Override
	public InvEmpty2 getInverse(){
		return new InvEmpty2();
	}
	
	private final int a = 2;
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) {
		// There were only parallels identities, nothing interesting to show and run
	}
}