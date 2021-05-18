package student;

public class App {
	public static void main(String[] args) {
		Student sv1 = new Student(123,"LeVanPhu", 7, 8);
		Student sv2 = new Student(423,"LeVanB", 8, 6);
		Student sv3 = new Student();
		sv3.input();
		
		
		
		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);
		
	}
}
