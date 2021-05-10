package exercise02;

import java.util.Scanner;

public class VehicleUtils {
	static int count = 0;

	public static Vehicle inputVehicle() {
		Scanner scanner = new Scanner(System.in);
		String model;
		String color;
		double cost = 0;
		int capacity = 0;

		System.out.println("=======================");
		System.out.println("Please enter info of Vehicle " + (++count) + ":");

		System.out.println("Model:");
		model = scanner.nextLine();

		System.out.println("Color:");
		color = scanner.nextLine();

		System.out.println("Cost:");
		cost = scanner.nextDouble();

		System.out.println("Capacity:");
		capacity = scanner.nextInt();

		Vehicle vehicle = new Vehicle(model, color, cost, capacity);
		return vehicle;
	}

	public static double export(Manager manager) {

		double tax = 0.0d;

		if (manager.getVehicle().getCapacity() < 100) {
			tax += manager.getVehicle().getCost() * 0.01;
		} else if (manager.getVehicle().getCapacity() >= 100 && manager.getVehicle().getCapacity() <= 200) {
			tax += manager.getVehicle().getCost() * 0.03;
		} else
			tax += manager.getVehicle().getCost() * 0.05;

		return tax;
	}
}
