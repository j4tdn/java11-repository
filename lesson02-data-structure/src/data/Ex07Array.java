package data;

public class Ex07Array {
	public static void main(String[] args) {
		int[] a = new int[5];
		String[] b = new String[4];
		
		a[1] = 10;
		b[3] = "hello";
		
		System.out.println("a[1]: " + a[1]);
		System.out.println("b[3]: " + b[3]);
		
		int[] c = {3, 4, 5, 6};
		System.out.println("c[1]: " + c[1]);
		
		for (int i = 0; i < c.length; i++) {
			System.out.println("c["+ i +"]: " + c[i]);
		}
		
		for (int i: a) {
			System.out.println(i);
		}
	}
}
