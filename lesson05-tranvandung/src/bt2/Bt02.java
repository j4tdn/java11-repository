package bt2;

public class Bt02 {
	public static void main(String[] args) {
		int[] arr2 = { 1, 2, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("So con thieu la " + getMissingNumbe(arr2));
	}

	static int getMissingNumbe(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		int count = 1;
		for (int i = 0; i < arr.length; i++) {
			if (count != arr[i]) {
				return count;
			}
			count++;
		}

		return count;

	}
}
