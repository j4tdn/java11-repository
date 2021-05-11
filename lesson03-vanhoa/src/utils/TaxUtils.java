package utils;

import bean.Vehicle;

public class TaxUtils {
	public static double exportTax(Vehicle vehicle) {
		double totalTax = 0.00d;

		if (vehicle.getEngine() < 100) {
			totalTax = vehicle.getCost() * 0.01;
		} else if (vehicle.getEngine() <= 200) {
			totalTax = vehicle.getCost() * 0.03;
		} else {
			totalTax = vehicle.getCost() * 0.05;
		}

		return totalTax;
	}

}
