package tests.manual;

import sorting.SortGrowingOpt;
import sorting.SortUngrowingOpt;
import yarelcore.RPP;

public class TestSortBitStack {

	public static void main(String[] args) {
		int m = TestSort.DATASET.length;
		RPP sorter;
		System.out.println("WITH BIT STACk");
		for (int k = 0; k <= m; k++) {
			System.out.println("\n\n\n start new cycle with k= " + k);
			sorter = new SortGrowingOpt(k);
			TestSort.testSort(k, sorter);
			sorter = new SortUngrowingOpt(k);
			TestSort.testSort(k, sorter);
		}
	}
}
