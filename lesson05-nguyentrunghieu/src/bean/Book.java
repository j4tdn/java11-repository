package bean;

public class Book {
	private String id;
	private int cost;
	private String producer;

	public Book() {
	}

	public Book(String id, int cost, String producer) {
		this.id = id;
		this.cost = cost;
		this.producer = producer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}
}
