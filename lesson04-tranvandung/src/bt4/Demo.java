package bt4;

public class Demo {
	public static void main(String[] args) {
		People p1 = new GiamDoc();
		p1.input();
		System.out.println();
		People p2 = new TruongPhong();
		p2.input();
		System.out.println();
		People p3 = new NhanVien();
		p3.input();
		System.out.println();
		People p4 = new NhanVien();
		p4.input();

		System.out.print("Bang Giam Doc");
		p1.output();
		System.out.print("Bang Truong Phong");
		p2.output();
		System.out.print("Bang Nhan Vien 1");
		p3.output();
		System.out.print("Bang Nhan Vien 2");
		p4.output();

	}
}
