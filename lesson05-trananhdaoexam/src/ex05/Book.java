package ex05;

public class Book {
	private String id;
	private double cost;
	private String publisher;
	public Book() {
		
	}
	public Book(String id, double cost, String publisher) {
		this.id = id;
		this.cost = cost;
		this.publisher = publisher;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", cost=" + cost + ", publisher=" + publisher + "]";
	}
	
}
