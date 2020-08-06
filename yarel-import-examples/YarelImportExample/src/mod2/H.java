package mod2;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class H implements RPP {
    public H() { }
    RPP function = new inner_mod.Inner_f();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }
}