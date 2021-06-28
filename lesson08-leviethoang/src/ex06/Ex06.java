package ex06;

public class Ex06 {
	public static void main(String[] args) {
		String input = "1236546496791164941513210316346484";
		System.out.println(getCharNumb(input, 10));
	}
	
	private static char getCharNumb(String input, int k) {
		if( k > input.length()) {
			throw new IllegalArgumentException("k cannot be greater than the length of the input !!!");
		}
		return input.charAt(k - 1);
	}
}
