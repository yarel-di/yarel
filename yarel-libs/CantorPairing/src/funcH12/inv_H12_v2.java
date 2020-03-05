package funcH12;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
import ArithNat.*; 
public class inv_H12_v2 implements RPP {
    public inv_H12_v2() { }
    RPP function = new inv_P3sub();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }          
}