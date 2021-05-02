package baitap;

public class Bt06 {
	public static void main(String[] args) {
		int n = 100000;
		int count = 0;
		for (int i = 2; i < n; i++) {
			boolean check = true;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0)
					check = false;
			}
			if (check)
				count++;
			if (count == 200) {
				System.out.println("so nguyen to thu 200 la: " + i);
				break;
			}
		}
	}
}
