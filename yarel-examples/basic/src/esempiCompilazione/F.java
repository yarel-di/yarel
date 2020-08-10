package esempiCompilazione;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class F implements RPP {
    public F() { }
    private RPP f = new Inc();
    private final int a = f.getA();
    public int[] b(int[] x) {
    	return this.f.b(x);
    }
    public int getA() { return this.a; }
}