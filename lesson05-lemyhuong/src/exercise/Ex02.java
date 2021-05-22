package exercise;

public class Ex02 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 7, 4, 5};
	    System.out.println(getMissingNumber(arr));
		

	}
	public static int getMissingNumber(int[] arr) {
		int missingNum = 0;
		int temp;
	    for (int i = 0; i < arr.length - 1; i++) {
			if(arr[i] > arr[i+1]) {
				temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				
		}	
		}
		for (int j = 1; j < arr.length; j++) {
			if((arr[j]- arr[j-1]) == 2) {
				missingNum = arr[j-1]+1;
			}
		}
		return missingNum;
	}

}


