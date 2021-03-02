package permuatation;
import yarelcore.*;	

public class InvPExample implements RPP {
	public InvPExample() { }
	
	

	
	public PExample getInverse(){
		return new PExample();
	}
	
	private final int a = 4;
	public void b(int[] x, int startIndex, int endIndex) {
		int tmp=0;
		tmp = x[startIndex + 0]; 
		x[startIndex + 0] = x[startIndex + 2]; 
		x[startIndex + 2] = tmp; 
		tmp = x[startIndex + 1]; 
		x[startIndex + 1] = x[startIndex + 3]; 
		x[startIndex + 3] = tmp; 
	}
	public int getA() { return this.a; }
}