package ifelse.switchcase;

public class Ex01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 6;
		int c = 8;
		
		System.out.println("max: " + max(a,b,c));
		System.out.println("max: " + max(max(a, b), c));
		
		float avgPoint = 6.8f;
		System.out.println("level: "+ getLevel(avgPoint));
		
	}
	
	//overloading
	private static int max(int a, int b) {
		return a > b? a: b;
	}
	
	private static int max(int a, int b, int c) {
		int max = a < b ? b : a;
		if (max < c) {
			max = c;
		}
		return max;
	}
	
	private static Level getLevel(float point) {
		//Level result = null;
		// để return mà k để biến result vì nó k trả về ngay khi thỏa dk mà nó sẽ thỏa nhiều điều kiện dưới nữa nên kết quả sẽ sai
		if (point < 5) {
			return Level.BAD;
		}
		if (point < 6.5) {
			return Level.MEDIUM;
		}
		if (point <=8 ) {
			return Level.PRETTY_GOOD;
		}
		return Level.GOOD;
		
	}
}
