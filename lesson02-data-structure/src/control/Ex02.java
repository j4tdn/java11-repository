package control;

public class Ex02 {
	enum Level {
		BAD, MEDIUM, PRETTY_GOOD, GOOD;
	}

	public static void main(String[] args) {
		float point = 8.7f;
		System.out.println(getLevel(point));
	}

	private static Level getLevel(float point) {
		Level level = null;
		if(point<5) {
			return Level.BAD;
		} else if (point < 6.5) {
			return Level.MEDIUM;
		} else if (point < 8.5) {
			return  Level.PRETTY_GOOD;
		} else {
			return Level.GOOD;
		}
	}
}
