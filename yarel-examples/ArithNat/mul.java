package ArithNat;
import java.util.Arrays;
import Yarelcore.*;
public class mul implements RPP {
    public mul() { }
    RPP l = new RPP() {
    	private final int a = 3;
    	public int[] b(int[] x) {
    		int[] r = new int[3];
    		r[0] = x[2];
    		r[1] = x[0];
    		r[2] = x[1];
    		return r;
    	}
    	public int getA() { return this.a; }
    };
    RPP r = new RPP() {
    	RPP function = new RPP() {
    		RPP function = new sum();
    		private final int a = function.getA();
    		public int[] b(int[] x) { 
    			  	return this.function.b(x);
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
    };
    private final int a = l.getA();
    public int[] b(int[] x) { // Implements a serial composition.
    	return this.r.b(this.l.b(x));
    }
    public int getA() { return this.a; }
}