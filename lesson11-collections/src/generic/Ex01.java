package generic;

public class Ex01{
	public static void main(String[] args) {
		// generic represents for object type only
	
		Integer[] ints = {1, 2, 5, 4, 3};
		Double[] doubles = {1d, 2d, 5d, 4d, 3d};
		Float[] floats = {1f, 2f, 5f, 4f, 3f};
		printf(ints);
	}
	
	private static <E extends Number> void printf(E[] elements) {
		for(E element: elements) {
			System.out.print(element +" ");
		}
		System.out.println();
	}
}