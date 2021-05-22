package ex02;

public class Ex02 {

	public static void main(String[] args) {
		int[] arr = {1, 6, 7, 4, 2, 5, 3, 10, 9};
		System.out.println("So con thieu la: " + getMissingNumber(arr));
	}
	
	public static int getMissingNumber(int[] numbers) {
		int n = numbers.length + 1;
		int sum = (n * (n + 1)) / 2;
		int s = 0;
		
		for(int number : numbers) {
			s += number;
		}
		return sum - s;
	}

}
