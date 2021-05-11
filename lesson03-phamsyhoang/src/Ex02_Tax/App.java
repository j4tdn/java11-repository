package Ex02_Tax;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		Person[] p = new Person[3];
		Vehicle[] v = new Vehicle[3];
		System.out.println("Chọn công việc: ");
		System.out.println("1. Nhập thông tin: ");
		System.out.println("2. Xuất bảng kê khai tiền thuế trước bạ của các xe: ");
		System.out.println("3. Thoát: ");
		int cv = ip.nextInt();
		switch (cv) {
		case 1: {
			for (int i = 0; i < 3; i++) {
				System.out.print("Tên chủ xe: ");
				p[i] = new Person(ip.next());
				System.out.print("Loại xe: ");
				String type = ip.next();
				System.out.print("Dung tích: ");
				int cylinder = ip.nextInt();
				System.out.print("Trị giá: ");
				Double cost = ip.nextDouble();
				v[i] = new Vehicle(type, cylinder, cost);
			}
			break;

		}
		case 2: {
			System.out.println("\nTên chủ xe\t" + "Loại xe\t\t" + "Dung tích\t" + "Trị giá\t\t" + "Thuế phải nộp\n");
			System.out.println("===================================================================================");
			for (int i = 0; i < 3; i++) {
				System.out.println(p[i].getName() + "\t\t" + v[i].getType() + "\t\t" + v[i].getCylinder() + "\t\t"
						+ v[i].getCost() + "\t\t" + ScheduleUtils.Schedule(v[i]) + "\n");
			}
		}
		case 3: {
			return;
		}

		}

	}
}
