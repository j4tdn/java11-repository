package ifelse.switchcase;

public class Ex03 {
	public static void main(String[] args) {
		int month = 7;
		int dayIsMonth = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dayIsMonth = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dayIsMonth = 30;
			break;
		case 2:
			dayIsMonth = 28;
			break;

		default:
			System.out.println("Invalid month");
			return; // ignore code below
		}
		
	}
}
