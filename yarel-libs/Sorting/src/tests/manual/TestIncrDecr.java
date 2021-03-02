package tests.manual;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

import yarelLib.Increment;

public class TestIncrDecr {
	static int[] newRegs() {
		return new int[] { 20, -15, 8, 0, 2, -3, 77, 0 };
	}

	@Test
	public void testInc2_5() {
		Increment incr;
		int[] r = newRegs();
		int[] exp = newRegs();
		exp[4] = -13;
		incr = new Increment(7, 2, 5);
		incr.b(r);
		assertArrayEquals(exp, r);
	}

//	public static void main(String[] args) {
//
//		Decrement decr;
//
//		decr = new Decrement(5, 0, 23);
//
//		RPPSupplier[] tasks = { new RPPSupplier(incr, incr.getInverse()), //
//				new RPPSupplier(decr, decr.getInverse()), //
//		};
//		System.out.println("Original registers: " + Arrays.toString(regs));
//
//		for (RPPSupplier supp : tasks) {
//			System.out.println(
//					"\nPerforming " + supp.task.getClass().getSimpleName() + " - having arity: " + supp.task.getA());
//			supp.task.b(regs);
//			System.out.println("now registers has : " + Arrays.toString(regs));
//			supp.inverse.b(regs);
//			System.out.println("registers after the inversion: " + Arrays.toString(regs));
//		}
//		System.out.println("\nfine test inc vari");
//	}
//
//	static class RPPSupplier {
//		final RPP f, inv;
//
//		public RPPSupplier(RPP f, RPP inv) {
//			super();
//			this.f = f;
//			this.inv = inv;
//		}
//	}
}
