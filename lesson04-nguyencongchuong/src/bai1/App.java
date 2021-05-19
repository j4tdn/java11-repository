package bai1;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		SinhVien sv1 = new SinhVien(111, "Nguyễn Công Chương", 7.5f, 8.0f);
		SinhVien sv2 = new SinhVien(112, "Trần Văn Dũng", 8.5f, 8.2f);
		SinhVien sv3 = new SinhVien();
		input(sv3);

		System.out.printf("\n%-20s%-20s%10s%20s%20s\n", "MSSV", "Họ tên", "Điểm LH", "Điểm TH", "Điểm TB");
		System.out.printf("\n%-20s%-20s%10s%20s%20s\n", sv1.getMSV(), sv1.getName(), sv1.getLH(), sv1.getTH(),
				Avg.export(sv1));
		System.out.printf("\n%-20s%-20s%10s%20s%20s\n", sv2.getMSV(), sv2.getName(), sv2.getLH(), sv2.getTH(),
				Avg.export(sv2));
		System.out.printf("\n%-20s%-20s%10s%20s%20s\n", sv3.getMSV(), sv3.getName(), sv3.getLH(), sv3.getTH(),
				Avg.export(sv3));

	}

	private static void input(SinhVien sv) {

		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập MSV: ");
		sv.setMSV(ip.nextInt());

		System.out.print("Nhập họ và tên: ");
		ip.nextLine();
		sv.setName(ip.nextLine());

		System.out.print("Nhập điểm LH: ");
		sv.setLH(ip.nextFloat());

		System.out.print("Nhập điểm TH: ");
		sv.setTH(ip.nextFloat());
	}
}
