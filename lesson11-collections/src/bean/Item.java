package bean;

import java.util.Objects;

public class Item {
	private int id;
	private double price;
	private String name;
	private int Stond;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int id, double price, String name, int stond) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		Stond = stond;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStond() {
		return Stond;
	}

	public void setStond(int stond) {
		Stond = stond;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", price=" + price + ", name=" + name + ", Stond=" + Stond + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Item))
			return false;
		Item that = (Item) o;
		return getStond() == that.getStond() && getId() == that.getId();

	}

	@Override
	public int hashCode() {

		return Objects.hash(Stond, id);
	}

}
