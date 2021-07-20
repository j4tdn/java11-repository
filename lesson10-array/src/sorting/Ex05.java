package sorting;

import bean.SortOrder;
import untils.ArrayUtils;

public class Ex05 {
	public static void main(String[] args) {
		int[] numbers = new int[] { 5, 4, 2, 6, 8, 11 };
		ArrayUtils.sort(numbers, SortOrder.DESC);
		ArrayUtils.printf(numbers);
	}
}
