package ifelse.switchcase;

public class Ex03 {
	public static void main(String[] args) {
		int month = 3;
		int dayinMonth = 0;
		//1 3 5 7 8 10 12
		//4 6 9
		//2
		switch (month) {
		case  1:
		case  3:
		case  5:
		case  7:
		case  8:	
		case 10:	
		case  12:
			dayinMonth = 31;
			break;
		case  4: case  6:case  9:
			
			System.out.println("30 days");
			break;
		case 2: 
			System.out.println("28 days");
			break;
		default:
			System.out.println("invalid month");
			return; //ignore code below and stop void method
		}
		System.out.println("Month " + month + " has " + dayinMonth + " days " );
	}
}
