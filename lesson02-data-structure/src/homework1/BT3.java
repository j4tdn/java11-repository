package homework1;

import java.util.Scanner;

public class BT3 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhap n = ");
		int n = ip.nextInt();
		if (isSDX(n)) {
			System.out.println("TRUE");
		}
		else {
			System.out.println("FALSE");
		}
	}
	private static boolean isSDX(int n) {
		int m=0;
		int n1 = n;
		while(n1!=0) {
			//12134
			int temp = n1 % 10;
			m = m*10 + temp;
			n1 = n1/10;
			
			//43121
		}
		if(m!=n) {
			return false;
		}
		return true;
		
	} 
	private static int isSDN(int n) {
		int m=0;
		int n1 = n;
		while(n1!=0) {
			//12134
			int temp = n1 % 10;
			m = m*10 + temp;
			n1 = n1/10;
			
			//43121
		}
		return m;
		
	}
	
}
