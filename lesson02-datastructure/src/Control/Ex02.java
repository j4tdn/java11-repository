package Control;

public class Ex02 {
	enum Level
	{
		BAD,MEDIUM,PRETTY_GOOD, GOOD
	}
	public static void main(String[] args) {
		float point =9.2f;
		System.out.println(GetLevel(point));
	}
	private static Level GetLevel(float point)
	{
		Level lev = null;
		if(point < 5)
			return Level.BAD;
		if(point<6.5f)
			return Level.MEDIUM;
		if( point <8.5)
			return Level.PRETTY_GOOD;
		return Level.GOOD;
	
	}
}
