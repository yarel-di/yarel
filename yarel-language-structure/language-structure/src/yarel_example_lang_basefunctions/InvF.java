package yarel_example_lang_basefunctions;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class InvF implements RPP {
    public InvF() { }
    RPP function = new InvG();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }
}