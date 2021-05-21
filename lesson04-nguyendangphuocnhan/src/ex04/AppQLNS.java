package ex04;

import java.util.Scanner;

public class AppQLNS {
	public static void main(String[] args) {
		People gd = new GiamDoc();
		People tp = new TruongPhong();
		People nv1 = new NhanVien();
		People nv2 = new NhanVien();

		nhapTTGD((GiamDoc) gd);
		nhapTTTP((TruongPhong) tp);
		nhapTTNV((NhanVien) nv1);
		nhapTTNV((NhanVien) nv2);
		
		System.out.println("==============================");
		System.out.println("Giám Đốc: ");
		System.out.println("==============================");
		System.out.println("Họ tên: " + gd.getHoTen());
		System.out.println("Năm sinh: " + gd.getNamSinh());
		System.out.println("Hệ số lương: " + gd.getHsLuong());
		System.out.println("Hệ số chức vụ: " + gd.toString());
		System.out.println("Lương: " + gd.luong() + " VNĐ");
		
		System.out.println("==============================");
		System.out.println("Trưởng phòng: ");
		System.out.println("==============================");
		System.out.println("Họ tên: " + tp.getHoTen());
		System.out.println("Năm sinh: " + tp.getNamSinh());
		System.out.println("Hệ số lương: " + tp.getHsLuong());
		System.out.println("Số lượng nhân viên quản lý: " + tp.toString());
		System.out.println("Lương: " + tp.luong() + " VNĐ");
		
		System.out.println("==============================");
		System.out.println("Nhân viên 1: ");
		System.out.println("==============================");
		System.out.println("Họ tên: " + nv1.getHoTen());
		System.out.println("Năm sinh: " + nv1.getNamSinh());
		System.out.println("Hệ số lương: " + nv1.getHsLuong());
		System.out.println("Đơn vị: " + nv1.toString());
		System.out.println("Lương: " + nv1.luong() + " VNĐ");
		
		System.out.println("==============================");
		System.out.println("Nhân viên 2: ");
		System.out.println("==============================");
		System.out.println("Họ tên: " + nv2.getHoTen());
		System.out.println("Năm sinh: " + nv2.getNamSinh());
		System.out.println("Hệ số lương: " + nv2.getHsLuong());
		System.out.println("Đơn vị: " + nv2.toString());
		System.out.println("Lương: " + nv2.luong() + " VNĐ");
	}

	private static Scanner ip = new Scanner(System.in);

	public static void nhapThongTin(People ppl) {
		System.out.print("Nhập họ tên: ");
		ppl.setHoTen(ip.nextLine());
		System.out.print("Nhập năm sinh: ");
		ppl.setNamSinh(Integer.parseInt(ip.nextLine()));
		System.out.print("Nhập hệ số lương: ");
		ppl.setHsLuong(Float.parseFloat(ip.nextLine()));
	}

	public static void nhapTTGD(GiamDoc gd) {
		nhapThongTin(gd);
		System.out.print("Nhập hệ số chức vụ: ");
		gd.setHsChucVu(Float.parseFloat(ip.nextLine()));

	}

	public static void nhapTTTP(TruongPhong tp) {
		nhapThongTin(tp);
		System.out.print("Nhập số lượng nhân viên quản lý: ");
		tp.setSlnvQuanLy(Integer.parseInt(ip.nextLine()));
	}

	public static void nhapTTNV(NhanVien nv) {
		nhapThongTin(nv);
		System.out.print("Nhập tên đơn vị (phòng/ban): ");
		nv.setDonVi(ip.nextLine());
	}

}
