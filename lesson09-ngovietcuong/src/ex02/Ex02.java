package ex02;

public class Ex02 {
	public static void main(String[] args) {
		getLargestNumbers("aa6b546c6e22h", "aa6b326c6e22h");
	}

	public static void getLargestNumbers(String... array) {
		for (String ar : array) {
			String[] ss = ar.split("[,\\s]+");
			for (String s : ss) {
				String[] numbers = s.split("[a-z]");
				String max = numbers[0];
				for(int i= 0; i<= numbers.length; i++) {
					if(numbers[i].compareTo(max) > 0) {
						max = numbers[i];
					}
				}
				System.out.println(max);
			}
		}
	}
}
