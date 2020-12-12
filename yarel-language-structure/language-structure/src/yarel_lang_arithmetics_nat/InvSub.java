package yarel_lang_arithmetics_nat;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class InvSub implements RPP {
    public InvSub() { }
    RPP function = new SumN();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }
}