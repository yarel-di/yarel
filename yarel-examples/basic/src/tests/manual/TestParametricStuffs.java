package tests.manual;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import parametricStuffs.Hello;
import parametricStuffs.InvShiftLastToFirstK;
import parametricStuffs.ParamSum;
import parametricStuffs.ShiftFirstToLastK;
import parametricStuffs.ShiftLastToFirstK;
import parametricStuffs.SwapNonNative;

public class TestParametricStuffs {
	public static final Comparator<String> STRING_COMP = (s1, s2) -> s1.compareTo(s2);

	public static void main(String[] args) {
		System.out.println("START TEST PARAMETRIC");
		System.out.println("\n\n\n\n\n\n");

		final Map<String, Runnable> tests = new TreeMap<>(STRING_COMP);
		tests.put("testShiftK", TestParametricStuffs::testShiftK);
		tests.put("testParamSum", TestParametricStuffs::testParamSum);
		tests.put("testHello", TestParametricStuffs::testHello);
		tests.put("testSwapNonNative", TestParametricStuffs::testSwapNonNative);

		tests.forEach((name, t) -> {
			System.out.println("\n\n\n\n\n\n");
			System.out.println("doing another test : " + name);
			t.run();
		});

		System.out.println("\n\n\n\n\n\n");
		System.out.println("end TEST PARAMETRIC");
	}

	public static void testSwapNonNative() {
		int[] regs = { 1, 2, 3, 4, 5, 6, 78, 9 };
		SwapNonNative swapper = new SwapNonNative(regs.length - 1, 3, 7);
		System.out.println("swapper has arity" + swapper.getA());
		swapper.b(regs);
		System.out.println("now registers has : " + Arrays.toString(regs));
		swapper.getInverse().b(regs);
		System.out.println("registers after the inversion: " + Arrays.toString(regs));
	}

	public static void testHello() {
		int[] regs = { 1, 2, 3, 4, 5, 6, 78, 9 };
		Hello ps = new Hello(6);
		System.out.println("Hello has arity" + ps.getA());
		ps.b(regs);
		System.out.println("now registers has : " + Arrays.toString(regs));
		ps.getInverse().b(regs);
		System.out.println("registers after the inversion: " + Arrays.toString(regs));

		ps = new Hello(3);
		System.out.println("\n what if Hello has just arity" + ps.getA() + "?");
		ps.b(regs);
		System.out.println("now registers has : " + Arrays.toString(regs));
		ps.getInverse().b(regs);
		System.out.println("registers after the inversion: " + Arrays.toString(regs));
	}

	public static void testParamSum() {
		int[] regs = { 0, 0, 0, 0, 1, 3, 2, 11, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		ParamSum ps = new ParamSum(4, 3, 5);
		System.out.println("ParamSum has arity" + ps.getA());
		ps.b(regs);
		System.out.println("now registers has : " + Arrays.toString(regs));
		ps.getInverse().b(regs);
		System.out.println("registers after the inversion: " + Arrays.toString(regs));
	}

	public static void testShiftK() {
		int[] regs;
		System.out.println("start ShiftLastToFirstK");
		regs = new int[] { //
				1, 2, 3, 4, 5, //
				6, 7, 8, 9, 0, //
				-1, -2, -3, -4, -5, //
				0, 0 //
		};
		int k = regs.length - 2;
		ShiftLastToFirstK shifterK = new ShiftLastToFirstK(k);
		System.out.println("shifter K registers was: " + Arrays.toString(regs));
		shifterK.b(regs);
		System.out.println("\t shifter K regs now is: " + Arrays.toString(regs));
		(new InvShiftLastToFirstK(k)).b(regs);
		System.out.println("\t shifter K regs after inverse call: " + Arrays.toString(regs));
		System.out.println("END ShiftLastToFirstK");

		k = 7;
		System.out.println("\n\n\n\nredo ShiftLastToFirstK with k=" + k);
		shifterK = new ShiftLastToFirstK(k);
		System.out.println("new shifterK has arity: " + shifterK.getA());
//		regs[regs.length - 1] = k;
		regs[k + 1] = k;
		regs[k] = 0;
		System.out.println("shifter K registers was: " + Arrays.toString(regs));
		shifterK.b(regs);
		System.out.println("\t shifter K regs now is: " + Arrays.toString(regs));
		(new InvShiftLastToFirstK(k)).b(regs);
		System.out.println("\t shifter K regs after inverse call: " + Arrays.toString(regs));
		System.out.println("END ShiftLastToFirstK with k=7");

		regs[k + 1] = k + 2;
		regs[k] = k + 1;
		k = 15;
		System.out.println("\n\n\n\nNow ShiftFirstToLastK with k=" + k);
		ShiftFirstToLastK shiftFTLk = new ShiftFirstToLastK(k);
		System.out.println("ShiftFirstToLastK K registers was: " + Arrays.toString(regs));
		shiftFTLk.b(regs);
		System.out.println("\t shifter K regs now is: " + Arrays.toString(regs));
		shiftFTLk.getInverse().b(regs);
		System.out.println("\t shifter K regs after inverse call: " + Arrays.toString(regs));
		System.out.println("END ShiftFirstToLastK with k=" + k);
	}
}
