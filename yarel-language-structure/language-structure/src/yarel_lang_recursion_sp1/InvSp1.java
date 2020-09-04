package yarel_lang_recursion_sp1;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class InvSp1 implements RPP {
    public InvSp1() { }
    RPP l = new RPP() {
    	RPP l = new RPP() {
    		RPP l = new RPP() {
    			RPP l = new RPP() {
    				RPP l = new RPP() {
    					private RPP f = new InvId();
    					private final int a = f.getA();
    					public int[] b(int[] x) {
    						return this.f.b(x);
    					}
    					public int getA() { return this.a; }
    				};
    				RPP r = new RPP() {
    					private RPP f = new InvId();
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
    			RPP r = new RPP() {
    				private RPP f = new InvId();
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
    		RPP r = new RPP() {
    			private RPP f = new InvId();
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
    	RPP r = new RPP() {
    		private RPP f = new InvId();
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
    RPP r = new RPP() {
    	private RPP f = new InvId();
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
}