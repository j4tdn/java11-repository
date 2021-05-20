package baitap04;

public class App {

	public static void main(String[] args) {
		System.out.println("Nhập Nhân Viên");
		People nv1 = new NhanVien();
		nv1.Nhap();
		
		People nv2 = new NhanVien();
		nv2.Nhap();
		System.out.println("==================");
		System.out.println("Nhập Giám Đốc");
		People gd1 = new GiamDoc();
		gd1.Nhap();

		System.out.println("==================");
		System.out.println("Nhập Trưởng Phòng");
		People tp1 = new TruongPhong();
		tp1.Nhap();
		
		System.out.println(nv1);
		System.out.println(nv2);
		System.out.println(gd1);
		System.out.println(tp1);
	
		
	}
}
