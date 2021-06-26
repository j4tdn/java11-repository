package ex02;


public class Ex02 {
	public static void main(String[] args) {
		
	}
	
	private static String[] getLargestNumber(String[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			String[] numbers = arr[i].split("[a-z]++");
			for (int j = 0; j < numbers.length; j++) {
				while(numbers[j].startsWith("0")) {
					numbers[j] = numbers[j].substring(1);
				}
			}
			
			
		}
	}
}
