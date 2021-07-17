package sorting;

import java.util.Arrays;

import bean.SortOrder;
import static utils.ArrayUtils.*;

public class Ex05 {
	public static void main(String[] args) {
		int[] numbers = {1, 5, 11, 9, 4, 6};
		
		sort(numbers, SortOrder.ASC);
		
		printf(numbers);
	}
}
