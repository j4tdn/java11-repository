package bai04;

public class App {
  public static void main(String[] args) {
	 GiamDoc gd1 = new GiamDoc();
	 gd1.nhap();
	 
	 TruongPhong tp1 = new TruongPhong();
	 tp1.nhap();
	 
	 NhanVien nv1 = new NhanVien();
	 nv1.nhap();
	 
	 NhanVien nv2 = new NhanVien();
	 nv2.nhap();
	 
	 System.out.println(gd1);
	 System.out.println(tp1);
	 System.out.println(nv1);
	 System.out.println(nv2);
	 
}
}
