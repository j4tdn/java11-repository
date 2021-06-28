package Ex02;

public class FindMaxNumber {
	public static void main(String[] args) {
		String n = "01a2b3456cde478";

		System.out.println(getLargestNumbers(n));
	}

	public static int getLargestNumbers(String n) {

		String[] stringNumber = n.split("[^\\d]+");
		int[] numbers = new int[stringNumber.length];

		for (int i = 0; i < stringNumber.length; i++) {
			numbers[i] = Integer.parseInt(stringNumber[i]);
		}

		int max = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			max = (max > numbers[i]) ? max : numbers[i];
		}

		return max;

	}

}
