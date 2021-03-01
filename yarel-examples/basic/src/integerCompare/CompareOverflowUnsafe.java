package integerCompare;
import yarelcore.*;	

public class CompareOverflowUnsafe implements RPP {
	public CompareOverflowUnsafe() { }

	
	public InvCompareOverflowUnsafe getInverse(){
		return new InvCompareOverflowUnsafe();
	}
	
	RPP function = new SameSignCompare();
	 public int getA() { return function.getA(); }
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
}