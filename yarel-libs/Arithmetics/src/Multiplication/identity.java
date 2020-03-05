package Multiplication;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
public class identity implements RPP {
    public identity() { }
    RPP l = new RPP() {
    	RPP function = new multiplication();
    	private final int a = function.getA();
    	public int[] b(int[] x) { 
    		  	return this.function.b(x);
    	}
    	 public int getA() { return this.a; }          
    };
    RPP r = new RPP() {
    	RPP function = new inv_multiplication();
    	private final int a = function.getA();
    	public int[] b(int[] x) { 
    		  	return this.function.b(x);
    	}
    	 public int getA() { return this.a; }          
    };
    private final int a = l.getA();
    public int[] b(int[] x) { // Implements a serial composition.
    	return this.r.b(this.l.b(x));
    }
    public int getA() { return this.a; }
}