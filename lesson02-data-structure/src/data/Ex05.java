package data;

public class Ex05 {
	public static void main(String[] args) {
		Integer a = 10;
		Integer b = 20;
		utils.PrintUtils.hash("hash a", a);
		utils.PrintUtils.hash("hash b", b);
		swap(a, b);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
	}

	private static void swap(int f, int s) {
		int temp = f;
		f = s;
		s = temp;
		utils.PrintUtils.hash("hash f", f);
		utils.PrintUtils.hash("hash s", s);
	}
}
