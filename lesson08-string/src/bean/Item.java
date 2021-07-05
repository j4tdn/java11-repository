package bean;

import jdk.swing.interop.SwingInterOpUtils;

public class Item {
	private int id;
	private String name;
	private double price;
	
	public Item() {
	}

	public Item(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	// Collection, Hash table
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if(!(o instanceof Item)) {
			return false;
		}
		
		Item that = (Item) o;
		return that.getId() == getId();
	}
}
