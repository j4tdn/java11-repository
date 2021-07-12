package ex03;


public class App {
	public static void main(String[] args) {
		String[] before = {"2","4", "cff","dsd", "-7", "b",null, null, "Special", null, "-7"};
		String[] result = up(before);
		System.out.println("Tăng dần: ");
		for(String i : result){
			System.out.print(i+", ");
		}
		System.out.println("\nGiảm dần: ");
		for(int i = result.length -1; i >= 0; i-- ) {
			System.out.print(result[i] +", ");
		}
		
	}
	
	private static String[] up(String[] before) {
		String[] result = new String[before.length];
		int m = 0,n = 0;
		String foo = null;
		for(String i : before) {
			if(isDigit(i)) {
				m++;
			}
			else if(i != foo && i != "Special") {
				n++;
			}
		}
		int[] digits = new int[m];
		String[] str = new String[n];
		int k = 0;
		int count = 0;
		boolean check = false;
		for(String i : before ) {
			if(i == "Special") {
				check = true;
			}
			else if(isDigit(i)) {
				digits[count] = Integer.parseInt(i); 
				count++;
			}
			else if(i != foo) {
				str[k] = i;
				k++;
			}	
		}	
		String[] st = sortString(str);
		int[] number = insertSort(digits);

		if(check) {
			result[0] = "special";
			int i = 1 ;
			while(i < number.length + 1 ) {
				result[i] = String.valueOf(number[i-1]);
				i++;
			}
			while(i < st.length + number.length + 1 ) {
				result[i] = st[i - 1 - number.length];
				i++;
			}
			while(i < result.length) {
				result[i] = foo;
				i++;
			}
		}
		return result;
	}
	
	//private static String[] connect(boolean check, String[] str, int[] digit) {
	//	
	//}
	/*
	 * 
	private static int getMiddle(int[] digits, int low, int high) {
		int tmp = digits[0];
		while(low < high) {
			while(low < high && high >= tmp) {
				high --;
			}
			digits[low] = digits[high];
			while(low < high && digits[low] <= tmp) {
				low ++;
			}
			digits[high] = digits[low];
		}
		digits[low] = tmp;
		return low;
	}
	
	private static void quickSort(int[] digits, int low, int high) {
		if(low < high) {
			int middle = getMiddle(digits,low,high);
			quickSort(digits, low, middle-1);
			quickSort(digits, middle +1, high);
		}
		for(int i : digits) {
			System.out.print(i+ ", ");
		}
	}
	*/
	private static String[] sortString(String[] str) {
		String temp;
		for(int i = 0;  i< str.length; i++) {
			for(int j = i + 1; j < str.length; j++) {
				if(str[i].compareTo(str[j]) > 0) {
					temp = str[i];
					str[i] = str[j];
					str[j] = temp;
				}
			}
		}
		return str;
	}
	private static int[] insertSort(int [] digits) {
		for(int i = 1; i < digits.length; i++) {
			int temp = digits[i];
			int j = i - 1;
			for(; j >= 0 && digits[j] > temp; j--) {
				//Moves the value greater than temp back by one unit
				digits[j+1] = digits[j];
			}
			digits[j+1] = temp;
		}
		return digits;
	}
	private static boolean isDigit(String str) {
		String foo = null;
		if(str == foo) {
			return false;
		}
		if(str.equals("+") || str.equals("-") )
			return false;
		else
			return str.matches("[+-]?\\d*(\\.\\d+)?");
		
	}
}
