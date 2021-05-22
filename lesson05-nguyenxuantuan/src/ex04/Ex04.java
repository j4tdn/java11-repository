package ex04;

public class Ex04 {
	public static void main(String[] args) {
		long[] numbers = {5,2,7,9};
		
		long result = 1;
		for(long number : numbers) {
			result = getLeastCommonMultiple(result, number);
		}
		
		System.out.println("Boi chung nho nhat cua day so la: " + result);
	}
	
	public static long getLeastCommonMultiple(long a, long b) {
		long mul = a * b;
		while(b > 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return mul / a;
	}
}