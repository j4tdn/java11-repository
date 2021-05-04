package ifelse.switchcase;

public class Ex03 {
	public static void main(String[] args) {
		//1 3 5 7 8 10 12
		//4 6 9
		//2
		//sout ("29 days")
		
		int month = 0;
		int dayInMonth = 0;
		
		switch (month) {
		case 1,3,5,7,8,10,12:
			dayInMonth= 31;
			break;
		case 4,6,9:
			dayInMonth=30;
			break;
		case 2:
			dayInMonth=29;
			break;
		default:
			System.out.println("Invalid month");
			return;
		}
		System.out.println("Month " + month +" has " + dayInMonth +" days");
	}
	
}
