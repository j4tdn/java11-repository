package Ex02_Tax;

public class Vehicle {
	private String type;
	private int cylinder;
	private double cost;
	
	public Vehicle() {
	}

	
	public Vehicle(String type, int cylinder, double cost) {
		this.type = type;
		this.cylinder = cylinder;
		this.cost = cost;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getCylinder() {
		return cylinder;
	}

	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}


	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", cylinder=" + cylinder + ", cost=" + cost + "]";
	}

	

	
}
