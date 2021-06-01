package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		
		System.out.println("Main start");
		Scanner ip = new Scanner(System.in);
		
//		int yob = ip.nextInt(); // input missmatchexception
		int yob = 0;
		int count = 0;
		while(true) {
			try {
				 System.out.println("Enter year of birth: ");
				 yob = Integer.parseInt(ip.nextLine());
				 break;
				 
			} catch (NumberFormatException e) {
				// contains exception information & root cause
//				e.printStackTrace();
//				System.out.println(e.getMessage());
				System.out.println("Invalid number " + ++count + " times");
				if (count == 3) {
					System.out.println("Exceed 3 times >>> OUT");
					break;
				}
			}
		}
		
		
		System.out.println("Age: " + (LocalDate.now().getYear() - yob + 1));
		System.out.println("Main end");
	}
	
}
