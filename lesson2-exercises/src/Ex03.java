import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("nhap n: ");
		long n = scanner.nextLong();
		if (check(n)) System.out.println(n + " la so doi xung");
		else System.out.println(n + " khong la so doi xung");
	}
	
	public static boolean check(long n) {
		long tmp = n;
		long m = 0;
		while(tmp!=0) {
			m = m*10 + tmp%10;
			tmp/=10;
		}
		return n==m ? true : false;
	}
}
