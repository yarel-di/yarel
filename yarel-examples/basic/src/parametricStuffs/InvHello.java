package parametricStuffs;
import yarelcore.*;	

public class InvHello implements RPP {
	public InvHello(int K){
		this.fixedRegistersAmount = 1;
		this.K = K;
	}
	protected InvHello(){
		this(1);
	}
	
	protected int fixedRegistersAmount;
	protected int K = 1;

	
	
	public Hello getInverse(){
		return new Hello(this.K);
	}
	
	/** regular function used when v > 0 */
	RPP function = new RPP() { // BodyPermIndexImpl
		public int getA() { return 1 + -1 + (1*K); }
		public void b(int[] x, int startIndex, int endIndex) {
			final int permutArity = -1 + (1*K);
			int tmp = x[startIndex], indexToWithdraw;
			indexToWithdraw = x[startIndex + permutArity];
			if(indexToWithdraw < 0){ indexToWithdraw = -indexToWithdraw; }
			indexToWithdraw--; // the index is 1-based
			indexToWithdraw = startIndex + (indexToWithdraw % permutArity);
			x[startIndex] = x[indexToWithdraw];
			x[indexToWithdraw] = tmp;
		}
		
	};
	
	/** inverse function used when v < 0 */
	RPP inv_function = new RPP() { // InvBodyPermIndexImpl
		public int getA() { return 1 + -1 + (1*K); }
		public void b(int[] x, int startIndex, int endIndex) {
			final int permutArity = -1 + (1*K);
			int tmp = x[startIndex], indexToWithdraw;
			indexToWithdraw = x[startIndex + permutArity];
			if(indexToWithdraw < 0){ indexToWithdraw = -indexToWithdraw; }
			indexToWithdraw--; // the index is 1-based
			indexToWithdraw = startIndex + (indexToWithdraw % permutArity);
			x[startIndex] = x[indexToWithdraw];
			x[indexToWithdraw] = tmp;
		}
		
	};
	
	public int getA() { return function.getA()+1; } 
	public void b(int[] x, int startIndex, int endIndex) { //b stands for behaviour and x are the delta and v function parameters
		final int repCounterIndex = (startIndex + this.getA()) - 1, originalRepCounter;
		int repetitionCounter = x[repCounterIndex];
		originalRepCounter = repetitionCounter;
	
		if(repetitionCounter > 0){ //if v is greater than zero, recursion goes on and v decreases each time
			endIndex = startIndex + function.getA();
			while(repetitionCounter-->0){
				function.b(x, startIndex, repCounterIndex);
				x[repCounterIndex]--;
			}
		}else if(repetitionCounter < 0){ //if v is greater than zero, recursion goes on and v decreases each time
			endIndex = startIndex + inv_function.getA();
			while(repetitionCounter++<0){
				inv_function.b(x, startIndex, repCounterIndex);
				x[repCounterIndex]++;
			}
		} //else: when v is equal to zero, recursive calls stop as a value is returned
		x[repCounterIndex] = originalRepCounter; // restore the original value
	}
}