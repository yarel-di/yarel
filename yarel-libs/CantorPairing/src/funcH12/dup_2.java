package funcH12;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
import ArithNat.*; 
public class dup_2 implements RPP {
    public dup_2() { }
    RPP l = new RPP() {
    	RPP l = new RPP() {
    		private final int a = 2;
    		public int[] b(int[] x) {
    			int tmp=0;
    			tmp = x[0]; 
    			x[0] = x[1]; 
    			x[1] = tmp; 
    			return x;
    		}
    		public int getA() { return this.a; }
    	};
    	RPP r = new RPP() {
    		// Iteration start
    		RPP function = new RPP() {
    			private RPP f = new inc();
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
    	};
    	private final int a = l.getA();
    	public int[] b(int[] x) { // Implements a serial composition.
    		return this.r.b(this.l.b(x));
    	}
    	public int getA() { return this.a; }
    };
    RPP r = new RPP() {
    	RPP pos=new RPP() {
    		private RPP f = new id();
    		private final int a = f.getA();
    		public int[] b(int[] x) {
    			return this.f.b(x);
    		}
    		public int getA() { return this.a; }
    	};
    	RPP zero=new RPP() {
    		private RPP f = new id();
    		private final int a = f.getA();
    		public int[] b(int[] x) {
    			return this.f.b(x);
    		}
    		public int getA() { return this.a; }
    	};
    	RPP neg=new RPP() {
    		private RPP f = new neg();
    		private final int a = f.getA();
    		public int[] b(int[] x) {
    			return this.f.b(x);
    		}
    		public int getA() { return this.a; }
    	};
    	private final int a=pos.getA()+1;
    	public int getA() {return this.a;}
    	public int[] b(int[] x) {
    		int[] t=Arrays.copyOfRange(x,0,pos.getA());	  		
    		if(x[x.length-1]>0){
    			t=pos.b(t);
    		}
    		if(x[x.length-1]==0){
    			t=zero.b(t);
    		}
    		if(x[x.length-1]<0){
    			t=neg.b(t);
    		}
    		int[] r = new int[x.length];
    		for (int i = 0; i < t.length; i++){
    			r[i]=t[i];
    		}
    		r[r.length-1]=x[x.length-1];
    		return r;
    	}
    };
    private final int a = l.getA();
    public int[] b(int[] x) { // Implements a serial composition.
    	return this.r.b(this.l.b(x));
    }
    public int getA() { return this.a; }
}