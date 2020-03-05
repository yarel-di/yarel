package Multiplication;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
public class permutation implements RPP {
    public permutation() { }
    private final int a = 3;
    public int[] b(int[] x) {
    	int tmp=0;
    	tmp = x[0]; 
    	x[0] = x[2]; 
    	x[2] = x[1]; 
    	x[1] = tmp; 
    	return x;
    }
    public int getA() { return this.a; }
}