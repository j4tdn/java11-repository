package ifelse.switchcase;

public class Ex01 {
	public static void main(String[] args) {
		int a = 9;
		int b = 4;
		int c = 7;
		
		System.out.println("max: " + max(a, b, c));
		System.out.println("max: " + max(max(a,b), b));
		
		float avgPoint = 7.5f;
		System.out.println("Level: " + getLevel(avgPoint));
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
		if(point < 5) {
			return Level.BAD;
		}
		if(point <= 6.5) {
			return Level.MEDIUM;
		}
		if(point <= 8) {
			return Level.PRYTY_GOOD;
		}
		return Level.GOOD;
	}

}
