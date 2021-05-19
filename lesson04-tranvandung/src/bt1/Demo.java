package bt1;

public class Demo {
	public static void main(String[] args) {
		Students s1 = new Students(1, "TranVanDung", 10f, 10f);
		Students s2 = new Students(2, "DaoNgocVu", 9f, 9f);
		Students s3 = new Students();
		s3.input();

		System.out.printf("\n%-20s%-20s%10s%20s%20s\n", "MaSV", "Name", "DiemLT", "DiemTH", "DiemTB");
		System.out.println("==============================================================================================");
		System.out.printf("%-20s%-20s%10s%20s%20s\n", s1.getMaSV(), s1.getName(), s1.getDiemLT(), s1.getDiemTH(),s1.diemTB());
		System.out.printf("%-20s%-20s%10s%20s%20s\n", s2.getMaSV(), s2.getName(), s2.getDiemLT(), s2.getDiemTH(),s2.diemTB());
		System.out.printf("%-20s%-20s%10s%20s%20s\n", s3.getMaSV(), s3.getName(), s3.getDiemLT(), s3.getDiemTH(),s3.diemTB());
	}
}
