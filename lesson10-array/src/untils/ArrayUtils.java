package untils;

public class ArrayUtils {
	private ArrayUtils() {
	}

	public static void printf(int[] elements) {
		for (var element : elements) {
			System.out.println(element + " ");
		}
	}
}
