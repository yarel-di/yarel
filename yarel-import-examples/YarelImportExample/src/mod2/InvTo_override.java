package mod2;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class InvTo_override implements RPP {
    public InvTo_override() { }
    private RPP f = new InvNeg();
    private final int a = f.getA();
    public int[] b(int[] x) {
    	return this.f.b(x);
    }
    public int getA() { return this.a; }
}