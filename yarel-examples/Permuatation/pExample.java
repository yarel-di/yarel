package Permuatation;
import java.util.Arrays;
import Yarelcore.*;
public class pExample implements RPP {
    public pExample() { }
    private final int a = 4;
    public int[] b(int[] x) {
    	int[] r = new int[4];
    	r[0] = x[2];
    	r[1] = x[3];
    	r[2] = x[0];
    	r[3] = x[1];
    	return r;
    }
    public int getA() { return this.a; }
}