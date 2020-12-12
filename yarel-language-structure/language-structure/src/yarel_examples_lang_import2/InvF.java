package yarel_examples_lang_import2;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class InvF implements RPP {
    public InvF() { }
    RPP function = new yarel_examples_lang_import1.InvToImport();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }
}