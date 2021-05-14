package ex02_vehicle;

public class Vehicle {
	//Vehicle: id, name, capacity, price, tax
	private String id;
	private String name ;
	private int capacity;
	private float price;
	private float tax;

	public Vehicle() {
	}

	public Vehicle(String id, String name, int capacity, float price, float tax) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.price = price;
		this.tax = tax;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", capacity=" + capacity + ", price=" + price + ", tax=" + tax
				+ "]";
	}
	
}
