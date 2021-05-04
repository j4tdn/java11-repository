package ifelse.switchcase;

public class Ex01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 6;
		int c = 8;

		System.out.println("max: " + max(a, b, c));
		System.out.println("max: " + max(max(a, b), c));

		float avgPoint = 7.8f;
		System.out.println("level: " + getLevel(avgPoint));
		
	}

//overloading
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

	private static Level getLevel(float point) {
		if (point < 5) {
			return Level.Bad;
		}
		if (point <= 6.5) {
			return Level.Medium;
		}
		if (point <= 8) {
			return Level.Pretty_Good;
		}
		return Level.Good;

	}
}
