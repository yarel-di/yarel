package yarel_lang_arithmetics_int;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class Sub implements RPP {
    public Sub() { }
    RPP function = new InvSum();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }
}