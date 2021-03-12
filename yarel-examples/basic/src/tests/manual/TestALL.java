package tests.manual;

import java.util.function.Consumer;

public class TestALL {

	public static void main(String[] args) {
		MainInvocation[] mains = { //
//				TestParallel::main, //
//				TestPermutationIndexed::main, //
				TestIntegerCompareManual::main, //
				TestFibonacci::main, //
				TestParametricStuffs::main, //
		};
		for (MainInvocation m : mains) {
			System.out.println("\n\n\n\n\n ANOTHER TEST\n\n\n\n\n");
			m.accept(args);
		}
	}

	static interface MainInvocation extends Consumer<String[]> {

	}
}
