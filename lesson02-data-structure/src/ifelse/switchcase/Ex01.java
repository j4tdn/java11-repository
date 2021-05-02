package ifelse.switchcase;

public class Ex01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 6;
		int c = 8;
		// System.out.println(max(a,b,c));
		// System.out.println(max(max(a,b),c));
		float avgpoint = 7.8f;
		System.out.println(getLevel(avgpoint));
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}

	private static int max(int a, int b, int c) {
		int max = a > b ? a : b;
		return max > c ? max : c;
	}

	private static Level getLevel(float point) {
		if (point < 5) {
			return Level.BAD;
		}
		if (point <= 6.5) {
			return Level.MEDIUM;
		}
		if (point <= 8) {
			return Level.PRETTY_GOOD;
		}
		return Level.GOOD;
	}

}
