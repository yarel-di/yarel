package ArithNat;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
public class inv_subN implements RPP {
    public inv_subN() { }
    RPP function = new sumN();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }          
}