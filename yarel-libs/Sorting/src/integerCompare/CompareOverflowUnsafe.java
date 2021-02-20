package integerCompare;
import yarelcore.*;	

public class CompareOverflowUnsafe implements RPP {
	public CompareOverflowUnsafe() { }
	
	public InvCompareOverflowUnsafe getInverse(){
		return new InvCompareOverflowUnsafe();
	}
	
	RPP function = new SameSignCompare();
	private final int a = function.getA();
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
	 public int getA() { return this.a; }
}