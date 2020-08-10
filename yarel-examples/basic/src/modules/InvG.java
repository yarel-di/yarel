package modules;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class InvG implements RPP {
    public InvG() { }
    private RPP f = new InvId();
    private final int a = f.getA();
    public int[] b(int[] x) {
    	return this.f.b(x);
    }
    public int getA() { return this.a; }
}