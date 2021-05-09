package transport;

public class Vehicle {
	private String model;
	private String color;
	private double cost;
	private int capacity;
	
	public Vehicle() {

	}

	public Vehicle(String model, String color, double cost, int capacity) {
		this.model = model;
		this.color = color;
		this.cost = cost;
		this.capacity = capacity;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Vehicle [model=" + model + ", color=" + color + ", cost=" + cost + ", capacity=" + capacity + "]";
	}
	

}
