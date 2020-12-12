package yarel_examples_lang_multiplication;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class InvIdentity implements RPP {
    public InvIdentity() { }
    RPP l = new RPP() {
    	RPP function = new InvMultiplication();
    	private final int a = function.getA();
    	public int[] b(int[] x) { 
    		  	return this.function.b(x);
    	}
    	 public int getA() { return this.a; }
    };
    RPP r = new RPP() {
    	RPP function = new Multiplication();
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