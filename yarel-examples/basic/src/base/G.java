package base;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class G implements RPP {
    public G() { }
    private RPP f = new Id();
    private final int a = f.getA();
    public int[] b(int[] x) {
    	return this.f.b(x);
    }
    public int getA() { return this.a; }
}