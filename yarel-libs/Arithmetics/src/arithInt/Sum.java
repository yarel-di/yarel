package arithInt;
import java.util.Arrays;
import java.lang.Math;
import yarelcore.*;	
public class Sum implements RPP {
    public Sum() { }
    RPP l = new RPP() {
    	RPP l = new RPP() {
    		RPP l = new RPP() {
    			RPP l = new RPP() {
    				RPP l = new RPP() {
    					RPP l = new RPP() {
    						RPP l = new RPP() {
    							private final int a = 5;
    							public int[] b(int[] x) {
    								int tmp=0;
    								tmp = x[1]; 
    								x[1] = x[2]; 
    								x[2] = tmp; 
    								return x;
    							}
    							public int getA() { return this.a; }
    						};
    						RPP r = new RPP() {
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
    								RPP function = new util.Dup();
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
    						private final int a = l.getA();
    						public int[] b(int[] x) { // Implements a serial composition.
    							return this.r.b(this.l.b(x));
    						}
    						public int getA() { return this.a; }
    					};
    					RPP r = new RPP() {
    						private final int a = 5;
    						public int[] b(int[] x) {
    							int tmp=0;
    							tmp = x[2]; 
    							x[2] = x[4]; 
    							x[4] = x[3]; 
    							x[3] = tmp; 
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
    							RPP function = new util.Dup();
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
    				private final int a = l.getA();
    				public int[] b(int[] x) { // Implements a serial composition.
    					return this.r.b(this.l.b(x));
    				}
    				public int getA() { return this.a; }
    			};
    			RPP r = new RPP() {
    				private final int a = 5;
    				public int[] b(int[] x) {
    					int tmp=0;
    					tmp = x[1]; 
    					x[1] = x[3]; 
    					x[3] = x[4]; 
    					x[4] = x[2]; 
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
    				RPP pos=new RPP() {
    					RPP pos=new RPP() {
    						RPP function = new arithNat.SumN();
    						private final int a = function.getA();
    						public int[] b(int[] x) { 
    							  	return this.function.b(x);
    						}
    						 public int getA() { return this.a; }
    					};
    					RPP zero=new RPP() {
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
    					RPP neg=new RPP() {
    						RPP l = new RPP() {
    							RPP l = new RPP() {
    								RPP l = new RPP() {
    									private RPP f = new Neg();
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
    								RPP function = new arithNat.SubN();
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
    						};
    						RPP r = new RPP() {
    							RPP l = new RPP() {
    								private RPP f = new Neg();
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
    									private RPP f = new Neg();
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
    								RPP function = new arithNat.SubN();
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
    						};
    						RPP r = new RPP() {
    							RPP l = new RPP() {
    								private RPP f = new Id();
    								private final int a = f.getA();
    								public int[] b(int[] x) {
    									return this.f.b(x);
    								}
    								public int getA() { return this.a; }
    							};
    							RPP r = new RPP() {
    								private RPP f = new Neg();
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
    					RPP zero=new RPP() {
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
    					RPP neg=new RPP() {
    						RPP l = new RPP() {
    							RPP l = new RPP() {
    								RPP l = new RPP() {
    									private RPP f = new Neg();
    									private final int a = f.getA();
    									public int[] b(int[] x) {
    										return this.f.b(x);
    									}
    									public int getA() { return this.a; }
    								};
    								RPP r = new RPP() {
    									private RPP f = new Neg();
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
    								RPP function = new arithNat.SumN();
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
    						};
    						RPP r = new RPP() {
    							RPP l = new RPP() {
    								private RPP f = new Neg();
    								private final int a = f.getA();
    								public int[] b(int[] x) {
    									return this.f.b(x);
    								}
    								public int getA() { return this.a; }
    							};
    							RPP r = new RPP() {
    								private RPP f = new Neg();
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
    		private final int a = 5;
    		public int[] b(int[] x) {
    			int tmp=0;
    			tmp = x[1]; 
    			x[1] = x[2]; 
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
    		RPP function = new util.InvDup();
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
    private final int a = l.getA();
    public int[] b(int[] x) { // Implements a serial composition.
    	return this.r.b(this.l.b(x));
    }
    public int getA() { return this.a; }
}