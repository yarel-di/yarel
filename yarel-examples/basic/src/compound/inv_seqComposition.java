package compound;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
public class inv_seqComposition implements RPP {
    public inv_seqComposition() { }
    RPP l = new RPP() {
    	RPP function = new inv_increment();
    	private final int a = function.getA();
    	public int[] b(int[] x) { 
    		  	return this.function.b(x);
    	}
    	 public int getA() { return this.a; }          
    };
    RPP r = new RPP() {
    	RPP function = new inv_decrement();
    	private final int a = function.getA();
    	public int[] b(int[] x) { 
    		  	return this.function.b(x);
    	}
    	 public int getA() { return this.a; }          
    };
    private final int a = l.getA();
    public int[] b(int[] x) { // Implements a serial composition.
    	return this.l.b(this.r.b(x));
    }
    public int getA() { return this.a; }
}