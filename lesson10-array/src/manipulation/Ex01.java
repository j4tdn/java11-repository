package manipulation;

import bean.Tuple;
import function.Predicate;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = {1, 9, 5, 36, 12, 33};
		
		int sumOdd = Caculate(digits, d -> d % 2 != 0);
		System.out.println("sum odd : " + sumOdd);
		
		Tuple mm = getMinMax(digits);
		System.out.println(mm);
		
		System.out.print("digits = ");
		print(digits);
		
		int[] add = addArr(digits, 2, 17);
		System.out.print("addArr = ");
		print(add);
		
		int[] remove = removeArr(digits, 3);
		System.out.print("removeArr = ");
		print(remove);
		
		int[] update = updateArr(digits, 2 , 15);
		System.out.print("updateArr = ");
		print(update);
		
		int[] reverse = reverseArr(digits);
		System.out.print("reverseArr = ");
		print(reverse);
		
		int[] reverse2 = reverseArr2(digits);
		System.out.print("reverseArr2 = ");
		print(reverse2);
	}
	




	private static void print(int[] digits) {
		for(int digit : digits) {
			System.out.print(digit + " ");
		}
		System.out.println();
		
	}

	
	private static int Caculate(int[] digits, Predicate predicate) {
		int result = 0;
		for(int digit : digits) {
			if(predicate.test(digit)) {
				result += digit;
			}
		}
		return result;
	}
	
	private static Tuple getMinMax(int[] digits) {
		Tuple mm = new Tuple();
		int max = digits[0];
		int min = digits[0];
		
		for(int digit : digits) {
			if(max < digit) {
				max = digit;
			}
			if(min > digit) {
				min = digit;
			}
		}
		
		mm.setMax(max);
		mm.setMin(min);
		
		return mm;	
	}
	
	private static int[] addArr(int[] digits, int k, int value) {
		int[] newDigits = new int[digits.length + 1];
		for(int i = 0; i < digits.length; i++) {
			newDigits[i] = digits[i];
		}
		
		int i = 0;
		for( i = newDigits.length - 1; i >=  k ; i--) { // 1, 9, 5, 36, 12, 33 0	
				newDigits[i] = newDigits[i -1];
		}
		newDigits[i] = value;
		
		return newDigits;
	}
	
	private static int[] removeArr(int[] digits, int k) {
		int[] newDigits = new int[digits.length - 1];
		
		int index = 0;
		for(int i = 0; i < digits.length; i ++) { 	
			if(i == (k-1)) {
				continue;
			}
			newDigits[index++] = digits[i]; 
		}
		
		
		return newDigits;
	}
	
	private static int[] updateArr(int[] digits, int k, int value) {
		int[] newDigits = new int[digits.length];
		for(int i = 0; i < digits.length; i++) {
			newDigits[i] = digits[i];
		}
		newDigits[k - 1] = value; 
		
		return newDigits;
	}
	
	// Case 1 : 
	private static int[] reverseArr(int[] digits) {
		int[] newDigits = new int[digits.length];
		int index = 0;
		for(int i = newDigits.length - 1; i >= 0; i--) {
			newDigits[index++] = digits[i];	
		}
		
		return newDigits;
	}
	
	// Case 2 : 
	private static int[] reverseArr2(int[] digits) {
		int[] newDigits = new int[digits.length];
		for(int i = 0; i < digits.length; i++) {
			newDigits[i] = digits[i];
		}
		
		for(int i = 0; i < newDigits.length / 2; i++) {
			int tmp = newDigits[i];
			newDigits[i] = newDigits[newDigits.length - 1 - i];
			newDigits[newDigits.length - 1 - i] = tmp;
		}
		
		return newDigits;
	}
}
