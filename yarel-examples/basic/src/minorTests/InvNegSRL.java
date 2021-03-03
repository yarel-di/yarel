package minorTests;
import yarelcore.*;	

public class InvNegSRL implements RPP {
	public InvNegSRL() { }
	
	
	

	
	public NegSRL getInverse(){
		return new NegSRL();
	}
	
	private final RPP[] __steps__ = new RPP[]{
		new RPP() { // BodyForImpl
			/** regular function used when v > 0 */
			RPP __function__ = new RPP() { // BodyIncImpl
				private RPP __f__ = InvInc.SINGLETON_InvInc;
				private final int __a__ = __f__.getA();
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__, __startIndex__, __endIndex__);
				}
				public int getA() { return this.__a__; }
			};
			
			/** inverse function used when v < 0 */
			RPP __inv_function__ = new RPP() { // InvBodyIncImpl
				private RPP __f__ = Inc.SINGLETON_Inc;
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
		},
		
		new RPP() { // BodyPermImpl
			private final int __a__ = 2;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // BodyForImpl
			/** regular function used when v > 0 */
			RPP __function__ = new RPP() { // BodyDecImpl
				private RPP __f__ = InvDec.SINGLETON_InvDec;
				private final int __a__ = __f__.getA();
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__, __startIndex__, __endIndex__);
				}
				public int getA() { return this.__a__; }
			};
			
			/** inverse function used when v < 0 */
			RPP __inv_function__ = new RPP() { // InvBodyDecImpl
				private RPP __f__ = Dec.SINGLETON_Dec;
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
		},
		
		new RPP() { // BodyPermImpl
			private final int __a__ = 2;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		},
		
		new RPP() { // BodyForImpl
			/** regular function used when v > 0 */
			RPP __function__ = new RPP() { // BodyIncImpl
				private RPP __f__ = InvInc.SINGLETON_InvInc;
				private final int __a__ = __f__.getA();
				public void b(int[] __x__, int __startIndex__, int __endIndex__) {
					this.__f__.b(__x__, __startIndex__, __endIndex__);
				}
				public int getA() { return this.__a__; }
			};
			
			/** inverse function used when v < 0 */
			RPP __inv_function__ = new RPP() { // InvBodyIncImpl
				private RPP __f__ = Inc.SINGLETON_Inc;
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
		},
		
		new RPP() { // BodyPermImpl
			private final int __a__ = 2;
			public void b(int[] __x__, int __startIndex__, int __endIndex__) {
				int __tmp__=0;
				__tmp__ = __x__[__startIndex__ + 0]; 
				__x__[__startIndex__ + 0] = __x__[__startIndex__ + 1]; 
				__x__[__startIndex__ + 1] = __tmp__; 
			}
			public int getA() { return this.__a__; }
		}
	};
	public int getA() { return this.__steps__[0].getA(); }
	public void b(int[] __x__, int __startIndex__, int __endIndex__) { // Implements a serial composition.
		int __i__;
		__i__ = __steps__.length;
		while( __i__-->0 ){
			__steps__[__i__].b(__x__, __startIndex__, __endIndex__);
		}
	}
}