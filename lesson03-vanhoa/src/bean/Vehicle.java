package bean;

public class Vehicle {
	private String owner;
	private String model;
	private String serial;
	private String color;
	private int engine;
	private double cost;
	
	public Vehicle() {
	}

	public Vehicle(String owner, String model, String serial, String color, int engine, double cost) {
		this.owner = owner;
		this.model = model;
		this.serial = serial;
		this.color = color;
		this.engine = engine;
		this.cost = cost;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEngine() {
		return engine;
	}

	public void setEngine(int engine) {
		this.engine = engine;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Vehicle [owner=" + owner + ", model=" + model + ", serial=" + serial + ", color=" + color + ", engine="
				+ engine + ", cost=" + cost + "]";
	}
	
	

}
