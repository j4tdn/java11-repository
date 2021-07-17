package exercises;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		int[] intNumbers = { 4, 2, 2, 6, 10, 5, 6, 2, 9, 5, 1, 7};

		System.out.print("delete the same number: ");
		int[] elementDistinct = distinct(intNumbers);
		display(elementDistinct);
		
		compareElement(intNumbers);
		
		System.out.print("Sắp xếp theo insertion: ");
		insertion(intNumbers);
		display(intNumbers);
		
		System.out.print("\nthe third largest in the array is: " + thirdMaxNumber(intNumbers));
	}

	private static void display(int[] intNummbers) {
		for (int i = 0; i < intNummbers.length; i++) {
			System.out.print(intNummbers[i] + " ");
		}
	}

	private static int[] distinct(int[] intNumbers) {
		int[] result = new int[intNumbers.length];
		int k = 0;
		for (int i = 0; i < intNumbers.length; i++) {
			if (!isUnique(intNumbers[i], intNumbers, i)) {
				result[k] = intNumbers[i];
				k++;
			}
		}

		return Arrays.copyOfRange(result, 0, k);
	}
	
	private static void compareElement(int[] intNumbers) {
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < 6; i++) {
			sum1 += intNumbers[i];
		}
		
		for (int i = 6; i < 12; i++) {
			sum2 += intNumbers[i];
		}
		
		if (sum1 > sum2) {
			System.out.println("\nsix half of array is greater than its last half");
		}else if (sum1 < sum2){
			System.out.println("\nsix half of array is less than its last half");
		}
		else {
			System.out.println("\nsix half of array is equal to its last half");

		}
	}
	
	private static boolean isUnique(int number, int[] result, int index) {
		for (int i = 0; i < result.length; i++) {
			if (index != i && number == result[i]) {
				return true;
			}
		}
		return false;
	}
	
	private static int[] insertion(int[] intNumbers) {
		for (int i = 0; i < intNumbers.length; i++) {
			for(int j = i + 1; j < intNumbers.length; j++) {
				if(intNumbers[j] < intNumbers[i]) {
					int temp = intNumbers[i];
					intNumbers[i] = intNumbers[j];
					intNumbers[j] = temp;

				}
			}			
		}		
		return intNumbers;
	}
	
	private static int thirdMaxNumber(int[] intNumbers) {
		insertion(intNumbers);
		int thirdMaxNumber = intNumbers[intNumbers.length - 3];
		return thirdMaxNumber;
	}
}