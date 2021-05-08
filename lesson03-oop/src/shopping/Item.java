package shopping;

public class Item {
	private String item;
	private String os;
	private String color;
	private double cost;
	
	public Item() {
	}
	

	public Item(String item, String os, String color, double cost) {
		super();
		this.item = item;
		this.os = os;
		this.color = color;
		this.cost = cost;
	}


	public String getId() {
		return item;
	}

	public void setId(String item) {
		this.item = item;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
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

	@Override
	public String toString() {
		return "Item [id=" + item + ", os=" + os + ", color=" + color + ", cost=" + cost + "]";
	}
	
	

}
