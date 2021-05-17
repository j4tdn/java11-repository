package bai01;


public class App {
	public static void main(String[] args) {
		Student sv1 = new Student(123,"Tran Thi Anh Dao",8,8);
		Student sv2 = new Student(456,"Mai Vo Hoai Thuong",9.5f,8);
		Student sv3 = new Student();
		sv3.InputInformation();
		
		System.out.println("MaSV         Hoten             DlT       DTH       DTB");
		System.out.printf("%-10d  %-10s  %-10.2f %-10.2f %-10.2f\n",
				sv1.getMaSV(),sv1.getHoten(),sv1.getDiemLT(),sv1.getDiemTH(),sv1.DiemTB());
		System.out.printf("%-10d  %-10s  %-10.2f %-10.2f %-10.2f\n",
				sv2.getMaSV(),sv2.getHoten(),sv2.getDiemLT(),sv2.getDiemTH(),sv2.DiemTB());
		System.out.printf("%-10d  %-10s  %-10.2f %-10.2f %-10.2f\n",
				sv3.getMaSV(),sv3.getHoten(),sv3.getDiemLT(),sv3.getDiemTH(),sv3.DiemTB());
	}

}
