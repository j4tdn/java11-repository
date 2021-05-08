package ifelse.switchcase;

public class Ex03 {
	public static void main(String[] args) {
		int month = 7;
		// 1 3 5 7 8 10 12
		//4 6 9
		// 2
		switch (month) {
		case 2:
			System.out.println("29 days");
			break;
		case 1: case 3:case 5:
		case 7: case 8:case 10:
		case 12:
			System.out.println("31 days");
			break;
		case 4: case 6: case 9:
			System.out.println("30 days");
			break;
		default:
			System.out.println("Invalid month");
			return;
		}
	}

}
