package yarel_examples_lang_multiplication;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class Multiplication implements RPP {
    public Multiplication() { }
    RPP l = new RPP() {
    	RPP l = new RPP() {
    		RPP function = new Permutation();
    		private final int a = function.getA();
    		public int[] b(int[] x) { 
    			  	return this.function.b(x);
    		}
    		 public int getA() { return this.a; }
    	};
    	RPP r = new RPP() {
    		// Iteration start
    		RPP function = new RPP() {
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
    	RPP function = new InvPermutation();
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