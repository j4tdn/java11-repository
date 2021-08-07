package ex04;

import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static String[] StrDigit = {"không", "một" , "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín", "mười"};

	public static String[] StrUnit = {"nghìn ", "triệu ", "tỷ "}; 

	public static void main(String[] args) {
		long number;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter number: ");
		number = sc.nextLong();
		int[] strNum = new int[10];
		int mod = -1;
		int count = 0;
		while (number > 0) {
			mod = (int)(number % 1000);
			
			if (mod == 0) strNum[count++] = (int)number;
			else strNum[count++] = (int)mod;
			number = number / 1000;		 
		}

		int[] strNumInit = Arrays.copyOfRange(strNum, 0, count-1);

		int t_lengthOfStrNum = strNumInit.length;
		for (int i = strNumInit.length - 1; i >= 0 ; i--) {

			String temp = Integer.toString(strNumInit[i]);
			int giao = strNumInit[i];
			int[] strNum1 = new int[10];
			int mod1 = -1;
			int count1 = 0;
			if (temp.length() != 1) {
				while (giao > 0) {
					mod1 = giao % 10;	
					if (mod1 == 0 && giao > 9 ) strNum1[count1++] = 0;
					else if (mod1 == 0 && giao <= 9 ) strNum1[count1++] = giao;
					else if (mod1 != 0) strNum1[count1++] = mod1;
					giao = giao / 10;		 
				}                             
				int[] strNum2 =  new int[count1];
				strNum2 = Arrays.copyOfRange(strNum1, 0, count1 - 1);
				int t_length = strNum2.length;
				for (int j = strNum2.length - 1; j >= 0; j--) {
					convertToString(strNum2[j], t_length);
					t_length--;
				}
				checkLength(t_lengthOfStrNum);
			}
			else 
			{
				convertToString(strNumInit[i],1);				
				checkLength(t_lengthOfStrNum);
			}

			t_lengthOfStrNum--;

		}
	}
	
	public static void checkLength(int length) {
		
		if (length == 4) {
			System.out.print(StrUnit[2]);
		}
		else if (length == 3) {
			System.out.print(StrUnit[1]);
		}
		else if (length == 2) {
			System.out.print(StrUnit[0]);
		}
	}

	public static void convertToString(int num, int length) {

		switch (length) {
		case 3:
			if (num >= 1) {
				System.out.print(StrDigit[num] + " trăm ");
			}	
			else System.out.print(StrDigit[num] + " trăm ");
			break;
		case 2:
			if (num > 1) {
				System.out.print(StrDigit[num] +" ");
			}
			else if (num == 1) System.out.print(" mười ");
			else System.out.print(" lẻ ");
			break;
		case 1:
			if (num != 0) {
				System.out.print(StrDigit[num] + " ");
			}
			else System.out.print("");
			break;

		default:
			break;
		}

	}
	
}
