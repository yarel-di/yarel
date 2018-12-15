package Multiplication;
import java.util.Arrays;
import Yarelcore.*;
public class permutation implements RPP {
    public permutation() { }
    private final int a = 3;
    public int[] b(int[] x) {
    	int[] r = new int[3];
    	r[0] = x[2];
    	r[1] = x[0];
    	r[2] = x[1];
    	return r;
    }
    public int getA() { return this.a; }
}