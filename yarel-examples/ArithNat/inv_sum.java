package ArithNat;
import java.util.Arrays;
import Yarelcore.*;
public class inv_sum implements RPP {
    public inv_sum() { }
    RPP function = new RPP() {
    	private RPP f = new inv_inc();
    	private final int a = f.getA();
    	public int[] b(int[] x) {
    		return this.f.b(x);
    	}
    	public int getA() { return this.a; }
    };
    private final int a = function.getA()+1;
    public int[] b(int[] x) {
    	int[] t=Arrays.copyOfRange(x,0,function.getA());
    	for(int i = 0 ; i < x[x.length - 1]; i++){
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
}