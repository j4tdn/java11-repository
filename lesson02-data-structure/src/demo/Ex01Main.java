package demo;

public class Ex01Main {
	public static void main(String[] args) {
		System.out.println("Hello 01");
		main();
	}
	public static void publicStaticMethod() {
		System.out.println("publicstaticmethod");
	}
	public static void main() {
		System.out.println("Hello 02");
		Ex02Main s;
		
	}

}
 class Ex02Main {
	public static void main(String[] args) {
		System.out.println("hello 03");
	}
}
