package ex02;


public class Utilis {
	public Utilis() {
		// TODO Auto-generated constructor stub
	}
	
	public static double tax(Vehicle vehicle) {
		double tax = 0;
		long price = vehicle.getPrice();
		int cc = vehicle.getCapacity();
		
		if(cc < 100) {
			tax = price*0.01;
		}
		else if (cc >100 && cc <200) {
			tax = price*0.03;
		}
		else {
			tax = price*0.05;
		}
		return tax;
	}
	
	
}
