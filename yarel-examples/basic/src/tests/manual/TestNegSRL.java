package tests.manual;

import java.util.Arrays;

import util.NegSRL;

public class TestNegSRL {

	public static void main(String[] args) {
		NegSRL n;
		int[][] regss = { //
				new int[] { 4, 0 }, //
				new int[] { -3, 0 }, //
				new int[] { 0, 0 }, //
				new int[] { 8, 3 }, //
				new int[] { 100, -5 }, //
				new int[] { -7, 10 }, //
				new int[] { -12, -3 },//
		};
		n = new NegSRL();
		System.out.println("start NegSRL test");
		for (int[] r : regss) {
			int[] exp = new int[] { -r[0], r[1] };
			System.out.println("\n\nTESTING : " + Arrays.toString(r));
			n.b(r);
			System.out.println("\t then: " + Arrays.toString(r));
			System.out.println("\t- correct? " + Arrays.equals(r, exp));
		}
		System.out.println("\n\n\n endNegSRL test");
	}

}
