package ifelse.switchcase;

public class Daytoday {
	public static void main(String[] args) {
		int day = 2;
		int isday = 0;
		
		switch (day) {	
		
		case 2:
			isday = 2;
			System.out.println("thu: " + day + " monday");
			break;
		case 3:
			isday = 3;
			System.out.println("thu: " + day + " tuesday");
			break;
		case 4:
			isday = 4;
			System.out.println("thu: " + day + " wednesday");
			break;
		case 5:
			isday = 5;
			System.out.println("thu: " + day + " thusday");
			break;
		case 6:
			isday = 6;
			System.out.println("thu: " + day + " friday");
			break;
		case 7:
			isday = 7;
			System.out.println("thu: " + day + " saturday");
			break;
		case 8:
			isday = 8;
			System.out.println("thu: " + day + " sunday");
			break;

		
		default: 
			System.out.println("Not a day");
			break;
		}
		
	}
}
