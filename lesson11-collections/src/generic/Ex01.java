package generic;

public class Ex01 {
	public static void main(String[] args) {
		// generic represents for object type only

		Integer[] ints = { 1, 2, 3, 4, 5 };
		Double[] doubles = { 1d, 2d, 3d, 4d, 5d };
		Float[] floats = { 1f, 2f, 3f, 4f, 5f };
		String[] strings = { "a", "b", "c", "d", "e" };

		printf(ints);
		printf(doubles);
		printf(floats);
		// printf(strings); String is not child of Number

	}

	// E: generic type
	// <E>: declaration, E's scope: method
	// E[]: using
	// Generic: extends: Upper Bound Type
	private static <E extends Number> void printf(E[] elements) {
		for (E element : elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

}
