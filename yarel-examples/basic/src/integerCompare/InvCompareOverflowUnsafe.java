package integerCompare;
import yarelcore.*;	

public class InvCompareOverflowUnsafe implements RPP {
	public InvCompareOverflowUnsafe() { }

	
	public CompareOverflowUnsafe getInverse(){
		return new CompareOverflowUnsafe();
	}
	
	RPP function = new InvSameSignCompare();
	 public int getA() { return function.getA(); }
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
}