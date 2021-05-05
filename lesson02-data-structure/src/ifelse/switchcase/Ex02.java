package ifelse.switchcase;

public class Ex02 {
	public static void main(String[] args) {
		float point = 8.2f;
		System.out.println(getLevel(point));
	}
	private static  Level getLevel(float point) {
		if(point < 5) {
			return Level.BAD;
		}
		else if(point <= 6.5) {
			return Level.MEDIUM;
		}
		else if(point <= 8) {
			return Level.PRETTY_GOOD;
		}	
			return Level.GOOD;
	}

}
