package tests.manual;

import java.util.Arrays;

import sorting.SortGrowing;
import sorting.SortUngrowing;
import yarelcore.RPP;

public class TestSort {
	public static final int[] DATASET = { 4, 3, 0, -2, 8, 4, 1, 6, -5, -2, 5, 7, 6, -12, 0, 10, 77, -4 };

	public static void main(String[] args) {
		int m = DATASET.length;
		RPP sorter;
		for (int k = 0; k <= m; k++) {
			System.out.println("\n\n\n start new cycle with k= " + k);
			sorter = new SortGrowing(k);
			testSort(k, sorter);
			sorter = new SortUngrowing(k);
			testSort(k, sorter);
		}
	}

	public static void testSort(int k, final RPP sorter) {
		int support;
		int[] r;
		support = 11; // because SortGrowing needs them
		r = new int[k + support];
		for (int i = 0; i < k; i++) {
			r[i] = DATASET[i];
		}
		for (int i = k; i < r.length; i++) {
			r[i] = 0;
		}
		System.out.println("\nSTART " + sorter.getClass().getSimpleName());
		System.out.println("and registers: " + Arrays.toString(r));
		sorter.b(r);
		System.out.println("\t got: " + Arrays.toString(r));
	}
}
