package modules;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class InvPermutation implements RPP {
    public InvPermutation() { }
    RPP l = new RPP() {
    	RPP function = new compound.InvParComposition();
    	private final int a = function.getA();
    	public int[] b(int[] x) { 
    		  	return this.function.b(x);
    	}
    	 public int getA() { return this.a; }
    };
    RPP r = new RPP() {
    	private final int a = 4;
    	public int[] b(int[] x) {
    		int tmp=0;
    		tmp = x[1]; 
    		x[1] = x[2]; 
    		x[2] = tmp; 
    		return x;
    	}
    	public int getA() { return this.a; }
    };
    private final int a = l.getA();
    public int[] b(int[] x) { // Implements a serial composition.
    	return this.l.b(this.r.b(x));
    }
    public int getA() { return this.a; }
}