package permuatation;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class PExample implements RPP {
    public PExample() { }
    private final int a = 4;
    public int[] b(int[] x) {
    	int tmp=0;
    	tmp = x[0]; 
    	x[0] = x[2]; 
    	x[2] = tmp; 
    	tmp = x[1]; 
    	x[1] = x[3]; 
    	x[3] = tmp; 
    	return x;
    }
    public int getA() { return this.a; }
}