package Ex01;

public class ArrayUtils {
	private ArrayUtils() {

	}

	public static void printf(int[] elements) {
		for (int element : elements) {
			System.out.print(element + " ");
		}

		System.out.println();

	}
}
