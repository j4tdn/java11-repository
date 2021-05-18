package student;

public class App {
	public static void main(String[] args) {
		Student sv1 = new Student(123,"LeVanPhu", 8f, 7f);
		Student sv2 = new Student(456,"LeVanA",5f,8f);
		Student sv3 = new Student();
		sv3.Nhap();
		
		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);
	}
}
