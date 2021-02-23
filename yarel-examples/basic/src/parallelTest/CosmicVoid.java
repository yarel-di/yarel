package parallelTest;
import yarelcore.*;	

public class CosmicVoid implements RPP {
	public CosmicVoid() { }
	
	public InvCosmicVoid getInverse(){
		return new InvCosmicVoid();
	}
	
	private final int a = 9;
	public int getA() { return this.a; }
	public void b(int[] x, int startIndex, int endIndex) {
		// There were only parallels identities, nothing interesting to show and run
	}
}