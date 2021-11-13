package Control;

public class Ex04 {
	public static void main(String[] args) {
		int month =6;
		switch(month)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31 days");
			break;
		case 4:
		case 6:
		case 9:
			System.out.println("30 days");
			break;
		case 2:
			System.out.println("28 days");
			break;
		default:
			System.out.println("Invald month ! should be (1-12)");
			break;
		}
	}

}
