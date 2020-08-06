package mod3;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class G implements RPP {
    public G() { }
    RPP function = new mod1.Ambiguous_name();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }
}