package baitap2;

public class Vehicle {
	private String model;
	private String color;
	private  double capacity;
	private double cost;

	public Vehicle() {

	}

	public Vehicle(String model, String color, double capacity, double cost) {

		this.model = model;
		this.color = color;
		this.capacity = capacity;
		this.cost = cost;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "vehicle [model=" + model + ", color=" + color + ", capacity=" + capacity + ", cost=" + cost + "]";
	}

}
