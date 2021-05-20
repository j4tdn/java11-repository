package bai04;

public class App {
	public static void main(String[] args) {
		People gd = new GiamDoc("Vuong", 1986, 4, 3);
		People tp = new TruongPhong("Kieu", 1990, 3, 2);
		People nv1 = new NhanVien("Son", 1994, 2, "Nhan su");
		People nv2 = new NhanVien("Thuy", 1994, 2, "Nhan su");
		
		System.out.printf("\n%-20s%-10s%10s%20s\n","Chuc vu", "Ten", "Nam sinh", "Luong");
		System.out.println("==================================================================================");
		System.out.printf("\n%-20s%-10s%10s%20s\n","Giam Doc", gd.getHoten(), gd.getNamsinh(),gd.getLuong());
		System.out.printf("\n%-20s%-10s%10s%20s\n","Truong Phong", tp.getHoten(), tp.getNamsinh(),tp.getLuong());
		System.out.printf("\n%-20s%-10s%10s%20s\n","Nhan Vien", nv1.getHoten(), nv1.getNamsinh(),nv1.getLuong());
		System.out.printf("\n%-20s%-10s%10s%20s\n","Nhan Vien", nv2.getHoten(), nv2.getNamsinh(),nv2.getLuong());
		
		
	}
}
