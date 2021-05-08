package exercise;

import java.util.Scanner;

import org.w3c.dom.Text;

public class Ex001Validwords {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		String text = null;
		int count = 0;
	
		do {
			System.out.println("Enter Name: ");
			 text = ip.nextLine();
			if (text.matches("[A-Z]+") || (text.matches("[a-z]+")) ) {
				break;
			}
			if (count == 3) {
				System.out.println("Wrong exceeds 3 times!");
				return;
			} count++;
			
		} while(true);

		
		String a = new String(text);
		System.out.println("Name: " + a);
	}
}
