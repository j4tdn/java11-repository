package functional;

public class Ex02 {
	public static void main(String[] args) {
		
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		count(a, num -> num % 3 == 0);
		count(a, num -> num % 5 == 0);
		count(a, num -> num % 7 == 0);
	}

	public static void count(int[] a, Condition con) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (con.test(a[i])) {
				count++;
			}
		}
		System.out.println(count);
	}
	
}