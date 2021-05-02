package ifelse.switchcase;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println(max(0, 0, 0));
		System.out.println(max(max(0,0),0));
		System.out.println(getLevel(10));
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}
	private static int max(int a, int b, int c) {
		int max = a > b ? a : b;
		if(max < c) {
			max = c;
		}
		return max;
	}
	private static Level getLevel(float point) {
		if(point < 5) {
			return Level.BAD;
		}
		if(point <= 6.5) {
			return Level.MEDIUM;
		}
		if(point <=8) {
			return Level.PRETTY_GOOD;
		}
		return Level.GOOD;
	}
}
