package funcH12;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
import ArithNat.*; 
public class H12_v2 implements RPP {
    public H12_v2() { }
    RPP function = new P3sub();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }          
}