package view;

public class Ex02 {

	public static void main(String[] args) {
		int[] arr = {2, 7, 6, 50, 35, 70, 10};
		
		int[] result = gatherArr(arr);
		for(int i = 0; i < result.length; i++) {
			System.out.print(" " + result[i]);
		}

	}
	private static int[] gatherArr(int[] arr) {
		int[] temp = new int[arr.length];
		int left = 0;
		int right = arr.length - 1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 7 == 0 || arr[i] % 35 == 0) {
				temp[left] = arr[i];
				left++;
			}
			if(arr[i] % 5 == 0  && arr[i] % 7 != 0) {
				temp[right] = arr[i];
				right--;
			}
			
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 5 != 0 && arr[i] % 7 != 0) {
				temp[right] = arr[i];
				right--;
			}
		}
		return temp;
		
	}

}