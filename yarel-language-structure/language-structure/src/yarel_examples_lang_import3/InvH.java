package yarel_examples_lang_import3;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class InvH implements RPP {
    public InvH() { }
    RPP function = new yarel_examples_lang_import2.InvAmbiguousName();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }
}