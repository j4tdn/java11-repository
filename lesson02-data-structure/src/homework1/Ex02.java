package homework1;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhap vao so: ");
		int number = ip.nextInt();
		if (isSDX(number)) {
			System.out.println(number + " la so doi xung");
		}
		else System.out.println(number + " Khong la so doi xung");
		
		System.out.println("==================");
		System.out.println(isSND(number));
		System.out.println("===========");
		System.out.println(demso(number));
	}
	private static boolean isSDX(int number) {
		//121
		if (number <=10 ) return false;
		int result = 0;
		int checkingNumber = number;
		while(checkingNumber != 0) {
			int temp = checkingNumber%10;
			result = result*10 +temp;
			checkingNumber = checkingNumber/10;
		}
		if (number == result) { 
			return true;
		}	
		return false;
	}
	private static int isSND(int number) {
		//12345
		int result = 0;
		int checkingN = number;
		while(checkingN !=0) {
			int temp = checkingN%10;
			result = result*10 +temp;
			checkingN = checkingN/10;
		}
		return result;
	}
	
	private static int demso(int number) {
		//1234
		int count =0;
		int checkingNumb = number;
		while (checkingNumb != 0) {
			checkingNumb = checkingNumb/10;
			count++;
		} 
		
		return count;
	}
}


	