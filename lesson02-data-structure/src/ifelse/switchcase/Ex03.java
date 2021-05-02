package ifelse.switchcase;

public class Ex03 {
	public static void main(String[] args) {
		int month = 123;
		// 1 3 5 7 8 10 12 : 31
		// 4 6 9 11 : 30
		// 2
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Co 31 ngay");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Co 30 ngay");
			break;
		case 2:
			System.out.println("Co 28 ngay");
			break;
		default:
			System.out.println("Invalid month");
			return; // ignore code below and stop void method
		}
		System.out.println("Month " + month);
	}
}
