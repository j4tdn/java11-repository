import java.util.Scanner;
public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("nhap n: ");
		int n = scanner.nextInt();
		if (check(n))
			System.out.println(n+" la luy thua cua hai");
		else
			System.out.println(n+ " khong phai la luy thua cua hai");
	}

	public static boolean check(int n) {
		if (n <= 0)
			return false;
		while (n != 1) {
			if (n % 2 == 0)
				n = n / 2;
			else
				return false;
		}
		return true;
	}
}
