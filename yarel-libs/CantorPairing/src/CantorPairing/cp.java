package CantorPairing;
import java.util.Arrays;
import java.lang.Math;
import Yarelcore.*;
import ArithNat.*; 
import funcH12.*; 
import BoundedMin.*; 
public class cp implements RPP {
    public cp() { }
    RPP l = new RPP() {
    	RPP l = new RPP() {
    		private final int a = 3;
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
    		RPP l = new RPP() {
    			RPP function = new sumN();
    			private final int a = function.getA();
    			public int[] b(int[] x) { 
    				  	return this.function.b(x);
    			}
    			 public int getA() { return this.a; }          
    		};
    		RPP r = new RPP() {
    			private RPP f = new id();
    			private final int a = f.getA();
    			public int[] b(int[] x) {
    				return this.f.b(x);
    			}
    			public int getA() { return this.a; }
    		};
    		private final int a = l.getA() + r.getA();
    		public int[] b(int[] x) { // Implements a parallel composition
    			return append(l.b(Arrays.copyOfRange(x,0       ,l.getA()         ))
    			,r.b(Arrays.copyOfRange(x,l.getA(),l.getA()+r.getA())));
    		}
    		public int getA() { return this.a; }
    		private int[] append(int[] l, int[] r) {
    			int[] res = new int[l.length + r.length];
    			for(int i = 0; i < l.length; i++)
    				res[i] = l[i];
    			for(int i = 0; i < r.length; i++) 
    			  	res[i + l.length] = r[i];
    		 	return res;
    		}
    	};
    	private final int a = l.getA();
    	public int[] b(int[] x) { // Implements a serial composition.
    		return this.r.b(this.l.b(x));
    	}
    	public int getA() { return this.a; }
    };
    RPP r = new RPP() {
    	RPP function = new P3();
    	private final int a = function.getA();
    	public int[] b(int[] x) { 
    		  	return this.function.b(x);
    	}
    	 public int getA() { return this.a; }          
    };
    private final int a = l.getA();
    public int[] b(int[] x) { // Implements a serial composition.
    	return this.r.b(this.l.b(x));
    }
    public int getA() { return this.a; }
}