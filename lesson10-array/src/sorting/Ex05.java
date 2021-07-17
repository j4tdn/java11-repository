package sorting;


import bean.SortOrder;
import utils.ArrayUtils;

public class Ex05 {
	public static void main(String[] args) {
		int[] digits = { 1, 5, 9, 4, 6, 11 };
		
		ArrayUtils.sort(digits, SortOrder.DESC);
		
		ArrayUtils.printf(digits);
	}
}
