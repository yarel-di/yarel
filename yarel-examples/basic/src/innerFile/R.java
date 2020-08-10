package innerFile;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
public class R implements RPP {
    public R() { }
    private RPP f = new Id();
    private final int a = f.getA();
    public int[] b(int[] x) {
    	return this.f.b(x);
    }
    public int getA() { return this.a; }
}