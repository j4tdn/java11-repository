package ifelse;

public class Ex03 {
	public static void main(String[] args) {
		int month = 7;
		// 1 3 5 7 8 10 12
		// 4 6 9
		// 2
		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12: {
			System.out.println("31 ngay");
			break;
		}
		case 2: {
			System.out.println("29 ngay");
			break;
		}
		case 4, 6, 9, 11: {
			System.out.println("30 ngay");
			break;
		}
		default: {
			System.out.println("k phai thang");
			break;
		}
		}
	}

}
