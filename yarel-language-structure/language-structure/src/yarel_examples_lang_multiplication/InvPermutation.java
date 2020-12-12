package yarel_examples_lang_multiplication;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class InvPermutation implements RPP {
    public InvPermutation() { }
    private final int a = 3;
    public int[] b(int[] x) {
    	int tmp=0;
    	tmp = x[0]; 
    	x[0] = x[1]; 
    	x[1] = x[2]; 
    	x[2] = tmp; 
    	return x;
    }
    public int getA() { return this.a; }
}