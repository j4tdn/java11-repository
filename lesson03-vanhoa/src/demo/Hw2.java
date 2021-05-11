package demo;

import bean.Vehicle;
import utils.TaxUtils;

public class Hw2 {
	public static void main(String[] args) {
		Vehicle x1 = new Vehicle("Nguyen Thu Loan", "Future Neo", "98473", "Red", 100, 35000000);
		Vehicle x2 = new Vehicle("Le Minh Tinh", "Ford Ranger", "79385", "Black", 3000, 250000000);
		Vehicle x3 = new Vehicle("Nguyen Minh Triet", "Landscape", "93539", "White", 1500, 1000000000);

//		System.out.println(TaxUtils.exportTax(x3));

		System.out.printf("\n%-25s%-20s%10s%20s%20s\n", "Vehicle Owner", "Model", "Engine Displacement", "Cost", "Tax");
		System.out.println(
				"===========================================================================================================");
		System.out.printf("%-25s%-20s%19d%20s%20s\n", x1.getOwner(),x1.getModel(),x1.getEngine(),x1.getCost(),TaxUtils.exportTax(x1));
		System.out.printf("%-25s%-20s%19d%20s%20s\n", x2.getOwner(),x2.getModel(),x2.getEngine(),x2.getCost(),TaxUtils.exportTax(x2));
		System.out.printf("%-25s%-20s%19d%20s%20s\n", x3.getOwner(),x3.getModel(),x3.getEngine(),x3.getCost(),TaxUtils.exportTax(x3));
	}

}
