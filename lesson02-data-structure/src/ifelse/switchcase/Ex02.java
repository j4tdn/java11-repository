package ifelse.switchcase;

public class Ex02 {
	public static void main(String[] args) {
		int number = 3;
		//
		switch (number) {
		case 1: {
			
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + number);
		}
		
	}

}
