package ifelse.switchcase;

public class Ex03 {
	public static void main(String[] args) {
		int month = 2;
		//int daysInMonth = 0;
		
		switch(month) {
		case 1: case 3:
		case 5: case 7:
		case 8: case 10: case 12:
			System.out.println("daysInMonth 31");
			
			//daysInMonth = 31;
			break;
		case 4: case 6: case 9:
			System.out.println("daysInMonth 30");
			//daysInMonth = 30;
			break;	
		case 2:
			System.out.println("daysInMonth 29");
			//daysInMonth = 28;
			break;
		default:
			System.out.println("Invalid month");
	        break;
		}
           //System.out.println("Month " + month + " has " + daysInMonth + " days ");
		
		}
	}


