package bean;


public class Item {
	private int id;

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

	private String name;
	private double price;
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	@Override
	public boolean equals(Object o) {
		if(this==o)
		{
			return true;
		}
		if(!(o instanceof Item))
		{
			return false;
		}
		Item that = (Item)o;
		return that.getId()==getId();
		
	}
}
