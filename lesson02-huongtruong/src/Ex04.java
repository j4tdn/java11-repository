

public class Ex04 {
	public static void main(String[] args) {
		int[] day = { 11, 12, 15, 21, 24, 25 };
		int[] le = new int[day.length];
		int d = 0;
		for (int i = 0; i < day.length; i++) {
			if (day[i] % 2 != 0) {
				le[d] = day[i];
				d++;

			}
		}
		int temp;
		for (int i = 0; i < le.length; i++) {
			for (int j = le.length - 1; j >= 1; j--) {
				if (le[j] < le[j - 1]) {
					temp = le[j];
					le[j] = le[j - 1];
					le[j - 1] = temp;
				}
			}
		}
		System.out.println("số lẻ lớn thứ nhất trong mảng là: " + le[le.length - 1]);

	}
}