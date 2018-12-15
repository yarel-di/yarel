package Multiplication;
import java.util.Arrays;
import Yarelcore.*;
public class inv_permutation implements RPP {
    public inv_permutation() { }
    private final int a = 3;
    public int[] b(int[] x) {
    	int[] r = new int[3];
    	r[2] = x[0];
    	r[0] = x[1];
    	r[1] = x[2];
    	return r;
    }
    public int getA() { return this.a; }
}