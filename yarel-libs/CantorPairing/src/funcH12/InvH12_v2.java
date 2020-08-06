package funcH12;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class InvH12_v2 implements RPP {
    public InvH12_v2() { }
    RPP function = new InvP3sub();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }
}