package ifelse.switchcase;

public class Ex01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 6;
		int c = 8;
		
		int max = isMax(a, b, c);
		System.out.println("Max : " + max);
		System.out.println("max : " + isMax(isMax(a, b), c) );
		System.out.println("=====================");
		System.out.println("Level : " + getLevel(6));
	}	
	// overloading
	private static int isMax(int a, int b) {
		return a > b ? a : b ;
	}
	private static int isMax(int a, int b ,int c) {
		int Max = a > b ? a : b;
		if(Max < c) {
			Max = c;
		}
		return Max;
	}
	
	private static Level getLevel(float point) {
		if(point < 5) {
			return Level.BAD;
		}
		if(point < 6.5) {
			return Level.MEDIUM;
		}
		if(point < 8) {
			return Level.GOOD;
		}
			return Level.GOOD;
	}
	
}
