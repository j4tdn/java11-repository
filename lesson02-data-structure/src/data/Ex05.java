package data;

public class Ex05 {

	public static void main(String[] args) {
		Integer a = 10;
		Integer b = 20;
		swap(a,b);
		System.out.println("a : "+a);
		System.out.println("b : "+b);
		// TODO Auto-generated method stub

	}
	private static void swap(Integer f, Integer s) {
		Integer tmp;
		tmp = f;
		f = s;
		s = tmp;
	}

}