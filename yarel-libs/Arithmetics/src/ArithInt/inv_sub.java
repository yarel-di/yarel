package ArithInt;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
import Util.*; 
import ArithNat.*; 
public class inv_sub implements RPP {
    public inv_sub() { }
    RPP function = new sum();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }          
}