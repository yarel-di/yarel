package mod1;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class InvAmbiguous_name implements RPP {
    public InvAmbiguous_name() { }
    private RPP f = new InvId();
    private final int a = f.getA();
    public int[] b(int[] x) {
    	return this.f.b(x);
    }
    public int getA() { return this.a; }
}