package homeworks;

public class Ex02 {
	public static void main(String[] args) {
		int sum = 0;
		int tmp = 1;
		for(int i = 1; i <= 18; i++) {
			tmp *= i;
			if (i == 4 || i == 7 || i == 12 || i == 18) 
				sum += tmp;	

		}
		System.out.println("4! + 7! + 12! + 18! = " + sum);

	}

}