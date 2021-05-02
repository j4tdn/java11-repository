package ifelse.switchcase;

public class Ex03 {
	public static void main(String[] args) {
		int month = 7;
		int daysINMonth = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			daysINMonth = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			daysINMonth = 30;
			break;
		case 2:
			daysINMonth = 29;
			break;
		default:
			System.out.println("Invaild");
			return;
		}
		System.out.println(daysINMonth);
	}
}
