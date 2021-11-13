package sorting;

import Utils.ArraysUtils;
import bean.SortOrder;

public class Ex06 {
	public static void main(String[] args) {
		int[] numbers = { 1, 5, 9, 4, 6, 11 };

		ArraysUtils.sort(numbers, SortOrder.DESC);
		ArraysUtils.printf(numbers);
	}
}
