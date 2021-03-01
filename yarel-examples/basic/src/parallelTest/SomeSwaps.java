package parallelTest;
import yarelcore.*;	

public class SomeSwaps implements RPP {
	public SomeSwaps() { }

	
	public InvSomeSwaps getInverse(){
		return new InvSomeSwaps();
	}
	
	private final int a = 10;
	public void b(int[] x, int startIndex, int endIndex) {
		int tmp=0;
		tmp = x[startIndex + 0]; 
		x[startIndex + 0] = x[startIndex + 9]; 
		x[startIndex + 9] = x[startIndex + 6]; 
		x[startIndex + 6] = x[startIndex + 8]; 
		x[startIndex + 8] = tmp; 
		tmp = x[startIndex + 1]; 
		x[startIndex + 1] = x[startIndex + 5]; 
		x[startIndex + 5] = x[startIndex + 3]; 
		x[startIndex + 3] = tmp; 
		tmp = x[startIndex + 2]; 
		x[startIndex + 2] = x[startIndex + 4]; 
		x[startIndex + 4] = x[startIndex + 7]; 
		x[startIndex + 7] = tmp; 
	}
	public int getA() { return this.a; }
}