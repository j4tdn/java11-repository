package view;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = { 3, 15, 21, 0, 15, 17, 21 };
		int count = 0;
		int[] result = new int[digits.length];
		for (int i = 0; i < digits.length; i++) {
			if (isUniqueNumber(digits, i)) {
				result[count++] = digits[i];
			}
		}
		sortAsc(result, count);
		for (int i = 0; i < count; i++) {
			System.out.print(result[i] + " ");
		}
	}

	private static boolean isUniqueNumber(int[] digits, int index) {
		for (int i = 0; i < digits.length; i++) {
			if (index != i && digits[index] == digits[i]) {
				return false;
			}
		}
		return true;
	}

	private static void sortAsc(int[] result, int count) {
		int tmp = 0;
		for (int i = 0; i < count - 1; i++) {
			for (int j = i + 1; j < count; j++) {
				if (result[i] > result[j]) {
					tmp = result[i];
					result[i] = result[j];
					result[j] = tmp;
				}
			}
		}
	}

}
