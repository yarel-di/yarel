package tests.manual;

import java.util.Arrays;

import sorting.SortGrowing;

public class TestSort {
	static final int[] DATASET = { 4, 0, 3, -2, 8, 1, 6, 5, 7, 6, -12, 0, 10, 77, -4 };

	public static void main(String[] args) {
		int k, support;
		int[] r;
		SortGrowing sorter;
		support = 11; // because SortGrowing needs them
		k = 10;
		r = new int[k + support];
		for (int i = 0; i < k; i++) {
			r[i] = DATASET[i];
		}
		for (int i = k; i < r.length; i++) {
			r[i] = 0;
		}
		sorter = new SortGrowing(k);
		System.out.println("START SORT GROWING with k= " + k);
		System.out.println("\t and registers: " + Arrays.toString(r));
		sorter.b(r);
		System.out.println("got: " + Arrays.toString(r));
	}
}
