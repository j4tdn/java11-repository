package ifelse.switchcase;

public class Ex01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 6;
		int c = 8;
		
		//truyền giá trị sau khi tạo hàm private max bên sưới
		System.out.println("max: " + max(b,c,a)); // b gán vào int a, c gán int
		System.out.println("max: " + max(max(a, b), c));
		
		float avgPoint = 9.2f;
		System.out.println("level: " + getLevel(avgPoint));
	}
	
	//overloading, 2 hàm trùng tên khác số lượng tham số
	private static int max(int a, int b) {
//		int max = a > b ? a : b;
//		return max;
		return a > b ? a : b;
	}

	private static int max(int a, int b, int c) { // tạo hàm max. sau khi tạo hàm thì quay lên public truyền biến
		// int max = a;
		// if (max < b) {
		// max = b;
		// }
		int max = a > b ? a : b; //nếu a>b gắn max cho a, nếu a<b gắn max cho b
		if (max < c) {
			max = c;
		}
		return max;
	}
	
	private static Level getLevel(float point) {
//		Level result = null;
//		if(point < 5) {
//			result = Level.BAD
//		}else if (point <= 6.5) {
//			result = Level.MEDIUM
//		}else if (point <= 8) {
//			result = Level.PRETTY_GOOD
//		}else result = Level.GOOD
		if(point < 5) {
			return Level.BAD;
		}
		if(point <= 6.5) {
			return Level.MEDIUM;
		}
		if(point <= 8) {
			return Level.PRETTY_GOOD;
		}
		return Level.GOOD;
	}
}
