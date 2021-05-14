package ex02;

public class Vehicle {
	public Vehicle(String type, int capacity, long price) {
		super();
		this.type = type;
		this.capacity = capacity;
		this.price = price;
	}

	private String type;
	private int capacity;
	private long price;

	public Vehicle() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return this.getType() + "\t\t" + this.getCapacity() + "\t\t\t" + this.getPrice() + "\t";
	}

}
