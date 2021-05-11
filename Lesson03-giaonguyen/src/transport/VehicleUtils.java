package transport;

import java.util.Scanner;

public class VehicleUtils {

	static int count = 0;

	public static void inputInfovehicle(Manager manager) {

		Scanner scanner = new Scanner(System.in);
		String _model; 
		String _color ;
		double _cost = 0 ;
		int _capacity = 0 ;

		System.out.println("============");
		System.out.println("Please enter info of Vehicle " +  (++count) + ":");

		System.out.println("Model:");
		_model = scanner.nextLine();
		manager.getVehicle().setModel(_model);

		System.out.println("Color:");
		_color = scanner.nextLine();
		manager.getVehicle().setColor(_color);

		System.out.println("Cost:");
		_cost = scanner.nextDouble();
		manager.getVehicle().setCost(_cost);

		System.out.println("Capacity:");
		_capacity = scanner.nextInt();
		manager.getVehicle().setCapacity(_capacity);

	}

	public static double exportRegistrationTax(Manager manager) {

		double totalTax = 0.0d;

		if (manager.getVehicle().getCapacity() < 100) {
			totalTax += manager.getVehicle().getCost()*0.01;
		}
		else if (manager.getVehicle().getCapacity() >= 100 && manager.getVehicle().getCapacity() <= 200) {
			totalTax += manager.getVehicle().getCost()*0.03;
		}
		else totalTax += manager.getVehicle().getCost()*0.05;

		return totalTax;
	}
}
