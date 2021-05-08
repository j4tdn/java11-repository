package exercise;

import java.util.Scanner;

public class Ex01ValidNumber {
	public static void main(String[] args) {
		//Enter valid number
		Scanner ip = new Scanner(System.in);
			String text = null;
			int count = 0;
			
		do {
			System.out.println("Enter number: ");
			text = ip.nextLine();
			if (text.matches("[0-9]+")) {
				break;
			}
			if (count == 2) {
				System.out.println("You type wrong exceeds 3 times!");
				return;
			}
			count++;
		}while(true);

		
		
	int number = Integer.parseInt(text);
	System.out.println("Value: " + number);
		
	}
}