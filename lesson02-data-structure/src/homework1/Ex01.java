package homework1;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		//System.out.println("Nhap vao so n: ");
		//int number = ip.nextInt();
//		System.out.println(isSDX(number));
//		System.out.println("=============");
//		System.out.println("so dao nguoc cua " + number + " la: " + isSO(number));
//		System.out.println("so chu so cua " + number + " la: " + demSo(number));

		//System.out.println(giaiThua(number));
		System.out.println();
		System.out.println(C(4,6));
	}
	private static long C(long k, long n) {
		if (k==0 || k==n) {
			return 1;
		}
		if (k==1 || k ==n-1) {
			return n;
		}
		return C(k-1,n-1) + C(k,n-1);
	}
	private static boolean isSDX(int number) {
		if (number <=10) return false;
		//121
		int result = 0;
		int checkingNumber = number;
		while(checkingNumber!=0) {
			int temp = checkingNumber%10;
			result = result*10 + temp;
			checkingNumber = checkingNumber/10;
		}
		if (result == number)
		{return true;
		
		}
		
		return false;
	}
	
	private static int isSO(int number) {
		int result = 0;
		int checkingNumber = number;
		while(checkingNumber != 0) {
			int temp = checkingNumber%10;
			result = result*10 +temp;
			checkingNumber = checkingNumber/10;
		}
		return result;
	  }
	
	private static int demSo(int number) {
		int count = 0;
		//1234
		int checkingNumber = number;
		while(checkingNumber!=0) {
			checkingNumber /=10;
			count++;
		}
		return count;
	}
	
	private static long giaiThua(long n) {
		if(n ==0 || n == 1) return 1;
		return n* giaiThua(n-1);
	}
}

	
