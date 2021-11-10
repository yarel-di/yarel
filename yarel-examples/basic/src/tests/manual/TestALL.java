package tests.manual;

import java.math.BigInteger;
import java.util.function.Consumer;

public class TestALL {

	public static interface MainInvocation extends Consumer<String[]> {
	}

	public static void main(String[] args) {
		MainInvocation[] mains = { //
//				TestParallel::main, //
//				TestPermutationIndexed::main, //
				TestIntegerCompareManual::main, //
				TestFibonacci::main, //
				// TestParametricStuffs::main, //
		};
		for (MainInvocation m : mains) {
			System.out.println("\n\n\n\n\n ANOTHER TEST\n\n\n\n\n");
			m.accept(args);
		}
	}

	public static BigInteger[] registersFrom(int[] vals) {
//		return IntStream.of(vals)//
//				.mapToObj(BigInteger::valueOf)//
//				.toArray(BigInteger[]::new);
		final int len;
		BigInteger[] reg = new BigInteger[len = vals.length];
		for (int i = 0; i < len; i++) {
			reg[i] = BigInteger.valueOf(vals[i]);
		}
		return reg;
	}
}
