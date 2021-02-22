package multiplication;
import yarelcore.*;	

public class Permutation implements RPP {
	public Permutation() { }
	
	@Override
	public InvPermutation getInverse(){
		return new InvPermutation();
	}
	
	private final int a = 3;
	public void b(int[] x, int startIndex, int endIndex) {
		int tmp=0;
		tmp = x[startIndex + 0]; 
		x[startIndex + 0] = x[startIndex + 2]; 
		x[startIndex + 2] = x[startIndex + 1]; 
		x[startIndex + 1] = tmp; 
	}
	
	public int getA() { return this.a; }
}