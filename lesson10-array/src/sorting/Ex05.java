package sorting;

import java.util.Arrays;

import bean.SortOrder;
import utils.ArrayUtils;

public class Ex05 {

	public static void main(String[] args) {
		int[] numbers = {1 ,5 ,7, 6, 8,3};
		
		Arrays.sort(numbers);
		ArrayUtils.sort(numbers,SortOrder.DESC);
	//	Arrays.sort(numbers);
		ArrayUtils.printf(numbers);
	}
}
