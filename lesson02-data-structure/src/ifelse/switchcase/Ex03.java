package ifelse.switchcase;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		int month;
		int daysInMonth = 0;
		Scanner sc = new Scanner(System.in);
		
		// 1 3 5 7 8 10 12
		// 4 6 9 
		// 2 
		month = sc.nextInt();
		switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
				daysInMonth = 31; 
				break;
			case 4: case 6: case 9: 
				daysInMonth = 30; 
				break;
			case 2: 
				daysInMonth = 28;
				break;
			default: 
				System.out.println("Invalid month");
				return; // ignore code below and stop void method
		}
		System.out.println("Month " + month + " has " + daysInMonth + " days.");
		
		
	}

}
