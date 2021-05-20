package bai01;

public class App {
	public static void main(String[] args) {
		Student s1 = new Student(01, "Huy", 6.5f, 6.5f);
		Student s2 = new Student(02, "Thanh", 7.0f, 7.0f);
		Student s3 = new Student();
		s3.input();
		
		System.out.printf("\n%-20s%-20s%10s%20s%20s\n","Masv", "Tensv", "DiemLT", "DiemTH", "DiemTB");
		System.out.println("=================================================================================================s");
		System.out.printf("\n%-20s%-20s%10s%20s%20s\n",s1.getMasv(), s1.getName(), s1.getDiemLT(), s1.getDiemTH(), s1.diemTB());
		System.out.printf("\n%-20s%-20s%10s%20s%20s\n",s2.getMasv(), s2.getName(), s2.getDiemLT(), s2.getDiemTH(), s2.diemTB());
		System.out.printf("\n%-20s%-20s%10s%20s%20s\n",s3.getMasv(), s3.getName(), s3.getDiemLT(), s3.getDiemTH(), s3.diemTB());
	}
}
