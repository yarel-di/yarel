package compound;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class SeqComposition implements RPP {
    public SeqComposition() { }
    RPP l = new RPP() {
    	RPP function = new Increment();
    	private final int a = function.getA();
    	public int[] b(int[] x) { 
    		  	return this.function.b(x);
    	}
    	 public int getA() { return this.a; }
    };
    RPP r = new RPP() {
    	RPP function = new Decrement();
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