package exercise;

public class Ex02_sumExponential {
	public static void main(String[] args) {

		System.out.println("Sum of 4! + 7! + 12! + 18! = "
				+ sum(sum(exponential(4), exponential(7)), sum(exponential(12), exponential(18))));

	}

	private static double exponential(int number) {
		int exponential = 1;
		for (int i = 1; i <= number; i++) {
			exponential *= i;
		}
		return exponential;

	}

	private static double sum(double d, double e) {
		return (d + e);

	}

}
