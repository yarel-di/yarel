package yarel_example_compound;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class Increment implements RPP {
    public Increment() { }
    // Iteration start
    RPP function = new RPP() {
    	private RPP f = new Inc();
    	private final int a = f.getA();
    	public int[] b(int[] x) {
    		return this.f.b(x);
    	}
    	public int getA() { return this.a; }
    };
    private final int a = function.getA()+1;
    public int[] b(int[] x) {
    	int[] t=Arrays.copyOfRange(x,0,function.getA());
    	for(int i = 0 ; i < Math.abs(x[x.length - 1]); i++){
    		t = function.b(t);
    	}
    	int[] r=new int[x.length];
    	for (int i=0; i<t.length; i++){
    		r[i]=t[i];
    	}
    	r[r.length-1]=x[x.length-1];
    	return r;
    }
    public int getA() { return this.a; } 
    // Iteration stop
}