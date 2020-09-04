package yarel_lang_cantor_boundedminimization;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class MinH12_original implements RPP {
    public MinH12_original() { }
    RPP l = new RPP() {
    	RPP l = new RPP() {
    		RPP l = new RPP() {
    			RPP l = new RPP() {
    				RPP l = new RPP() {
    					// Iteration start
    					RPP function = new RPP() {
    						RPP l = new RPP() {
    							RPP l = new RPP() {
    								RPP l = new RPP() {
    									RPP l = new RPP() {
    										RPP l = new RPP() {
    											RPP l = new RPP() {
    												RPP l = new RPP() {
    													RPP l = new RPP() {
    														RPP function = new yarel_lang_cantor_funcH12.H12();
    														private final int a = function.getA();
    														public int[] b(int[] x) { 
    															  	return this.function.b(x);
    														}
    														 public int getA() { return this.a; }
    													};
    													RPP r = new RPP() {
    														private RPP f = new Id();
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
    													private RPP f = new Id();
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
    												private RPP f = new Id();
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
    											private final int a = 6;
    											public int[] b(int[] x) {
    												int tmp=0;
    												tmp = x[1]; 
    												x[1] = x[2]; 
    												x[2] = x[3]; 
    												x[3] = x[4]; 
    												x[4] = x[5]; 
    												x[5] = tmp; 
    												return x;
    											}
    											public int getA() { return this.a; }
    										};
    										private final int a = l.getA();
    										public int[] b(int[] x) { // Implements a serial composition.
    											return this.r.b(this.l.b(x));
    										}
    										public int getA() { return this.a; }
    									};
    									RPP r = new RPP() {
    										RPP pos=new RPP() {
    											RPP l = new RPP() {
    												RPP l = new RPP() {
    													RPP l = new RPP() {
    														RPP l = new RPP() {
    															private RPP f = new Id();
    															private final int a = f.getA();
    															public int[] b(int[] x) {
    																return this.f.b(x);
    															}
    															public int getA() { return this.a; }
    														};
    														RPP r = new RPP() {
    															private RPP f = new Id();
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
    														private RPP f = new Id();
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
    													private RPP f = new Id();
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
    												private RPP f = new Id();
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
    										RPP zero=new RPP() {
    											RPP l = new RPP() {
    												RPP l = new RPP() {
    													RPP l = new RPP() {
    														RPP l = new RPP() {
    															private RPP f = new Id();
    															private final int a = f.getA();
    															public int[] b(int[] x) {
    																return this.f.b(x);
    															}
    															public int getA() { return this.a; }
    														};
    														RPP r = new RPP() {
    															private RPP f = new Id();
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
    														private RPP f = new Id();
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
    													private RPP f = new Id();
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
    												private RPP f = new Id();
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
    										RPP neg=new RPP() {
    											RPP l = new RPP() {
    												RPP pos=new RPP() {
    													RPP l = new RPP() {
    														RPP l = new RPP() {
    															RPP l = new RPP() {
    																private RPP f = new Id();
    																private final int a = f.getA();
    																public int[] b(int[] x) {
    																	return this.f.b(x);
    																}
    																public int getA() { return this.a; }
    															};
    															RPP r = new RPP() {
    																private RPP f = new Id();
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
    															private RPP f = new Id();
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
    														private RPP f = new Id();
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
    												RPP zero=new RPP() {
    													RPP l = new RPP() {
    														RPP l = new RPP() {
    															private RPP f = new Id();
    															private final int a = f.getA();
    															public int[] b(int[] x) {
    																return this.f.b(x);
    															}
    															public int getA() { return this.a; }
    														};
    														RPP r = new RPP() {
    															private RPP f = new Id();
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
    														RPP function = new yarel_lang_arithmetics_nat.SumN();
    														private final int a = function.getA();
    														public int[] b(int[] x) { 
    															  	return this.function.b(x);
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
    												RPP neg=new RPP() {
    													RPP l = new RPP() {
    														RPP l = new RPP() {
    															RPP l = new RPP() {
    																private RPP f = new Id();
    																private final int a = f.getA();
    																public int[] b(int[] x) {
    																	return this.f.b(x);
    																}
    																public int getA() { return this.a; }
    															};
    															RPP r = new RPP() {
    																private RPP f = new Id();
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
    															private RPP f = new Id();
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
    														private RPP f = new Id();
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
    											RPP r = new RPP() {
    												RPP l = new RPP() {
    													RPP l = new RPP() {
    														RPP l = new RPP() {
    															RPP l = new RPP() {
    																private RPP f = new Id();
    																private final int a = f.getA();
    																public int[] b(int[] x) {
    																	return this.f.b(x);
    																}
    																public int getA() { return this.a; }
    															};
    															RPP r = new RPP() {
    																private RPP f = new Id();
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
    															private RPP f = new Id();
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
    														private RPP f = new Id();
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
    													private RPP f = new Inc();
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
    								};
    								RPP r = new RPP() {
    									private final int a = 6;
    									public int[] b(int[] x) {
    										int tmp=0;
    										tmp = x[1]; 
    										x[1] = x[5]; 
    										x[5] = x[4]; 
    										x[4] = x[3]; 
    										x[3] = x[2]; 
    										x[2] = tmp; 
    										return x;
    									}
    									public int getA() { return this.a; }
    								};
    								private final int a = l.getA();
    								public int[] b(int[] x) { // Implements a serial composition.
    									return this.r.b(this.l.b(x));
    								}
    								public int getA() { return this.a; }
    							};
    							RPP r = new RPP() {
    								RPP l = new RPP() {
    									RPP l = new RPP() {
    										RPP l = new RPP() {
    											RPP function = new yarel_lang_cantor_funcH12.InvH12();
    											private final int a = function.getA();
    											public int[] b(int[] x) { 
    												  	return this.function.b(x);
    											}
    											 public int getA() { return this.a; }
    										};
    										RPP r = new RPP() {
    											private RPP f = new Id();
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
    										private RPP f = new Id();
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
    									private RPP f = new Id();
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
    							RPP l = new RPP() {
    								RPP l = new RPP() {
    									RPP l = new RPP() {
    										RPP l = new RPP() {
    											RPP l = new RPP() {
    												private RPP f = new Inc();
    												private final int a = f.getA();
    												public int[] b(int[] x) {
    													return this.f.b(x);
    												}
    												public int getA() { return this.a; }
    											};
    											RPP r = new RPP() {
    												private RPP f = new Id();
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
    											private RPP f = new Id();
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
    										private RPP f = new Id();
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
    									private RPP f = new Inc();
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
    								private RPP f = new Id();
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
    				RPP r = new RPP() {
    					private final int a = 7;
    					public int[] b(int[] x) {
    						int tmp=0;
    						tmp = x[4]; 
    						x[4] = x[6]; 
    						x[6] = x[5]; 
    						x[5] = tmp; 
    						return x;
    					}
    					public int getA() { return this.a; }
    				};
    				private final int a = l.getA();
    				public int[] b(int[] x) { // Implements a serial composition.
    					return this.r.b(this.l.b(x));
    				}
    				public int getA() { return this.a; }
    			};
    			RPP r = new RPP() {
    				RPP pos=new RPP() {
    					RPP l = new RPP() {
    						RPP l = new RPP() {
    							RPP l = new RPP() {
    								RPP l = new RPP() {
    									RPP l = new RPP() {
    										private RPP f = new Id();
    										private final int a = f.getA();
    										public int[] b(int[] x) {
    											return this.f.b(x);
    										}
    										public int getA() { return this.a; }
    									};
    									RPP r = new RPP() {
    										private RPP f = new Id();
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
    									private RPP f = new Id();
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
    								private RPP f = new Id();
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
    							private RPP f = new Id();
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
    						private RPP f = new Id();
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
    				RPP zero=new RPP() {
    					RPP l = new RPP() {
    						RPP l = new RPP() {
    							RPP l = new RPP() {
    								RPP l = new RPP() {
    									private RPP f = new Id();
    									private final int a = f.getA();
    									public int[] b(int[] x) {
    										return this.f.b(x);
    									}
    									public int getA() { return this.a; }
    								};
    								RPP r = new RPP() {
    									private RPP f = new Id();
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
    								private RPP f = new Id();
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
    							RPP function = new yarel_lang_arithmetics_nat.SumN();
    							private final int a = function.getA();
    							public int[] b(int[] x) { 
    								  	return this.function.b(x);
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
    						private RPP f = new Id();
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
    				RPP neg=new RPP() {
    					RPP l = new RPP() {
    						RPP l = new RPP() {
    							RPP l = new RPP() {
    								RPP l = new RPP() {
    									RPP l = new RPP() {
    										private RPP f = new Id();
    										private final int a = f.getA();
    										public int[] b(int[] x) {
    											return this.f.b(x);
    										}
    										public int getA() { return this.a; }
    									};
    									RPP r = new RPP() {
    										private RPP f = new Id();
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
    									private RPP f = new Id();
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
    								private RPP f = new Id();
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
    							private RPP f = new Id();
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
    						private RPP f = new Id();
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
    		};
    		RPP r = new RPP() {
    			private final int a = 7;
    			public int[] b(int[] x) {
    				int tmp=0;
    				tmp = x[4]; 
    				x[4] = x[5]; 
    				x[5] = x[6]; 
    				x[6] = tmp; 
    				return x;
    			}
    			public int getA() { return this.a; }
    		};
    		private final int a = l.getA();
    		public int[] b(int[] x) { // Implements a serial composition.
    			return this.r.b(this.l.b(x));
    		}
    		public int getA() { return this.a; }
    	};
    	RPP r = new RPP() {
    		// Iteration start
    		RPP function = new RPP() {
    			RPP l = new RPP() {
    				RPP l = new RPP() {
    					RPP l = new RPP() {
    						RPP l = new RPP() {
    							RPP l = new RPP() {
    								RPP l = new RPP() {
    									RPP l = new RPP() {
    										RPP l = new RPP() {
    											RPP function = new yarel_lang_cantor_funcH12.InvH12();
    											private final int a = function.getA();
    											public int[] b(int[] x) { 
    												  	return this.function.b(x);
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
    								private final int a = 6;
    								public int[] b(int[] x) {
    									int tmp=0;
    									tmp = x[1]; 
    									x[1] = x[5]; 
    									x[5] = x[4]; 
    									x[4] = x[3]; 
    									x[3] = x[2]; 
    									x[2] = tmp; 
    									return x;
    								}
    								public int getA() { return this.a; }
    							};
    							private final int a = l.getA();
    							public int[] b(int[] x) { // Implements a serial composition.
    								return this.l.b(this.r.b(x));
    							}
    							public int getA() { return this.a; }
    						};
    						RPP r = new RPP() {
    							RPP pos=new RPP() {
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
    							RPP zero=new RPP() {
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
    							RPP neg=new RPP() {
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
    									private RPP f = new InvInc();
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
    							return this.l.b(this.r.b(x));
    						}
    						public int getA() { return this.a; }
    					};
    					RPP r = new RPP() {
    						private final int a = 6;
    						public int[] b(int[] x) {
    							int tmp=0;
    							tmp = x[1]; 
    							x[1] = x[2]; 
    							x[2] = x[3]; 
    							x[3] = x[4]; 
    							x[4] = x[5]; 
    							x[5] = tmp; 
    							return x;
    						}
    						public int getA() { return this.a; }
    					};
    					private final int a = l.getA();
    					public int[] b(int[] x) { // Implements a serial composition.
    						return this.l.b(this.r.b(x));
    					}
    					public int getA() { return this.a; }
    				};
    				RPP r = new RPP() {
    					RPP l = new RPP() {
    						RPP l = new RPP() {
    							RPP l = new RPP() {
    								RPP function = new yarel_lang_cantor_funcH12.H12();
    								private final int a = function.getA();
    								public int[] b(int[] x) { 
    									  	return this.function.b(x);
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
    				private final int a = l.getA();
    				public int[] b(int[] x) { // Implements a serial composition.
    					return this.l.b(this.r.b(x));
    				}
    				public int getA() { return this.a; }
    			};
    			RPP r = new RPP() {
    				RPP l = new RPP() {
    					RPP l = new RPP() {
    						RPP l = new RPP() {
    							RPP l = new RPP() {
    								RPP l = new RPP() {
    									private RPP f = new InvInc();
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
    						private RPP f = new InvInc();
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
    			private final int a = l.getA();
    			public int[] b(int[] x) { // Implements a serial composition.
    				return this.l.b(this.r.b(x));
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
    	private final int a = 7;
    	public int[] b(int[] x) {
    		int tmp=0;
    		tmp = x[0]; 
    		x[0] = x[3]; 
    		x[3] = x[2]; 
    		x[2] = tmp; 
    		return x;
    	}
    	public int getA() { return this.a; }
    };
    private final int a = l.getA();
    public int[] b(int[] x) { // Implements a serial composition.
    	return this.r.b(this.l.b(x));
    }
    public int getA() { return this.a; }
}