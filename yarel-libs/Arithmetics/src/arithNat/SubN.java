package arithNat;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class SubN implements RPP {
    public SubN() { }
    RPP function = new InvSumN();
    private final int a = function.getA();
    public int[] b(int[] x) { 
    	  	return this.function.b(x);
    }
     public int getA() { return this.a; }
}