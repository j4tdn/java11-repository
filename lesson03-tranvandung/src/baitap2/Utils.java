package baitap2;

import java.util.Scanner;

public class Utils {

	static int count = 0;

	public static Vehicle input() {
		Scanner ip = new Scanner(System.in);
		String model;
		String color;
		double capacity = 0d;
		double cost = 0;

		System.out.println(" ============================== ");
		System.out.println(" Moi nhap thong tin phuong tien:" + (++count));

		System.out.println("Model: ");
		model = ip.nextLine();

		System.out.println("Color: ");
		color = ip.nextLine();

		System.out.println("Capacity: ");
		capacity = ip.nextDouble();

		System.out.println("Cost: ");
		cost = ip.nextDouble();

		Vehicle vehicle = new Vehicle(model, color, capacity, cost);
		return vehicle;
	}

	public static double export(Taxstaff taxstaff) {

		double tax = 0.0d;

		if (taxstaff.getVehicle().getCapacity() < 100) {
			tax += taxstaff.getVehicle().getCost() * 0.01;
		} else if (taxstaff.getVehicle().getCapacity() >= 100 && taxstaff.getVehicle().getCapacity() <= 200) {
			tax += taxstaff.getVehicle().getCost() * 0.03;
		} else
			tax += taxstaff.getVehicle().getCost() * 0.05;

		return tax;
	}
}
