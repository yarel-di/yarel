package yarel_lang_recursion_stack;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class Pop implements RPP {
    public Pop() { }
    RPP function = new yarel_lang_cantor_pairing.Cu();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }
}