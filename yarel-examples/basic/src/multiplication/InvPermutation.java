package multiplication;
import yarelcore.*;	

public class InvPermutation implements RPP {
	public InvPermutation() { }
	
	public Permutation getInverse(){
		return new Permutation();
	}
	
	private final int a = 3;
	public void b(int[] x, int startIndex, int endIndex) {
		int tmp=0;
		tmp = x[startIndex + 0]; 
		x[startIndex + 0] = x[startIndex + 1]; 
		x[startIndex + 1] = x[startIndex + 2]; 
		x[startIndex + 2] = tmp; 
	}
	
	public int getA() { return this.a; }
}