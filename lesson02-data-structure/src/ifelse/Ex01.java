package ifelse;


public class Ex01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 6;
		int c = 8;
		
		float avgPoint = 7.8f;
		getLevel(avgPoint);
		System.out.println("level: " + getLevel(avgPoint));

		System.out.println("max: " + max(max(a, b), c));
		System.out.println("max: " + max(a, b, c));

	}

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

	private static level getLevel(float point) {
		if (point < 5) {
			return level.BAD;
		}
		if (point <= 6.5) {
			return level.MEDIUM;
		}
		if (point <= 8) {
			return level.PRETTY_GOOD;
		}
		return level.GOOD;

	}

}
