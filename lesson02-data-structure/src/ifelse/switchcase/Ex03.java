package ifelse.switchcase;

public class Ex03 {
	public static void main(String[] args) {
		int month = 100;
		int dayInMonth = 0;
		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12:
			dayInMonth = 31;
			break;
		case 2:
			dayInMonth = 29;
			break;
		case 4, 6, 9, 11:
			dayInMonth = 30;
			break;

		default:
			System.out.println("Invalid month");
			return;										//return: ignore code below and stop void method
		}

		System.out.println("Month " + month + " has " + dayInMonth + " days.");

	}

}
