package ifelse.switchcase;

public class Ex03 {
	public static void main(String[] args) {
		int month = 18;
		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12:
			System.out.println("31 days");
			break;

		case 4, 6, 9:
			System.out.println("30 days");
			break;

		case 2:
			System.out.println("29 days");
			break;

		default:
			System.out.println("month invalid");
		}
	}
}
