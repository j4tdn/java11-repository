package ex02;

public class Vehicle {
	private String name;
	private int capacity;
	private long price;
	
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String name, long price, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.price = price;
		
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

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return  name + "\t\t" + capacity+ "\t\t" + price +"\t" ;
	}
	

	
}
