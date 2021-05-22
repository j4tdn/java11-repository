package exercise2;

public class App {
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 2, 1, 6, 5 };
		int[] arr1 = new int[] {3, 7, 9, 2, 1, 6, 5, 4, 10};
		System.out.println("Phan tu can tim co gia tri: " + getMissingNumber(arr));
	}
	private static int getMissingNumber(int[] numList) {
		String str = "";
		for (int i : numList) {
			str += i;
		}
		for (int i = 1; i <= numList.length + 1; i++) {
			if (!str.contains("" + i)) {
				return i;
			}
		}
		return -1;
	}
}
