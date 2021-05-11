package bai2;

public class Vehicle {
	private int id;
	private String model;
	private int capacity;
	private double cost;
	
	public Vehicle() {
	}

	public Vehicle(int id, String model, int capacity, double cost) {
		super();
		this.id = id;
		this.model = model;
		this.capacity = capacity;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
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
		return "Vehicle [id=" + id + ", model=" + model + ", capacity=" + capacity + ", cost=" + cost + "]";
	}
	
	
}
