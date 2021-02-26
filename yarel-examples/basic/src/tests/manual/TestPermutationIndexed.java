package tests.manual;

import java.util.Arrays;

import permuatation.PIndexed_0;
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
import yarelcore.RPP;

public class TestPermutationIndexed {

	public static void main(String[] args) {
		int i;
		int[] regs = new int[5];
		RPP[] perms = { //
				new PIndexed_0(), //
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

//		System.out.println("\n\n\n\n---------------------------");
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