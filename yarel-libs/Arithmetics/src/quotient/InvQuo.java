package quotient;
import java.math.BigInteger;
import yarelcore.*;	

public class InvQuo implements RPP {
	public InvQuo() { }
	
	
	public Quo getInverse(){
		return new Quo();
	}
	
	private final RPP[] __steps__ = new RPP[]{ //
		new RPP() { // BodyPermImpl // index: 0
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __x__[__startIndex__ + 4]; 
				__x__[__startIndex__ + 4] = __x__[__startIndex__ + 5]; 
				__x__[__startIndex__ + 5] = __tmp__; 
			}
			public int getA() { return 6; }
		},
		
		new RPP() { // ParCompImpl // index: 1
			private RPP __f__ = new RPP(){
				RPP __function__ = new arithNat.InvSumN();
				public int getA() { return __function__.getA(); }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
			public int getA() { return 6; }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 0,
					__startIndex__ + (0) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 2
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 5]; 
				__x__[__startIndex__ + 5] = __x__[__startIndex__ + 4]; 
				__x__[__startIndex__ + 4] = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __tmp__; 
			}
			public int getA() { return 6; }
		},
		
		new RPP() { // BodyItImpl // index: 3
			// Iteration start
			RPP __function__ = new RPP() { // SerCompImpl
				private final RPP[] __steps__ = new RPP[]{ //
					new RPP() { // ParCompImpl // index: 0
						private RPP __f__ = new RPP(){
							RPP __function__ = new InvQuoStep();
							public int getA() { return __function__.getA(); }
							public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
								this.__function__.b(__x__, __startIndex__, __endIndex__);
							}
						};
						public int getA() { return 5; }
						public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0,
								__startIndex__ + (0) + this.__f__.getA()
								);
						}
					},
					
					new RPP() { // BodyPermImpl // index: 1
						public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
							BigInteger __tmp__ = BigInteger.ZERO;
							__tmp__ = __x__[__startIndex__ + 3]; 
							__x__[__startIndex__ + 3] = __x__[__startIndex__ + 4]; 
							__x__[__startIndex__ + 4] = __tmp__; 
						}
						public int getA() { return 5; }
					},
					
					new RPP() { // BodyIfImpl // index: 2
						RPP __pos__=new RPP() {
							public int getA() { return 4; }
							public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
								// There were only parallels identities, nothing interesting to show and run
							}
						};
						RPP __zero__=new RPP() {
							public int getA() { return 4; }
							public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
								// There were only parallels identities, nothing interesting to show and run
							}
						};
						RPP __neg__=new RPP() {
							private RPP __f__ = new RPP(){
								private RPP __f__ = InvInc.SINGLETON_InvInc;
								public int getA() { return this.__f__.getA(); }
								public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__, __startIndex__, __endIndex__);
								}
							};
							public int getA() { return 4; }
							public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
								this.__f__.b(__x__,
									__startIndex__ + 3,
									__startIndex__ + (3) + this.__f__.getA()
									);
							}
						};
						private int __a__ = this.__pos__.getA()+1;
						public int getA() { return this.__a__; }
						public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
							final int __testPositivity__ = __x__[(__startIndex__ + this.getA()) - 1].compareTo(BigInteger.ZERO);
							if(__testPositivity__ > 0){
								__pos__.b(__x__, __startIndex__, __startIndex__ + __pos__.getA());
							} else if(__testPositivity__ == 0){
								__zero__.b(__x__, __startIndex__, __startIndex__ + __zero__.getA());
							} else { // The "__testPositivity__ < 0" test is a tautology
								__neg__.b(__x__, __startIndex__, __startIndex__ + __neg__.getA());
							}
						}
					},
					
					new RPP() { // BodyPermImpl // index: 3
						public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
							BigInteger __tmp__ = BigInteger.ZERO;
							__tmp__ = __x__[__startIndex__ + 3]; 
							__x__[__startIndex__ + 3] = __x__[__startIndex__ + 4]; 
							__x__[__startIndex__ + 4] = __tmp__; 
						}
						public int getA() { return 5; }
					},
					
					new RPP() { // BodyIfImpl // index: 4
						RPP __pos__=new RPP() {
							private final RPP[] __steps__ = new RPP[]{ //
								new RPP() { // BodyPermImpl // index: 0
									public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
										BigInteger __tmp__ = BigInteger.ZERO;
										__tmp__ = __x__[__startIndex__ + 1]; 
										__x__[__startIndex__ + 1] = __x__[__startIndex__ + 2]; 
										__x__[__startIndex__ + 2] = __x__[__startIndex__ + 3]; 
										__x__[__startIndex__ + 3] = __tmp__; 
									}
									public int getA() { return 4; }
								},
								
								new RPP() { // ParCompImpl // index: 1
									private RPP __f__ = new RPP(){
										RPP __function__ = new arithNat.InvSumN();
										public int getA() { return __function__.getA(); }
										public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
											this.__function__.b(__x__, __startIndex__, __endIndex__);
										}
									};
									public int getA() { return 4; }
									public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
										this.__f__.b(__x__,
											__startIndex__ + 1,
											__startIndex__ + (1) + this.__f__.getA()
											);
									}
								},
								
								new RPP() { // BodyPermImpl // index: 2
									public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
										BigInteger __tmp__ = BigInteger.ZERO;
										__tmp__ = __x__[__startIndex__ + 1]; 
										__x__[__startIndex__ + 1] = __x__[__startIndex__ + 3]; 
										__x__[__startIndex__ + 3] = __x__[__startIndex__ + 2]; 
										__x__[__startIndex__ + 2] = __tmp__; 
									}
									public int getA() { return 4; }
								}
							};
							public int getA() { return this.__steps__[0].getA(); }
							public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
								int __i__;
								__i__ = __steps__.length;
								while( __i__-->0 ){
									__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
								}
							}
						};
						RPP __zero__=new RPP() {
							public int getA() { return 4; }
							public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
								// There were only parallels identities, nothing interesting to show and run
							}
						};
						RPP __neg__=new RPP() {
							public int getA() { return 4; }
							public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
								// There were only parallels identities, nothing interesting to show and run
							}
						};
						private int __a__ = this.__pos__.getA()+1;
						public int getA() { return this.__a__; }
						public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
							final int __testPositivity__ = __x__[(__startIndex__ + this.getA()) - 1].compareTo(BigInteger.ZERO);
							if(__testPositivity__ > 0){
								__pos__.b(__x__, __startIndex__, __startIndex__ + __pos__.getA());
							} else if(__testPositivity__ == 0){
								__zero__.b(__x__, __startIndex__, __startIndex__ + __zero__.getA());
							} else { // The "__testPositivity__ < 0" test is a tautology
								__neg__.b(__x__, __startIndex__, __startIndex__ + __neg__.getA());
							}
						}
					}
				};
				public int getA() { return this.__steps__[0].getA(); }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
					int __i__;
					__i__ = __steps__.length;
					while( __i__-->0 ){
						__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
					}
				}
			};
			private int __a__ = this.__function__.getA()+1;
			public int getA() { return this.__a__; }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				int __endIndexBody__ = (__startIndex__ + this.getA()) - 1;
				BigInteger __iterationsLeft__ = __x__[__endIndexBody__].abs();
				while(__iterationsLeft__.compareTo(BigInteger.ZERO) > 0){
					__function__.b(__x__, __startIndex__, __endIndexBody__);
					__iterationsLeft__ = __iterationsLeft__.subtract(BigInteger.ONE);
				}
			}
			// Iteration stop
		},
		
		new RPP() { // ParCompImpl // index: 4
			private RPP __f__ = new RPP(){
				RPP __function__ = new arithNat.InvSubN();
				public int getA() { return __function__.getA(); }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
			public int getA() { return 6; }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 4,
					__startIndex__ + (4) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 5
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __x__[__startIndex__ + 4]; 
				__x__[__startIndex__ + 4] = __tmp__; 
			}
			public int getA() { return 6; }
		},
		
		new RPP() { // ParCompImpl // index: 6
			private RPP __f__ = new RPP(){
				RPP __function__ = new arithNat.InvSumN();
				public int getA() { return __function__.getA(); }
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
					this.__function__.b(__x__, __startIndex__, __endIndex__);
				}
			};
			public int getA() { return 6; }
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				this.__f__.b(__x__,
					__startIndex__ + 2,
					__startIndex__ + (2) + this.__f__.getA()
					);
			}
		},
		
		new RPP() { // BodyPermImpl // index: 7
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 3]; 
				__x__[__startIndex__ + 3] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __x__[__startIndex__ + 5]; 
				__x__[__startIndex__ + 5] = __tmp__; 
			}
			public int getA() { return 6; }
		}
	};
	public int getA() { return this.__steps__[0].getA(); }
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
		int __i__;
		__i__ = __steps__.length;
		while( __i__-->0 ){
			__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
		}
	}
}