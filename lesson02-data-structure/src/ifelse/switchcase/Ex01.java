package ifelse.switchcase;

public class Ex01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 6;
		int c = 8;

		System.out.println("max: " + max(a, b, c));
		System.out.println("max: " + max(max(a, b), c));

		float mark = 5.8f;
		System.out.println("Level: " + getLevel(mark));

	}

	// overloading
	private static int max(int a, int b) {
		return a > b ? a : b;
	}

	private static int max(int a, int b, int c) {
		int max = a > b ? a : b;

		if (max < c) {
			max = c;
		}

		return max;

	}

	private static Level getLevel(float mark) {

		if (mark < 5) {
			return Level.BAD;
		}

		if (mark <= 6.5) {
			return Level.MEDIUM;
		}

		if (mark <= 8) {
			return Level.PRETTY_GOOD;
		}

		return Level.GOOD;
	}

}
