package ifelse.switchcase;

public class Ex03 {
	public static void main(String[] args) {
<<<<<<< HEAD
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
=======
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

>>>>>>> ba78b3a (lesson02-03 02.05.2021)
}
