package base;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
public class InvF implements RPP {
    public InvF() { }
    private RPP f = new InvInc();
    private final int a = f.getA();
    public int[] b(int[] x) {
    	return this.f.b(x);
    }
    public int getA() { return this.a; }
}