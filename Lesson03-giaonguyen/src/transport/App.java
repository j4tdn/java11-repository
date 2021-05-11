package transport;

public class App {
	public static void main(String[] args) {
		
		User u1 = new User("Nguyễn Thu Loan", "123");
		User u2 = new User("Lê Minh Tính", "456");
		User u3 = new User("Nguyễn Minh Triết", "789");
		
		Manager m1 = new Manager(u1, new Vehicle());
		Manager m2 = new Manager(u2, new Vehicle());
		Manager m3 = new Manager(u3, new Vehicle());
		
		// Input info of Vehicles
		VehicleUtils.inputInfovehicle(m1);
		VehicleUtils.inputInfovehicle(m2);
		VehicleUtils.inputInfovehicle(m3);
		
		// Export table of registration tax
		System.out.printf("\n%-20s%-20s%10s%20s%20s\n", "Vehicle owner", "Model", "Capacity", "Cost", "Registration tax");
		System.out.println("==========================================================================================");
		System.out.printf("%-20s%-20s%10d%20s%20s\n", m1.getUser().getName(), m1.getVehicle().getModel(), m1.getVehicle().getCapacity(),
				m1.getVehicle().getCost(), VehicleUtils.exportRegistrationTax(m1));
		System.out.printf("%-20s%-20s%10d%20s%20s\n", m2.getUser().getName(), m2.getVehicle().getModel(), m2.getVehicle().getCapacity(),
				m2.getVehicle().getCost(), VehicleUtils.exportRegistrationTax(m2));
		System.out.printf("%-20s%-20s%10d%20s%20s\n", m3.getUser().getName(), m3.getVehicle().getModel(), m3.getVehicle().getCapacity(),
				m3.getVehicle().getCost(), VehicleUtils.exportRegistrationTax(m3));
		
	}
}
