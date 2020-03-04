package base;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
public class inv_f implements RPP {
    public inv_f() { }
    private RPP f = new inv_inc();
    private final int a = f.getA();
    public int[] b(int[] x) {
    	return this.f.b(x);
    }
    public int getA() { return this.a; }
}