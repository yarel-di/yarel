package yarelLib;
import yarelcore.*;	

public class AddFrom implements RPP {
	public AddFrom(//arities:
		int M
		,
		int I,
		int J
		){
		this.__fixedRegistersAmount__ = 3;
		if(M < 0){ throw new WrongArityException("The arity \"M\" cannot be negative: " + M); }
		this.M = M;
		// if(I < 0){ throw new WrongArityException("The parameter \"I\" cannot be negative: " + I); }
		this.I = I;
		// if(J < 0){ throw new WrongArityException("The parameter \"J\" cannot be negative: " + J); }
		this.J = J;
	}
	protected AddFrom(){
		this(1,0, 0);
	}
	
	protected final int __fixedRegistersAmount__;
	protected final int M;
	protected final int I;
	protected final int J;
	
	
	public int getFixedRegistersAmount(){
		return this.__fixedRegistersAmount__;
	}
	public int getM(){ return this.M; }
	public int getI(){ return this.I; }
	
	public int getJ(){ return this.J; }
	
	protected RPP __theWholeBody__ = null;

	
	public InvAddFrom getInverse(){
		return new InvAddFrom(this.M,I, J);
	}
	
	public int getA() {
		this.checkTheWholeBody();
		//return this.__theWholeBody__.getA();
		return this.__fixedRegistersAmount__ + this.M;
	}
	public void b(int[] __x__, int __startIndex__, int __endIndex__) {
		this.checkTheWholeBody();
		this.__theWholeBody__.b(__x__, __startIndex__, __endIndex__);
	}
	protected void checkTheWholeBody(){
		if(this.__theWholeBody__ == null){
			this.__theWholeBody__ = new RPP(){
				private final RPP[] __steps__ = new RPP[]{
					new RPP() { // BodyFunImpl
						RPP __function__ = new SwapSRLlike(
							2 + (1*M)
							,
							0 + (1*I),
							2 + (1*M)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // ParCompImpl
						private RPP __f__ = new RPP(){
							/** regular function used when v > 0 */
							RPP __function__ = new RPP() { // BodyIncImpl
								private RPP __f__ = Inc.SINGLETON_Inc;
								private final int __a__ = __f__.getA();
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__, __startIndex__, __endIndex__);
								}
								public int getA() { return this.__a__; }
							};
							
							/** inverse function used when v < 0 */
							RPP __inv_function__ = new RPP() { // InvBodyIncImpl
								private RPP __f__ = InvInc.SINGLETON_InvInc;
								private final int __a__ = __f__.getA();
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__, __startIndex__, __endIndex__);
								}
								public int getA() { return this.__a__; }
							};
							
							public int getA() { return __function__.getA()+1; } 
							public void b(int[] __x__, int __startIndex__, int __endIndex__) { //b stands for behaviour and x are the delta and v function parameters
								final int __repCounterIndex__ = (__startIndex__ + this.getA()) - 1, __originalRepCounter__;
								int __repetitionCounter__ = __x__[__repCounterIndex__];
								__originalRepCounter__ = __repetitionCounter__;
							
								if(__repetitionCounter__ > 0){ //if v is greater than zero, recursion goes on and v decreases each time
									__endIndex__ = __startIndex__ + __function__.getA();
									while(__repetitionCounter__-->0){
										__function__.b(__x__, __startIndex__, __repCounterIndex__);
										__x__[__repCounterIndex__]--;
									}
								}else if(__repetitionCounter__ < 0){ //if v is greater than zero, recursion goes on and v decreases each time
									__endIndex__ = __startIndex__ + __inv_function__.getA();
									while(__repetitionCounter__++<0){
										__inv_function__.b(__x__, __startIndex__, __repCounterIndex__);
										__x__[__repCounterIndex__]++;
									}
								} //else: when v is equal to zero, recursive calls stop as a value is returned
								__x__[__repCounterIndex__] = __originalRepCounter__; // restore the original value
							}
						};
						public int getA() { return 3 + (1*M); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0 + (1*M),
								__startIndex__ + (0 + (1*M)) + (2)
								);
						}
					},
					
					new RPP() { // BodyFunImpl
						RPP __function__ = new SwapSRLlike(
							2 + (1*M)
							,
							0 + (1*I),
							2 + (1*M)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodyFunImpl
						RPP __function__ = new SwapSRLlike(
							2 + (1*M)
							,
							0 + (1*J),
							2 + (1*M)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // ParCompImpl
						private RPP __f__ = new RPP(){
							/** regular function used when v > 0 */
							RPP __function__ = new RPP() { // BodyIncImpl
								private RPP __f__ = Inc.SINGLETON_Inc;
								private final int __a__ = __f__.getA();
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__, __startIndex__, __endIndex__);
								}
								public int getA() { return this.__a__; }
							};
							
							/** inverse function used when v < 0 */
							RPP __inv_function__ = new RPP() { // InvBodyIncImpl
								private RPP __f__ = InvInc.SINGLETON_InvInc;
								private final int __a__ = __f__.getA();
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__, __startIndex__, __endIndex__);
								}
								public int getA() { return this.__a__; }
							};
							
							public int getA() { return __function__.getA()+1; } 
							public void b(int[] __x__, int __startIndex__, int __endIndex__) { //b stands for behaviour and x are the delta and v function parameters
								final int __repCounterIndex__ = (__startIndex__ + this.getA()) - 1, __originalRepCounter__;
								int __repetitionCounter__ = __x__[__repCounterIndex__];
								__originalRepCounter__ = __repetitionCounter__;
							
								if(__repetitionCounter__ > 0){ //if v is greater than zero, recursion goes on and v decreases each time
									__endIndex__ = __startIndex__ + __function__.getA();
									while(__repetitionCounter__-->0){
										__function__.b(__x__, __startIndex__, __repCounterIndex__);
										__x__[__repCounterIndex__]--;
									}
								}else if(__repetitionCounter__ < 0){ //if v is greater than zero, recursion goes on and v decreases each time
									__endIndex__ = __startIndex__ + __inv_function__.getA();
									while(__repetitionCounter__++<0){
										__inv_function__.b(__x__, __startIndex__, __repCounterIndex__);
										__x__[__repCounterIndex__]++;
									}
								} //else: when v is equal to zero, recursive calls stop as a value is returned
								__x__[__repCounterIndex__] = __originalRepCounter__; // restore the original value
							}
						};
						public int getA() { return 3 + (1*M); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0 + (1*M),
								__startIndex__ + (0 + (1*M)) + (2)
								);
						}
					},
					
					new RPP() { // ParCompImpl
						private RPP __f__ = new RPP(){
							private final int __a__ = 3;
							public void b(int[] __x__, int __startIndex__, int __endIndex__) {
								int __tmp__=0;
								__tmp__ = __x__[__startIndex__ + 0]; 
								__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
								__x__[__startIndex__ + 1] = __tmp__; 
							}
							public int getA() { return this.__a__; }
						};
						public int getA() { return 3 + (1*M); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0 + (1*M),
								__startIndex__ + (0 + (1*M)) + (3)
								);
						}
					},
					
					new RPP() { // BodyFunImpl
						RPP __function__ = new SwapSRLlike(
							2 + (1*M)
							,
							0 + (1*J),
							1 + (1*M)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodyFunImpl
						RPP __function__ = new SwapSRLlike(
							2 + (1*M)
							,
							0 + (1*I),
							1 + (1*M)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // ParCompImpl
						private RPP __f__ = new RPP(){
							/** regular function used when v > 0 */
							RPP __function__ = new RPP() { // BodyDecImpl
								private RPP __f__ = Dec.SINGLETON_Dec;
								private final int __a__ = __f__.getA();
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__, __startIndex__, __endIndex__);
								}
								public int getA() { return this.__a__; }
							};
							
							/** inverse function used when v < 0 */
							RPP __inv_function__ = new RPP() { // InvBodyDecImpl
								private RPP __f__ = InvDec.SINGLETON_InvDec;
								private final int __a__ = __f__.getA();
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__, __startIndex__, __endIndex__);
								}
								public int getA() { return this.__a__; }
							};
							
							public int getA() { return __function__.getA()+1; } 
							public void b(int[] __x__, int __startIndex__, int __endIndex__) { //b stands for behaviour and x are the delta and v function parameters
								final int __repCounterIndex__ = (__startIndex__ + this.getA()) - 1, __originalRepCounter__;
								int __repetitionCounter__ = __x__[__repCounterIndex__];
								__originalRepCounter__ = __repetitionCounter__;
							
								if(__repetitionCounter__ > 0){ //if v is greater than zero, recursion goes on and v decreases each time
									__endIndex__ = __startIndex__ + __function__.getA();
									while(__repetitionCounter__-->0){
										__function__.b(__x__, __startIndex__, __repCounterIndex__);
										__x__[__repCounterIndex__]--;
									}
								}else if(__repetitionCounter__ < 0){ //if v is greater than zero, recursion goes on and v decreases each time
									__endIndex__ = __startIndex__ + __inv_function__.getA();
									while(__repetitionCounter__++<0){
										__inv_function__.b(__x__, __startIndex__, __repCounterIndex__);
										__x__[__repCounterIndex__]++;
									}
								} //else: when v is equal to zero, recursive calls stop as a value is returned
								__x__[__repCounterIndex__] = __originalRepCounter__; // restore the original value
							}
						};
						public int getA() { return 3 + (1*M); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0 + (1*M),
								__startIndex__ + (0 + (1*M)) + (2)
								);
						}
					},
					
					new RPP() { // BodyFunImpl
						RPP __function__ = new SwapSRLlike(
							2 + (1*M)
							,
							0 + (1*I),
							2 + (1*M)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // BodyFunImpl
						RPP __function__ = new SwapSRLlike(
							2 + (1*M)
							,
							0 + (1*J),
							2 + (1*M)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
						}
					},
					
					new RPP() { // ParCompImpl
						private RPP __f__ = new RPP(){
							/** regular function used when v > 0 */
							RPP __function__ = new RPP() { // BodyIncImpl
								private RPP __f__ = Inc.SINGLETON_Inc;
								private final int __a__ = __f__.getA();
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__, __startIndex__, __endIndex__);
								}
								public int getA() { return this.__a__; }
							};
							
							/** inverse function used when v < 0 */
							RPP __inv_function__ = new RPP() { // InvBodyIncImpl
								private RPP __f__ = InvInc.SINGLETON_InvInc;
								private final int __a__ = __f__.getA();
								public void b(int[] __x__, int __startIndex__, int __endIndex__) {
									this.__f__.b(__x__, __startIndex__, __endIndex__);
								}
								public int getA() { return this.__a__; }
							};
							
							public int getA() { return __function__.getA()+1; } 
							public void b(int[] __x__, int __startIndex__, int __endIndex__) { //b stands for behaviour and x are the delta and v function parameters
								final int __repCounterIndex__ = (__startIndex__ + this.getA()) - 1, __originalRepCounter__;
								int __repetitionCounter__ = __x__[__repCounterIndex__];
								__originalRepCounter__ = __repetitionCounter__;
							
								if(__repetitionCounter__ > 0){ //if v is greater than zero, recursion goes on and v decreases each time
									__endIndex__ = __startIndex__ + __function__.getA();
									while(__repetitionCounter__-->0){
										__function__.b(__x__, __startIndex__, __repCounterIndex__);
										__x__[__repCounterIndex__]--;
									}
								}else if(__repetitionCounter__ < 0){ //if v is greater than zero, recursion goes on and v decreases each time
									__endIndex__ = __startIndex__ + __inv_function__.getA();
									while(__repetitionCounter__++<0){
										__inv_function__.b(__x__, __startIndex__, __repCounterIndex__);
										__x__[__repCounterIndex__]++;
									}
								} //else: when v is equal to zero, recursive calls stop as a value is returned
								__x__[__repCounterIndex__] = __originalRepCounter__; // restore the original value
							}
						};
						public int getA() { return 3 + (1*M); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__f__.b(__x__,
								__startIndex__ + 0 + (1*M),
								__startIndex__ + (0 + (1*M)) + (2)
								);
						}
					},
					
					new RPP() { // BodyFunImpl
						RPP __function__ = new SwapSRLlike(
							2 + (1*M)
							,
							0 + (1*J),
							2 + (1*M)
						);
						public int getA() { return __function__.getA(); }
						public void b(int[] __x__, int __startIndex__, int __endIndex__) {
							this.__function__.b(__x__, __startIndex__, __endIndex__);
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
		}
	}
}