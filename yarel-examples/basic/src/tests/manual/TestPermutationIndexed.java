package tests.manual;

import java.util.Arrays;

import permuatation.InvShiftLastToFirst10;
import permuatation.InvShiftLastToFirst5;
import permuatation.PIndexed_1;
import permuatation.PIndexed_10;
import permuatation.PIndexed_12;
import permuatation.PIndexed_2;
import permuatation.PIndexed_3;
import permuatation.PIndexed_4;
import permuatation.PIndexed_5;
import permuatation.PIndexed_6;
import permuatation.PIndexed_7;
import permuatation.PIndexed_8;
import permuatation.PIndexed_min_1;
import permuatation.PIndexed_min_11;
import permuatation.PIndexed_min_14;
import permuatation.ShiftLastToFirst10;
import permuatation.ShiftLastToFirst5;
import yarelcore.RPP;

public class TestPermutationIndexed {

	public static void main(String[] args) {
		int i;
		int[] regs = new int[5];
		RPP[] perms = { //
				new PIndexed_1(), //
				new PIndexed_2(), //
				new PIndexed_3(), //
				new PIndexed_4(), //
				new PIndexed_5(), //
				new PIndexed_6(), //
				new PIndexed_7(), //
				new PIndexed_8(), //
				new PIndexed_10(), //
				new PIndexed_12(), //
				new PIndexed_min_14(), //
				new PIndexed_min_11(), //
				new PIndexed_min_1(), //
		};
		for (RPP pi : perms) {
			System.out.println("\n\n performing: " + pi.getClass().getSimpleName());
			Arrays.fill(regs, 0);
//		System.out.print("\thad: "+Arrays.toString(regs));
			pi.b(regs);
			System.out.println("\tgot: " + Arrays.toString(regs));
		}

		System.out.println("\n\n\n\n---------------------------");
		System.out.println("start ShiftLastToFirst5");
		regs = new int[] { 5, 8, 0, 13, -7, 0, 5 };
		ShiftLastToFirst5 shifter5 = new ShiftLastToFirst5();
		System.out.println("shifter 5 registers was: " + Arrays.toString(regs));
		shifter5.b(regs);
		System.out.println("\t shifter 5 regs now is: " + Arrays.toString(regs));
		(new InvShiftLastToFirst5()).b(regs);
		System.out.println("\t shifter 5 regs after inverse call: " + Arrays.toString(regs));
		System.out.println("END ShiftLastToFirst5");

		System.out.println("\n\n\n\n---------------------------");
		System.out.println("start ShiftLastToFirst10");
		regs = new int[] { 5, 8, 0, 13, -7, 666, -777, 88, 1024, 3, 0, 10 };
		ShiftLastToFirst10 shifter10 = new ShiftLastToFirst10();
		System.out.println("shifter 5 registers was: " + Arrays.toString(regs));
		shifter10.b(regs);
		System.out.println("\t shifter 5 regs now is: " + Arrays.toString(regs));
		(new InvShiftLastToFirst10()).b(regs);
		System.out.println("\t shifter 5 regs after inverse call: " + Arrays.toString(regs));
		System.out.println("END ShiftLastToFirst10");

		// System.out.println("\n\n\n\n---------------------------");
//		regs = new int[12];
//		Arrays.fill(regs, 0);
//		regs[1] = 10; // length
//		i = 2;
//		for (int x : new int[] { 7, 0, 5, 3, -2, 14, 6, 777, -1000, 8 }) {
//			regs[i++] = x;
//		}
//		System.out.println("Shifting regs: " + Arrays.toString(regs));
//		ShiftLeft10IntsArray1Place shifterOne = new ShiftLeft10IntsArray1Place();
//		shifterOne.b(regs);
//		System.out.println("Shifting regs got: " + Arrays.toString(regs));

	}
}