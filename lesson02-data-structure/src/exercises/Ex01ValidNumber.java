package exercises;

import java.util.Scanner;

public class Ex01ValidNumber {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int count = 0;
		String text = null;
		do {
			System.out.println("Enter number: ");
			text = ip.nextLine();
			if(text.matches("[0-9]+")) {
				break;
			}
			count++;
			if(count == 3) {
			System.out.println("Wrong text exceeds 3 times !");
			return;
			}
		}while(true);
		int number = Integer.parseInt(text);
		System.out.println("value: " + number);
	}
}
