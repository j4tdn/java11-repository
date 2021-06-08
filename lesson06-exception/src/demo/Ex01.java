package demo;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("Main start");
		
		Scanner ip = new Scanner(System.in);
		
		//int yob = ip.nextInt(); // input Mismatch Exception
		int yob = 0;
		int count = 0;
		while(true) {
			
				try {
					System.out.println("Enter year of birth: ");
					 yob = Integer.parseInt(ip.nextLine());
					 break;
						
					
				} catch (NumberFormatException e) {
					//contains exception information & root case: nguyen nhan loi 
					//e.printStackTrace();
					//System.out.println(e.getMessage());
					System.out.println("Invalid Number " + ++count + " times");
					//count++;
					 if (count ==3) {
						 System.out.println("Wrong entering times exceed 3 times >> OUT");
					 
					 break;
				 }
				}
				
			}
		
		if (yob !=0) {
			System.out.println("age: " + (LocalDate.now().getYear() - yob + 1));
		}
		
		System.out.println("Main end");
	}
}
