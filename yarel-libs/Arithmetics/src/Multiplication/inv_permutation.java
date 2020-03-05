package Multiplication;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
public class inv_permutation implements RPP {
    public inv_permutation() { }
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