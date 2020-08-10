package mod1;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class To_override implements RPP {
    public To_override() { }
    private RPP f = new Id();
    private final int a = f.getA();
    public int[] b(int[] x) {
    	return this.f.b(x);
    }
    public int getA() { return this.a; }
}