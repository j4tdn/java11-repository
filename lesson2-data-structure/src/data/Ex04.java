package data;

public class Ex04 {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		Integer c = 20;
		swap(a, b);
		System.out.println(a);
		System.out.println(b);
	}

	private static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}

	private static void swap(Integer a, Integer b) {
		Integer tmp = a;
		a = b;
		b = tmp;
	}

}
