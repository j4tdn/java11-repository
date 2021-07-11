package bt01;

public class Bt01 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 3, 1 };
		System.out.print("1.Result eraseDuplicate: ");
		eraseDuplicate(arr);

		System.out.println();

		System.out.print("2.Compare n/2 front with n/2 behind: ");
		checkAverage(arr);

		int[] arr2 = { 7, 8, 8, 8, 6, 2, 5, 1 };
		System.out.print("3.Sort array from smallest to largest: ");
		checkmax3rd(arr2);
	}
	//EraseDuplicate
	private static void eraseDuplicate(int[] digit) {
		int count;
		for (int i = 0; i < digit.length; i++) {
			count = 0;
			for (int j = 0; j < digit.length; j++) {
				if (digit[i] == digit[j]) {
					count++;
				}
			}
			if (count == 1) {
				System.out.print(" " + digit[i]);
			}
		}
	}
	//CheckAverage n/2 front with n/2 behind
	private static void checkAverage(int[] numb) {
		double front = 0;
		double behind = 0;
		int n = numb.length;
		for (int i = 0; i < n / 2; i++) {
			front = (front + numb[i]);
		}
		// check length odd or even
		int midindex = (numb.length % 2 == 0) ? numb.length / 2 : numb.length / 2 + 1;
		for (int j = midindex; j < n; j++) {
			behind = (behind + numb[j]);
		}
		if (front > behind) {
			System.out.println("n/2 front > n/2 after");
		} else {
			System.out.println("n/2 behind > n/2 front");
		}

	}
	//Find 3rd largest number
	private static void checkmax3rd(int[] number) {
		// sort array from smallest to largest
		int n = number.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (number[i] > number[j]) {
					int temp = number[i];
					number[i] = number[j];
					number[j] = temp;
				}
			}
			System.out.print(" " + number[i]);
		}
		//check max 3rd
		for (int k = n - 1; k > 0; k--) {
			if (number[k] != number[k - 1]) {
				count++;
			}
			if (count == 3) {
				System.out.println();
				System.out.println("Number max 3rd: " + number[k]);
				break;
			}
		}
	}
}
