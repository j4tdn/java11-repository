

import java.util.Random;

public class Ex06 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		Random rd = new Random();
		arr[0] = 20 + rd.nextInt(30 - 20 + 1);
		boolean isDuplicate = false;
		for (int i = 1; i < arr.length; i++) {
			int temp = 20 + rd.nextInt(30 - 20 + 1);
			for (int j = 0; j < i; j++) {
				if (temp == arr[j]) {
					isDuplicate = true;
					break;
				} else
					isDuplicate = false;
			}
			if (isDuplicate)
				i--;
			else
				arr[i] = temp;
		}
		for(int i : arr) {
			System.out.println(i);
		}

	}

}