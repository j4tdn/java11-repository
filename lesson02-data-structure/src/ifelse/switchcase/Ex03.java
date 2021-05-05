package ifelse.switchcase;

public class Ex03 {
	public static void main(String[] args) {
		int month = 13;
		int daysInMonth = 0;
		switch(month) {
		case 1: case 3:
		case 5: case 7: 
		case 8: case 10:
		case 12:
			daysInMonth = 31;
			break;
		case 4: case 6: 
		case 9: case 11:
			daysInMonth = 30;
			break;
	
		case 2: 
			daysInMonth = 28;
			
		default:
			System.out.println("Invalid month");
			return;
		}
		System.out.println("Month " + month + " has " + daysInMonth + " days");
	}

}
