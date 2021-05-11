package exercise02;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Owner o1 = new Owner( "123","Trần Quốc Hưng", "Bình Định");
		Owner o2 = new Owner( "456","Đặng Văn Hải", "Quản Nam");
		Owner o3 = new Owner( "789","Trần Văn Dũng", "Đà Năng");

		Vehicle ve1 = new Vehicle("Vison", "Black", 50000, 250);
		Vehicle ve2 = new Vehicle("AirBlade", "Blue", 60000, 150);
		Vehicle ve3 = new Vehicle("Surius", "Red", 25000, 150);
		Manager ma1 = new Manager(o1, ve1);
		Manager ma2 = new Manager(o2, ve2);
		Manager ma3 = new Manager(o3, ve3);
		Manager[] ArrManager = new Manager[3];
		ArrManager[0] = ma1;
		ArrManager[1] = ma2;
		ArrManager[2] = ma3;
		int number = 0;
		System.out.println("==== Please Enter Your Choose ====");
		System.out.println("1.Enter Vehicle");
		System.out.println("2.Export Vehicle Tax");
		System.out.println("3.Exit");
		Scanner scanner = new Scanner(System.in);
		System.out.print("**Enter number choose :  ");
		number = scanner.nextInt();
		switch (number) {
		case 1: {
			Vehicle v1 = VehicleUtils.inputVehicle();
			Vehicle v2 = VehicleUtils.inputVehicle();
			Vehicle v3 = VehicleUtils.inputVehicle();

			Manager m1 = new Manager(o1, v1);
			Manager m2 = new Manager(o2, v2);
			Manager m3 = new Manager(o3, v3);
			ArrManager[0] = m1;
			ArrManager[1] = m2;
			ArrManager[2] = m3;
		}
		case 2: {
			System.out.printf("\n%-20s%-20s%10s%20s%20s\n", "Name owner","Vehicle owner", "Model", "Capacity", "Cost",
					"Registration tax");
			System.out.println(
					"==========================================================================================");
			for (Manager item : ArrManager) {
				System.out.printf("%-20s%-20s%10d%20s%20s\n", item.getOwner().getName(), item.getVehicle().getModel(),
						item.getVehicle().getCapacity(), item.getVehicle().getCost(), VehicleUtils.export(item));
			}
			break;
		}
		case 3: {
			return;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + number);
		}
	}
}
