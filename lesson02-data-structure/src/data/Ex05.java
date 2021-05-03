package data;

public class Ex05 {
	public static void main(String[] args) {
		Integer a = 10;
		Integer b = 20;
		swap(a, b);
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("Hash code a: " +  System.identityHashCode(a));
		System.out.println("Hash code b: " +  System.identityHashCode(b));
	
	}
	private static void swap(Integer f, Integer s) {
		Integer tmp = f;
		f = s;
		s = tmp;
		System.out.println("Hash f: " +System.identityHashCode(f));
		System.out.println("Hash s:" + System.identityHashCode(s));
		System.out.println("Hash tmp: " +  System.identityHashCode(tmp));
		System.out.println("f: " + f);
		System.out.println("s: " + s);
	}

}
