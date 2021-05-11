package excersise;

import java.math.BigDecimal;
import java.util.Scanner;

import bean.Vehicle;

public class Ex02 {
	static final int length = 10;
	static int count = 0;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Vehicle[] listVehicle = new Vehicle[length];
		Tax[] tax = Tax.values();

		String menu = "1. Nhập thông tin và tạo các đối tượng.\n"
				+ "2. Xuất bảng kê khai tiền thuế trước bạ của các xe.\n" + "3. Thoát.\n" + "Nhập lựa chọn: ";
		int key = 0;
		while (true) {
			System.out.print(menu);
			key = Integer.parseInt(sc.nextLine());
			switch (key) {
			case 1:
				input(listVehicle);
				break;
			case 2:
				output(listVehicle, tax);
				break;
			case 3:
				System.exit(0);

			default:
				System.out.println("Không hợp lệ");
			}
		}
	}

	private static void output(Vehicle[] listVehicle, Tax[] tax) {
		for (int i = 0; i < count; i++) {
			listVehicle[i].setThue(tinhThue(listVehicle[i], tax));
			System.out.println(listVehicle[i]);
		}

	}

	private static float tinhThue(Vehicle vehicle, Tax[] tax) {
		if (vehicle.getDungTich() < 100) {
			return vehicle.getTriGia() * tax[0].getValue();
		}
		if (vehicle.getDungTich() >= 100 && vehicle.getDungTich() <= 200) {
			return vehicle.getTriGia() * tax[1].getValue();
		}
		if (vehicle.getDungTich() >= 200) {
			return vehicle.getTriGia() * tax[2].getValue();
		}
		return 0;
	}

	private static void input(Vehicle[] listVehicle) {
		System.out.print("Nhập tên chủ xe: ");
		String ownerName = sc.nextLine();
		System.out.print("Nhập loại xe: ");
		String model = sc.nextLine();
		System.out.print("Nhập dung tích xe: ");
		int volCylinder = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập giá xe: ");
		long price = Long.parseLong(sc.nextLine());

		listVehicle[count++] = new Vehicle(ownerName, model, volCylinder, price);

	}

}

enum Tax {
	CC100("0.01"), CC100_200("0.03"), CC200("0.05");

	private String value;

	private Tax(String value) {
		this.value = value;
	}

	float getValue() {
		return Float.parseFloat(value);
	}
}