package sorting;

import static utils.ArrayUtils.sort;

import bean.SortOrder;

public class Ex05 {
	public static void main(String[] args) {
		int[] numbers = {1, 5, 9, 4, 6, 11};
		
		sort(numbers, SortOrder.DESC);
		System.out.println(numbers);
	}
}
