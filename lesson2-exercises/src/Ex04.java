import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("nhap so luong phan tu cua mang: ");
		int n = scanner.nextInt();
		int[] a = new int[n];
		if (n > 0) {
			System.out.println("nhap cac phan tu: ");
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
		}
		System.out.println(oddMax(a));
	}

	public static int oddMax(int[] a) {
		if (a.length == 0)
			return -1;
		if (a.length == 1)
			return a[0];
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0 && a[i] > max)
				max = a[i];
		}
		return max;
	}
}
