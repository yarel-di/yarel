package ArithNat;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
public class subN implements RPP {
    public subN() { }
    RPP function = new inv_sumN();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }          
}