package homework;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("Nhap so n= ");
		Scanner ip = new Scanner(System.in);
		int number = ip.nextInt();
		if (isSDX(number)) {
			System.out.println(number + " la so doi xung");
			
		} else { 
			System.out.println(" khong la so doi xung");
		}
		
		
	}
	
	private static boolean isSDX(int number) {
		int checkingNum = number;
		int result = 0;
		if (number <= 10) {
			return false;
		}
		//121
		while(checkingNum!=0) {
			int temp = checkingNum%10;
			result = result*10 + temp;
			checkingNum = checkingNum/10;
		}
		
		if (result == number) {
			return true;
		}
		return false;
	}
	
}