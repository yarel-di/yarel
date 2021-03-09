package quotient;
import yarelcore.*;	

public class Quo implements RPP {
	public Quo() { }
	
	
	

	
	public InvQuo getInverse(){
		return new InvQuo();
	}
	
	private final RPP[] __steps__ = new RPP[]{ //
		new RPP() { // BodyPermImpl // index: 0
			private final int __a__ = 6;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 5]; 
				__x__[__startIndex__ + 5] = __x__[__startIndex__ + 4]; 
				__x__[__startIndex__ + 4] = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // ParCompImpl // index: 1
			private RPP __f__ = new RPP(){
				RPP __function__ = new arithNat.SumN();
				public int getA() { return __function__.getA(); }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
			public int getA() { return 6; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 0,
					__startIndex__ + (0) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 2
			private final int __a__ = 6;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __x__[__startIndex__ + 4]; 
				__x__[__startIndex__ + 4] = __x__[__startIndex__ + 5]; 
				__x__[__startIndex__ + 5] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // BodyItImpl // index: 3
			// Iteration start
			RPP __function__ = new RPP() { // SerCompImpl
				private final RPP[] __steps__ = new RPP[]{ //
					new RPP() { // ParCompImpl // index: 0
						private RPP __f__ = new RPP(){
							RPP __function__ = new QuoStep();
							public int getA() { return __function__.getA(); }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								this.__function__.b(__x__, __startIndex__, __endIndex__);
							}
						};
						public int getA() { return 5; }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0,
								__startIndex__ + (0) + this.__f__.getA()
								);
						}
					},
					
					new RPP() { // BodyPermImpl // index: 1
						private final int __a__ = 5;
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							int __tmp__=0;
							__tmp__ = __x__[__startIndex__ + 3]; 
							__x__[__startIndex__ + 3] = __x__[__startIndex__ + 4]; 
							__x__[__startIndex__ + 4] = __tmp__; 
						}
						public int getA() { return this.__a__; }
					},
					
					new RPP() { // BodyIfImpl // index: 2
						RPP __pos__=new RPP() {
							public int getA() { return 4; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								// There were only parallels identities, nothing interesting to show and run
							}
						};
						RPP __zero__=new RPP() {
							public int getA() { return 4; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								// There were only parallels identities, nothing interesting to show and run
							}
						};
						RPP __neg__=new RPP() {
							private RPP __f__ = new RPP(){
								private RPP __f__ = Inc.SINGLETON_Inc;
								private final int __a__ = __f__.getA();
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__, __startIndex__, __endIndex__);
								}
								public int getA() { return this.__a__; }
							};
							public int getA() { return 4; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								this.__f__.b(__x__,
									__startIndex__ + 3,
									__startIndex__ + (3) + this.__f__.getA()
									);
							}
						};
						public int getA() { return this.__pos__.getA()+1; }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							final int __testValue__ = __x__[(__startIndex__ + this.getA()) - 1];
							if(__testValue__ > 0){
								__pos__.b(__x__, __startIndex__, __startIndex__ + __pos__.getA());
							} else if(__testValue__ == 0){
								__zero__.b(__x__, __startIndex__, __startIndex__ + __zero__.getA());
							} else { // The "__testValue__<0" test is a tautology
								__neg__.b(__x__, __startIndex__, __startIndex__ + __neg__.getA());
							}
						}
					},
					
					new RPP() { // BodyPermImpl // index: 3
						private final int __a__ = 5;
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							int __tmp__=0;
							__tmp__ = __x__[__startIndex__ + 3]; 
							__x__[__startIndex__ + 3] = __x__[__startIndex__ + 4]; 
							__x__[__startIndex__ + 4] = __tmp__; 
						}
						public int getA() { return this.__a__; }
					},
					
					new RPP() { // BodyIfImpl // index: 4
						RPP __pos__=new RPP() {
							private final RPP[] __steps__ = new RPP[]{ //
								new RPP() { // BodyPermImpl // index: 0
									private final int __a__ = 4;
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										int __tmp__=0;
										__tmp__ = __x__[__startIndex__ + 1]; 
										__x__[__startIndex__ + 1] = __x__[__startIndex__ + 3]; 
										__x__[__startIndex__ + 3] = __x__[__startIndex__ + 2]; 
										__x__[__startIndex__ + 2] = __tmp__; 
									}
									public int getA() { return this.__a__; }
								},
								
								new RPP() { // ParCompImpl // index: 1
									private RPP __f__ = new RPP(){
										RPP __function__ = new arithNat.SumN();
										public int getA() { return __function__.getA(); }
										public void b(int[] __x__, int __startIndex__, int __endIndex__) {
											this.__function__.b(__x__, __startIndex__, __endIndex__);
										}
									};
									public int getA() { return 4; }
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__,
											__startIndex__ + 1,
											__startIndex__ + (1) + this.__f__.getA()
											);
									}
								},
								
								new RPP() { // BodyPermImpl // index: 2
									private final int __a__ = 4;
									public void b(int[] __x__, int __startIndex__, int __endIndex__) {
										int __tmp__=0;
										__tmp__ = __x__[__startIndex__ + 1]; 
										__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
										__x__[__startIndex__ + 2] = __x__[__startIndex__ + 3]; 
										__x__[__startIndex__ + 3] = __tmp__; 
									}
									public int getA() { return this.__a__; }
								}
							};
							public int getA() { return this.__steps__[0].getA(); }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
								int __i__;
								__i__ = -1;
								while( ++__i__ < __steps__.length ){
									__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
								}
							}
						};
						RPP __zero__=new RPP() {
							public int getA() { return 4; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								// There were only parallels identities, nothing interesting to show and run
							}
						};
						RPP __neg__=new RPP() {
							public int getA() { return 4; }
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								// There were only parallels identities, nothing interesting to show and run
							}
						};
						public int getA() { return this.__pos__.getA()+1; }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							final int __testValue__ = __x__[(__startIndex__ + this.getA()) - 1];
							if(__testValue__ > 0){
								__pos__.b(__x__, __startIndex__, __startIndex__ + __pos__.getA());
							} else if(__testValue__ == 0){
								__zero__.b(__x__, __startIndex__, __startIndex__ + __zero__.getA());
							} else { // The "__testValue__<0" test is a tautology
								__neg__.b(__x__, __startIndex__, __startIndex__ + __neg__.getA());
							}
						}
					}
				};
				public int getA() { return this.__steps__[0].getA(); }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
					int __i__;
					__i__ = -1;
					while( ++__i__ < __steps__.length ){
						__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
					}
				}
			};
			public int getA() { return __function__.getA()+1; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __endIndexBody__ = (__startIndex__ + this.getA()) - 1;
				int __iterationsLeft__ = Math.abs(__x__[__endIndexBody__]);
				while(__iterationsLeft__-->0){
					__function__.b(__x__, __startIndex__, __endIndexBody__);
				}
			}
			// Iteration stop
		},
		
		new RPP() { // ParCompImpl // index: 4
			private RPP __f__ = new RPP(){
				RPP __function__ = new arithNat.SubN();
				public int getA() { return __function__.getA(); }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
			public int getA() { return 6; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 4,
					__startIndex__ + (4) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 5
			private final int __a__ = 6;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 4]; 
				__x__[__startIndex__ + 4] = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // ParCompImpl // index: 6
			private RPP __f__ = new RPP(){
				RPP __function__ = new arithNat.SumN();
				public int getA() { return __function__.getA(); }
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
			public int getA() { return 6; }
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 2,
					__startIndex__ + (2) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 7
			private final int __a__ = 6;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 5]; 
				__x__[__startIndex__ + 5] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		}
	};
	public int getA() { return this.__steps__[0].getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
		int __i__;
		__i__ = -1;
		while( ++__i__ < __steps__.length ){
			__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
		}
	}
}