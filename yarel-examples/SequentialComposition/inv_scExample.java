package SequentialComposition;
import java.util.Arrays;
import Yarelcore.*;
public class inv_scExample implements RPP {
    public inv_scExample() { }
    RPP l = new RPP() {
    	private RPP f = new inv_inc();
    	private final int a = f.getA();
    	public int[] b(int[] x) {
    		return this.f.b(x);
    	}
    	public int getA() { return this.a; }
    };
    RPP r = new RPP() {
    	private RPP f = new inv_dec();
    	private final int a = f.getA();
    	public int[] b(int[] x) {
    		return this.f.b(x);
    	}
    	public int getA() { return this.a; }
    };
    private final int a = l.getA();
    public int[] b(int[] x) { // Implements a serial composition.
    	return this.l.b(this.r.b(x));
    }
    public int getA() { return this.a; }
}