package exam1;

public class UniqueNumber {
	public static void main(String[] args) {
		
		int[] arr = {3, 15, 21, 0, 15, 17, 21};
		getUniqueNumber(arr);

	}

	public static void getUniqueNumber(int[] arr) {
		int[] temp = new int[10];
		boolean check = true;
		int count = 0;
		
		//get UniqueNumber
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					if (arr[i] == arr[j]) {
						check = false;
						break;
					}
				}
			}
			
			if (check) {
				temp[count++] = arr[i]; 
				check = true;
			}
			else check = true;
		}
		
		// sort
		for (int i = 0; i < count -1 ; i++) {
			for (int j = i +1; j < count; j++) {
				if (temp[i] > temp[j]) {
					int tmp = temp[i];
					temp[i] = temp[j];
					temp[j] = tmp;
				}
			}
		}

		for (int i = 0; i < count; i++) {
			System.out.printf("%s ", temp[i]);

		}
	}
}
