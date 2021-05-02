package ifelse.switchcase;

public class Ex03 {
	public static void main(String[] args) {
		int month = 13;
		// 31 days: 1 3 5 7 8 10 12
		// 30 days: 4 6 9
		// 28/29 days: 2
		switch (month) {
		case 1:case 3:
		case 5:case 7:
		case 8:case 10:
		case 12:
			System.out.println("31 days");
			break;
		case 4:case 6:
		case 9:
			System.out.println("30 days");
			break;
		case 2:
			System.out.println("28 days");
			break;
		default:
			System.out.println("Invalid month");
			return;	//stop void method
		}
		System.out.println("a");
	}

}
