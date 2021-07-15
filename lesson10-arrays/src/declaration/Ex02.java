package declaration;

import java.util.Arrays;

import bean.Condition;

public class Ex02 implements Condition{
	public static void main(String[] args) {
		int[] digits = {1, 3, 6, 19, 22, 40};
		printf(getElements(digits, d1 -> d1 % 2 == 0));
		printf(getElements(digits, d1 -> d1 % 2 != 0));
	}

	private static int[] getElements(int[] digits, Condition cdt) {
		int[] result = new int[digits.length];
		int index = 0;
		for (int digit: digits) {
			if(cdt.test(digit)) {
				result[index++] = digit;
			}
		}
		return Arrays.copyOf(result, index);
	}
	
	private static void printf(int[] digits) {
		for(int digit: digits) {
			System.out.println(digit + " ");
		}
		System.out.println();
	}

	@Override
	public boolean test(int a) {
		// TODO Auto-generated method stub
		return false;
	}

}


