import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		System.out.println(isPalindrome(rd.nextInt()));
	}

	private static boolean isPalindrome(int number) {
		int temp = 0, root = number;
		while (number > 0) {
			temp = temp * 10 + number % 10;
			number /= 10;
		}
		return temp == root ? true : false;
	}
}
