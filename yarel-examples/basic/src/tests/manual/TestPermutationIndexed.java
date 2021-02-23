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
	}
}