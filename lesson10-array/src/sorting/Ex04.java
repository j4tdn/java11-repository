package sorting;

import java.util.Arrays;

import bean.SortOder;
import utils.ArrayUtils;

public class Ex04 {
	public static void main(String[] args) {
		int[] numbers = {1,3,11,5,9,4,6};
		
		ArrayUtils.sort(numbers, SortOder.DESC);
		ArrayUtils.printf(numbers);
	}
}
