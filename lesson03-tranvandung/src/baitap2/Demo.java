package baitap2;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {

		User u1 = new User("US1", "VanDung", "123");
		User u2 = new User("US2", "CongChuong", "234");
		User u3 = new User("US3", "VanHai", "345");
		User u4 = new User("US4", "QuocHung", "456");

		Vehicle v1 = new Vehicle("Kawasaki", "Black", 100, 2540);
		Vehicle v2 = new Vehicle("Wave", "Red", 50, 2540);
		Vehicle v3 = new Vehicle("Ab", "Black", 150, 4000);
		Vehicle v4 = new Vehicle("Sh", "Black", 190, 60000);

		Taxstaff t1 = new Taxstaff(u1, v1);
		Taxstaff t2 = new Taxstaff(u2, v2);
		Taxstaff t3 = new Taxstaff(u3, v3);
		Taxstaff t4 = new Taxstaff(u4, v4);

		Taxstaff[] ts = new Taxstaff[4];
		ts[0] = t1;
		ts[1] = t2;
		ts[2] = t3;
		ts[3] = t4;

		int chose = 0;
		do {
			System.out.println("===== Bang chon cong viec =====");
			System.out.println("1. Nhap thong tin va tao doi tuong.");
			System.out.println("2. Xuat bang ke.");
			System.out.println("3. Thoat");
			Scanner ip = new Scanner(System.in);
			System.out.print(" Lua chon cong viec: ");
			chose = ip.nextInt();
			switch (chose) {
			case 1: {
				Vehicle vo1 = Utils.input();
				Vehicle vo2 = Utils.input();
				Vehicle vo3 = Utils.input();
				Vehicle vo4 = Utils.input();

				Taxstaff to1 = new Taxstaff(u1, vo1);
				Taxstaff to2 = new Taxstaff(u2, vo2);
				Taxstaff to3 = new Taxstaff(u3, vo3);
				Taxstaff to4 = new Taxstaff(u4, vo4);

				ts[0] = to1;
				ts[1] = to2;
				ts[2] = to3;
				ts[3] = to4;
				break;
			}
			case 2: {
				System.out.printf("\n%-20s%-20s%10s%20s%20s\n", "Ten chu xe", "Loai xe", "Dung tich", "Gia tien",
						"Thue");
				System.out.println(
						"==========================================================================================");
				for (Taxstaff item : ts) {
					System.out.printf("\n%-20s%-20s%10s%20s%20s\n", item.getUser().getName(),
							item.getVehicle().getModel(), item.getVehicle().getCapacity(), item.getVehicle().getCost(),
							Utils.export(item));
				}
				break;
			}

			case 3: {
				return;
			}
			}
		} while (chose != 0);
	}
}
