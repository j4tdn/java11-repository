package untils;

public class ArrayUtils {
	private ArrayUtils() {
	}

	public static void printf(int[] elements) {
		for (var element : elements) {
			System.out.println(element + " ");
		}
	}

	public static void printf(Object[] elements) {
		for (var element : elements) {
			System.out.println(element + " ");
		}
	}

	public static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
