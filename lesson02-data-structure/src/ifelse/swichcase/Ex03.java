package ifelse.swichcase;

public class Ex03 {
	public static void main(String[] args) {
		int month = 7;
		switch (month) {
		case 1: case 3: case 7: case 5: case 8,10,12:
			System.out.println("31");
			break;
		case 4: case 6: case 9: case 11:
			System.out.println("30");
			break;
		case 2:
			System.out.println("28");
			break;
		
		default:
			return;
		}

	}

}
