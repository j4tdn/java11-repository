package ex05;

public class App {
	public static void main(String[] args) {
		Sach[] sach = new Sach[5];
		SachGK gk1 = new SachGK("SGK01", 20d, "Nhi Dong", "Moi");
		SachGK gk2 = new SachGK("SGK02", 30d, "Nhat Dong", "Cu");
		SachGK gk3 = new SachGK("SGK03", 60d, "Kim Dong", "Moi");

		SachTK tk1 = new SachTK("STK01", 20d, "Nhat Dong", 20);
		SachTK tk2 = new SachTK("STK02", 30d, "Nhat Dong", 20);

		sach[0] = gk1;
		sach[1] = gk2;
		sach[2] = gk3;
		sach[3] = tk1;
		sach[4] = tk2;

		System.out.println("===== Bo Sach Thuoc Nha Xuat Ban Nhi Dong =======");
		timNXB(sach, "Nhi Dong");

		System.out.println("===== Bo Sach Don Gia < 50 =======");
		timSach(sach, 50d);

		System.out.println("===== Dong Gia Cua KhacH Hang La =======");
		Sach[] sach2 = new Sach[2];
		sach2[0] = gk1;
		sach2[1] = gk2;
		System.out.println(tongtien(sach2));
	}

	public static void timNXB(Sach[] sach, String n) {
		Sach[] B = new Sach[5];
		int i = 0;
		for (Sach item : sach) {
			if (item.getNhaXB() == n) {
				B[i] = item;
				i++;
			}
		}
		for (Sach item : B) {
			System.out.println(item.toString());
		}
	}

	public static void timSach(Sach[] sach, double n) {
		Sach[] B = new Sach[5];
		int i = 0;
		for (Sach item : sach) {
			if (item.getDonGia() < n) {
				B[i] = item;
				i++;
			}
		}
		for (Sach item : B) {
			System.out.println(item.toString());
		}
	}

	public static double tongtien(Sach[] sach) {
		double tongtien = 0;
		for (Sach item : sach) {
			tongtien = tongtien + item.tinhtien();
		}
		return tongtien;
	}
}
