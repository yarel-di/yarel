package base;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
import modules.G; 
public class F implements RPP {
    public F() { }
    RPP function = new G();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }          
}