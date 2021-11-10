package parallelTest;
import java.math.BigInteger;
import yarelcore.*;	

public class Mult implements RPP {
	public Mult() { }
	
	
	public InvMult getInverse(){
		return new InvMult();
	}
	
	private final RPP[] __steps__ = new RPP[]{ //
		new RPP() { // BodyPermImpl // index: 0
			private final int __a__ = 3;
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // BodyForImpl // index: 1
			/** regular function used when v > 0 */
			RPP __function__ = new RPP() { // BodyForImpl
				/** regular function used when v > 0 */
				RPP __function__ = new RPP() { // BodyIncImpl
					private RPP __f__ = Inc.SINGLETON_Inc;
					private final int __a__ = __f__.getA();
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return this.__a__; }
				};
				
				/** inverse function used when v < 0 */
				RPP __inv_function__ = new RPP() { // InvBodyIncImpl
					private RPP __f__ = InvInc.SINGLETON_InvInc;
					private final int __a__ = __f__.getA();
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return this.__a__; }
				};
				
				public int getA() { return __function__.getA()+1; } 
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) { //b stands for behaviour and x are the delta and v function parameters
					final int __repCounterIndex__ = (__startIndex__ + this.getA()) - 1;
					BigInteger __repetitionCounter__ = __x__[__repCounterIndex__], __originalRepCounter__;
					__originalRepCounter__ = __repetitionCounter__;
					int __testPositivity__ = __repetitionCounter__.compareTo(BigInteger.ZERO);
					if(__testPositivity__ > 0){ //if v is greater than zero, recursion goes on and v decreases each time
						__endIndex__ = __startIndex__ + __function__.getA();
						while(__repetitionCounter__.compareTo(BigInteger.ZERO) > 0){
							__function__.b(__x__, __startIndex__, __repCounterIndex__);
							__repetitionCounter__ = __repetitionCounter__.subtract(BigInteger.ONE);
						}
					}else if(__testPositivity__ < 0){ //if v is greater than zero, recursion goes on and v decreases each time
						__endIndex__ = __startIndex__ + __inv_function__.getA();
						while(__repetitionCounter__.compareTo(BigInteger.ZERO) < 0){
							__inv_function__.b(__x__, __startIndex__, __repCounterIndex__);
							__repetitionCounter__ = __repetitionCounter__.add(BigInteger.ONE);
						}
					} //else: when v is equal to zero, recursive calls stop as a value is returned
					//__x__[__repCounterIndex__] = __originalRepCounter__; // restore the original value
				}
			};
			
			/** inverse function used when v < 0 */
			RPP __inv_function__ = new RPP() { // InvBodyForImpl
				/** regular function used when v > 0 */
				RPP __function__ = new RPP() { // BodyIncImpl
					private RPP __f__ = InvInc.SINGLETON_InvInc;
					private final int __a__ = __f__.getA();
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return this.__a__; }
				};
				
				/** inverse function used when v < 0 */
				RPP __inv_function__ = new RPP() { // InvBodyIncImpl
					private RPP __f__ = Inc.SINGLETON_Inc;
					private final int __a__ = __f__.getA();
					public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
						this.__f__.b(__x__, __startIndex__, __endIndex__);
					}
					public int getA() { return this.__a__; }
				};
				
				public int getA() { return __function__.getA()+1; } 
				public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) { //b stands for behaviour and x are the delta and v function parameters
					final int __repCounterIndex__ = (__startIndex__ + this.getA()) - 1;
					BigInteger __repetitionCounter__ = __x__[__repCounterIndex__], __originalRepCounter__;
					__originalRepCounter__ = __repetitionCounter__;
					int __testPositivity__ = __repetitionCounter__.compareTo(BigInteger.ZERO);
					if(__testPositivity__ > 0){ //if v is greater than zero, recursion goes on and v decreases each time
						__endIndex__ = __startIndex__ + __function__.getA();
						while(__repetitionCounter__.compareTo(BigInteger.ZERO) > 0){
							__function__.b(__x__, __startIndex__, __repCounterIndex__);
							__repetitionCounter__ = __repetitionCounter__.subtract(BigInteger.ONE);
						}
					}else if(__testPositivity__ < 0){ //if v is greater than zero, recursion goes on and v decreases each time
						__endIndex__ = __startIndex__ + __inv_function__.getA();
						while(__repetitionCounter__.compareTo(BigInteger.ZERO) < 0){
							__inv_function__.b(__x__, __startIndex__, __repCounterIndex__);
							__repetitionCounter__ = __repetitionCounter__.add(BigInteger.ONE);
						}
					} //else: when v is equal to zero, recursive calls stop as a value is returned
					//__x__[__repCounterIndex__] = __originalRepCounter__; // restore the original value
				}
			};
			
			public int getA() { return __function__.getA()+1; } 
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) { //b stands for behaviour and x are the delta and v function parameters
				final int __repCounterIndex__ = (__startIndex__ + this.getA()) - 1;
				BigInteger __repetitionCounter__ = __x__[__repCounterIndex__], __originalRepCounter__;
				__originalRepCounter__ = __repetitionCounter__;
				int __testPositivity__ = __repetitionCounter__.compareTo(BigInteger.ZERO);
				if(__testPositivity__ > 0){ //if v is greater than zero, recursion goes on and v decreases each time
					__endIndex__ = __startIndex__ + __function__.getA();
					while(__repetitionCounter__.compareTo(BigInteger.ZERO) > 0){
						__function__.b(__x__, __startIndex__, __repCounterIndex__);
						__repetitionCounter__ = __repetitionCounter__.subtract(BigInteger.ONE);
					}
				}else if(__testPositivity__ < 0){ //if v is greater than zero, recursion goes on and v decreases each time
					__endIndex__ = __startIndex__ + __inv_function__.getA();
					while(__repetitionCounter__.compareTo(BigInteger.ZERO) < 0){
						__inv_function__.b(__x__, __startIndex__, __repCounterIndex__);
						__repetitionCounter__ = __repetitionCounter__.add(BigInteger.ONE);
					}
				} //else: when v is equal to zero, recursive calls stop as a value is returned
				//__x__[__repCounterIndex__] = __originalRepCounter__; // restore the original value
			}
		},
		
		new RPP() { // BodyPermImpl // index: 2
			private final int __a__ = 3;
			public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) {
				BigInteger __tmp__ = BigInteger.ZERO;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 2]; 
				__x__[__startIndex__ + 2] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		}
	};
	public int getA() { return this.__steps__[0].getA(); }
	public void b(BigInteger[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
		int __i__;
		__i__ = -1;
		while( ++__i__ < __steps__.length ){
			__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
		}
	}
}