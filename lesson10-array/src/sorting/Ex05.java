package sorting;

import bean.SortOrder;
import static utils.ArrayUtils.*;

public class Ex05 {
	public static void main(String[] args) {
		int[] numbers = { 1, 5, 9, 4, 6, 11 };
		sort(numbers, SortOrder.DESC);
		printf(numbers);
	}
}
