package permuatation;
import yarelcore.*;	

public class PExample implements RPP {
	public PExample() { }

	
	public InvPExample getInverse(){
		return new InvPExample();
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