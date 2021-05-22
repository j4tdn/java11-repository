package bt1;

import java.util.Arrays;

public class Bt01 {
	public static void main(String[] args) {
		int[] arr = { 3, 15, 21, 0, 15, 17, 21};
		int[] arr1 = getUniqueNumbers(arr);
		for (int i : arr1) {
			System.out.println(i);
		}
	}
	static int[] getUniqueNumbers(int arr[]) {
		int[] result = new int[arr.length];
		int index = 0;
		boolean isDuplicate = false;
		for (int i = 0; i < arr.length; i++) {
			isDuplicate = false;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j] && i != j) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				result[index] = arr[i];
				index++;
			}
		}
		result = Arrays.copyOfRange(result, 0, index);
		for (int i = 0; i < result.length - 1; i++) {
			for (int j = i + 1; j < result.length; j++) {
				if (result[i] > result[j]) {
					int temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
			}
		}
		return result;
	}
}
