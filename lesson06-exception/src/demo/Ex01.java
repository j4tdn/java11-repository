package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("Main start");
		Scanner ip = new Scanner(System.in);
		// int yob = ip.nextInt(); // inputMismatchException
		int yob = 0;
		int cout = 0;
		while(true){
			try { 
			System.out.println("Enter year of birth: ");
			 yob = Integer.parseInt(ip.nextLine());
			 break;
		} catch (NumberFormatException e) {
			// contains exception information & root cause
			// e.printStackTrace();
            // System.out.println(e.getMessage());
			System.out.println("Invalid number " + ++cout + " times");
		}
			if(cout == 3 ) {
				System.out.println("Ban da nhap qua 3 lan");
				break;
			}
	}
		if(yob != 0) {
			System.out.println("Age: " + (LocalDate.now().getYear() - yob + 1));
		}
		System.out.println("Main End");
	}
	
}
