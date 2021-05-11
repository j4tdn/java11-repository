package exercise;

public class Vehicle {
	private String owner;
	private String nameVehicle;
	private double cost;
	private double xilanh;
	private double tax;

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String owner, String nameVehicle, double xilanh, double cost) {
		super();
		this.owner = owner;
		this.nameVehicle = nameVehicle;
		this.cost = cost;
		this.xilanh = xilanh;
		this.tax = Tax();
	}

	private double Tax() {

		if (xilanh < 100) {
			return 0.01 * cost;
		} else if (xilanh < 200) {
			return 0.03 * cost;
		} else
			return 0.05 * cost;

	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

	public String getnameVehicle() {
		return nameVehicle;
	}

	public void setnameVehicle(String nameVehicle) {
		this.nameVehicle = nameVehicle;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getXilanh() {
		return xilanh;
	}

	public void setXilanh(double xilanh) {
		this.xilanh = xilanh;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return String.format("%-25s %-25s %10s %25.2f %25.2f", owner, nameVehicle, xilanh, cost, tax);
	}

}
