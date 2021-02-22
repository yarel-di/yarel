package integerCompare;
import yarelcore.*;	

public class InvCompareOverflowUnsafe implements RPP {
	public InvCompareOverflowUnsafe() { }
	
	@Override
	public CompareOverflowUnsafe getInverse(){
		return new CompareOverflowUnsafe();
	}
	
	RPP function = new InvSameSignCompare();
	private final int a = function.getA();
	public void b(int[] x, int startIndex, int endIndex) {
		this.function.b(x, startIndex, endIndex);
	}
	 public int getA() { return this.a; }
}